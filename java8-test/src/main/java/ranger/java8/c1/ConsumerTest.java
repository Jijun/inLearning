package ranger.java8.c1;

import java.util.function.Consumer;

public class ConsumerTest {
	public static void main(String[] args) {
		Consumer<Person> greeter = (p) -> System.out.println("hello " + p.firstName);
		greeter.accept(new Person("Jijun","Liu"));
	}
}
