package org.isistan.flabot.javamodel.java;

import org.isistan.flabot.javamodel.JClass;
import org.isistan.flabot.javamodel.JLongPrimitive;
import org.isistan.flabot.javamodel.MixedImplementationsException;

public class LongPrimitiveImpl extends PrimitiveImpl implements
		JLongPrimitive {

	private Long javaLongPrimitive;
	
	Long getLongPrimitive() {
		return javaLongPrimitive;
	}
	
	static Long getLongPrimitive(JLongPrimitive jLongPrimitive) {
		if(jLongPrimitive instanceof LongPrimitiveImpl) {
			return ((LongPrimitiveImpl)jLongPrimitive).getLongPrimitive();
		} else {
			throw new MixedImplementationsException(jLongPrimitive);
		} 
	}
	
	LongPrimitiveImpl(Long javaLongPrimitive) {
		super(javaLongPrimitive);
		this.javaLongPrimitive=javaLongPrimitive;
	}

	public long getValue() {
		return javaLongPrimitive.longValue();
	}

	@Override
	public JClass getObjectClass() {
		return JavaFactory.getInstance().buildClass(long.class);
	}

	public String getString() {
		return javaLongPrimitive.toString();
	}

}
