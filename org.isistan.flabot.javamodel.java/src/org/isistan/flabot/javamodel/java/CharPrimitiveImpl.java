package org.isistan.flabot.javamodel.java;

import org.isistan.flabot.javamodel.JCharPrimitive;
import org.isistan.flabot.javamodel.JClass;
import org.isistan.flabot.javamodel.MixedImplementationsException;

public class CharPrimitiveImpl extends PrimitiveImpl implements
		JCharPrimitive {

	private Character javaCharPrimitive;
	
	Character getCharPrimitive() {
		return javaCharPrimitive;
	}
	
	static Character getCharPrimitive(JCharPrimitive jCharPrimitive) {
		if(jCharPrimitive instanceof CharPrimitiveImpl) {
			return ((CharPrimitiveImpl)jCharPrimitive).getCharPrimitive();
		} else {
			throw new MixedImplementationsException(jCharPrimitive);
		} 
	}
	
	CharPrimitiveImpl(Character javaCharPrimitive) {
		super(javaCharPrimitive);
		this.javaCharPrimitive=javaCharPrimitive;
	}

	public char getValue() {
		return javaCharPrimitive.charValue();
	}

	@Override
	public JClass getObjectClass() {
		return JavaFactory.getInstance().buildClass(char.class);
	}
	
	public String getString() {
		return javaCharPrimitive.toString();
	}


}
