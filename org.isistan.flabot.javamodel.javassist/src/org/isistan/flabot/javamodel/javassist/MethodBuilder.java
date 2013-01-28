/** * $Id: MethodBuilder.java,v 1.1 2006/01/27 18:46:32 dacostae Exp $ * $Author: dacostae $ */package org.isistan.flabot.javamodel.javassist;

import javassist.CtMethod;import org.isistan.flabot.javamodel.JMethod;import org.isistan.flabot.javamodel.ObjectMirrorBuilder;public class MethodBuilder implements ObjectMirrorBuilder<JMethod> {

	public boolean accepts(Object object) {
		return object instanceof CtMethod;
	}

	public JMethod build(Object object) {
		return new MethodImpl((CtMethod)object);
	}


}
