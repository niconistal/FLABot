/** * $Id: MemberImpl.java,v 1.5 2006/03/20 23:43:43 dacostae Exp $ * $Author: dacostae $ */package org.isistan.flabot.javamodel.jdt;

import java.lang.reflect.Modifier;import org.eclipse.jdt.core.Flags;import org.eclipse.jdt.core.IMember;import org.eclipse.jdt.core.ISourceRange;import org.eclipse.jdt.core.JavaModelException;import org.isistan.flabot.javamodel.InternalModelException;import org.isistan.flabot.javamodel.JMember;import org.isistan.flabot.javamodel.JSourceLocation;import org.isistan.flabot.javamodel.MixedImplementationsException;import org.isistan.flabot.javamodel.jdt.workspace.JWorkspaceClass;import org.isistan.flabot.javamodel.jdt.workspace.JWorkspaceElement;public abstract class MemberImpl extends ObjectImpl implements JMember, JWorkspaceElement {

	private IMember jdtMember;
	
	IMember getJDTMember() {
		return jdtMember;
	}
	
	static IMember getJDTMember(JMember jMember) {
		if(jMember instanceof MemberImpl) {
			return ((MemberImpl)jMember).getJDTMember();
		} else {
			throw new MixedImplementationsException(jMember);
		} 
	}
	
	MemberImpl(IMember jdtMember) {
		super(jdtMember);
		this.jdtMember=jdtMember;
	}

	public JWorkspaceClass getDeclaringClass() {
		return JDTFactory.getInstance().buildClass(jdtMember.getDeclaringType());
	}

	public int getModifiers() {
		try {
			int flags=jdtMember.getFlags();
			int modifiers=0;
			if(Flags.isAbstract(flags))
				modifiers=modifiers | Modifier.ABSTRACT;
			if(Flags.isFinal(flags))
				modifiers=modifiers | Modifier.FINAL;
			if(Flags.isInterface(flags))
				modifiers=modifiers | Modifier.INTERFACE;
			if(Flags.isNative(flags))
				modifiers=modifiers | Modifier.NATIVE;
			if(Flags.isPrivate(flags))
				modifiers=modifiers | Modifier.PRIVATE;
			if(Flags.isProtected(flags))
				modifiers=modifiers | Modifier.PROTECTED;
			if(Flags.isPublic(flags) || jdtMember.getDeclaringType().isInterface())
				modifiers=modifiers | Modifier.PUBLIC;
			if(Flags.isStatic(flags))
				modifiers=modifiers | Modifier.STATIC;
			if(Flags.isStrictfp(flags))
				modifiers=modifiers | Modifier.STRICT;
			if(Flags.isSynchronized(flags))
				modifiers=modifiers | Modifier.SYNCHRONIZED;
			if(Flags.isTransient(flags))
				modifiers=modifiers | Modifier.TRANSIENT;
			if(Flags.isVolatile(flags))
				modifiers=modifiers | Modifier.VOLATILE;
			return modifiers;
		} catch (JavaModelException e) {
			throw new InternalModelException(e);
		}
	}

	public boolean isSynthetic() {
		try {
			return Flags.isSynthetic(jdtMember.getFlags());
		} catch (JavaModelException e) {
			throw new InternalModelException(e);
		}
	}

	public String getName() {
		return jdtMember.getElementName();
	}		public abstract JWorkspaceClass getType();		public JSourceLocation getSourceLocation() {		try {			ISourceRange sourceRange=jdtMember.getSourceRange();			return new JSourceLocation(sourceRange.getOffset(), sourceRange.getLength());		} catch (JavaModelException e) {			throw new InternalModelException(e);		}	}
}
