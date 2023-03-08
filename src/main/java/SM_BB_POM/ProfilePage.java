package SM_BB_POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class ProfilePage {

	private WebElement convertElement(String replace)
	{
		String xpath = String.format("//button[.='%s']", replace);
		return driver.findElement(By.xpath(xpath));
	}	

	private WebDriver driver;
	//intialization

	public ProfilePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

}
