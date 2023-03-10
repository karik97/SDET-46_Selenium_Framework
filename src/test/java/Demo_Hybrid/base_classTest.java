package Demo_Hybrid;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class base_classTest 
{
	public static WebDriver d;
    @BeforeMethod
    public void oa()
    {
    	WebDriverManager.firefoxdriver().setup();
    	d=new FirefoxDriver();
    	d.get("https://blazedemo.com/index.php");
    }
    @AfterMethod
    public void ca() throws InterruptedException
    {
    	d.quit();
    }
}
