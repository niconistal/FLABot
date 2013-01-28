/** * $Id: TypeVariableImpl.java,v 1.3 2006/03/18 00:25:07 dacostae Exp $ * $Author: dacostae $ */package org.isistan.flabot.javamodel.java;

import java.lang.reflect.TypeVariable;import org.isistan.flabot.javamodel.JArray;import org.isistan.flabot.javamodel.JGenericDeclaration;import org.isistan.flabot.javamodel.JType;import org.isistan.flabot.javamodel.JTypeVariable;import org.isistan.flabot.javamodel.MixedImplementationsException;public class TypeVariableImpl extends TypeImpl implements JTypeVariable {

	
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
