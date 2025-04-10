package com.Automation.Tests;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.Automation.Base.BaseTest;
import com.Automation.Pages.DeveloperConsolePage;
import com.Automation.Pages.HomePage;
import com.Automation.Pages.LoginPage;
import com.Automation.Pages.MySettingsPage;
import com.Automation.Pages.ProfilePage;
import com.Automation.Utility.Constants;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class UserMenuDropDownTest extends BaseTest  {
	
	@Test
	public static void UserNavigation_menu() throws Exception  {	
		LoginPage lp = new LoginPage(driver);
	     HomePage hp = new HomePage(driver);
	     lp.enterUserName(usernamedata);
	  		lp.enterPassword(passworddata);
	  		lp.clickRemember_me();
	  		lp.clickLogin();
			Thread.sleep(3000);
			hp.click_user_Dropdownarrow();
			Thread.sleep(2000);
		
		if (hp.MyProfile_Option() && hp.MySettings_Option() && hp.Developer_Console_Option() && hp.LightningExperience_Option() && hp.Logout_Option() ) {
			mylog.info("The user navigation menu displayed with all options!");
			extentReportUtility.LogtestPassed("The user navigation menu displayed with all options!");

		}else {
			mylog.error("Check the user navigation menu options");
			extentReportUtility.LogtestFailed("Check the user navigation menu options");	
		}
		}
	@Test
	public static void My_profile() throws InterruptedException {
		LoginPage lp = new LoginPage(driver);
	     HomePage hp = new HomePage(driver);
	     ProfilePage pp = new ProfilePage(driver);
	     lp.enterUserName(usernamedata);
	  		lp.enterPassword(passworddata);
	  		lp.clickRemember_me();
	  		lp.clickLogin();
			Thread.sleep(3000);
			hp.click_user_Dropdownarrow();
		hp.click_MyProfile();
		Thread.sleep(3000);
		String expectedMy_profileheader = "Anjana Guruprasath";
		String actualMy_profileheader = pp.My_profileheader();
		if (expectedMy_profileheader.equals(actualMy_profileheader)) {
			mylog.info("User profile page is displayed!");
			extentReportUtility.LogtestPassed("User profile page is displayed!");
	}else {
		mylog.error("User profile page is not displayed!");
		extentReportUtility.LogtestFailed("User profile page is not displayed!");
	}
}
	@Test
	public static void Edit_profile() throws InterruptedException {
		LoginPage lp = new LoginPage(driver);
	     HomePage hp = new HomePage(driver);
	     ProfilePage pp = new ProfilePage(driver);
	     lp.enterUserName(usernamedata);
	  		lp.enterPassword(passworddata);
	  		lp.clickRemember_me();
	  		lp.clickLogin();
			Thread.sleep(5000);
			hp.click_user_Dropdownarrow();
		hp.click_MyProfile();
		Thread.sleep(3000);
		
		pp.click_Dropdown_arrow();
		pp.click_Edit_profile();
		Thread.sleep(3000);

        String expectedEditProfile_PopupHeader = "Edit Profile";
        String actualEditProfile_PopupHeader = pp.EditProfile_PopupHeader();
      if(expectedEditProfile_PopupHeader.equals(actualEditProfile_PopupHeader)) {
    	  mylog.info("Edit profile pop up window displayed!");
    	  extentReportUtility.LogtestPassed("Edit profile pop up window displayed!");
      }
      else {
    	  mylog.error("Edit profile pop up window not displayed!");
    	  extentReportUtility.LogtestFailed("Edit profile pop up window not displayed!");
      }
		driver.switchTo().frame("aboutMeContentId");  		
    	    	pp.click_Popup_About_tab();
    	    	pp.Enter_Last_name();
    	  		pp.click_Saveall();
	        
    	  		 driver.switchTo().defaultContent();
    	 		String actualMy_profileheader = pp.My_profileheader();
	  		String UpdatedMy_profileheader = "Guruprasath";
	  		if (actualMy_profileheader.contains(UpdatedMy_profileheader)) {
	  			mylog.info("User Name updated!");
	  			extentReportUtility.LogtestPassed("User Name updated!");
	  	}else {
	  		mylog.error("User Name not updated!");
	  		extentReportUtility.LogtestFailed("User Name not updated!");
		pp.MyProfileHeader_Screenshot();
	  	}
	  		}		
   @Test
	public static void Post_link() throws Exception {
	   LoginPage lp = new LoginPage(driver);
	     HomePage hp = new HomePage(driver);
	     ProfilePage pp = new ProfilePage(driver);
	     lp.enterUserName(usernamedata);
	  		lp.enterPassword(passworddata);
	  		lp.clickRemember_me();
	  		lp.clickLogin();
			Thread.sleep(5000);
			hp.click_user_Dropdownarrow();
		hp.click_MyProfile();
		Thread.sleep(3000);
		
		pp.click_Post_link();
		Thread.sleep(3000);
		pp.PostLink_Frame();
		pp.Enter_TextBox();
		 driver.switchTo().defaultContent();
		
		pp.click_SharePost();
				
		String expected_Newpost = "Hello World!";
		String actual_Newpost = pp.New_post();
		if (expected_Newpost.equals(actual_Newpost)) {
			mylog.info("Message posted successfully!");
			extentReportUtility.LogtestPassed("Message posted successfully!");
		}else {
			mylog.error("Message not posted!");
			extentReportUtility.LogtestFailed("Message not posted!");
		}
   }
	
	      @Test
	public static void File_link() throws Exception {
	    	  LoginPage lp = new LoginPage(driver);
	 	     HomePage hp = new HomePage(driver);
	 	     ProfilePage pp = new ProfilePage(driver);
	 	     lp.enterUserName(usernamedata);
	 	  		lp.enterPassword(passworddata);
	 	  		lp.clickRemember_me();
	 	  		lp.clickLogin();
	 			Thread.sleep(5000);
	 			hp.click_user_Dropdownarrow();
	 		hp.click_MyProfile();
	 		Thread.sleep(3000);

		pp.click_File_link();
		Thread.sleep(3000);
		pp.click_Upload_from_computer();
		pp.Enter_FilePath();
		pp.click_ShareFile();
			Thread.sleep(3000);
			mylog.info("File uploaded succesfully!");
			extentReportUtility.LogtestPassed("File uploaded succesfully!");
	      }
	@Test
	public static void Add_photo() throws Exception {
		LoginPage lp = new LoginPage(driver);
	     HomePage hp = new HomePage(driver);
	     ProfilePage pp = new ProfilePage(driver);
	     lp.enterUserName(usernamedata);
	  		lp.enterPassword(passworddata);
	  		lp.clickRemember_me();
	  		lp.clickLogin();
			Thread.sleep(5000);
			hp.click_user_Dropdownarrow();
		hp.click_MyProfile();
		Thread.sleep(3000);
		pp.click_Moderate();
  		
		String expected_UploadPhotoHeader = "Upload Profile Photo";
		String actual_UploadPhotoHeader = pp.UploadPhoto_Header();
		if (expected_UploadPhotoHeader.equals(actual_UploadPhotoHeader) ){
		pp.Picture_frame();
		pp.Enter_PicPath();
		driver.switchTo().defaultContent();
		Thread.sleep(2000);
		
		pp.Picture_frame();
		pp.click_SavePic();
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		Thread.sleep(2000);
		pp.Picture_frame();
		Thread.sleep(2000);
		pp.click_savebtn_photoframe();
		mylog.info("Photo uploaded successfully..");
		extentReportUtility.LogtestPassed("Photo uploaded successfully..");
		Thread.sleep(3000);
		driver.switchTo().defaultContent();
		}
		else {
		driver.switchTo().defaultContent();
			mylog.error("Photo uploaded successfully..");
			extentReportUtility.LogtestFailed("Photo uploaded successfully..");
		}
	}
	      @Test
	public static void My_Settings() throws InterruptedException {
	    	  LoginPage lp = new LoginPage(driver);
	 	     HomePage hp = new HomePage(driver);
	 	    MySettingsPage sp = new MySettingsPage(driver);
		     lp.enterUserName(usernamedata);
		  		lp.enterPassword(passworddata);
		  		lp.clickRemember_me();
		  		lp.clickLogin();
				Thread.sleep(3000);
				hp.click_user_Dropdownarrow();

	  		hp.click_MySettings();
		sp.click_Personal();
		sp.click_LoginHistoryTab();
		
		String expected_Login_history_header = "Login History";
		String actual_Login_history_header = sp.LoginHistory_header();
		if (expected_Login_history_header.equals(actual_Login_history_header)) {
			mylog.info("Login History Page displayed!");
			extentReportUtility.LogtestPassed("Login History Page displayed!");
		}else {
			mylog.error("Login History Page not displayed!");
			extentReportUtility.LogtestFailed("Login History Page not displayed!");
		}
		sp.click_DisplayandLayoutTab();
		sp.click_CustomiseMyTabs();
		sp.click_SalesforceChatter();
		sp.click_Reports();
		sp.click_AddButton();
		
		
		if (sp.SelectedTabs_list().contains("Reports") && sp.SelectedTabs_list().contains("Chatter"))
		{
			mylog.info("Reports and Chatter tabs added!");
			extentReportUtility.LogtestPassed("Reports and Chatter tabs added!");	
			sp.click_SelectedTabs_SaveButton();
		}else {
			mylog.error("Reports and Chatter tabs not added!");
			extentReportUtility.LogtestFailed("Reports and Chatter tabs not added!");
		}
		Thread.sleep(5000);
		
		//Email
		sp.click_Email_tab();
		sp.click_MyEmailSettings();	
		sp.enter_EmailName();
		sp.enter_EmailAddress();
		sp.click_Automatic_Bcc();
		sp.click_SaveEmailSettings();
		
		if (sp.SavedEmail_ConfirmationMsg()) {
			mylog.info("Changes to email settings not saved!");
			extentReportUtility.LogtestPassed("Changes to email settings not saved!");
		}else {
			mylog.error("Changes to email settings saves successfully!");
			extentReportUtility.LogtestFailed("Reports and Chatter tabs not added!");
		}
		
		//Calendars and reminders
		
		sp.click_CalendarsAndRemindersTab();
		sp.click_ActivityReminders();
		sp.click_OpenTestRemainder();
		
		Thread.sleep(5000);
		
		String Testreminderwindow_Handle = driver.getWindowHandle();

		for (String handle : driver.getWindowHandles()) {
		    if (!handle.equals(Testreminderwindow_Handle)) {
		        driver.switchTo().window(handle);  
		        break;
		    }
		}
		    if (sp.ReminderPopup()) {
		    	mylog.info("Reminder pop-up is displayed.");
		    	extentReportUtility.LogtestPassed("Reminder pop-up is displayed.");
		    	sp.click_DismissAllPopup();
		    } else {
		    	mylog.error("Reminder pop-up is not displayed.");
		    	extentReportUtility.LogtestFailed("Reminder pop-up is not displayed.");
		 }
	        driver.switchTo().window(Testreminderwindow_Handle);  
		Thread.sleep(3000);
}

	@Test
	public static void Developer_console() throws Exception {
		LoginPage lp = new LoginPage(driver);
	     HomePage hp = new HomePage(driver);
	     DeveloperConsolePage dp = new DeveloperConsolePage(driver);

	     lp.enterUserName(usernamedata);
	  		lp.enterPassword(passworddata);
	  		lp.clickRemember_me();
	  		lp.clickLogin();
			Thread.sleep(3000);
			hp.click_user_Dropdownarrow();
		String Main_WindowHandle= driver.getWindowHandle();
		hp.click_DeveloperConsole();
		Thread.sleep(3000);
		
		for (String handle : driver.getWindowHandles()) {
		    if (handle.equals(Main_WindowHandle)) {
		        driver.switchTo().window(handle);  
		        mylog.info("Switched to pop up window");
		        break;
		    }
		}
		Thread.sleep(5000);
            if(dp.developer_ConsoleWindow()) {
            	mylog.info("Developer console window is displayed.");
            	extentReportUtility.LogtestPassed("Developer console window is displayed.");
            	Thread.sleep(5000);
            } else {
            	mylog.error("Developer console window is not displayed.");
            	extentReportUtility.LogtestFailed("Developer console window is not displayed.");
            }
	        driver.switchTo().window(Main_WindowHandle)  ;
	        Thread.sleep(2000);
	}
	@Test
	public static void Logout() throws Exception {
		LoginPage lp = new LoginPage(driver);
	     HomePage hp = new HomePage(driver);
	     lp.enterUserName(usernamedata);
	  		lp.enterPassword(passworddata);
	  		lp.clickRemember_me();
	  		lp.clickLogin();
			Thread.sleep(3000);
			hp.click_user_Dropdownarrow();
			hp.click_Logout();
			Thread.sleep(3000);
		
		WebElement Login_page = driver.findElement(By.id("left"));
		
		if (Login_page.isDisplayed()) {
			mylog.info("Login page is displayed!");
        	extentReportUtility.LogtestPassed("Login page is displayed!");
		}else {
			mylog.error("Login page is not displayed!");
        	extentReportUtility.LogtestFailed("Login page is not displayed!");
		}
}
}
