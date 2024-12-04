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
import com.sku.qa.pages.AcademicsPage;
import com.sku.qa.pages.DashboardPage;
import com.sku.qa.pages.FindMentorsPage;
import com.sku.qa.pages.GroupEngPage;
import com.sku.qa.pages.HomePage;
import com.sku.qa.pages.LoginPage;
import com.sku.qa.pages.ManageMyTeamPage;
import com.sku.qa.pages.MenteeProfilePage;
import com.sku.qa.pages.MentorProfilePage;
import com.sku.qa.pages.MyMenteesPage;
import com.sku.qa.pages.MyMentorsPage;
import com.sku.qa.pages.MyProfilePage;
import com.sku.qa.pages.MyProjectsPage;
import com.sku.qa.pages.MySkillsPage;
import com.sku.qa.pages.RatingRequestsPage;
import com.sku.qa.pages.SkillAnalysisPage;
import com.sku.qa.pages.WelcomePage;

public class HomePageTest extends TestBase {
	WelcomePage welcomePage;
	LoginPage loginPage;
	HomePage homePage;
	DashboardPage dashboardPage;
	MySkillsPage mySkillsPage;
	SkillAnalysisPage skillAnalysisPage;
	RatingRequestsPage ratingRequestsPage;
	GroupEngPage groupEngPage;
	FindMentorsPage findMentorsPage;
	MyMentorsPage myMentorsPage;
	MyMenteesPage myMenteesPage;
	MyProjectsPage myProjectsPage;
	MyProfilePage myProfilePage;
	AcademicsPage academicsPage;
	MentorProfilePage mentorProfilePage;
	MenteeProfilePage menteeProfilePage;
	ManageMyTeamPage manageMyTeamPage;
	WebDriverWait wait;

	public HomePageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		welcomePage = new WelcomePage();
		loginPage = welcomePage.clickLoginBtnWlcmPage();
		homePage = loginPage.login(prop.getProperty("un"), prop.getProperty("pwd"));
		dashboardPage = new DashboardPage();
		mySkillsPage = new MySkillsPage();
		skillAnalysisPage = new SkillAnalysisPage();
		ratingRequestsPage = new RatingRequestsPage();
		groupEngPage = new GroupEngPage();
		findMentorsPage = new FindMentorsPage();
		myMentorsPage = new MyMentorsPage();
		myMenteesPage = new MyMenteesPage();
		myProjectsPage = new MyProjectsPage();
		myProfilePage = new MyProfilePage();
		academicsPage = new AcademicsPage();
		mentorProfilePage = new MentorProfilePage();
		menteeProfilePage = new MenteeProfilePage();
		manageMyTeamPage = new ManageMyTeamPage();
	}

	@Test(priority = 1)
	public void verifyHomePageTitleTest() {
		String homePageTitle = homePage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, "Zigtal | Skill Universe", "Home Page Title not matched");
	}

	@Test(priority = 2)
	public void verifyDashboardLinkTest() {
		homePage.clickDashboardMenuLink();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		WebElement landingPageElement = wait.until(ExpectedConditions.visibilityOf(dashboardPage.getDashboardPageUniqueElement()));
		// Assert that the landing page element is displayed
		Assert.assertTrue(landingPageElement.isDisplayed(), "Dashboard page element not visible.");

	}

	@Test(priority = 3)
	public void verifySkillsLinkTest() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		homePage.clickSkillsMenuLink();
		System.out.println("Skills dropdown is clicked successfully");
	}

	@Test(priority = 4)
	public void verifyMySkillsLinkTest() {
		homePage.clickSkillsMenuLink();
		homePage.clickMySkillsMenuLink();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		WebElement landingPageElement = wait.until(ExpectedConditions.visibilityOf(mySkillsPage.getMySkillsPageUniqueElement()));
		// Assert that the landing page element is displayed
		Assert.assertTrue(landingPageElement.isDisplayed(), "My Skills page element not visible.");
	}

	@Test(priority = 5)
	public void verifySkillAnalysisLinkTest() {
		homePage.clickSkillsMenuLink();
		homePage.clickSkillAnalysisMenuLink();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		WebElement landingPageElement = wait.until(ExpectedConditions.visibilityOf(skillAnalysisPage.getMySkillsPageUniqueElement()));
		// Assert that the landing page element is displayed
		Assert.assertTrue(landingPageElement.isDisplayed(), "Skill Analysis page element not visible.");
	}

	@Test(priority = 6)
	public void verifyRatingRequestsLinkTest() {
		homePage.clickSkillsMenuLink();
		homePage.clickRatingRequestsMenuLink();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		WebElement landingPageElement = wait.until(ExpectedConditions.visibilityOf(ratingRequestsPage.getRatingRequestsPageUniqueElement()));
		// Assert that the landing page element is displayed
		Assert.assertTrue(landingPageElement.isDisplayed(), "Rating Requests page element not visible.");
	}

	@Test(priority = 7)
	public void verifyGroupEngLinkTest() {
		homePage.clickGroupEngMenuLink();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		WebElement landingPageElement = wait.until(ExpectedConditions.visibilityOf(groupEngPage.getGroupEngPageUniqueElement()));
		// Assert that the landing page element is displayed
		Assert.assertTrue(landingPageElement.isDisplayed(), "Group Engagement page element not visible.");
	}

	@Test(priority = 8)
	public void verifyMentoringLinkTest() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		homePage.clickMentoringMenuLink();
		homePage.clickMentoringMenuLink();
		System.out.println("Mentoring dropdown is clicked successfully");
	}

	@Test(priority = 9)
	public void verifyFindMentorsLinkTest() {
		homePage.clickDashboardMenuLink();
		homePage.clickMentoringMenuLink();
		homePage.clickFindMentorsMenuLink();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		WebElement landingPageElement = wait.until(ExpectedConditions.visibilityOf(findMentorsPage.getFindMentorsPageUniqueElement()));
		// Assert that the landing page element is displayed
		Assert.assertTrue(landingPageElement.isDisplayed(), "Find Mentors page element not visible.");
	}

	@Test(priority = 10)
	public void verifyMyMentorsLinkTest() {
		homePage.clickMyMentorsMenuLink();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		WebElement landingPageElement = wait.until(ExpectedConditions.visibilityOf(myMentorsPage.getMyMentorsPageUniqueElement()));
		// Assert that the landing page element is displayed
		Assert.assertTrue(landingPageElement.isDisplayed(), "My Mentors page element not visible.");
	}

	@Test(priority = 11)
	public void verifyMyMenteesLinkTest() {
		homePage.clickMyMenteesMenuLink();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		WebElement landingPageElement = wait.until(ExpectedConditions.visibilityOf(myMenteesPage.getMyMenteesPageUniqueElement()));
		// Assert that the landing page element is displayed
		Assert.assertTrue(landingPageElement.isDisplayed(), "My Mentees page element not visible.");
	}

	@Test(priority = 12)
	public void verifyMyProjectsLinkTest() {
		homePage.clickMyProjectsMenuLink();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		WebElement landingPageElement = wait.until(ExpectedConditions.visibilityOf(myProjectsPage.getMyProjectsPageUniqueElement()));
		// Assert that the landing page element is displayed
		Assert.assertTrue(landingPageElement.isDisplayed(), "My Projects page element not visible.");
	}

	@Test(priority = 13)
	public void verifyProfileDetailsLinkTest() {
		homePage.clickProfileDetailsMenuLink();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		System.out.println("Profile Details dropdown is clicked successfully");
	}

	@Test(priority = 14)
	public void verifyMyProfileLinkTest() {
		homePage.clickProfileDetailsMenuLink();
		homePage.clickMyProfMenuLink();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		WebElement landingPageElement = wait.until(ExpectedConditions.visibilityOf(myProfilePage.getMyProfilePageUniqueElement()));
		// Assert that the landing page element is displayed
		Assert.assertTrue(landingPageElement.isDisplayed(), "My Profile page element not visible.");
	}

	@Test(priority = 15)
	public void verifyAcademicsLinkTest() {
		homePage.clickProfileDetailsMenuLink();
		homePage.clickAcademicsMenuLink();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		WebElement landingPageElement = wait.until(ExpectedConditions.visibilityOf(academicsPage.getAcademicsPageUniqueElement()));
		// Assert that the landing page element is displayed
		Assert.assertTrue(landingPageElement.isDisplayed(), "My Profile page element not visible.");
	}

	@Test(priority = 16)
	public void verifyMentorProfileLinkTest() {
		homePage.clickProfileDetailsMenuLink();
		homePage.clickMentorProfMenuLink();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		WebElement landingPageElement = wait.until(ExpectedConditions.visibilityOf(mentorProfilePage.getMentorProfilePageUniqueElement()));
		// Assert that the landing page element is displayed
		Assert.assertTrue(landingPageElement.isDisplayed(), "Mentor Profile page element not visible.");
	}

	@Test(priority = 17)
	public void verifyMenteeProfileLinkTest() {
		homePage.clickProfileDetailsMenuLink();
		homePage.clickMenteeProfMenuLink();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		WebElement landingPageElement = wait.until(ExpectedConditions.visibilityOf(menteeProfilePage.getMenteeProfilePageUniqueElement()));
		// Assert that the landing page element is displayed
		Assert.assertTrue(landingPageElement.isDisplayed(), "Mentee Profile page element not visible.");
	}

	@Test(priority = 18)
	public void verifyManageMyTeamLinkTest() {
		homePage.clickProfileDetailsMenuLink();
		homePage.clickManageMyTeamMenuLink();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		WebElement landingPageElement = wait.until(ExpectedConditions.visibilityOf(manageMyTeamPage.getManageMyTeamPageUniqueElement()));
		// Assert that the landing page element is displayed
		Assert.assertTrue(landingPageElement.isDisplayed(), "My Profile page element not visible.");
	}

	@Test(priority = 19)
	public void verifyExpandCollapseMenuTest() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		homePage.clickExpandCollapseMenuLink();
		homePage.clickExpandCollapseMenuLink();

		System.out.println("Exapand Collapse menu icon is clicked successfully");
	}

	@Test(priority = 20)
	public void verifyZigtalLogoVisibilityTest() {
		try {
			Thread.sleep(2000); // Sleep for 2 seconds
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		boolean isLogoVisible = homePage.isHomePageLogoVisible();
		Assert.assertTrue(isLogoVisible, "Zigtal logo is not visible on the Home page.");
	}

	@Test(priority = 21)
	public void verifyProgramNameVisibilityTest() {
		try {
			Thread.sleep(2000); // Sleep for 2 seconds
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		boolean isProgramNameVisible = homePage.isProgramNameVisible();

		Assert.assertTrue(isProgramNameVisible, "Program Name is not visible on the Home page.");
	}

	@Test(priority = 22)
	public void verifyProgramNameTest() {
		String expectedText = prop.getProperty("programNameText"); // Expected text from properties
		Assert.assertTrue(homePage.isProgramNameVisible(), "Program Name Text is not displayed");
		String actualText = homePage.getProgramNameText(); // Method to fetch the actual text
		Assert.assertEquals(actualText, expectedText, "Program Name Text does not match the expected value.");
		System.out.println("Program Name Text is displayed and verified successfully.");
	}

	@AfterMethod
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}
}