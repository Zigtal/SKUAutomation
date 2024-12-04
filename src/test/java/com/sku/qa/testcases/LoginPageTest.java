package com.sku.qa.testcases;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.sku.qa.base.TestBase;
import com.sku.qa.pages.FindMentorsPage;
import com.sku.qa.pages.HomePage;
import com.sku.qa.pages.LoginPage;
import com.sku.qa.pages.SignUpPage;
import com.sku.qa.pages.WelcomePage;

public class LoginPageTest extends TestBase {

	WelcomePage welcomePage;
	LoginPage loginPage;
	SignUpPage signUpPage;
	HomePage homePage;
	FindMentorsPage findMentorsPage;
	WebDriverWait wait;

	public LoginPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Initialize wait in setup
		welcomePage = new WelcomePage();
		loginPage = new LoginPage();
		homePage = new HomePage();
		findMentorsPage = new FindMentorsPage();
		loginPage = welcomePage.clickLoginBtnWlcmPage();

	}

	@Test(priority = 1)
	public void loginPageTitleTest() {
		String title = loginPage.getLoginPageTitle();
		Assert.assertEquals(title, "Zigtal | Skill Universe", "Page title is incorrect.");
	}

	@Test(priority = 2)
	public void loginPageUrlTest() {
		String currentUrl = loginPage.getLoginPageUrl();
		String expectedUrl = prop.getProperty("loginPageUrl");
		Assert.assertEquals(currentUrl, expectedUrl, "URL mismatch.");
	}

	@Test(priority = 3)
	public void loginPageLogoVisibilityTest() {
		try {
			Thread.sleep(2000); // Sleep for 2 seconds
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		boolean isLogoVisible = loginPage.isLoginPageLogoVisible();
		Assert.assertTrue(isLogoVisible, "Zigtal logo is not visible on the login page.");
	}

	@Test(priority = 4)
	public void clickLoginPageLogoTest() {
		loginPage.isLoginPageLogoClickable();

		// Verify the URL after clicking the logo
		String expectedUrl = prop.getProperty("welcomePageUrl");
		String actualUrl = driver.getCurrentUrl();

		// Assert that the current URL matches the expected URL
		Assert.assertEquals(actualUrl, expectedUrl, "loginPage logo click did not navigate to the welcome page.");

		// Print a success message
		System.out.println("Login page logo click navigates correctly to the welcome page.");
	}

	@Test(priority = 5)
	public void verifyLandingHomePageUrlTest() {
		homePage = loginPage.login(prop.getProperty("un"), prop.getProperty("pwd"));

		// Wait for the home page URL to load properly
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.urlToBe(prop.getProperty("landingPageUrl")));

		String homePageUrl = driver.getCurrentUrl();
		String expectedHomePageUrl = prop.getProperty("landingPageUrl");

		// Assert that the home page URL matches the expected URL
		Assert.assertEquals(homePageUrl, expectedHomePageUrl, "Home page URL is incorrect after login.");
	}

	@Test(priority = 6)
	public void verifyInvalidLoginTest() {
		// Perform invalid login using the credentials from the properties file
		loginPage.invalidLogin(prop.getProperty("invalidUn"), prop.getProperty("invalidPwd"));

		// Wait for the error message to be visible
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(loginPage.getLoginErrorMessage())); // Ensure the error message is displayed

		// Step 4: Get the error message element
		WebElement errorMessage = loginPage.getLoginErrorMessage();

		// Step 5: Assert that the error message is displayed
		Assert.assertTrue(errorMessage.isDisplayed(), "Error message not displayed for invalid login.");

		// Step 6: Check the content of the error message
		String expectedErrorMessage = "Error in Authentication"; // Replace with the actual error message text
		String actualErrorMessage = errorMessage.getText();
		Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "The error message is not correct.");

		// Step 7: Optionally, check the URL to ensure we are still on the login page
		String currentUrl = driver.getCurrentUrl();
		String expectedUrl = prop.getProperty("loginPageUrl"); // This URL should be the login page URL from your properties file
		Assert.assertEquals(currentUrl, expectedUrl, "User was redirected away from the login page.");
	}

	@Test(priority = 7)
	public void verifyPasswordFieldEyeButtonClick() {

		loginPage.invalidLogin(prop.getProperty("invalidUn"), prop.getProperty("invalidPwd"));
		// Step 1: Reveal the password by clicking the eye button
		loginPage.togglePasswordVisibility();

		// Step 2: Verify that the password field is revealed (i.e., type="text")
		String fieldTypeAfterReveal = loginPage.getPasswordFieldType();
		Assert.assertEquals(fieldTypeAfterReveal, "password", "Password field is not revealed after clicking the eye button.");

		// Print the password to the console (revealed password)
		WebElement passwordField = loginPage.passwordField();
		System.out.println("Password is revealed: " + passwordField.getAttribute("value"));

		// Step 3: Hide the password again by clicking the eye button
		loginPage.togglePasswordVisibility();

		// Step 4: Verify that the password field is hidden (i.e., type="password")
		String fieldTypeAfterHide = loginPage.getPasswordFieldType();
		Assert.assertEquals(fieldTypeAfterHide, "password", "Password field is not hidden after clicking the eye button again.");

		// Step 5: Optionally, print a confirmation that the password is hidden
		System.out.println("Password is hidden again.");
	}

	@Test(priority = 8)
	public void verifyLoginHereLinkNavigation() {
		loginPage.clickSignUpHereLinkOnSignUpPage();

		// Define expected URL for verification
		String expectedUrl = prop.getProperty("signUpPageUrl");

		// Wait until the login page URL is loaded
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.urlToBe(expectedUrl));

		// Verify that the current URL matches the expected URL
		String actualUrl = driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl, "Navigation to Sign Up page failed.");

		// Print confirmation message for successful test
		System.out.println("Successfully navigated to the Sign Up page via 'Sign Up Here' link on the Login page.");
	}

	@AfterMethod
	public void tearDown() {
		if (driver != null) {
			driver.quit(); // Quit the driver
		}
	}
}
