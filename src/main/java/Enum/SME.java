package Enum;

public enum SME 
{
    LOGOUT("Log out");
    
    String element;
    
    private  SME(String element)
    {
    	this.element=element;
    }
    public String get()
    {
    	return element;
    }
    
}
