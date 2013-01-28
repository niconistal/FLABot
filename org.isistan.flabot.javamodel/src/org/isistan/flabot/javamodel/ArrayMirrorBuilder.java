/**

public interface ArrayMirrorBuilder extends MirrorBuilder<JArray<JObject>> {
	/**
	 * Builds a mirror for the given object that represents an array
	 *  
	 * @param object
	 * @return the mirror if the object is accepted, null otherwise
	 */
	<T extends JObject> JArray<T> build(Object object, ObjectMirrorBuilder<T> componentBuilder);
}