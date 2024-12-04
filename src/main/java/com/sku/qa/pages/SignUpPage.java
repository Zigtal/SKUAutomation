package com.sku.qa.pages;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sku.qa.base.TestBase;

public class SignUpPage extends TestBase {

	// Page Factory OR Object Repository

	@FindBy(xpath = "//img[@alt='logo']")
	WebElement signUpPageLogo;

	@FindBy(tagName = "h1")
	WebElement signUpPageText1;

	@FindBy(tagName = "p")
	WebElement signUpPageText2;

	@FindBy(xpath = "//label[@class='MuiFormLabel-root MuiFormLabel-colorPrimary Mui-required css-1cailrh']")
	WebElement emailFieldName;

	@FindBy(id = ":r0:")
	WebElement email;

	@FindBy(xpath = "//input[@type='checkbox']")
	WebElement checkbox;

	@FindBy(xpath = "//span[@class='MuiTypography-root MuiTypography-body1 MuiFormControlLabel-label css-1an67pf']//span[1]")
	WebElement declarationLine;

	@FindBy(xpath = "//a[normalize-space()='Zigtal Policies']")
	WebElement zigtalPoliciesLink;

	@FindBy(xpath = "//button[text()='Send OTP']")
	WebElement sendOTPBtn;

	@FindBy(xpath = "//p[@class='MuiTypography-root MuiTypography-body1 css-1owrzqw']")
	WebElement signUpPageText3;

	@FindBy(xpath = "//a[text()='login here']")
	WebElement loginHereLink;

	@FindBy(xpath = "//div[@class='MuiBox-root css-1kpnfgz']//*[name()='svg']")
	WebElement signUpPageImage;

	@FindBy(xpath = "//p[text()='Email is mandatory']")
	WebElement errMsg1;

	@FindBy(xpath = "//p[text()='Invalid email address']")
	WebElement errMsg2;

	@FindBy(xpath = "//p[text()='User Already Registered']")
	WebElement errMsg3;

	@FindBy(xpath = "//p[text()='Not Authorized to register']")
	WebElement errMsg4;

	// Initializing the Page Objects
	public SignUpPage() {
		PageFactory.initElements(driver, this);
	}

	// Actions:
	public String getSignUpPageTitle() {
		return driver.getTitle();
	}

	public String getSignUpPageUrl() {
		return driver.getCurrentUrl();
	}

	public boolean isSignUpPageLogoVisible() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOf(signUpPageLogo));
			return signUpPageLogo.isDisplayed();
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
			return false;
		}
	}

	public WelcomePage isSignUpPageLogoClickable() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(signUpPageLogo));
			signUpPageLogo.click();
			wait.until(ExpectedConditions.urlToBe(prop.getProperty("welcomePageUrl")));
		} catch (Exception e) {
			System.out.println("Error while clicking the logo: " + e.getMessage());
		}
		return new WelcomePage();
	}

	public void errMsgEmailIsMandatory() {
		email.clear();
		checkbox.click();
		sendOTPBtn.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(errMsg1));
	}

	public WebElement geterrMsg1() {
		return errMsg1;
	}

	public void errMsgInvalidEmailAddress(String invalidEmailAddressEmailId) {
		email.clear();
		email.sendKeys(invalidEmailAddressEmailId);
		checkbox.click();
		sendOTPBtn.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(errMsg2));
	}

	public WebElement geterrMsg2() {
		return errMsg2;
	}

	public void errMsgUserAlreadyReg(String userAlreadyRegEmailId) {
		email.clear();
		email.sendKeys(userAlreadyRegEmailId);
		checkbox.click();
		sendOTPBtn.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(errMsg3));
	}

	public WebElement geterrMsg3() {
		return errMsg3;
	}

	public void errMsgNotAutorizedToReg(String notAuthorizedToRegEmailId) {
		email.clear();
		email.sendKeys(notAuthorizedToRegEmailId);
		checkbox.click();
		sendOTPBtn.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(errMsg4));
	}

	public WebElement geterrMsg4() {
		return errMsg4;
	}

	public boolean isSignUpPageText1Visible() {
		return signUpPageText1.isDisplayed();
	}

	public String getSignUpPageText1() {
		return signUpPageText1.getText();
	}

	public boolean isSignUpPageText2Visible() {
		return signUpPageText2.isDisplayed();
	}

	public String getSignUpPageText2() {
		return signUpPageText2.getText();
	}

	public boolean isSignUpPageText3Visible() {
		return signUpPageText3.isDisplayed();
	}

	public String getSignUpPageText3() {
		return signUpPageText3.getText();
	}

	public boolean isEmailFieldNameWithAsteriskVisible() {
		return emailFieldName.isDisplayed();
	}

	public String getEmailFieldNameWithAsterisk() {
		return emailFieldName.getText();
	}

	public boolean isSignUpPageImageVisible() {
		return signUpPageImage.isDisplayed();
	}

	public PolicyPage clickZigtalPoliciesLink() {
		zigtalPoliciesLink.click();
		return new PolicyPage();
	}

	public LoginPage clickLoginHereLinkOnSignUpPage() {
		loginHereLink.click();
		return new LoginPage();
	}
}
