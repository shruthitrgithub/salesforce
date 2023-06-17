package com.automation.pages.home;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.automation.pages.base.BasePage;

public class AccountsPage extends BasePage{

	public static long timeOut = 30;
	@FindBy(id ="createNewButton") WebElement createNewButton;
	@FindBy(xpath ="//a[@class='accountMru menuButtonMenuLink']") WebElement Account_tab;
	@FindBy(xpath ="//input[@id='acc2']") WebElement AccountName;
	@FindBy(xpath ="//select[@id='acc6']") WebElement Type_dropDown;
	@FindBy(xpath ="//select[@id='00N5i00000Ow2Y0']") WebElement CustomerPriority_dropDown;
	@FindBy(xpath ="//a[@id='tryLexDialogX']") WebElement popUp_close;

	public AccountsPage(WebDriver driver) {
		super(driver);
	}

	public void click_createNewButton() {
		clickElement(createNewButton, timeOut);
	}

	public void click_Account_tab() {
		clickElement(Account_tab, timeOut);
	}

	public void input_AccountName(String acctName) {
		enterText(AccountName, acctName);
	}

	public void select_Type_dropDown_item(String item) {
		selectFromDropDown(Type_dropDown, item);
	}

	public void select_CustomerPriority_dropDown_item(String priority) {
		selectFromDropDown(CustomerPriority_dropDown, priority);
	}

	public void click_popUp_close() {

		clickElement(popUp_close, timeOut);		

	}

}
