/**

public class DefaultHashProvider<T> implements HashProvider<T> {
	public int getHashCode(Object object) {
		return object.hashCode();
	}
	
	public boolean areEquals(Object object1, Object object2) {
		return object1.equals(object2);
	}
}