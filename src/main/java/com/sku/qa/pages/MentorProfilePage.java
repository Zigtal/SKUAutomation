package com.sku.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sku.qa.base.TestBase;

public class MentorProfilePage extends TestBase {

	// Page Factory OR Object Repository
	@FindBy(xpath = "//p[text()='Mentor Profile']")
	WebElement mentorProfilePageElement;

	// Constructor
	public MentorProfilePage() {
		PageFactory.initElements(driver, this);
	}

	// Method to get the unique element (WebElement)
	public WebElement getMentorProfilePageUniqueElement() {
		return mentorProfilePageElement;
	}

}
