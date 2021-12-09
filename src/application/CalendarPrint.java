package application;

import java.util.Calendar;
import java.util.Locale;

public interface CalendarPrint {
	
	public static void getAllInfo(Calendar calendar) {
		System.out.println("YEAR: " + calendar.get(Calendar.YEAR));
		System.out.println("MONTH: " + calendar.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.UK));
		System.out.println("WEEK_OF_YEAR: " + calendar.get(Calendar.WEEK_OF_YEAR));
		System.out.println("WEEK_OF_MONTH: " + calendar.get(Calendar.WEEK_OF_MONTH));
		System.out.println("DATE: " + calendar.get(Calendar.DATE));
		System.out.println("DAY_OF_MONTH: " + calendar.get(Calendar.DAY_OF_MONTH));
		System.out.println("DAY_OF_YEAR: " + calendar.get(Calendar.DAY_OF_YEAR));
		System.out.println("DAY_OF_WEEK: " + calendar.get(Calendar.DAY_OF_WEEK));
		System.out.println("DAY_OF_WEEK_IN_MONTH: " + calendar.get(Calendar.DAY_OF_WEEK_IN_MONTH));
		System.out.println("AM_PM: " + calendar.get(Calendar.AM_PM));
		System.out.println("HOUR: " + calendar.get(Calendar.HOUR));
		System.out.println("HOUR_OF_DAY: " + calendar.get(Calendar.HOUR_OF_DAY));
		System.out.println("MINUTE: " + calendar.get(Calendar.MINUTE));
		System.out.println("SECOND: " + calendar.get(Calendar.SECOND));
		System.out.println("MILLISECOND: " + calendar.get(Calendar.MILLISECOND) + "\n");
	}
	
	public static void getSomeInfo(Calendar calendar) {
		System.out.println(getShortDescription(calendar));
	}
	
	public static String getShortDescription(Calendar calendar) {
		String message = "YEAR: " + calendar.get(Calendar.YEAR);
		/*message += "; MONTH: " + calendar.get(Calendar.MONTH);*/
		/*message += "; MONTH: " + calendar.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.FRENCH);*/
		message += "; MONTH: " + calendar.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.UK);
		message += "; DAY_OF_MONTH: " + calendar.get(Calendar.DAY_OF_MONTH);
		message += "; HOUR_OF_DAY: " + calendar.get(Calendar.HOUR_OF_DAY);
		return message;
	}

}