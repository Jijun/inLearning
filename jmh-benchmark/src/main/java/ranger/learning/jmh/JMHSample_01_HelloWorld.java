package ranger.learning.jmh;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

public class JMHSample_01_HelloWorld {

	/**
	 * JMH 如下：
	 * 用户给方法添加注解@Benchmark， 然后JMH尽可能可靠的生成一些特殊的benchmark
	 *基本上，@Benchemark方法就是我们想评估的性能。
	 * @description //TODO 设计说明
	 * @author ranger
	 * @date May 15, 2018
	 * @modified by xxx 修改说明
	 */
	
	@Benchmark
	public void wellHelloThere() {
		//这个方法留空了
		System.out.println("test");
	}
	
	
	/**
	 * 你将看到许多循环。
	 * mvn clean install
	 * java -jar target/benchmarks.jar 
	 * @description //TODO 设计说明
	 * @author ranger
	 * @date May 15, 2018
	 * @modified by xxx 修改说明
	 * @param args
	 * @throws RunnerException 
	 */
	public static void main(String[] args) throws RunnerException {
		Options options = new OptionsBuilder().include(JMHSample_01_HelloWorld.class.getSimpleName()).forks(1).build();
		new Runner(options).run();
	}

}
