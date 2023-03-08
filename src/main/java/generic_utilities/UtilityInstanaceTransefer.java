package generic_utilities;

import com.aventstack.extentreports.ExtentTest;
/**
 * 
 * @author Kartik
 *
 */
public class UtilityInstanaceTransefer {
	private static ThreadLocal<ExtentTest> extent=new ThreadLocal<>();
	/**
	 * this method is used to return utility to called for the member
	 * @return
	 */

	public static ExtentTest getExtent() {
		return extent.get();
	}

	/**
	 * this method is used to set the extent variable
	 * @param setExtentTest
	 */
	public static void setExtent(ExtentTest setExtentTest) {
		extent.set(setExtentTest);
	}
}
