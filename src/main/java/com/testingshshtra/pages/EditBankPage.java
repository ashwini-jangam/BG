package com.testingshshtra.pages;

import java.util.List;

import org.openqa.selenium.By;

import com.testingshashtra.utility.Constance;
import com.testingshashtra.utility.WaitFor;

public class EditBankPage {
	AddBankPage abp = new AddBankPage();
	public By seachBx = By.cssSelector("input[type='search']");
	public By editBtn = By.cssSelector("button[class='btn btn-primary btn-border btn-rounded btn-xs editBtn']");
	public By submitBtn = By.cssSelector("input[value='Submit']");

	public By banknametxt = By.cssSelector("table#datatable3 tr td:nth-child(2) ");
	/*public By accountName = By.cssSelector("");
	public By accountNo = By.cssSelector("");
	public By accountType = By.cssSelector("");// select dropdown
	public By ifscCode = By.cssSelector("");
	public By micrCode = By.cssSelector("");*/
	
	
	public void enterTextInSearchBx(String text) {
				Constance.driver.findElement(seachBx).sendKeys(text);
	}
	public void clickOnEditBtn() {
		Constance.driver.findElement(editBtn).click();
		//WaitFor.visibilityOfElement(editBtn);
	}
	public String getBankName() {
		List list = Constance.driver.findElements(banknametxt);
		String bankname = list.get(0).toString();
		return bankname;
	}

}
