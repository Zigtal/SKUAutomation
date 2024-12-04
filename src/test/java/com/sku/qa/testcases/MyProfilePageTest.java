package com.sku.qa.testcases;

import java.time.Duration;

import org.openqa.selenium.StaleElementReferenceException;
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
import com.sku.qa.pages.MyProfilePage;
import com.sku.qa.pages.WelcomePage;

public class MyProfilePageTest extends TestBase {

	WelcomePage welcomePage;
	LoginPage loginPage;
	HomePage homePage;
	MyProfilePage myProfilePage;

	WebDriverWait wait;

	public MyProfilePageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();

		welcomePage = new WelcomePage();
		loginPage = welcomePage.clickLoginBtnWlcmPage();
		homePage = loginPage.login(prop.getProperty("un"), prop.getProperty("pwd"));
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		myProfilePage = new MyProfilePage();
	}

	// Utility method to retry finding elements in case of
	// StaleElementReferenceException
	private WebElement waitForElementWithRetry(WebElement element) {
		int attempts = 3;
		for (int i = 0; i < attempts; i++) {
			try {
				return wait.until(ExpectedConditions.visibilityOf(element));
			} catch (StaleElementReferenceException e) {
				System.out.println("Encountered stale element, retrying... Attempt: " + (i + 1));
			}
		}
		throw new StaleElementReferenceException("Element not found after retries");
	}

	private void navigateToMyProfilePage() {
		homePage.clickProfileDetailsMenuLink();
		homePage.clickMyProfMenuLink();
	}

	@Test(priority = 1)
	public void verifyMyProfilePageTitleTest() {
		navigateToMyProfilePage();
		WebElement landingPageElement = waitForElementWithRetry(myProfilePage.getMyProfilePageUniqueElement());
		Assert.assertTrue(landingPageElement.isDisplayed(), "My Profile page element not visible.");

		String myProfilePageTitle = myProfilePage.verifyMyProfilePageTitle();
		Assert.assertEquals(myProfilePageTitle, "Zigtal | Skill Universe", "My Profile Page title not matched");
	}

	@Test(priority = 2)
	public void verifyMyProfilePageUrlTest() {
		navigateToMyProfilePage();

		WebElement landingPageElement = waitForElementWithRetry(myProfilePage.getMyProfilePageUniqueElement());
		Assert.assertTrue(landingPageElement.isDisplayed(), "My Profile page element not visible.");

		String expectedUrl = prop.getProperty("myProfilePageUrl");
		String actualUrl = driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl, "My Profile page URL is incorrect.");
	}

	@Test(priority = 3)
	public void verifyEditButtonTest() {
		navigateToMyProfilePage();
		myProfilePage.clickEditButton();
		System.out.println("Successfully clicked the Edit button");

	}

	@Test(priority = 4)
	public void verifyChangePasswordButtonTest() {
		navigateToMyProfilePage();
		myProfilePage.clickChangePasswordButton();
		System.out.println("Successfully clicked the Change Password button");

	}

	@Test(priority = 5)
	public void verifyDifferentTagsTest() {
		navigateToMyProfilePage();
		Assert.assertEquals(myProfilePage.getFunctionTag(), "Function Tag is not displayed");
		System.out.println("Function Tag is displayed successfully");
	}

	@Test(priority = 6)
	public void verifyProfilePageLabelsTest() {
		navigateToMyProfilePage();

		// Verify the visibility of all the labels
		Assert.assertTrue(myProfilePage.getFunctionTag().isDisplayed(), "Function label is not visible.");
		Assert.assertTrue(myProfilePage.getSubFunctionTag().isDisplayed(), "Sub Function label is not visible.");
		Assert.assertTrue(myProfilePage.getRoleTag().isDisplayed(), "Role label is not visible.");
		Assert.assertTrue(myProfilePage.getPhoneNumberTag().isDisplayed(), "Phone Number label is not visible.");
		Assert.assertTrue(myProfilePage.getEmailAddressTag().isDisplayed(), "Email Address label is not visible.");
		Assert.assertTrue(myProfilePage.getLinkedInProfileTag().isDisplayed(), "LinkedIn Profile label is not visible.");
		Assert.assertTrue(myProfilePage.getManagerNameTag().isDisplayed(), "Manager Name label is not visible.");
		Assert.assertTrue(myProfilePage.getEmployeeIDTag().isDisplayed(), "Employee ID label is not visible.");

		// Print a success message
		System.out.println("All labels are successfully verified on the Profile Page.");
	}

	@Test(priority = 4)
	public void verifyDataEntryInMandatoryFieldTest() {
		navigateToMyProfilePage();
		myProfilePage.clickEditButton();

		// Use enterMandatoryFieldDetails to add data
		myProfilePage.enterMandatoryFieldDetails(prop.getProperty("firstName"), prop.getProperty("lastName"), prop.getProperty("empID"));
	}

	@AfterMethod
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}
}
