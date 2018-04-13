package ranger.java8.c5;

import java.util.concurrent.atomic.LongAccumulator;
import java.util.function.LongBinaryOperator;
import java.util.stream.IntStream;

import ranger.java8.c4.C4Parent;

public class LongAccumulatorTest extends C4Parent {

	
	public static void main(String[] args) {
		LongBinaryOperator operator = (x, y) -> 2 * x + y;
		LongAccumulator accumulator = new LongAccumulator(operator, 1L);
		IntStream.range(0,10).forEach(i->executorService.submit(()->accumulator.accumulate(i)));;
		stop(executorService);
		System.out.println(accumulator.getThenReset());
		
	}
	
}
