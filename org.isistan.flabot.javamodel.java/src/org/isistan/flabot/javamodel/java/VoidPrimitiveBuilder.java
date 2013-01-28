package org.isistan.flabot.javamodel.java;

import org.isistan.flabot.javamodel.JVoidPrimitive;
import org.isistan.flabot.javamodel.ObjectMirrorBuilder;

public class VoidPrimitiveBuilder implements ObjectMirrorBuilder<JVoidPrimitive> {
	
	public boolean accepts(Object object) {
		return object==VoidPrimitiveImpl.INTERNAL_VOID_PRIMITIVE;
	}

	public JVoidPrimitive build(Object object) {
		return new VoidPrimitiveImpl();
	}


}
