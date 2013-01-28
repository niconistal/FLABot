/** * $Id: BehaviorBuilder.java,v 1.1 2006/01/27 18:47:41 dacostae Exp $ * $Author: dacostae $ */package org.isistan.flabot.javamodel.java;

import java.lang.reflect.Constructor;import java.lang.reflect.Method;import org.isistan.flabot.javamodel.JBehavior;import org.isistan.flabot.javamodel.ObjectMirrorBuilder;public class BehaviorBuilder implements ObjectMirrorBuilder<JBehavior> {

	public boolean accepts(Object object) {
		return object instanceof Method ||
			object instanceof Constructor;
	}

	public JBehavior build(Object object) {
		return null;
	}

}
