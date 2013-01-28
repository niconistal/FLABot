/** * $Id: ThrowableBuilder.java,v 1.1 2006/02/16 01:57:48 dacostae Exp $ * $Author: dacostae $ */package org.isistan.flabot.javamodel.java;

import org.isistan.flabot.javamodel.JThrowable;import org.isistan.flabot.javamodel.ObjectMirrorBuilder;public class ThrowableBuilder implements ObjectMirrorBuilder<JThrowable> {

	public boolean accepts(Object object) {
		return object instanceof Throwable;
	}
	
	public JThrowable build(Object object) {
		return new ThrowableImpl((Throwable)object);
	}



}
