package sample;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class Grid {
	
	@Test
	public void test() throws MalformedURLException
	{
		DesiredCapabilities desire=new DesiredCapabilities();
		desire.setPlatform(Platform.WINDOWS);
		String browser="chrome";
		if(browser.equals("chrome"))
		{
			desire.setBrowserName("chrome");
		}
		else if(browser.equals("firefox"))
		{
			desire.setBrowserName("firefox");
		}	
		URL url=new URL("http://192.168.1.5:4444");
		WebDriver d=new RemoteWebDriver(url, desire);		
		d.manage().window().maximize();
		d.get("http://www.flipkart.com");
	}
}
