package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import TestComponents.BaseTest;
import pageobjects.SignInPage;

import java.io.IOException;
import org.testng.Assert;

public class SignInTest extends BaseTest {

	public static final String invalidMessage = "email or password is invalid";
	@Test(dataProvider="getData")
	public void LoginUnsuccessfully(String email, String password)
	{
		SignInPage signInPage = new SignInPage(driver);
		signInPage.login(email, password);
		String actualMessage = signInPage.getErrorMessage();
		Assert.assertEquals(actualMessage, invalidMessage);		
	}
	
	
	@DataProvider
	public Object[][] getData()
	{
		return new Object[][]  {{"incorrectEmail@gmail.com", "incorrectPass"}};
	}
	
}
