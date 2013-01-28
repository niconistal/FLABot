/** * $Id: ArrayMirrorBuilder.java,v 1.1 2006/01/27 18:48:10 dacostae Exp $ * $Author: dacostae $ */package org.isistan.flabot.javamodel;

public interface ArrayMirrorBuilder extends MirrorBuilder<JArray<JObject>> {
	/**
	 * Builds a mirror for the given object that represents an array
	 *  
	 * @param object
	 * @return the mirror if the object is accepted, null otherwise
	 */
	<T extends JObject> JArray<T> build(Object object, ObjectMirrorBuilder<T> componentBuilder);
}
