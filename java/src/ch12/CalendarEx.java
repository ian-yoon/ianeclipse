package ch12;

import java.util.Calendar;

public class CalendarEx {

	public static void main(String[] args) {

		Calendar cal = Calendar.getInstance();

		System.out.println(cal.get(Calendar.YEAR));
		System.out.println(cal.get(Calendar.MONTH) + 1);
		System.out.println(cal.get(Calendar.DATE));
		System.out.println(cal.get(Calendar.HOUR));
		System.out.println(cal.get(Calendar.HOUR_OF_DAY));
		System.out.println(cal.get(Calendar.MINUTE));
		System.out.println(cal.get(Calendar.SECOND));
		
		System.out.println(cal.get(Calendar.AM_PM));
		if (cal.get(Calendar.AM_PM) == 0) {
			System.out.println("am");
		} else {
			System.out.println("pm");
		}
		
		System.out.println(cal.get(Calendar.DAY_OF_WEEK));
		String yoil = "";
		switch (cal.get(Calendar.DAY_OF_WEEK)) {
		case 1:
			yoil = "Sunday";
			break;
		case 2:
			yoil = "Monday";
			break;
		case 3:
			yoil = "Tuesday";
			break;
		case 4:
			yoil = "Wednesday";
			break;
		case 5:
			yoil = "Thursday";
			break;
		case 6:
			yoil = "Friday";
			break;
		case 7:
			yoil = "Saturday";
			break;
		}
		System.out.println("Today is " + yoil);

	}

}
