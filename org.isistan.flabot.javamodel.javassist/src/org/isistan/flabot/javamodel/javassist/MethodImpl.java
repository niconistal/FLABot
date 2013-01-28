/** * $Id: MethodImpl.java,v 1.5 2006/03/24 00:34:01 dacostae Exp $ * $Author: dacostae $ */package org.isistan.flabot.javamodel.javassist;

import java.lang.reflect.InvocationTargetException;import javassist.CtMethod;import javassist.NotFoundException;import org.isistan.flabot.javamodel.InternalModelException;import org.isistan.flabot.javamodel.JArray;import org.isistan.flabot.javamodel.JClass;import org.isistan.flabot.javamodel.JMethod;import org.isistan.flabot.javamodel.JObject;import org.isistan.flabot.javamodel.JType;import org.isistan.flabot.javamodel.MixedImplementationsException;import org.isistan.flabot.javamodel.NotSupportedFeatureException;public class MethodImpl extends BehaviorImpl implements JMethod {

	private CtMethod javassistMethod;
	
	CtMethod getJavassistMethod() {
		return javassistMethod;
	}
	
	static CtMethod getJavassistMethod(JMethod jMethod) {
		if(jMethod instanceof MethodImpl) {
			return ((MethodImpl)jMethod).getJavassistMethod();
		} else {
			throw new MixedImplementationsException(jMethod);
		} 
	}
	
	MethodImpl(CtMethod javassistMethod) {
		super(javassistMethod);
		this.javassistMethod=javassistMethod;
	}


	public JClass getType() {
		try {
			return JavassistFactory.getInstance().buildClass(javassistMethod.getReturnType());
		} catch (NotFoundException e) {
			throw new InternalModelException(e);
		}
	}

	public JType getGenericReturnType() {
		throw new NotSupportedFeatureException();
	}

	public JObject invoke(JObject object, JArray<? extends JObject> arguments) {
		throw new NotSupportedFeatureException();
	}

	public boolean isBridge() {
		throw new NotSupportedFeatureException();
	}

	public JObject getDefaultValue() {
		throw new NotSupportedFeatureException();
	}
}
