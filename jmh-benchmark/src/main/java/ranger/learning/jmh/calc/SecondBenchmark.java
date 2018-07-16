package ranger.learning.jmh.calc;

import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.TearDown;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
@State(Scope.Benchmark)
public class SecondBenchmark {
	// @Param 可以用来指定某项参数的多种情况。特别适合用来测试一个函数在不同的参数输入的情况下的性能。
	@Param({ "10000", "100000", "1000000" })
	private int length;

	private int[] numbers;
	private Calculator singleThreadCalc;
	private Calculator multiThreadCalc;
//	@Setup 会在执行 benchmark 之前被执行，正如其名，主要用于初始化。
//	Level
//	用于控制 @Setup，@TearDown 的调用时机，默认是 Level.Trial，即benchmark开始前和结束后。

	@Setup
	public void prepare() {
		numbers = IntStream.rangeClosed(1, length).toArray();
		singleThreadCalc = new SinglethreadCalculator();
		multiThreadCalc = new MultithreadCalculator(Runtime.getRuntime().availableProcessors());

	}

	@Benchmark
	public long singleThreadBench() {
		return singleThreadCalc.sum(numbers);
	}

	@Benchmark
	public long multiThreadBench() {
		return multiThreadCalc.sum(numbers);
	}
	//@TearDown 和 @Setup 相对的，会在所有 benchmark 执行结束以后执行，主要用于资源的回收等。

	@TearDown
	public void shutdown() {
		singleThreadCalc.shutdown();
		multiThreadCalc.shutdown();
	}

	public static void main(String[] args) throws RunnerException {
		Options opt = new OptionsBuilder().include(SecondBenchmark.class.getSimpleName()).forks(2).warmupIterations(5)
				.measurementIterations(5).build();

		new Runner(opt).run();
	}

}
