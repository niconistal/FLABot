/** * $Id: ExactHashProvider.java,v 1.2 2006/02/16 20:52:51 dacostae Exp $ * $Author: dacostae $ */package org.isistan.flabot.util.custommap;

public class ExactHashProvider<T> implements HashProvider<T> {
	public int getHashCode(Object object) {
		return System.identityHashCode(object);
	}
	
	public boolean areEquals(Object object1, Object object2) {
		return object1==object2;
	}
}
