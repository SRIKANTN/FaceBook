package Com.FaceBook.Tests;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Scanner;

import org.testng.Reporter;
import org.testng.annotations.Test;

import Com.FaceBook.Generic.BaseTest;
import Com.FaceBook.Generic.Exceldata;
import Com.FaceBook.Generic.GenericUtils;
import Com.FaceBook.Pages.HomePage;
import Com.FaceBook.Pages.LoginPage;

public class LoginTest extends BaseTest
{
	@Test
	public void login() throws Exception 
	{
		
		
		String username=Exceldata.getData(file_path, "Sheet1", 1,0);
		String password=Exceldata.getData(file_path, "Sheet1", 1, 1);
	//	String text=Exceldata.getData(file_path, "Sheet3", 1, 0);
		String path=Exceldata.getData(file_path, "Sheet3", 1, 1);
		LoginPage lp= new LoginPage(driver);
		HomePage hp= new HomePage(driver);
		lp.usernameBOx(username);
		lp.passwordBox(password);
		lp.clickOnLogin();	
		Thread.sleep(2000);
		hp.homeButtonClick();
		Thread.sleep(2000);
		hp.composeButtonClick();
		Thread.sleep(2000);
		hp.photoClick();	
		Thread.sleep(2000);
		GenericUtils.TextEnter(path);
		Thread.sleep(5000);
		hp.posting();
		String text=BaseTest.postingText;
		
		GenericUtils.TextEnter(text);
		Thread.sleep(5000);
		hp.tagFriendTextBox();
		Thread.sleep(5000);
		
		
		int rc=Exceldata.getRowCount(file_path, "Sheet2");
		for (int i = 1; i <=rc; i++) 
		{
			String tagList= Exceldata.getData(file_path, "Sheet2", i, 0);
			Reporter.log(tagList);
			hp.tagFriendListBox(tagList);
			Robot r= new Robot();
			r.keyPress(KeyEvent.VK_ENTER);
			Thread.sleep(1000);
			r.keyRelease(KeyEvent.VK_ENTER);
		}
		Thread.sleep(10000);
		hp.shareButtonClick();
	}

}
