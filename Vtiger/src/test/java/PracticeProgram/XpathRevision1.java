package PracticeProgram;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class XpathRevision1 {

	public static void main(String[] args) {
	
		ChromeDriver driver= new ChromeDriver();
		driver.get("https://www.flipkart.com/search?q=Phone&otracker=search&otracker1=search&marketplace=FLIPKART&as-show=on&as=off");
		driver.manage().window().maximize();
	//	driver.findElement(By.xpath("//input[@placeholder='Search for Products, Brands and More']")).sendKeys("Phone");
	//	driver.findElement(By.xpath("//input[@placeholder='Search for Products, Brands and More']")).click();
	 List<WebElement> phone = driver.findElements(By.xpath("//div[@class='KzDlHZ']"));
	 List<WebElement> phoneprice =driver.findElements(By.xpath("//div[@class='KzDNx9bqj _4b5DiRlHZ']"));
	 for(int i=0;i<=phone.size();i++)
	 {
		System.out.println(phone.get(i).getText()+"-----------------"+phoneprice.get(i).getText());
		
	 }
		 
	}

}