package com.Utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	
	
	@DataProvider(name="LoginData")
	public String[][]getData() throws IOException
	{
		String path = "C:\\Users\\15713\\eclipse-workspace\\Bootcamp_Practice\\testData\\ExcelData.xlsx"; // taking xl file form testData
	
	ExcelUtility xlutil = new ExcelUtility(path);
	
	int totalrows = xlutil.getRowCount("LoginTN");
	int totalcols = xlutil.getCellCount("LoginTN",1);
	
	String logindata[][]= new String[totalrows][totalcols];
	for(int i=1;i<=totalrows;i++) 
	{
		for(int j=0;j<totalcols;j++) 
	{
		logindata[i-1][j]= xlutil.getCellData("LoginTN", i, j);	
    	}
		
	}
	return logindata;
	
	
	}

}
