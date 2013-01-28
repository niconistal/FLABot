/** * $Id: ClassBuilder.java,v 1.1 2006/01/27 18:47:41 dacostae Exp $ * $Author: dacostae $ */package org.isistan.flabot.javamodel.java;

import org.isistan.flabot.javamodel.JClass;import org.isistan.flabot.javamodel.ObjectMirrorBuilder;public class ClassBuilder implements ObjectMirrorBuilder<JClass> {

	public boolean accepts(Object object) {
		return object instanceof Class;
	}
	
	public JClass build(Object object) {
		return new ClassImpl((Class)object);
	}



}
