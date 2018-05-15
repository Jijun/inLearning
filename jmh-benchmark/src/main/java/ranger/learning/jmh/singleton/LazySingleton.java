package ranger.learning.jmh.singleton;

public class LazySingleton {
	private LazySingleton() {
	}

	private static LazySingleton instance = null;

	public synchronized static final LazySingleton getInstance() {
		if (instance == null)
			instance = new LazySingleton();

		return instance;
	}
}
