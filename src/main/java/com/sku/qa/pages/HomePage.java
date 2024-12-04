package com.sku.qa.pages;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sku.qa.base.TestBase;

public class HomePage extends TestBase {

	@FindBy(xpath = "//div[@class='MuiBox-root css-1ykdma4']/a")
	WebElement homePageLogo;

	@FindBy(xpath = "//button[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-edgeEnd MuiIconButton-sizeMedium css-10im2rk']")
	WebElement expandCollapseMenuLink;

	@FindBy(xpath = "//span[text()='Dashboard']")
	WebElement dashboardMenuLink;

	@FindBy(xpath = "//span[text()='Skills']")
	WebElement skillsMenuLink;

	@FindBy(xpath = "//span[text()='My Skills ']")
	WebElement mySkillsMenuLink;

	@FindBy(xpath = "//span[text()='Skill Analysis ']")
	WebElement skillAnalysisMenuLink;

	@FindBy(xpath = "//span[text()='Rating Requests ']")
	WebElement ratingRequestsMenuLink;

	@FindBy(xpath = "//span[text()='Group Engagements']")
	WebElement groupEngMenuLink;

	@FindBy(xpath = "//span[text()='Mentoring']")
	WebElement mentoringMenuLink;

	@FindBy(xpath = "//span[text()='Find Mentors ']")
	WebElement findMentorsMenuLink;

	@FindBy(xpath = "//span[text()='My Mentors ']")
	WebElement myMentorsMenuLink;

	@FindBy(xpath = "//span[text()='My Mentees ']")
	WebElement myMenteesMenuLink;

	@FindBy(xpath = " //span[text()='My Projects']")
	WebElement myProjectsMenuLink;

	@FindBy(xpath = "//span[text()='Profile Details']")
	WebElement profileDetailsMenuLink;

	@FindBy(xpath = "//span[text()='My Profile ']")
	WebElement myProfMenuLink;

	@FindBy(xpath = "//span[text()='Academics ']")
	WebElement academicsMenuLink;

	@FindBy(xpath = "//span[text()='Mentor Profile ']")
	WebElement mentorProfMenuLink;

	@FindBy(xpath = "//span[text()='Mentee Profile ']")
	WebElement menteeProfMenuLink;

	@FindBy(xpath = "//span[text()='Manage My Team']")
	WebElement manageMyTeamMenuLink;

	@FindBy(xpath = "//div[@class='css-gkx0rl']")
	WebElement programName;

	// Initializing the Page Objects:
	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	// Wait for element method
	private WebElement waitForElement(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Adjust timeout as necessary
		return wait.until(ExpectedConditions.visibilityOf(element));
	}

	public String verifyHomePageTitle() {
		return driver.getTitle();
	}

	public String verifyHomePageUrl() {
		return driver.getCurrentUrl();
	}

	public boolean isHomePageLogoVisible() {
		return homePageLogo.isDisplayed();
	}

	public DashboardPage clickHomePageLogo() {
		waitForElement(homePageLogo).click();
		return new DashboardPage();
	}

	public void clickExpandCollapseMenuLink() {
		waitForElement(expandCollapseMenuLink).click();
	}

	public DashboardPage clickDashboardMenuLink() {
		waitForElement(dashboardMenuLink).click();
		return new DashboardPage();
	}

	public void clickSkillsMenuLink() {
		waitForElement(skillsMenuLink).click();
	}

	public MySkillsPage clickMySkillsMenuLink() {
		waitForElement(mySkillsMenuLink).click();
		return new MySkillsPage();
	}

	public SkillAnalysisPage clickSkillAnalysisMenuLink() {
		waitForElement(skillAnalysisMenuLink).click();
		return new SkillAnalysisPage();
	}

	public RatingRequestsPage clickRatingRequestsMenuLink() {
		waitForElement(ratingRequestsMenuLink).click();
		return new RatingRequestsPage();
	}

	public GroupEngPage clickGroupEngMenuLink() {
		waitForElement(groupEngMenuLink).click();
		return new GroupEngPage();
	}

	public void clickMentoringMenuLink() {
		waitForElement(mentoringMenuLink).click();
	}

	public FindMentorsPage clickFindMentorsMenuLink() {
		waitForElement(findMentorsMenuLink).click();
		return new FindMentorsPage();
	}

	public MyMentorsPage clickMyMentorsMenuLink() {
		waitForElement(myMentorsMenuLink).click();
		return new MyMentorsPage();
	}

	public MyMenteesPage clickMyMenteesMenuLink() {
		waitForElement(myMenteesMenuLink).click();
		return new MyMenteesPage();
	}

	public MyProjectsPage clickMyProjectsMenuLink() {
		waitForElement(myProjectsMenuLink).click();
		return new MyProjectsPage();
	}

	public void clickProfileDetailsMenuLink() {
		waitForElement(profileDetailsMenuLink).click();
	}

	public MyProfilePage clickMyProfMenuLink() {
		waitForElement(myProfMenuLink).click();
		return new MyProfilePage();
	}

	public AcademicsPage clickAcademicsMenuLink() {
		waitForElement(academicsMenuLink).click();
		return new AcademicsPage();
	}

	public MentorProfilePage clickMentorProfMenuLink() {
		waitForElement(mentorProfMenuLink).click();
		return new MentorProfilePage();

	}

	public MenteeProfilePage clickMenteeProfMenuLink() {
		waitForElement(menteeProfMenuLink).click();
		return new MenteeProfilePage();
	}

	public ManageMyTeamPage clickManageMyTeamMenuLink() {
		waitForElement(manageMyTeamMenuLink).click();
		return new ManageMyTeamPage();
	}

	public boolean isProgramNameVisible() {
		return programName.isDisplayed();
	}

	public String getProgramNameText() {
		return programName.getText();
	}

}
