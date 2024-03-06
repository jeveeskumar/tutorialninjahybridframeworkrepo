package com.tutorialsninja.qa.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage {
	WebDriver driver;
	@FindBy(xpath="//a[contains(text(),'account information')]")
	private WebElement EdityourAccountInformation;
	public AccountPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public boolean getDisplayStatusOfEditYourAccountInformation() {
		boolean editYourAccountInformation = EdityourAccountInformation.isDisplayed();
		return editYourAccountInformation;
	}
	
	

}
