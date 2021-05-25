package testSuites;

import java.io.File;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import TestUtils.Constants;

public  class BaseTest {

	public static WebDriver driver;
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest logger;
	

	
	@BeforeTest
	public void beforeTestMethod() {
		
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") +"/test-output/testReport.html");
        
        //initialize ExtentReports and attach the HtmlReporter
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
         
    
		//To add system or environment info by using the setSystemInfo method.
       
		extent.setSystemInfo("Automation", "Tapas");
        
		//extent.setSystemInfo("Browser", browser);
        
        //configuration items to change the look and feel
        //add content, manage tests etc
       
        htmlReporter.config().setDocumentTitle("Extent Report Demo");
        htmlReporter.config().setReportName("Test Report");
        htmlReporter.config().setEncoding("utf-8");;
        htmlReporter.config().setTheme(Theme.STANDARD);
        htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
	};

	@BeforeMethod
	@Parameters(value={"browserName"})
	public void beforeMethodMethod(String browserName, Method testMethod) {
		logger =extent.createTest(testMethod.getName());
		
		setUpdriver(browserName);
		driver.manage().window().maximize();
		driver.get(Constants.url);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	};


	@AfterMethod
	public void afterMethodMethod(ITestResult result) {
		
		if (result.getStatus()== ITestResult.SUCCESS){
			String methodName=result.getMethod().getMethodName();
			String logText = "Test Case" +methodName + "PASSED";
			Markup m =MarkupHelper.createLabel(logText, ExtentColor.GREEN);
			logger.log(Status.PASS,m);
		}
		else if (result.getStatus()==ITestResult.FAILURE) {
			String methodName=result.getMethod().getMethodName();
			String logText = "Test Case" +methodName + "FAILED";
			Markup m =MarkupHelper.createLabel(logText, ExtentColor.RED);
			logger.log(Status.FAIL,m);
			
		}
		driver.quit();
		
	
	
	};

	
	@AfterTest
	public void afterTestMethod() {
		extent.flush();
	};
	
	
	public void setUpdriver(String browserName) {
		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver","C:\\Selenium_Forum\\QAIbibo\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		} 
		else if (browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver",
					System.getProperty("user.dir") + File.separator + "drivers" + File.separator + "geckodriver");
			driver = new FirefoxDriver();
		}
		else {

			System.setProperty("webdriver.chrome.driver","C:\\Selenium_Forum\\QAIbibo\\drivers\\chromedriver.exe");
					
			driver = new ChromeDriver();

		}

	}

}



