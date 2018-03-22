package ranger.java8.c1;

import java.util.Objects;
import java.util.function.Predicate;

public class PredicatesTest {
	public static void main(String[] args) {
		Predicate<String> predicate = (s) ->s.length()>0;
		predicate.test("foo");//true
		predicate.negate().test("foo");//false
	
		Predicate<String> nonNull = Objects::nonNull;
		Predicate<Boolean> isNull = Objects::isNull;
		Predicate<String> isEmpty = String::isEmpty;
		Predicate<String> isNotEmpty = isEmpty.negate();
		isEmpty.and(nonNull);
		isEmpty.or(isNotEmpty);
	}
}
