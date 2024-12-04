package com.sku.qa.pages;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sku.qa.base.TestBase;

public class PolicyPage extends TestBase {

	// Page Factory OR Object Repository OR Page Factory

	@FindBy(xpath = "//a[@class='sc_layouts_logo sc_layouts_logo_default trx_addons_inline_1179813743']//img[@alt='Zigtal']")
	WebElement policyPageLogo;

	@FindBy(tagName = "h3")
	WebElement policyPageText;

	// Initializing the Page Objects
	public PolicyPage() {
		PageFactory.initElements(driver, this);
	}

	// Actions:
	public String getPolicyPageTitle() {
		return driver.getTitle();
	}

	public String getPolicyPageUrl() {
		return driver.getCurrentUrl();
	}

	public boolean isPolicyPageTextVisible() {
		return policyPageText.isDisplayed();
	}

	public String getPolicyPageText() {
		return policyPageText.getText();
	}

	public boolean isPolicyPageLogoVisible() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOf(policyPageLogo));
			return policyPageLogo.isDisplayed();
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
			return false;
		}
	}
}
