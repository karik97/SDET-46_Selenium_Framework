package sample;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import generic_utilities.Webdriver_utility;

public class Broken_linksTest {

	
	public static void main(String[] args) throws MalformedURLException {
		//
		Webdriver_utility wu=new Webdriver_utility();
		WebDriver d = wu.openBrowser("firefox");
		wu.openApp("https://www.flipkart.com", d);
		List<WebElement> links = d.findElements(By.xpath("//a"));
		List<String> arlis=new ArrayList<>();
		List<String> broken=new ArrayList<>();
		for(WebElement link:links)
		{			
			arlis.add(link.getAttribute("href"));
		}	
		for(String url:arlis)
		{
			
			try {
				URL lis=new URL(url);
				HttpURLConnection urlconn = (HttpURLConnection)lis.openConnection();//to get the getResponseCode & getResponseMessage explicitly typecasting
				 int response = urlconn.getResponseCode();
				String msg = urlconn.getResponseMessage();
				if(response!=200)
				{
					broken.add(url);
				}
			System.out.println(	urlconn.getResponseCode());
			System.out.println(urlconn.getResponseMessage());
			}catch(Exception e)
			{
				broken.add(url);
			}
		}
		wu.quiteBrowser(d);
	}

}
