package com.testingshatra.keywords;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.log4testng.Logger;

import com.testingshashtra.utility.Config;
import com.testingshashtra.utility.Constance;

import io.cucumber.messages.internal.com.google.protobuf.util.TimeUtil;
import io.github.bonigarcia.wdm.WebDriverManager;

public class UIKeywords {
private static final Logger LOG = Logger.getLogger(UIKeywords.class);
	public void lunchedBrowser( String browser) {
		
		switch (browser) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			Constance.driver = new ChromeDriver();
			LOG.info("Launching Chrome Browser");
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			Constance.driver=new FirefoxDriver();
			LOG.info("Launching Firefox Browser");
			
			break;
		case "opera":
		WebDriverManager.operadriver().setup();
		Constance.driver= new OperaDriver();
		LOG.info("Launching Opera Browser");
		
		break;
		case "IE":
			WebDriverManager.iedriver().setup();
			Constance.driver = new InternetExplorerDriver();
			LOG.info("Launching IE  Browser");
			
			break;
		default:
			LOG.error("Invalide Browser");
			break;
		}
	}
	
	public void openUrl(String url) {
		Constance.driver.get(url);
	}
	public void click(By by) {
		Constance.driver.findElement(by).click();
	}
	public void click(WebElement element) {
		element.click();
	}
	public void clearTextBox(By by) {
		Constance.driver.findElement(by).clear();
		
	}
	public void clearDropdownText(By by) {
		Constance.select = new Select(Constance.driver.findElement(by));
		Constance.select.deselectByIndex(0);
		
		
	}
}
