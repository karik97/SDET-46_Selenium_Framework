package generic_utilities;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import Annotation.ExtentReport;
import BaseClassPractice.BaseClassPractice;
import Enum.Enum_data;

public class Extentreportlistner implements ITestListener ,ISuiteListener,Framework_data{
	/**
	 * this method is used to intialize the report utility
	 */
	private Reportutility report;
	protected String extentpath;
	public static  Reportutility sreport;//run time polymrphism,method overiding
	@Override
	public void onStart(ISuite suite) {
		Property_util prop = new Property_util(FISPATH);	
		String override = prop.readData(Enum_data.OVERRIDEREPORT);
		String randomName=null;
		if(override.equalsIgnoreCase("no"))
		{
			randomName = "_"+new Java_utils().getsimpleDate();
		}

		extentpath = EXTENTPATH+suite.getClass().getPackage()+randomName+" .html";
		report = new Reportutility(extentpath, prop.readData(Enum_data.EXTENTREPORTTITLE), 
				prop.readData(Enum_data.EXTENTREPORTNAME), prop.readData(Enum_data.BROWSER));
		sreport=report;
	}
	/**
	 *  this method is used to save the report
	 */
	@Override
	public void onFinish(ISuite suite) {
		report.saveReport(extentpath);
		System.out.println("onfinish----suite");
	}
	/**
	 *  
	 */
	@Override
	public void onStart(ITestContext context){//
		System.out.println("onStart----test");
	}
	/**
	 * 
	 */
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("onTestFailedButWithinSuccessPercentage");
	}
	/**
	 *  this method is used to intialize the intialize the author & category by using the annotation,  create a test inside the report
	 */
	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("onTestStart");
		report.createTest(result.getMethod().getMethodName());
		ExtentReport annotaion = result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(ExtentReport.class);
		System.out.println(annotaion.author()+" "+annotaion.category());
		report.addAuthor(annotaion.author(), UtilityInstanaceTransefer.getExtent());
		report.addCategory(annotaion.category(), UtilityInstanaceTransefer.getExtent());
	}
	/**
	 * 
	 */
	@Override
	public void onFinish(ITestContext context) {
		System.out.println("onfinish---Test");
	}
/**
 * this method is used to print which test annotation is passed
 */
	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("onTestSuccess");
		report.pass(result.getMethod().getMethodName()+" pass",UtilityInstanaceTransefer.getExtent());
	}
/**
 * this method is used to print which get the screenshot of failed method & highlight the method  
 */
	@Override
	public void onTestFailure(ITestResult result) {
		report.fail(result.getMethod().getMethodName(),UtilityInstanaceTransefer.getExtent());
		report.fail(result.getThrowable(),UtilityInstanaceTransefer.getExtent());

		System.out.println("<b>"+result.getMethod().getMethodName()+"</b>"+" is failed");


		report.attachScreenshot("base64",
				BaseClassPractice.class.cast(result.getInstance()).web_util.genericScreenshot(),
				result.getMethod().getMethodName(),UtilityInstanaceTransefer.getExtent());
	}
/**
 * this method is used to print which get the screenshot of skipped method & highlight the method
 */
	@Override
	public void onTestSkipped(ITestResult result) {
		report.skip(result.getMethod().getMethodName(),UtilityInstanaceTransefer.getExtent());
		report.skip(result.getThrowable(),UtilityInstanaceTransefer.getExtent());

		report.attachScreenshot("alt",
				BaseClassPractice.class.cast(result.getInstance()).web_util.genericScreenshot(),
				result.getMethod().getMethodName()+" skipped",UtilityInstanaceTransefer.getExtent());
	}
}
