package ranger.java8.c1.time;

import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

/**
 * 本地时间类表示一个没有指定时区的时间,例如,10 p.m.或者17:30:15,下面的
 * 例子会用上面的例子定义的时区创建两个本地时间对象。然后我们会比较两个时 间,并计算它们之间的小时和分钟的不同。
 * 
 * @description //TODO 设计说明
 * @author ranger
 * @date Mar 23, 2018
 */
public class LocalTimeTest {

	public static void main(String[] args) {
		ZoneId zone1 = ZoneId.of("Europe/Berlin");
		ZoneId zone2 = ZoneId.of("Brazil/East");
		LocalTime now1 = LocalTime.now(zone1);
		LocalTime now2 = LocalTime.now(zone2);
		
		System.out.println(now1.isBefore(now2));
		
		long hoursBetween = ChronoUnit.HOURS.between(now1, now2);
		long minutesBetween = ChronoUnit.MINUTES.between(now1, now2);
		System.out.println(hoursBetween);
		System.out.println(minutesBetween);

		LocalTime late = LocalTime.of(23, 59, 59);
		System.out.println(late);
		DateTimeFormatter germanFormater = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT).withLocale(Locale.GERMAN);
		LocalTime leetTime = LocalTime.parse("13:37", germanFormater);
		System.out.println(leetTime);
		
		
		
		
	}

}
