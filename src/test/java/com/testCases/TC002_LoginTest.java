package com.testCases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.pageObjects.HomePage;
import com.pageObjects.LoginPage;
import com.testBase.BaseClass;

public class TC002_LoginTest extends BaseClass {
	public TC002_LoginTest() throws Exception {
		super();
	}
	
	@Test(priority = 1)
	public void verifyLoginwithValidCredentials() {
		
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
	
		LoginPage lg = new LoginPage(driver);
		lg.Email(p.getProperty("validEmail"));
		lg.Password(p.getProperty("validPassword"));
		lg.ClickOnLogin();
		//Assert.assertTrue(driver.findElement(By.linkText("Logout")).isDisplayed());
		Assert.assertTrue(lg.LogoutbtnisPresent());
	
		}

	@Test(priority = 2)
	public void verifyLoginwithValidEmailInvalidPasword() {
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		LoginPage lg = new LoginPage(driver);
		lg.Email(p.getProperty("validEmail"));
		lg.Password(p.getProperty("invalidPassword"));
		lg.ClickOnLogin();
		String confmsg = lg.WarningmsgisDisplayd();
		Assert.assertEquals(confmsg, "Warning: No match for E-Mail Address and/or Password.");
	
		
	}
	
	@Test(priority =3)
	public void verifyLoginwitInvalidEmailValidPasword() throws Exception {
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		LoginPage lg = new LoginPage(driver);
		
		lg.Email(p.getProperty("invalidEmail"));
		
		lg.Password(p.getProperty("validPassword"));
		lg.ClickOnLogin();
		String confmsg = lg.WarningmsgisDisplayd();
		Assert.assertEquals(confmsg, "Warning: No match for E-Mail Address and/or Password.");
	
		
	}
	
	@Test(priority = 4)
	public void verifyLoginwithInvalidCredentials() throws Exception {
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		LoginPage lg = new LoginPage(driver);
		Thread.sleep(2000);
		lg.Email("Mananrr@Gmail.com");
		
		lg.Password("Manan@1234");
		lg.ClickOnLogin();
		String confmsg = lg.WarningmsgisDisplayd();
		Assert.assertEquals(confmsg, "Warning: No match for E-Mail Address and/or Password.");
	
		}
	
	@Test(priority =5)
	public void verifyLoginwithNoCredentials() {
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		LoginPage lg = new LoginPage(driver);
		lg.ClickOnLogin();
		String confmsg = lg.WarningmsgisDisplayd();
		Assert.assertEquals(confmsg, "Warning: No match for E-Mail Address and/or Password.");
	
		
	}

}
