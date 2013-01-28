/** * $Id: PackageBuilder.java,v 1.1 2006/01/27 18:46:32 dacostae Exp $ * $Author: dacostae $ */package org.isistan.flabot.javamodel.javassist;

import org.isistan.flabot.javamodel.JPackage;import org.isistan.flabot.javamodel.ObjectMirrorBuilder;public class PackageBuilder implements ObjectMirrorBuilder<JPackage> {

	public boolean accepts(Object object) {
		return object instanceof String;
	}

	public JPackage build(Object object) {
		return new PackageImpl((String)object);
	}


}
