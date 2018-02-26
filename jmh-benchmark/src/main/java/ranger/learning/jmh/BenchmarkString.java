package ranger.learning.jmh;

import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

@OutputTimeUnit(TimeUnit.SECONDS)
@BenchmarkMode(Mode.Throughput)
@Warmup(iterations = 10)
@Fork(value = 1)
@State(Scope.Benchmark)
public class BenchmarkString {
	
    private static final int LOOPS = 1000;

    @Benchmark
    public int testConcat() {
        int counter = 0;
        for (int i = 0; i < LOOPS; i++) {
            String s = "dododo hello " + counter + " by " + counter + "?";
            counter += s.length();
        }
        return counter;
    }

    @Benchmark
    public int testFormat() {
        int counter = 0;
        for (int i = 0; i < LOOPS; i++) {
            String s = String.format("dododo hello %d by %d?", counter, counter);
            counter += s.length();
        }
        return counter;
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(BenchmarkString.class.getSimpleName())
                .forks(1)
                .build();
        new Runner(opt).run();
    }
}
