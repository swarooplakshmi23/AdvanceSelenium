package Generic_Utilities;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;

public class WebDriver_Utility {
	
	  public void maximizeBrowserWindow(WebDriver driver)
	  {
		  driver.manage().window().maximize();
	  }
	  public void implicityWait(WebDriver driver)
	  {
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  }
	  public void windowHandling(WebDriver driver,String WindowTitle)
	  {
		  Set<String> wins = driver.getWindowHandles();
		    Iterator<String> it = wins.iterator();
			 while(it.hasNext())
		    {
		    	String win = it.next();
		    	driver.switchTo().window(win);
		    	String currentTitle = driver.getTitle();
		    if(currentTitle.contains(WindowTitle))
		    {
		    	
		    	
		    	break;
		    }
		   }
	  }
	  /**
		 * this method is used to accept the alert popup
		 * @param driver
		 */
		public void alertAccept(WebDriver driver)
		{
			driver.switchTo().alert().accept();
		}
		
		/** this method is used to dismiss the alert popup
		 * 
		 * @param driver
		 */
		public void alertDismiss(WebDriver driver)
		{
			driver.switchTo().alert().dismiss();
		}
		
}
