package org.isistan.flabot.javamodel.java;

import org.isistan.flabot.javamodel.JClass;
import org.isistan.flabot.javamodel.JShortPrimitive;
import org.isistan.flabot.javamodel.MixedImplementationsException;

public class ShortPrimitiveImpl extends PrimitiveImpl implements
		JShortPrimitive {

	private Short javaShortPrimitive;
	
	Short getShortPrimitive() {
		return javaShortPrimitive;
	}
	
	static Short getShortPrimitive(JShortPrimitive jShortPrimitive) {
		if(jShortPrimitive instanceof ShortPrimitiveImpl) {
			return ((ShortPrimitiveImpl)jShortPrimitive).getShortPrimitive();
		} else {
			throw new MixedImplementationsException(jShortPrimitive);
		} 
	}
	
	ShortPrimitiveImpl(Short javaShortPrimitive) {
		super(javaShortPrimitive);
		this.javaShortPrimitive=javaShortPrimitive;
	}

	public short getValue() {
		return javaShortPrimitive.shortValue();
	}

	@Override
	public JClass getObjectClass() {
		return JavaFactory.getInstance().buildClass(short.class);
	}
	
	public String getString() {
		return javaShortPrimitive.toString();
	}

}
