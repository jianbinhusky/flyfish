package date;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTest {
	
	public static SimpleDateFormat yyyyMMdd = new SimpleDateFormat("yyyy-MM-dd");
	
	public static String getNextDayDate(Date date){
		long dateTime = 1L;
		dateTime *= 24;
		dateTime *= 60;
		dateTime *= 60;
		dateTime *= 1000;
		
		Date nextDate = new Date(dateTime + date.getTime());
		
		return yyyyMMdd.format(nextDate);
	}

	public static void main(String[] args) {
		System.out.println("today next date is " +getNextDayDate(new Date()) );

	}

}
