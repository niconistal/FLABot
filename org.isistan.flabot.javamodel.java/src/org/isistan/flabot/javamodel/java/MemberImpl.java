/**

import java.lang.reflect.Member;

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
	}

}