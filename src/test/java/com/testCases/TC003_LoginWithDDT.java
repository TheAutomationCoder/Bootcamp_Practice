package com.testCases;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Utilities.DataProviders;
import com.pageObjects.HomePage;
import com.pageObjects.LoginPage;
import com.pageObjects.MyAccountPage;
import com.testBase.BaseClass;

public class TC003_LoginWithDDT extends BaseClass {
	public TC003_LoginWithDDT() throws Exception {
		super();
	}
	
	@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class)
	public void verifyLoginwithDDT(String email, String pwd) {
	HomePage hp = new HomePage(driver);
	hp.clickMyAccount();
	hp.clickLogin();

	LoginPage lg = new LoginPage(driver);
	lg.Email(email);
	lg.Password(pwd);
	lg.ClickOnLogin();
	
	MyAccountPage mac=new MyAccountPage(driver);
	boolean targatPage=mac.isMyAccountPageExists();
	
	
	
	
	
	}
}










