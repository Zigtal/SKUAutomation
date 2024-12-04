package com.sku.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sku.qa.base.TestBase;

public class ManageMyTeamPage extends TestBase {

	// Page Factory OR Object Repository
	@FindBy(xpath = "//p[text()='Manage My Team']")
	WebElement manageMyTeamPageElement;

	// Constructor
	public ManageMyTeamPage() {
		PageFactory.initElements(driver, this);
	}

	// Method to get the unique element (WebElement)
	public WebElement getManageMyTeamPageUniqueElement() {
		return manageMyTeamPageElement;
	}

}
