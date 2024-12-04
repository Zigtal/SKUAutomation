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
import com.sku.qa.pages.MenteeProfilePage;
import com.sku.qa.pages.MyProfilePage;
import com.sku.qa.pages.WelcomePage;

public class MenteeProfilePageTest extends TestBase {

	WelcomePage welcomePage;
	LoginPage loginPage;
	HomePage homePage;
	MyProfilePage myProfilePage;
	MenteeProfilePage menteeProfilePage;

	WebDriverWait wait;

	public MenteeProfilePageTest() {
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
		menteeProfilePage = new MenteeProfilePage();
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
		homePage.clickMenteeProfMenuLink();
	}

	@Test(priority = 1)
	public void verifyMentorProfilePageUrlTest() {
		navigateToMyProfilePage();

		WebElement landingPageElement = waitForElementWithRetry(menteeProfilePage.getMenteeProfilePageUniqueElement());
		Assert.assertTrue(landingPageElement.isDisplayed(), "Mentee Profile page element not visible.");

		String expectedUrl = prop.getProperty("menteeProfilePageUrl");
		String actualUrl = driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl, "Mentee Profile page URL is incorrect.");
	}

	@AfterMethod
	public void tearDown() {
		if (driver != null) {
			driver.quit(); // Quit the driver
		}
	}
}
