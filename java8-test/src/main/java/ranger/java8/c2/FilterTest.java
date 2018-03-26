package ranger.java8.c2;

import java.util.stream.Stream;

public class FilterTest {
	public static void main(String[] args) {

		// 如果我们调整操作顺序,将 filter 移动到调用链的顶端,就可以极大减少操作的执行次数:
		Stream.of("d2", "a2", "b1", "b2", "b3", "c").filter(s -> {
			System.out.println("filter " + s);
			return s.startsWith("a");
		}).map(s -> {
			System.out.println("map: " + s);
			return s.toUpperCase();
		}).forEach(s -> System.out.println("foreach: " + s));

		Stream.of("d2", "a2", "b1", "b3", "c").sorted((s1, s2) -> {
			System.out.printf("sort: %s; %s\n", s1, s2);
			return s1.compareTo(s2);
		}).filter(s -> {
			System.out.println("filter: " + s);
			return s.startsWith("a");
		}).map(s -> {
			System.out.println("map: " + s);
			return s.toUpperCase();
		}).forEach(s -> System.out.println("forEach: " + s));
		
		
		
		
	}
}
