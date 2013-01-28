package org.isistan.flabot.javamodel.java;

import org.isistan.flabot.javamodel.JIntPrimitive;
import org.isistan.flabot.javamodel.ObjectMirrorBuilder;

public class IntPrimitiveBuilder implements ObjectMirrorBuilder<JIntPrimitive> {


	public boolean accepts(Object object) {
		return object instanceof Integer;
	}
	
	
	public JIntPrimitive build(Object object) {
		return new IntPrimitiveImpl(((Integer)object));
	}


}
