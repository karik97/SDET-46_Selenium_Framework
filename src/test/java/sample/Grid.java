package sample;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Test;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

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
			desire.setBrowserName("friefox");
		}
		
		URL url=new URL("http://192.168.19.24:4444/wd/hub");
		WebDriver d=new RemoteWebDriver(url, desire);
		
		d.manage().window().maximize();
		d.get("https//:www.flipkart.com");
	}
}
