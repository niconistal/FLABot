/** * $Id: AnnotatedElementBuilder.java,v 1.1 2006/01/27 18:47:41 dacostae Exp $ * $Author: dacostae $ */package org.isistan.flabot.javamodel.java;

import java.lang.reflect.AnnotatedElement;import org.isistan.flabot.javamodel.JAnnotatedElement;import org.isistan.flabot.javamodel.ObjectMirrorBuilder;public class AnnotatedElementBuilder implements ObjectMirrorBuilder<JAnnotatedElement> {
	
	public boolean accepts(Object object) {
		return object instanceof AnnotatedElement;
	}
	
	public JAnnotatedElement build(Object object) {
		return new AnnotatedElementImpl((AnnotatedElement)object);
	}

}
