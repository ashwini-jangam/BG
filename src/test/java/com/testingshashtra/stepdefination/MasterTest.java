package com.testingshashtra.stepdefination;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.testingshashtra.utility.WaitFor;
import com.testingshatra.setup.SeleniumBase;
import com.testingshshtra.pages.MasterPage;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class MasterTest {
	MasterPage master = new MasterPage();
	private static final Logger LOG = Logger.getLogger(MasterTest.class);

	@Given("Hover on Master Menu")
	public void hover_on_master_menu() throws InterruptedException {
		WaitFor.pageLoad();
		master.masterMenuMouseHover();

	}

	@Then("Verify Submenu List")
	public void verify_submenu_list() {
		 master.getSubMenu();
		
		 /* List<String>  list = (Arrays.asList("Banks","Users","Branches","Customers",
				  "Brokers","Vendors","Enquiry","Projects"));
		 
		 
		  LOG.info("Actual List is : " + actualList +" and " + "Expected List "+ list );
		  Assert.assertTrue(flag);*/
		  
		  
		  
		 

	}

	private void info(String string) {
		// TODO Auto-generated method stub
		
	}
	
}
