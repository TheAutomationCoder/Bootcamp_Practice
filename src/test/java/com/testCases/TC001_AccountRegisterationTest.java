package com.testCases;


import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.pageObjects.AccountRegisterationPage;
import com.pageObjects.HomePage;
import com.testBase.BaseClass;
@Listeners(com.Listeners.BootcampFrameworkListeners.class)class TC001_AccountRegisterationTest extends BaseClass  {
	public TC001_AccountRegisterationTest() throws Exception {
		super();
	}
	
	@Test(priority =1)
	public  void verifyRegistrationWithMandatoryDetails() {
      
		HomePage  hp = new HomePage(driver);
		hp.clickMyAccount();
		hp.clickRegister();
		
		AccountRegisterationPage rs= new AccountRegisterationPage(driver);
		
		rs.Firstname(randomString().toUpperCase());
		rs.Lastname(randomString().toUpperCase());
		rs.Email(randomString()+"@gmail.com");
		rs.Telephone(randomNumber());
		
		String password =randomAlphaNumber(); 
		
		rs.Password(password);
		rs.ConfirmPassword(password);
		rs.PrivacyPolicybutton();
		rs.ClickonContinue();
		
		String confmsg=rs.getConfirmationMsg();
		Assert.assertEquals(confmsg, "Your Account Has Been Created!");

		
	}	
	
	@Test(priority =2)
	public void verifyRegisterWithAllDetails()   {
		
		HomePage  hp = new HomePage(driver);
		hp.clickMyAccount();
		hp.clickRegister();
		AccountRegisterationPage  rs= new AccountRegisterationPage(driver);
	    rs.Firstname(randomString().toUpperCase());
		rs.Lastname(randomString().toUpperCase());
		rs.Email(randomString()+"@gmail.com");
		rs.Telephone(randomNumber());
		
		String password =randomAlphaNumber(); 
		
		rs.Password(password);
		rs.ConfirmPassword(password);
		rs.SubscribeYesRediobutton();
		rs.PrivacyPolicybutton();
		rs.ClickonContinue();
		String confmsg=rs.getConfirmationMsg();
		Assert.assertEquals(confmsg, "Your Account Has Been Created!");
		
		}
	
	@Test(priority =3)
	public  void verifyRegistrationWithExistingEmail() {
      
		HomePage  hp = new HomePage(driver);
		hp.clickMyAccount();
		hp.clickRegister();
		
		AccountRegisterationPage rs= new AccountRegisterationPage(driver);
		
		rs.Firstname(randomString().toUpperCase());
		rs.Lastname(randomString().toUpperCase());
		rs.Email("seleniumpanda@gmail.com");
		rs.Telephone(randomNumber());
		
		String password =randomAlphaNumber(); 
		
		rs.Password(password);
		rs.ConfirmPassword(password);
		rs.PrivacyPolicybutton();
		rs.ClickonContinue();
		String actualEmailWarningMsg = rs.emailwarningmsg();
	    Assert.assertEquals(actualEmailWarningMsg,"Warning: E-Mail Address is already registered!");

		
	}
	
	@Test(priority=4)
	public void verifyRegisterWithIncorrectConfirmPassword() {

		HomePage  hp = new HomePage(driver);
		hp.clickMyAccount();
		hp.clickRegister();
		AccountRegisterationPage  rs= new AccountRegisterationPage(driver);
	    rs.Firstname(randomString().toUpperCase());
		rs.Lastname(randomString().toUpperCase());
		rs.Email(randomString()+"@gmail.com");
		rs.Telephone(randomNumber());
		
		rs.Password("Selenium@123");
		rs.ConfirmPassword("Selenium@1234");
		rs.SubscribeYesRediobutton();
		rs.PrivacyPolicybutton();
		rs.ClickonContinue();
		Assert.assertTrue(rs.incorrectpasswordAlert());
		
	}

	@Test(priority = 5)
	public void verifyRegisterWithNoDetails() {
		HomePage  hp = new HomePage(driver);
		hp.clickMyAccount();
		hp.clickRegister();
		AccountRegisterationPage  rs= new AccountRegisterationPage(driver);
	    
		rs.ClickonContinue();
		String actualPrivacyPolicyWarningMessage = driver.findElement(By.xpath("//div[contains(@class, 'alert-dismissible')]")).getText();
		String expectedPrivacyPolicyWarningMessage = "Warning: You must agree to the Privacy Policy!";
		Assert.assertTrue(actualPrivacyPolicyWarningMessage.contains(expectedPrivacyPolicyWarningMessage));
		
		Assert.assertTrue(rs.displayStatusOfFirstname());
		Assert.assertTrue(rs.displayStatusOfLastname());
		Assert.assertTrue(rs.displayStatusOfEmail());
		Assert.assertTrue(rs.displayStatusOfTelephone());
		Assert.assertTrue(rs.displayStatusOfPassword());
		
		
	}
	
	
	
	   
	}
		
		
