package com.testingshashtra.stepdefination;

import org.apache.log4j.Logger;
import org.testng.Assert;

import com.testingshashtra.utility.Constance;
import com.testingshashtra.utility.WaitFor;
import com.testingshatra.setup.SeleniumBase;
import com.testingshshtra.pages.AddBankPage;
import com.testingshshtra.pages.LoginPage;
import com.testingshshtra.pages.MasterPage;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class AddBankTest {
	MasterPage masterpage = new MasterPage();
	AddBankPage addbank = new AddBankPage();
	private static final Logger LOG = Logger.getLogger(AddBankTest.class);
	
	@Given("click on bnak Menu")
	public void click_on_bnak_menu() {
		WaitFor.pageLoad();
		masterpage.masterMenuMouseHover();
		LOG.info("Master Menu Clicked");
		addbank.clickOnBankMenu();
		LOG.info("Bank Sub Menu Clicked");
		

	}

	@Given("click on add bank button")
	public void click_on_add_bank_button() {
		LOG.info("Waiting For Visibility Add Bank button");
		
		WaitFor.visibilityOfElement(addbank.bankBtn);
		addbank.clickOnAddBankBtn();
		LOG.info("Click on  Add Bank button");
		
	}

	@Then("Fill all Mantetory Fields")
	public void fill_all_mantetory_fields() {
		//WaitFor.visibilityOfElement(addbank.bankBtn);
		addbank.enterBankName("Union Bank");
		addbank.enterAccountName("ABS");
		addbank.enterAccountNumber("1234567890");
		addbank.selectAccountType("Savings");
		addbank.enterIFSCCode("UNBI0004567");
		addbank.enterMICRCode("145698715");

	}

	@Then("Click on submit button")
	public void click_on_submit_button() {
		LOG.info("Click on Submit button");
		
		addbank.clickOnSubmitBtn();
	}

	@Then("Assert Result")
	public void assert_result() {
		LOG.info("Asserting Result");
		WaitFor.visibilityOfElement(addbank.sucessMessage);;
		String Expected = "Bank Added.";
		String Actual = addbank.getSucessMessageText();
		Assert.assertEquals(Actual, Expected);

	}
	


}
