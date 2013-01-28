/** * $Id: MemberImpl.java,v 1.4 2006/03/18 00:25:06 dacostae Exp $ * $Author: dacostae $ */package org.isistan.flabot.javamodel.java;

import java.lang.reflect.Member;import org.isistan.flabot.javamodel.JClass;import org.isistan.flabot.javamodel.JMember;import org.isistan.flabot.javamodel.JSourceLocation;import org.isistan.flabot.javamodel.MixedImplementationsException;import org.isistan.flabot.javamodel.NotSupportedFeatureException;public abstract class MemberImpl extends ObjectImpl implements JMember {

	private Member javaMember;
	
	Member getJavaMember() {
		return javaMember;
	}
	
	static Member getJavaMember(JMember jMember) {
		if(jMember instanceof MemberImpl) {
			return ((MemberImpl)jMember).getJavaMember();
		} else {
			throw new MixedImplementationsException(jMember);
		} 
	}
	
	MemberImpl(Member javaMember) {
		super(javaMember);
		this.javaMember=javaMember;
	}

	public JClass getDeclaringClass() {
		return JavaFactory.getInstance().buildClass(javaMember.getDeclaringClass());
	}

	public String getName() {
		return javaMember.getName();
	}

	public int getModifiers() {
		return javaMember.getModifiers();
	}

	public boolean isSynthetic() {
		return javaMember.isSynthetic();
	}		public JSourceLocation getSourceLocation() {		throw new NotSupportedFeatureException();	}

}
