package ranger.java8.c1;

import java.util.ArrayList;
import java.util.List;
/**
 * Filter接受一个predicate接口类型的变量,并将所有流对象中的元素进行过滤。该操
作是一个中间操作,因此它允许我们在返回结果的基础上再进行其他的流操作
(forEach)。ForEach接受一个function接口类型的变量,用来执行对每一个元素
的操作。ForEach是一个中止操作。它不返回流,所以我们不能再调用其他的流操
作。
 * @description //TODO 设计说明
 * @author ranger
 * @date Mar 22, 2018
 */
public class FiltersTest {
	public static void main(String[] args) {
		List<String> stringCollection = new ArrayList<>();
		stringCollection.add("ddd2");
		stringCollection.add("aaa2");
		stringCollection.add("bbb1");
		stringCollection.add("aaa1");
		stringCollection.add("bbb3");
		stringCollection.add("ccc");
		stringCollection.add("bbb2");
		stringCollection.add("ddd1");

		stringCollection.stream().filter(s->s.startsWith("a")).forEach(System.out::printf);
	}
}
