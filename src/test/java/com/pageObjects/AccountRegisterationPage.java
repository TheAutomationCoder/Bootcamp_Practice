package com.pageObjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;



public class AccountRegisterationPage extends BasePage {
	

	
	//Constructor
	
	public AccountRegisterationPage(WebDriver driver){
		super(driver);	
	}
	
	//WebElement

	@FindBy(xpath="//input[@name=\"firstname\"]")
	WebElement txt_firstname;
	
	@FindBy(xpath="//input[@name=\"lastname\"]")
	WebElement txt_lastname;
	
	@FindBy(xpath="//input[@name=\"email\"]")
	WebElement txt_Email;
	
	@FindBy(xpath="//input[@name=\"telephone\"]")
	WebElement txt_telephone;
	
	@FindBy(xpath="//input[@name=\"password\"]")
	WebElement txt_password;
	
	@FindBy(xpath="//input[@name=\"confirm\"]")
	WebElement txt_confirmpassword;
	
	@FindBy(xpath="(//input[@name='newsletter'])[1]")
	WebElement YesSubscributeRadioButton;
	
    @FindBy(xpath="//input[@name=\"agree\"]")
    WebElement privacyPolicyCheckbox;
    
    @FindBy(css = "input.btn.btn-primary")
    WebElement  btn_continue;
    
    @FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
    WebElement	msgConfirmation;
    
    @FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")
	WebElement actualEmailWarningMessage;
    
    @FindBy(xpath="//div[@class='text-danger']")
	WebElement incorrectpassword;
    
    @FindBy(xpath="//div[contains(text(),'First Name must be between 1 and 32 characters!')]")
    WebElement   firstnamewarning  ;
    
    @FindBy(xpath="//div[contains(text(),'Last Name must be between 1 and 32 characters!')]")
    WebElement    lastnamewarning ;
    
    @FindBy(xpath="//div[contains(text(),'E-Mail Address does not appear to be valid!')]")
    WebElement    emailwarning ;
    
    @FindBy(xpath="//div[contains(text(),'Telephone must be between 3 and 32 characters!')]")
    WebElement    telephonewarning ;
    
    @FindBy(xpath="//div[contains(text(),'Password must be between 4 and 20 characters!')]")
    WebElement   passwardwarning  ;
    
	//Action method
	
	public void Firstname(String firstName ) {
		
		txt_firstname.sendKeys(firstName);
	}
	
	public void Lastname(String lastName) {
		
		txt_lastname.sendKeys(lastName);
	}
	
	public void Email(String email) {
		
		txt_Email.sendKeys(email);
	}
	
	public void Telephone(String telephone) {
		
		txt_telephone.sendKeys(telephone);
	}
	
	public void Password(String password) {
		
		txt_password.sendKeys(password);
	}
	
	public void ConfirmPassword(String confirmpassword) {
		
		txt_confirmpassword.sendKeys(confirmpassword);
		
	}
	
	public void SubscribeYesRediobutton() {
		
		YesSubscributeRadioButton.click();
	}
	
	public void PrivacyPolicybutton() {
		
		privacyPolicyCheckbox.click();
		
	}
	
	public void ClickonContinue() {
		
		
		btn_continue.click();
	}
	
	public String getConfirmationMsg()  {
		try {
			return(msgConfirmation.getText());
		}
			catch(Exception e) {
				return(e.getMessage());
			
		}
	}
	
	public String emailwarningmsg() {
		String status = actualEmailWarningMessage.getText();
		return status;
	}
	
	public boolean incorrectpasswordAlert() {
		boolean displayStatus = incorrectpassword.isDisplayed();
		return displayStatus;
	}
	
	
	public boolean  displayStatusOfFirstname() {
		boolean  displayStatus = firstnamewarning.isDisplayed();
		return    displayStatus;
	}
	
	public boolean   displayStatusOfLastname() {
		boolean  displayStatus = lastnamewarning.isDisplayed();
		return displayStatus;
	}
	
	public boolean   displayStatusOfEmail() {
		boolean  displayStatus = emailwarning.isDisplayed();
		return   displayStatus;
	}
	
	public boolean   displayStatusOfTelephone() {
		boolean  displayStatus = telephonewarning.isDisplayed();
		return displayStatus;
	}
	
	public boolean   displayStatusOfPassword() {
		boolean  displayStatus =passwardwarning.isDisplayed();
		return displayStatus;
	}


}
