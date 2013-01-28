/** * $Id: AccessibleObjectImpl.java,v 1.3 2006/03/18 00:25:07 dacostae Exp $ * $Author: dacostae $ */package org.isistan.flabot.javamodel.java;

import java.lang.reflect.AccessibleObject;import org.isistan.flabot.javamodel.JAccessibleObject;import org.isistan.flabot.javamodel.JAnnotation;import org.isistan.flabot.javamodel.JArray;import org.isistan.flabot.javamodel.JClass;import org.isistan.flabot.javamodel.MixedImplementationsException;public class AccessibleObjectImpl extends ObjectImpl implements
		JAccessibleObject {
	
	private AccessibleObject javaAccessibleObject;
	
	AccessibleObject getJavaAccessibleObject() {
		return javaAccessibleObject;
	}
	
	static AccessibleObject getJavaAccessibleObject(JAccessibleObject jAccessibleObject) {
		if(jAccessibleObject instanceof AccessibleObjectImpl) {
			return ((AccessibleObjectImpl)jAccessibleObject).getJavaAccessibleObject();
		} else {
			throw new MixedImplementationsException(jAccessibleObject);
		} 
	}
	
	AccessibleObjectImpl(AccessibleObject javaAccessibleObject) {
		super(javaAccessibleObject);
		this.javaAccessibleObject=javaAccessibleObject;
	}

	public void setAccessible(boolean flag) throws SecurityException {
		javaAccessibleObject.setAccessible(flag);
	}

	public boolean isAccessible() {
		return javaAccessibleObject.isAccessible();
	}

	public boolean isAnnotationPresent(JClass annotationType) {
		return javaAccessibleObject.isAnnotationPresent(
				ClassImpl.getJavaClass(annotationType)
			);		
	}

	public JAnnotation getAnnotation(JClass annotationType) {
		return JavaFactory.getInstance().buildAnnotation(
				javaAccessibleObject.getAnnotation(ClassImpl.getJavaClass(annotationType))
			);		
	}

	public JArray<? extends JAnnotation> getAnnotations() {
		return JavaFactory.getInstance().buildArray(
				javaAccessibleObject.getAnnotations(),
				JavaFactory.getInstance().getAnnotationBuilder()
			);
	}

	public JArray<? extends JAnnotation> getDeclaredAnnotations() {
		return JavaFactory.getInstance().buildArray(
				javaAccessibleObject.getDeclaredAnnotations(),
				JavaFactory.getInstance().getAnnotationBuilder()
			);
	}

}
