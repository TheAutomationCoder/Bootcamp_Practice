package com.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;







public class HomePage extends BasePage {

	
	//Constructor
	public HomePage(WebDriver driver) {
		super(driver);
		
	}
	
	//WebElement
		@FindBy(xpath="//span[normalize-space()='My Account']")
		WebElement lnkMyaccount;
		
		@FindBy(xpath="(//a[normalize-space()='Register'])[1]")
		WebElement lnkRegister;
		
		@FindBy(xpath="//a[normalize-space()='Login']")
		WebElement lnkLogin;
		
		@FindBy(xpath="//input[@name=\"search\"]")
		private WebElement searchTextBox;
		
		@FindBy(css = "button.btn.btn-default.btn-lg")
		private WebElement searchButton;
		
		
		//Action Methods
	public void clickMyAccount() {
		lnkMyaccount.click();
		
	}
  
	public void clickRegister() {
		lnkRegister.click();
		
	}
	
	public void clickLogin() {
		lnkLogin.click();
	}
	
	public void enterProduct(String ProductText) {
		searchTextBox.sendKeys(ProductText);
	}
	
	public ProductPage clickOnSearchButton() {
		searchButton.click();
		return new ProductPage(driver);
	}
	
}
