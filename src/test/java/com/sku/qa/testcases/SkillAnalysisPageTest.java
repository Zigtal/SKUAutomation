package com.sku.qa.testcases;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
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
import com.sku.qa.pages.SkillAnalysisPage;
import com.sku.qa.pages.WelcomePage;

public class SkillAnalysisPageTest extends TestBase {

	WelcomePage welcomePage;
	LoginPage loginPage;
	SignUpPage signUpPage;
	HomePage homePage;
	FindMentorsPage findMentorsPage;
	SkillAnalysisPage skillAnalysisPage;
	WebDriverWait wait;

	public SkillAnalysisPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		welcomePage = new WelcomePage();
		loginPage = welcomePage.clickLoginBtnWlcmPage();
		homePage = loginPage.login(prop.getProperty("un"), prop.getProperty("pwd"));
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		skillAnalysisPage = new SkillAnalysisPage();
		findMentorsPage = new FindMentorsPage();
	}

	@Test(priority = 1)
	public void clickAllTabsTest() {
		homePage.clickSkillsMenuLink();
		homePage.clickSkillAnalysisMenuLink();

		skillAnalysisPage.clickMyAspirationalRolesTab();
		skillAnalysisPage.clickSuitableRoleForMeTab();
		skillAnalysisPage.clickMatchAgainstAnyRoleTab();
		skillAnalysisPage.clickMyCurrentRoleTab();
	}

	@Test(priority = 2)
	public void clickFindMentorsLink() {
		homePage.clickSkillsMenuLink();
		homePage.clickSkillAnalysisMenuLink();
		skillAnalysisPage.clickFindMentorsLink();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		String expectedUrl = prop.getProperty("findMentorsPageUrl");
		String actualUrl = driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl, "Find Mentors Page url is not correct");
		System.out.println("Find Mentors Page url is correct");

		WebElement landingPageElement = wait.until(ExpectedConditions.visibilityOf(findMentorsPage.getFindMentorsPageUniqueElement()));
		// Assert that the landing page element is displayed
		Assert.assertTrue(landingPageElement.isDisplayed(), "Find Mentors page element not visible.");
		System.out.println("Find Mentors page element is visible.");
	}

	@Test(priority = 3)
	public void clickAddAspirationRoleBtn() {
		homePage.clickSkillsMenuLink();
		homePage.clickSkillAnalysisMenuLink();
		skillAnalysisPage.clickMyAspirationalRolesTab();
		skillAnalysisPage.clickAddAspirationRoleBtnLink();
	}

	@Test(priority = 4)
	public void verifyWarningMessageOnAddAspirationPage() {
		homePage.clickSkillsMenuLink();
		homePage.clickSkillAnalysisMenuLink();
		skillAnalysisPage.clickMyAspirationalRolesTab();
		skillAnalysisPage.clickAddAspirationRoleBtnLink();
		skillAnalysisPage.clickSaveBtnOnAddAspirationPage();

		skillAnalysisPage.getWarningMsg(prop.getProperty("warningMsgOnAddAspirationPage"));

		// Wait for the error message to be visible
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(signUpPage.geterrMsg3())); // Ensure the error message is displayed

		// Step 4: Get the error message element
		WebElement errorMessage = signUpPage.geterrMsg3();

		// Step 5: Assert that the error message is displayed
		Assert.assertTrue(errorMessage.isDisplayed(), "warningMsgOnAddAspirationPage not displayed");

		// Step 6: Check the content of the error message
		String expectedErrorMessage = prop.getProperty("warningMsgOnAddAspirationPage");
		String actualErrorMessage = errorMessage.getText();
		Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "The error message is not correct.");

	}

	@Test(priority = 4)
	public void adddAspirationRoleSuccessfully() {
		homePage.clickSkillsMenuLink();
		homePage.clickSkillAnalysisMenuLink();
		skillAnalysisPage.clickMyAspirationalRolesTab();
		skillAnalysisPage.clickAddAspirationRoleBtnLink();
		aspirationDropdownField = skillAnalysisPage.clickAspirationDropdownField();

		// Input a partial value to trigger the suggestions
		aspirationDropdownField.sendKeys("cloud"); // Replace "Developer" with a relevant partial input

		// Wait for suggestions to appear
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		List<WebElement> suggestions = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//ul[contains(@class, 'suggestions-list')]//li")));

		// Check if there are suggestions and select the first one
		Assert.assertTrue(suggestions.size() > 0, "No suggestions were found.");
		suggestions.get(0).click();

		// Verify that the selected value appears in the field (optional)
		String selectedValue = autoSuggestField.getAttribute("value");
		Assert.assertEquals(selectedValue, "Developer", "The selected value does not match the expected.");

		System.out.println("Aspiration role successfully added: " + selectedValue);

		// Add further actions or assertions if necessary
	}

	@AfterMethod
	public void tearDown() {
		if (driver != null) {
			driver.quit(); // Quit the driver
		}
	}
}
