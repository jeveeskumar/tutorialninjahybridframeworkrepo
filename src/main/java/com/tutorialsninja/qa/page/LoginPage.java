package com.tutorialsninja.qa.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//input[@id='input-email']")
	private WebElement emailInput;
	@FindBy(xpath="//input[@id='input-password']")
	private WebElement passwordInput;
	@FindBy(xpath="//input[@value='Login']")
	private WebElement loginButton;
	@FindBy(xpath="//div[contains(@class,'alert')]")
	private WebElement invalidCredentialsValidationMsg;
	
	public void enterEmailAddress(String emailtext) {
		emailInput.sendKeys(emailtext);
	}
	public void enterPassword(String passwordtext) {
		passwordInput.sendKeys(passwordtext);
	}
	public AccountPage clickOnLoginButton() {
		loginButton.click();
		return new AccountPage(driver);
	}
	
	public String getInvalidCredentialsValidationMsg() {
		return invalidCredentialsValidationMsg.getText();
	}
	public AccountPage login(String email,String password) {
		emailInput.sendKeys(email);
		passwordInput.sendKeys(password);
		loginButton.click();
		return new AccountPage(driver);
	}
	
	

}
