package com.ninja.tutorials;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ninjatutorials.qa.utils.Utilits;
import com.tutorialsninja.base.Base;
import com.tutorialsninja.qa.page.AccountSuccessPage;
import com.tutorialsninja.qa.page.HomePage;
import com.tutorialsninja.qa.page.RegisterPage;

public class RegisterTest extends Base {
	public WebDriver drv;
	RegisterPage register;
	AccountSuccessPage accountSuccess;
	@BeforeMethod()
	public void setup() {
		
		drv = selectBrowserAndOpenBrowser(prop.getProperty("browser"));
		HomePage homePage = new HomePage(drv);
		register = homePage.navigateToRegisterPage();
		
	}
	
	@AfterMethod()
	public void tearDown() {
		drv.quit();
		
	}
	@Test(priority=1)
	public void registerWithOnlyMandatoryFields() {
		accountSuccess = register.registerWithMandatoryFields(dataprop.getProperty("firstName"), dataprop.getProperty("lastName"), Utilits.generateRandomEmail(), dataprop.getProperty("telephoneNumber"), prop.getProperty("validPassword"), prop.getProperty("validPassword"));
		Assert.assertTrue(accountSuccess.getAccountCreatedMsg().contains(dataprop.getProperty("AccountCreatedMsg")),"account creation success message is not displayed");
	}
	@Test(priority=2)
	public void registerWithAllFields() {
		accountSuccess = register.registerWithAllFields(dataprop.getProperty("firstName"), dataprop.getProperty("lastName"), Utilits.generateRandomEmail(), dataprop.getProperty("telephoneNumber"), prop.getProperty("validPassword"), prop.getProperty("validPassword"));
		Assert.assertTrue(accountSuccess.getAccountCreatedMsg().contains(dataprop.getProperty("AccountCreatedMsg")),"account creation success message is not displayed");
		
		
		
	}
	@Test(priority=3)
	public void registerWithExistingEmailAddress() {
		register.registerWithMandatoryFields(dataprop.getProperty("firstName"), dataprop.getProperty("lastName"), prop.getProperty("validEmail"), dataprop.getProperty("telephoneNumber"), prop.getProperty("validPassword"), prop.getProperty("validPassword"));
		Assert.assertTrue(register.getEmailAlreadyExistsMsg().contains(dataprop.getProperty("emailAlreadyExistsMsg")),"email address already exists warning message is not displayed");
	}
	@Test(priority=4)
	public void registerWithoutFillingAnyDetails() {
		register.clickOncontinueButton();
		Assert.assertTrue(register.displayStatusofWarningMessages(dataprop.getProperty("firstNameValidationMsg"), dataprop.getProperty("lastNameValidationMsg"), dataprop.getProperty("emailValidationMsg"), dataprop.getProperty("telephoneNumberValidationMsg"), dataprop.getProperty("passwordValidationMsg"), dataprop.getProperty("privacyPolicyValidationMsg")),"Mandatory fields warning Message(s) is not displayed");
	}
	
	public RegisterTest() {
		super();
	}

}
