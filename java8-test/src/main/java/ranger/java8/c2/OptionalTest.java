package ranger.java8.c2;

import java.util.Optional;

class Outer {
	Nested nested;
}

class Nested {
	Inner inner;
}

class Inner {
	String foo;
}

public class OptionalTest {
	public static void main(String[] args) {

		Outer outer = new Outer();
		if (outer != null && outer.nested != null && outer.nested.inner != null) {
			System.out.println(outer.nested.inner.foo);
		}
		Optional.of(new Outer())
		.flatMap(o -> Optional.ofNullable(o.nested))
		.flatMap(n -> Optional.ofNullable(n.inner))
		.flatMap(i -> Optional.ofNullable(i.foo))
		.ifPresent(System.out::println);
	}
}
