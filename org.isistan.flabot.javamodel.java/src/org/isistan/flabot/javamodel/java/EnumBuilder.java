/** * $Id: EnumBuilder.java,v 1.1 2006/01/27 18:47:41 dacostae Exp $ * $Author: dacostae $ */package org.isistan.flabot.javamodel.java;

import org.isistan.flabot.javamodel.JEnum;import org.isistan.flabot.javamodel.ObjectMirrorBuilder;public class EnumBuilder implements ObjectMirrorBuilder<JEnum> {

	public boolean accepts(Object object) {
		return object instanceof Enum;
	}

	public JEnum build(Object object) {
		return new EnumImpl((Enum)object);
	}


}
