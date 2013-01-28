package org.isistan.flabot.javamodel.java;

import org.isistan.flabot.javamodel.JBooleanPrimitive;
import org.isistan.flabot.javamodel.ObjectMirrorBuilder;

public class BooleanPrimitiveBuilder implements ObjectMirrorBuilder<JBooleanPrimitive> {


	public boolean accepts(Object object) {
		return object instanceof Boolean;
	}
	
	
	public JBooleanPrimitive build(Object object) {
		return new BooleanPrimitiveImpl(((Boolean)object));
	}


}
