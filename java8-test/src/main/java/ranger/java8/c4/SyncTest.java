package ranger.java8.c4;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class SyncTest {
	int count = 0;

	synchronized void incrementSync() {
		count = count + 1;
	}

	void test() {
		ExecutorService executorService = Executors.newFixedThreadPool(2);
		IntStream.range(0, 1000).forEach(i -> executorService.submit(this::incrementSync));
	}

	public static void main(String[] args) {
		SyncTest test = new SyncTest();
		test.test();
	}
}
