package com.automation.pages.home;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.automation.pages.base.BasePage;

public class HomePage extends BasePage{
	
	public static long timeOut = 30;
	@FindBy(id ="userNavLabel") WebElement userMenuDropDown;
	@FindBy(xpath = "//a[@title='My Profile']") WebElement myProfile;
	@FindBy(xpath = "//a[@title='My Settings']") WebElement mySetting;
	@FindBy(xpath = "//a[@title='Developer Console (New Window)']") WebElement developerconsole;
	@FindBy(xpath = "//a[@title='Switch to Lightning Experience']") WebElement switchtoLight;
	@FindBy(xpath = "//a[@title='Logout']") WebElement logout;
	@FindBy(xpath = "//a[@class='contactInfoLaunch editLink']/img") WebElement Editprofile;
	@FindBy(xpath = "//a[contains(text(),'About')]") WebElement About;
	@FindBy(id = "lastName") WebElement lastName;
	@FindBy(xpath = "//input[@value='Save All']") WebElement saveAll;
	@FindBy(id ="Account_Tab") WebElement Account_Tab;	

	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	public void click_userMenuDropDown() {
		clickElement(userMenuDropDown, timeOut);
	}
	
	
	public boolean verify_myProfile() {
		return isElementPresent(myProfile);
	}
	
	public boolean verify_mySetting() {
		return isElementPresent(mySetting);
	}

	public boolean verify_developerconsole() {
		return isElementPresent(developerconsole);
	}

	public boolean verify_switchtoLight() {
		return isElementPresent(switchtoLight);
	}
	
	public boolean verify_logout() {
		return isElementPresent(logout);
	}
		
	public void click_myProfile() {
		clickElement(myProfile, timeOut);
	}
	
	public void click_mySetting() {
		clickElement(mySetting,timeOut);
	}

	public void click_developerconsole() {
		clickElement(developerconsole, timeOut);
	}

	public void click_switchtoLight() {
		clickElement(switchtoLight, timeOut);
	}
	
	public void click_logout() {
		clickElement(logout, timeOut);
	}
	
	public void click_Editprofile() {
		clickElement(Editprofile, timeOut);
	}
	
	public void enter_LastName(String data) {
		driver.switchTo().frame("contactInfoContentId");
		clickElement(About, timeOut);
		clearElement(lastName);
		enterText(lastName, data);
	}
	
	public void click_saveAll() {
		clickElement(saveAll, timeOut);
	}

	public void click_Account_Tab() {
		clickElement(Account_Tab, timeOut);
	}

	
}
