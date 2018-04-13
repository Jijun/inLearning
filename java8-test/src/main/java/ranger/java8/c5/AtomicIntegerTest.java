package ranger.java8.c5;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

import ranger.java8.c4.C4Parent;

public class AtomicIntegerTest extends C4Parent {
	public static void main(String[] args) {

		AtomicInteger atomicInteger = new AtomicInteger(0);
		IntStream.range(0, 1000).forEach(i -> executorService.submit(atomicInteger::incrementAndGet));

		IntStream.range(0, 1000).forEach(i-> {
			Runnable task = () -> {
				atomicInteger.accumulateAndGet(i, (n,m)-> n+m);
			};
			executorService.submit(task);
			System.out.println(atomicInteger.get());
		});
		
		System.out.println(atomicInteger.get());
		stop(executorService);
		
	}
}
