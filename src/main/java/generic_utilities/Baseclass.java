package generic_utilities;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;
import Enum.Enum_data;
import SM_BB_POM.SM_element;

public class Baseclass implements Framework_data
{
	//driver
	protected static WebDriver driver;

	//object creation
	protected  Webdriver_utility web_util;
	protected  Property_util prop;
	protected  Java_utils java_util;
	protected  Javascript_utils jsu;
	protected  Wait_utility wait;
	protected  Excel_utils excel;
	protected  SoftAssert soft;
	public Reportutility report;

	//common data
	protected  String pagetype;
	protected  String elementtype;

	protected  String welcomepage;
	protected  String loginpage;
	protected  String homepage;
	protected  String elemntname;

	protected  String ewpt;
	protected  String elpt;
	protected  String ehpt;

	@BeforeClass(alwaysRun = true)
	public void testSetup()
	{
		report=Extentreportlistner.sreport;

		//object creation
		web_util=new Webdriver_utility();
		prop=new Property_util(FISPATH);
		excel=new Excel_utils(prop.readData(Enum_data.EXCEL_PATH));
		java_util=new Java_utils();
		soft=new SoftAssert();

		//driver
		driver=web_util.openBrowser(prop.readData(Enum_data.BROWSER));
		web_util.maximize(driver);

		jsu=new Javascript_utils(driver);
		wait=new Wait_utility(driver);	
		sme=new SM_element(driver);

		//common data
		welcomepage = prop.readData(Enum_data.WELCOMEPAGE);
		loginpage=prop.readData(Enum_data.LOGINPAGE);
		homepage = prop.readData(Enum_data.HOMEPAGE);
		elemntname=prop.readData(Enum_data.ELEMENTNAME);

		pagetype=prop.readData(Enum_data.PAGETYPE);
		elementtype=prop.readData(Enum_data.ELEMENTTYPE);

		ewpt= prop.readData(Enum_data.WPTITLE);
		elpt= prop.readData(Enum_data.LPTITLE);
		ehpt=prop.readData(Enum_data.HPTITLE);

	}

	protected String url;
	protected String email;
	protected String pwd; 
	protected SM_element sme;
	@BeforeMethod(alwaysRun = true)
	public void methodSetup()
	{

		//credential
		url = prop.readData(Enum_data.URL);
		email =java_util.decoder(prop.readData(Enum_data.E));  
		pwd = java_util.decoder(prop.readData(Enum_data.P));

		web_util.openApp(url,driver);
		String awelt = web_util.title(driver);

		soft.assertTrue(awelt.equalsIgnoreCase(ewpt), "welcome page is not displayed");

		sme.sign();

		String alogt=web_util.title(driver);//

		soft.assertTrue(alogt.equalsIgnoreCase(elpt),"login page is not displayed");

		sme.untextfield().sendKeys(email);
		sme.pwdtextfirled().sendKeys(pwd);

		sme.loginbutton();

		//login.loginUser(excel.fetchxpath(prop.readData(Enum_data.LOGINSHEET)));

		String ahpt=web_util.title(driver);	
		soft.assertTrue(ahpt.equalsIgnoreCase(ehpt),"home page is not displayed");
	}


	@AfterMethod(alwaysRun = true)
	public void methodTeardown()
	{	
		//sme.logout();
		soft.assertAll();
	}

	@AfterClass(alwaysRun = true)
	public void testTeardown()
	{
		excel.close();
		prop.readClose();
		wait.Pause(5000);
		//web_util.closeTab(driver);
	}
}
