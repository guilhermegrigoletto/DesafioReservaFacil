package util;

import java.util.Calendar;

import org.joda.time.DateTime;
import org.joda.time.Days;

public class DataUtil {
	public static final int calcularDiferencaEntreDatasEmDias(Calendar data1,
			Calendar data2) {
		DateTime dateTime1 = new DateTime(data1);
		DateTime dateTime2 = new DateTime(data2);
		return Days.daysBetween(dateTime1.withTimeAtStartOfDay(),
				dateTime2.withTimeAtStartOfDay()).getDays();
	}

	public static final Calendar getDataDaquiXDias(int x) {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, x);
		return cal;
	}
}
