package Generic_Utilities;

import java.util.Date;
import java.util.Random;

public class Java_Utility {
	/**
	 * This method is used to get random number in order to avoid duplicate value
	@author Swaroop
	 * @return
	 */
	public int getRandomNumber()
	{
		Random ran=new Random();
		int ranNum = ran.nextInt(1000);
		return ranNum;
	}
	/**
	 * This method is used to get current time and date in IST format
	 * @author Swaroop
	 * @return
	 */
	public String getSystemDateAndTime() {
		Date date=new Date();
		String dateAndTime=date.toString();	
		return dateAndTime;		
	}

	/**
	 * This method is used to get current date in YYYY=MM-DD format
	 * @author Swaroop Lakshmi
	 * @return
	 */
	public String getSystemDateWithFormat() {
		Date date=new Date();
		String dateAndTime=date.toString();
		String YYYY= dateAndTime.split(" ")[5];
		String DD= dateAndTime.split(" ")[2];
		int MM=date.getMonth()+1;
		String finalFormat=YYYY+"-"+MM+"-"+DD;
		return finalFormat;
		
		
	}
//1st pull
	//2nd push
}
