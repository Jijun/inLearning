package ranger.learning.jmh.calc;

import java.util.stream.IntStream;

public class MultithreadCalculator implements Calculator {
	private int availableProcessors ;
	
	public MultithreadCalculator(int availableProcessors) {
		this.availableProcessors = availableProcessors;
	}

	@Override
	public long sum(int[] numbers) {
		return IntStream.of(numbers).parallel().sum();
	}

	@Override
	public void shutdown() {

	}

}
