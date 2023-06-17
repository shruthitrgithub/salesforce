package com.automation.tests;

import java.util.Properties;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.automation.base.BaseTest;
import com.automation.pages.home.AccountsPage;
import com.automation.pages.home.HomePage;
import com.automation.pages.home.MySettingsPage;
import com.automation.pages.login.LoginPage;
import com.automation.utility.ExtentReportsUtility;
import com.automation.utility.PropertiesUtility;

public class AutomationScripts extends BaseTest{


	@Test (enabled = true)	
	public void login_Error_Message_1() throws InterruptedException {
	
		ExtentReportsUtility extObject = ExtentReportsUtility.getInstance();
		extObject.startExtentReport();
		extObject.startSingleTestReport("login_Error_Message_1");
		//extObject.logTestInfo("login_Error_Message_1");
		
		log.info("inside the login_to_salesforce_testscript test method");		
		PropertiesUtility pro=new PropertiesUtility();
		Properties appProp= pro.loadFile("applicationDataProperties");
	
		String userId=appProp.getProperty("login.valid.userid");
		String password="";	
		
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUsername(userId);
		loginpage.enterPassword(password);
		driver= loginpage.clickButton();
		Assert.assertTrue(loginpage.loginErrorDisplayed());
		extObject.logTestpassed("login_Error_Message_1 is Pass");
		extObject.endReport();
		driver.close();

	}

	@Test(enabled = true)
	public void login_to_SalesForce_2() throws InterruptedException {
		ExtentReportsUtility extObject = ExtentReportsUtility.getInstance();
		extObject.startExtentReport();
		extObject.startSingleTestReport("login_Error_Message_1");
		
		log.info("inside the login_to_SalesForce_2 test method");		
		PropertiesUtility pro=new PropertiesUtility();
		Properties appProp= pro.loadFile("applicationDataProperties");
	
		String userId=appProp.getProperty("login.valid.userid");
		String password=appProp.getProperty("login.valid.password");
		
		extObject.logTestInfo("Entering user id as " + userId);
		extObject.logTestInfo("Entering password id as " + password);
		
		String expectedTitle = "Home Page ~ Salesforce - Developer Edition";
		
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUsername(userId);
		loginpage.enterPassword(password);
		driver= loginpage.clickButton();
		String actualTitle= loginpage.getTitleOfThePAge();
		Assert.assertEquals(actualTitle, expectedTitle);
		extObject.logTestInfo("expectedTitle is  " + expectedTitle);
		extObject.logTestInfo("actualTitle is  " + actualTitle);
		driver.close();

	}

	

	@Test(enabled = true)
	public void check_remember_me_3() throws InterruptedException {
		log.info("inside the check_remember_me_3 test method");		
		PropertiesUtility pro=new PropertiesUtility();
		Properties appProp= pro.loadFile("applicationDataProperties");
	
		String userId=appProp.getProperty("login.valid.userid");
		String password=appProp.getProperty("login.valid.password");
		
		String expectedTitle = "Home Page ~ Salesforce - Developer Edition";
		
		LoginPage loginpage=new LoginPage(driver);
		HomePage homepage=new HomePage(driver);

		loginpage.enterUsername(userId);
		loginpage.enterPassword(password);
		loginpage.select_Rememberme();
		driver= loginpage.clickButton();
		String actualTitle= loginpage.getTitleOfThePAge();
		System.out.println("expectedTitle = " +expectedTitle);
		System.out.println("actualTitle = " +actualTitle);
		Assert.assertEquals(actualTitle, expectedTitle);	

		Thread.sleep(2000);	
		homepage.click_userMenuDropDown();
		Thread.sleep(2000);
		homepage.click_logout();
		Thread.sleep(4000);	
		
		String savedUname = loginpage.getSavedUsername();
		System.out.println("userId = " +userId);
		System.out.println("savedUname = " +savedUname);

		Assert.assertEquals(userId, savedUname);	

		driver.close();		
	}
	
	@Test(enabled = true)
	public void forgot_Password_4A() throws InterruptedException {
		log.info("inside the forgot_Password_4A test method");		
		PropertiesUtility pro=new PropertiesUtility();
		Properties appProp= pro.loadFile("applicationDataProperties");	
		String userId=appProp.getProperty("login.valid.userid");		
		LoginPage loginpage=new LoginPage(driver);
		loginpage.click_forgot_password();
		loginpage.enter_forgotPassword_Username(userId);
		loginpage.click_forgotPassword_continue();
		driver.close();		
	}

	
	@Test(enabled = true)
	public void forgot_Password_4B() throws InterruptedException {

		log.info("inside the forgot_Password_4B test method");		
		PropertiesUtility pro=new PropertiesUtility();
		Properties appProp= pro.loadFile("applicationDataProperties");	
		String userId=appProp.getProperty("login.valid.userid");
		String password=appProp.getProperty("login.invalid.password");

		LoginPage loginpage=new LoginPage(driver);

		loginpage.enterUsername(userId);
		loginpage.enterPassword(password);
		driver= loginpage.clickButton();
		Thread.sleep(4000);
		Assert.assertTrue(loginpage.loginErrorDisplayed());

		driver.close();		
	}

	@Test(enabled = true)
	public void TestId_TC05() throws InterruptedException {

		log.info("inside the TestId_TC05 test method");		
		PropertiesUtility pro=new PropertiesUtility();
		Properties appProp= pro.loadFile("applicationDataProperties");	
		String userId=appProp.getProperty("login.valid.userid");
		String password=appProp.getProperty("login.valid.password");

		LoginPage loginpage = new LoginPage(driver);
		HomePage homepage = new HomePage(driver);
		
		loginpage.enterUsername(userId);
		loginpage.enterPassword(password);
		loginpage.clickButton();		
		homepage.click_userMenuDropDown();
		Assert.assertTrue(homepage.verify_myProfile());
		Assert.assertTrue(homepage.verify_mySetting());
		Assert.assertTrue(homepage.verify_developerconsole());
		Assert.assertTrue(homepage.verify_switchtoLight());
		Assert.assertTrue(homepage.verify_logout());		
		driver.close();		

	}

	@Test(enabled = true)
	public void TestId_TC06() throws InterruptedException {

		log.info("inside the TestId_TC06 test method");		
		PropertiesUtility pro=new PropertiesUtility();
		Properties appProp= pro.loadFile("applicationDataProperties");	
		String userId=appProp.getProperty("login.valid.userid");
		String password=appProp.getProperty("login.valid.password");
		String lName = "Dixit";
		
		LoginPage loginpage = new LoginPage(driver);
		HomePage homepage = new HomePage(driver);
		
		loginpage.enterUsername(userId);
		loginpage.enterPassword(password);
		loginpage.clickButton();
		
		homepage.click_userMenuDropDown();
		Assert.assertTrue(homepage.verify_myProfile());
		Assert.assertTrue(homepage.verify_mySetting());
		Assert.assertTrue(homepage.verify_developerconsole());
		Assert.assertTrue(homepage.verify_switchtoLight());
		Assert.assertTrue(homepage.verify_logout());
		
		homepage.click_myProfile();		
		homepage.click_Editprofile();
		homepage.enter_LastName(lName);		
		homepage.click_saveAll();
		
		driver.close();		

	}
	
	@Test(enabled = true)
	public void TestId_TC07() throws InterruptedException {

		log.info("inside the TestId_TC07 test method");		
		PropertiesUtility pro=new PropertiesUtility();
		Properties appProp= pro.loadFile("applicationDataProperties");	
		String userId=appProp.getProperty("login.valid.userid");
		String password=appProp.getProperty("login.valid.password");
		
		LoginPage loginpage = new LoginPage(driver);
		HomePage homepage = new HomePage(driver);
		MySettingsPage mysettings = new MySettingsPage(driver);		
		
		loginpage.enterUsername(userId);
		loginpage.enterPassword(password);
		loginpage.clickButton();
		
		homepage.click_userMenuDropDown();	
		homepage.click_mySetting();		
		mysettings.click_PersonalInfo_tab();
		mysettings.click_LoginHistory_tab();
		mysettings.click_Download_Login_History();
		mysettings.click_DisplayAndLayout_tab();
		mysettings.click_CustomizeTabs_tab();
		mysettings.select_customApp_dropDown_item("Salesforce Chatter");
		mysettings.select_AvailableTabs_item("Reports");
		mysettings.click_add_available_tabs();
		mysettings.click_save_button();	
		mysettings.click_DisplayAndLayout_tab();
		mysettings.click_CustomizeTabs_tab();
		mysettings.select_customApp_dropDown_item("Salesforce Chatter");
		mysettings.select_SelectedTabs_item("Reports");
		mysettings.click_remove_selected_tabs();
		mysettings.click_save_button();
		mysettings.click_EmailSetup_tab();
		mysettings.click_My_Email_Settings_tab();
		mysettings.input_Email_Name("Shruthi Dixit");
		mysettings.input_Email_Address("shruthi.344@gmail.com");
		mysettings.select_Automatic_Bcc();
		mysettings.click_save_button();
		mysettings.click_CalendarAndReminders_tab();
		mysettings.click_Activity_Reminders_tab();
		mysettings.click_open_Test_Reminder_button();
		
		driver.close();		

	}

	@Test(enabled = true)
	public void TestId_TC08() throws InterruptedException {

		log.info("inside the TestId_TC08 test method");		
		PropertiesUtility pro=new PropertiesUtility();
		Properties appProp= pro.loadFile("applicationDataProperties");	
		String userId=appProp.getProperty("login.valid.userid");
		String password=appProp.getProperty("login.valid.password");
		
		LoginPage loginpage = new LoginPage(driver);
		HomePage homepage = new HomePage(driver);
		
		loginpage.enterUsername(userId);
		loginpage.enterPassword(password);
		loginpage.clickButton();
		
		homepage.click_userMenuDropDown();	
		homepage.click_developerconsole();		
	//	driver.switchTo().window("Developer Console");			
		driver.close();		

	}

	@Test(enabled = false)
	public void TestId_TC09() throws InterruptedException {

		log.info("inside the TestId_TC09 test method");		
		PropertiesUtility pro=new PropertiesUtility();
		Properties appProp= pro.loadFile("applicationDataProperties");	
		String userId=appProp.getProperty("login.valid.userid");
		String password=appProp.getProperty("login.valid.password");
		
		LoginPage loginpage = new LoginPage(driver);
		HomePage homepage = new HomePage(driver);
		
		loginpage.enterUsername(userId);
		loginpage.enterPassword(password);
		loginpage.clickButton();
		
		homepage.click_userMenuDropDown();	
		homepage.click_logout();		
		driver.close();		

	}

	@Test(enabled = true)
	public void TestId_TC10() throws InterruptedException {

		log.info("inside the TestId_TC10 test method");		
		PropertiesUtility pro=new PropertiesUtility();
		Properties appProp= pro.loadFile("applicationDataProperties");	
		String userId=appProp.getProperty("login.valid.userid");
		String password=appProp.getProperty("login.valid.password");
		
		LoginPage loginpage = new LoginPage(driver);
		HomePage homepage = new HomePage(driver);
		MySettingsPage mysettings = new MySettingsPage(driver);		
		AccountsPage accountsPage = new AccountsPage(driver);

		
		loginpage.enterUsername(userId);
		loginpage.enterPassword(password);
		loginpage.clickButton();
		homepage.click_Account_Tab();
		
		accountsPage.click_popUp_close();
		
		accountsPage.click_createNewButton();
		accountsPage.click_Account_tab();
		Thread.sleep(2000);
		accountsPage.input_AccountName("Samanvita");
		accountsPage.select_Type_dropDown_item("Technology Partner");
		accountsPage.select_CustomerPriority_dropDown_item("High");
		mysettings.click_save_button();	
		driver.close();		

	}

}
