package Home;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import Annotation.ExtentReport;
import Enum.Enum_data;
import generic_utilities.Baseclass;
import generic_utilities.UtilityInstanaceTransefer;
/**
 * abc
 * @author Kartik
 *
 */
public class SM_BBTest extends Baseclass
{
	private String photodescitpion;
	private String photopath;

	@ExtentReport(author = "karti")
	@Test(groups = {"regression","major"})
	public void upload_phototest() {
		System.out.println(Thread.currentThread().getId());
		report.info("home page is displayed", UtilityInstanaceTransefer.getExtent());

		String e1 =java_util.decoder(prop.readData(Enum_data.E1)); 
		report.info("user b email fetched properly", UtilityInstanaceTransefer.getExtent());

		//common data
		int random = java_util.random(20);
		photodescitpion = prop.readData(Enum_data.PHOTODESCRIPTION)+"_"+random;
		photopath = prop.readData(Enum_data.PHOTOPATH);

		report.info("data fetched properly", UtilityInstanaceTransefer.getExtent());

		sme.choosefilebtn().sendKeys(photopath);
		sme.descriptionareaField().sendKeys(photodescitpion);
		sme.shareBtn();

		report.info("user uploaded the photo successfully", UtilityInstanaceTransefer.getExtent());

		sme.logout();
		report.info("user logged out successfully", UtilityInstanaceTransefer.getExtent());

		String alogt=web_util.title(driver);
		soft.assertTrue(alogt.equalsIgnoreCase(elpt),"login page is not displayed");
		report.info("login page displayed successfully", UtilityInstanaceTransefer.getExtent());

		sme.sign();		

		sme.untextfield().sendKeys(e1);
		sme.pwdtextfirled().sendKeys(pwd);
		sme.loginbutton();

		report.info("user log in page successfully", UtilityInstanaceTransefer.getExtent());

		List<WebElement> txts = sme.uploadedphotoTxt();
		for(WebElement txt:txts)
		{
			String tx = txt.getText();
			if(tx.contains(photodescitpion))
			{
				Assert.assertEquals(tx, photodescitpion);

			}
		}
		soft.assertTrue(web_util.title(driver).equalsIgnoreCase(ehpt),"home page is not displayed");
		report.info("home page successfully", UtilityInstanaceTransefer.getExtent());
	}

	/**
	 * this method is used to delete the photo we need to call this method in main m ethod in order to execute 
	 */
	@ExtentReport(author = "raksh")
	//@Test
	public void delete_phototest() 
	{	
		System.out.println(Thread.currentThread().getId());
		//report.info("home page is displayed", UtilityInstanaceTransefer.getExtent());

		List<WebElement> txts = sme.uploadedphotoTxt();
		List<WebElement> btns = sme.dltbtn();
		for(WebElement txt:txts)
		{
			String tx = txt.getText();
			if(tx.contains(prop.readData(Enum_data.PHOTODESCRIPTION)))
			{
				for(WebElement btn:btns) {
					jsu.scrollIntoView(txt);
					wait.Pause(2000);
					btn.click();
					jsu.generateAlert("photo deleted successfullly");
					wait.Pause(2000);
					
				//	report.info("user deleted the photo successfully", UtilityInstanaceTransefer.getExtent());
					try
					{
						Assert.assertEquals(tx, prop.readData(Enum_data.PHOTODESCRIPTION));
					}
					catch (Exception e) 
					{
						System.out.println("test case pass");
					}
				}
			}
		}
	}
}

