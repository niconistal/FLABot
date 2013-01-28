/** * $Id: ObjectMirrorBuilder.java,v 1.1 2006/01/27 18:48:10 dacostae Exp $ * $Author: dacostae $ */package org.isistan.flabot.javamodel;

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
