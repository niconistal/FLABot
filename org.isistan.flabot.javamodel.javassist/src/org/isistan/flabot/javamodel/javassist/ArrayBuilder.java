/** * $Id: ArrayBuilder.java,v 1.1 2006/01/27 18:46:32 dacostae Exp $ * $Author: dacostae $ */package org.isistan.flabot.javamodel.javassist;

import org.isistan.flabot.javamodel.ArrayMirrorBuilder;import org.isistan.flabot.javamodel.JArray;import org.isistan.flabot.javamodel.JObject;import org.isistan.flabot.javamodel.ObjectMirrorBuilder;public class ArrayBuilder implements ArrayMirrorBuilder {

	public boolean accepts(Object object) {
		return object instanceof Object[];
	}

	public <T extends JObject> JArray<T> build(Object object, ObjectMirrorBuilder<T> componentBuilder) {
		return new ArrayImpl<T>((Object[])object, componentBuilder);
	}
}
