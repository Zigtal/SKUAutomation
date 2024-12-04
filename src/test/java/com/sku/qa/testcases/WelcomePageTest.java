package com.sku.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.sku.qa.base.TestBase;
import com.sku.qa.pages.LoginPage;
import com.sku.qa.pages.SignUpPage;
import com.sku.qa.pages.WelcomePage;

public class WelcomePageTest extends TestBase {

	WelcomePage welcomePage;
	LoginPage loginPage;
	SignUpPage signUpPage;

	public WelcomePageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		welcomePage = new WelcomePage();
	}

	@Test(priority = 1)
	public void welcomePageTitleTest() {
		String title = welcomePage.getWelcomePageTitle();
		Assert.assertEquals(title, "Zigtal | Skill Universe", "Page title is incorrect.");
		System.out.println("Page title is correct.");
	}

	@Test(priority = 2)
	public void welcomePageUrlTest() {
		String expectedUrl = prop.getProperty("welcomePageUrl"); // Define the expected URL in properties
		String actualUrl = driver.getCurrentUrl(); // Retrieve the current URL
		Assert.assertEquals(actualUrl, expectedUrl, "Welcome page URL is incorrect.");
		System.out.println("Welcome page URL is correct.");
	}

	@Test(priority = 3)
	public void welcomePageLogoVisibilityTest() {
		try {
			Thread.sleep(2000); // Sleep for 2 seconds
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		boolean isLogoVisible = welcomePage.isWelcomePageLogoVisible();
		Assert.assertTrue(isLogoVisible, "Zigtal logo is not visible on the welcome page.");
	}

	@Test(priority = 4)
	public void verifyLoginButtonNavigation() {
		loginPage = welcomePage.clickLoginBtnWlcmPage();
		String expectedLoginUrl = prop.getProperty("loginPageUrl");
		Assert.assertEquals(driver.getCurrentUrl(), expectedLoginUrl, "Clicking login did not navigate to the login page.");
		System.out.println("Login button navigates correctly to the login page.");
	}

	@Test(priority = 5)
	public void verifySignUpButtonNavigation() {
		signUpPage = welcomePage.clickSignUpBtnWlcmPage();
		String expectedSignUpUrl = prop.getProperty("signUpPageUrl");
		Assert.assertEquals(driver.getCurrentUrl(), expectedSignUpUrl, "Clicking signup did not navigate to the signup page.");
		System.out.println("Signup button navigates correctly to the signup page.");
	}

	@Test(priority = 6)
	public void verifyWelcomeText1Displayed() {
		String expectedText = prop.getProperty("wlcmPageText1"); // Expected text from properties
		Assert.assertTrue(welcomePage.isWlcmPageText1Visible(), "wlcmPageText1 is not displayed on the Welcome page.");
		String actualText = welcomePage.getWlcmPageText1(); // Method to fetch the actual text
		Assert.assertEquals(actualText, expectedText, "wlcmPageText1 does not match the expected value.");
		System.out.println("wlcmPageText1 is displayed and verified successfully.");
	}

	@Test(priority = 7)
	public void verifyWelcomeText2Displayed() {
		String expectedText = prop.getProperty("wlcmPageText2"); // Expected text from properties
		Assert.assertTrue(welcomePage.isWlcmPageText2Visible(), "wlcmPageText2 is not displayed on the Welcome page.");
		String actualText = welcomePage.getWlcmPageText2(); // Method to fetch the actual text
		Assert.assertEquals(actualText, expectedText, "wlcmPageText2 does not match the expected value.");
		System.out.println("wlcmPageText2 is displayed and verified successfully.");
	}

	@AfterMethod
	public void tearDown() {
		if (driver != null) {
			driver.quit(); // Quit the driver
		}
	}

}
