package com.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartPage {
	
	WebDriver driver;
	
	//constructor
	public ShoppingCartPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements( driver,this);
		
	}
	
	//Locators
	
	@FindBy(xpath="//a[text()='Tablets']")
	WebElement tablets;
	
	@FindBy(xpath="//a[text()='Laptops & Notebooks (5)']")
	WebElement laptopsandnotbooks;
	
	@FindBy(xpath="//div[@id='content']//div[1]//div[1]//div[2]//div[2]//button[1]//i[1]")
	WebElement addhplp3065;
	
	@FindBy(xpath="//button[@id='button-cart']")
	WebElement addtocart;
	
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	WebElement  ProductAlrtMsg;
	
	@FindBy(xpath="//span[normalize-space()='Shopping Cart']")
	WebElement clicOnshoppingcart;
	
	@FindBy(xpath="(//a[contains(text(),'HP LP3065')])[2]")
	WebElement productname;
	
	
	

	//Action method
	public void Tablets() {
		tablets.click();
	}
	
	public void LaptopsandNotebooks() {
		laptopsandnotbooks.click();
	}
	
	public void HPLP3065() {
		addhplp3065.click();
	}
	
	public void Addtocart() {
		addtocart.click();
	}
	
	
	public String ProductAlrtMsg() {
		
		String productstatusMsg =  ProductAlrtMsg.getText();
		return productstatusMsg;
	}
	
	
	 public void ShoppingCart() {
		 clicOnshoppingcart.click();
	 }
	 
	 public boolean ProductName() {
		 
		boolean productstatus = productname.isDisplayed();
		 return productstatus;
	 }
	

}
