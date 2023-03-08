package BaseClassPractice;

import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Annotation.ExtentReport;
import BaseClassPractice.BaseClassPractice;

@Listeners(generic_utilities.Setparameter.class)
public class flipTest1 extends BaseClassPractice{

	@ExtentReport(author = "karti")
	@Test(groups = {"sanity","minor"})
	public void ts1()
	{
		System.out.println(Thread.currentThread().getId());
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
		System.out.println("test case 2");
		System.out.println("sanity");
	}
	
}
