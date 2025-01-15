package com.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReporter {
	
	public static  ExtentReports generateExtentReport() throws Exception {
		
		ExtentReports extentReport = new ExtentReports();
		
		File extentReportFile = new File(System.getProperty("user.dir")+"\\test-output\\ExtentReports\\extentreporter.html");
		
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(extentReportFile);
		
		sparkReporter.config().setTheme(Theme.DARK);
		sparkReporter.config().setReportName("Bootcamp Result");
		sparkReporter.config().setDocumentTitle("TNReportTitle  | bootcamp 2024");
		sparkReporter.config().setTimeStampFormat("MM/dd/yyyy hh:mm:ss");
		
		
		extentReport.attachReporter(sparkReporter);
		
		Properties prop = new Properties();	
		FileInputStream ip = new FileInputStream(System.getProperty("C:\\Users\\15713\\eclipse-workspace\\Bootcamp_Practice\\src\\main\\java\\config.properties"));
		prop.load(ip);
		extentReport.setSystemInfo("application url", prop.getProperty("url"));
		extentReport.setSystemInfo("email", prop.getProperty("validEmail"));
		extentReport.setSystemInfo("password", prop.getProperty("validPassword"));
		extentReport.setSystemInfo("Operating System", prop.getProperty("os.name"));
		extentReport.setSystemInfo("Operating System version detail", prop.getProperty("os.version"));
		extentReport.setSystemInfo("Tester Responsible", prop.getProperty("user.name"));
		extentReport.setSystemInfo("java version", prop.getProperty("java.version"));
		extentReport.setSystemInfo("java vendor", prop.getProperty("java.vendor"));
		
		return extentReport;
		
	}

	

	
}
