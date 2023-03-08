package generic_utilities;

import java.util.Set;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * 
 * @author Kartik
 *
 */
public class Popup_utils {
	private Alert alt;
	private WebDriver driver;
	/**
	 * @param driver
	 */
	Popup_utils(WebDriver driver)
	{
		this.driver=driver;
		alt = driver.switchTo().alert();
	}
	/**
	 * this method is used to accept pop up
	 */
	public void accept()
	{
		alt.accept();
	}
	/**
	 * this method is used to dismiss from pop up
	 */
	public void dismiss()
	{
		alt.dismiss();
	}
	/**
	 *this method is used to send path of the photo & while file upload 
	 * @param data
	 */
	public void sendKeys(String data)
	{
		alt.sendKeys(data);
	}
	/**
	 *this method is used to get the text from the popup
	 * @param text
	 * @return 
	 */
	public String getText()
	{
		return alt.getText();
	}
/**
 * this method is used to switch to one window to another window
 * @param driver
 * @param type
 * @param expt
 * @param expurl
 */
	public void switchToWindow(String type,String expt,String expurl)
	{
		Set<String> ids = driver.getWindowHandles();
		for(String id:ids)
		{
			driver.switchTo().window(id);
			if(type.equalsIgnoreCase("title"))
			{
				if(driver.getTitle().equalsIgnoreCase(expt))
				{
					break;
				}
			}
			else if(type.equalsIgnoreCase("url"))
			{
				if(driver.getCurrentUrl().equalsIgnoreCase(expurl))
				{
					break;
				}
			}
		}
	}
	
	public String getText(WebElement e)
	{
		String text=null;
		Set<String> ids = driver.getWindowHandles();
		for(String id:ids)
		{
			driver.switchTo().window(id);
			text=e.getText();
			break;
		}
		return text;
	}
}
