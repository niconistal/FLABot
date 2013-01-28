/** * $Id: BehaviorBuilder.java,v 1.4 2006/03/18 00:25:14 dacostae Exp $ * $Author: dacostae $ */package org.isistan.flabot.javamodel.jdt;

import org.eclipse.jdt.core.IMethod;import org.isistan.flabot.javamodel.JBehavior;import org.isistan.flabot.javamodel.ObjectMirrorBuilder;import org.isistan.flabot.javamodel.jdt.ImplicitConstructorImpl.JDTImplicitConstructor;public class BehaviorBuilder implements ObjectMirrorBuilder<JBehavior> {

	public boolean accepts(Object object) {
		return object instanceof IMethod || object instanceof JDTImplicitConstructor;
	}

	public JBehavior build(Object object) {
		//can't do anything behavior is ficticious for jdt, only method exists
		return null;
	}

}
