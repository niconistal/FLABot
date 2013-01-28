/**

import java.lang.reflect.GenericDeclaration;
		JGenericDeclaration {

	private GenericDeclaration javaGenericDeclaration;
	
	GenericDeclaration getJavaGenericDeclaration() {
		return javaGenericDeclaration;
	}
	
	static GenericDeclaration getJavaGenericDeclaration(JGenericDeclaration jGenericDeclaration) {
		if(jGenericDeclaration instanceof GenericDeclarationImpl) {
			return ((GenericDeclarationImpl)jGenericDeclaration).getJavaGenericDeclaration();
		} else {
			throw new MixedImplementationsException(jGenericDeclaration);
		} 
	}
	
	GenericDeclarationImpl(GenericDeclaration javaGenericDeclaration) {
		super(javaGenericDeclaration);
		this.javaGenericDeclaration=javaGenericDeclaration;
	}
	
	public JArray<? extends JTypeVariable> getTypeParameters() {
		return JavaFactory.getInstance().buildArray(
				javaGenericDeclaration.getTypeParameters(), 
				JavaFactory.getInstance().getTypeVariableBuilder()
			);	

	}

}