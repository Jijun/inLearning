package ranger.java8.c1;

import java.util.function.Function;

public class FunctionsTest {
	public static void main(String[] args) {
		Function<String,Integer> toInteger = Integer::valueOf;
		Function<String, String> backToString = toInteger.andThen(String::valueOf);
		
		backToString.apply("123");
		
		Function<String, Integer> stringBf = toInteger.compose(String::valueOf);
		stringBf.apply("2.0");
		
		
	}

}
