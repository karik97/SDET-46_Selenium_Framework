package flipPom;


import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {
	
	@FindAll({@FindBy(tagName = "a"),@FindBy(tagName = "img")})
	private List<WebElement> links;

	@FindAll(@FindBy(xpath = "//div[.='APPLE iPhone 14 (Starlight, 128 GB)']/../following-sibling::div//div[@class='_30jeq3 _1_WHN1']"))
	private WebElement link;

	private WebDriver d;
	
	public SearchPage(WebDriver d) {
		this.d=d;
		PageFactory.initElements(d, this);
	}
	
	HttpURLConnection con;
	protected ArrayList<String> vl;
	protected ArrayList<String> bl;
	public ArrayList<String> links() {
		vl = new ArrayList<>();
		bl = new ArrayList<>();
		
		for(WebElement link:links) {
		vl.add(link.getAttribute("href"));
		}
		for(String l:vl) {
			try {
				URL url = new URL(l);
				 con = (HttpURLConnection)url.openConnection();
				con.getResponseMessage();
				con.getResponseCode();
				if(con.getResponseCode()==201 || con==null) {
					bl.add(l);
					bl.add(con.getResponseMessage());
				}
			}
			catch (Exception e) {
				bl.add(l);	
				try {
					bl.add(con.getResponseMessage());
				} catch (Exception e1) {}
			}
			
		}
		return bl;
	}
	
	public PhonePage link() {
		link.click();
		return new PhonePage(d);//lazy pattern
	}
	
}
