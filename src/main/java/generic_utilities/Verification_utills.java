package generic_utilities;
/**
 * 
 * @author Kartik
 *
 */
public class Verification_utills {
	/**
	 * this method is used to verifiy the page,element,test script we need to pass the expected result
	 * @param exp
	 * @param act
	 * @param type
	 * @param pagenameOrelement
	 */
	public void verification(String exp,String act,String type,String pagenameOrelement)
	{
		if(type.equalsIgnoreCase("TC"))
		{
		if(exp.equals(act))
		{
			System.out.println("test case pass");
		}
		else
		{
			System.out.println("test case faill");
		}}
		else if(type.equalsIgnoreCase("page"))
		{
			if(exp.equalsIgnoreCase(act))
			{
				System.out.println(pagenameOrelement+" page is displayed");
			}
			else {System.out.println(pagenameOrelement+" is not diaplayed");		
		}}
			else if(type.equalsIgnoreCase("element"))
			{
				if(exp.equalsIgnoreCase(act))
				{
					System.out.println(pagenameOrelement+" is displayed");
				}
				else
				{
					System.out.println(pagenameOrelement+" is not displayed");
				}
			}
	}
	/**
	 * this method is used to partial verification the test script
	 * @param exp
	 * @param act
	 */
	public void partialVerification(String exp,String act)
	{
		if(exp.equals(act))
		{
			System.out.println("test case pass");
		}
		else
		{
			System.out.println("test case faill");
		}
	}
}
