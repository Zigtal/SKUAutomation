package com.sku.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sku.qa.base.TestBase;

public class MySkillsPage extends TestBase {

	// Page Factory OR Object Repository
	@FindBy(xpath = "//p[@class='MuiTypography-root MuiTypography-body1 css-1emn403']")
	WebElement mySkillsPageElement;

	// Constructor
	public MySkillsPage() {
		PageFactory.initElements(driver, this);
	}

	// Method to get the unique element (WebElement)
	public WebElement getMySkillsPageUniqueElement() {
		return mySkillsPageElement;

	}

}
