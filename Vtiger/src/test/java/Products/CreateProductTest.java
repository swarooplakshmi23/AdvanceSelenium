package Products;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import Generic_Utilities.BaseClass;
import Generic_Utilities.Excel_Utility;
import Generic_Utilities.File_Utility;
import Generic_Utilities.Java_Utility;
import Generic_Utilities.WebDriver_Utility;
import Object_Repository.CreateProductPage;
import Object_Repository.VtigerHomePage;
import Object_Repository.VtigerLoginPage;

public class CreateProductTest extends BaseClass{
@Test
	public  void createProductTest() throws Throwable {
      
	        
	VtigerHomePage homePage= new VtigerHomePage(driver);
		homePage.clickProductLink();
		
		 CreateProductPage productPage=new CreateProductPage(driver);
     
		 productPage.clickPlusImg();
		int ranNum = jutil.getRandomNumber();
		String prdData =eutil.getExcelData("Product", 0, 0)+ranNum;
		productPage.enterProductName(prdData);

		productPage.clickOnSaveButton();
   
		
		Thread.sleep(2000);
		
		homePage.clickAdmImg();
		homePage.clickOnSignOut();

	}

}
