package org.isistan.flabot.javamodel.java;

import org.isistan.flabot.javamodel.JFloatPrimitive;
import org.isistan.flabot.javamodel.ObjectMirrorBuilder;

public class FloatPrimitiveBuilder implements ObjectMirrorBuilder<JFloatPrimitive> {


	public boolean accepts(Object object) {
		return object instanceof Float;
	}
	
	
	public JFloatPrimitive build(Object object) {
		return new FloatPrimitiveImpl(((Float)object));
	}


}
