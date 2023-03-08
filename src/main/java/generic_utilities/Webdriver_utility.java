package generic_utilities;

import java.io.File;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.Locale;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.io.FileHandler;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * 
 * @author Kartik
 *
 */
public class Webdriver_utility {
	WebDriver driver;
	/**
	 * this method is use open the browser by passing the type/name of browser 
	 * @param Browser
	 * @return
	 * String... its a spread operator whenever we pass the data it will take otherwise it will be empty
	 */
	public WebDriver openBrowser(String Browser,String... notification)
	{
		switch(Browser) {
		case  "chrome":
			if(notification.length>=1)
			{
				ChromeOptions opts=new ChromeOptions();
				opts.addArguments("--disable-notifications");
				WebDriverManager.chromedriver().setup();
				driver=new ChromeDriver(opts);
				break;
			}
			else
			{
				WebDriverManager.chromedriver().setup();
				driver=new ChromeDriver();
				break;
			}
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			break;

		case "ie":
			WebDriverManager.iedriver().setup();
			driver=new InternetExplorerDriver();
			break;
		default:
			System.out.println("enter proper key");
			break;
		}
		return driver;

	}
	/**
	 * this method is use open the application by passing the url & driver
	 * @param url
	 */
	public void openApp(String url,WebDriver Driver)
	{
		Driver.get(url);
	}
	/**
	 * this method is use to close the single tab & we need to pass the driver
	 */
	public void closeTab(WebDriver Driver)
	{
		Driver.close();   	
	}
	/**
	 * this method is use to quite from browser & we need to pass the driver
	 */
	public void quiteBrowser(WebDriver Driver)
	{
		Driver.quit();
	}
	/**
	 * this method is use to get the title of the page & we need to pass the driver
	 */
	public String title(WebDriver Driver)
	{
		return Driver.getTitle();
	}
	/**
	 * this method is use to get the current page url & we need to pass the driver
	 */
	public String currentUrl(WebDriver Driver)
	{
		return Driver.getCurrentUrl();
	}
	/**
	 * this method is use to get the current page source code & we need to pass the driver
	 */
	public String  pageSource(WebDriver Driver)
	{
		return Driver.getPageSource();
	}
	/**
	 * this method is use to maximize the browser & we need to pass the driver
	 */
	public void maximize(WebDriver Driver)
	{
		Driver.manage().window().maximize();
	}
	/**
	 * this method is use to navigate back from current page & we need to pass the driver
	 */
	public void navigateBack(WebDriver Driver)
	{
		Driver.navigate().back();
	}
	/**
	 * this method is use to navigate forward from current page & we need to pass the driver
	 */
	public void navigateForward(WebDriver Driver)
	{
		Driver.navigate().forward();
	}
	/**
	 * this method is use to navigate refresh the current page & we need to pass the driver
	 */
	public void refresh(WebDriver Driver)
	{
		Driver.navigate().refresh();
	}
	/**
	 * this method is use to clearing the browsing history & we need to pass the driver
	 */
	public void clearallBrowsingData(WebDriver Driver)
	{
		Driver.manage().deleteAllCookies();
	}
	/**
	 * this method is use to drag the window by passing the height & width & we need to pass the driver
	 * @param x
	 * @param y
	 */
	public void windowDrag(int x,int y,WebDriver Driver)
	{
		Point p = new Point(x, y);
		Driver.manage().window().setPosition(p);
	}
	/**
	 * this method is use to drag the window by passing the height & width & we need to pass the driver
	 * @param width
	 * @param height
	 */
	public void windowResize(int width,int height,WebDriver Driver)
	{
		Dimension d=new Dimension(width, height);
		Driver.manage().window().setSize(d);
	}
	/**
	 * this method is used to get the req month & year
	 * @param currentmonthyear
	 * @param ry
	 * @param rm
	 * @param nxt
	 * @param prev
	 * @param cal
	 */
	public void getreqMonthYear(WebElement currentmonthyear,String ry,String rm,WebElement nxt,WebElement prev,WebElement cal) 
	{
		int reqy = Integer.parseInt(ry);
		int reqmn = DateTimeFormatter.ofPattern("MMM").withLocale(Locale.ENGLISH).parse(rm).get(ChronoField.MONTH_OF_YEAR);

		cal.click();
		String curmonthyear=currentmonthyear.getText();//monthyear
		int currentyear = Integer.parseInt(curmonthyear.split(" ")[1]);
		int curmonthnum = DateTimeFormatter.ofPattern("MMM").withLocale(Locale.ENGLISH).parse(curmonthyear.split(" ")[0].substring(0, 3)).get(ChronoField.MONTH_OF_YEAR);

		while(reqy>currentyear|| reqmn>curmonthnum)	
		{
			nxt.click();
			curmonthyear=currentmonthyear.getText();//monthyear
			currentyear = Integer.parseInt(curmonthyear.split(" ")[1]);
			curmonthnum = DateTimeFormatter.ofPattern("MMM").withLocale(Locale.ENGLISH).parse(curmonthyear.split(" ")[0].substring(0, 3)).get(ChronoField.MONTH_OF_YEAR);		
		}
		while(reqy<currentyear||reqmn<curmonthnum)
		{
			prev.click();
			curmonthyear=currentmonthyear.getText();//monthyear
			currentyear = Integer.parseInt(curmonthyear.split(" ")[1]);
			curmonthnum = DateTimeFormatter.ofPattern("MMM").withLocale(Locale.ENGLISH).parse(curmonthyear.split(" ")[0].substring(0, 3)).get(ChronoField.MONTH_OF_YEAR);		
		}
	}

	/**@throws IOException
	 * this method is use to takesscreenshot of webpage  by passing the date & driver
	 * return
	 */
	TakesScreenshot ts;
	public String geenericScreenshot(WebDriver Driver,String date)
	{
		TakesScreenshot ts=(TakesScreenshot)Driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File dst=new File("./src/test/resources/photo/"+date+".jpeg");
		try {
			FileHandler.copy(src, dst);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return dst.getAbsolutePath();
	}
	/**
	 *  this method is use to takesscreenshot of the element by passing the date & element
	 * @param ele
	 * @param date
	 * @return
	 */
	public String  genericScreenshot(WebElement ele,String date)
	{		
		File src = ele.getScreenshotAs(OutputType.FILE);
		File dst=new File("./src/test/resources/photo/"+date+" .jpeg");
		try {
			FileHandler.copy(src, dst);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return dst.getAbsolutePath();	
	}
	/*
	 * @return path
	 */
	public String  genericScreenshot()
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		 return ts.getScreenshotAs(OutputType.BASE64); 		
	}
}
