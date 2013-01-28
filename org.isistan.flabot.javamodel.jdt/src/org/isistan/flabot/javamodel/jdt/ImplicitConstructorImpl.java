/** * $Id: ImplicitConstructorImpl.java,v 1.2 2006/03/24 00:33:59 dacostae Exp $ * $Author: dacostae $ */package org.isistan.flabot.javamodel.jdt;

import java.lang.reflect.InvocationTargetException;import java.lang.reflect.Modifier;import org.isistan.flabot.javamodel.JAnnotation;import org.isistan.flabot.javamodel.JArray;import org.isistan.flabot.javamodel.JClass;import org.isistan.flabot.javamodel.JConstructor;import org.isistan.flabot.javamodel.JObject;import org.isistan.flabot.javamodel.JSourceLocation;import org.isistan.flabot.javamodel.JType;import org.isistan.flabot.javamodel.JTypeVariable;import org.isistan.flabot.javamodel.MixedImplementationsException;import org.isistan.flabot.javamodel.NotSupportedFeatureException;import org.isistan.flabot.javamodel.Util;import org.isistan.flabot.javamodel.jdt.workspace.JWorkspaceClass;public class ImplicitConstructorImpl extends ObjectImpl implements JConstructor {
	private static Object[] EMPTY_ARRAY=new Object[0];		static class JDTImplicitConstructor {		private JWorkspaceClass declaringClass;		public JDTImplicitConstructor(JWorkspaceClass declaringClass) {			this.declaringClass=declaringClass;		}	}	
	private JDTImplicitConstructor jdtImplicitConstructor;
	
	JDTImplicitConstructor getJDTImplicitConstructor() {
		return jdtImplicitConstructor;
	}
	
	static JDTImplicitConstructor getJDTImplicitConstructor(JConstructor jConstructor) {
		if(jConstructor instanceof ImplicitConstructorImpl) {
			return ((ImplicitConstructorImpl)jConstructor).getJDTImplicitConstructor();
		} else {
			throw new MixedImplementationsException(jConstructor);
		} 
	}
	
	ImplicitConstructorImpl(JDTImplicitConstructor jdtImplicitConstructor) {
		super(jdtImplicitConstructor);
		this.jdtImplicitConstructor=jdtImplicitConstructor;
	}
		public String getName() {
		return JConstructor.BEHAVIOR_NAME;
	}
	
	public JObject newInstance(JArray<? extends JObject> arguments) {
		throw new NotSupportedFeatureException();
	}	public JWorkspaceClass getType() {		return this.getDeclaringClass();	}	public JArray<? extends JClass> getParameterTypes() {		return JDTFactory.getInstance().buildArray(EMPTY_ARRAY,				JDTFactory.getInstance().getClassBuilder());	}	public JArray<? extends JType> getGenericParameterTypes() {		throw new NotSupportedFeatureException();	}	public JArray<? extends JClass> getExceptionTypes() {		throw new NotSupportedFeatureException();	}	public JArray<? extends JType> getGenericExceptionTypes() {		throw new NotSupportedFeatureException();	}	public String toGenericString() {		throw new NotSupportedFeatureException();	}	public boolean isVarArgs() {		throw new NotSupportedFeatureException();	}	public JArray<? extends JAnnotation> getParameterAnnotations() {		throw new NotSupportedFeatureException();	}	public String getSignature() {		return "" + Util.ARGUMENTS_INITIATOR + Util.ARGUMENTS_TERMINATOR;	}	public String getJNISignature() {		return "" + Util.ARGUMENTS_INITIATOR + Util.ARGUMENTS_TERMINATOR + Util.VOID_JNI_NAME;	}	public void setAccessible(boolean flag) {		throw new NotSupportedFeatureException();	}	public boolean isAccessible() {		throw new NotSupportedFeatureException();	}	public boolean isAnnotationPresent(JClass annotationType) {		throw new NotSupportedFeatureException();	}	public JAnnotation getAnnotation(JClass annotationType) {		throw new NotSupportedFeatureException();	}	public JArray<? extends JAnnotation> getAnnotations() {		throw new NotSupportedFeatureException();	}	public JArray<? extends JAnnotation> getDeclaredAnnotations() {		throw new NotSupportedFeatureException();	}	public JArray<? extends JTypeVariable> getTypeParameters() {		throw new NotSupportedFeatureException();	}	public JWorkspaceClass getDeclaringClass() {		return jdtImplicitConstructor.declaringClass;	}	public int getModifiers() {		return Modifier.PUBLIC;	}	public boolean isSynthetic() {		return false;	}	public String getDescriptor() {		return Util.getBehaviorDescriptor(this);	}		public JSourceLocation getSourceLocation() {		return JSourceLocation.UNKNOWN;	}
}
