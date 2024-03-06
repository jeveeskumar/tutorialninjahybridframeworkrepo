package com.tutorialsninja.qa.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;
	@FindBy(xpath="//a[@title='My Account']")
	private WebElement myAccountDropMenu;
	@FindBy(xpath="//a[text()='Login']")
	private WebElement loginOption;
	@FindBy(xpath="//a[text()='Register']")
	private WebElement registerOption;
	@FindBy(xpath="//input[@name='search']")
	private WebElement SearchBox;
	@FindBy(xpath="//button[@class='btn btn-default btn-lg']")
	private WebElement SearchButton;
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public LoginPage navigateToLoginPage() {
		myAccountDropMenu.click();
		loginOption.click();
		return new LoginPage(driver);
	}
	public RegisterPage navigateToRegisterPage() {
		myAccountDropMenu.click();
		registerOption.click();
		return new RegisterPage(driver);
	}
	
	public SearchPage searchForAProduct(String productText) {
		SearchBox.sendKeys(productText);
		SearchButton.click();
		return new SearchPage(driver);
	}

}
