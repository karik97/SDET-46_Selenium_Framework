package generic_utilities;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import com.mysql.cj.jdbc.Driver;

public class JDBC_utils 
{
	private static Statement statment;
	/**
	 * this constructor is used intialize the database URL UN PWD
	 * @throws SQLException e
	 * @param driver
	 * @param url
	 * @param un
	 * @param pwd
	 * 
	 */
     public JDBC_utils(String url,String un,String pwd)
     {
    	 try {
    		 DriverManager.registerDriver(new Driver());
			 statment = DriverManager.getConnection(url, un, pwd).createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}    	 
     }
     /**
      * this nethod is used to fetch data from database
	  * @throws SQLException e
      * @param query
      * @param index
      * @return
      */
     public ArrayList<String> executeQuery(String query,String data)
     {
    	 ArrayList<String> arlis=new ArrayList<>();
    	 try {
			ResultSet res = statment.executeQuery(query);
			while(res.next())
			{
			arlis.add(res.getString(data));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	 return arlis;
     }
     /**
      * its used to update the data in database
      * @param query
      */
     public void executeUpdate(String query)
     {
    	 try {
			int res = statment.executeUpdate(query);
			while(res==1)
			{
				System.out.println(res);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
     }
}
