package com.Automation.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Automation.Base.Pages.BasePage;

public class HomePage extends BasePage{
	@FindBy (xpath ="//*[@title='My Profile']") WebElement myprofile ;
	@FindBy (xpath ="//*[@title='My Settings']") WebElement mysettings ;
	@FindBy (xpath ="//*[@title='Developer Console (New Window)']") WebElement developer_console ;
	@FindBy (xpath ="//*[@title='Switch to Lightning Experience']") WebElement lightning_experience ;
	@FindBy (xpath ="//*[@title='Logout']") WebElement logout ;
	@FindBy (id ="userNav-arrow") WebElement user_Dropdownarrow ;
	@FindBy (id ="Account_Tab") WebElement Accounts_tab ;
	@FindBy (id ="Contact_Tab") WebElement Contacts_tab ;
	@FindBy (id ="Lead_Tab") WebElement Leads_tab ;
	@FindBy (xpath ="//*[starts-with(@title, 'Opportunities')]") WebElement Opportunities_tab ;

	public HomePage (WebDriver driver) {
		super(driver);
	}
	public void click_MyProfile() {
		myprofile.click();
	}
	public void click_MySettings() {
		mysettings.click();
	}
	public void click_DeveloperConsole() {
		developer_console.click();
	}
	public void click_LightningExperience() {
		lightning_experience.click();
	}
	public void click_Logout() {
		logout.click();
	}
	public void click_user_Dropdownarrow() {
		user_Dropdownarrow.click();
	}
	public void click_AccountTab() {
		Accounts_tab.click();
	}
	public void click_ContactsTab() {
		Contacts_tab.click();
	}
	public void click_OpportunityTab() {
		Opportunities_tab.click();
	}
	public void click_LeadsTab() {
		Leads_tab.click();
	}
	public boolean MyProfile_Option(){
		if (myprofile.isDisplayed()){
			return true;
		}else {
			return false;
		}
	}
	public boolean MySettings_Option(){
		if (mysettings.isDisplayed()){
			return true;
		}else {
			return false;
		}
	}
	public boolean Developer_Console_Option(){
		if (developer_console.isDisplayed()){
			return true;
		}else {
			return false;
		}
	}
	public boolean LightningExperience_Option(){
		if (lightning_experience.isDisplayed()){
			return true;
		}else {
			return false;
		}
	}
	public boolean Logout_Option(){
		if (logout.isDisplayed()){
			return true;
		}else {
			return false;
		}
	}
	
}
