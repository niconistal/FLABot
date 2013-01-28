package org.isistan.flabot.javamodel.java;

import org.isistan.flabot.javamodel.JBooleanPrimitive;
import org.isistan.flabot.javamodel.JClass;
import org.isistan.flabot.javamodel.MixedImplementationsException;

public class BooleanPrimitiveImpl extends PrimitiveImpl implements
		JBooleanPrimitive {

	private Boolean javaBooleanPrimitive;
	
	Boolean getBooleanPrimitive() {
		return javaBooleanPrimitive;
	}
	
	static Boolean getBooleanPrimitive(JBooleanPrimitive jBooleanPrimitive) {
		if(jBooleanPrimitive instanceof BooleanPrimitiveImpl) {
			return ((BooleanPrimitiveImpl)jBooleanPrimitive).getBooleanPrimitive();
		} else {
			throw new MixedImplementationsException(jBooleanPrimitive);
		} 
	}
	
	BooleanPrimitiveImpl(Boolean javaBooleanPrimitive) {
		super(javaBooleanPrimitive);
		this.javaBooleanPrimitive=javaBooleanPrimitive;
	}

	public boolean getValue() {
		return javaBooleanPrimitive.booleanValue();
	}

	@Override
	public JClass getObjectClass() {
		return JavaFactory.getInstance().buildClass(boolean.class);
	}
	
	public String getString() {
		return javaBooleanPrimitive.toString();
	}

}
