package Campaigns;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import Generic_Utilities.BaseClass;
import Generic_Utilities.Excel_Utility;
import Generic_Utilities.File_Utility;
import Generic_Utilities.Java_Utility;
import Generic_Utilities.WebDriver_Utility;
import Object_Repository.CreateCampaignPage;
import Object_Repository.VtigerHomePage;
import Object_Repository.VtigerLoginPage;

public class CreateCampaignsTest extends BaseClass {

	
@Test
	public void createCampaignsTest() throws Throwable {
		
		VtigerHomePage homePage= new VtigerHomePage(driver);
		homePage.clickMoreLink();
		homePage.clickCampaignsLink();
		CreateCampaignPage campaignPage=new CreateCampaignPage(driver);
		campaignPage.clickOnPlusSign();
		int ranNum = jutil.getRandomNumber();
		Excel_Utility eLib = new Excel_Utility();
		String campData = eLib.getExcelData("Campaign", 0, 0) + ranNum;
		
		campaignPage.enterCampaignName(campData);     
		campaignPage.clickOnSaveButton();
		
		Thread.sleep(2000);
		homePage.clickAdmImg();
		homePage.clickOnSignOut();
	}
}
