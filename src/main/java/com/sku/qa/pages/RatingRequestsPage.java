package com.sku.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sku.qa.base.TestBase;

public class RatingRequestsPage extends TestBase {

	// Page Factory OR Object Repository
	@FindBy(xpath = "//p[text()='People requested to rate skills']")
	WebElement ratingRequestsPageElement;

	// Constructor
	public RatingRequestsPage() {
		PageFactory.initElements(driver, this);
	}

	// Method to get the unique element (WebElement)
	public WebElement getRatingRequestsPageUniqueElement() {
		return ratingRequestsPageElement;

	}
}
