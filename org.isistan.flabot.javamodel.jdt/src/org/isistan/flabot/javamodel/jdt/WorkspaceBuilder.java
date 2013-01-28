/** * $Id: WorkspaceBuilder.java,v 1.1 2006/02/14 04:34:51 dacostae Exp $ * $Author: dacostae $ */package org.isistan.flabot.javamodel.jdt;

import org.eclipse.jdt.core.IJavaModel;import org.isistan.flabot.javamodel.ObjectMirrorBuilder;import org.isistan.flabot.javamodel.jdt.workspace.JWorkspace;public class WorkspaceBuilder implements ObjectMirrorBuilder<JWorkspace> {

	public boolean accepts(Object object) {
		return object instanceof IJavaModel;
	}

	public JWorkspace build(Object object) {
		return new WorkspaceImpl((IJavaModel) object);
	}

}
