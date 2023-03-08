package generic_utilities;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

/**
 * 
 * @author Kartik
 *
 */
public class Select_utility {
	private Select sel;
	/**
	 * this method is use intialize the select object we need to pass the element address
	 * @param element
	 */
	Select_utility(WebElement element) {
		sel=new Select(element);
	}
	/**
	 * this method select the dropdown option based on the visible text/data
	 * @param data
	 */
	public void selbyvisibileText(String data)
	{
		sel.selectByVisibleText(data);
	}
	/**
	 * this method is used th select the dropdown options based on the value
	 * @param data
	 */
	public void selbyValue(String data)
	{
		sel.selectByValue(data);
	}
	/**
	 * this method is used verify whether the drop down is multiple
	 */
	public void isMultiple()
	{
		sel.isMultiple();
	}
	/**
	 * this method is used to selct all options from the dropdown
	 */
	public void deselAll()
	{
		sel.deselectAll();
	}
}
