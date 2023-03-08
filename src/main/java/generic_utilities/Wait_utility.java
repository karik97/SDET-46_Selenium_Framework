package generic_utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
/**
 * 
 * @author Kartik
 *
 */
public class Wait_utility
{
	/**@throws InterruptedException
	 * this method is use to pause the execution
	 * @param millisec
	 */
   public void Pause(long millisec)
   {
	   try {
		Thread.sleep(millisec);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
   }
   WebDriverWait w;
   WebDriver driver;
   /**
    * this constructor is `use to intialization
    * @param driver
    * @param sec
    */
   
   public Wait_utility(WebDriver driver)
   {
	   this.driver=driver;
	   w=new WebDriverWait(driver, 5);
   }
   /**
    * this method is use to visiblity of element to perform action
    * @param sec
    * @param element
    */
   public void excplicitWait(WebElement element)
   {
	   w.until(ExpectedConditions.visibilityOf(element));
   }
   /**
    * this method is use to element is enabled 
    * @param element
    */
   public void elementtobeClickable(WebElement element)
   {
	   w.until(ExpectedConditions.elementToBeClickable(element));
   }
   /**
    *this method is use to check the invisbility of element 
    * @param element
    */
   public void invisiblityOf(WebElement element)
   {
	   w.until(ExpectedConditions.invisibilityOf(element));
   }
   /**
    * this method is use wait for the element address to perform action 
    * @param driver
    * @param timeout
    */
   public void implicitWait(long timeout)
   {
      driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
   }
}
