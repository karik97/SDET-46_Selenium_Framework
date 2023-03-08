package generic_utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * 
 * @author Kartik
 *
 */
public class Javascript_utils {
	JavascriptExecutor js;
	/**
	 * this constructor is use to type cast from webdriver to javascript executor
	 * @param driver
	 */
	public Javascript_utils(WebDriver driver)
	{
		js=(JavascriptExecutor)driver;
	}
	/**
	 * this method is use to scroll down by passing the bellow para
	 * @param vertical
	 * @param horizental
	 */
	public void scrollDown(int vertical, int horizental)
	{		
		js.executeScript("window.scrollBy("+vertical+","+horizental+")");
	}
	/**
	 * this method is use to scroll up by passing the bellow para(-integer)
	 * @param vertical
	 * @param horizental
	 */
	public void scrollUp(int vertical, int horizental)
	{
		js.executeScript("window.scrollBy("+vertical+","+horizental+")");
	}
	/**
	 * this method is use to scroll to the particular element by passing the bellow para
	 * @param element
	 */
	public void scrollIntoView(WebElement element)
	{
		js.executeScript("arguments[0].scrollIntoView()",element);
	}
	/**
	 * this method is use to enter data into disabled element by passing the bellow para
	 * @param element
	 * @param data
	 */
	public void senddata(WebElement element,String data)
	{
		js.executeScript("arguments[0].value='"+data+"';",element);
	}
	/**
	 * this method is use to perform click action on disabled element by passing the bellow para
	 * @param element
	 */
	public void Click(WebElement element)
	{
		js.executeScript("arguments[0].click();",element);
	}
	/**
	 * this method is use to launch application using java script by passing the  url
	 * @param url
	 */
	public void javascriptlaunchApp(String url)
	{
		js.executeScript("window.location='"+url+"'");
	}
	/**
	 * this method is used to highlight the element by passing element address
	 * @param element
	 */
	public void highlightElement(WebElement element)
	{
		js.executeScript("arguments[0].setAttribute('style','border:6px dotted red;');",element);
	}
	/**
	 * this method is use to get title of the page
	 * @return page title
	 */
	public String getTitle()
	{
		return	js.executeScript("return document.title").toString();
	}
	/**
	 * this method is use to generate alert message at run time at run time on the web page
	 * @param msg
	 */
	public void generateAlert(String msg)
	{
		js.executeScript("alert('"+msg+"')");
	}
	/**
	 * this method is use to refresh the webpage
	 */
	public void refreshByJs()
	{
		js.executeScript("history.go(0)");
	}
	/**
	 * this method is use to get url of the page
	 * @return page title
	 */
	public String getUrl()
	{
		return	js.executeScript("return document.URL;").toString();
	}
	/**
	 * this method is use to get the whole text in the web page
	 * @return page title
	 */
	public String wholetextinWebPage()
	{
		 return js.executeScript("return document.documentElement.innerText").toString();
	}
	/**
	 * this method is use to scroll down by passing the bellow para(-integer)
	 * @param vertical
	 * @param horizental
	 */
	public void scrollUp()
	{		
		js.executeScript("window.scrollBy(0,-document.body.scrollHeight)");
	}
	/**
	 * this method is use to scroll up by pa
	 * ssing the bellow para
	 * @param vertical
	 * @param horizental
	 */ 
	public void scrollDown()
	{
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}
	public void maximimzeWindow()
	{
		js.executeScript("maximizeCurrentWindow");
	}
}

