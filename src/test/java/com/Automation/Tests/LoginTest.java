package com.Automation.Tests;

import java.io.File;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Test;

import com.Automation.Base.BaseTest;
import com.Automation.Base.Pages.BasePage;
import com.Automation.Pages.HomePage;
import com.Automation.Pages.LoginPage;
import com.Automation.Utility.Constants;
import com.Automation.Utility.PropertiesUtility;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class LoginTest extends BaseTest{
	
	@Test
	public static void logout() throws Exception  {
		LoginPage lp = new LoginPage(driver);
	    HomePage hp = new HomePage(driver); 

		lp.enterUserName(usernamedata);
		lp.enterPassword(passworddata);
		lp.clickRemember_me();
		lp.clickLogin();
		hp.click_user_Dropdownarrow();
		hp.click_Logout();
		Thread.sleep(3000);
		
		String actualusername = "anjuu05513@agentforce.com";
		WebElement username = driver.findElement(By.id("idcard-identity"));
		
		if (username.getText().contentEquals(actualusername)) {
			mylog.info("After logging out Username is displayed while remember me is checked! " );
			extentReportUtility.logTestInfo("After logging out Username is displayed while remember me is checked! ");
			
	}		
	}
	@Test
	public static void Salesforce_login() throws Exception {
		LoginPage lp = new LoginPage(driver);
	    HomePage hp = new HomePage(driver);
		lp.enterUserName(usernamedata);
		lp.enterPassword(passworddata);
		lp.clickRemember_me();
		lp.clickLogin();
				mylog.info("Succesfully logged in!");
		extentReportUtility.LogtestPassed("Succesfully logged in!");

	}
	@Test
	public static void Salesforce_InvalidLogin_ValidteErrorMessage() {
		LoginPage lp = new LoginPage(driver);
	    HomePage hp = new HomePage(driver);
		
		lp.enterUserName(usernamedata);
		lp.enterPassword(wrongpassworddata);
		lp.clickLogin();
		String expected_Errormessage = "Please check your username and password. If you still can't log in, contact your Salesforce administrator.";
		String actual_Errormessage=lp.InvalidLoginErrorMessage();
				
				if(actual_Errormessage.equals(expected_Errormessage)) {
				mylog.info("Correct error message is displayed!");
				extentReportUtility.LogtestPassed("Correct error message is displayed!");
			}else{
				mylog.error("Mistake in error message!");
				extentReportUtility.LogtestFailed("Mistake in error message!");
			}		
		}
	@Test
	public static void Forgot_password() throws Exception {
		LoginPage lp = new LoginPage(driver);
	    HomePage hp = new HomePage(driver);
		
		lp.enterUserName(usernamedata);
		lp.clickForgotPassword();
		
		Thread.sleep(2000);
		String expectedForgotPasswordHeader = "Forgot Your Password";
		String actualForgotPasswordHeader = lp.ForgotPassword_header();
		if (expectedForgotPasswordHeader.equals(actualForgotPasswordHeader)) {
			mylog.info("Forgot Password page is displayed!");
			extentReportUtility.LogtestPassed("Forgot Password page is displayed!");
		}else {
			mylog.error("Forgot Password page is not displayed!");
			extentReportUtility.LogtestFailed("Forgot Password page is not displayed!");
		}		
		lp.enter_ForgotPassword_Username(usernamedata);		
		lp.ForgotPassword_ContinueButton();	
		Thread.sleep(2000);
		
		String expectedEmailSent_header = "Check Your Email";
		String actualEmailSent_header = lp.ForgotPassword_EmailSent_header();
		if (expectedEmailSent_header.equals(actualEmailSent_header)) {
			mylog.info("Email sent!");
			extentReportUtility.LogtestPassed("Email sent!");

		}else {
			mylog.error("Email not sent!");
			extentReportUtility.LogtestFailed("Email not sent!");
		}
}
}


