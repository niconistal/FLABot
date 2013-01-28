/** * $Id: ProjectBuilder.java,v 1.1 2006/02/14 04:34:51 dacostae Exp $ * $Author: dacostae $ */package org.isistan.flabot.javamodel.jdt;

import org.eclipse.jdt.core.IJavaProject;import org.isistan.flabot.javamodel.ObjectMirrorBuilder;import org.isistan.flabot.javamodel.jdt.workspace.JProject;public class ProjectBuilder implements ObjectMirrorBuilder<JProject> {

	public boolean accepts(Object object) {
		return object instanceof IJavaProject;
	}

	public JProject build(Object object) {
		return new ProjectImpl((IJavaProject) object);
	}

}
