/** * $Id: BehaviorImpl.java,v 1.4 2006/03/18 00:25:06 dacostae Exp $ * $Author: dacostae $ */package org.isistan.flabot.javamodel.java;

import java.lang.reflect.Member;import org.isistan.flabot.javamodel.JBehavior;import org.isistan.flabot.javamodel.MixedImplementationsException;import org.isistan.flabot.javamodel.Util;public abstract class BehaviorImpl extends MemberImpl implements JBehavior {

	private Member javaBehavior;
	
	Member getJavaBehavior() {
		return javaBehavior;
	}
	
	static Member getJavaMember(JBehavior jBehavior) {
		if(jBehavior instanceof BehaviorImpl) {
			return ((BehaviorImpl)jBehavior).getJavaBehavior();
		} else {
			throw new MixedImplementationsException(jBehavior);
		} 
	}
	
	BehaviorImpl(Member javaBehavior) {
		super(javaBehavior);
		this.javaBehavior=javaBehavior;
	}
	private String descriptor=null;	public String getDescriptor() {		if(descriptor==null) {			descriptor=Util.getBehaviorDescriptor(this);		}		return descriptor;	}		private String signature=null;	public String getSignature() {		if(signature==null) {			signature=Util.getSignature(this);		}		return signature;	}	private String jniSignature=null;	public String getJNISignature() {		if(jniSignature==null) {			jniSignature=Util.getJNISignature(this);		} 		return jniSignature;	}
}
