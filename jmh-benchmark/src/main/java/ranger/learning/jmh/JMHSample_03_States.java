package ranger.learning.jmh;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
/**
 * State代表某种状态，可以在benchmark过程中进行改变
 * @author ranger
 *
 */
public class JMHSample_03_States {
	
	@State(Scope.Benchmark)
	public static class BenchmarkState {
		volatile double x = Math.PI;
	}

	@State(Scope.Thread)
	public static class ThreadState {
		volatile double x = Math.PI;
	}
	@Benchmark
	public void measureUnshared(ThreadState state) {
		state.x ++;
	}

	@Benchmark
	public void measureShared(BenchmarkState state) {
		state.x ++;
	}
	
	 public static void main(String[] args) throws RunnerException {
	        Options opt = new OptionsBuilder()
	                .include(JMHSample_03_States.class.getSimpleName())
	                .threads(4)
	                .forks(2)
	                .build();

	        new Runner(opt).run();
	    }
	

}
