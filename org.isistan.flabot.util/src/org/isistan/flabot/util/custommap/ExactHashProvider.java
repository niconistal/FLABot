/**

public class ExactHashProvider<T> implements HashProvider<T> {
	public int getHashCode(Object object) {
		return System.identityHashCode(object);
	}
	
	public boolean areEquals(Object object1, Object object2) {
		return object1==object2;
	}
}