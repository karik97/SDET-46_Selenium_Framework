
package sample;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.collections4.map.HashedMap;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.collect.Multiset.Entry;

import SM_BB_POM.LoginPage;
import generic_utilities.Excel_utils;
import generic_utilities.Framework_data;
import generic_utilities.Javascript_utils;
import generic_utilities.Webdriver_utility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class practice implements Framework_data
{
	static String k;
	static String v;
	public static void main(String[] args) throws EncryptedDocumentException, IOException ,Exception{

		
		Excel_utils e=new Excel_utils("./src/test/resources/test case/TC_Template1(1).xlsx");
		Object[][] key = e.multiDimenArray("login");
		
		System.out.println(key);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}
}

/*
 ArrayList<String> a=new ArrayList<>();
		a.add("kagtkj");
		a.add("njhbgf");
		a.add("mkjhgf");


		FileInputStream f=new FileInputStream("./src/test/resources/test case/TC_Template1(1).xlsx");
		DataFormatter df=new DataFormatter();
		
		 Workbook open = WorkbookFactory.create(f);
			Sheet sh = open.getSheet("Sheet1");
		
			for(int j=0; j<sh.getRow(0).getLastCellNum(); j++)
			{
				String key=df.formatCellValue(sh.getRow(0).getCell(j));
				if(key.equalsIgnoreCase("password"))
				{
					for(int k=0; k<a.size(); k++)
					{try {
						sh.getRow(k+1).createCell(j).setCellValue(a.get(k));
					}catch(Exception e) {
						sh.createRow(k+1).createCell(j).setCellValue(a.get(k));	
					}
					}
					break;
					
					
				}
			
		}
		FileOutputStream fout=new FileOutputStream("./src/test/resources/test case/TC_Template1(1).xlsx");
		open.write(fout);	
 */