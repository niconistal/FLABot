/** * $Id: AnnotationImpl.java,v 1.3 2006/03/18 00:25:06 dacostae Exp $ * $Author: dacostae $ */package org.isistan.flabot.javamodel.java;

import java.lang.annotation.Annotation;import org.isistan.flabot.javamodel.JAnnotation;import org.isistan.flabot.javamodel.JClass;import org.isistan.flabot.javamodel.MixedImplementationsException;public class AnnotationImpl extends ObjectImpl implements JAnnotation {
	private Annotation javaAnnotation;
	
	Annotation getJavaAnnotation() {
		return javaAnnotation;
	}
	
	static Annotation getJavaAnnotation(JAnnotation jAnnotation) {
		if(jAnnotation instanceof AnnotationImpl) {
			return ((AnnotationImpl)jAnnotation).getJavaAnnotation();
		} else {
			throw new MixedImplementationsException(jAnnotation);
		} 
	}
	
	AnnotationImpl(Annotation javaAnnotation) {
		super(javaAnnotation);
		this.javaAnnotation=javaAnnotation;
	}
	
	public JClass annotationType() {
		return JavaFactory.getInstance().buildClass(javaAnnotation.annotationType());
	}
}
