/** * $Id: ConstructorImpl.java,v 1.7 2006/03/24 00:34:01 dacostae Exp $ * $Author: dacostae $ */package org.isistan.flabot.javamodel.javassist;

import java.lang.reflect.InvocationTargetException;import javassist.CtConstructor;import org.isistan.flabot.javamodel.JArray;import org.isistan.flabot.javamodel.JClass;import org.isistan.flabot.javamodel.JConstructor;import org.isistan.flabot.javamodel.JObject;import org.isistan.flabot.javamodel.MixedImplementationsException;import org.isistan.flabot.javamodel.NotSupportedFeatureException;public class ConstructorImpl extends BehaviorImpl implements JConstructor {

	private CtConstructor javassistConstructor;
	
	CtConstructor getJavassistConstructor() {
		return javassistConstructor;
	}
	
	static CtConstructor getJavassistConstructor(JConstructor jConstructor) {
		if(jConstructor instanceof ConstructorImpl) {
			return ((ConstructorImpl)jConstructor).getJavassistConstructor();
		} else {
			throw new MixedImplementationsException(jConstructor);
		} 
	}
	
	ConstructorImpl(CtConstructor javassistConstructor) {
		super(javassistConstructor);
		this.javassistConstructor=javassistConstructor;
	}
	
	@Override	public String getName() {
		return JConstructor.BEHAVIOR_NAME;
	}
	
	public JObject newInstance(JArray<? extends JObject> arguments) {
		throw new NotSupportedFeatureException();
	}	public JClass getType() {		return this.getDeclaringClass();	}
}
