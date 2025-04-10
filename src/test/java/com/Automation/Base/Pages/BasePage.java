package com.Automation.Base.Pages;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Automation.Base.BaseTest;
import com.Automation.Utility.ExtentReportsUtility;
import com.google.common.io.Files;

public class BasePage {
	
	protected static Logger mylog =LogManager.getLogger(BasePage.class);
	protected static ExtentReportsUtility extentReportUtility = ExtentReportsUtility.getInstance();

	private static WebDriver driver;
	public static WebDriverWait wait = null;
	
	public BasePage (WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public static void EnterText(WebElement ele, String data, String objName)
	{
		if(ele.isDisplayed())
		{
			ele.clear();
			ele.sendKeys(data);
			mylog.info("Data is entered to "+objName);
			extentReportUtility.logTestInfo("Data is entered to "+objName);
		}
		else
		{
			mylog.error(objName+" textbox is not displayed");
			extentReportUtility.LogtestFailed(objName+" textbox is not displayed");
		}
	}
	
	public static void ClickElement (WebElement ele, String objName)
	{
		if(ele.isEnabled())
		{
			ele.click();
			mylog.info(objName+" button is clicked!");
			extentReportUtility.logTestInfo(objName+" button is clicked!");
		}
		else {
			mylog.error(objName+" button is not displayed!");
			extentReportUtility.LogtestFailed(objName+" button is not displayed!");
		}
	}
	public String GetTextFromElement(WebElement ele, String objName) {
		String data = null;
		if(ele.isDisplayed()) {
			data=ele.getText();
		}else {
			mylog.error(objName+" not displayed!");
		}
		return data;
	}
	
	public static void selectByValue(WebElement ele, String value)
	{
		Select select =new Select(ele);
		select.selectByValue(value);
		mylog.info(value+" got selected from dropdown list");
		extentReportUtility.logTestInfo(value+" got selected from dropdown list");
	}
	
	public static void selectByIndex(WebElement ele, int index)
	{
		Select select =new Select(ele);
		select.selectByIndex(index);
		mylog.info(index+" got selected from dropdown list");
		extentReportUtility.logTestInfo(index+" got selected from dropdown list");
	}
	
	public static void selectByVisibleText(WebElement ele, String value)
	{
		Select select =new Select(ele);
		select.selectByVisibleText(value);;
		mylog.info(value+" got selected from dropdown list");
		extentReportUtility.logTestInfo(value+" got selected from dropdown list");
	}
	public static void SwitchFrame(WebElement ele) {
		driver.switchTo().frame(ele);
		mylog.info("Switched Frame");
		extentReportUtility.logTestInfo("Switched Frame!");
	}
	public static void Closedriver() throws InterruptedException {
		Thread.sleep(5000);
	//	driver.close();
	}
	public static void waitForAlertToPresent(long timeInSec,String ObjectName) { 
		System.out.println(ObjectName+ "waiting for visibility for maximum of "+timeInSec+ "sec"); 
	//	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		wait.until(ExpectedConditions.alertIsPresent()); 
	}
	public static void takeScreenshot(String filepath) {
		TakesScreenshot screenCapture = (TakesScreenshot) driver;
		File src = screenCapture.getScreenshotAs(OutputType.FILE);
		File destFile = new File (filepath);
		try {
			Files.copy(src, destFile);
			mylog.info("Screen captured");
			extentReportUtility.logTestInfo("Screen captured");
		}catch (IOException e) {
			e.printStackTrace();
			mylog.error("Problem taking screenshot!");
			extentReportUtility.LogtestFailed("Problem taking screenshot!");
		}
	}
}
