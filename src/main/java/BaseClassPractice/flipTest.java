package BaseClassPractice;

import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.internal.BaseClassFinder;

import BaseClassPractice.BaseClassPractice;


@Listeners
public class flipTest extends BaseClassPractice{

	@Test(groups = {"regression","major"})
	public void ts1()
	{
		//
		System.out.println(Thread.currentThread().getId());
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
		System.out.println("test case 1");
		System.out.println("regression");
	}
}
