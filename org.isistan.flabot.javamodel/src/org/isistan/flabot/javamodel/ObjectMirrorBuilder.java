/**

/**
 * Builder for object mirror
 * @author $Author: dacostae $
 *
 */
public interface ObjectMirrorBuilder<T extends JObject> extends MirrorBuilder<T> {

	/**
	 * Builds a mirror for the given object
	 *  
	 * @param object
	 * @return the mirror if the object is accepted, null otherwise
	 */
	T build(Object object);
}