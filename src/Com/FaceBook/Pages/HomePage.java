package Com.FaceBook.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Com.FaceBook.Generic.BasePage;

public class HomePage extends BasePage
{
	@FindBy(xpath="(//a[@class='_2s25'])[1]")
	private WebElement homeBTN;
	
	@FindBy(xpath="//a[@class='_4-h7 _5qtn']")
	private WebElement ComposeBTN;
	
	@FindBy(xpath="//div[@class='_1mf _1mj']")
	private WebElement PassingTextBTN;
	
	@FindBy(xpath="(//div[@class='_3jk'])[2]")
	private WebElement PhotoBTN;
	
	@FindBy(xpath="(//div[@class='_3jk'])[1]")
	private WebElement PhotoUpLOadBTN;
	
	@FindBy(xpath="(//div[@class='_2aha'])[3]")
	private WebElement tagFriendBTN;
	
	@FindBy(xpath="//div[@class='_6c0o']")
	private WebElement shareBTN;
	
	@FindBy(xpath="(//input[@class='_58al'])[1]")
	private WebElement tagFriendbox;

	public HomePage(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(driver, this);
	}
	public void tagFriendTextBox()
	{
		tagFriendBTN.click();
	}
	public void tagFriendListBox(String text)
	{
		tagFriendbox.sendKeys(text);
	}
	public void photoClick()
	{
		PhotoBTN.click();
	}
	
		public void homeButtonClick() {
		homeBTN.click();
		
	}


	public void composeButtonClick() {
		ComposeBTN.click();
		 
	}
	
	public void shareButtonClick()
	{
		shareBTN.click();
	}


	public void posting() {
		PassingTextBTN.click();
		
	}
	

}
