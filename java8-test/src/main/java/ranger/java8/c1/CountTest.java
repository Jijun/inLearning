package ranger.java8.c1;

import java.util.ArrayList;
import java.util.List;
/**
 * Count是一个终结操作,它的作用是返回一个数值,用来标识当前流对象中包含的
元素数量。
 * @description //TODO 设计说明
 * @author ranger
 * @date Mar 23, 2018
 */
public class CountTest {
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
		
		long startsWithB =
				stringCollection
				.stream()
				.filter((s) -> s.startsWith("b"))
				.count();
				System.out.println(startsWithB);
	}
}
