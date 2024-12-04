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
import com.sku.qa.pages.HomePage;
import com.sku.qa.pages.LoginPage;
import com.sku.qa.pages.PolicyPage;
import com.sku.qa.pages.SignUpPage;
import com.sku.qa.pages.WelcomePage;

public class SignUpPageTest extends TestBase {

	WelcomePage welcomePage;
	LoginPage loginPage;
	SignUpPage signUpPage;
	HomePage homePage;
	PolicyPage policyPage;
	WebDriverWait wait;

	public SignUpPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Initialize wait in setup
		welcomePage = new WelcomePage();
		loginPage = new LoginPage();
		homePage = new HomePage();
		policyPage = new PolicyPage();
		signUpPage = welcomePage.clickSignUpBtnWlcmPage();

	}

	@Test(priority = 1)
	public void signUpPageTitleTest() {
		String title = signUpPage.getSignUpPageTitle();
		Assert.assertEquals(title, "Zigtal | Skill Universe", "Page title is incorrect.");
	}

	@Test(priority = 2)
	public void signUpPageUrlTest() {
		String currentUrl = signUpPage.getSignUpPageUrl();
		String expectedUrl = prop.getProperty("signUpPageUrl");
		Assert.assertEquals(currentUrl, expectedUrl, "URL mismatch.");
	}

	@Test(priority = 3)
	public void verifySignUpPageText1Displayed() {
		String expectedText = prop.getProperty("signUpPageText1"); // Expected text from properties
		Assert.assertTrue(signUpPage.isSignUpPageText1Visible(), "signUpPageText1 is not displayed");
		String actualText = signUpPage.getSignUpPageText1(); // Method to fetch the actual text
		Assert.assertEquals(actualText, expectedText, "signUpPageText1 does not match the expected value.");
		System.out.println("signUpPageText1 is displayed and verified successfully.");
	}

	@Test(priority = 4)
	public void verifySignUpPageText2Displayed() {
		String expectedText = prop.getProperty("signUpPageText2"); // Expected text from properties
		Assert.assertTrue(signUpPage.isSignUpPageText2Visible(), "signUpPageText2 is not displayed");
		String actualText = signUpPage.getSignUpPageText2(); // Method to fetch the actual text
		Assert.assertEquals(actualText, expectedText, "signUpPageText2 does not match the expected value.");
		System.out.println("signUpPageText2 is displayed and verified successfully.");
	}

	@Test(priority = 5)
	public void verifySignUpPageText3Displayed() {
		String expectedText = prop.getProperty("signUpPageText3"); // Expected text from properties
		Assert.assertTrue(signUpPage.isSignUpPageText3Visible(), "signUpPageText3 is not displayed");
		String actualText = signUpPage.getSignUpPageText3(); // Method to fetch the actual text
		Assert.assertEquals(actualText, expectedText, "signUpPageText3 does not match the expected value.");
		System.out.println("signUpPageText3 is displayed and verified successfully.");
	}

	@Test(priority = 6)
	public void verifyEmailFieldNameWithAsteriskDisplayed() {
		String expectedText = prop.getProperty("emailFieldNameWithAsterisk"); // Expected is (Your Work Email\u2009*) as here \u2009 is the Unicode for
																				// non-breaking space
		Assert.assertTrue(signUpPage.isEmailFieldNameWithAsteriskVisible(), "emailFieldNameWithAsterisk is not displayed");
		String actualText = signUpPage.getEmailFieldNameWithAsterisk(); // Method to fetch the actual text
		Assert.assertEquals(actualText, expectedText, "emailFieldNameWithAsterisk does not match the expected value.");
		System.out.println("emailFieldNameWithAsterisk is displayed and verified successfully.");
	}

	@Test(priority = 7)
	public void verifySignUpPageImageDisplayed() {
		Assert.assertTrue(signUpPage.isSignUpPageImageVisible(), "signUpPageImage is not displayed");
		System.out.println("signUpPageImage is displayed successfully");
	}

	@Test(priority = 8)
	public void signUpPageLogoVisibilityTest() {
		try {
			Thread.sleep(2000); // Sleep for 2 seconds
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		boolean isLogoVisible = signUpPage.isSignUpPageLogoVisible();
		Assert.assertTrue(isLogoVisible, "Zigtal logo is not visible on the signUp page.");
	}

	@Test(priority = 9)
	public void clickSignUpPageLogoTest() {
		signUpPage.isSignUpPageLogoClickable();

		// Verify the URL after clicking the logo
		String expectedUrl = prop.getProperty("welcomePageUrl");
		String actualUrl = driver.getCurrentUrl();

		// Assert that the current URL matches the expected URL
		Assert.assertEquals(actualUrl, expectedUrl, "signUpPage logo click did not navigate to the welcome page.");

		// Print a success message
		System.out.println("signUpPage logo click navigates correctly to the welcome page.");
	}

	@Test(priority = 10)
	public void clickZigtalPoliciesLinkTest() {
		// Click on the "Zigtal Policies" link on the Sign-Up page
		signUpPage.clickZigtalPoliciesLink();

		// Store the original window handle (main tab)
		String mainTabHandle = driver.getWindowHandle();

		// Wait for a new tab to open
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.numberOfWindowsToBe(2));

		// Switch to the new tab
		for (String windowHandle : driver.getWindowHandles()) {
			if (!windowHandle.equals(mainTabHandle)) {
				driver.switchTo().window(windowHandle);
				break;
			}
		}

		// Verify the URL of the new tab
		String expectedUrl = prop.getProperty("policyPageUrl");
		String actualUrl = driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl, "URL mismatch.");

		// Print a success message
		System.out.println("Navigated successfully to Zigtal Policies page.");

		// Verify the page title of the new tab
		String expectedTitle = "Privacy Policy - Zigtal";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle, "Page title is incorrect.");

		// Close the policy tab and switch back to the main tab
		driver.close();
		driver.switchTo().window(mainTabHandle);
	}

	@Test(priority = 11)
	public void verifyLoginHereLinkNavigation() {
		signUpPage.clickLoginHereLinkOnSignUpPage();

		// Define expected URL for verification
		String expectedUrl = prop.getProperty("loginPageUrl");

		// Wait until the login page URL is loaded
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.urlToBe(expectedUrl));

		// Verify that the current URL matches the expected URL
		String actualUrl = driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl, "Navigation to Login page failed.");

		// Print confirmation message for successful test
		System.out.println("Successfully navigated to the Login page via 'Login Here' link on the Sign-Up page.");
	}

	@Test(priority = 12)
	public void verifyErrMsgForMandatoryEmailIdTest() {
		signUpPage.errMsgEmailIsMandatory();

		// Wait for the error message to be visible
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(signUpPage.geterrMsg1())); // Ensure the error message is displayed

		// Step 4: Get the error message element
		WebElement errorMessage = signUpPage.geterrMsg1();

		// Step 5: Assert that the error message is displayed
		Assert.assertTrue(errorMessage.isDisplayed(), "Error message not displayed for Mandatory Email Id");

		// Step 6: Check the content of the error message
		String expectedErrorMessage = prop.getProperty("errMsgForMandatoryEmailId");
		String actualErrorMessage = errorMessage.getText();
		Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "The error message is not correct.");

		// Step 7: Optionally, check the URL to ensure we are still on the login page
		String currentUrl = driver.getCurrentUrl();
		String expectedUrl = prop.getProperty("signUpPageUrl"); // This URL should be the login page URL from your properties file
		Assert.assertEquals(currentUrl, expectedUrl, "User was redirected away from the login page.");
	}

	@Test(priority = 13)
	public void verifyErrMsgForInvalidEmailAddressTest() {
		signUpPage.errMsgInvalidEmailAddress(prop.getProperty("invalidEmailAddressEmailId"));

		// Wait for the error message to be visible
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(signUpPage.geterrMsg2())); // Ensure the error message is displayed

		// Step 4: Get the error message element
		WebElement errorMessage = signUpPage.geterrMsg2();

		// Step 5: Assert that the error message is displayed
		Assert.assertTrue(errorMessage.isDisplayed(), "Error message not displayed for InvalidEmailAddress");

		// Step 6: Check the content of the error message
		String expectedErrorMessage = prop.getProperty("errMsgForInvalidEmailAddress");
		String actualErrorMessage = errorMessage.getText();
		Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "The error message is not correct.");

		// Step 7: Optionally, check the URL to ensure we are still on the login page
		String currentUrl = driver.getCurrentUrl();
		String expectedUrl = prop.getProperty("signUpPageUrl"); // This URL should be the login page URL from your properties file
		Assert.assertEquals(currentUrl, expectedUrl, "User was redirected away from the login page.");
	}

	@Test(priority = 14)
	public void verifyErrMsgForUserAlreadyRegEmailIdTest() {
		signUpPage.errMsgUserAlreadyReg(prop.getProperty("userAlreadyRegEmailId"));

		// Wait for the error message to be visible
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(signUpPage.geterrMsg3())); // Ensure the error message is displayed

		// Step 4: Get the error message element
		WebElement errorMessage = signUpPage.geterrMsg3();

		// Step 5: Assert that the error message is displayed
		Assert.assertTrue(errorMessage.isDisplayed(), "Error message not displayed for UserAlreadyRegEmailId");

		// Step 6: Check the content of the error message
		String expectedErrorMessage = prop.getProperty("errMsgForUserAlreadyRegEmailId");
		String actualErrorMessage = errorMessage.getText();
		Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "The error message is not correct.");

		// Step 7: Optionally, check the URL to ensure we are still on the login page
		String currentUrl = driver.getCurrentUrl();
		String expectedUrl = prop.getProperty("signUpPageUrl"); // This URL should be the login page URL from your properties file
		Assert.assertEquals(currentUrl, expectedUrl, "User was redirected away from the login page.");
	}

	@Test(priority = 15)
	public void verifyErrMsgForNotAuthorizedToRegTest() {
		signUpPage.errMsgNotAutorizedToReg(prop.getProperty("notAuthorizedToRegEmailId"));

		// Wait for the error message to be visible
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(signUpPage.geterrMsg4())); // Ensure the error message is displayed

		// Step 4: Get the error message element
		WebElement errorMessage = signUpPage.geterrMsg4();

		// Step 5: Assert that the error message is displayed
		Assert.assertTrue(errorMessage.isDisplayed(), "Error message not displayed for notAuthorizedToReg");

		// Step 6: Check the content of the error message
		String expectedErrorMessage = prop.getProperty("errMsgForNotAuthorizedToRegEmailId");
		String actualErrorMessage = errorMessage.getText();
		Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "The error message is not correct.");

		// Step 7: Optionally, check the URL to ensure we are still on the login page
		String currentUrl = driver.getCurrentUrl();
		String expectedUrl = prop.getProperty("signUpPageUrl"); // This URL should be the login page URL from your properties file
		Assert.assertEquals(currentUrl, expectedUrl, "User was redirected away from the login page.");
	}

	@AfterMethod
	public void tearDown() {
		if (driver != null) {
			driver.quit(); // Quit the driver
		}
	}
}
