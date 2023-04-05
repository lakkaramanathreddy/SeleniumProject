package generalLibraries;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
/*
 * this class contain reusable java methods
 * @author welcome
 */

public class JavaUtility {
	/*
	 * this method generates random number with in the limit
	 * @param limit
	 * @return
	 */
	public int generateRandomNum(int limit) {
		Random random=new Random();
		int randomNum=random.nextInt(limit);
		return randomNum;
		}
	/*
	 * this method return current time in specified format
	 * @return
	 */
	public String getCurrentTime() {
		Date date = new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("dd_yy_hh_mm_ss");
		String currentTime=sdf.format(date);
		
		return currentTime;
		
	}

}
