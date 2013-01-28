/** * $Id: MirrorBuilder.java,v 1.1 2006/01/27 18:48:09 dacostae Exp $ * $Author: dacostae $ */package org.isistan.flabot.javamodel;

public interface MirrorBuilder<T extends JObject> {
	
	/**
	 * Used to gather if the builder can build the mirror
	 * @param object
	 * @return
	 */
	boolean accepts(Object object);
	
}
