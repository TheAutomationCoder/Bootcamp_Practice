package com.testCases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.pageObjects.ShoppingCartPage;
import com.testBase.BaseClass;


@Listeners(com.Listeners.BootcampFrameworkListeners.class)
public class TC005_ShoppingCartPage extends BaseClass {

	@Test
	void  shoppnigcartTast() {
		ShoppingCartPage sh = new ShoppingCartPage(driver);
		sh.Tablets();
		sh.LaptopsandNotebooks();
		sh.HPLP3065();
		sh.Addtocart();
		
		String expectedSuccessMessage = "Success: You have added HP LP3065 to your shopping cart!";
		Assert.assertTrue(sh.ProductAlrtMsg().contains(expectedSuccessMessage));
		sh.ShoppingCart();
		Assert.assertTrue(sh.ProductName());
		
}
}