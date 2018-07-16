package ranger.learning.jmh;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.TearDown;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

@State(Scope.Thread)
public class JMHSample_05_StateFixtures {
    double x;
    @Setup
    public void prepare() {
    	System.out.println("prepare");
    	x = Math.PI;
    }
    
    @TearDown
    public void check() {
    	System.out.println("tear down");
    	assert x > Math.PI:"Nothing changed?";
    }
    
    @Benchmark
    public void measureRight() {
    	x ++;
    }
    
    @Benchmark
    public void measureWrong() {
    	double x = 0;
    	x ++;
    }
    
    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(JMHSample_05_StateFixtures.class.getSimpleName())
                .forks(1).warmupIterations(1)
                .jvmArgs("-ea")
                .build();

        new Runner(opt).run();
	}
    
    
}
