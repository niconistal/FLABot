/** * $Id: ConstructorBuilder.java,v 1.1 2006/01/27 18:47:41 dacostae Exp $ * $Author: dacostae $ */package org.isistan.flabot.javamodel.java;

import java.lang.reflect.Constructor;import org.isistan.flabot.javamodel.JConstructor;import org.isistan.flabot.javamodel.ObjectMirrorBuilder;public class ConstructorBuilder implements ObjectMirrorBuilder<JConstructor> {

	public boolean accepts(Object object) {
		return object instanceof Constructor;
	}
	public JConstructor build(Object object) {
		return new ConstructorImpl((Constructor)object);
	}



}
