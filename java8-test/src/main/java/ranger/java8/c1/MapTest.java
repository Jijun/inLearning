package ranger.java8.c1;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sun.org.apache.bcel.internal.generic.NEW;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

/**
 * map是一个对于流对象的中间操作,通过给定的方法,它能够把流对象中的每一个 元素对应到另外一个对象上。下面的例子就演示了如何把每个string都转换成大写
 * 的string. 不但如此,你还可以把每一种对象映射成为其他类型。对于带泛型结果的 流对象,具体的类型还要由传递给map的泛型方法来决定。
 * 
 * @description //TODO 设计说明
 * @author ranger
 * @date Mar 22, 2018
 */
public class MapTest {
	public static void main(String[] args) throws UnsupportedEncodingException {
		List<String> stringCollection = new ArrayList<>();
		stringCollection.add("ddd2");
		stringCollection.add("aaa2");
		stringCollection.add("bbsb1");
		stringCollection.add("aaddda1");
		stringCollection.add("bbb3");
		stringCollection.add("cddcc");
		stringCollection.add("bbb2");
		stringCollection.add("ddddd1");

		stringCollection.stream().map(String::toUpperCase).sorted((a, b) -> b.compareTo(a))
				.forEach(System.out::println);

		Map<Integer, String> map = new HashMap<>();

		for (int i = 0; i < 10; i++) {
			map.putIfAbsent(i, "val" + i);
		}
		map.forEach((id, val) -> System.out.println(val));

		map.computeIfPresent(3, (num, val) -> val + num);
		map.get(3);
		map.computeIfPresent(9, (num, val) -> null);
		map.containsKey(9);
		map.computeIfAbsent(3, num -> "bam");
		System.out.println(map.get(3));
		map.remove("3", "val3");
		map.get(3);
		map.remove(3, "val33");
		map.get(3);
		map.getOrDefault(42, "not found");

		System.out.println(map.get(9));
		map.merge(9, "val", (val, newval) -> val.concat(newval));
		System.out.println(map.get(9));

		map.merge(9, "concat", (value, newValue) -> value.concat(newValue));
		System.out.println(map.get(9));

	}
}
