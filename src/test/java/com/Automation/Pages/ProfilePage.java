package com.Automation.Pages;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.Automation.Base.Pages.BasePage;
import com.Automation.Utility.Constants;

public class ProfilePage extends BasePage {

	
	@FindBy (xpath ="//a[@title='User Action Menu']") WebElement dropdown_arrow ;
	@FindBy (xpath ="//a[@title='Edit Profile']") WebElement Edit_profile ;
	@FindBy (xpath ="//li[@id='aboutTab']") WebElement Popup_About_tab ;
	@FindBy (xpath ="//input[@name='lastName']") WebElement Last_name ;
	@FindBy (xpath ="//input[@value='Save All']") WebElement Save_all ;
	@FindBy (xpath ="//a[@id='publisherAttachTextPost']") WebElement Post_link ;
	@FindBy (xpath ="//body[@aria-label='Rich Text Editor, publisherRichTextEditor']") WebElement Text_box ;
	@FindBy (xpath ="//input[@title='Share']") WebElement SharePost ;
	@FindBy (xpath ="//a[@title='File']") WebElement File_link ;
	@FindBy (xpath ="//a[@title='Upload a file from your computer']") WebElement Upload_from_computer ;
	@FindBy (id ="chatterFile") WebElement Choose_file ;
	@FindBy (xpath ="//input[@id='publishersharebutton']") WebElement ShareFile ;
	@FindBy (xpath ="//*[contains(text(),'Moderator')]") WebElement Moderate ;
	@FindBy (xpath ="//input[@class='fileInput']") WebElement Choosepic ;
	@FindBy (xpath ="//*[@id='j_id0:uploadFileForm:uploadBtn' and @value='Save']") WebElement SavePic ;
	@FindBy (id ="uploadPhotoContentId") WebElement switch_frame ;
	@FindBy (xpath ="j_id0:j_id7:save") WebElement savebtn_photoframe ;
	@FindBy (xpath ="//span[@id='tailBreadcrumbNode']") WebElement My_profileheader ;
	@FindBy (xpath ="//h2[@id='aboutMeTitle']") WebElement EditProfile_PopupHeader ;
	@FindBy (xpath ="//iframe[@title='Rich Text Editor, publisherRichTextEditor']") WebElement PostLink_Frame ;
	@FindBy (id ="0D5gK0000007e5Z") WebElement New_post ;
	@FindBy (id ="uploadPhotoTitle") WebElement UploadPhoto_Header ;


	public ProfilePage (WebDriver driver) {
		super(driver);
	}
	public void click_Dropdown_arrow() {
		ClickElement (dropdown_arrow,"dropdown_arrow");
	}
	public void click_Edit_profile() {
		ClickElement (Edit_profile,"Edit_profile");
	}
	public void click_Popup_About_tab() {
		ClickElement (Popup_About_tab,"Popup_About_tab");
	}
	public void Enter_Last_name() {
		Last_name.clear();
		EnterText(Last_name,"Guruprasath", "Last_name");
	}
	public void click_Saveall() {
		ClickElement(Save_all,"Save_all");
	}
	public void click_Post_link() {
		ClickElement(Post_link,"Post_link");
	}
	public void Enter_TextBox() {
		EnterText(Text_box,"Hello World!", "TextBox");
	}
	public void click_SharePost() {
		ClickElement(SharePost,"SharePost");
	}
	public void click_File_link() {
		ClickElement(File_link,"File_link");
	}
	public void click_Upload_from_computer() {
		ClickElement(Upload_from_computer,"Upload_from_computer");
	}
	public void Enter_FilePath() {
		String filePath = "/Users/anjanaguruprasath/Desktop/Hello World.docx"; 
		EnterText(Choose_file, filePath, "filePath");
	}
	public void click_ShareFile() {
		ClickElement(ShareFile,"ShareFile");
	}
	public void click_Moderate() {
		ClickElement(Moderate, "Moderate");
	}
	public void Enter_PicPath() {
		String PicPath = "/Users/anjanaguruprasath/Desktop/peach-flowers.jpg"; 
		EnterText(Choosepic, PicPath, "PicPath");
	}
		public void click_SavePic() throws Exception {
			Thread.sleep(2000);
			ClickElement(SavePic,"SavePic");
}
		public void Picture_frame() throws Exception {
			Thread.sleep(3000);
			SwitchFrame(switch_frame);
		}
		public void click_savebtn_photoframe() throws Exception {
			Thread.sleep(2000);
			ClickElement(savebtn_photoframe,"savebtn_photoframe");
}
		public String My_profileheader() {
			return GetTextFromElement(My_profileheader, "My_profileheader");
		}
		public String EditProfile_PopupHeader() {
			return GetTextFromElement(EditProfile_PopupHeader, "EditProfile_PopupHeader");
		}
		public void MyProfileHeader_Screenshot() {
			String finalname=new SimpleDateFormat ("yyyy_MM_dd_HH_mm_ss").format(new Date());
			takeScreenshot(Constants.SCREENSHOTS_DIRECTORY_PATH+finalname+".png");
		}
		public void PostLink_Frame() throws Exception {
			Thread.sleep(3000);
			SwitchFrame(PostLink_Frame);
		}
		public String New_post() {
			return GetTextFromElement(New_post, "New_post");
		}
		public String UploadPhoto_Header() {
			return GetTextFromElement(UploadPhoto_Header, "UploadPhoto_Header");
		}
		
}