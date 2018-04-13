package ranger.java8.c4;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * ReadWriteLock 接口规定了锁的另一种类型,包含用于读写访问的一对锁。读写
 * 锁的理念是,只要没有任何线程写入变量,并发读取可变变量通常是安全的。所以 
 * 读锁可以同时被多个线程持有,只要没有线程持有写锁。这样可以提升性能和吞吐
 * 量,因为读取比写入更加频繁。
 * -----》ReentrantReadWriteLock写锁的互斥的
（读和读---不互斥，读和写---互斥，写和写----互斥）

 * @description //TODO 设计说明
 * @author ranger
 * @date Apr 11, 2018
 */
public class ReadWriteLockTest extends C4Parent {
	public static void main(String[] args) {
		Map<String, String> map = new HashMap<>();
		ReadWriteLock lock = new ReentrantReadWriteLock();
		executorService.submit(() -> {
			lock.writeLock().lock();
			try {
				sleep(1);
				map.put("foo", "bar");
			} finally {
				lock.writeLock().unlock();
			}
		});

		Runnable readTask = () -> {
			lock.readLock().lock();
			try {
				System.out.println(map.get("foo"));
				sleep(1);
			} finally {
				lock.readLock().unlock();
			}
		};
		executorService.submit(readTask);
		executorService.submit(readTask);
		stop(executorService);
	}


}
