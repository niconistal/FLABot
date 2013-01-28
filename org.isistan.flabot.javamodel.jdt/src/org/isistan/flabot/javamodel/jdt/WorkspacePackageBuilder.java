/** * $Id: WorkspacePackageBuilder.java,v 1.1 2006/02/14 04:34:52 dacostae Exp $ * $Author: dacostae $ */package org.isistan.flabot.javamodel.jdt;

import org.eclipse.jdt.core.IPackageFragment;import org.eclipse.jdt.core.dom.IPackageBinding;import org.isistan.flabot.javamodel.ObjectMirrorBuilder;import org.isistan.flabot.javamodel.jdt.workspace.JWorkspacePackage;public class WorkspacePackageBuilder implements ObjectMirrorBuilder<JWorkspacePackage> {

	public boolean accepts(Object object) {
		return object instanceof IPackageFragment || object instanceof IPackageBinding;
	}

	public JWorkspacePackage build(Object object) {		if(object instanceof IPackageBinding) {			object=((IPackageBinding)object).getJavaElement();		}
		return new WorkspacePackageImpl((IPackageFragment) object);
	}

}
