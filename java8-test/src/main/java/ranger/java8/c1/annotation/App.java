package ranger.java8.c1.annotation;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.AnnotatedType;
@Retention(RetentionPolicy.RUNTIME)
@interface Hints {
	Hint[] value();
}

@Repeatable(Hints.class)
@Retention(RetentionPolicy.RUNTIME)
@interface Hint {
	String value();
}

// old style
//@Hints({ @Hint("123"), @Hint("456") })
//class Person {
//}

@Hint("hint1")
@Hint("hint2")
class Person {
}

public class App {
	
	public static void main(String[] args) {
		
		Hint hint = Person.class.getAnnotation(Hint.class);
		System.out.println(hint);                   // null

		Hints hints1 = Person.class.getAnnotation(Hints.class);
		System.out.println(hints1.value().length);  // 2

		Hint[] hints2 = Person.class.getAnnotationsByType(Hint.class);
		System.out.println(hints2.length);          // 2

		
	}

}

