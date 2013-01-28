package org.isistan.flabot.javamodel.java;

import org.isistan.flabot.javamodel.JClass;
import org.isistan.flabot.javamodel.JFloatPrimitive;
import org.isistan.flabot.javamodel.MixedImplementationsException;

public class FloatPrimitiveImpl extends PrimitiveImpl implements
		JFloatPrimitive {

	private Float javaFloatPrimitive;
	
	Float getFloatPrimitive() {
		return javaFloatPrimitive;
	}
	
	static Float getFloatPrimitive(JFloatPrimitive jFloatPrimitive) {
		if(jFloatPrimitive instanceof FloatPrimitiveImpl) {
			return ((FloatPrimitiveImpl)jFloatPrimitive).getFloatPrimitive();
		} else {
			throw new MixedImplementationsException(jFloatPrimitive);
		} 
	}
	
	FloatPrimitiveImpl(Float javaFloatPrimitive) {
		super(javaFloatPrimitive);
		this.javaFloatPrimitive=javaFloatPrimitive;
	}

	public float getValue() {
		return javaFloatPrimitive.floatValue();
	}

	@Override
	public JClass getObjectClass() {
		return JavaFactory.getInstance().buildClass(float.class);
	}
	
	public String getString() {
		return javaFloatPrimitive.toString();
	}

}
