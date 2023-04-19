package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstractComponent;

public class SignUpPage extends AbstractComponent{

	WebDriver driver;
	
	public SignUpPage(WebDriver driver)
	{
		super(driver);
		//initialization
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	//WebElements
	
		@FindBy(xpath = "//a[@href='#register']")
		WebElement lnkSignUp;
		
		@FindBy(xpath = "//input[@placeholder='Username']")
		WebElement txtUsername;

		@FindBy(xpath = "//input[@type='email']")
		WebElement txtEmail;
		
		@FindBy(xpath = "//input[@type='password']")
		WebElement txtPassword;
		
		@FindBy(xpath = "//button[@type='submit']")
		WebElement btnSubmit;

		
		public HomePage SignUpSuccessfully(String username, String email, String password) throws InterruptedException
		{
			waitForWebElementToAppear(lnkSignUp);
			lnkSignUp.click();
			waitForWebElementToAppear(txtUsername);
			txtUsername.sendKeys(username);
			txtEmail.sendKeys(email);
			txtPassword.sendKeys(password);
			btnSubmit.click();
			HomePage homePage = new HomePage(driver);
			return homePage;
		}
		
	
}
