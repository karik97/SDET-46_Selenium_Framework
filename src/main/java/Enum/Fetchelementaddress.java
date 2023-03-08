package Enum;
/**
 * 
 * @author Kartik
 *
 */
public enum Fetchelementaddress 
{
     XPATH("xpath");
     
     String fetchxpath;
	
     private Fetchelementaddress(String fetchxpath)
     {
    	 this.fetchxpath=fetchxpath;
     }
     public String get()
     {
    	 return fetchxpath;
     }
}
