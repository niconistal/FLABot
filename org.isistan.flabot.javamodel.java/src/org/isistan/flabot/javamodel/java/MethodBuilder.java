/** * $Id: MethodBuilder.java,v 1.1 2006/01/27 18:47:41 dacostae Exp $ * $Author: dacostae $ */package org.isistan.flabot.javamodel.java;

import java.lang.reflect.Method;import org.isistan.flabot.javamodel.JMethod;import org.isistan.flabot.javamodel.ObjectMirrorBuilder;public class MethodBuilder implements ObjectMirrorBuilder<JMethod> {

	public boolean accepts(Object object) {
		return object instanceof Method;
	}

	public JMethod build(Object object) {
		return new MethodImpl((Method)object);
	}


}
