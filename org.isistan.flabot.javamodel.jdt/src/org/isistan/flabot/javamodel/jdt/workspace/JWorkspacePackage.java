package org.isistan.flabot.javamodel.jdt.workspace;

import org.eclipse.jdt.core.JavaModelException;
import org.isistan.flabot.javamodel.JArray;
import org.isistan.flabot.javamodel.JPackage;

/**
 * Represents a workspace package (as IPackageFragment)
 * @author $Author: dacostae $
 *
 */
public interface JWorkspacePackage extends JPackage, JWorkspaceElement {
	/**
	 * Returns the package's contained .java and .class files
	 * @return
	 * @throws JavaModelException
	 */
	public JArray<? extends JJavaFile> getJavaFiles();
	
	
	/**
	 * returns the parent package, null if package is directly in root
	 * @return
	 */
	public JWorkspacePackage getParentPackage();
	
	/**
	 * returns the child packages (none if package is default)
	 * @return
	 * @throws JavaModelException
	 */
	public JArray<? extends JWorkspacePackage> getPackages();

}
