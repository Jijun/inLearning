package ranger.java8.c5;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapTest {
	public static void main(String[] args) {

		ConcurrentHashMap<String, String> cmap = new ConcurrentHashMap();
		cmap.put("foo", "bar");
		cmap.put("han", "solo");
		cmap.put("r2", "d2");
		cmap.put("c3", "p0");

		String result = cmap.search(1, (key, value) -> {
			System.out.println(Thread.currentThread().getName());
			if ("foo".equals(key)) {
				return value;
			}
			return null;
		});
		System.out.println(result);

		result = cmap.searchValues(1, value -> {
			System.out.println(Thread.currentThread().getName());
			if (value.length() > 3) {
				return value;
			}
			return null;
		});
		System.out.println("result " + result);

		result = cmap.reduce(1, (key, value) -> {
			System.out.println("Transform: " + Thread.currentThread().getName());
			return key + "=" + value;
		}, (s1, s2) -> {
			System.out.println("reduce: " + Thread.currentThread().getName());
			return s1 + ", " + s2;
		});
		
		System.out.println("result " + result);
	}
}
