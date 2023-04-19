package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstractComponent;

public class SignInPage extends AbstractComponent{

	WebDriver driver;
	
	public SignInPage(WebDriver driver)
	{
		super(driver);
		//initialization
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
		
	//WebElements
	
	@FindBy(xpath = "//a[@href='#login']")
	WebElement lnkLogin;
	
	@FindBy(xpath = "//input[@type='email']")
	WebElement txtEmail;
	
	@FindBy(xpath = "//input[@type='password']")
	WebElement txtPassword;
	
	@FindBy(xpath = "//button[@type='submit']")
	WebElement btnSubmit;
	
	@FindBy(xpath = "//ul[@class='error-messages']/li")
	WebElement msgError;
	
	
	
	public void login(String email, String password) throws InterruptedException
	{
		waitForWebElementToAppear(lnkLogin);
		lnkLogin.click();
		waitForWebElementToAppear(txtEmail);
		txtEmail.sendKeys(email);
		txtPassword.sendKeys(password);
		btnSubmit.click();
	}
	
	
	public String getErrorMessage()
	{
		waitForWebElementToAppear(msgError);
		return msgError.getText();
	}
	
	
}
