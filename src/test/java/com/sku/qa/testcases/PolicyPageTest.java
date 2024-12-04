package com.sku.qa.testcases;

import java.time.Duration;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;

import com.sku.qa.base.TestBase;
import com.sku.qa.pages.FindMentorsPage;
import com.sku.qa.pages.HomePage;
import com.sku.qa.pages.LoginPage;
import com.sku.qa.pages.SignUpPage;
import com.sku.qa.pages.WelcomePage;

public class PolicyPageTest extends TestBase {

	WelcomePage welcomePage;
	LoginPage loginPage;
	SignUpPage signUpPage;
	HomePage homePage;
	FindMentorsPage findMentorsPage;
	WebDriverWait wait;

	public PolicyPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Initialize wait in setup
		welcomePage = new WelcomePage();
		loginPage = new LoginPage();
		homePage = new HomePage();
		findMentorsPage = new FindMentorsPage();
		loginPage = welcomePage.clickLoginBtnWlcmPage();

	}

}
