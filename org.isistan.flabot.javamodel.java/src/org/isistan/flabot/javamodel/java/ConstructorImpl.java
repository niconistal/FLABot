/** * $Id: ConstructorImpl.java,v 1.7 2006/03/24 00:33:55 dacostae Exp $ * $Author: dacostae $ */package org.isistan.flabot.javamodel.java;

import java.lang.reflect.Constructor;import java.lang.reflect.InvocationTargetException;import org.isistan.flabot.javamodel.InternalModelException;import org.isistan.flabot.javamodel.JAnnotation;import org.isistan.flabot.javamodel.JArray;import org.isistan.flabot.javamodel.JClass;import org.isistan.flabot.javamodel.JConstructor;import org.isistan.flabot.javamodel.JObject;import org.isistan.flabot.javamodel.JType;import org.isistan.flabot.javamodel.JTypeVariable;import org.isistan.flabot.javamodel.MixedImplementationsException;public class ConstructorImpl extends BehaviorImpl implements JConstructor {

	private Constructor javaConstructor;
	
	Constructor getJavaConstructor() {
		return javaConstructor;
	}
	
	static Constructor getJavaConstructor(JConstructor jConstructor) {
		if(jConstructor instanceof ConstructorImpl) {
			return ((ConstructorImpl)jConstructor).getJavaConstructor();
		} else {
			throw new MixedImplementationsException(jConstructor);
		} 
	}
	
	ConstructorImpl(Constructor javaConstructor) {
		super(javaConstructor);
		this.javaConstructor=javaConstructor;
	}
	
	@Override	public String getName() {
		return JConstructor.BEHAVIOR_NAME;
	}
	
	public JObject newInstance(JArray<? extends JObject> arguments) {
		Object[] javaArguments=new Object[arguments.length()];
		for(int i=0; i<arguments.length(); i++) {
			javaArguments[i]=ObjectImpl.getJavaObject(arguments.at(i));
		}
		try {			return JavaFactory.getInstance().buildObject(javaConstructor.newInstance(javaArguments));		} catch (IllegalArgumentException e) {			throw new InternalModelException(e);		} catch (InstantiationException e) {			throw new InternalModelException(e);		} catch (IllegalAccessException e) {			throw new InternalModelException(e);		} catch (InvocationTargetException e) {			throw new InternalModelException(e);		}
	}

	public JArray<? extends JClass> getParameterTypes() {
		return JavaFactory.getInstance().buildArray(
				javaConstructor.getParameterTypes(), 
				JavaFactory.getInstance().getClassBuilder()
			);	
	}

	public JArray<? extends JType> getGenericParameterTypes() {
		return JavaFactory.getInstance().buildArray(
				javaConstructor.getGenericParameterTypes(),
				JavaFactory.getInstance().getTypeBuilder()
			);	
	}

	public JArray<? extends JClass> getExceptionTypes() {
		return JavaFactory.getInstance().buildArray(
				javaConstructor.getExceptionTypes(),
				JavaFactory.getInstance().getClassBuilder()
			);	
	}

	public JArray<? extends JType> getGenericExceptionTypes() {
		return JavaFactory.getInstance().buildArray(
				javaConstructor.getGenericExceptionTypes(),
				JavaFactory.getInstance().getTypeBuilder()
			);	
	}

	public String toGenericString() {
		return javaConstructor.toGenericString();
	}

	public boolean isVarArgs() {
		return javaConstructor.isVarArgs();
	}

	public JArray<? extends JAnnotation>/*2 dimensions*/ getParameterAnnotations() {
		return JavaFactory.getInstance().buildArray(
				javaConstructor.getParameterAnnotations(), 
				JavaFactory.getInstance().getAnnotationBuilder()
			);	
	}

	public void setAccessible(boolean flag) throws SecurityException {
		javaConstructor.setAccessible(flag);
	}

	public boolean isAccessible() {
		return javaConstructor.isAccessible();
	}

	public boolean isAnnotationPresent(JClass annotationType) {
		return javaConstructor.isAnnotationPresent(ClassImpl.getJavaClass(annotationType));
	}

	public JAnnotation getAnnotation(JClass annotationType) {
		return JavaFactory.getInstance().buildAnnotation(javaConstructor.getAnnotation(ClassImpl.getJavaClass(annotationType)));
	}

	public JArray<? extends JAnnotation> getAnnotations() {
		return JavaFactory.getInstance().buildArray(
				javaConstructor.getAnnotations(),
				JavaFactory.getInstance().getAnnotationBuilder()
			);	
	}

	public JArray<? extends JAnnotation> getDeclaredAnnotations() {
		return JavaFactory.getInstance().buildArray(
				javaConstructor.getDeclaredAnnotations(),
				JavaFactory.getInstance().getAnnotationBuilder()
			);	
	}

	public JArray<? extends JTypeVariable> getTypeParameters() {
		return JavaFactory.getInstance().buildArray(
				javaConstructor.getTypeParameters(), 
				JavaFactory.getInstance().getTypeVariableBuilder()
			);	
	}

	public JClass getType() {		return this.getDeclaringClass();	}}
