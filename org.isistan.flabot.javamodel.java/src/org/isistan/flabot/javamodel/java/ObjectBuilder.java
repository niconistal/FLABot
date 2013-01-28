/** * $Id: ObjectBuilder.java,v 1.1 2006/01/27 18:47:41 dacostae Exp $ * $Author: dacostae $ */package org.isistan.flabot.javamodel.java;

import org.isistan.flabot.javamodel.JObject;import org.isistan.flabot.javamodel.ObjectMirrorBuilder;public class ObjectBuilder implements ObjectMirrorBuilder<JObject> {

	public boolean accepts(Object object) {
		return true;
	}

	public JObject build(Object object) {
		return new ObjectImpl(object);
	}

}

