/** * $Id: TypeBuilder.java,v 1.1 2006/01/27 18:47:41 dacostae Exp $ * $Author: dacostae $ */package org.isistan.flabot.javamodel.java;

import java.lang.reflect.Type;import org.isistan.flabot.javamodel.JType;import org.isistan.flabot.javamodel.ObjectMirrorBuilder;public class TypeBuilder implements ObjectMirrorBuilder<JType> {

	public boolean accepts(Object object) {
		return object instanceof Type;
	}

	public JType build(Object object) {
		return new TypeImpl((Type)object);
	}

}
