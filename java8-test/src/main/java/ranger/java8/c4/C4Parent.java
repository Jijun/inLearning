package ranger.java8.c4;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class C4Parent {
	
	public static ExecutorService executorService = Executors.newFixedThreadPool(2);

	public static void sleep(long seconds) {
		try {
			TimeUnit.SECONDS.sleep(seconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public static void stop(ExecutorService executorService) {
		executorService.shutdown();
		try {
			executorService.awaitTermination(60, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			if (!executorService.isTerminated()) {
				executorService.shutdownNow();
			}
		}
	}

}
