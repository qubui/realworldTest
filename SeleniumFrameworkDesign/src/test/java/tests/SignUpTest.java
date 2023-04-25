package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import TestComponents.BaseTest;
import pageobjects.HomePage;
import pageobjects.SignUpPage;

import java.io.IOException;
import org.testng.Assert;

public class SignUpTest extends BaseTest {


	@Test
	public void SignUpSuccessfully()
	{
		String password = "password123";
		SignUpPage signUpPage = new SignUpPage(driver);
		String username = generateRandomUsername();
		HomePage homePage = signUpPage.SignUpSuccessfully(username, generateRandomEmail(), password);		 
		Assert.assertTrue(homePage.isLnkYourFeedDisplay());
		Assert.assertTrue(homePage.isLnkGlobalFeedDisplay());
		Assert.assertTrue(homePage.isLnkNewPostDisplay());
		Assert.assertTrue(homePage.isLnkSettingsDisplay());	
		Assert.assertTrue(homePage.isUsernameDisplayHeader(username));
	}
	
	
}