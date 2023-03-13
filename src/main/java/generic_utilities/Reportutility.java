package generic_utilities;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
/**
 * 
 * @author Kartik
 *
 */
public class Reportutility {
	private ExtentReports report;
	/**
	 * this method is used to modify the report template attach the report
	 * @param filepath
	 * @param documentTitle
	 * @param reportName
	 * @param browserName
	 */
	public Reportutility(String filepath,String documentTitle,String reportName,String browserName)
	{

		ExtentSparkReporter sparkextent = new ExtentSparkReporter(filepath);
		sparkextent.config().setDocumentTitle(documentTitle);
		sparkextent.config().setReportName(reportName);
		sparkextent.config().setTheme(Theme.DARK);

		report = new ExtentReports();
		report.attachReporter(sparkextent);
		report.setSystemInfo("browser", browserName);
		report.setSystemInfo("os", System.getProperty("os.name"));
	}
	/**
	 * its used to start logging
	 * @param testName
	 */
	public void createTest(String testName)
	{
		ExtentTest	test=report.createTest(testName);
		UtilityInstanaceTransefer.setExtent(test);
	}
	/**
	 * this method is used for logg falied report
	 * @param message
	 */
	public void fail(String message,ExtentTest test)
	{
		test.fail(message);
		System.out.println(message);
	}
	/**
	 * this method is used for assign author name
	 * @param string 
	 * @param message
	 */
	public void addAuthor(String[] name, ExtentTest test)
	{
		test.assignAuthor(name);
		System.out.println(name);
	}
	/**
	 * this method is used for assign category
	 * @param message
	 */
	public void addCategory(String[] category,ExtentTest test)
	{
		test.assignCategory(category);
		System.out.println(category);
	}
	/**
	 * this method is used for logg exception
	 * @param errormsg
	 */
	public void fail(Throwable errormsg,ExtentTest test)//method overloading
	{
		test.fail(errormsg);
		System.out.println(errormsg);
	}
	/**
	 * this method is used for logg skip msg
	 * @param msg
	 */
	public void skip(String msg,ExtentTest test)
	{
		test.skip(msg);
		System.out.println(msg);
	}
	/**
	 * this method is used for logg skip exception errormsg
	 * @param errormsg
	 */
	public void skip(Throwable errormsg,ExtentTest test)
	{
		test.skip(errormsg);
		System.out.println(errormsg);
	}
	/**
	 * this method is used for logg warn exception errormsg
	 * @param msg
	 */
	public void warn(String msg,ExtentTest test)
	{
		test.warning(msg);
		System.out.println(msg);
	}
	/**
	 * this method is used for logg warn exception errormsg
	 * @param errormsg
	 */
	public void warn(Throwable errormsg,ExtentTest test)
	{
		test.warning(errormsg);
		System.out.println(errormsg);
	}
	/**
	 * this method is used for logg information
	 * @param info
	 */
	public void info(String info,ExtentTest test)
	{
		test.info(info);
		System.out.println(info);
	}
	/**
	 * this method is used to attachscreen shot to the extent report
	 * @param statergy
	 * @param scrrenshotpath
	 * @param title
	 */
	public void attachScreenshot(String statergy,String scrrenshotpath,String title,ExtentTest test)
	{
		if(statergy.equalsIgnoreCase("alt"))
		{
			test.addScreenCaptureFromBase64String(scrrenshotpath, title);
		}
		else
		{
			test.addScreenCaptureFromPath(scrrenshotpath, title);
		}
	}
	/**
	 * this method is used to save the extent report
	 */
	public void saveReport(String extentpath)
	{
		report.flush();
		try {
			Desktop.getDesktop().browse(new File(extentpath).toURI());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * this method is used to logg report for passed test script
	 * @param msg
	 */
	public void pass(String msg,ExtentTest test)
	{
		test.pass(msg);
		System.out.println(msg);
	}
}
