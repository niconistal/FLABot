/** * $Id: FieldBuilder.java,v 1.1 2006/01/27 18:46:32 dacostae Exp $ * $Author: dacostae $ */package org.isistan.flabot.javamodel.javassist;

import javassist.CtField;import org.isistan.flabot.javamodel.JField;import org.isistan.flabot.javamodel.ObjectMirrorBuilder;public class FieldBuilder implements ObjectMirrorBuilder<JField> {

	public boolean accepts(Object object) {
		return object instanceof CtField;
	}
	
	public JField build(Object object) {
		return new FieldImpl((CtField)object);
	}
}
