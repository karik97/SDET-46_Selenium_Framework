package Profile;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Annotation.ExtentReport;
import Enum.Enum_data;
import generic_utilities.Baseclass;
import generic_utilities.Extentreportlistner;
import generic_utilities.UtilityInstanaceTransefer;
/**
 * 
 * @author Kartik
 *
 */

public class SM_BBTest  extends Baseclass
{
	
	private String un;
	@ExtentReport(author = "kiran")
	@Test(groups = {"sanity","minor"})
	
	public void profileUpdatetest() //profile update
	{
        
		System.out.println(Thread.currentThread().getId());
		report.info("home page is displayed", UtilityInstanaceTransefer.getExtent());
		
		//username to edit profile
		un = excel.username(prop.readData(Enum_data.PROFILESHEET), prop.readData(Enum_data.ACTCOLOUMN), prop.readData(Enum_data.ACTUSERNAME));
        report.info("user name is fetched succesfully", UtilityInstanaceTransefer.getExtent());
		sme.profilem();
		sme.editprofilebtn();

		soft.assertTrue(web_util.currentUrl(driver).contains("edit_profile"), "edit profile page is not displayed");
		report.info("edit profile page is displayed", UtilityInstanaceTransefer.getExtent());

		sme.unt().clear();
		sme.unt().sendKeys(un);
		sme.savebtn();
		report.info("profile updated suceesfully", UtilityInstanaceTransefer.getExtent());

		soft.assertTrue(web_util.currentUrl(driver).contains("profile"), "profile page is not displayed");
		report.info("profile page is displayed", UtilityInstanaceTransefer.getExtent());

		WebElement aun = sme.untxt();

		if(aun.isDisplayed())
		{
			report.info("actual user name is displayed", UtilityInstanaceTransefer.getExtent());
		}
	}
	/**
	 * this method is used to update the profile and verify in home page we need to call this method in main method in order to execute 
	 */
	@ExtentReport(author = "karti")
	@Test(groups = {"regression","major"})
	public void profile_update_hometest()
	{
		System.out.println(Thread.currentThread().getId());
		report.info("home page is displayed", UtilityInstanaceTransefer.getExtent());
		
		sme.profilem();
		
		sme.editprofilebtn();

		soft.assertTrue(web_util.currentUrl(driver).contains("edit_profile"), "edit profile page is not displayed");
		report.info("edit profile page is displayed", UtilityInstanaceTransefer.getExtent());

		sme.unt().clear();
		sme.unt().sendKeys(un);
		sme.savebtn();
		report.info("profile updated suceesfully", UtilityInstanaceTransefer.getExtent());

		sme.homeBtn();

		soft.assertTrue(web_util.title(driver).equalsIgnoreCase(ehpt),"home page is not displayed");
		report.info("home page is displayed", UtilityInstanaceTransefer.getExtent());

		WebElement aun = sme.untxt();

		if(aun.isDisplayed())
		{
			report.info("actual user name is displayed", UtilityInstanaceTransefer.getExtent());
		}
		else {report.info("actual user name is not displayed", UtilityInstanaceTransefer.getExtent());}
	}
}
