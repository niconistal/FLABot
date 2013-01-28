package org.isistan.flabot.javamodel.java;

import org.isistan.flabot.javamodel.JClass;
import org.isistan.flabot.javamodel.JIntPrimitive;
import org.isistan.flabot.javamodel.MixedImplementationsException;

public class IntPrimitiveImpl extends PrimitiveImpl implements
		JIntPrimitive {

	private Integer javaIntPrimitive;
	
	Integer getIntPrimitive() {
		return javaIntPrimitive;
	}
	
	static Integer getIntPrimitive(JIntPrimitive jIntPrimitive) {
		if(jIntPrimitive instanceof IntPrimitiveImpl) {
			return ((IntPrimitiveImpl)jIntPrimitive).getIntPrimitive();
		} else {
			throw new MixedImplementationsException(jIntPrimitive);
		} 
	}
	
	IntPrimitiveImpl(Integer javaIntPrimitive) {
		super(javaIntPrimitive);
		this.javaIntPrimitive=javaIntPrimitive;
	}

	public int getValue() {
		return javaIntPrimitive.intValue();
	}
	
	@Override
	public JClass getObjectClass() {
		return JavaFactory.getInstance().buildClass(int.class);
	}

	public String getString() {
		return javaIntPrimitive.toString();
	}

}
