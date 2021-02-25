package com.testingshshtra.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import com.testingshashtra.utility.Constance;
import com.testingshashtra.utility.WaitFor;

public class AddBankPage {
	private static final Logger LOG = Logger.getLogger(AddBankPage.class);
	public By banks = By.xpath("//a[text()='Banks ']");
	public By bankBtn = By.cssSelector("#add_btn");
	public By bankName = By.cssSelector("#bank_name");
	public By accountName = By.cssSelector("#account_name");
	public By accountNo = By.cssSelector("input#account_no");
	public By accountType = By.cssSelector("#bank_account_type");// select dropdown
	public By ifscCode = By.cssSelector("#ifsc_code");
	public By micrCode = By.cssSelector("#micr_code");
	public By submitBtn = By.cssSelector("input[value='Submit']");
	public By sucessMessage = By.cssSelector("div[class='swal2-content']");

	public By okMessageBtn = By.cssSelector("button[class='swal2-confirm styled']");

	public void clickOnBankMenu() {
		LOG.info("Click On Bank Menu");
		WaitFor.visibilityOfElement(banks);
		Constance.driver.findElement(banks).click();
	}

	public void clickOnAddBankBtn() {
		LOG.info("Click On  Add Bank Button");
		Constance.driver.findElement(bankBtn).click();

	}

	public void enterBankName(String BankName) {
		Constance.driver.findElement(bankName).sendKeys(BankName);
		LOG.info("Entering Bank Name " + BankName);
	}

	public void enterAccountName(String Accountname) {
		Constance.driver.findElement(accountName).sendKeys(Accountname);
		LOG.info("Entering Account Name " + Accountname);

	}

	public void enterAccountNumber(String AccountNumber) {
		Constance.driver.findElement(accountNo).sendKeys(AccountNumber);
		LOG.info("Entering  Account number   " + AccountNumber);
	}

	public void selectAccountType(String AccountType) {
		Select select = new Select(Constance.driver.findElement(accountType));
		select.selectByVisibleText(AccountType);
		LOG.info("Selecting  Account Type  " + AccountType);
	}

	public void enterIFSCCode(String IFSCCode) {
		Constance.driver.findElement(ifscCode).sendKeys(IFSCCode);
		LOG.info("Entering IFSC Code  " + IFSCCode);

	}

	public void enterMICRCode(String MICRCode) {
		Constance.driver.findElement(micrCode).sendKeys(MICRCode);
		LOG.info("Entering MICR Code  " + MICRCode);
	}

	public void clickOnSubmitBtn() {
		Constance.driver.findElement(submitBtn).click();
		LOG.info("Click on Submit button");
	}

	public String getSucessMessageText() {
		LOG.info("Get Success Message");
		return Constance.driver.findElement(sucessMessage).getText();

	}
public void clickOnConfirmButton() {

	LOG.info("click On Ok button");
	 Constance.driver.findElement(okMessageBtn).click();

}

}
