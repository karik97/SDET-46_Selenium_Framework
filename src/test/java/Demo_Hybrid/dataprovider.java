package Demo_Hybrid;

import org.testng.annotations.DataProvider;

public class dataprovider 
{
     @DataProvider(name="signup")
     public static String[][] getdata()
     {
    	 String [][] s= {{"Welcome to the Simple Travel Agency!","Mexico City","London",
 "kartik","peenya","bangalore","karnataka","560066","1234567887456123","12","2022",
	 "karti"}};
    	 return s;
     }
}
