package org.isistan.flabot.javamodel.java;

import org.isistan.flabot.javamodel.JBytePrimitive;
import org.isistan.flabot.javamodel.JClass;
import org.isistan.flabot.javamodel.MixedImplementationsException;

public class BytePrimitiveImpl extends PrimitiveImpl implements
		JBytePrimitive {

	private Byte javaBytePrimitive;
	
	Byte getBytePrimitive() {
		return javaBytePrimitive;
	}
	
	static Byte getBytePrimitive(JBytePrimitive jBytePrimitive) {
		if(jBytePrimitive instanceof BytePrimitiveImpl) {
			return ((BytePrimitiveImpl)jBytePrimitive).getBytePrimitive();
		} else {
			throw new MixedImplementationsException(jBytePrimitive);
		} 
	}
	
	BytePrimitiveImpl(Byte javaBytePrimitive) {
		super(javaBytePrimitive);
		this.javaBytePrimitive=javaBytePrimitive;
	}

	public byte getValue() {
		return javaBytePrimitive.byteValue();
	}
	
	@Override
	public JClass getObjectClass() {
		return JavaFactory.getInstance().buildClass(byte.class);
	}
	
	public String getString() {
		return javaBytePrimitive.toString();
	}

}
