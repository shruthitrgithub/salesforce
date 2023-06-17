package com.automation.pages.home;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.automation.pages.base.BasePage;

public class MySettingsPage extends BasePage{
	
	public static long timeOut = 30;
	@FindBy(id ="PersonalInfo_font") WebElement personalInfo_tab;
	@FindBy(id ="DisplayAndLayout_font") WebElement displayAndLayout_tab;
	@FindBy(id ="EmailSetup_font") WebElement emailSetup_tab;
	@FindBy(id ="PersonalCollaboration_font") WebElement chatter_tab;
	@FindBy(id ="CalendarAndReminders_font") WebElement calendarAndReminders_tab;
	@FindBy(id ="DesktopIntegration_font") WebElement desktopAddOns_tab;
	@FindBy(id ="Import_font") WebElement import_tab;	
	@FindBy(id ="LoginHistory_font") WebElement LoginHistory_tab;	
	@FindBy(xpath ="//a[contains(text(),'Download login history')]") WebElement download_Login_History;	
	@FindBy(id ="CustomizeTabs_font") WebElement CustomizeTabs_tab;	
	@FindBy(id ="p4") WebElement customApp_DropDown;	
	@FindBy(id ="duel_select_0") WebElement available_tabs;
	@FindBy(id ="duel_select_1") WebElement selected_tabs;	
	@FindBy(id ="duel_select_0_right") WebElement add_available_tabs;	
	@FindBy(id ="duel_select_0_left") WebElement remove_selected_tabs;	
	@FindBy(name ="save") WebElement save_button;	
	@FindBy(id ="EmailSettings_font") WebElement email_Setting;	
	@FindBy(id ="sender_name") WebElement sender_Name;	
	@FindBy(id ="sender_email") WebElement sender_Email;	
	@FindBy(id ="auto_bcc1") WebElement auto_bcc1;
	@FindBy(id ="Reminders_font") WebElement Activity_Reminders_tab;
	@FindBy(id ="testbtn") WebElement open_Test_Reminder_button;
	

	public MySettingsPage(WebDriver driver) {
		super(driver);
	}
	
	public void click_PersonalInfo_tab() {
		clickElement(personalInfo_tab, timeOut);
	}
	
	public void click_DisplayAndLayout_tab() {
		clickElement(displayAndLayout_tab, timeOut);
	}

	public void click_EmailSetup_tab() {
		clickElement(emailSetup_tab, timeOut);
	}

	public void click_Chatter_tab() {
		clickElement(chatter_tab, timeOut);
	}

	public void click_CalendarAndReminders_tab() {
		clickElement(calendarAndReminders_tab, timeOut);
	}

	public void click_DesktopAddOns_tab() {
		clickElement(desktopAddOns_tab, timeOut);
	}

	public void click_Import_tab() {
		clickElement(import_tab, timeOut);
	}

	public void click_LoginHistory_tab() {
		clickElement(LoginHistory_tab, timeOut);
	}

	public void click_Download_Login_History() {
		clickElement(download_Login_History, timeOut);
	}

	public void click_CustomizeTabs_tab() {
		clickElement(CustomizeTabs_tab, timeOut);
	}

	public void select_customApp_dropDown_item(String item) {
		selectFromDropDown(customApp_DropDown, item);
	}
	
	public void select_AvailableTabs_item(String available) {
		selectFromDropDown(available_tabs, available);
	}
	
	public void select_SelectedTabs_item(String selected) {
		selectFromDropDown(selected_tabs, selected);
	}

	public void click_add_available_tabs() {
		clickElement(add_available_tabs, timeOut);
	}
	
	public void click_remove_selected_tabs() {
		clickElement(remove_selected_tabs, timeOut);
	}
	
	public void click_My_Email_Settings_tab() {
		clickElement(email_Setting, timeOut);
	}

	public void input_Email_Name(String sender) {
		enterText(sender_Name, sender);
	}

	public void input_Email_Address(String email) {
		enterText(sender_Email, email);
	}

	public void select_Automatic_Bcc() {
		clickElement(auto_bcc1, timeOut);
	}

	public void click_save_button() {
		clickElement(save_button, timeOut);
	}

	public void click_Activity_Reminders_tab() {
		clickElement(Activity_Reminders_tab, timeOut);
	}

	public void click_open_Test_Reminder_button() {
		clickElement(open_Test_Reminder_button, timeOut);
	}
	
}
