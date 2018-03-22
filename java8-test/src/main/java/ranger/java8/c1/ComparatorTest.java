package ranger.java8.c1;

import java.util.Comparator;

public class ComparatorTest {
	public static void main(String[] args) {
		
		Comparator<Person> comparator = (p1,p2) ->p1.firstName.compareTo(p2.firstName);
		
		Person p1 = new Person("John", "Doe");
		Person p2 = new Person("Alice", "Wonderland");
		
		comparator.compare(p1, p2);
		comparator.reversed().compare(p1, p2);
	}
}
