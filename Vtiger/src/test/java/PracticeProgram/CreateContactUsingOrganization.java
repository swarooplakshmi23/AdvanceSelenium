package PracticeProgram;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Iterator;
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

import Generic_Utilities.Excel_Utility;
import Generic_Utilities.File_Utility;
import Generic_Utilities.Java_Utility;
import Generic_Utilities.WebDriver_Utility;
import Object_Repository.VtigerHomePage;
import Object_Repository.VtigerLoginPage;

class CreateContactUsingOrganization 
{
	public static void main(String[] args) throws Throwable {
		WebDriver_Utility wdu=new WebDriver_Utility();
		File_Utility flib=new File_Utility();
		Java_Utility jutil=new Java_Utility();
		Excel_Utility eutil= new Excel_Utility();
		/*
		WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	*/
		WebDriver driver;
	       String BROWSER = flib.getKeyAndValuePair("browser");
	         if(BROWSER.equalsIgnoreCase("chrome"))
	         {
	        	 driver=new ChromeDriver();
	         }
	         else
	         {
	         if(BROWSER.equalsIgnoreCase("edge"))
	        	 {
	        		 driver=new EdgeDriver();
	        	 }
	       	 else
	        	 {
	        if(BROWSER.equalsIgnoreCase("firefox"))
	        		{
	        			driver=new FirefoxDriver();
	        		}
	        else
	        		{
	        			driver=new ChromeDriver();
	        		}
	        	 }
	         }
	         wdu.maximizeBrowserWindow(driver);	//driver.manage().window().maximize();
	 		wdu.implicityWait(driver); 	
	driver.get("http://localhost:8888/");
	String URL =flib.getKeyAndValuePair("url");
	String USERNAME =flib.getKeyAndValuePair("username");
	String PASSWORD =flib.getKeyAndValuePair("password");
	driver.get(URL);
	
	VtigerLoginPage login = new VtigerLoginPage(driver);
//	driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys("admin");
//	driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys("admin");
//	driver.findElement(By.xpath("//input[@id='submitButton']")).click();
	VtigerHomePage homePage= new VtigerHomePage(driver);

	driver.findElement(By.linkText("Organizations")).click();
	driver.findElement(By.cssSelector("[alt='Create Organization...']")).click();
	/*
	Random ran = new Random();
	int ranNum = ran.nextInt(1000);
	*/
	
	int ranNum = jutil.getRandomNumber();
/*	
	  //Step1:- Path Connection of the physical File
	FileInputStream fis1 = new FileInputStream("C:\\Users\\Admin\\eclipse-workspace\\Vtiger\\src\\test\\resources\\excel.xlsx");

	        //step2:- keep Excel_File in Read mode
	         Workbook book1 = WorkbookFactory.create(fis1);
		
	         //step3:- get control of the sheet
	         Sheet sheet1 = book1.getSheet("Organization");
	         
	         //step4:- get control of the Row
	         Row row1 = sheet1.getRow(0);
	         
	         //step5:- get control of the Cell
	         Cell cell1 = row1.getCell(0);
	         
	         String prdData = cell1.getStringCellValue()+ranNum;
	         */
	
	 String prdData =eutil.getExcelData("Organization", 0, 0)+ranNum;
	driver.findElement(By.name("accountname")).sendKeys(prdData);
	driver.findElement(By.id("phone")).sendKeys("9998885252");
	driver.findElement(By.id("email1")).sendKeys("mailto:abc@gmail.com");
driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

Thread.sleep(1000);
                   	driver.findElement(By.xpath("//a[text()='Contacts']")).click();
                   	driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
                   	driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("swaroop");
                	driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("swaroopl");

	driver.findElement(By.xpath("(//img[@title='Select'])[1]")).click();
	/*
	 Set<String> wins = driver.getWindowHandles();
	    Iterator<String> it = wins.iterator();
		 while(it.hasNext())
	    {
	    	String win = it.next();
	    	driver.switchTo().window(win);
	    	String currentTitle = driver.getTitle();
	    if(currentTitle.contains("Accounts&action"))
	    {
	    	break;
	    }
	    }
	    */
	  wdu.windowHandling(driver, "Accounts&action");
		
	    driver.findElement(By.name("search_text")).sendKeys(prdData);
	    driver.findElement(By.name("search")).click();
	    
	  //  driver.findElement(By.xpath("//a[text()='Bluetooth202']")).click();
	   Thread.sleep(1000); 
	    driver.findElement(By.xpath("//a[text()='"+prdData+"']")).click();
	    Thread.sleep(1000);
	    /*
	    Set<String> wins1 = driver.getWindowHandles();
	    Iterator<String> it1 = wins1.iterator();
		 while(it1.hasNext())
	    {
	    	String win1 = it1.next();
	    	driver.switchTo().window(win1);
	    	String currentTitle = driver.getTitle();
	    if(currentTitle.contains("Contacts&action"))
	    {
	    	break;
	    }
	    }
	    */
	    wdu.windowHandling(driver, "Contacts&action");
	    
driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
	//	driver.findElement(By.linkText("Sign Out")).click();
		//driver.quit();
		homePage.clickAdmImg();
		homePage.clickOnSignOut();
	}
	}

