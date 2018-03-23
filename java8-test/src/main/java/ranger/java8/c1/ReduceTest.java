package ranger.java8.c1;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * 该操作是一个终结操作,它能够通过某一个方法,对元素进行削减操作。该操作的
结果会放在一个Optional变量里返回。
 * @description //TODO 设计说明
 * @author ranger
 * @date Mar 23, 2018
 */
public class ReduceTest {
	public static void main(String[] args) {
		List<String> stringCollection = new ArrayList<>();
		stringCollection.add("ddd2");
		stringCollection.add("aaa2");
		stringCollection.add("bbsb1");
		stringCollection.add("aaddda1");
		stringCollection.add("bbb3");
		stringCollection.add("cddcc");
		stringCollection.add("bbb2");
		stringCollection.add("ddddd1");

		
		Optional<String>	 reduced = stringCollection.stream().sorted().reduce((s1,s2)-> s1 + "#" + s2);
		
		reduced.ifPresent(System.out::println);
		
		
		
	}
}
