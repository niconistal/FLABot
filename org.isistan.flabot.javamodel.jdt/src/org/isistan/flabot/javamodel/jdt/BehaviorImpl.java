/** * $Id: BehaviorImpl.java,v 1.10 2006/07/18 01:50:33 mblech Exp $ * $Author: mblech $ */package org.isistan.flabot.javamodel.jdt;

import java.lang.ref.WeakReference;import org.eclipse.jdt.core.ElementChangedEvent;import org.eclipse.jdt.core.IJavaElement;import org.eclipse.jdt.core.IJavaElementDelta;import org.eclipse.jdt.core.IMethod;import org.eclipse.jdt.core.JavaModelException;import org.eclipse.jdt.core.Signature;import org.eclipse.jdt.core.dom.IMethodBinding;import org.eclipse.jdt.core.dom.ITypeBinding;import org.isistan.flabot.javamodel.InternalModelException;import org.isistan.flabot.javamodel.JAnnotation;import org.isistan.flabot.javamodel.JArray;import org.isistan.flabot.javamodel.JBehavior;import org.isistan.flabot.javamodel.JClass;import org.isistan.flabot.javamodel.JType;import org.isistan.flabot.javamodel.JTypeVariable;import org.isistan.flabot.javamodel.MixedImplementationsException;import org.isistan.flabot.javamodel.NotSupportedFeatureException;import org.isistan.flabot.javamodel.Util;import org.isistan.flabot.javamodel.jdt.workspace.JWorkspaceClass;public abstract class BehaviorImpl extends MemberImpl implements JBehavior, JNotificableElement {
	private static final int BEHAVIOR_CHANGE_FLAG=0;
	private IMethod jdtBehavior;
	
	IMethod getJDTBehavior() {
		return jdtBehavior;
	}
	
	static IMethod getJDTBehavior(JBehavior jBehavior) {
		if(jBehavior instanceof BehaviorImpl) {
			return ((BehaviorImpl)jBehavior).getJDTBehavior();
		} else {
			throw new MixedImplementationsException(jBehavior);
		} 
	}
	
	BehaviorImpl(IMethod jdtBehavior) {
		super(jdtBehavior);
		this.jdtBehavior=jdtBehavior;		JavaModelListener.getInstance().add(this, BEHAVIOR_CHANGE_FLAG, jdtBehavior, IJavaElementDelta.CHANGED);	}		public void changed(int flag, IJavaElement javaElement, int eventFlags, ElementChangedEvent event) {		if(flag==BEHAVIOR_CHANGE_FLAG) {			parameterTypes=null;		}			}
	private JArray<? extends JWorkspaceClass> parameterTypes=null;
	public JArray<? extends JWorkspaceClass> getParameterTypes() {		if(parameterTypes==null) {			if(!jdtBehavior.isBinary()) {				ITypeBinding[] typeBindings=getBinding().getParameterTypes();				Object[] types=new Object[typeBindings.length];				for (int i = 0; i < types.length; i++) {					types[i]=WorkspaceClassBuilder.getBuildableObjectFromBinding(typeBindings[i],							jdtBehavior.getJavaProject());				}				parameterTypes=JDTFactory.getInstance().buildArray(types,						JDTFactory.getInstance().getClassBuilder());			} else {				try {					String[] parameterTypeNames=jdtBehavior.getParameterTypes();					Object[] types=new Object[parameterTypeNames.length];					for (int i = 0; i < types.length; i++) {						//TODO: Generic types not supported!!!!						/*if (parameterTypeNames[i].indexOf(Signature.C_GENERIC_START) > 0 ||								parameterTypeNames[i].indexOf("TE;")>=0) 						{							parameterTypeNames = new String[] {};							types = new Object[] {};							break;						}*/												types[i]=JavaModelJDTUtil.findType(jdtBehavior.getJavaProject(), Util.getName(parameterTypeNames[i]));					}					parameterTypes=JDTFactory.getInstance().buildArray(types,							JDTFactory.getInstance().getClassBuilder());				} catch (JavaModelException e) {					throw new InternalModelException(e);				} catch (UnresolvedTypeException e) {					throw new InternalModelException(e);				}			}		}		return parameterTypes;	}
		private WeakReference<IMethodBinding> bindingRef= null;	IMethodBinding getBinding() {		IMethodBinding binding=null;		if(bindingRef!=null) {			binding=bindingRef.get();		}		if(binding==null) {			String behaviorKey=jdtBehavior.getHandleIdentifier();			ITypeBinding classBinding=((WorkspaceClassImpl) getDeclaringClass()).getBinding();			IMethodBinding[] bindingBehaviors = classBinding.getDeclaredMethods();			for (IMethodBinding bindingBehavior : bindingBehaviors) {				IJavaElement javaElement=bindingBehavior.getJavaElement();				if(javaElement!=null && javaElement.getHandleIdentifier().equals(behaviorKey)) {					binding=bindingBehavior;					bindingRef = new WeakReference<IMethodBinding>(binding);					break;				}			}		}		return binding;			}
	public JArray<? extends JType> getGenericParameterTypes() {
		throw new NotSupportedFeatureException();
	}

	public JArray<? extends JWorkspaceClass> getExceptionTypes() {
		throw new NotSupportedFeatureException();
	}

	public JArray<? extends JType> getGenericExceptionTypes() {
		throw new NotSupportedFeatureException();
	}

	public String toGenericString() {
		throw new NotSupportedFeatureException();
	}

	public boolean isVarArgs() {
		throw new NotSupportedFeatureException();
	}

	public JArray<? extends JAnnotation> getParameterAnnotations() {
		throw new NotSupportedFeatureException();
	}

	public void setAccessible(boolean flag) throws SecurityException {
		throw new NotSupportedFeatureException();
	}

	public boolean isAccessible() {
		throw new NotSupportedFeatureException();
	}

	public boolean isAnnotationPresent(JClass annotationType) {
		throw new NotSupportedFeatureException();
	}

	public JAnnotation getAnnotation(JClass annotationType) {
		throw new NotSupportedFeatureException();
	}

	public JArray<? extends JAnnotation> getAnnotations() {
		throw new NotSupportedFeatureException();
	}

	public JArray<? extends JAnnotation> getDeclaredAnnotations() {
		throw new NotSupportedFeatureException();
	}

	public JArray<? extends JTypeVariable> getTypeParameters() {
		throw new NotSupportedFeatureException();
	}

	private String signature=null;	public String getSignature() {		if(signature==null) {			if(jdtBehavior.isBinary()) {				try {					String jniSignature=jdtBehavior.getSignature();					String[] types=Signature.getParameterTypes(jniSignature);					for (int i = 0; i < types.length; i++) {						types[i]=Util.getName(types[i]);					}					String returnType=null;					if(!jdtBehavior.isConstructor()) {						returnType=Util.getName(Signature.getReturnType(jniSignature));					}					signature=Util.getSignature(types, returnType);				} catch (JavaModelException e) {					throw new InternalModelException(e);				}			} else {				signature=Util.getSignature(this);			}		}		return signature;	}	private String jniSignature=null;	public String getJNISignature() {		if(jniSignature==null) {			if(jdtBehavior.isBinary()) {				try {					jniSignature=jdtBehavior.getSignature();				} catch (JavaModelException e) {					throw new InternalModelException(e);				}			} else {				jniSignature=Util.getJNISignature(this);			}		} 		return jniSignature;	}		private String descriptor=null;	public String getDescriptor() {		if(descriptor==null) {			descriptor=Util.getBehaviorDescriptor(this);		}		return descriptor;	}

}
