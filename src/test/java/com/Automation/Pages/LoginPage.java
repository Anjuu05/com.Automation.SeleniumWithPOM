package com.Automation.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Automation.Base.Pages.BasePage;

public class LoginPage extends BasePage {

		@FindBy (id ="username") WebElement UserName ;
		@FindBy (id ="password") WebElement Password ;
		@FindBy (xpath ="//*[@id='rememberUn']") WebElement Remember_me ;
		@FindBy (id ="Login") WebElement Login_button ;
		@FindBy (id="forgot_password_link") WebElement ForgotPassword;
		@FindBy (id="error") WebElement InvalidLoginErrorMessage;
		@FindBy (id="header") WebElement ForgotPassword_header;
		@FindBy (id="un") WebElement ForgotPassword_Username;
		@FindBy (id="continue") WebElement ForgotPassword_ContinueButton;
		@FindBy (id="header") WebElement EmailSent_header;


		WebDriver driver;
		public LoginPage (WebDriver driver) {
			super(driver);
		}
		
		public void enterUserName (String data) {
			EnterText(UserName,data, "UserName");
		}
		public void enterPassword (String data) {
			EnterText(Password,data, "Password");
		}
		public void clickRemember_me() {
			ClickElement(Remember_me,"Remember_me");
		}
		public void clickLogin() {
			ClickElement(Login_button,"Login_button");
		}
		public WebDriver clickForgotPassword() {
			ClickElement(ForgotPassword, "ForgotPassword");
			return driver;
		}
		public String InvalidLoginErrorMessage() {
			return GetTextFromElement(InvalidLoginErrorMessage, "InvalidLoginErrorMessage");
}
		public String ForgotPassword_header() {
			return GetTextFromElement(ForgotPassword_header, "ForgotPassword_header");
}
		public void enter_ForgotPassword_Username (String data) {
			EnterText(ForgotPassword_Username,data, "ForgotPassword_Username");
}
		public void ForgotPassword_ContinueButton() {
			ClickElement(ForgotPassword_ContinueButton,"ForgotPassword_ContinueButton");
		}
		public String ForgotPassword_EmailSent_header() {
			return GetTextFromElement(EmailSent_header, "EmailSent_header");
}
}