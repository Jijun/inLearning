package ranger.learning.jmh.singleton;

public class StaticSingleton {
	private StaticSingleton() {
	}

	private static final class SingletonHolder {
		private static StaticSingleton instance = new StaticSingleton();
	}

	public static final StaticSingleton getInstance() {
		return SingletonHolder.instance;

	}
}
