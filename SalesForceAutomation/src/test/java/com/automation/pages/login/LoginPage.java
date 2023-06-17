package com.automation.pages.login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.automation.pages.base.BasePage;

public class LoginPage extends BasePage {
	
	public static long timeOut = 30;

	
	@FindBy(id ="username") WebElement userNameElement;
	@FindBy(id = "password") WebElement password;
	@FindBy(id = "Login") WebElement loginButton;
	@FindBy(id = "error") WebElement loginErrorElement;
	@FindBy(id = "rememberUn") WebElement rememberMe_CheckBox;
	@FindBy(id = "idcard-identity") WebElement savedUserName;
	@FindBy(id = "forgot_password_link") WebElement forgotPassword;
	@FindBy(id = "un") WebElement forgotPassword_userName;
	@FindBy(id = "continue") WebElement forgotPassword_continue;
	@FindBy(name = "cancel") WebElement forgotPassword_cancel;

	
	public LoginPage(WebDriver driver) {		
		super(driver);		
	}
	
	public void enterUsername(String usernamedata) {
		enterText(userNameElement, usernamedata);
	}
	
	public void enterPassword(String passworddata) {
		enterText(password, passworddata);
	}
	
	public boolean loginErrorDisplayed() {
		return isElementPresent(loginErrorElement);
	}
	
	public WebDriver clickButton() {
		clickElement(loginButton, timeOut);
		return driver;
	}
	
	public String getTitleOfThePAge() {
		//waitUntilPageLoads();		
		return driver.getTitle();
	}
	
	public void select_Rememberme() {
		clickElement(rememberMe_CheckBox,timeOut);
	}
	
	public String getSavedUsername () {
		return getTextOfElement (savedUserName);		
	}
	
	public void click_forgot_password() {
		clickElement(forgotPassword,timeOut);
	}

	public void enter_forgotPassword_Username(String forgotUname) {
		enterText(forgotPassword_userName, forgotUname);
	}
	
	public void click_forgotPassword_continue() {
		clickElement(forgotPassword_continue,timeOut);
	}
	
	public void click_forgotPassword_cancel() {
		clickElement(forgotPassword_cancel,timeOut);
	}

}
