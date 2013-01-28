package org.isistan.flabot.javamodel.java;

import org.isistan.flabot.javamodel.JDoublePrimitive;
import org.isistan.flabot.javamodel.ObjectMirrorBuilder;

public class DoublePrimitiveBuilder implements ObjectMirrorBuilder<JDoublePrimitive> {


	public boolean accepts(Object object) {
		return object instanceof Double;
	}
	
	
	public JDoublePrimitive build(Object object) {
		return new DoublePrimitiveImpl(((Double)object));
	}


}
