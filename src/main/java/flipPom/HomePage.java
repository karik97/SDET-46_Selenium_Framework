package flipPom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class HomePage {

private WebDriver d;
	
	@FindBy(xpath ="//button[.='✕']")
	private WebElement cbtn;
	
	@FindBy(name = "q")
	private WebElement stf;
	
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement sbtn;
	
	public HomePage(WebDriver d) {
		this.d=d;
		PageFactory.initElements(d,this);
	}
	
	public void cbtn() {
		cbtn.click();
		Assert.assertEquals(d.getCurrentUrl(), "https://www.flipkart.com/");
	}
	
	public SearchPage stf(String s) {
		stf.sendKeys(s);
		sbtn.click();
		return new SearchPage(d);
	}
}