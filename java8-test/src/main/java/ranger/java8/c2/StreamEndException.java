package ranger.java8.c2;

import java.util.function.Supplier;
import java.util.stream.Stream;

public class StreamEndException {
	public static void main(String[] args) {
		Stream<String> stream = Stream.of("d2", "a2", "b1", "b3", "c").filter(s -> s.startsWith("a"));
		stream.anyMatch(s -> true);		// ok
		stream.noneMatch(s -> true);		// exception
	
		Supplier<Stream<String>> streamSupplier = () -> Stream.of("d2", "a2", "b1", "b3", "c").filter(s -> s.startsWith("a"));
		
		
		
	}
	
}
