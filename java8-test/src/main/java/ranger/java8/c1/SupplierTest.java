package ranger.java8.c1;

import java.util.function.Supplier;

/**
 * Supplier接口产生一个给定类型的结果。与Function不同的是,Supplier没有输入参 数。
 * 
 * @description //TODO 设计说明
 * @author ranger
 * @date Mar 21, 2018
 */
public class SupplierTest {
	public static void main(String[] args) {
		Supplier<Person> personSupplier = Person::new;
		System.out.println(personSupplier.get());
	}
}
