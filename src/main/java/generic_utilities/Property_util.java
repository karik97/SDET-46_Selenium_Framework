package generic_utilities;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import Enum.Enum_data;

/**
 * 
 * @author Kartik
 *
 */
public class Property_util
{
	private Properties Read_prop;
	static FileInputStream fis;
	/**
	 *this method use to intialize the file input stream,it needs the fis_path 
	 * @param FIS_PATH
	 */
	public Property_util(String fispath)
	{
		try {
			fis=new FileInputStream(fispath);
			Read_prop=new Properties();
			Read_prop.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 
	 * @param key
	 * @return
	 * this method use to read property data
	 */
	public String readData(Enum_data key)
	{
		return Read_prop.getProperty(key.name().toLowerCase(),"please give proper key "+key.name().toLowerCase()+" ").trim();
	}

	Properties Write_prop;
	private FileOutputStream Fout;
	/**
	 * In this method we have to intialize the set property by passing the FOUT path 
	 * @throws FileNotFoundException
	 * @param FOUT_PATH
	 */
	public void intializewriteProp(String FOUT_PATH)
	{
		try {
			Fout=new FileOutputStream(FOUT_PATH,true);
			Write_prop=new Properties();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}		
	}
	/**This method is use to set data & store the property
	 * @throws IOException
	 * @param Key
	 * @param Value
	 */
	public void setData(String Key,String Value)
	{
		Write_prop.setProperty(Key, Value);
		try {
			Write_prop.store(Fout, "New Data");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}	
	/**@throws IOException
	 * this method is use to close the stream & property
	 */
	public void readClose()
	{
		try {
			Read_prop.clear();
			fis.close();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	/**@throws IOException
	 * this method is use to close the stream & property
	 */
	public void writeClose()
	{
		try {
			Write_prop.clear();
			Fout.close();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
}