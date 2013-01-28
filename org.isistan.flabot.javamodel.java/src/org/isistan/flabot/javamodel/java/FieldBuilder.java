/** * $Id: FieldBuilder.java,v 1.1 2006/01/27 18:47:41 dacostae Exp $ * $Author: dacostae $ */package org.isistan.flabot.javamodel.java;

import java.lang.reflect.Field;import org.isistan.flabot.javamodel.JField;import org.isistan.flabot.javamodel.ObjectMirrorBuilder;public class FieldBuilder implements ObjectMirrorBuilder<JField> {

	public boolean accepts(Object object) {
		return object instanceof Field;
	}
	
	public JField build(Object object) {
		return new FieldImpl((Field)object);
	}
}
