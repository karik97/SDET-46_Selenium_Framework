package generic_utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
/**
 * 
 * @author Kartik
 *
 */
public class Action_utils 
{
	private Actions act;
	/**
	 * 
	 * @param Driver
	 */
	Action_utils(WebDriver Driver)
	{
		act=new Actions(Driver);
	}
	/**
	 * This methods used to do mouse hoover action
	 * here it needs element address
	 */
	public void movetoElement(WebElement element)
	{		
		act.moveToElement(element).perform();
	}
	
	/**
	 * This methods used to do right click action
	 * here it needs element address
	 */
	public void  contextClick(WebElement element)
	{
		act.contextClick(element).perform();
	}
	/**
	 * This methods used to do double click action
	 * here it needs element address
	 */
	public void  doubleClick(WebElement element)
	{
		act.doubleClick(element).perform();
	}
	
	/**
	 * This methods used to do drag drop action
	 * here it needs element address
	 */
	public void dragDrop(WebElement src,WebElement dst)
	{	  
		act.dragAndDrop(src, dst).perform();
	}
	/**
	 * This methods used to double click on webpage
	 */
	public void doubleClick()
	{
		act.doubleClick().perform();
	}
}
