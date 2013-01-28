/** * $Id: FieldImpl.java,v 1.6 2006/03/24 00:33:55 dacostae Exp $ * $Author: dacostae $ */package org.isistan.flabot.javamodel.java;

import java.lang.reflect.Field;import org.isistan.flabot.javamodel.InternalModelException;import org.isistan.flabot.javamodel.JAnnotation;import org.isistan.flabot.javamodel.JArray;import org.isistan.flabot.javamodel.JClass;import org.isistan.flabot.javamodel.JField;import org.isistan.flabot.javamodel.JObject;import org.isistan.flabot.javamodel.JType;import org.isistan.flabot.javamodel.MixedImplementationsException;import org.isistan.flabot.javamodel.Util;public class FieldImpl extends MemberImpl implements JField {

	private Field javaField;
	
	Field getJavaField() {
		return javaField;
	}
	
	static Field getJavaField(JField jField) {
		if(jField instanceof FieldImpl) {
			return ((FieldImpl)jField).getJavaField();
		} else {
			throw new MixedImplementationsException(jField);
		} 
	}
	
	FieldImpl(Field javaField) {
		super(javaField);
		this.javaField=javaField;
	}
	
	public void setAccessible(boolean flag) throws SecurityException {
		javaField.setAccessible(flag);
	}

	public boolean isAccessible() {
		return javaField.isAccessible();
	}

	public boolean isAnnotationPresent(JClass annotationType) {
		return javaField.isAnnotationPresent(ClassImpl.getJavaClass(annotationType));
	}

	public JAnnotation getAnnotation(JClass annotationType) {
		return JavaFactory.getInstance().buildAnnotation(javaField.getAnnotation(ClassImpl.getJavaClass(annotationType)));
	}

	public JArray<? extends JAnnotation> getAnnotations() {
		return JavaFactory.getInstance().buildArray(
				javaField.getAnnotations(), 
				JavaFactory.getInstance().getAnnotationBuilder()
			);	
	}

	public JArray<? extends JAnnotation> getDeclaredAnnotations() {
		return JavaFactory.getInstance().buildArray(
				javaField.getDeclaredAnnotations(),
				JavaFactory.getInstance().getAnnotationBuilder()
			);	
	}

	public boolean isEnumConstant() {
		return javaField.isEnumConstant();
	}

	public JClass getType() {
		return JavaFactory.getInstance().buildClass(javaField.getType());
	}

	public JType getGenericType() {
		return JavaFactory.getInstance().buildType(javaField.getGenericType());
	}

	public String toGenericString() {
		return javaField.toGenericString();
	}

	public JObject get(JObject obj) {
		try {			Class type=javaField.getType();			Object value=javaField.get(ObjectImpl.getJavaObject(obj));			if(!type.isPrimitive()) {				return JavaFactory.getInstance().buildObject(value);			} else {				return JavaFactory.getInstance().buildPrimitive(value);			}		} catch (IllegalArgumentException e) {			throw new InternalModelException(e);		} catch (IllegalAccessException e) {			throw new InternalModelException(e);		}
	}

	public void set(JObject obj, JObject value) {
		try {			javaField.set(ObjectImpl.getJavaObject(obj), ObjectImpl.getJavaObject(value));		} catch (IllegalArgumentException e) {			throw new InternalModelException(e);		} catch (IllegalAccessException e) {			throw new InternalModelException(e);		}
	}	public String getDescriptor() {		return Util.getFieldDescriptor(this);	}

}
