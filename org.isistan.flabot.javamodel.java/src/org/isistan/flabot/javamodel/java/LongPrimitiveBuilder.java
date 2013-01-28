package org.isistan.flabot.javamodel.java;

import org.isistan.flabot.javamodel.JLongPrimitive;
import org.isistan.flabot.javamodel.ObjectMirrorBuilder;

public class LongPrimitiveBuilder implements ObjectMirrorBuilder<JLongPrimitive> {


	public boolean accepts(Object object) {
		return object instanceof Long;
	}
	
	
	public JLongPrimitive build(Object object) {
		return new LongPrimitiveImpl(((Long)object));
	}


}
