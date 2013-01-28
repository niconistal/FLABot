/** * $Id: ObjectBoolean.java,v 1.1 2006/01/27 18:45:32 dacostae Exp $ * $Author: dacostae $ */package org.isistan.flabot.util;

/**
 * This class represents a boolean in the form of Object.
 * It should be used instead of java.lang.Boolean when
 * a mutable object is needed
 * 
 * @author $Author: dacostae $
 *
 */
public class ObjectBoolean {
	public ObjectBoolean() {
	}
	
	public ObjectBoolean(boolean value) {
		this.value=value;
	}
	
	public boolean value=false;
}
