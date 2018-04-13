package ranger.java8.c4;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest extends C4Parent {

	public static void main(String[] args) {
		ReentrantLock lock = new ReentrantLock();
		executorService.submit(() -> {
			lock.lock();
			try {
				sleep(1);
			} finally {
				lock.unlock();
			}
		});
		executorService.submit(() -> {
			System.out.println("Locked: " + lock.isLocked());
			System.out.println("Held by me:" + lock.isHeldByCurrentThread());

			boolean locked = lock.tryLock();
			System.out.println("lock acquired : " + locked);
			try {
				locked = lock.tryLock(10, TimeUnit.SECONDS);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("lock acquired : " + locked);
		});

	}

}