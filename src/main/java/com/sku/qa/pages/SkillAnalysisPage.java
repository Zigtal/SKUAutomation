package com.sku.qa.pages;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sku.qa.base.TestBase;

public class SkillAnalysisPage extends TestBase {

	// Page Factory OR Object Repository
	@FindBy(xpath = "//p[text()='Skill Analysis']")
	WebElement skillAnalysisPageElement;

	@FindBy(xpath = "//button[text()='My Current Role']")
	WebElement myCurrentRoleTab;

	@FindBy(xpath = "//button[text()='My Aspirational Roles']")
	WebElement myAspirationalRolesTab;

	@FindBy(xpath = "//button[text()='Suitable Role for Me']")
	WebElement suitableRoleForMeTab;

	@FindBy(xpath = "//button[text()='Match Against Any Role']")
	WebElement matchAgainstAnyRoleTab;

	@FindBy(linkText = "FIND MENTORS")
	WebElement findMentorsLink;

	@FindBy(xpath = "//button[text()='Add Aspiration Role']")
	WebElement addAspirationRoleBtn;

	@FindBy(id = "jr-ac")
	WebElement aspirationDropdownField;

	@FindBy(xpath = "//button[text()='Save']")
	WebElement saveBtnOnAddAspirationPage;

	@FindBy(xpath = "//button[text()='Cancel']")
	WebElement cancelBtnOnAddAspirationPage;

	@FindBy(tagName = "p")
	WebElement warningMsg;

	// Constructor
	public SkillAnalysisPage() {
		PageFactory.initElements(driver, this);
	}

	// Wait for element method
	private WebElement waitForElement(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Adjust timeout as necessary
		return wait.until(ExpectedConditions.visibilityOf(element));
	}

	// Method to get the unique element (WebElement)
	public WebElement getMySkillsPageUniqueElement() {
		return skillAnalysisPageElement;
	}

	public void clickMyCurrentRoleTab() {
		waitForElement(myCurrentRoleTab).click();
	}

	public void clickMyAspirationalRolesTab() {
		waitForElement(myAspirationalRolesTab).click();
	}

	public void clickSuitableRoleForMeTab() {
		waitForElement(suitableRoleForMeTab).click();
	}

	public void clickMatchAgainstAnyRoleTab() {
		waitForElement(matchAgainstAnyRoleTab).click();
	}

	public void clickFindMentorsLink() {
		waitForElement(findMentorsLink).click();
	}

	public void clickAddAspirationRoleBtnLink() {
		waitForElement(addAspirationRoleBtn).click();
	}

	public void clickSaveBtnOnAddAspirationPage() {
		waitForElement(saveBtnOnAddAspirationPage).click();
	}

	public void clickCancelBtnOnAddAspirationPage() {
		waitForElement(cancelBtnOnAddAspirationPage).click();
	}

	public void warningMsgOnAddAspirationPage() {
		aspirationDropdownField.clear();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(warningMsg));
	}

	public WebElement getWarningMsg() {
		return warningMsg;
	}
}
