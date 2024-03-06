package com.tutorialsninja.qa.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {
	
	WebDriver driver;
	public SearchPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[contains(text(),'HP LP30651')]")
	private WebElement validProduct;
	@FindBy(xpath="//div[@id='content']/p[2]")
	private WebElement invalidProductErrorMsg;
	//adding comment in search pom
	
	
	public boolean getValidProductNameDisplayed() {
		 return validProduct.isDisplayed();
	}
	public String getinvalidProductErrorMsg() {
		 return invalidProductErrorMsg.getText();
	}

}
