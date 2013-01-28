package org.isistan.flabot.javamodel.java;

import org.isistan.flabot.javamodel.JShortPrimitive;
import org.isistan.flabot.javamodel.ObjectMirrorBuilder;

public class ShortPrimitiveBuilder implements ObjectMirrorBuilder<JShortPrimitive> {


	public boolean accepts(Object object) {
		return object instanceof Short;
	}
	
	
	public JShortPrimitive build(Object object) {
		return new ShortPrimitiveImpl(((Short)object));
	}


}
