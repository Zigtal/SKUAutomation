package com.sku.qa.pages;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sku.qa.base.TestBase;

public class WelcomePage extends TestBase {

	// Page Factory OR Object Repository OR Page Factory
	@FindBy(linkText = "LOGIN")
	WebElement loginBtnWlcmPage;

	@FindBy(linkText = "SIGNUP")
	WebElement signUpBtnWlcmPage;

	@FindBy(xpath = "//img[@alt='logo']")
	WebElement welcomePageLogo;

	@FindBy(tagName = "h1")
	WebElement wlcmPageText1;

	@FindBy(tagName = "p")
	WebElement wlcmPageText2;

	// Initializing the Page Objects
	public WelcomePage() {
		PageFactory.initElements(driver, this);
	}

	// Actions:
	public String getWelcomePageTitle() {
		return driver.getTitle();
	}

	public String getWelcomePageUrl() {
		return driver.getCurrentUrl();
	}

	public boolean isWelcomePageLogoVisible() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOf(welcomePageLogo));
			return welcomePageLogo.isDisplayed();
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
			return false;
		}
	}

	public LoginPage clickLoginBtnWlcmPage() {
		loginBtnWlcmPage.click();
		return new LoginPage();
	}

	public SignUpPage clickSignUpBtnWlcmPage() {
		signUpBtnWlcmPage.click();
		return new SignUpPage();
	}

	public boolean isWlcmPageText1Visible() {
		return wlcmPageText1.isDisplayed();
	}

	public String getWlcmPageText1() {
		return wlcmPageText1.getText();
	}

	public boolean isWlcmPageText2Visible() {
		return wlcmPageText2.isDisplayed();
	}

	public String getWlcmPageText2() {
		return wlcmPageText2.getText();
	}
}
