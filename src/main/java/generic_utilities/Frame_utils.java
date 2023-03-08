package generic_utilities;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * 
 * @author Kartik
 *
 */
public class Frame_utils {
	/**
	 * this method is use to switch between frame throught address
	 * @param element
	 */
	public void switchToFrame(WebElement element,WebDriver Driver)
	{
		Driver.switchTo().frame(element);
	}
	/**
	 * this method is use to switch between frame throught string
	 * @param attribute_value
	 * @param Driver
	 */
	public void switchToFrame(String ID_Name,WebDriver Driver)
	{
		Driver.switchTo().frame(ID_Name);
	}
	/**
	 * this method is use to switch from frame to main page
	 * @param Driver
	 */
	public void switchto_defaultContent(WebDriver Driver)
	{
		Driver.switchTo().defaultContent();
	}
	/**
	 * this method is use to switch to parent frame
	 * @param Driver
	 */
	public void switchto_parentFrame(WebDriver Driver)
	{
		Driver.switchTo().parentFrame();
	}
	/**
	 * this method is use to switch any window based on title
	 * @param driver
	 * @param partialWindowTitle
	 */
	public void switchToWindow(WebDriver driver,String partialWindowTitle) {
		Set<String> ids=driver.getWindowHandles();
		Iterator<String> it = ids.iterator();
		
		while(it.hasNext())
		{
			String WID = it.next();
            driver.switchTo().window(WID);
            String currentPageTitle = driver.getTitle();
            if(currentPageTitle.contains(partialWindowTitle))
            {
            	break;
            }           
		}
		
	}
}


