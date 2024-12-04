package com.sku.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sku.qa.base.TestBase;

public class MyMentorsPage extends TestBase {

	// Page Factory OR Object Repository
	@FindBy(xpath = "//p[text()='My Mentors']")
	WebElement myMentorsPageElement;

	// Constructor
	public MyMentorsPage() {
		PageFactory.initElements(driver, this);
	}

	// Method to get the unique element (WebElement)
	public WebElement getMyMentorsPageUniqueElement() {
		return myMentorsPageElement;
	}

}
