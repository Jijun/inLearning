package ranger.java8.c1;

import java.util.ArrayList;
import java.util.List;

/**
 * 匹配操作有多种不同的类型,都是用来判断某一种规则是否与流对象相互吻合的。 所有的匹配操作都是终结操作,只返回一个boolean类型的结果。
 * 
 * @description //TODO 设计说明
 * @author ranger
 * @date Mar 23, 2018
 */
public class MatchTest {
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

		boolean anyStartsWithA = stringCollection.stream().anyMatch(s -> s.startsWith("a"));
		boolean allStartsWithA = stringCollection.stream().allMatch((s) -> s.startsWith("a"));
		System.out.println(allStartsWithA);
		// false
		boolean noneStartsWithZ = stringCollection.stream().noneMatch((s) -> s.startsWith("z"));
		System.out.println(noneStartsWithZ);
	}
}
