package Generic_Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import Object_Repository.VtigerLoginPage;

public class BaseClass {
	public WebDriver driver;
	
	public Java_Utility jutil=new Java_Utility();
	public WebDriver_Utility wdu=new WebDriver_Utility();
	public File_Utility flib=new File_Utility();
	public Excel_Utility eutil= new Excel_Utility();
	
	@BeforeSuite
	public void BS() {
		System.out.println("DataBase Connection Open");
	}
	
	@BeforeTest
	public void BT() {
		System.out.println("parallel execution start");
	}
	
@BeforeClass
public void BC() throws Throwable
{
	String BROWSER =System.getProperty("browser");
	System.out.println(BROWSER);
	
//String BROWSER = flib.getKeyAndValuePair("browser");
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
System.out.println("Browser Launched");
}

@BeforeMethod
public void BM() throws Throwable {
	
	wdu.maximizeBrowserWindow(driver);	//driver.manage().window().maximize();
		wdu.implicityWait(driver); 

String URL =flib.getKeyAndValuePair("url");
String USERNAME =flib.getKeyAndValuePair("username");
String PASSWORD =flib.getKeyAndValuePair("password");
driver.get(URL);

VtigerLoginPage login = new VtigerLoginPage(driver);
login.loginToVitigerApp(USERNAME, PASSWORD);
	System.out.println("login to application ");
}

@AfterMethod
public void AM() {
	System.out.println("logout  from application  ");
}

@AfterClass
public void AC() {
	
	System.out.println("close the browser");
}

@AfterTest
public void AT() {
	System.out.println("Parallel exeution done ");
}

@AfterSuite
public void AS() {
	System.out.println("database close ");
}
}

