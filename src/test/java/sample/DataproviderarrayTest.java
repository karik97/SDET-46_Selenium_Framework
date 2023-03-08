package sample;

import java.util.Map;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import generic_utilities.Excel_utils;

public class DataproviderarrayTest
{
	@Test(dataProvider = "dp")
	public void test(Object s,Object k,Object a,Object v,Object c,Object b)
	{
		System.out.println(s+" "+k+" "+a+""+v+""+c+" "+b);
	}
	
	@DataProvider
	public Object[][] dp()
	{
		Excel_utils e=new Excel_utils("./src/test/resources/test case/TC_Template1(1).xlsx");
	    return	e.multiDimenArray("Sheet1");
	}
	
	
   // @DataProvider
    public Object[][] dp1()
    {
    	Object [][] arr=new Object[2][2];
    	arr[0][0]="kartik";
    	arr[0][1]=2153;
    	
    	arr[1][0]="jnjhbjghfg";
    	arr[1][1]=2145;
    	return arr;
    }
}
