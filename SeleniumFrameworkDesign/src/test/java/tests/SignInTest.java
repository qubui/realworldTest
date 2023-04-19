package tests;

import org.testng.annotations.Test;
import TestComponents.BaseTest;
import pageobjects.SignInPage;

import java.io.IOException;
import org.testng.Assert;

public class SignInTest extends BaseTest {


	@Test
	public void LoginUnsuccessfully() throws IOException, InterruptedException
	{
		SignInPage signInPage = new SignInPage(driver);
		signInPage.login("incorrectEmail@gmail.com", "incorrectPass");
		String actualMessage = signInPage.getErrorMessage();
		Assert.assertEquals(actualMessage, "email or password is invalid");		
	}
}
