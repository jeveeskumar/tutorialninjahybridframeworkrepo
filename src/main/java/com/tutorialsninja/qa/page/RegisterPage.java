package com.tutorialsninja.qa.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
	WebDriver driver;
	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
@FindBy(xpath="//input[@name='firstname']")
	private WebElement firstName;
	@FindBy(xpath="//input[@name='lastname']")
	private WebElement lastName;
	@FindBy(xpath="//input[@name='email']")
	private WebElement email;
	@FindBy(xpath="//input[@name='telephone']")
	private WebElement telephone;
	@FindBy(xpath="//input[@name='password']")
	private WebElement password;
	@FindBy(xpath="//input[@name='confirm']")
	private WebElement confirmPassword;
	@FindBy(xpath="//input[@name='agree']")
	private WebElement agreeOption;
	@FindBy(xpath="//input[@value='Continue']")
	private WebElement continueButton;
	@FindBy(xpath="//input[@name='newsletter' and @value='1']")
	private WebElement newsletter;
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")
	private WebElement emailAlreadyExistsMsg;
	@FindBy(xpath="//input[@name='firstname']/following-sibling::div[@class='text-danger']")
	private WebElement firstNameErrorMsg;
	@FindBy(xpath="//input[@name='lastname']/following-sibling::div[@class='text-danger']")
	private WebElement lastNameErrorMsg;
	@FindBy(xpath="//input[@name='email']/following-sibling::div[@class='text-danger']")
	private WebElement emailErrorMsg;
	@FindBy(xpath="//input[@name='telephone']/following-sibling::div[@class='text-danger']")
	private WebElement telephoneErrorMsg;
	@FindBy(xpath="//input[@name='password']/following-sibling::div[@class='text-danger']")
	private WebElement passwordErrorMsg;
	@FindBy(xpath="//div[contains(@class,'alert-dismis')]")
	private WebElement privacyPolicyErrorMsg;
	
	public String getEmailAlreadyExistsMsg() {
		return emailAlreadyExistsMsg.getText();
	}
	public String getFirstNameErrorMsg() {
		return firstNameErrorMsg.getText();
	}
	public String getLastNameErrorMsg() {
		return lastNameErrorMsg.getText();
	}
	public String getEmailErrorMsg() {
		return emailErrorMsg.getText();
	}
	public String getTelephoneErrorMsg() {
		return telephoneErrorMsg.getText();
	}
	public String getpasswordErrorMsg() {
		return passwordErrorMsg.getText();
	}
	public String getprivacyPolicyErrorMsg() {
		return privacyPolicyErrorMsg.getText();
	}
	public AccountSuccessPage registerWithMandatoryFields(String firstname, String lastname, String emailaddress, String telephoneNumber,String passwordInput, String confirmPasswordInput) {
		firstName.sendKeys(firstname);
		lastName.sendKeys(lastname);
		email.sendKeys(emailaddress);
		telephone.sendKeys(telephoneNumber);
		password.sendKeys(passwordInput);
		confirmPassword.sendKeys(confirmPasswordInput);
		agreeOption.click();
		continueButton.click();
		return new AccountSuccessPage(driver);
	}
	public AccountSuccessPage registerWithAllFields(String firstname, String lastname, String emailaddress, String telephoneNumber,String passwordInput, String confirmPasswordInput) {
		firstName.sendKeys(firstname);
		lastName.sendKeys(lastname);
		email.sendKeys(emailaddress);
		telephone.sendKeys(telephoneNumber);
		password.sendKeys(passwordInput);
		confirmPassword.sendKeys(confirmPasswordInput);
		newsletter.click();
		agreeOption.click();
		continueButton.click();
		return new AccountSuccessPage(driver);
	}
	public void clickOncontinueButton() {
		continueButton.click();
		
	}
	public boolean displayStatusofWarningMessages(String expectedFirstName, String expectedLastName, String expectedEmail, String expectedTelephone, String exceptedPassword,String expectedPrivacypolicy) {
		boolean firstNamecheck = expectedFirstName.contains(firstNameErrorMsg.getText());
		boolean lastNamecheck = expectedLastName.contains(lastNameErrorMsg.getText());
		boolean Emailcheck = expectedEmail.contains(emailErrorMsg.getText());
		boolean TelephoneCheck = expectedTelephone.contains(telephoneErrorMsg.getText());
		boolean passwordCheck = exceptedPassword.contains(passwordErrorMsg.getText());
		boolean privacyPolicyCheck = expectedPrivacypolicy.contains(privacyPolicyErrorMsg.getText());
		return firstNamecheck && lastNamecheck && Emailcheck && TelephoneCheck && passwordCheck && privacyPolicyCheck;
	}
}
	
	
	
	

