/** * $Id: GenericDeclarationBuilder.java,v 1.1 2006/01/27 18:47:41 dacostae Exp $ * $Author: dacostae $ */package org.isistan.flabot.javamodel.java;

import java.lang.reflect.GenericDeclaration;import org.isistan.flabot.javamodel.JGenericDeclaration;import org.isistan.flabot.javamodel.ObjectMirrorBuilder;public class GenericDeclarationBuilder implements ObjectMirrorBuilder<JGenericDeclaration> {

	public boolean accepts(Object object) {
		return object instanceof GenericDeclaration;
	}
	public JGenericDeclaration build(Object object) {
		return new GenericDeclarationImpl((GenericDeclaration)object);
	}


}
