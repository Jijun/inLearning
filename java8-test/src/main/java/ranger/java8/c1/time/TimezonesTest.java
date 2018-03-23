package ranger.java8.c1.time;

import java.time.ZoneId;

public class TimezonesTest {
	public static void main(String[] args) {
		
		System.out.println(ZoneId.getAvailableZoneIds());
		
		ZoneId zone1 = ZoneId.of("Europe/Berlin");
		ZoneId zone2 = ZoneId.of("Brazil/East");
		System.out.println(zone1.getRules());
		System.out.println(zone2.getRules());
	}
}
