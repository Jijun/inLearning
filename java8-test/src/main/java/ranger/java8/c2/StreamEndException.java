package ranger.java8.c2;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Person {
	String name;
	int age;

	Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return name;
	}
}

public class StreamEndException {
	public static void main(String[] args) {
		Stream<String> stream = Stream.of("d2", "a2", "b1", "b3", "c").filter(s -> s.startsWith("a"));
		stream.anyMatch(s -> true); // ok
		// stream.noneMatch(s -> true); // exception

		Supplier<Stream<String>> streamSupplier = () -> Stream.of("d2", "a2", "b1", "b3", "c")
				.filter(s -> s.startsWith("a"));
		List<Person> persons = Arrays.asList(
				new Person("Max", 18), new Person("Peter", 23), new Person("Pamela", 23), new Person("David", 12)
		);
		Map<Integer, List<Person>> personByAge = persons.stream().collect(Collectors.groupingBy(p -> p.age));
		personByAge.forEach((age, p) -> System.out.format("age %s: %s\n", age, p));

		IntSummaryStatistics ageSumer = persons.stream().collect(Collectors.summarizingInt(p -> p.age));
		System.out.println(ageSumer);
		Double avgAge = persons.stream().collect(Collectors.averagingDouble(o -> o.age));
		System.out.println(avgAge);

		String phrase = persons.stream().filter(p -> p.age >= 18).map(p -> p.name)
				.collect(Collectors.joining(" and ", " In germany ", " are of legal age. "));
		System.out.println(phrase);
		Collector<Person, StringJoiner, String> personNameCollector = Collector.of(
				() -> new StringJoiner(" | "),
				// supplier
				(j, p) -> j.add(p.name.toUpperCase()), // accumulator
				(j1, j2) -> j1.merge(j2),
				// combiner
				StringJoiner::toString
		);

		String names = persons.stream().collect(personNameCollector);
		System.out.println(names);

		persons.stream().reduce((p1, p2) -> p1.age > p2.age ? p1 : p2);

		Person result = persons.stream().reduce(new Person("", 0), (p1, p2) -> {
			p1.age += p2.age;
			p1.name += p2.name;
			return p1;
		});
		System.out.format("name=%s; age=%s", result.name, result.age);

		Integer ageSum = persons.stream().reduce(0, (sum, p) -> sum += p.age, (sum1, sum2) -> sum1 + sum2);
		System.out.println(ageSum);

		Integer ageSum2 = persons.parallelStream().reduce(0, (sum, p) -> {
			System.out.format("accumulator: sum=%s; person=%s\n", sum, p);
			return sum += p.age;
		}, (sum1, sum2) -> {
			System.out.format("combiner: sum1=%s; sum2=%s\n", sum1, sum2);
			return sum1 + sum2;
		});

		Arrays.asList("a1", "a2", "b1", "c2", "c1").parallelStream().filter(s -> {
			System.out.format("filter: %s [%s]\n", s, Thread.currentThread().getName());
			return true;
		}).map(s -> {
			System.out.format("map: %s [%s]\n", s, Thread.currentThread().getName());
			return s.toUpperCase();
		}).forEach(s -> System.out.format("forEach: %s [%s]\n", s, Thread.currentThread().getName()));
	}

}
