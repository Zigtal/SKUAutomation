package com.sku.qa.pages;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sku.qa.base.TestBase;

public class FindMentorsPage extends TestBase {

	// Page Factory OR Object Repository
	@FindBy(xpath = "//p[text()='Find Mentors']")
	WebElement findMentorsPageElement;

	@FindBy(xpath = "//span[@class='MuiBadge-root css-chz7cr']//*[name()='svg']")
	WebElement advanceFilterIcon;

	// Constructor
	public FindMentorsPage() {
		PageFactory.initElements(driver, this);
	}

	// Wait for element method
	private WebElement waitForElement(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Adjust timeout as necessary
		return wait.until(ExpectedConditions.visibilityOf(element));
	}

	// Method to get the unique element (WebElement)
	public WebElement getFindMentorsPageUniqueElement() {
		return findMentorsPageElement;
	}

	public void clickAdvanceFilterIcon() {
		waitForElement(advanceFilterIcon).click();
	}
}
