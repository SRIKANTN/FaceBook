package Com.FaceBook.Generic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class BasePage
{
	
		public WebDriver driver;
		public BasePage(WebDriver driver)
		{
			this.driver= driver;
		}
		
		public void  verifyTitle(String eTitle) 
		{
			WebDriverWait wait= new WebDriverWait(driver, 10);
			try
			{
				wait.until(ExpectedConditions.titleIs(eTitle));
				Reporter.log("Title is matching:"+eTitle, true);
			}
			catch(Exception e)
			{
				Reporter.log("Title is not matching, expected title is:"+eTitle, true);
				
				Reporter.log("Actual title is:" + driver.getTitle());
				Assert.fail();
			
			}
			
		}
		
		public void verifyElement(WebElement element)
		{
			WebDriverWait wait=new WebDriverWait(driver,10);
			try
			{
				wait.until(ExpectedConditions.visibilityOf(element));
				Reporter.log("Element is Present ..." , true);
			}
			
			catch (Exception e )
			{
				Reporter.log("element is not Present .." , true );
				Assert.fail();
				
			}
		
	}
		

}
