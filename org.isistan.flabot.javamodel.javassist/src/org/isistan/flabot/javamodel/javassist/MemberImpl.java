/** * $Id: MemberImpl.java,v 1.4 2006/03/18 00:25:03 dacostae Exp $ * $Author: dacostae $ */package org.isistan.flabot.javamodel.javassist;

import javassist.CtMember;import org.isistan.flabot.javamodel.JClass;import org.isistan.flabot.javamodel.JMember;import org.isistan.flabot.javamodel.JSourceLocation;import org.isistan.flabot.javamodel.MixedImplementationsException;import org.isistan.flabot.javamodel.NotSupportedFeatureException;public abstract class MemberImpl extends ObjectImpl implements JMember {

	private CtMember javassistMember;
	
	CtMember getJavassistMember() {
		return javassistMember;
	}
	
	static CtMember getJavassistMember(JMember jMember) {
		if(jMember instanceof MemberImpl) {
			return ((MemberImpl)jMember).getJavassistMember();
		} else {
			throw new MixedImplementationsException(jMember);
		} 
	}
	
	MemberImpl(CtMember javassistMember) {
		super(javassistMember);
		this.javassistMember=javassistMember;
	}

	public JClass getDeclaringClass() {
		return JavassistFactory.getInstance().buildClass(javassistMember.getDeclaringClass());
	}

	public String getName() {
		return javassistMember.getName();
	}

	public int getModifiers() {
		return javassistMember.getModifiers();
	}

	public boolean isSynthetic() {
		throw new NotSupportedFeatureException();
	}		public JSourceLocation getSourceLocation() {		throw new NotSupportedFeatureException();	}
}
