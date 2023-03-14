package sample;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import generic_utilities.Webdriver_utility;

public class ShadowElementTest {
	public static void main(String[] args) throws InterruptedException {
		Webdriver_utility wu=new Webdriver_utility();
		WebDriver d = wu.openBrowser("chrome");
		wu.openApp("chrome://downloads/", d);
		JavascriptExecutor js=(JavascriptExecutor)d;
		WebElement ele = (WebElement)js.executeScript("return document.querySelector('downloads-manager').shadowRoot.querySelector('#toolbar')"
				+ ".shadowRoot.querySelector('#toolbar').shadowRoot.querySelector('#search')");
		ele.sendKeys("kartik");
		Thread.sleep(5000);
		d.quit();
	}

}
