package testCases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import utilities.ExcelUtilities;
import utilities.ScreenShotCapture;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

public class BaseClass {

	WebDriver driver;
	ScreenShotCapture sc;
	public static Properties prop;

	
	 public static String loginDetails(int row, int column) throws IOException {
		 String value=ExcelUtilities.readData("Sheet1", row, column);
		 return value;
	 }
	 
	 public static void testBasics() throws IOException {
		 prop=new Properties();
		 FileInputStream fp = new FileInputStream(
		 System.getProperty("user.dir") + "\\src\\test\\resources\\Properties\\Config.properties");
		 prop.load(fp);
	 }

	@BeforeMethod
	@Parameters("Browser")
	public void beforeMethod(String browserName) throws IOException {
		testBasics();
		if(browserName.equals("Chrome"))
		{
		driver = new ChromeDriver();
		}
		else if(browserName.equals("FireFox"))
		{
			driver=new FirefoxDriver();
		}
		driver.get(prop.getProperty("baseURL"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(50));
	}
	
	@AfterMethod
	public void afterMethod(ITestResult iTestResult) throws IOException {
		if (iTestResult.getStatus() == ITestResult.FAILURE) {
			sc = new ScreenShotCapture();
			sc.captureFailureScreenShot(driver, iTestResult.getName());
		}
		else if (iTestResult.getStatus() == ITestResult.SUCCESS) {
			sc = new ScreenShotCapture();
			sc.captureSuccessScreenShot(driver, iTestResult.getName());
		}
		driver.quit();
	}
	

}

