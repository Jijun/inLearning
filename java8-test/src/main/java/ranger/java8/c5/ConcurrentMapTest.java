package ranger.java8.c5;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ForkJoinPool;

public class ConcurrentMapTest {
	public static void main(String[] args) {
		ConcurrentMap<String, String> map = new ConcurrentHashMap<>();
		map.put("foo", "bar");
		map.put("han", "solo");
		map.put("r2", "d2");
		map.put("c3", "p0");
		map.forEach((key,value)-> {
			System.out.printf("%s = %s\n", key,value);
		});
		
		String value = map.putIfAbsent("c3", "p1");
		System.out.println(value);
		value = map.getOrDefault("hi", "there");
		System.out.println(value);
		
		map.replaceAll((key, value1) -> "r2".equals(key)? "d3":value1);
		
		map.compute("foo", (key,value1)-> value1 + value1);
		
		map.merge("foo", "boo", (oldVal, newVal)-> newVal + " was " + oldVal);
		System.out.println(map.get("foo"));
		System.out.println(ForkJoinPool.getCommonPoolParallelism());
		
		
		
		
		
	}
}
