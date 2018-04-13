package ranger.java8.c4;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class SemaphoreTest extends C4Parent {
	public static void main(String[] args) {
		Semaphore semaphore = new Semaphore(5);
		Runnable longRunningTask = () -> {
			boolean permit = false;
			try {
				permit = semaphore.tryAcquire(1, TimeUnit.SECONDS);
				if (permit) {
					System.out.println("Semaphore acquired");
					sleep(5);
				} else {
					System.out.println("Could not acquire semaphore");
				}
			} catch (InterruptedException e) {
				throw new IllegalStateException(e);
			} finally {
				if (permit) {
					semaphore.release();
				}
			}
		};
		IntStream.range(0, 10).forEach(i -> executorService.submit(longRunningTask));
		stop(executorService);
	}
}
