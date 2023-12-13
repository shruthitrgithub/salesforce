package com.automation.pages.base;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.automation.utility.ExtentReportsUtility;
import com.automation.utility.Log4JUtility;

public class BasePage {	
	protected static  WebDriver driver;
	protected  WebDriverWait wait;
	protected Log4JUtility logObject=Log4JUtility.getInstance();
	protected Logger log;
	protected ExtentReportsUtility report=ExtentReportsUtility.getInstance();

	public BasePage(WebDriver driver) {
		BasePage.driver=driver;
		System.out.println("driver in basePage="+driver);
		PageFactory.initElements(driver, this);
		log=logObject.getLogger();	
	}



	//public static void enterText (WebElement element,String data,String objectName) {
	public static void enterText (WebElement element,String data) {		
		if (element.isDisplayed()) {
			clearElement(element);
			element.sendKeys(data);
			System.out.println("pass:" +data+ " is entered");
		}
		else {
			System.out.println("Fail:"+data+" element is not displayed");
		}
	}


	//public static void clearElement(WebElement element,String data,String objectName) {
	public static void clearElement(WebElement element) {		
		if (element.isDisplayed()) {
			element.clear();
			System.out.println("pass: Element cleared ");
		}
		else {
			System.out.println("Fail: Element is not displayed");
		}
	}

	public static void clickElement(WebElement element, long timeOut) {	
		WebDriverWait wait = new WebDriverWait (driver, timeOut);
		wait.until(ExpectedConditions.elementToBeClickable(element));

		if (element.isDisplayed()) {
			element.click();
		}
		else {
			System.out.println("Fail: Element is not found");
		}
	}

	public static boolean isElementPresent(WebElement element) {
		boolean exists = false;
		try {
			element.isDisplayed();
			exists = true;
		} catch (NoSuchElementException e) {
			exists = false;
		}
		return exists;
	}

	public static String getTextOfElement(WebElement element) {
		return element.getText();

	}

	public static void selectFromDropDown(WebElement dropdown, String value) {	

		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		Select drpDn = new Select(dropdown);
		drpDn.selectByVisibleText(value);

	}


	public static void switchToWindow(String title) {
/*		for (String handle : driver.getWindowHandles()) {
			if (driver.switchTo().window(handle).getTitle().contains(title)) {
				System.out.println("Switched to window with title:" + title);
				break;
			}

		}
*/	
		driver.switchTo().window(title);
	}

}
