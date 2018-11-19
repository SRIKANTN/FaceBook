package Com.FaceBook.Generic;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class GenericUtils 
{
	public static void getScreenShot(WebDriver driver, String name)
	{
		try 
		{
			TakesScreenshot t = (TakesScreenshot) driver;
			File src = t.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(src, new File("./screenshots/"+name+".png"));
		}
		catch (IOException e) {
		}
	}
	public static void ScrollDownPage(WebDriver driver, int y)
	{
		
		JavascriptExecutor js=(JavascriptExecutor) driver; 
		js.executeScript("window.scrollBy(0,'"+y+"')");
		
	}
	public static void onlineText(String text) throws Exception
	{
		String t=text;
		StringSelection sc= new StringSelection(t);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(sc, null);
		Thread.sleep(1000);
		Robot r= new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		Thread.sleep(1000);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_V);
		Thread.sleep(1000);
		
//		r.keyPress(KeyEvent.VK_ENTER);
//		r.keyRelease(KeyEvent.VK_ENTER);
//	
	}
	
	public static void TextEnter(String text) throws Exception
	{
		String t=text;
		StringSelection sc= new StringSelection(t);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(sc, null);
		Thread.sleep(1000);
		Robot r= new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		Thread.sleep(1000);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_V);
		Thread.sleep(1000);
		
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	
	}
}
