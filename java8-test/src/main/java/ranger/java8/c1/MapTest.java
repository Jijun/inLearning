package ranger.java8.c1;

import java.util.ArrayList;
import java.util.List;
/**
 * map是一个对于流对象的中间操作,通过给定的方法,它能够把流对象中的每一个
元素对应到另外一个对象上。下面的例子就演示了如何把每个string都转换成大写
的string. 不但如此,你还可以把每一种对象映射成为其他类型。对于带泛型结果的
流对象,具体的类型还要由传递给map的泛型方法来决定。
 * @description //TODO 设计说明
 * @author ranger
 * @date Mar 22, 2018
 */
public class MapTest {
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

		stringCollection.stream().map(String::toUpperCase).sorted((a,b)->b.compareTo(a)).forEach(System.out::println);
		
	}
}
