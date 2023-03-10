package Demo_Hybrid;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class pom 
{
	WebDriver d;
       @FindBy(xpath="//h1[.='Welcome to the Simple Travel Agency!']")
       private WebElement wtext;
       
       public pom(WebDriver d)
       {
    	   this.d=d;
    	   PageFactory.initElements(d, this);
       }     
       public void wtext(String wt)
       {
    	   String t = wtext.getText();
    	  if(t.equals(wt))
    	  {
    	   System.out.println("this is the home page");
       	  }
    	  else
    	  {
    		  System.out.println("home page is not displayed");
    	  }
       }
       
       @FindBy(xpath="//a[.='destination of the week! The Beach!']")
       private WebElement hl;
       
       public void hl()
       {
    	   hl.click();
    	   String url = d.getCurrentUrl();
    	   if(url.contains("vacation"))
    	   {
    		   System.out.println("url has a string vaccation");
    		   d.navigate().back();
    	   }
    	   else
    	   {
    		   System.out.println("url not contains a vaccation string");
    	   }
       }
       
       @FindBy(name="fromPort")
       private WebElement fd;
       
       public void fd(String f)
       {
    	   Select sel=new Select(fd);
    	   sel.selectByVisibleText(f);
       }
       
       @FindBy(name="toPort")
       private WebElement td;
       
       public void td(String t)
       {
    	   Select sel=new Select(td);
           sel.selectByVisibleText(t);			  
       }
       
       @FindBy(xpath="//input[@type='submit']")
       private WebElement sb;
       
       public void sb()
       {
    	   sb.click();
       }
       
       @FindBy(xpath="//td[.='Aer Lingus']/../td[1]/input")
       private static WebElement lcost;
       
       public static  WebElement lcost()
       {
    	   return lcost;
       }
       
       @FindBy(xpath="(//div[@class='container'])[2]/p[5]")
       private static WebElement tcost;
       
       public String tcost()
       {
    	   String text = tcost.getText();
    	   return text;
       }
       @FindBy(name="inputName")
       private WebElement fn;
       
       public void fn(String ftn)
       {
    	   fn.sendKeys(ftn);
       }
       
       @FindBy(name="address")
       private WebElement ad;
       
       public void ad(String a)
       {
    	   ad.sendKeys(a);
       }
       @FindBy(name="city")
       private WebElement city;
       
       public void city(String c)
       {
    	   city.sendKeys(c);
       }
       
       @FindBy(name="state")
       private WebElement state;
       
       public void state(String s)
       {
    	   state.sendKeys(s);
       }
      
       @FindBy(name="zipCode")
       private WebElement zip;
       
       public void zip(String zp)
       {
    	   zip.sendKeys(zp);
       }
       
       @FindBy(id="cardType")
       private WebElement ct;
       
       public void ct()
       {
    	   Select sel=new Select(ct);
    	   sel.selectByIndex(1);
       }
       
       @FindBy(name="creditCardNumber")
       private WebElement ccn;
       
       public void ccn(String cn)
       {
    	  ccn.sendKeys(cn);
       }
       
       @FindBy(name="creditCardMonth")
       private WebElement month;
       
       public void month(String m)
       {
    	   month.sendKeys(m);
       }
       
       @FindBy(name="creditCardYear")
       private WebElement year;
       
       public void year(String y)
       {
    	   year.sendKeys(y);
       }
       
       @FindBy(name="nameOnCard")
       private WebElement ncard;
       
       public void ncard(String n)
       {
    	   ncard.sendKeys(n);
       }
       
       @FindBy(xpath="//td[.='Id']/../td[2]")
       private WebElement id;
       
       public WebElement id()
       {
    	   return id;
       }
}

