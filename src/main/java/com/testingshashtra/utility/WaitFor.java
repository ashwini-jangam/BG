package com.testingshashtra.utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitFor {
	
public  static void visibilityOfElement(By by ) {
	Constance.wait =  new WebDriverWait(Constance.driver ,20);
		
	Constance.wait.until(ExpectedConditions.visibilityOfElementLocated(by));
		
	}
public static void presenceOfElementLocated(By by) {
	Constance.wait =  new WebDriverWait(Constance.driver ,20);
	Constance.wait.until(ExpectedConditions.presenceOfElementLocated(by));
}
public static  void alertIsPresent() {
	Constance.wait =  new WebDriverWait(Constance.driver ,20);
	Constance.wait.until(ExpectedConditions.alertIsPresent());
}
public static void pageLoad() {
	Constance.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	
}

}
