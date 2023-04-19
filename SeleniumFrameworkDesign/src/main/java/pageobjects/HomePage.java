package pageobjects;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstractComponent;

public class HomePage extends AbstractComponent{

	WebDriver driver;

	public HomePage(WebDriver driver)
	{
		super(driver);
		//initialization
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	//WebElements
	@FindBy(xpath = "//a[contains(text(),'Your Feed')]")
	WebElement lnkYourFeed;	

	
	@FindBy(xpath = "//a[contains(text(),'Global Feed')]")
	WebElement lnkGlobalFeed;	
	
	@FindBy(xpath = "//a[@href='#editor']")
	WebElement lnkNewPost;	
	
	@FindBy(xpath = "//a[@href='#settings']")
	WebElement lnkSettings;	
	
	
	
	public WebElement getLnkNewPost() {
		return lnkNewPost;
	}

	public WebElement getLnkSettings() {
		return lnkSettings;
	}

	public WebElement getLnkYourFeed() {
		return lnkYourFeed;
	}

	public WebElement getLnkGlobalFeed() {
		return lnkGlobalFeed;
	}


	public Boolean isLnkYourFeedDisplay() 
	{
		Boolean lnkYourFeed = getLnkYourFeed().isDisplayed();
		return lnkYourFeed;

	}
	
	public Boolean isLnkGlobalFeedDisplay() 
	{
		Boolean lnkGlobalFeed = getLnkGlobalFeed().isDisplayed();
		return lnkGlobalFeed;

	}
	
	public Boolean isLnkNewPostDisplay() 
	{
		Boolean lnkNewPost = getLnkGlobalFeed().isDisplayed();
		return lnkNewPost;

	}
	public Boolean isLnkSettingsDisplay() 
	{
		Boolean lnkSettings = getLnkGlobalFeed().isDisplayed();
		return lnkSettings;

	}
	
	
	public Boolean isUsernameDisplayHeader(String username) 
	{
		WebElement usernameElement = driver.findElement(By.xpath("//a[contains(text(),'"+ username +"')]"));
		Boolean isUsernameDisplay = usernameElement.isDisplayed();
		return isUsernameDisplay;

	}
	
	
	public void goTo(String url)
	{
		driver.get(url);
	}
}
