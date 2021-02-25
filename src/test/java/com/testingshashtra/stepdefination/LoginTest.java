package com.testingshashtra.stepdefination;

import java.util.NoSuchElementException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import com.testingshashtra.utility.Constance;
import com.testingshashtra.utility.WaitFor;
import com.testingshshtra.pages.LoginPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginTest {
	private static final Logger LOG = Logger.getLogger(LoginTest.class);

	LoginPage l = new LoginPage();
	// SoftAssert asrt = new SoftAssert();

	@Given("I have {string} as mobile no")
	public void i_have_as_mobile_no(String username) {
		l.enterMobileNumber(username);

	}

	@Given("{string} as password")
	public void as_password(String pass) {
		l.enterPassword(pass);

	}

	@When("I hit on login button")
	public void i_hit_on_login_button() throws InterruptedException {
		l.clickLoginBt();

	}

	@Then("verify Login pass or Fail  Message")
	public void verify_error_message() {
		WaitFor.visibilityOfElement(l.okbtn);
		String mobile = l.getMobileTxt();
		String actual = l.getMsgOnPopUp();
		l.clickOnOKBtn();

		if (Constance.driver.getCurrentUrl().equals("http://103.50.162.196/testing/index.php")) {
			Assert.assertEquals(actual, "Login Successfull.");
			actual = l.dashboardtext();
			LOG.info("LOGIN SUCCESSFULLY and Redirect on  " + actual + " Page");
			Assert.assertEquals(actual, "Dashboard");
		} else {
			LOG.info("Fail to Login ");
			System.out.println("MObile test data " + mobile);
			if (mobile.startsWith("1") || mobile.startsWith("2") || mobile.startsWith("3") || mobile.startsWith("4")
					|| mobile.startsWith("5")) {
				LOG.info("Invalid start of Mobile number : " + actual);
				Assert.assertEquals(actual, "Please enter proper mobile no. Mobile No must be start with 6,7,8,9");
			} else {
				LOG.info("Mobile number or Password  not Register with our Application :  " + actual);
				Assert.assertEquals(actual, "Username/Password is wrong. Please try again.");
			}

		}

	}

	@Then("verify error msg for mobile number")
	public void verify_error_msg_for_mobile_numbe() {
		String actual = " ";
      // if (Constance.driver.findElement(l.mobileErrorMsg).isDisplayed()==true) {
			String mobile = l.getMobileTxt();
			if (mobile.length() > 10 || mobile.length() < 10 || !(mobile.length() == 0)) {
				actual = l.getMobileFieldErrorOnLabel();
				LOG.info("Mobile Field Error : " + actual);
				Assert.assertEquals(actual, "Please Enter Proper Mobile Number");
			} else if (mobile.equals(" ")) {
				actual = l.getMobileFieldErrorOnLabel();
				LOG.info("Mobile Field is Empty : " + actual);
				Assert.assertEquals(actual, "Please Enter Mobile Number");
			}
			 else if (l.getPasswordtxt().length() < 5 || !(l.getPasswordtxt().length() == 0) ){
					 // || Constance.driver.findElement(l.mobileErrorMsg).isDisplayed()== false) {
				actual = l.getPasswordfieldErrorOnLable();
				LOG.info("Password Field Error: " + actual);
				Assert.assertEquals(actual, "Your password must be at least 5 characters long");
			} else if (l.getPasswordtxt().equals(" ")) {
				actual = l.getPasswordfieldErrorOnLable();
				LOG.info("Password Field is Empty : " + actual);
				Assert.assertEquals(actual, "Please provide a password");

			}
		}
	}

