package org.isistan.flabot.javamodel.java;

import org.isistan.flabot.javamodel.JClass;
import org.isistan.flabot.javamodel.JDoublePrimitive;
import org.isistan.flabot.javamodel.MixedImplementationsException;

public class DoublePrimitiveImpl extends PrimitiveImpl implements
		JDoublePrimitive {

	private Double javaDoublePrimitive;
	
	Double getDoublePrimitive() {
		return javaDoublePrimitive;
	}
	
	static Double getDoublePrimitive(JDoublePrimitive jDoublePrimitive) {
		if(jDoublePrimitive instanceof DoublePrimitiveImpl) {
			return ((DoublePrimitiveImpl)jDoublePrimitive).getDoublePrimitive();
		} else {
			throw new MixedImplementationsException(jDoublePrimitive);
		} 
	}
	
	DoublePrimitiveImpl(Double javaDoublePrimitive) {
		super(javaDoublePrimitive);
		this.javaDoublePrimitive=javaDoublePrimitive;
	}

	public double getValue() {
		return javaDoublePrimitive.doubleValue();
	}
	
	@Override
	public JClass getObjectClass() {
		return JavaFactory.getInstance().buildClass(double.class);
	}

	public String getString() {
		return javaDoublePrimitive.toString();
	}

}
