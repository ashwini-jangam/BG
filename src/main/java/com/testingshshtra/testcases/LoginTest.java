package com.testingshshtra.testcases;

import org.testng.annotations.Test;

import com.testingshashtra.utility.Constance;
import com.testingshatra.setup.SeleniumBase;

public class LoginTest extends SeleniumBase {
	@Test
	public void verifyLoginForValidInput() {
       Constance.driver.get("http://103.50.162.196/testing/user-login.php");
       
	}
}
