package com.sku.qa.pages;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sku.qa.base.TestBase;

public class LoginPage extends TestBase {

	// Page Factory OR Object Repository
	@FindBy(id = ":r0:")
	WebElement email;

	@FindBy(id = ":r1:")
	WebElement password;

	@FindBy(xpath = "//button[text()='Login']")
	WebElement loginBtn;

	@FindBy(linkText = "Forgot Password?")
	WebElement forgotPwdLink;

	@FindBy(linkText = "Signup here")
	WebElement signUpHereLink;

	@FindBy(xpath = "//button[@type='button']")
	WebElement eyeBtn;

	@FindBy(xpath = "//img[@alt='logo']")
	WebElement loginPageLogo;

	@FindBy(xpath = "//p[contains(text(), 'Error in Authentication')]")
	WebElement errorMsg;

	// Initializing the Page Objects
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	// Actions:
	public String getLoginPageTitle() {
		return driver.getTitle();
	}

	public String getLoginPageUrl() {
		return driver.getCurrentUrl();
	}

	public boolean isLoginPageLogoVisible() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOf(loginPageLogo));
			return loginPageLogo.isDisplayed();
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
			return false;
		}
	}

	public WelcomePage isLoginPageLogoClickable() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(loginPageLogo));
			loginPageLogo.click();
			wait.until(ExpectedConditions.urlToBe(prop.getProperty("welcomePageUrl")));
		} catch (Exception e) {
			System.out.println("Error while clicking the logo: " + e.getMessage());
		}
		return new WelcomePage();
	}

	public HomePage login(String un, String pwd) {
		email.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.urlToBe(prop.getProperty("landingPageUrl")));
		return new HomePage();
	}

	public void invalidLogin(String invalidUn, String invalidPwd) {
		email.clear();
		password.clear();
		email.sendKeys(invalidUn);
		password.sendKeys(invalidPwd);
		loginBtn.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(errorMsg));
	}

	public WebElement getLoginErrorMessage() {
		return errorMsg;
	}

	public WebElement getEyeButton() {
		return eyeBtn;
	}

	public WebElement passwordField() {
		return password;
	}

	public String getPasswordFieldType() {
		return password.getAttribute("type");
	}

	// Method to toggle the password visibility
	public void togglePasswordVisibility() {
		// Ensure the eye button is clickable
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(eyeBtn)); // Wait until the eye button is clickable
		eyeBtn.click(); // Click to reveal password

		// Wait for the password field's type attribute to change to "text"
		wait.until(ExpectedConditions.attributeToBe(password, "type", "text")); // Wait for the password to be revealed

		// Click again to hide the password
		eyeBtn.click();

		// Wait for the password field's type attribute to change back to "password"
		wait.until(ExpectedConditions.attributeToBe(password, "type", "password")); // Wait for the password to be hidden again
	}

	public SignUpPage clickSignUpHereLinkOnSignUpPage() {
		signUpHereLink.click();
		return new SignUpPage();
	}

}
