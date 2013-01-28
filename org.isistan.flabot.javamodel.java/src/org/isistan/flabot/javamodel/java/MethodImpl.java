/** * $Id: MethodImpl.java,v 1.6 2006/03/24 00:33:55 dacostae Exp $ * $Author: dacostae $ */package org.isistan.flabot.javamodel.java;

import java.lang.reflect.InvocationTargetException;import java.lang.reflect.Method;import org.isistan.flabot.javamodel.InternalModelException;import org.isistan.flabot.javamodel.JAnnotation;import org.isistan.flabot.javamodel.JArray;import org.isistan.flabot.javamodel.JClass;import org.isistan.flabot.javamodel.JMethod;import org.isistan.flabot.javamodel.JObject;import org.isistan.flabot.javamodel.JType;import org.isistan.flabot.javamodel.JTypeVariable;import org.isistan.flabot.javamodel.MixedImplementationsException;public class MethodImpl extends BehaviorImpl implements JMethod {

	private Method javaMethod;
	
	Method getJavaMethod() {
		return javaMethod;
	}
	
	static Method getJavaMethod(JMethod jMethod) {
		if(jMethod instanceof MethodImpl) {
			return ((MethodImpl)jMethod).getJavaMethod();
		} else {
			throw new MixedImplementationsException(jMethod);
		} 
	}
	
	MethodImpl(Method javaMethod) {
		super(javaMethod);
		this.javaMethod=javaMethod;
	}


	public JArray<? extends JClass> getParameterTypes() {
		return JavaFactory.getInstance().buildArray(
				javaMethod.getParameterTypes(),
				JavaFactory.getInstance().getClassBuilder()
			);	
	}

	public JArray<? extends JType> getGenericParameterTypes() {
		return JavaFactory.getInstance().buildArray(
				javaMethod.getGenericParameterTypes(),
				JavaFactory.getInstance().getTypeBuilder()
			);	
	}

	public JArray<? extends JClass> getExceptionTypes() {
		return JavaFactory.getInstance().buildArray(
				javaMethod.getExceptionTypes(), 
				JavaFactory.getInstance().getClassBuilder()
			);	
	}

	public JArray<? extends JType> getGenericExceptionTypes() {
		return JavaFactory.getInstance().buildArray(
				javaMethod.getGenericExceptionTypes(), 
				JavaFactory.getInstance().getTypeBuilder()
			);	
	}

	public String toGenericString() {
		return javaMethod.toGenericString();
	}

	public boolean isVarArgs() {
		return javaMethod.isVarArgs();
	}

	public JArray<? extends JAnnotation>/*2 dimensions*/ getParameterAnnotations() {
		return JavaFactory.getInstance().buildArray(
				javaMethod.getParameterAnnotations(), 
				JavaFactory.getInstance().getAnnotationBuilder()
			);	
	}

	public void setAccessible(boolean flag) throws SecurityException {
		javaMethod.setAccessible(flag);
	}

	public boolean isAccessible() {
		return javaMethod.isAccessible();
	}

	public boolean isAnnotationPresent(JClass annotationType) {
		return javaMethod.isAccessible();
	}

	public JAnnotation getAnnotation(JClass annotationType) {
		return JavaFactory.getInstance().buildAnnotation(javaMethod.getAnnotation(ClassImpl.getJavaClass(annotationType)));
	}

	public JArray<? extends JAnnotation> getAnnotations() {
		return JavaFactory.getInstance().buildArray(
				javaMethod.getAnnotations(),
				JavaFactory.getInstance().getAnnotationBuilder()
			);	
	}

	public JArray<? extends JAnnotation> getDeclaredAnnotations() {
		return JavaFactory.getInstance().buildArray(
				javaMethod.getDeclaredAnnotations(), 
				JavaFactory.getInstance().getAnnotationBuilder()
			);	
	}

	public JArray<? extends JTypeVariable> getTypeParameters() {
		return JavaFactory.getInstance().buildArray(
				javaMethod.getTypeParameters(), 
				JavaFactory.getInstance().getTypeVariableBuilder()
			);	
	}

	public JClass getType() {
		return JavaFactory.getInstance().buildClass(javaMethod.getReturnType());
	}

	public JType getGenericReturnType() {
		return JavaFactory.getInstance().buildType(javaMethod.getGenericReturnType());
	}

	public JObject invoke(JObject object, JArray<? extends JObject> arguments) {
		Object[] javaArguments=new Object[arguments.length()];
		for(int i=0; i<arguments.length(); i++) {
			javaArguments[i]=ObjectImpl.getJavaObject(arguments.at(i));
		}
		Object javaObject=ObjectImpl.getJavaObject(object);
		try {			return JavaFactory.getInstance().buildObject(
					javaMethod.invoke(javaObject, javaArguments)
				);		} catch (IllegalArgumentException e) {			throw new InternalModelException(e);		} catch (IllegalAccessException e) {			throw new InternalModelException(e);		} catch (InvocationTargetException e) {			throw new InternalModelException(e);		}
	}

	public boolean isBridge() {
		return javaMethod.isBridge();
	}

	public JObject getDefaultValue() {
		return JavaFactory.getInstance().buildObject(javaMethod.getDefaultValue());
	}
}
