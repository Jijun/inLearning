package ranger.java8.c1.time;

import java.time.Clock;
import java.time.Instant;
import java.time.ZoneId;
import java.util.Date;
/**
 * Clock提供了对当前时间和日期的访问功能。Clock是对当前时区敏感的,并可用于
替代System.currentTimeMillis()方法来获取当前的毫秒时间。当前时间线上的时刻
可以用Instance类来表示。Instance也能够用于创建原先的java.util.Date对象。
 * @description //TODO 设计说明
 * @author ranger
 * @date Mar 23, 2018
 */
public class ClockTest {
	public static void main(String[] args) {
		ZoneId currentZone = ZoneId.systemDefault();
		System.out.println(currentZone.getId());
		Clock clock = Clock.systemDefaultZone();
		long millis = clock.millis();
		System.out.println(millis);
		
		Instant instant = clock.instant();
		Date legacyDate = Date.from(instant);
		System.out.println(legacyDate);
	}
}
