package sample;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import generic_utilities.Excel_utils;
import generic_utilities.Javascript_utils;
import generic_utilities.Webdriver_utility;


public class sample {
	static String txt;
	public static void main(String[] args) throws EncryptedDocumentException, IOException, InterruptedException {

		String rm="Aug"; String ry="2023";	
		int rmn = DateTimeFormatter.ofPattern("MMM").withLocale(Locale.ENGLISH).parse(rm).get(ChronoField.MONTH_OF_YEAR);
		int ryn = Integer.parseInt(ry);

		Webdriver_utility w=new Webdriver_utility();
		WebDriver d = w.openBrowser("firefox");
		Javascript_utils j=new Javascript_utils(d);
		w.openApp("https://www.redbus.in/online-booking/tsrtc?gclid=Cj0KCQiAgOefBhDgARIsAMhqXA5Jsx9QV0ngGllSUM1f0FNhXJ84nPAD9MijF8VluZpZlW-0gciVHlAaAjiJEALw_wcB", d);
		
		System.out.println(j.getUrl()+" "+j.getTitle());
		d.findElement(By.id("txtOnwardCalendar")).click();
		j.generateAlert("button clicked properly");
		Thread.sleep(5000);

		d.quit();


	}


}


































/*WebElement currentmonthyear = d.findElement(By.xpath("//td[.='Feb 2023']"));
		WebElement prev = d.findElement(By.xpath("//td[@class='prev']/button"));
		WebElement nxt = d.findElement(By.xpath("//td[@class='next']/button"));
		WebElement cal = d.findElement(By.id("onward_cal"));*/

/*
String rm="Mar";
int ry=2023;
int rmn = DateTimeFormatter.ofPattern("MMM").withLocale(Locale.ENGLISH).parse(rm).get(ChronoField.MONTH_OF_YEAR);
      emt=d.findElement(By.id("onward_cal"));
String date = ju.getsimpleDate();
		System.out.println(date);
		wu.genericScreenshot(emt, date);

String currentmonthyear = d.findElement(By.xpath("//td[@class='monthTitle']")).getText();
int currentyear = Integer.parseInt(currentmonthyear.split(" ")[1]);
int curmonthnum = DateTimeFormatter.ofPattern("MMM").withLocale(Locale.ENGLISH).parse(currentmonthyear.split(" ")[0]).get(ChronoField.MONTH_OF_YEAR);

	while(ry>currentyear || rmn>curmonthnum) 
		{	
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			d.findElement(By.xpath("//td[@class='next']/button")).click();
			currentmonthyear = d.findElement(By.xpath("//td[@class='monthTitle']")).getText();
			currentyear = Integer.parseInt(currentmonthyear.split(" ")[1]);
			String curmonth = currentmonthyear.split(" ")[0].substring(0, 3);										
			curmonthnum = DateTimeFormatter.ofPattern("MMM").withLocale(Locale.ENGLISH).parse(curmonth).get(ChronoField.MONTH_OF_YEAR);	 					 					
		}

		while(ry<currentyear || rmn<curmonthnum) 
		{
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			d.findElement(By.xpath("//td[@class='prev']/button")).click();
			currentmonthyear = d.findElement(By.xpath("//td[@class='monthTitle']")).getText();
			currentyear = Integer.parseInt(currentmonthyear.split(" ")[1]);
			String curmonth = currentmonthyear.split(" ")[0].substring(0, 3);										
			curmonthnum = DateTimeFormatter.ofPattern("MMM").withLocale(Locale.ENGLISH).parse(curmonth).get(ChronoField.MONTH_OF_YEAR);	 					 
		} 

		//write multiple data based on keys
Webdriver_utility w=new Webdriver_utility();
	WebDriver d = w.openBrowser("firefox");
	w.openApp("https://www.flipkart.com", d);
	 List<WebElement> links = d.findElements(By.xpath("//a"));

	for(WebElement link:links)
	{
		txt = link.getText();
	}

	DataFormatter df=new DataFormatter();	
	FileInputStream e=new FileInputStream("./src/test/resources/test case/TC_Template1(1).xlsx");
	FileOutputStream fout=new FileOutputStream("./src/test/resources/test case/TC_Template1(1).xlsx",true);
	 Workbook open = WorkbookFactory.create(e);
	 Sheet sh=open.getSheet("Sheet1");

	 for(int i=0; i<=sh.getLastRowNum(); i++)
	 {
		 for(int j=0; j<sh.getRow(i).getLastCellNum(); j++)
		 {
			 String key = df.formatCellValue(sh.getRow(i).getCell(j));
			 if(key.equalsIgnoreCase("password"))
			 {
						for(int o=0; o<=links.size(); o++)
						{
							Cell c = sh.createRow(o).createCell(i+1);
							c.setCellValue(links.get(o).getAttribute("href"));	
						}							 
			 }
		 }
	 }
	 open.write(fout);
 */













