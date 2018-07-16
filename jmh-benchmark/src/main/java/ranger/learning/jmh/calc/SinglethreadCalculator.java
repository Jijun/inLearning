package ranger.learning.jmh.calc;

public class SinglethreadCalculator implements Calculator {

	@Override
	public long sum(int[] numbers) {
		long total = 0L;
		for(int i: numbers) {
			total +=i;
		}
		
		return total;
	}

	@Override
	public void shutdown() {

	}

}
