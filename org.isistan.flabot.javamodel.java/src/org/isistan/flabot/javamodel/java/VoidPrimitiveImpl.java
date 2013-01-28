package org.isistan.flabot.javamodel.java;

import org.isistan.flabot.javamodel.JClass;
import org.isistan.flabot.javamodel.JVoidPrimitive;

public class VoidPrimitiveImpl extends PrimitiveImpl implements
		JVoidPrimitive {

	public static final Object INTERNAL_VOID_PRIMITIVE=new Object();

	VoidPrimitiveImpl() {
		super(INTERNAL_VOID_PRIMITIVE);
	}

	@Override
	public JClass getObjectClass() {
		return JavaFactory.getInstance().buildClass(void.class);
	}

	public String getString() {
		return STRING;
	}

}
