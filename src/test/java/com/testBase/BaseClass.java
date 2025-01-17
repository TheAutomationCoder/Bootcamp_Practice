package com.testBase;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.collections.bag.SynchronizedSortedBag;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class BaseClass {
	
public WebDriver driver;
public Logger logger;
public Properties p;


	@BeforeMethod
	@Parameters({"os","browser"})
	public void setup(String os,String br) throws IOException 
	{
		//Loading config.properties file
		FileReader file= new FileReader(System.getProperty("user.dir")+"\\src\\main\\java\\config.properties");
		p=new Properties();
		p.load(file);
		

		
		logger=LogManager.getLogger(this.getClass());  //log4j2 code
		
		switch(br.toLowerCase()) {
		case "chrome" : driver=new ChromeDriver();break;
		case "edge"   : driver=new EdgeDriver();break;
		case "firefox": driver=new FirefoxDriver();break;
		default : System.out.println("Invalid browser name");
		return;
		}
		
		
		driver.manage().window().maximize(); 
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    driver.get(p.getProperty("url"));
	    
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
  }
	
	public String randomString() 
	{
		
	String generatedstring=RandomStringUtils.randomAlphabetic(5);
	return generatedstring;
		
	}
	
	
	public String randomNumber() 
	{
		
	String generatednumber=RandomStringUtils.randomNumeric(10);
	return generatednumber;
	
	}
	
	
	public String randomAlphaNumber() 
	{
    String generatedstring=RandomStringUtils.randomAlphabetic(3);	
	String generatednumber=RandomStringUtils.randomNumeric(3);
	return (generatedstring+"#"+generatednumber);
		
	}
}
