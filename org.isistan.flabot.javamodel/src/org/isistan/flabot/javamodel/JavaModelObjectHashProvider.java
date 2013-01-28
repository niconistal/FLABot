/** * $Id: JavaModelObjectHashProvider.java,v 1.3 2006/02/16 20:52:50 dacostae Exp $ * $Author: dacostae $ */package org.isistan.flabot.javamodel;

import org.isistan.flabot.javamodel.JObject;import org.isistan.flabot.util.custommap.HashProvider;public class JavaModelObjectHashProvider<T extends JObject> implements HashProvider<T> {
	public int getHashCode(Object object) {
		return ((JObject)object).objectHashCode();
	}
	
	public boolean areEquals(Object object1, Object object2) {
		return ((JObject)object1).objectEquals((JObject)object2);
	}
}
