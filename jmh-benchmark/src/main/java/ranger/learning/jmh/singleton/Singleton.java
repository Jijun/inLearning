package ranger.learning.jmh.singleton;

public class Singleton {
	
	private Singleton() {
	}
	private static final Singleton instance = new Singleton();
	
	public static final Singleton getInstance() {
		return instance;
	}
	
}
