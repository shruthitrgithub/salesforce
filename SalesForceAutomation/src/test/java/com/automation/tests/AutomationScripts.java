package com.automation.tests;

import java.util.Properties;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.automation.base.BaseTest;
import com.automation.pages.home.AccountsPage;
import com.automation.pages.home.ContactPage;
import com.automation.pages.home.HomePage;
import com.automation.pages.home.LeadsPage;
import com.automation.pages.home.MySettingsPage;
import com.automation.pages.home.OpportunitiesPage;
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
        Thread.sleep(4000);
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

		//accountsPage.click_popUp_close();

		accountsPage.click_createNewButton();
		accountsPage.click_Account_tab();
		Thread.sleep(2000);
		accountsPage.input_AccountName("Samanvita");
		accountsPage.select_Type_dropDown_item("Technology Partner");
		accountsPage.select_CustomerPriority_dropDown_item("High");
		mysettings.click_save_button();	
		driver.close();		

	}

	@Test(enabled = true)
	public void TestId_TC11() throws InterruptedException {

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
		accountsPage.click_createNewView();

		accountsPage.input_ViewName("TestViewName");
		accountsPage.input_ViewUniqueName("TestViewUniqueName");
		accountsPage.click_SaveButton();
		driver.close();	
	}	


	@Test(enabled = true)
	public void TestId_TC12() throws InterruptedException {

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
		homepage.click_Account_Tab();////*[@id="filter_element"]/div/span/span[2]/a[1]
		accountsPage.click_Edit();

		accountsPage.input_ViewName1("Sugosh");
		accountsPage.click_SaveButton1();
		driver.close();	
	}

	@Test(enabled = true)
	public void TestId_TC13() throws InterruptedException {

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
		accountsPage.click_mergeaccount();
		accountsPage.EnterAccName("samanvita");
		accountsPage.click_findaccount();
		accountsPage.click_Nextbutton();
		driver.close();	
	}


	@Test(enabled = true)
	public void TestId_TC14() throws InterruptedException {

		log.info("inside the TestId_TC14 test method");		
		PropertiesUtility pro=new PropertiesUtility();
		Properties appProp= pro.loadFile("applicationDataProperties");	
		String userId=appProp.getProperty("login.valid.userid");
		String password=appProp.getProperty("login.valid.password");

		LoginPage loginpage = new LoginPage(driver);
		HomePage homepage = new HomePage(driver);
		//MySettingsPage mysettings = new MySettingsPage(driver);		
		AccountsPage accountsPage = new AccountsPage(driver);


		loginpage.enterUsername(userId);
		loginpage.enterPassword(password);
		loginpage.clickButton();
		homepage.click_Account_Tab();
		accountsPage.Accountactivity();
		accountsPage.select_Date_Field();	
		accountsPage.fromToday();
		accountsPage.toToday();
		accountsPage.click_SaveUnsavedReport();
		accountsPage.input_Report_Name("December2023");
		accountsPage.input_Report_Unique_Name("ThisYear");
		accountsPage.click_SaveButton_SaveReport();
		driver.close();


	}
	@Test(enabled = true)
	public void TestId_TC15() throws InterruptedException {

		log.info("inside the TestId_TC15 test method");		
		PropertiesUtility pro=new PropertiesUtility();
		Properties appProp= pro.loadFile("applicationDataProperties");	
		String userId=appProp.getProperty("login.valid.userid");
		String password=appProp.getProperty("login.valid.password");

		LoginPage loginpage = new LoginPage(driver);
		HomePage homepage = new HomePage(driver);
		OpportunitiesPage oppPage=new OpportunitiesPage(driver);

		loginpage.enterUsername(userId);
		loginpage.enterPassword(password);
		loginpage.clickButton();
		oppPage.click_Opp_tab();
		oppPage.click_ViewDD();
	}

	@Test(enabled = true)
	public void TestId_TC16() throws InterruptedException {

		log.info("inside the TestId_TC16 test method");		
		PropertiesUtility pro=new PropertiesUtility();
		Properties appProp= pro.loadFile("applicationDataProperties");	
		String userId=appProp.getProperty("login.valid.userid");
		String password=appProp.getProperty("login.valid.password");

		LoginPage loginpage = new LoginPage(driver);
		HomePage homepage = new HomePage(driver);
		OpportunitiesPage oppPage=new OpportunitiesPage(driver);

		loginpage.enterUsername(userId);
		loginpage.enterPassword(password);
		loginpage.clickButton();
		oppPage.click_Opp_tab();
		oppPage.click_NewButton();
	}

	@Test(enabled = true)
	public void TestId_TC17() throws InterruptedException {

		log.info("inside the TestId_TC17 test method");		
		PropertiesUtility pro=new PropertiesUtility();
		Properties appProp= pro.loadFile("applicationDataProperties");	
		String userId=appProp.getProperty("login.valid.userid");
		String password=appProp.getProperty("login.valid.password");

		LoginPage loginpage = new LoginPage(driver);
		HomePage homepage = new HomePage(driver);
		OpportunitiesPage oppPage=new OpportunitiesPage(driver);

		loginpage.enterUsername(userId);
		loginpage.enterPassword(password);
		loginpage.clickButton();
		oppPage.click_Opp_tab();
		oppPage.click_NewButton();
		oppPage.click_oppPipeline();
	}	
	@Test(enabled = true)
	public void TestId_TC18() throws InterruptedException {

		log.info("inside the TestId_TC18 test method");		
		PropertiesUtility pro=new PropertiesUtility();
		Properties appProp= pro.loadFile("applicationDataProperties");	
		String userId=appProp.getProperty("login.valid.userid");
		String password=appProp.getProperty("login.valid.password");

		LoginPage loginpage = new LoginPage(driver);
		HomePage homepage = new HomePage(driver);
		OpportunitiesPage oppPage=new OpportunitiesPage(driver);

		loginpage.enterUsername(userId);
		loginpage.enterPassword(password);
		loginpage.clickButton();
		oppPage.click_Opp_tab();
		oppPage.StuckOpp();

	}
	@Test(enabled = true)
	public void TestId_TC20() throws InterruptedException {

		log.info("inside the TestId_TC20 test method");		
		PropertiesUtility pro=new PropertiesUtility();
		Properties appProp= pro.loadFile("applicationDataProperties");	
		String userId=appProp.getProperty("login.valid.userid");
		String password=appProp.getProperty("login.valid.password");

		LoginPage loginpage = new LoginPage(driver);
		HomePage homepage = new HomePage(driver);
		LeadsPage leadsPage=new LeadsPage(driver);


		loginpage.enterUsername(userId);
		loginpage.enterPassword(password);
		loginpage.clickButton();
		leadsPage.click_Lead_tab();

	}


	@Test(enabled = true)
	public void TestId_TC21() throws InterruptedException {

		log.info("inside the TestId_TC21 test method");		
		PropertiesUtility pro=new PropertiesUtility();
		Properties appProp= pro.loadFile("applicationDataProperties");	
		String userId=appProp.getProperty("login.valid.userid");
		String password=appProp.getProperty("login.valid.password");

		LoginPage loginpage = new LoginPage(driver);
		HomePage homepage = new HomePage(driver);
		LeadsPage leadsPage=new LeadsPage(driver);


		loginpage.enterUsername(userId);
		loginpage.enterPassword(password);
		loginpage.clickButton();
		leadsPage.click_Lead_tab();
		leadsPage.click_View_Dropdown();
		driver.close();
	}
	@Test(enabled = true)
	public void TestId_TC22() throws InterruptedException {

		log.info("inside the TestId_TC21 test method");		
		PropertiesUtility pro=new PropertiesUtility();
		Properties appProp= pro.loadFile("applicationDataProperties");	
		String userId=appProp.getProperty("login.valid.userid");
		String password=appProp.getProperty("login.valid.password");

		LoginPage loginpage = new LoginPage(driver);
		HomePage homepage = new HomePage(driver);
		LeadsPage leadsPage=new LeadsPage(driver);


		loginpage.enterUsername(userId);
		loginpage.enterPassword(password);
		loginpage.clickButton();
		leadsPage.click_Lead_tab();
		leadsPage.click_View_Dropdown();
		leadsPage.click_View_DropdownList() ;
		leadsPage.click_UserMenu();
		leadsPage.click_Logout();
		Thread.sleep(2000);
		loginpage.enterUsername(userId);
		loginpage.enterPassword(password);
		loginpage.clickButton();
		leadsPage.click_Lead_tab();
		leadsPage.click_GOButton();
	}
	@Test(enabled = true)
	public void TestId_TC23() throws InterruptedException {

		log.info("inside the TestId_TC21 test method");		
		PropertiesUtility pro=new PropertiesUtility();
		Properties appProp= pro.loadFile("applicationDataProperties");	
		String userId=appProp.getProperty("login.valid.userid");
		String password=appProp.getProperty("login.valid.password");

		LoginPage loginpage = new LoginPage(driver);
		HomePage homepage = new HomePage(driver);
		LeadsPage leadsPage=new LeadsPage(driver);


		loginpage.enterUsername(userId);
		loginpage.enterPassword(password);
		loginpage.clickButton();
		leadsPage.click_Lead_tab();
		leadsPage.click_View_Dropdown();
		leadsPage.click_View_DropdownList1();

	}
	@Test(enabled = true)
	public void TestId_TC24() throws InterruptedException {

		log.info("inside the TestId_TC21 test method");		
		PropertiesUtility pro=new PropertiesUtility();
		Properties appProp= pro.loadFile("applicationDataProperties");	
		String userId=appProp.getProperty("login.valid.userid");
		String password=appProp.getProperty("login.valid.password");

		LoginPage loginpage = new LoginPage(driver);
		HomePage homepage = new HomePage(driver);
		LeadsPage leadsPage=new LeadsPage(driver);


		loginpage.enterUsername(userId);
		loginpage.enterPassword(password);
		loginpage.clickButton();
		leadsPage.click_Lead_tab();
		leadsPage.click_NewButton();
		leadsPage.click_LastName();
		leadsPage.input_LName("ABCD");
		leadsPage.click_CompanyName();
		leadsPage.input_CName("ABCD");
		//leadsPage.click_Save();
	}
	@Test(enabled = true)
	public void TestId_TC25() throws InterruptedException {

		log.info("inside the TestId_TC21 test method");		
		PropertiesUtility pro=new PropertiesUtility();
		Properties appProp= pro.loadFile("applicationDataProperties");	
		String userId=appProp.getProperty("login.valid.userid");
		String password=appProp.getProperty("login.valid.password");

		LoginPage loginpage = new LoginPage(driver);
		HomePage homepage = new HomePage(driver);
		ContactPage ContactPage=new ContactPage(driver);

		loginpage.enterUsername(userId);
		loginpage.enterPassword(password);
		loginpage.clickButton();

		ContactPage.click_Contact_tab();
		ContactPage.click_New_tab();
		ContactPage.click_lastElement();
		ContactPage.click_AccountName();
		ContactPage.input_LName("Dixit");
		ContactPage.input_AName("samhita");
		ContactPage.click_Save();
	}

	@Test(enabled = true)
	public void TestId_TC26() throws InterruptedException {

		log.info("inside the TestId_TC21 test method");		
		PropertiesUtility pro=new PropertiesUtility();
		Properties appProp= pro.loadFile("applicationDataProperties");	
		String userId=appProp.getProperty("login.valid.userid");
		String password=appProp.getProperty("login.valid.password");

		LoginPage loginpage = new LoginPage(driver);
		HomePage homepage = new HomePage(driver);
		ContactPage ContactPage=new ContactPage(driver);

		loginpage.enterUsername(userId);
		loginpage.enterPassword(password);
		loginpage.clickButton();

		ContactPage.click_Contact_tab();
		ContactPage.click_newview();
		ContactPage.input_ViewName("Anna");
		Thread.sleep(2000);
		ContactPage.click_ViewUniqueName();
		ContactPage.input_UniqueName("John");
		ContactPage.click_Save1();



	}

	@Test(enabled = true)
	public void TestId_TC27() throws InterruptedException {

		log.info("inside the TestId_TC27 test method");		
		PropertiesUtility pro=new PropertiesUtility();
		Properties appProp= pro.loadFile("applicationDataProperties");	
		String userId=appProp.getProperty("login.valid.userid");
		String password=appProp.getProperty("login.valid.password");

		LoginPage loginpage = new LoginPage(driver);
		HomePage homepage = new HomePage(driver);
		ContactPage ContactPage=new ContactPage(driver);

		loginpage.enterUsername(userId);
		loginpage.enterPassword(password);
		loginpage.clickButton();

		ContactPage.click_Contact_tab();
		ContactPage.select_Recent_Contact_DropDown("Recently Created");

	}

	@Test(enabled = true)
	public void TestId_TC28() throws InterruptedException {

		log.info("inside the TestId_TC27 test method");		
		PropertiesUtility pro=new PropertiesUtility();
		Properties appProp= pro.loadFile("applicationDataProperties");	
		String userId=appProp.getProperty("login.valid.userid");
		String password=appProp.getProperty("login.valid.password");

		LoginPage loginpage = new LoginPage(driver);
		HomePage homepage = new HomePage(driver);
		ContactPage ContactPage=new ContactPage(driver);

		loginpage.enterUsername(userId);
		loginpage.enterPassword(password);
		loginpage.clickButton();

		ContactPage.click_Contact_tab();
		ContactPage. click_View_Dropdown1() ;
		ContactPage.select_Dropdown1() ;

	}	
	@Test(enabled = true)//incomplete
	public void TestId_TC29() throws InterruptedException {

		log.info("inside the TestId_TC29 test method");		
		PropertiesUtility pro=new PropertiesUtility();
		Properties appProp= pro.loadFile("applicationDataProperties");	
		String userId=appProp.getProperty("login.valid.userid");
		String password=appProp.getProperty("login.valid.password");

		LoginPage loginpage = new LoginPage(driver);
		HomePage homepage = new HomePage(driver);
		ContactPage ContactPage=new ContactPage(driver);

		loginpage.enterUsername(userId);
		loginpage.enterPassword(password);
		loginpage.clickButton();

		ContactPage.click_Contact_tab();
		ContactPage.click_Name();

	}
	@Test(enabled = true)
	public void TestId_TC30() throws InterruptedException {

		log.info("inside the TestId_TC30 test method");		
		PropertiesUtility pro=new PropertiesUtility();
		Properties appProp= pro.loadFile("applicationDataProperties");	
		String userId=appProp.getProperty("login.valid.userid");
		String password=appProp.getProperty("login.valid.password");

		LoginPage loginpage = new LoginPage(driver);
		HomePage homepage = new HomePage(driver);
		ContactPage ContactPage=new ContactPage(driver);

		loginpage.enterUsername(userId);
		loginpage.enterPassword(password);
		loginpage.clickButton();

		ContactPage.click_Contact_tab();
		ContactPage.click_newview();
		ContactPage.click_ViewUniqueName();
		ContactPage.input_UniqueNameAlphabet("EFGH");
		ContactPage.click_Save1();

	}
	@Test(enabled = true)
	public void TestId_TC31() throws InterruptedException {

		log.info("inside the TestId_TC30 test method");		
		PropertiesUtility pro=new PropertiesUtility();
		Properties appProp= pro.loadFile("applicationDataProperties");	
		String userId=appProp.getProperty("login.valid.userid");
		String password=appProp.getProperty("login.valid.password");

		LoginPage loginpage = new LoginPage(driver);
		HomePage homepage = new HomePage(driver);
		ContactPage ContactPage=new ContactPage(driver);

		loginpage.enterUsername(userId);
		loginpage.enterPassword(password);
		loginpage.clickButton();

		ContactPage.click_Contact_tab();
		ContactPage.click_newview();
		ContactPage.click_ViewUniqueName();
		ContactPage.input_ViewNameAlphabet("ABCD");
		ContactPage.input_UniqueNameAlphabet("EFGH");
		Thread.sleep(2000);
		ContactPage.click_Cancel();

	}

	@Test(enabled = true)//incomplete
	public void TestId_TC32() throws InterruptedException {

		log.info("inside the TestId_TC21 test method");		
		PropertiesUtility pro=new PropertiesUtility();
		Properties appProp= pro.loadFile("applicationDataProperties");	
		String userId=appProp.getProperty("login.valid.userid");
		String password=appProp.getProperty("login.valid.password");

		LoginPage loginpage = new LoginPage(driver);
		HomePage homepage = new HomePage(driver);
		ContactPage ContactPage=new ContactPage(driver);

		loginpage.enterUsername(userId);
		loginpage.enterPassword(password);
		loginpage.clickButton();

		ContactPage.click_Contact_tab();
		ContactPage.click_New_tab();
		ContactPage.click_lastElement();
		ContactPage.input_LastName("Indian");
		ContactPage.click_AccountName(); 
		ContactPage.input_AccNameBox("Global Media");
		ContactPage.click_SaveandNew();

	}

	@Test(enabled = true)
	public void TestId_TC33() throws InterruptedException {

		log.info("inside the TestId_TC33 test method");		
		PropertiesUtility pro=new PropertiesUtility();
		Properties appProp= pro.loadFile("applicationDataProperties");	
		String userId=appProp.getProperty("login.valid.userid");
		String password=appProp.getProperty("login.valid.password");

		LoginPage loginpage = new LoginPage(driver);
		HomePage homepage = new HomePage(driver);

		loginpage.enterUsername(userId);
		loginpage.enterPassword(password);
		loginpage.clickButton();
		homepage.click_Home_Tab();
		String curUserName = homepage.get_Current_UserName();
		Assert.assertEquals(curUserName, "Shruthi Dixit");
		driver.close();

	}
	
	@Test(enabled = true)
	public void TestId_TC34() throws InterruptedException {

		log.info("inside the TestId_TC34 test method");		
		PropertiesUtility pro=new PropertiesUtility();
		Properties appProp= pro.loadFile("applicationDataProperties");	
		String userId=appProp.getProperty("login.valid.userid");
		String password=appProp.getProperty("login.valid.password");

		LoginPage loginpage = new LoginPage(driver);
		HomePage homepage = new HomePage(driver);

		loginpage.enterUsername(userId);
		loginpage.enterPassword(password);
		loginpage.clickButton();
		homepage.click_Home_Tab();
		homepage.click_Current_UserName();
		homepage.click_Editprofile();
		homepage.verify_EditProfile_PopUp_displayed();
		homepage.verify_EditProfile_ContactTab_displayed();
		//homepage.click_Account_Tab();
		homepage.enter_LastName("Abcd");
		homepage.click_saveAll();
		Thread.sleep(4000);
		String curUserName = homepage.get_Current_UserName_EditProfile();
		Assert.assertEquals(curUserName, "Shruthi Abcd");
		driver.close();
		
	}

	@Test(enabled = true)
	public void TestId_TC35() throws InterruptedException {

		log.info("inside the TestId_TC35 test method");		
		PropertiesUtility pro=new PropertiesUtility();
		Properties appProp= pro.loadFile("applicationDataProperties");	
		String userId=appProp.getProperty("login.valid.userid");
		String password=appProp.getProperty("login.valid.password");

		LoginPage loginpage = new LoginPage(driver);
		HomePage homepage = new HomePage(driver);

		loginpage.enterUsername(userId);
		loginpage.enterPassword(password);
		loginpage.clickButton();
		homepage.click_Home_Tab();
		homepage.click_showAllTabs();
		homepage.click_customizeMyTabs();
		homepage.select_item_from_selected_Tabs();
		homepage.click_remove_Selected_Tabs();
		homepage.click_save_Button();
		driver.close();
		
	}
	@Test(enabled = true)
	public void TestId_TC36() throws InterruptedException {

		log.info("inside the TestId_TC36 test method");		
		PropertiesUtility pro=new PropertiesUtility();
		Properties appProp= pro.loadFile("applicationDataProperties");	
		String userId=appProp.getProperty("login.valid.userid");
		String password=appProp.getProperty("login.valid.password");

		LoginPage loginpage = new LoginPage(driver);
		//Thread.sleep(2000);
		HomePage homepage = new HomePage(driver);

		loginpage.enterUsername(userId);
		loginpage.enterPassword(password);
		loginpage.clickButton();
		homepage.click_Home_Tab();
		Thread.sleep(4000);
		homepage.click_CurrentDate();
		homepage.Scroll8PM();
		homepage.click_EightPM();
		homepage.click_SubjectCombo();
		homepage.comboBox_SelectOthers();
		homepage.StartDateTime_time();
		homepage.input_EndTime();
		homepage.click_save_Button();
		//driver.close();
	
	}
	@Test(enabled = true)
	public void TestId_TC37() throws InterruptedException {

		log.info("inside the TestId_TC36 test method");		
		PropertiesUtility pro=new PropertiesUtility();
		Properties appProp= pro.loadFile("applicationDataProperties");	
		String userId=appProp.getProperty("login.valid.userid");
		String password=appProp.getProperty("login.valid.password");

		LoginPage loginpage = new LoginPage(driver);
		//Thread.sleep(2000);
		HomePage homepage = new HomePage(driver);

		loginpage.enterUsername(userId);
		loginpage.enterPassword(password);
		loginpage.clickButton();
		homepage.click_Home_Tab();
		Thread.sleep(2000);
		homepage.click_CurrentDate();
		homepage.Scroll4PM();
		Thread.sleep(4000);
		homepage.click_FourPM();
		homepage.click_SubjectCombo();
		homepage.comboBox_SelectOthers();
		Thread.sleep(4000);
		homepage.input_EndTime7();
		homepage.ScrollRecurrence();
		homepage.click_CheckBox();
		homepage.click_RecurrenceEndDate();
		homepage.DatePicker();
		homepage.Save();
		
	
		//homepage.click_save_Button();
	
	
	}
	
}
