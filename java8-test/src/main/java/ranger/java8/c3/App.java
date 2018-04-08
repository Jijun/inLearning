package ranger.java8.c3;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import com.sun.corba.se.impl.orbutil.closure.Future;

public class App {
	public static void main(String[] args) throws InterruptedException {

		Runnable task = () -> {
			String currentThreadName = Thread.currentThread().getName();
			System.out.println(currentThreadName);
		};
		task.run();

		Thread thread = new Thread(task);
		thread.start();
		System.out.println("done!");
		ExecutorService executorService = Executors.newSingleThreadExecutor();
		executorService.submit(() -> {
			System.out.println("hello " + Thread.currentThread().getName());
		});
		executorService.shutdown();
		try {
			executorService.awaitTermination(5, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			if (!executorService.isTerminated()) {
				System.out.println("cancel nonfinished tasks");
			}
			executorService.shutdownNow();
		}
		ExecutorService executor = Executors.newWorkStealingPool();

		List<Callable<String>> callables = Arrays.asList(() -> "task1", () -> "task2", () -> "task3");

		executor.invokeAll(callables).stream().map(future -> {
			try {
				return future.get();
			} catch (Exception e) {
				throw new IllegalStateException();
			}
		}).forEach(System.out::println);

	}
}
