package com.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
	
	//Constructor
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	//WebElement
	
	
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement txt_Email;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement txt_Password;
	
	@FindBy(xpath="//input[@value='Login']")
	WebElement btn_Login;
	
	@FindBy(linkText="Logout")
	WebElement btn_Logout;
	
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")
	WebElement warningmsg;
	
	
	//Action Method
	
	public void Email(String email) {
		txt_Email.sendKeys(email);
	}
	
	public void Password(String password) {
		txt_Password.sendKeys(password);
	}
	
	public void ClickOnLogin() {
		btn_Login.click();
	}	
		
	public boolean LogoutbtnisPresent() {
		boolean status = btn_Logout.isDisplayed();
		return status;
	}
	
	public String WarningmsgisDisplayd() {
	try {
		return(warningmsg.getText());
	}
		catch(Exception e) {
			return(e.getMessage());
		} 
	}
	
	public void ClickOnLogOut() {
		btn_Logout.click();
	}

}
	

