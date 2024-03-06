package com.ninja.tutorials;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ninjatutorials.qa.utils.Utilits;
import com.tutorialsninja.base.Base;
import com.tutorialsninja.qa.page.AccountPage;
import com.tutorialsninja.qa.page.HomePage;
import com.tutorialsninja.qa.page.LoginPage;

public class LoginTest extends Base {
	public WebDriver drv;
	LoginPage loginPage;
	@Test(priority=1,dataProvider="logindata")
	public void loginWithValidCredentials(String userName, String password) {
		AccountPage accountPage = loginPage.login(userName, password);
		Assert.assertTrue(accountPage.getDisplayStatusOfEditYourAccountInformation());
		
	}
	@Test(priority=2)
	public void loginWithInvalidCredentials() {
		loginPage.login(Utilits.generateRandomEmail(), prop.getProperty("validPassword"));
		AssertJUnit.assertTrue(loginPage.getInvalidCredentialsValidationMsg().contains(dataprop.getProperty("expectedWarningMessage")));
	}
	@Test(priority=3)
	public void loginWithValidEmailAddressAndInvalidPassword() {
		loginPage.login(prop.getProperty("validEmail"), dataprop.getProperty("invalidPassword"));
		Assert.assertTrue(loginPage.getInvalidCredentialsValidationMsg().contains(dataprop.getProperty("expectedWarningMessage")));
		
		
	}
	@Test(priority=4)
	public void loginWithInvalidEmailAddressAndValidPassword() {
		loginPage.login(Utilits.generateRandomEmail(), prop.getProperty("validPassword"));
		Assert.assertTrue(loginPage.getInvalidCredentialsValidationMsg().contains(dataprop.getProperty("expectedWarningMessage")));
		
		
	}
	@Test(priority=5)
	public void LoginWithBlankCredentials() {
		
		
		loginPage.clickOnLoginButton();
		Assert.assertTrue(loginPage.getInvalidCredentialsValidationMsg().contains(dataprop.getProperty("expectedWarningMessage")));
		
		
	}
	
	
	
	@AfterMethod()
	public void tearDown() {
		drv.quit();
		
	}
	@BeforeMethod()
	public void setup() {
		
		drv = selectBrowserAndOpenBrowser(prop.getProperty("browser"));
		HomePage homePage = new HomePage(drv);
		loginPage = homePage.navigateToLoginPage();
		
	}
	public LoginTest() {
		super();
	}
	@DataProvider(name="logindata")
	public String[][] supplyTestData() {
		String[][] data = Utilits.getdataFromExcel("loginTestdata");
		return data;
	}

}
