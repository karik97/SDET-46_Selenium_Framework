package sample;

import java.util.Map;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class POM 
{
	private  WebDriver d;

	String pxpath="//input[@name='%s']";

	public  WebElement convertelement(String replace)
	{
		String xpath=String.format(pxpath, replace);
		return	d.findElement(By.xpath(xpath));
	}

	public POM(WebDriver d)
	{
		this.d=d;
		PageFactory.initElements(d, this);
	}

	public void send(Map<String, String> xpath) 
	{
		for(Entry<String, String > v:xpath.entrySet())
		{
			convertelement(v.getKey()).sendKeys(v.getValue());
		}
	}	
}
