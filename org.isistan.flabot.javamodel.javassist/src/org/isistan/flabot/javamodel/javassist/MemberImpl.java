/**

import javassist.CtMember;

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
	}
}