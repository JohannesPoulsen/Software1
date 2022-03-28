package projectManagement;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class DateServer {

	public static String getYear() {
		Calendar calendar = new GregorianCalendar();
		return Integer.toString(calendar.get(Calendar.YEAR));
	}

}
