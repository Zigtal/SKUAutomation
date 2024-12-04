package com.sku.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sku.qa.base.TestBase;

public class GroupEngPage extends TestBase {

	// Page Factory OR Object Repository
	@FindBy(xpath = "//p[text()='Group Engagements']")
	WebElement groupEngPageElement;

	// Constructor
	public GroupEngPage() {
		PageFactory.initElements(driver, this);
	}

	// Method to get the unique element (WebElement)
	public WebElement getGroupEngPageUniqueElement() {
		return groupEngPageElement;
	}

}
