/** * $Id: FieldBuilder.java,v 1.5 2006/03/18 00:25:14 dacostae Exp $ * $Author: dacostae $ */package org.isistan.flabot.javamodel.jdt;

import org.eclipse.jdt.core.IField;import org.isistan.flabot.javamodel.JField;import org.isistan.flabot.javamodel.ObjectMirrorBuilder;public class FieldBuilder implements ObjectMirrorBuilder<JField> {

	public boolean accepts(Object object) {
		return object instanceof IField;
	}
	
	public JField build(Object object) {		return new FieldImpl((IField)object);	}
}
