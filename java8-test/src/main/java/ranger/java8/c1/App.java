package ranger.java8.c1;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class App {

	public static void main(String[] args) {
		Personfactory<Person> personfactory = Person::new;
		Person person = personfactory.create("stes", "dfaf");
		
	}

	public void FormulaTest() {
		Formula formula = new Formula() {

			@Override
			public double calculate(int a) {
				return sqrt(a * 100);
			}
		};
		formula.calculate(100);
		formula.sqrt(16);
		//默认方法无法在lambda内部被访问
//		Formula formula2 = (a) -> sqrt( a * 100);
	}

	
	
	class Something {
		String startWith(String s) {
			return String.valueOf(s.charAt(0));
		}
	}
	
	public void funcInter() {
		Converter<String, Integer> converter = (from)->Integer.valueOf(from);
		Integer converted = converter.convert("123");
		System.out.println(converted);
		//静态方法引用
		Converter<String, Integer> converter2 = Integer::valueOf;
		
		Something something = new Something();
		Converter<String, String> converter3 = something::startWith;
		String converted3 = converter3.convert("java");
		System.out.println(converted3);
	}
	
	
	
	public static void lambda() {
		List<String> names = Arrays.asList("peter", "anna");
		Collections.sort(names, (a, b) -> b.compareTo(a));
	}

}
	
interface Formula {
	double calculate(int a);

	default double sqrt(int a) {
		return Math.sqrt(a);
	}
}