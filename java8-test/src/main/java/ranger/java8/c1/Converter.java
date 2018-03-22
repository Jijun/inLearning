package ranger.java8.c1;

@FunctionalInterface
public interface Converter<F, T> {
	T convert(F from);
}
