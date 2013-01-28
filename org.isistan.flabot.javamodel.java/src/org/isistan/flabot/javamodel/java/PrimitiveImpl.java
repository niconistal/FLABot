package org.isistan.flabot.javamodel.java;

import org.isistan.flabot.javamodel.JClass;
import org.isistan.flabot.javamodel.JPrimitive;
import org.isistan.flabot.javamodel.MixedImplementationsException;

public abstract class PrimitiveImpl extends ObjectImpl implements
		JPrimitive {

	private Object javaPrimitive;
	
	Object getPrimitive() {
		return javaPrimitive;
	}
	
	static Object getPrimitive(JPrimitive jPrimitive) {
		if(jPrimitive instanceof PrimitiveImpl) {
			return ((PrimitiveImpl)jPrimitive).getPrimitive();
		} else {
			throw new MixedImplementationsException(jPrimitive);
		} 
	}
	
	PrimitiveImpl(Object javaPrimitive) {
		super(javaPrimitive);
		this.javaPrimitive=javaPrimitive;
	}

	@Override
	public boolean isPrimitiveValue() {
		return true;
	}

	@Override
	public JClass getObjectClass() {
		throw new UnsupportedOperationException();
	}
	
	@Override
	public String objectToString() {
		return this.getString();
	}

}
