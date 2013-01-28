package org.isistan.flabot.javamodel.java;

import org.isistan.flabot.javamodel.JCharPrimitive;
import org.isistan.flabot.javamodel.ObjectMirrorBuilder;

public class CharPrimitiveBuilder implements ObjectMirrorBuilder<JCharPrimitive> {


	public boolean accepts(Object object) {
		return object instanceof Character;
	}
	
	
	public JCharPrimitive build(Object object) {
		return new CharPrimitiveImpl(((Character)object));
	}


}
