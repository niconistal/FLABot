/** * $Id: ConstructorBuilder.java,v 1.1 2006/01/27 18:46:32 dacostae Exp $ * $Author: dacostae $ */package org.isistan.flabot.javamodel.javassist;

import javassist.CtConstructor;import org.isistan.flabot.javamodel.JConstructor;import org.isistan.flabot.javamodel.ObjectMirrorBuilder;public class ConstructorBuilder implements ObjectMirrorBuilder<JConstructor> {

	public boolean accepts(Object object) {
		return object instanceof CtConstructor;
	}
	public JConstructor build(Object object) {
		return new ConstructorImpl((CtConstructor)object);
	}



}
