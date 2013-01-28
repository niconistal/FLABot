/** * $Id: JavaFileBuilder.java,v 1.2 2006/03/18 00:25:15 dacostae Exp $ * $Author: dacostae $ */package org.isistan.flabot.javamodel.jdt;

import org.eclipse.jdt.core.IClassFile;import org.eclipse.jdt.core.ICompilationUnit;import org.isistan.flabot.javamodel.ObjectMirrorBuilder;import org.isistan.flabot.javamodel.jdt.workspace.JJavaFile;public class JavaFileBuilder implements ObjectMirrorBuilder<JJavaFile> {

	public boolean accepts(Object object) {
		return object instanceof IClassFile || object instanceof ICompilationUnit;
	}

	public JJavaFile build(Object object) {		if(object instanceof IClassFile) {			return new JavaBinaryFileImpl((IClassFile) object);		} else {			return new JavaSourceFileImpl((ICompilationUnit) object);		}
	}

}
