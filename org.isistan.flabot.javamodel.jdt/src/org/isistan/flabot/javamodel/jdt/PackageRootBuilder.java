/** * $Id: PackageRootBuilder.java,v 1.1 2006/02/14 04:34:51 dacostae Exp $ * $Author: dacostae $ */package org.isistan.flabot.javamodel.jdt;

import org.eclipse.jdt.core.IPackageFragmentRoot;import org.isistan.flabot.javamodel.ObjectMirrorBuilder;import org.isistan.flabot.javamodel.jdt.workspace.JPackageRoot;public class PackageRootBuilder implements ObjectMirrorBuilder<JPackageRoot> {

	public boolean accepts(Object object) {
		return object instanceof IPackageFragmentRoot;
	}

	public JPackageRoot build(Object object) {
		return new PackageRootImpl((IPackageFragmentRoot) object);
	}

}
