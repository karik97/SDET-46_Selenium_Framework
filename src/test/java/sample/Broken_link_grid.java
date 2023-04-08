package sample;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class Broken_link_grid {
	
	@Test 
	public void test() throws MalformedURLException{
	DesiredCapabilities desire=new DesiredCapabilities();//desire capability is deprecated in selenium 4th version 
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
	URL url=new URL("http://192.168.0.135:4444/wd/hub");
	WebDriver d=new RemoteWebDriver(url, desire);		
	d.manage().window().maximize();
	d.get("http://rmgtestingserver/domain/Bio_Book/");
}}
