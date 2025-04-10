package com.Automation.Base;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;

import com.Automation.Base.Pages.BasePage;
import com.Automation.Pages.HomePage;
import com.Automation.Pages.LoginPage;
import com.Automation.Tests.LoginTest;
import com.Automation.Utility.Constants;
import com.Automation.Utility.ExtentReportsUtility;
import com.Automation.Utility.PropertiesUtility;
import com.google.common.io.Files;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	protected static Logger mylog =LogManager.getLogger(BaseTest.class);
	protected static ExtentReportsUtility extentReportUtility = ExtentReportsUtility.getInstance();

	protected static WebDriver driver;
	public static WebDriverWait wait = null;
	public static String usernamedata = PropertiesUtility.readDataFromPropertyFile(Constants.APPLICATION_PROPERTIES, "username");
	public static String wrongpassworddata = PropertiesUtility.readDataFromPropertyFile(Constants.APPLICATION_PROPERTIES, "wrongpassword");
	protected static String passworddata = PropertiesUtility.readDataFromPropertyFile(Constants.APPLICATION_PROPERTIES, "password");
	
	public static void LaunchBrowser(String browserName)
	
	{
		switch (browserName.toLowerCase()) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			break;

		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			break;
			
		case "safari":
			WebDriverManager.safaridriver().setup();
			driver=new SafariDriver();
			break;
			
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
			break;
		
			
		default: System.out.println("invalid browser");
			break;
		}
	}
	
	public static void goToUrl(String url) throws Exception
	{
		driver.get(url);
		System.out.println(url+" is entered");
		driver.manage().window().maximize();
		Thread.sleep(5000);
	}
	
	public static void closeDriver() throws Exception
	{
		Thread.sleep(5000);
		driver.close();
	}
	
	@BeforeMethod
	public void SetUpBeforeMethod(@Optional ("firefox") String browserName) throws Exception {
		Thread.sleep(3000);
		LaunchBrowser(browserName);
		String url = PropertiesUtility.readDataFromPropertyFile(Constants.APPLICATION_PROPERTIES, "url");
		goToUrl(url);	
	}

	@AfterMethod
	public void TearDownAfterMethod() throws Exception {
       driver.close();	
       Thread.sleep(3000);
	}
	
}
