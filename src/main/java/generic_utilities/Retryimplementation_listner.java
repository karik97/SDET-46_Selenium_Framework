package generic_utilities;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
/**
 * this method is used to override the IRetryAnalyzer methods & to set invocation
 * @author Kartik
 *
 */
public class Retryimplementation_listner implements IRetryAnalyzer {
	int c=0;
	@Override
	public boolean retry(ITestResult result) {
		if(c<2)
		{
			c++;			
			return true;	
		}
		return false;
	}
}
