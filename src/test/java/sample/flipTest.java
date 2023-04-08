package sample;
import org.testng.annotations.Test;
import Annotation.ExtentReport;
import BaseClassPractice.BaseClassPractice;
import flipPom.PhonePage;

public class flipTest extends BaseClassPractice{
	
	protected PhonePage p;
	@ExtentReport(author = "karti")
	@Test(groups = {"regression","major"})
	public void ts()
	{   	
		System.out.println(search.links());		
		PhonePage p = search.link();
		System.out.println("test case 1");
		System.out.println("regression");
	}
}