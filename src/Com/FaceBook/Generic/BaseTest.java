package Com.FaceBook.Generic;

import java.lang.reflect.Method;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class BaseTest implements Autoconstant
{
	public WebDriver driver;
	static
	{
		System.setProperty(chrome_key, chrome_value);
		System.setProperty(gecko_key, gecko_value);
	}
	
	@BeforeSuite
	public static String getTextConsole()
	{
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter the Posting text");
		String postingText = sc.nextLine();
		return postingText;
		
		
	}
	
	@BeforeMethod
	public void preCondition(Method methodName)
	{
		
		
		ChromeOptions cp= new ChromeOptions();
		cp.addArguments("--disable-notifications");
		driver= new ChromeDriver(cp);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.facebook.com/");
	}
	
	@AfterMethod()
	public void postCondition(ITestResult res)
	{
		int status=res.getStatus();
		
		if(status==2)
	 {
			String name=res.getMethod().getMethodName();
			GenericUtils.getScreenShot(driver, name);
	 }
	
		// driver.close();
		
	}
}

	


