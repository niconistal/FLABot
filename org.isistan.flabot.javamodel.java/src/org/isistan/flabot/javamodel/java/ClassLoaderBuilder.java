/** * $Id: ClassLoaderBuilder.java,v 1.1 2006/01/27 18:47:41 dacostae Exp $ * $Author: dacostae $ */package org.isistan.flabot.javamodel.java;

import org.isistan.flabot.javamodel.JClassLoader;import org.isistan.flabot.javamodel.ObjectMirrorBuilder;public class ClassLoaderBuilder implements ObjectMirrorBuilder<JClassLoader> {

	public boolean accepts(Object object) {
		return object instanceof ClassLoader;
	}
	public JClassLoader build(Object object) {
		return new ClassLoaderImpl((ClassLoader)object);
	}



}
