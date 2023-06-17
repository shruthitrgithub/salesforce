package com.automation.base;

import java.io.File;
import java.util.Properties;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.automation.utility.ExtentReportsUtility;
import com.automation.utility.Log4JUtility;
import com.automation.utility.PropertiesUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	protected Logger log;
	public  static WebDriver driver;
	protected Log4JUtility logObject=Log4JUtility.getInstance();
	protected ExtentReportsUtility report = ExtentReportsUtility.getInstance();
	
	@BeforeTest
	public void setUpForBeforeTest() {
		log=logObject.getLogger();
	}
	
	@BeforeMethod
	@Parameters("browserName")
	public void setUpBeforeTestMethod(@Optional("chrome") String browName) {
		PropertiesUtility pro=new PropertiesUtility();
		Properties appProp= pro.loadFile("applicationDataProperties");
		String url = appProp.getProperty("url");
		launchBrowser(browName);
		goToUrl(url);
		
	}
	
	@AfterMethod
	public void tearDownAfterTestMethod() {
		
	}

	public static void launchBrowser(String browserName) {
		switch (browserName) {
		case"firefox":
			WebDriverManager.firefoxdriver().browserVersion("109.0.1").setup();
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			break;
		case"chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			break;
		}
		System.out.println(browserName+"browser opened");
	}
	
	public static void goToUrl(String url) {
		driver.get(url);		
	}

	public File getScreenshotOfThePage(WebDriver driver2) {
		// TODO Auto-generated method stub
		return null;
	}

}
