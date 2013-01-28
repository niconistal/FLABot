/** * $Id: AnnotatedElementImpl.java,v 1.3 2006/03/18 00:25:06 dacostae Exp $ * $Author: dacostae $ */package org.isistan.flabot.javamodel.java;

import java.lang.reflect.AnnotatedElement;import org.isistan.flabot.javamodel.JAnnotatedElement;import org.isistan.flabot.javamodel.JAnnotation;import org.isistan.flabot.javamodel.JArray;import org.isistan.flabot.javamodel.JClass;import org.isistan.flabot.javamodel.MixedImplementationsException;public class AnnotatedElementImpl extends ObjectImpl implements
		JAnnotatedElement {

	private AnnotatedElement javaAnnotatedElement;
	
	AnnotatedElement getJavaAnnotatedElement() {
		return javaAnnotatedElement;
	}
	
	static AnnotatedElement getJavaClass(JAnnotatedElement jAnnotatedElement) {
		if(jAnnotatedElement instanceof AnnotatedElementImpl) {
			return ((AnnotatedElementImpl)jAnnotatedElement).getJavaAnnotatedElement();
		} else {
			throw new MixedImplementationsException(jAnnotatedElement);
		} 
	}
	
	AnnotatedElementImpl(AnnotatedElement javaAnnotatedElement) {
		super(javaAnnotatedElement);
		this.javaAnnotatedElement=javaAnnotatedElement;
	}
	
	public boolean isAnnotationPresent(JClass annotationType) {
		return javaAnnotatedElement.isAnnotationPresent(
				ClassImpl.getJavaClass(annotationType)
			);		
	}

	public JAnnotation getAnnotation(JClass annotationType) {
		return JavaFactory.getInstance().buildAnnotation(
				javaAnnotatedElement.getAnnotation(ClassImpl.getJavaClass(annotationType))
			);		
	}

	public JArray<? extends JAnnotation> getAnnotations() {
		return JavaFactory.getInstance().buildArray(
				javaAnnotatedElement.getAnnotations(),
				JavaFactory.getInstance().getAnnotationBuilder()
			);
	}

	public JArray<? extends JAnnotation> getDeclaredAnnotations() {
		return JavaFactory.getInstance().buildArray(
				javaAnnotatedElement.getDeclaredAnnotations(), 
				JavaFactory.getInstance().getAnnotationBuilder()
			);
	}

}
