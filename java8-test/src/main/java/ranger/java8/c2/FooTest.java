package ranger.java8.c2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

class Foo {
	String name;
	List<Bar> bars = new ArrayList<>();

	Foo(String name) {
		this.name = name;
	}
}
class Bar {
	String name;

	Bar(String name) {
		this.name = name;
	}
}

public class FooTest {
	public static void main(String[] args) {
		List<Foo> foos = new ArrayList<>();
		// create foos
		IntStream.range(1, 4).forEach(i -> foos.add(new Foo("Foo" + i)));
		// create bars
		foos.forEach(f -> IntStream.range(1, 4).forEach(i -> f.bars.add(new Bar("Bar" + i + " <- " + f.name))));
		
		foos.stream().flatMap(f->f.bars.stream()).forEach(b->System.out.println(b.name));
		
	}
}
