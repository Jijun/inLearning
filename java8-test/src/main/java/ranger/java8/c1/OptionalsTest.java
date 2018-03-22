package ranger.java8.c1;

import java.util.Optional;

public class OptionalsTest {
	public static void main(String[] args) {
		Optional<String> optional = Optional.of("bam");
		optional.isPresent();
		optional.get();
		optional.orElse("fallback");
		optional.ifPresent(s -> System.out.println(s));
	}
}
