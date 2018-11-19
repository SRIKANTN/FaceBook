package Com.FaceBook.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Com.FaceBook.Generic.BasePage;

public class LoginPage extends BasePage
{
	@FindBy(xpath="//input[@id='email']")
	private WebElement UnTB;
	
	@FindBy(xpath="//input[@id='pass']")
	private WebElement PuTB;
	
	@FindBy(xpath="//input[@value='Log In']")
	private WebElement LgBT;
	
	public LoginPage(WebDriver driver) 
	{
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public void usernameBOx(String un)
	{
		UnTB.sendKeys(un);
			
	}
	public void passwordBox(String pw)
	{
		PuTB.sendKeys(pw);
	}
	public void clickOnLogin()
	{
		LgBT.click();
	}
}
