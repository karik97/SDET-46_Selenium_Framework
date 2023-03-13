package SM_BB_POM;

import java.util.Map;
import java.util.Map.Entry;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Enum.Enum_data;
import Enum.SME;
import generic_utilities.Baseclass;
/**
 * 
 * @author Kartik
 *
 */
public class LoginPage extends Baseclass {

	private String pxpath="//input[@name='%s']";
	private WebElement convertElement(String replace)
	{
		String xpath = String.format(pxpath, replace);
		return driver.findElement(By.xpath(xpath));
	}	

	private WebDriver driver;
	//intialization

	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public void loginUser(Map<String, String> key)
	{
		for(Entry<String, String> keyvalue:key.entrySet())
		{
			convertElement(keyvalue.getKey()).sendKeys(keyvalue.getValue());
			convertElement(keyvalue.getKey()).sendKeys(keyvalue.getValue());
			convertElement(keyvalue.getKey()).click();	
			
		}
	}

	public void logOut(SME key)
	{
		convertElement(key.get()).click();
	}
}
