package ranger.learning.jmh.singleton;

import java.io.Serializable;

public class SerializableSingleton implements Serializable{
	private SerializableSingleton() {
	}
	private static final SerializableSingleton instance = new SerializableSingleton();
	
	public static final SerializableSingleton getInstance() {
		return instance;
	}
	
	public Object readResolve() {
		return instance;
	}
}
