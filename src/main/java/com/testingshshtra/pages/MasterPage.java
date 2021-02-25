package com.testingshshtra.pages;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.testingshashtra.utility.Constance;
import com.testingshashtra.utility.WaitFor;

public class MasterPage {
	private static final Logger LOG = Logger.getLogger(MasterPage.class);
	public By masterMenu = By.cssSelector("i[class='fa fa-database'] ~ span[class='toggle-none']");
	public By subMenu = By
			.cssSelector("ul#respMenu :nth-child(2) ul[class='nav-second-level nav flex-column sub-menu'] li a");

	public void masterMenuMouseHover() {
		Actions action = new Actions(Constance.driver);
		action.moveToElement(Constance.driver.findElement(masterMenu)).build().perform();
		// WaitFor.visibilityOfElement(subMenu);
	}

	public void getSubMenu() {
		int size = Constance.driver.findElements(subMenu).size();
		LOG.info(" Size of  Submenu : " + size);
		}
}
