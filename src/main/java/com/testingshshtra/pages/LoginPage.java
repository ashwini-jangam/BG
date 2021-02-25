package com.testingshshtra.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import com.testingshashtra.utility.Constance;
import com.testingshashtra.utility.WaitFor;

public class LoginPage {
	private static final Logger LOG = Logger.getLogger(LoginPage.class);
	public By mobileTxtBx = By.cssSelector("input#username");
	public By passwordTxtBx = By.cssSelector("input#password");
	public By loginBtn = By.cssSelector("button[type='submit']");
	
	public By dashboardTxt = By.xpath("//h2[text()='Dashboard']");
	
	public By mobileErrorMsg = By.cssSelector("#username-error");
	public By passworErrormsg =By.cssSelector("#password-error");
	
	public By messagePopUp = By.cssSelector("div[class='swal2-content']");
	public By okbtn = By.cssSelector("button[class='swal2-confirm styled']");

	public LoginPage() {
		WaitFor.pageLoad();
	}

	public void clickOnOKBtn() {
		Constance.driver.findElement(okbtn).click();
	}

	public String getMobileFieldErrorOnLabel() {
		return Constance.driver.findElement(mobileErrorMsg).getText();
	}
	public String getPasswordfieldErrorOnLable() {
		return Constance.driver.findElement(passworErrormsg).getText();
	}

	public String getMsgOnPopUp() {
		return Constance.driver.findElement(messagePopUp).getText();
	}

		public String getMobileTxt() {
		return Constance.driver.findElement(mobileTxtBx).getAttribute("value");

	}
	public String getPasswordtxt() {
		return Constance.driver.findElement(passwordTxtBx).getAttribute("value");

	}

	public void enterMobileNumber(String mobilenumber) {
		Constance.driver.findElement(mobileTxtBx).sendKeys(mobilenumber);

	}

	public void enterPassword(String paswword) {
		Constance.driver.findElement(passwordTxtBx).sendKeys(paswword);
	}

	public void clickLoginBt() {
		Constance.driver.findElement(loginBtn).click();

	}

	public String dashboardtext() {
		LOG.info("Getting dashboard text");
		return Constance.driver.findElement(dashboardTxt).getText();
	}

}
