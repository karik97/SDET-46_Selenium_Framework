package SM_BB_POM;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SM_element
{
	//intialization

	public SM_element(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//declration

	@FindBy(xpath = "//button[.='Sign in']")
	private WebElement signin;

	@FindBy(name = "email")
	private WebElement unt;

	@FindBy(name = "password")
	private WebElement pt;

	@FindBy(name = "submit")
	private WebElement lb;

	@FindBy(name="image")
	private WebElement choosefilebtn;

	@FindBy(name="content")
	private WebElement descriptionareafield;

	@FindBy(xpath="//button[.='Share']/ancestor::div[@id='right-nav']/following-sibling::div[@id='right-nav1']//p[.='king']")
	private  List<WebElement> uploadedphotoTxt;

	@FindBy(xpath="//button[.='Share']")
	private WebElement shareBtn;

	@FindBy(xpath="//button[.='Log out']")
	private WebElement logoutbtn;


	//profile update

	@FindBy(xpath="//label[.='Profile']")
	private WebElement profilem;

	@FindBy(xpath="//button[.='Edit Profile']")
	private WebElement editprofilebtn;

	@FindBy(name="username")
	private WebElement untf;

	@FindBy(xpath="//button[.='Save']")
	private WebElement savebtn;

	@FindBy(xpath="//label[.='Home']")
	private WebElement homebtn;

	@FindBy(xpath="//b[.='karti']")
	private WebElement untxt;



	//delete photo

	@FindBy(xpath="//button[.='Share']/ancestor::div[@id='right-nav']/following-sibling::div[@id='right-nav1']//button[.='X']")
	private List<WebElement> dltbtn;

	//utilization

	public void sign()
	{
		signin.click();
	}	

	public WebElement untextfield()
	{
		return unt;
	}

	public WebElement pwdtextfirled()
	{
		return pt;   
	}

	public void loginbutton()
	{
		lb.click();//login & share button
	}

	//upload photo

	public WebElement choosefilebtn()
	{
		return choosefilebtn;
	}

	public  WebElement descriptionareaField()
	{
		return descriptionareafield;
	}

	public void shareBtn()
	{
		shareBtn.click();
	}

	public List<WebElement> uploadedphotoTxt()
	{
		return uploadedphotoTxt;
	}

	public void logout()
	{
		logoutbtn.click();
	}

	public void signin1()
	{
		signin.click();
	}



	//profile update

	public void profilem()
	{
		profilem.click();;
	}

	public void editprofilebtn()
	{
		editprofilebtn.click();
	}

	public WebElement unt()
	{
		return untf;
	}

	public void savebtn()
	{
		savebtn.click();
	}

	public void homeBtn()
	{
		homebtn.click();
	}

	public WebElement untxt()
	{
		return untxt;
	}


	//delete photo

	public List<WebElement> dltbtn()
	{
		return dltbtn;
	}
}



/*
  String partialxpath="//button[.='%s']";
  private WebElement convertElement(String replace)
	{
	    String xpath = String.format(partialxpath, replace);
	    return driver.findElement(By.xpath(xpath));
	}	

		private WebDriver driver;
	//intialization

	public SM_element(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

 */
