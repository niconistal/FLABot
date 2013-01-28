/**

import java.lang.reflect.TypeVariable;

	
	private TypeVariable javaTypeVariable;
	
	TypeVariable getJavaTypeVariable() {
		return javaTypeVariable;
	}
	
	static TypeVariable getJavaTypeVariable(JTypeVariable jTypeVariable) {
		if(jTypeVariable instanceof TypeVariableImpl) {
			return ((TypeVariableImpl)jTypeVariable).getJavaTypeVariable();
		} else {
			throw new MixedImplementationsException(jTypeVariable);
		} 
	}
	
	TypeVariableImpl(TypeVariable javaTypeVariable) {
		super(javaTypeVariable);
		this.javaTypeVariable=javaTypeVariable;
	}
	
	public JArray<? extends JType> getBounds() {
		return JavaFactory.getInstance().buildArray(
				javaTypeVariable.getBounds(), 
				JavaFactory.getInstance().getTypeBuilder()
			);
	}

	public JGenericDeclaration getGenericDeclaration() {
		return JavaFactory.getInstance().buildGenericDeclaration(
				javaTypeVariable.getGenericDeclaration()
			);
	}

	public String getName() {
		return javaTypeVariable.getName();
	}

}