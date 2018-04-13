package ranger.java8.c4;

import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.StampedLock;

public class StampedLockTest extends C4Parent {
	
	private int balance;
	private StampedLock lock = new StampedLock();
	
	public void conditionReadWrite(int value) {
		long stamp = lock.readLock();
		while(balance > 0) {
			long writeStamp = lock.tryConvertToOptimisticRead(stamp);
			if(writeStamp != 0) {//成功转换为写锁
				stamp = writeStamp;
				balance +=value;
				break;
			} else {
				//没有转换成写锁，这里需要首先释放读锁，然后再拿写锁
				lock.unlockRead(stamp);
				//获取写锁
				stamp = lock.writeLock();
			}
		}
		lock.unlock(stamp);
	}
	
	public void optimisticRead() {
		long stamp = lock.tryOptimisticRead();
		int c = balance;
		// 这里可能会出现了写操作，因此要进行判断
		if(!lock.validate(stamp)) {
			long readStamp = lock.readLock();
			c = balance;
			stamp = readStamp;
		}
		lock.unlockRead(stamp);
	}
	
	public void read() {
		long stamp = lock.readLock();
		lock.tryOptimisticRead();
		int c = balance;
		lock.unlockRead(stamp);
	}
	
	public void write(int value) {
		long stamp = lock.writeLock();
		balance +=value;
		lock.unlock(stamp);
	}
	
	
	public static void main(String[] args) {
		LockSupport.parkNanos(610000000);
	}
	
}
