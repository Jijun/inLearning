package ranger.java8.c1;

public interface Personfactory<P extends Person> {
	P create(String firstName, String lastName);
}
