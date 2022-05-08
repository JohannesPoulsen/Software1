package projectManagement;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class DateServer { // Keeps track of current year to provide correct id to projects

	public static String getYear() {
		Calendar calendar = new GregorianCalendar();
		return Integer.toString(calendar.get(Calendar.YEAR));
	}

}
