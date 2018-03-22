package ranger.java8.c1;

import java.util.ArrayList;
import java.util.List;

/**
 * java.util.Stream表示了某一种元素的序列,在这些元素上可以进行各种操作。
 * Stream操作可以是中间操作,也可以是完结操作。完结操作会返回一个某种类型的 值,而中间操作会返回流对象本身,并且你可以通过多次调用同一个流操作方法来
 * 将操作结果串起来(就像StringBuffer的append方法一样————译者注)。
 * Stream是在一个源的基础上创建出来的,例如java.util.Collection中的list或者
 * set(map不能作为Stream的源)。Stream操作往往可以通过顺序或者并行两种方 式来执行
 * 
 * @description //TODO 设计说明
 * @author ranger
 * @date Mar 22, 2018
 */
public class StreamsTest {
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
		
		stringCollection.parallelStream().forEach(System.out::println);
	}
}
