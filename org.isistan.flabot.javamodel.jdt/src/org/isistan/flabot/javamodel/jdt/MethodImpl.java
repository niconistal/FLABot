/** * $Id: MethodImpl.java,v 1.8 2006/05/09 00:50:16 dacostae Exp $ * $Author: dacostae $ */package org.isistan.flabot.javamodel.jdt;

import java.lang.reflect.InvocationTargetException;import org.eclipse.jdt.core.IMethod;import org.isistan.flabot.javamodel.JArray;import org.isistan.flabot.javamodel.JMethod;import org.isistan.flabot.javamodel.JObject;import org.isistan.flabot.javamodel.JType;import org.isistan.flabot.javamodel.MixedImplementationsException;import org.isistan.flabot.javamodel.NotSupportedFeatureException;import org.isistan.flabot.javamodel.jdt.workspace.JWorkspaceClass;public class MethodImpl extends BehaviorImpl implements JMethod {
	private IMethod jdtMethod;
	
	IMethod getJDTMethod() {
		return jdtMethod;
	}
	
	static IMethod getJDTMethod(JMethod jMethod) {
		if(jMethod instanceof MethodImpl) {
			return ((MethodImpl)jMethod).getJDTMethod();
		} else {
			throw new MixedImplementationsException(jMethod);
		} 
	}
	
	MethodImpl(IMethod jdtMethod) {
		super(jdtMethod);
		this.jdtMethod=jdtMethod;
	}
	@Override	public JWorkspaceClass getType() {		return JDTFactory.getInstance().buildClass(					WorkspaceClassBuilder.getBuildableObjectFromBinding(							getBinding().getReturnType(), jdtMethod.getJavaProject()));	}	
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
