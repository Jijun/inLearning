package ranger.java8.c1.time;

import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.Date;

/**
 * LocalDateTime表示的是日期-时间。它将刚才介绍的日期对象和时间对象结合起
 * 来,形成了一个对象实例。LocalDateTime是不可变的,与LocalTime和LocalDate
 * 的工作原理相同。我们可以通过调用方法来获取日期时间对象中特定的数据域。
 * 
 * @description //TODO 设计说明
 * @author ranger
 * @date Mar 26, 2018
 */
public class LocalDateTimeTest {
	public static void main(String[] args) {
		LocalDateTime sylvester = LocalDateTime.of(2014, Month.DECEMBER, 31, 23, 59, 59);

		DayOfWeek dayOfWeek = sylvester.getDayOfWeek();
		System.out.println(dayOfWeek);
		// WEDNESDAY
		Month month = sylvester.getMonth();
		System.out.println(month);
		// DECEMBER
		long minuteOfDay = sylvester.getLong(ChronoField.MINUTE_OF_DAY);
		System.out.println(minuteOfDay);
		// 1439

		Instant instant = sylvester.atZone(ZoneId.systemDefault()).toInstant();
		Date legacyDate = Date.from(instant);
		System.out.println(legacyDate);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM dd, yyyy - HH:mm");

		LocalDateTime parsed = LocalDateTime.parse("Nov 03, 2014 - 07:13", formatter);
		String string = formatter.format(parsed);
		System.out.println(string);
		

	}
}
