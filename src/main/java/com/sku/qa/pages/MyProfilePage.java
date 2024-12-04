package com.sku.qa.pages;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sku.qa.base.TestBase;

public class MyProfilePage extends TestBase {

	// Page Factory OR Object Repository
	@FindBy(xpath = "//p[text()='My Profile']")
	WebElement myProfilePageElement;

	@FindBy(xpath = "//button[text()='Edit']")
	WebElement editBtn;

	@FindBy(xpath = "//button[text()='Change Password']")
	WebElement changePwdBtn;

	@FindBy(xpath = "//button[text()='Basic Information']")
	WebElement basicInfoBtn;

	@FindBy(xpath = "//button[text()='Role & Manager Information']")
	WebElement roleManagerInfoBtn;

	@FindBy(xpath = "//button[text()='Cancel']")
	WebElement onEditCancelBtn;

	@FindBy(xpath = "//button[text()='Save']")
	WebElement onEditSaveBtn;

	@FindBy(xpath = "//button[text()='Change']")
	WebElement profilePicChangeBtn;

	@FindBy(xpath = "//button[text()='Remove']")
	WebElement profilePicRemoveBtn;

	@FindBy(xpath = "//span[text()='Function']")
	WebElement functionTag;

	@FindBy(xpath = "//span[text()='Sub Function']")
	WebElement subFunctionTag;

	@FindBy(xpath = "//span[text()='Role']")
	WebElement roleTag;

	@FindBy(xpath = "//span[text()='Phone Number']")
	WebElement phoneNumberTag;

	@FindBy(xpath = "//span[text()='Email Address']")
	WebElement emailAddressTag;

	@FindBy(xpath = "//span[text()='LinkedIn Profile']")
	WebElement linkedInProfileTag;

	@FindBy(xpath = "//span[text()='Manager Name']")
	WebElement managerNameTag;

	@FindBy(xpath = "//span[text()='Employee ID']")
	WebElement empIDTag;

	@FindBy(id = "firstName")
	WebElement firstNameTextField;

	@FindBy(id = "lastName")
	WebElement lastNameTextField;

	@FindBy(id = "workLocationId")
	WebElement locationDropdownField;

	@FindBy(id = "profileHeadline")
	WebElement profileHeadlineTextField;

	@FindBy(id = "profileSummary")
	WebElement profileSummaryTextField;

	@FindBy(id = "phoneNumber")
	WebElement phoneNumberTextField;

	@FindBy(id = "email")
	WebElement emailField;

	@FindBy(id = "urlLinkedIn")
	WebElement urlLinkedInTextField;

	@FindBy(id = "employeeId")
	WebElement employeeIdTextField;

	@FindBy(id = "firstName-helper-text")
	WebElement errMsgFirstNameField;

	@FindBy(id = "lastName-helper-text")
	WebElement errMsgLastNameField;

	@FindBy(id = "employeeId-helper-text")
	WebElement errMsgEmpIdField;

	@FindBy(id = "functionId")
	WebElement functionId;

	@FindBy(id = "subFunctionId")
	WebElement subFunctionId;

	@FindBy(id = "roleId")
	WebElement roleId;

	@FindBy(id = "managerEmailAddress")
	WebElement managerEmailAddress;

	@FindBy(id = "functionId-helper-text")
	WebElement errMsgFunctionId;

	@FindBy(id = "subFunctionId-helper-text")
	WebElement errMsgSubFunctionId;

	@FindBy(id = "roleId-helper-text")
	WebElement errMsgRoleId;

	// Constructor
	// Initializing the Page Objects:
	public MyProfilePage() {
		PageFactory.initElements(driver, this);
	}

	// Method to get the unique element (WebElement)
	public WebElement getMyProfilePageUniqueElement() {
		return myProfilePageElement;
	}

	// Wait for element method
	private WebElement waitForElement(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Adjust timeout as necessary
		return wait.until(ExpectedConditions.visibilityOf(element));
	}

	public String verifyMyProfilePageTitle() {
		return driver.getTitle();
	}

	public String verifyMyProfilePageUrl() {
		return driver.getCurrentUrl();
	}

	public void clickEditButton() {
		waitForElement(editBtn).click();
	}

	public void clickChangePasswordButton() {
		waitForElement(changePwdBtn).click();
	}

	public void clickRoleManagerInfoButton() {
		waitForElement(roleManagerInfoBtn).click();
	}

	public void clickBasicInfoButton() {
		waitForElement(basicInfoBtn).click();
	}

	public void clickOnEditCancelButton() {
		waitForElement(onEditCancelBtn).click();
	}

	public void clickOnEditSaveButton() {
		waitForElement(onEditSaveBtn).click();
	}

	public void clickProfilePicChangeButton() {
		waitForElement(profilePicChangeBtn).click();
	}

	public void clickProfilePicRemoveButton() {
		waitForElement(profilePicRemoveBtn).click();
	}

	// Method to enter data in mandatory fields
	public MyProfilePage enterMandatoryFieldDetails(String firstName, String lastName, String empID) {
		firstNameTextField.clear();
		firstNameTextField.sendKeys(firstName);
		lastNameTextField.clear();
		lastNameTextField.sendKeys(lastName);
		employeeIdTextField.clear();
		employeeIdTextField.sendKeys(empID);
		onEditSaveBtn.click();
		return new MyProfilePage();
	}

	// Method to get the unique element (WebElement)
	public WebElement getFunctionTag() {
		return functionTag;
	}

	// Method to get the unique element (WebElement)
	public WebElement getSubFunctionTag() {
		return subFunctionTag;
	}

	// Method to get the unique element (WebElement)
	public WebElement getRoleTag() {
		return roleTag;
	}

	// Method to get the unique element (WebElement)
	public WebElement getPhoneNumberTag() {
		return phoneNumberTag;
	}

	// Method to get the unique element (WebElement)
	public WebElement getEmailAddressTag() {
		return emailAddressTag;
	}

	// Method to get the unique element (WebElement)
	public WebElement getLinkedInProfileTag() {
		return linkedInProfileTag;
	}

	// Method to get the unique element (WebElement)
	public WebElement getManagerNameTag() {
		return managerNameTag;
	}

	// Method to get the unique element (WebElement)
	public WebElement getEmployeeIDTag() {
		return empIDTag;
	}

}
