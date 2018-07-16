package ranger.learning.jmh;

import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

public class JMHSample_02_BenchmarkModes {
	/**
	 * JMH会额外生成很多代码，JMH能通过不同方式衡量性能。
	 * 用户可以通过特殊注解选择默认方式，也可以在运行时选择其他方式。
	 * 
	 * @throws InterruptedException
	 */
	@Benchmark
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.SECONDS)
	public void measureThrought() throws InterruptedException {
		TimeUnit.MILLISECONDS.sleep(100);
	}

	@Benchmark
	@BenchmarkMode(Mode.AverageTime)
	@OutputTimeUnit(TimeUnit.MICROSECONDS)
	public void measureAvgTime() throws InterruptedException {
		TimeUnit.MILLISECONDS.sleep(100);
	}

	/**
	 * Mode.SampleTime 采样执行时间，
	 * 
	 * 这允许我们衡量，百分比
	 * 
	 * @throws InterruptedException
	 */
	@Benchmark
	@OutputTimeUnit(TimeUnit.MICROSECONDS)
	@BenchmarkMode(Mode.SampleTime)
	public void measureSamples() throws InterruptedException {
		TimeUnit.MILLISECONDS.sleep(100);
	}

	@Benchmark
	@OutputTimeUnit(TimeUnit.MICROSECONDS)
	@BenchmarkMode(Mode.SingleShotTime)
	public void measureSingleShot() throws InterruptedException {
		TimeUnit.MILLISECONDS.sleep(100);
	}

	/*
	 * We can also ask for multiple benchmark modes at once. All the tests above
	 * can be replaced with just a single test like this:
	 */
	@Benchmark
	@BenchmarkMode({ Mode.Throughput, Mode.AverageTime, Mode.SampleTime, Mode.SingleShotTime })
	@OutputTimeUnit(TimeUnit.MICROSECONDS)
	public void measureMultiple() throws InterruptedException {
		TimeUnit.MILLISECONDS.sleep(100);
	}

    /*
     * Or even...
     */
    @Benchmark
    @BenchmarkMode(Mode.All)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    public void measureAll() throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(100);
    }

	public static void main(String[] args) throws RunnerException {
		Options options = new OptionsBuilder().include(JMHSample_02_BenchmarkModes.class.getSimpleName()).forks(1)
				.build();
		new Runner(options).run();
	}

}
