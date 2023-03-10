package sample;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DemoTest {

	public static void main(String[] args) {
	
		
		WebDriverManager.firefoxdriver().setup();
		WebDriver d=new FirefoxDriver();
		d.get("https://flipkart.com");

	}

}
