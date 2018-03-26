package ranger.java8.c2;

import java.util.Arrays;
import java.util.function.Consumer;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ArraysTest {
	final static Consumer<String> consumer = System.out::println;

	public static void main(String[] args) {
		Arrays.asList("a23", "33").stream().findFirst().ifPresent(consumer);

		Stream.of("a1", "a2", "a3").findFirst().ifPresent(consumer);

		IntStream.range(1, 10).forEach(System.out::println);

		Arrays.stream(new int[] { 1, 2, 3 }).map(n -> 2 * n + 1).average().ifPresent(System.out::println);
		// 执行这段代码时,不向控制台打印任何东西。这是因为衔接操作只在终止操作调用时被执行。
		Stream.of("d2", "a2", "b1", "b3").filter(s -> {
			System.err.println("filter" + s);
			return true;
		});

		Stream.of("d2", "a2", "b1", "b3").filter(s -> {
			System.out.println("filter " + s);
			return true;
		}).forEach(s -> System.out.println("forEach: " + s));
		;
		Stream.of("d2", "a2", "b1", "b3", "c").map(s -> {
			System.out.println("map: " + s);
			return s.toUpperCase();
		}).anyMatch(s -> {
			System.out.println("anyMatch: " + s);
			return s.startsWith("A");
		});

		System.out.println("====== all match ======");
		Stream.of("d2", "a2", "b1", "b3", "c").map(s -> {
			System.out.println("map: " + s);
			return s.toUpperCase();
		}).allMatch(s -> {
			System.out.println("allMatch: " + s);
			return s.startsWith("A");
		});

	}
}
