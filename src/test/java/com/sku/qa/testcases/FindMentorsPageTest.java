package com.sku.qa.testcases;

import java.time.Duration;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.sku.qa.base.TestBase;
import com.sku.qa.pages.FindMentorsPage;
import com.sku.qa.pages.HomePage;
import com.sku.qa.pages.LoginPage;
import com.sku.qa.pages.MentorProfilePage;
import com.sku.qa.pages.MyProfilePage;
import com.sku.qa.pages.WelcomePage;

public class FindMentorsPageTest extends TestBase {

	WelcomePage welcomePage;
	LoginPage loginPage;
	HomePage homePage;
	MyProfilePage myProfilePage;
	MentorProfilePage mentorProfilePage;
	FindMentorsPage findMentorsPage;
	WebDriverWait wait;

	public FindMentorsPageTest() {
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
		mentorProfilePage = new MentorProfilePage();
		findMentorsPage = new FindMentorsPage();
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
		homePage.clickFindMentorsMenuLink();
	}

	@Test(priority = 1)
	public void verifyMentorProfilePageUrlTest() {
		navigateToMyProfilePage();

		WebElement landingPageElement = waitForElementWithRetry(mentorProfilePage.getMentorProfilePageUniqueElement());
		Assert.assertTrue(landingPageElement.isDisplayed(), "My Profile page element not visible.");

		String expectedUrl = prop.getProperty("mentorProfilePageUrl");
		String actualUrl = driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl, "Mentor Profile page URL is incorrect.");
	}

}
