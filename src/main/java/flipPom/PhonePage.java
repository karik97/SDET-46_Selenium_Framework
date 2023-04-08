package flipPom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PhonePage {
	
	private WebDriver d;
	public PhonePage(WebDriver d) {
		this.d=d;
		PageFactory.initElements(d, this);
	}
}
