package com.testCases;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.pageObjects.HomePage;
import com.pageObjects.ProductPage;
import com.testBase.BaseClass;

public class TC004_SearchProductTest extends BaseClass{
	public TC004_SearchProductTest() throws Exception {
		super();
	}
	
	
	@Test(priority=1)
	public void searchWithValidProduct() {
		HomePage hp = new HomePage(driver);
		hp.enterProduct(p.getProperty("validProduct"));
		hp.clickOnSearchButton();
		
		ProductPage pg = new ProductPage(driver);
		Assert.assertTrue(pg.displayStatusOfHPLaptop());
		
	}
	
	
	@Test(priority=2) //purposely Failed
	public void searchWithInvalidProduct() {
		HomePage hp = new HomePage(driver);
		ProductPage pg = new ProductPage(driver);
		hp.enterProduct(p.getProperty("validProduct"));
		hp.clickOnSearchButton();
		String waringmsg =pg.displayStatusOfWarningMessage();
		Assert.assertNotSame(waringmsg, "There is no product that matches the search criteria.");
		
		
		
		
	}
	
	@Test(priority=3, dependsOnMethods ="searchWithInvalidProduct") //purposely Failed
	public void searchWithNoProduct() {
		HomePage hp = new HomePage(driver);
		hp.clickOnSearchButton();
		ProductPage pg = new ProductPage(driver);
		String waringmsg =pg.displayStatusOfWarningMessage();
		Assert.assertEquals(waringmsg, "There is no product that matches the search criteria.");
		
		
		
	}

}
