/**

public interface MirrorBuilder<T extends JObject> {
	
	/**
	 * Used to gather if the builder can build the mirror
	 * @param object
	 * @return
	 */
	boolean accepts(Object object);
	
}