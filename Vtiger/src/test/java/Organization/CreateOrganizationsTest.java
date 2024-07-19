package Organization;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

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
import Object_Repository.CreateOrganizationPage;
import Object_Repository.VtigerHomePage;
import Object_Repository.VtigerLoginPage;
@Test
public class CreateOrganizationsTest extends BaseClass {
	public void createOrganizationsTest() throws Throwable {

		VtigerHomePage homePage= new VtigerHomePage(driver);
		homePage.clickOrganizationLink();
		
		CreateOrganizationPage OrgPage=new CreateOrganizationPage(driver);
		OrgPage.clickPlusImg();
		
		int ranNum = jutil.getRandomNumber();
		
		String orgData =eutil.getExcelData("Organization", 0, 0)+ranNum;
		String phoneNum = eutil.getExcelDataUsingDataFormatter("Organization",0,1);
        String emailId = eutil.getExcelDataUsingDataFormatter("Organization",0,2);
		
        OrgPage.enterOrganizationData(orgData, phoneNum, emailId);
        
		
		  //       driver.findElement(By.name("accountname")).sendKeys(orgData);

		         OrgPage.clickOnSaveButton();       

		         Thread.sleep(2000);

homePage.clickAdmImg();
homePage.clickOnSignOut();
	}

}
