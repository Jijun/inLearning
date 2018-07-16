package ranger.learning.jmh.hash;

import java.util.Collection;
import java.util.SortedMap;
import java.util.TreeMap;

import org.openjdk.jmh.annotations.Benchmark;

/**
 * 
 * @author ranger
 *
 * @param <T>
 */
public class ConsistentHash<T> {
	private HashFunction hashFunction;
	private final int numberOfReplicas; // 虚拟节点
	private final SortedMap<Long, T> circle = new TreeMap<Long, T>(); // 用来存储虚拟节点hash值
																		// 到真实node的映射

	public ConsistentHash(HashFunction hashFunction, int numberOfReplicas, Collection<T> nodes) {
		this.hashFunction = hashFunction;
		this.numberOfReplicas = numberOfReplicas;

		for (T node : nodes) {
			add(node);
		}
	}

	public void add(T node) {
		for (int i = 0; i < numberOfReplicas; i++) {
			circle.put(hashFunction.hash(node.toString() + i), node);
		}
	}

	public void remove(T node) {
		for (int i = 0; i < numberOfReplicas; i++) {
			circle.remove(hashFunction.hash(node.toString() + i));
		}
	}

	/**
	 * 获得一个最近的顺时针节点
	 * 
	 * @param key
	 *            为给定键取Hash，取得顺时针方向上最近的一个虚拟节点对应的实际节点
	 * @return
	 */
	@Benchmark
	public T get(final String key) {
		if (circle.isEmpty()) {
			return null;
		}
		long hash = hashFunction.hash(key);
		if (!circle.containsKey(hash)) {
			SortedMap<Long, T> tailMap = circle.tailMap(hash); //// 返回此映射的部分视图，其键大于等于
																//// hash
			hash = tailMap.isEmpty() ? circle.firstKey() : tailMap.firstKey();
		}
		return circle.get(hash);
	}

	public long size() {
		return circle.size();
	}

	// public static void main(String[] args) {
	// char[] alpahBetas = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
	// 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r',
	// 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };
	// int length = alpahBetas.length;
	// int numberOfReplicas = 1024;
	// Set<String> nodes = new HashSet<String>();
	// for (int i = 0; i < length; i++) {
	// nodes.add("base_file_" + alpahBetas[i]);
	// }
	// ConsistentHash test = new ConsistentHash<String>(new HashFunction(),
	// numberOfReplicas, nodes);
	// System.out.println(test.size());
	// System.out.println(test.get("ff808081588ff35d01589544dcad0541"));
	// System.out.println(test.get("ff8080815adb2da1015b6625ff957d7e"));
	// System.out.println(test.get("60c76b456490fcbbe050adcae90842fb"));
	// System.out.println(test.get("5de1c145aba8e70ce050adcae9089dd0"));
	// System.out.println(test.get("5a4a13ef1372d815e050adcae908dcba"));
	// System.out.println(test.get("54ccc7db5403d239e050adcae908c82a"));
	// System.out.println(test.get("60e4897f4ad7d8e3e050adcae908d575"));
	// System.out.println(test.get("60cfc435fac9320ce050adcae90842a2"));
	// System.out.println(test.get("54e39fcd15565262e050adcae908594b"));
	// System.out.println(test.get("ff80808155818a81015594df1d641285"));
	// System.out.println(test.get("60300c3c02395ed1e050adcae9088db6"));
	// }

}
