/** * $Id: ConstructorImpl.java,v 1.8 2006/03/24 00:33:59 dacostae Exp $ * $Author: dacostae $ */package org.isistan.flabot.javamodel.jdt;

import java.lang.reflect.InvocationTargetException;import org.eclipse.jdt.core.ElementChangedEvent;import org.eclipse.jdt.core.IJavaElement;import org.eclipse.jdt.core.IMethod;import org.isistan.flabot.javamodel.JArray;import org.isistan.flabot.javamodel.JConstructor;import org.isistan.flabot.javamodel.JObject;import org.isistan.flabot.javamodel.MixedImplementationsException;import org.isistan.flabot.javamodel.NotSupportedFeatureException;import org.isistan.flabot.javamodel.jdt.workspace.JWorkspaceClass;public class ConstructorImpl extends BehaviorImpl implements JConstructor {

	private IMethod jdtConstructor;
	
	IMethod getJDTConstructor() {
		return jdtConstructor;
	}
	
	static IMethod getJDTConstructor(JConstructor jConstructor) {
		if(jConstructor instanceof ConstructorImpl) {
			return ((ConstructorImpl)jConstructor).getJDTConstructor();
		} else {
			throw new MixedImplementationsException(jConstructor);
		} 
	}
	
	ConstructorImpl(IMethod jdtConstructor) {
		super(jdtConstructor);
		this.jdtConstructor=jdtConstructor;
	}
	
	@Override	public String getName() {
		return JConstructor.BEHAVIOR_NAME;
	}
	
	public JObject newInstance(JArray<? extends JObject> arguments) {
	
		throw new NotSupportedFeatureException();
	}	@Override	public JWorkspaceClass getType() {		return this.getDeclaringClass();	}
}
