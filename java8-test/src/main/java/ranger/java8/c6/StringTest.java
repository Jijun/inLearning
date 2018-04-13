package ranger.java8.c6;

import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class StringTest {
	public static void main(String[] args) {
		System.out.println(String.join(":", "foobar", "foo", "bar"));

		"foobar:foo:bar".chars().distinct().mapToObj(c -> String.valueOf((char) c)).sorted()
				.collect(Collectors.joining());
		System.out
				.println(Pattern.compile(":").splitAsStream("foobar:foo:bar").filter(s -> s.contains("bar")).sorted().collect(Collectors.joining(":")));

		Pattern pattern = Pattern.compile(".*@gmail\\.com");
		Stream.of("bob@gmail.com","alice@hotmail.com").filter(pattern.asPredicate()).count();
		
		
		System.out.println(Integer.MAX_VALUE);
		
		long maxUnsignedInt = (1L<<32) - 1;
		String string = String.valueOf(maxUnsignedInt);
		System.out.println(string);
		int unsignedint = Integer.parseUnsignedInt(string,10);
		String string2 = Integer.toUnsignedString(unsignedint,10);
		System.out.println(string2);
		
	}
}
