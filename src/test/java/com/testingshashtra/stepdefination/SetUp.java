package com.testingshashtra.stepdefination;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.imageio.ImageIO;

import com.testingshashtra.utility.Config;
import com.testingshashtra.utility.Constance;
import com.testingshatra.keywords.UIKeywords;
import com.testingshatra.setup.SeleniumBase;
import com.testingshshtra.pages.LoginPage;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;

public class SetUp {
	@After
	public void closebrowser() {
		SeleniumBase.tearDown();
	}
	@After
	public void tearDown(Scenario scenario) {
		if(scenario.isFailed()) {
				try {
					Robot robo = new Robot();
					String filepath = System.getProperty("user.dir");
					Rectangle screenRect =  new Rectangle();
					screenRect.setSize(1366, 768);
					DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
					LocalDate now = LocalDate.now();
					String Todays_Date = dtf.format(now);
					
					BufferedImage bufimg = robo.createScreenCapture(screenRect);
					String filename = filepath+"/Robot_Images/"+ Todays_Date+"/pic_"+ System.currentTimeMillis() +".png";
					//String filename = filepath+"/Robot_Images/"+datefolder+"/pic_"+time+".png";
					
					File output =  new File(filename); 
					output.mkdirs();
					ImageIO.write(bufimg, "PNG", output);
					
				} catch (AWTException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				finally {
					Constance.driver.close();
				}
			
		}
		
	}
	
	@Given("{string} browser is Opened")
	public void openBrowser(String browser) {
		UIKeywords keywords = new UIKeywords();
		keywords.lunchedBrowser(browser);
	}

	@Given("application Url is Launched")
	public void application_url_is_launched() {
		Constance.driver.get(Config.getAppUrl());

	}

	@Given("Application is login")
	public void Application_is_login() {
		LoginPage login = new LoginPage();
		login.enterMobileNumber("9876543210");
		login.enterPassword("admin");
		login.clickLoginBt();
		login.clickOnOKBtn();
	}

	@Given("{string} browser is Opened and application Url is Launched")
	public void browser_is_opened_and_application_url_is_launched(String browser) {
		UIKeywords keywords = new UIKeywords();
		keywords.lunchedBrowser(browser);
		Constance.driver.get(Config.getAppUrl());
	}
	
/*	
	@Before(order = 1)
	public void luanchBrowserAndOpenURL() {
		SeleniumBase.setup();
	}

	@Before(order = 2)
	public void loginApplication() {
		LoginPage login = new LoginPage();
		login.enterMobileNumber("1234567890");
		login.enterPassword("admin");
		login.clickLoginBt();

	}*/


}
