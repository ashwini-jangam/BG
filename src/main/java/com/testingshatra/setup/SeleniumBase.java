package com.testingshatra.setup;

import java.lang.invoke.ConstantCallSite;

import org.apache.log4j.Logger;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.testingshashtra.utility.Config;
import com.testingshashtra.utility.Constance;
import com.testingshashtra.utility.PropertyUtility;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumBase {
	private static final Logger LOG = Logger.getLogger(SeleniumBase.class);
	
	//@BeforeMethod
	public static  void setup() {
		switch (Config.getBrowserName()) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			Constance.driver = new ChromeDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			Constance.driver=new FirefoxDriver();
			break;
		case "opera":
		WebDriverManager.operadriver().setup();
		Constance.driver= new OperaDriver();
		break;
		case "IE":
			WebDriverManager.iedriver().setup();
			Constance.driver = new InternetExplorerDriver();
			break;
		default:
			System.err.println("Invalide Browser");
			break;
		}
		
		Constance.driver.get(Config.getAppUrl());
	
	}
	//@AfterMethod
	public static  void tearDown() {
		LOG.info("Browser Closed");
		
		Constance.driver.quit();
	}

}
