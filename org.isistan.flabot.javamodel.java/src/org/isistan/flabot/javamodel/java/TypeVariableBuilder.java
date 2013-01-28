/** * $Id: TypeVariableBuilder.java,v 1.1 2006/01/27 18:47:41 dacostae Exp $ * $Author: dacostae $ */package org.isistan.flabot.javamodel.java;

import java.lang.reflect.TypeVariable;import org.isistan.flabot.javamodel.JTypeVariable;import org.isistan.flabot.javamodel.ObjectMirrorBuilder;public class TypeVariableBuilder implements ObjectMirrorBuilder<JTypeVariable> {

	public boolean accepts(Object object) {
		return object instanceof TypeVariable;
	}

	public JTypeVariable build(Object object) {
		return new TypeVariableImpl((TypeVariable)object);
	}



}
