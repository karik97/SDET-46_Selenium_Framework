package BaseClassPractice;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

import Annotation.ExtentReport;
import Enum.Enum_data;
import generic_utilities.Excel_utils;
import generic_utilities.Framework_data;
import generic_utilities.Java_utils;
import generic_utilities.Javascript_utils;
import generic_utilities.Property_util;
import generic_utilities.Verification_utills;
import generic_utilities.Wait_utility;
import generic_utilities.Webdriver_utility;

public class BaseClassPractice implements Framework_data{

	public  WebDriver driver;

	//object creation
	public  Webdriver_utility web_util;
	protected  Property_util prop;
	protected  Verification_utills verify;
	public Java_utils java_util;
	protected  Javascript_utils jsu;
	protected  Wait_utility wait;
	protected  Excel_utils excel;
	protected  SoftAssert soft;
	
	@ExtentReport(author = "karti")
	@Parameters("browser")
	@BeforeClass(alwaysRun = true)
	public void classsetup(@Optional String browser)
	{
		prop=new Property_util(FISPATH);
		web_util=new Webdriver_utility();
		excel=new Excel_utils(prop.readData(Enum_data.EXCEL_PATH));
		if(browser==null)
		{
			driver=web_util.openBrowser(prop.readData(Enum_data.BROWSER));
		}	
		else
		{
			//driver=web_util.openBrowser(browser);
			driver=web_util.openBrowser(System.getProperty("browser"));//for maven execution 
		}

       verify=new Verification_utills();
		java_util=new Java_utils();
		
		soft=new SoftAssert();
	}

	@BeforeMethod(alwaysRun = true)
	public void methodSetup()
	{
		web_util.openApp(System.getProperty("url"),driver);
	}

	@AfterMethod(alwaysRun = true)
	public void methodteardown()
	{
		web_util.navigateBack(driver);
	}

	
	@AfterClass(alwaysRun = true)
	public void testTeardown()
	{
		excel.close();
		prop.readClose();
		web_util.closeTab(driver);
	}
}
 