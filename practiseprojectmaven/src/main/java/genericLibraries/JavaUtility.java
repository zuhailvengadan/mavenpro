package genericLibraries;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
/** 
 * this is the class which provide common functionality that can be
 * used across multiple app.it is not directly related to functionality
 * example:: random , system time.
 * @author Zuhail
 *
 */
public class JavaUtility {
	/**
	 * this method create random number within the limit 
	 * @param limit
	 * @return
	 */

	public int generateRandomNum(int limit) {
		Random random=new Random();
		return random.nextInt(limit);
	}
	/**
	 * this method get system time in specified format;
	 * 
	 * @return
	 */
	public String getCurrentTime() {
		Date date= new Date();
		SimpleDateFormat sdf =new SimpleDateFormat("dd_mm_yy_hh_mm_sss");
			
			return sdf.format(date);
	}
	
}
