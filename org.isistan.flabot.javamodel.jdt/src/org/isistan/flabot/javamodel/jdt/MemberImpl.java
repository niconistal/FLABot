/**

import java.lang.reflect.Modifier;

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
	}
}