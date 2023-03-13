package generic_utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.map.HashedMap;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * 
 * @author Kartik
 *
 */

public class Excel_utils {
	Workbook open;	
	DataFormatter df;
	/**
	 * 
	 * @param fis_path
	 */
	FileInputStream fis;
	public Excel_utils(String fis_path)
	{
		try {
			df=new DataFormatter();
			fis = new FileInputStream(fis_path);
			open=WorkbookFactory.create(fis);
		}
		catch (IOException | EncryptedDocumentException e) {

			e.printStackTrace();
		} 
	}	
	/**
	 * this method use to close the stream & excel
	 */
	public void close()
	{
		try {
			fis.close();
			open.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * this method is used to fetch data from excel exact value
	 */
	public String ts(String sheet,String actkey,String v)
	{
		 String value = null;
		 String key;
		Sheet s = open.getSheet(sheet);
		Map<String, String> map=new HashedMap<>();
		List<String> lis=new ArrayList<>(); 
		for(int i=0; i<s.getRow(0).getLastCellNum(); i++)
		{
			key = df.formatCellValue(s.getRow(0).getCell(i)).trim();
			if(key.equalsIgnoreCase(actkey))
			{
				for(int k=1; k<=s.getLastRowNum(); k++)
				{
					value = df.formatCellValue(s.getRow(k).getCell(i));		
					if(value.equalsIgnoreCase(v))
					{
						System.out.println(value);
						break;
					}
					else
					{
						lis.add(value);
					}			      
				}
				map.put(key, value);
			} 	
		}     
		return map.get(actkey);		
	}

	String un;
	/**
	 * this method is use to fetch the data from the test case for update profile script
	 * @param sheet
	 * @param actC
	 * @param actun
	 * @return
	 */
	public String username(String sheet,String actC,String actun)
	{
		Sheet s = open.getSheet(sheet);
		for(int i=0; i<=s.getLastRowNum(); i++)
		{
			String expc = df.formatCellValue(s.getRow(0).getCell(i)).trim();
			if(expc.equalsIgnoreCase(actC))
			{
				for(int j=i; j<=s.getLastRowNum(); j++)
				{
					String expusername = df.formatCellValue(s.getRow(j).getCell(i)).trim();
					if(expusername.equalsIgnoreCase(actun))
					{
						un = expusername;
						break;
					}
				}
				break;
			}
		}
		return un;
	}	
	/**
	 * 	this method is use to fetch the xpath of bio book from excel it will return the map & we need to pass the sheet parameter
	 * @param sheet
	 * @return map
	 */
	public Map<String, String> fetch_xpath(String sheet)
	{
		Sheet s = open.getSheet(sheet);
		Map<String, String> m=new LinkedHashMap<>();

		for(int i=0; i<=s.getLastRowNum();)
		{
			for(int j=0; j<s.getRow(i).getLastCellNum(); j++)
			{
				String key = df.formatCellValue(s.getRow(i).getCell(j));
				String value=df.formatCellValue(s.getRow(i+1).getCell(j));	    	
				m.put(key, value);
			}break;
		}
		return m;
	}
	/**
	 * this metch is used fetch xoath from excel for demo application
	 * @param sheet
	 * @return
	 */
	public Map<String, String> fetchxpath(String sheet)
	{
		Sheet sh = open.getSheet(sheet);
		Map<String, String> m=new LinkedHashMap<>();

		for(int j=0; j<sh.getRow(0).getLastCellNum(); j++)
		{
			String key=df.formatCellValue(sh.getRow(0).getCell(j+1));
			String value=df.formatCellValue(sh.getRow(0+1).getCell(j+1));
			m.put(key, value);
		}

		return m;
	}
	/**
	 * this method is used to fetch data from excel & store it into object [][]
	 * @param sheet
	 * @return
	 */
	public Object[][] multiDimenArray(String sheet)
	{ 
		Sheet s = open.getSheet(sheet);
		Object [][] arr=new Object[s.getLastRowNum()+1][s.getRow(0).getLastCellNum()];
		for(int i=0; i<s.getLastRowNum()+1;i++)
		{
			for(int j=0; j<s.getRow(i).getLastCellNum(); j++)
			{
				arr[i][j]=df.formatCellValue(s.getRow(i).getCell(j));
			}
		}		
		return arr;
	}

	public String basedOnKey(String sheet,String expk,String actun)
	{
		Sheet s = open.getSheet(sheet);
		Map< String, String> map=new LinkedHashMap<>();
		for(int i=0; i<=s.getLastRowNum(); i++)
		{
			for(int j=0; j<s.getRow(i).getLastCellNum(); j++)
			{
				String key=df.formatCellValue(s.getRow(i).getCell(j));
				if(key.equalsIgnoreCase(expk))
				{
					String value=df.formatCellValue(s.getRow(i+1).getCell(j));
					map.put(key, value);
				}
			}			
		}
		return un;
	}	

	public Map<String, String> getData(String sheet,String exptc,String expk)
	{
		Map<String, String>  map =new LinkedHashMap<>();
	    int tccount = 0;	int kcount = 0;   String value = null;
		Sheet sh = open.getSheet(sheet);
		for(int i=0; i<=sh.getLastRowNum(); i++)
		{
			
			String acttc = df.formatCellValue(sh.getRow(i).getCell(0));
			if(acttc.equalsIgnoreCase(exptc))
			{
				tccount++;
				for(int j=0; j<sh.getRow(i).getLastCellNum(); j++)
				{
					String key = df.formatCellValue(sh.getRow(i).getCell(j));
					if(key.equalsIgnoreCase(expk))
					{
						kcount++;
					    value = df.formatCellValue(sh.getRow(i+1).getCell(j));
					    map.put(key, value);
					}break;
				}
			}break;
		}
		
		if(kcount==0)
		{
			if(tccount==0)
			{
				System.out.println("please enter proper test case name "+exptc);
			}
			else
			{
				System.out.println("please enter proper key "+expk);
			}
		}
		System.out.println("data fetched properly "+value);
		return map;
	}
}




