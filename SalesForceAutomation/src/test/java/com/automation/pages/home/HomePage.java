package com.automation.pages.home;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

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
	@FindBy(xpath ="//a[@title='Home Tab']") WebElement Home_Tab;	
	@FindBy(xpath ="//h1/a[@href='/_ui/core/userprofile/UserProfilePage']") WebElement currentUserName;	
	@FindBy(xpath ="//h2[@id='contactInfoTitle']") WebElement editProfileTitle;
	@FindBy(id ="contactTab") WebElement editProfile_ContactTab;
	@FindBy(xpath ="//span[@id='tailBreadcrumbNode']") WebElement editProfile_ProfileName;
	//@FindBy(id ="aboutTab") WebElement editProfile_AboutTab;
	//@FindBy(id ="lastName") WebElement editProfile_LastName;
	//@FindBy(xpath ="//input[@type='button' and @value='Save All']") WebElement editProfile_SaveAll;	

	@FindBy(xpath ="//a[@href='/home/showAllTabs.jsp']") WebElement showAllTabs;
	@FindBy(xpath ="//input[@value='Customize My Tabs']") WebElement customizeMyTabs;	
	@FindBy(id ="duel_select_0") WebElement available_Tabs;
	@FindBy(id ="duel_select_1") WebElement selected_Tabs;
	@FindBy(id ="duel_select_0_right") WebElement add_Selected_Tabs;	
	@FindBy(id ="duel_select_0_left") WebElement remove_Selected_Tabs;
	@FindBy(xpath ="//input[@name='save']") WebElement save_Button;
	@FindBy(xpath ="//*[@id=\"ptBody\"]/div/div[2]/span[2]/a") WebElement CurrentDate;
	@FindBy(xpath ="//*[@id=\"p:f:j_id25:j_id61:28:j_id64\"]/a") WebElement EightPM;
	@FindBy(className="comboboxIcon") WebElement SubjectCombo;
	@FindBy(xpath ="//a[text()='Other']") WebElement comboBox_Other;
	@FindBy(xpath ="//*[@id=\"p:f:j_id25:j_id61:20:j_id64\"]/a") WebElement FourPM;
	@FindBy(id ="EndDateTime_time") WebElement endDateTime_Time;
	@FindBy(id ="timePickerItem_42") WebElement StartDateTime_Time_9pm;
	@FindBy(id ="StartDateTime_time") WebElement StartDateTime_time;
	@FindBy(className="btn") WebElement SaveButton;
	@FindBy(id ="timePickerItem_46") WebElement endDateTime_Time_11pm;
	@FindBy(xpath ="//*[@id=\"timePickerItem_38\"]") WebElement endDateTime_Time_7pm;
	@FindBy(id ="IsRecurrence") WebElement CheckBox;
	@FindBy(id ="rectypeftw") WebElement WeekelyRadioButton;
	@FindBy(id ="RecurrenceEndDateOnly") WebElement RecurrenceEndDate;
	@FindBy(id ="datePicker") WebElement Calender;
	@FindBy(xpath ="//*[@id=\"bottomButtonRow\"]/input[1]") WebElement Save;
	
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

	public void click_Home_Tab() {
		clickElement(Home_Tab, timeOut);
	}

	public String get_Current_UserName() {		
		String user_Name = currentUserName.getText();
		System.out.println("user_Name = " +user_Name);
		return user_Name;
	}

	public String get_Current_UserName_EditProfile() {	
		System.out.println("Inside get_Current_UserName_EditProfile");
		isElementPresent(editProfile_ProfileName);
		String user_Name = editProfile_ProfileName.getText();
		System.out.println("user Name on Edit profile page= " +user_Name);
		return user_Name;
	}


	public void click_Current_UserName() {		
		clickElement(currentUserName, timeOut);
	}

	public void verify_EditProfile_PopUp_displayed() {	
		System.out.println("Verifying Edit Profile Pop up displayed");
		isElementPresent(editProfileTitle);
	}

	public void verify_EditProfile_ContactTab_displayed() {
		System.out.println("Verifying Contact Tab on Edit Profile Pop up is displayed");
		isElementPresent(editProfile_ContactTab);
	}


	public void click_showAllTabs() {		
		clickElement(showAllTabs, timeOut);
	}

	public void click_customizeMyTabs() {		
		clickElement(customizeMyTabs, timeOut);
	}

	public void click_available_Tabs() {		
		clickElement(available_Tabs, timeOut);
	}

	public void select_item_from_selected_Tabs() {	
		Select selectedTab = new Select(selected_Tabs);
		selectedTab.selectByIndex(1);		
	}

	public void click_add_Selected_Tabs() {		
		clickElement(selected_Tabs, timeOut);
	}

	public void click_remove_Selected_Tabs() {		
		clickElement(remove_Selected_Tabs, timeOut);
	}

	public void click_save_Button() {		
		clickElement(save_Button, timeOut);
	}
	public void click_CurrentDate() {
		clickElement(CurrentDate, timeOut);
	}
	public void Scroll8PM() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
	}
	public void click_EightPM() {
		clickElement(EightPM, timeOut);
	}

	public void click_SubjectCombo() throws InterruptedException {
		Thread.sleep(2000);
		clickElement(SubjectCombo, timeOut);

	}


	public void comboBox_SelectOthers() throws InterruptedException {
		Thread.sleep(4000);
		// It will return the parent window name as a String
		String parent=driver.getWindowHandle();
		Set<String> s=driver.getWindowHandles();
		// Now iterate using Iterator
		Iterator<String> I1= s.iterator();
		while(I1.hasNext())	{
			String child_window=I1.next();
			if(!parent.equals(child_window)) {
				driver.switchTo().window(child_window);
				System.out.println(driver.switchTo().window(child_window).getTitle());
			}

		}		
		clickElement(comboBox_Other, timeOut);
		
		driver.switchTo().window(parent);
	}
	public void StartDateTime_time() {		
		clickElement(StartDateTime_time, timeOut);
		clickElement(StartDateTime_Time_9pm, timeOut);	
	}

	public void input_EndTime() {		
		clickElement(endDateTime_Time, timeOut);
		clickElement(endDateTime_Time_11pm, timeOut);	

	}
	public void input_EndTime7() {		
		clickElement(endDateTime_Time, timeOut);
		clickElement(endDateTime_Time_7pm, timeOut);	
	}
	


	public void click_Save() {
		clickElement(SaveButton,timeOut);
	}
	public void click_FourPM() {
		clickElement(FourPM, timeOut);
	}
	public void Scroll4PM() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,800)");
	}
	public void ScrollRecurrence() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,800)");
	}
	public void click_CheckBox() {
		clickElement(CheckBox, timeOut);
	
}
	public void click_WeekelyRadioButton() {
		clickElement(WeekelyRadioButton, timeOut);	
	}
	public void click_RecurrenceEndDate() {
		clickElement( RecurrenceEndDate, timeOut);	
}
	public void DatePicker() {
		clickElement(Calender, timeOut);
		
	}
	public void Save() {
		clickElement(Save, timeOut);
		
	}
	
}



