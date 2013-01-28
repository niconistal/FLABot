package org.isistan.flabot.javamodel.java;

import org.isistan.flabot.javamodel.JBytePrimitive;
import org.isistan.flabot.javamodel.ObjectMirrorBuilder;

public class BytePrimitiveBuilder implements ObjectMirrorBuilder<JBytePrimitive> {


	public boolean accepts(Object object) {
		return object instanceof Byte;
	}
	
	
	public JBytePrimitive build(Object object) {
		return new BytePrimitiveImpl(((Byte)object));
	}


}
