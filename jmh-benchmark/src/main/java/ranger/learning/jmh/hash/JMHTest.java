package ranger.learning.jmh.hash;

import java.nio.charset.Charset;
import java.util.HashSet;
import java.util.Set;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import com.google.common.hash.Hashing;

public class JMHTest {

	@State(Scope.Benchmark)
	public static class BenchmarkState {
		char[] alpahBetas = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r',
				's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };
		int length = alpahBetas.length;
		int numberOfReplicas = 1024;
		Set<String> nodes = new HashSet<String>();
		for (int i = 0; i < length; i++) {
			nodes.add("base_file_" + alpahBetas[i]);
		}
		static ConsistentHash<String> test = new ConsistentHash<String>(new HashFunction(), 10, nodes);
	}

	Charset utf8 = Charset.forName("utf8");

	@Setup
	public void init() {
	}

	@Benchmark
	public void doNormalHash() {
		BenchmarkState.test.get("ff808081588ff35d01589544dcad0541");
	}

	@Benchmark
	public void doGuavaHash() {
		Hashing.consistentHash(Hashing.sha256().hashString("ff808081588ff35d01589544dcad0541", utf8), 26);
	}

	public static void main(String[] args) throws RunnerException {

		Options options = new OptionsBuilder().include(JMHTest.class.getSimpleName()).forks(1).build();
		new Runner(options).run();

	}
}
