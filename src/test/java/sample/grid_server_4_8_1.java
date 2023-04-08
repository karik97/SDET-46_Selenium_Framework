package sample;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class grid_server_4_8_1 {
	
	@Test
	public void test() throws MalformedURLException
	{
		ChromeOptions opt=new ChromeOptions();
		String browser="chrome";
		
		URL url=new URL("http://192.168.19.24:5555");
		
		WebDriver d=new ChromeDriver();		
		d.manage().window().maximize();
		d.get("http://rmgtestingserver/domain/Bio_Book/");
	}

}
