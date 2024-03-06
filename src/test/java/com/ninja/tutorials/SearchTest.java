package com.ninja.tutorials;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsninja.base.Base;
import com.tutorialsninja.qa.page.HomePage;
import com.tutorialsninja.qa.page.LoginPage;
import com.tutorialsninja.qa.page.SearchPage;

public class SearchTest extends Base {
	public WebDriver drv;
	HomePage homePage;
	SearchPage searchPage;
	@BeforeMethod
	public void Setup() {
		drv = selectBrowserAndOpenBrowser(prop.getProperty("browser"));
		homePage = new HomePage(drv);
		LoginPage loginpage = homePage.navigateToLoginPage();
		loginpage.enterEmailAddress(prop.getProperty("validEmail"));
		loginpage.enterPassword(prop.getProperty("validPassword"));
		loginpage.clickOnLoginButton();
	}

	@AfterMethod()
	public void tearDown() {
		drv.quit();
	}
	@Test(priority=1)
	public void verifySearchWithValidProduct() {
		searchPage = homePage .searchForAProduct(dataprop.getProperty("validProduct"));
		Assert.assertTrue(searchPage.getValidProductNameDisplayed(),"valid search product HP is not displayed");
		
	}
	@Test(priority=2,dependsOnMethods={"verifySearchWithValidProduct"})
	public void verifySearchWithInvalidProduct() {
		searchPage = homePage .searchForAProduct(dataprop.getProperty("invalidProduct"));
		Assert.assertTrue(searchPage.getinvalidProductErrorMsg().contains(dataprop.getProperty("noProductFoundMsg")),"invalid product validation message is not displayed");
		
	}
	public SearchTest() {
		super();
	}

}
