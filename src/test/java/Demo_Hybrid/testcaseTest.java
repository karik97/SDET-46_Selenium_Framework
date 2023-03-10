package Demo_Hybrid;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class testcaseTest extends base_classTest
{
	@Test(dataProvider = "signup", dataProviderClass = dataprovider.class)
    public static void script(String wt,String f,String t,
    		String fn,String a,String c,String s
    		,String zp,String cn,String m,String y,String n)
    {
    	pom p=new pom(d);
    	p.wtext(wt);
    	p.hl();
    	p.fd(f);
    	p.td(t);
    	p.sb();
        WebElement l = p.lcost();
        l.click();
        System.out.println(d.getCurrentUrl());
 	   String title = d.getTitle();
 	   if(title.contains("BlazeDemo Purchase"))
 	   {
 	   System.out.println("purchase page is displayed");
 	   String tcost = p.tcost();
 	   System.out.println("total cost is available "+tcost);
    	p.fn(fn);
    	p.ad(a);
    	p.city(c);
    	p.state(s);
    	p.zip(zp);
    	p.ct();
    	p.ccn(cn);
    	p.month(m);
    	p.year(y);
    	p.ncard(n);
    	p.sb();    	
    	
    	String cont = d.getTitle();
    	if(cont.contains("BlazeDemo Confirmation"))
    	{
    		System.out.println("purchase confirmation page is displayed");
    		String id = p.id().getText();
    		System.out.println(id+" id of flight");
    	}
    }
 	   else
 	   {
 		   System.out.println("purcahse page not disaplayed");
 	   }
 	   }
	   
}
