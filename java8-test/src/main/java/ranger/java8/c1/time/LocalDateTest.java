package ranger.java8.c1.time;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

/**
 * 本地时间表示了一个独一无二的时间,例如:2014-03-11。这个时间是不可变的,
与LocalTime是同源的。下面的例子演示了如何通过加减日,月,年等指标来计算
新的日期。记住,每一次操作都会返回一个新的时间对象。
 * @description //TODO 设计说明
 * @author ranger
 * @date Mar 23, 2018
 */
public class LocalDateTest {
	public static void main(String[] args) {
		
		LocalDate today = LocalDate.now();
		LocalDate tomorrow = today.plus(1,ChronoUnit.DAYS);
		LocalDate yesterday = tomorrow.minusDays(2);
		
		LocalDate independenceDay = LocalDate.of(2014, Month.JULY, 4);
		DayOfWeek dayOfWeek = independenceDay.getDayOfWeek();
		System.out.println(dayOfWeek);
		DateTimeFormatter germanFormatter =
				DateTimeFormatter
				.ofLocalizedDate(FormatStyle.MEDIUM)
				.withLocale(Locale.GERMAN);
				LocalDate xmas = LocalDate.parse("24.12.2014", germanFormatter);
				System.out.println(xmas);
	}
}
