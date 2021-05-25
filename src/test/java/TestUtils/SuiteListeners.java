package TestUtils;


import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.IAnnotationTransformer;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.ITestAnnotation;

import testSuites.BaseTest;



public class SuiteListeners implements  ITestListener,IAnnotationTransformer{
	

	@Override
	public void onTestStart(ITestResult result) {
		
	}
	
	@Override
	public void onTestSuccess(ITestResult result) {
		
	}
	
		
	@Override
	
	public void onTestFailure(ITestResult result) {
		
		String fileName =System.getProperty("user.dir") + File.separator + "screens" + File.separator + result.getMethod().getMethodName();
		File f = ((TakesScreenshot)BaseTest.driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(f,new File(fileName + ".jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSkipped(result);
	}
	
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}
	
	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onStart(context);
	}
	
	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onFinish(context);
	}
	
	@Override
	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
		
		annotation.setRetryAnalyzer(retryAnalyzer.class);
	}
	
	
	
	
	
	
	
	

}
