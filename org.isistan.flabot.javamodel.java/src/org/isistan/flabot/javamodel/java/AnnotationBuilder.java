/** * $Id: AnnotationBuilder.java,v 1.1 2006/01/27 18:47:41 dacostae Exp $ * $Author: dacostae $ */package org.isistan.flabot.javamodel.java;

import java.lang.annotation.Annotation;import org.isistan.flabot.javamodel.JAnnotation;import org.isistan.flabot.javamodel.ObjectMirrorBuilder;public class AnnotationBuilder implements ObjectMirrorBuilder<JAnnotation> {
	public boolean accepts(Object object) {
		return object instanceof Annotation;
	}
	
	public JAnnotation build(Object object) {
		return new AnnotationImpl((Annotation)object);
	}



}