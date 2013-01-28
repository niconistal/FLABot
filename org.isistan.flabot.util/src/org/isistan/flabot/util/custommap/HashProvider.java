/**

/**
 * This class provides an alternative for hashCode and equals methods
 * Remember the contracts between those methods still remain:
 * 	- Object that are equals must have the same hashCode
 * 	- hashCode and equals should be "inmutable" during the lifecycle
 *  - equals(x, y) should be the same as equals(y, x)
 * 
 * @author $Author: dacostae $
 *
 * @param <T>
 */
public interface HashProvider<T> {
		
	public int getHashCode(Object object);
	
	public boolean areEquals(Object object1, Object object2);
}