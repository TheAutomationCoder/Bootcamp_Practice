package com.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage extends BasePage{

	//Constructor
  public ProductPage(WebDriver driver) {
	super(driver);
}
	//WebElement
	@FindBy(linkText = "HP LP3065")
	private WebElement HPLaptop;
	
	@FindBy(xpath = "//p[text() = 'There is no product that matches the search criteria.']")
	private WebElement productWarning;
	
	
	
	
	//Action Method
	public boolean displayStatusOfHPLaptop() {
		boolean status = HPLaptop.isDisplayed();
		return status;
	}
	
	public String displayStatusOfWarningMessage() {
		String status = productWarning.getText();
		return status;
	}

}
