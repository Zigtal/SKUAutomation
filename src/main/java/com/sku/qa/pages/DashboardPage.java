
package com.sku.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sku.qa.base.TestBase;

public class DashboardPage extends TestBase {

	// Page Factory OR Object Repository
	@FindBy(xpath = "//p[text()='Dashboard']")
	WebElement dashboardPageElement;

	// Constructor
	public DashboardPage() {
		PageFactory.initElements(driver, this);
	}

	public WebElement getDashboardPageUniqueElement() {
		return dashboardPageElement;
	}

}
