package Products;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.List;
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

import Generic_Utilities.BaseClass;
import Generic_Utilities.Excel_Utility;
import Generic_Utilities.File_Utility;
import Generic_Utilities.Java_Utility;
import Generic_Utilities.WebDriver_Utility;
import Object_Repository.CreateProductPage;
import Object_Repository.DeleteProd;
import Object_Repository.VtigerHomePage;
import Object_Repository.VtigerLoginPage;

public class CreateProductAndDeleteProductTest extends BaseClass {

	public void createProductAndDeleteProductTest() throws Throwable {
		
		VtigerHomePage homePage= new VtigerHomePage(driver);	
		homePage.clickProductLink();
		
		CreateProductPage productPage=new CreateProductPage(driver);
		productPage.clickPlusImg();
 
		int ranNum = jutil.getRandomNumber();
	
		 String prdData =eutil.getExcelData("Product", 0, 0)+ranNum;
		productPage.enterProductName(prdData);
    
		productPage.clickOnSaveButton();
    
		homePage.clickProductLink();
     
		DeleteProd deleteProdPage =new DeleteProd(driver);

		deleteProdPage.selectPrdCheckBox(driver, prdData);

		deleteProdPage.clickOnDeleteButton();       

		wdu.alertAccept(driver);

		deleteProdPage.ValidatePrdName(driver, prdData);

	Thread.sleep(2000);
	homePage.clickAdmImg();
	homePage.clickOnSignOut();
	}

}
