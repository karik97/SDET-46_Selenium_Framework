package sample;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import Annotation.ExtentReport;
import BaseClassPractice.BaseClassPractice;

public class flipTest extends BaseClassPractice{
	@ExtentReport(author = "karti")
	@Test(groups = {"regression","major"})
	public void ts()
	{
		System.out.println(Thread.currentThread().getId());
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
		System.out.println("test case 1");
		System.out.println("regression");
	}
}
