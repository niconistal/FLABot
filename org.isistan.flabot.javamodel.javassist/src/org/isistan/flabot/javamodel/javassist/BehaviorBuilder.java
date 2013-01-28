/** * $Id: BehaviorBuilder.java,v 1.2 2006/02/03 04:42:25 dacostae Exp $ * $Author: dacostae $ */package org.isistan.flabot.javamodel.javassist;

import javassist.CtBehavior;import org.isistan.flabot.javamodel.JBehavior;import org.isistan.flabot.javamodel.ObjectMirrorBuilder;public class BehaviorBuilder implements ObjectMirrorBuilder<JBehavior> {

	public boolean accepts(Object object) {
		return object instanceof CtBehavior;
	}

	public JBehavior build(Object object) {
		return null;
	}

}
