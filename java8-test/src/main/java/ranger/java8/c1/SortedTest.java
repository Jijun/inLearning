package ranger.java8.c1;

import java.util.ArrayList;
import java.util.List;

/**
 * Sorted是一个中间操作,能够返回一个排过序的流对象的视图。流对象中的元素会
 * 默认按照自然顺序进行排序,除非你自己指定一个Comparator接口来改变排序规 则。
 * 
 * @description //TODO 设计说明
 * @author ranger
 * @date Mar 22, 2018
 */
public class SortedTest {
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

		stringCollection.stream().sorted().filter(s -> s.startsWith("a")).forEach(System.out::println);

		stringCollection.stream().sorted((a, b) -> a.length() - b.length()).forEach(System.out::println);

	}
}
