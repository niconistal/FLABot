/** * $Id: AccessibleObjectBuilder.java,v 1.1 2006/01/27 18:47:41 dacostae Exp $ * $Author: dacostae $ */package org.isistan.flabot.javamodel.java;

import java.lang.reflect.AccessibleObject;import org.isistan.flabot.javamodel.JAccessibleObject;import org.isistan.flabot.javamodel.ObjectMirrorBuilder;public class AccessibleObjectBuilder implements ObjectMirrorBuilder<JAccessibleObject> {
	public boolean accepts(Object object) {
		return object instanceof AccessibleObject;
	}

	public JAccessibleObject build(Object object) {
		return new AccessibleObjectImpl((AccessibleObject)object);
	}

}
