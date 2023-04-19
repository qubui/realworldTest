package tests;

import org.testng.annotations.Test;
import TestComponents.BaseTest;
import pageobjects.HomePage;
import pageobjects.SignUpPage;

import java.io.IOException;
import org.testng.Assert;

public class SignUpTest extends BaseTest {


	@Test
	public void SignUpSuccessfully() throws IOException, InterruptedException
	{

		SignUpPage signUpPage = new SignUpPage(driver);
		String username = generateRandomUsername();
		HomePage homePage = signUpPage.SignUpSuccessfully(username, generateRandomEmail(), "password123");		 
		Assert.assertTrue(homePage.isLnkYourFeedDisplay());
		Assert.assertTrue(homePage.isLnkGlobalFeedDisplay());
		Assert.assertTrue(homePage.isLnkNewPostDisplay());
		Assert.assertTrue(homePage.isLnkSettingsDisplay());	
		Assert.assertTrue(homePage.isUsernameDisplayHeader(username));
	}
}