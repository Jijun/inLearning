package ranger.learning.jmh;

import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;

import ranger.learning.jmh.singleton.LazySingleton;
import ranger.learning.jmh.singleton.Singleton;

@OutputTimeUnit(TimeUnit.SECONDS)
@BenchmarkMode(Mode.Throughput)
@Warmup(iterations = 10)
@Fork(value = 1)
@State(Scope.Benchmark)
@Measurement(iterations=10)
public class SingletonTest {
    private static final int LOOPS = 1000;
    @Benchmark
    public int testSingleton() {
        int counter = 0;
        for (int i = 0; i < LOOPS; i++) {
        	Singleton.getInstance();
        }
        return counter;
    }
    
    @Benchmark
    public int testLazySingleton() {
        int counter = 0;
        for (int i = 0; i < LOOPS; i++) {
        	LazySingleton.getInstance();
        }
        return counter;
    }
}
