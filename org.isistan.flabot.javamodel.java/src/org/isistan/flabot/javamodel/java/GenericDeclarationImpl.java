/** * $Id: GenericDeclarationImpl.java,v 1.3 2006/03/18 00:25:06 dacostae Exp $ * $Author: dacostae $ */package org.isistan.flabot.javamodel.java;

import java.lang.reflect.GenericDeclaration;import org.isistan.flabot.javamodel.JArray;import org.isistan.flabot.javamodel.JGenericDeclaration;import org.isistan.flabot.javamodel.JTypeVariable;import org.isistan.flabot.javamodel.MixedImplementationsException;public class GenericDeclarationImpl extends ObjectImpl implements
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
