package com.Automation.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.Automation.Base.Pages.BasePage;

public class DeveloperConsolePage extends BasePage {

	@FindBy (xpath ="//body[@onfocus='if(this.bodyOnFocus)bodyOnFocus();']") WebElement developer_consoleWindow ;
	
	public DeveloperConsolePage (WebDriver driver) {
		super(driver);
	}
	public boolean developer_ConsoleWindow() {
		if(developer_consoleWindow.isDisplayed()) {
			return true;
		}else {
			return false;
		}
	}
}
