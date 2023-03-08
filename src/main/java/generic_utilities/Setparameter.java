package generic_utilities;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.annotations.ITestAnnotation;
import org.testng.internal.annotations.IAnnotationTransformer;
/**
 * 
 * @author Kartik
 *
 */
public class Setparameter implements IAnnotationTransformer {
/**
 * this method will set the RetryAnalyzer retry to execution
 */
	@Override
	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod,
			Class<?> occurringClazz) {
		annotation.setRetryAnalyzer(generic_utilities.Retryimplementation_listner.class);
	}
}
