package com.Automation.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.Automation.Base.Pages.BasePage;

public class MySettingsPage extends BasePage {
	
	@FindBy (xpath ="//*[@id='PersonalInfo']/a") WebElement Personal ;
	@FindBy (xpath ="//span[@class='leafText' and @id='LoginHistory_font']") WebElement login_history_tab ;
	@FindBy (xpath ="//span[@class='folderText' and @id='DisplayAndLayout_font' ]") WebElement display_and_layout_tab ;
	@FindBy (xpath ="//span[@class='leafText' and @id='CustomizeTabs_font' ]") WebElement Customise_my_tabs ;
	@FindBy (xpath ="//*[@value='02ugK0000006lFx']") WebElement saleforce_chatter ;
	@FindBy (xpath ="//*[@value='report']") WebElement Reports ;
	@FindBy (xpath ="//*[@id='duel_select_0_right']") WebElement Add_button ;
	@FindBy (xpath ="//*[@value=' Save ']") WebElement SelectedTabs_SaveButton ;
	@FindBy (xpath ="//*[@id='EmailSetup_font']") WebElement Email_tab ;
	@FindBy (xpath ="//*[@id='EmailSettings_font' and @class='leafText']") WebElement My_email_settings ;
	@FindBy (id ="sender_name") WebElement Email_name ;
	@FindBy (id ="sender_email") WebElement Email_address ;
	@FindBy (id ="auto_bcc1") WebElement Automatic_Bcc ;
	@FindBy (xpath ="//*[@id='bottomButtonRow']/input[1]") WebElement Save_EmailSettings ;
	@FindBy (id ="CalendarAndReminders_font") WebElement Calendars_and_reminders_tab ;
	@FindBy (xpath ="//*[@id='Reminders_font' and @class = 'leafText']") WebElement Activity_reminders ;
	@FindBy (id ="testbtn") WebElement Open_a_test_Remainder ;
	@FindBy (id ="dismiss_all") WebElement Dismiss_all ;
	@FindBy (xpath ="//h1[@class='noSecondHeader pageType']") WebElement Login_history_header ;
	@FindBy (id ="duel_select_1") WebElement SelectedTabs_list ;
	@FindBy (id ="meSaveCompleteMessage") WebElement SavedEmail_ConfirmationMsg ;
	@FindBy (name ="reminder") WebElement ReminderPopup ;


	public MySettingsPage (WebDriver driver) {
		super(driver);
	}
	public void click_Personal() {
		ClickElement (Personal,"Personal");
	}
	public void click_LoginHistoryTab() {
		ClickElement (login_history_tab,"login_history_tab");
	}
	public void click_DisplayandLayoutTab() {
		ClickElement (display_and_layout_tab,"display_and_layout_tab");
	}
	public void click_CustomiseMyTabs() {
		ClickElement (Customise_my_tabs,"Customise_my_tabs");
	}
	public void click_SalesforceChatter() {
		ClickElement (saleforce_chatter,"saleforce_chatter");
	}
	public void click_Reports() {
		ClickElement (Reports,"Reports");
	}
	public void click_AddButton() {
		ClickElement (Add_button,"Add_button");
	}
	public void click_SelectedTabs_SaveButton() {
		ClickElement (SelectedTabs_SaveButton,"SelectedTabs_SaveButton");
	}
	public void click_Email_tab() {
		ClickElement (Email_tab,"Email_tab");
	}
	public void click_MyEmailSettings() {
		ClickElement (My_email_settings,"My_email_settings");
	}
	public void enter_EmailName() {
		EnterText(Email_name, "Anjana Jayaraman","Email_name");	
		}
	public void enter_EmailAddress() {
		EnterText(Email_address, "anjuu05@gmail.com","Email_address");	
		}
	public void click_Automatic_Bcc() {
		ClickElement(Automatic_Bcc, "Automatic_Bcc");	
		}
	public void click_SaveEmailSettings() {
		ClickElement(Save_EmailSettings, "Save_EmailSettings");	
		}
	public void click_CalendarsAndRemindersTab() {
		ClickElement(Calendars_and_reminders_tab, "Calendars_and_reminders_tab");	
		}
	public void click_ActivityReminders() {
		ClickElement(Activity_reminders, "Activity_reminders");	
		}
	public void click_OpenTestRemainder() {
		ClickElement(Open_a_test_Remainder, "Open_a_test_Remainder");	
		}
	public void click_DismissAllPopup() {
		ClickElement(Dismiss_all, "Dismiss_all");	
		}
	public String LoginHistory_header() {
		return GetTextFromElement(Login_history_header, "Login_history_header");
	}
	public String SelectedTabs_list() {
		return GetTextFromElement(SelectedTabs_list, "SelectedTabs_list");
	}
	public boolean SavedEmail_ConfirmationMsg() {
		if(SavedEmail_ConfirmationMsg.isDisplayed()) {
			return true;
		}else {
			return false;
		}
	}
	public boolean ReminderPopup() {
		if(ReminderPopup.isDisplayed()) {
			return true;
		}else {
			return false;
		}
	}
	
}
