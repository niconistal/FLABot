package org.isistan.flabot.javamodel.jdt.workspace;

import org.eclipse.jdt.core.JavaModelException;
import org.isistan.flabot.javamodel.JArray;
import org.isistan.flabot.javamodel.JObject;

/**
 * Represents a package root (as IPackageFragmentRoot)
 * @author $Author: dacostae $
 *
 */
public interface JPackageRoot extends JObject, JWorkspaceElement {

	/**
	 * returns all packages contained in this package root (recursively)
	 * @return
	 * @throws JavaModelException
	 */
	public JArray<? extends JWorkspacePackage> getAllPackages();

	/**
	 * Returns the package with the given name, null if not present
	 * @param packageName
	 * @return
	 */
	public JWorkspacePackage getPackage(String packageName);

	/**
	 * returns packages contained in this package root (not recursively)
	 * @return
	 * @throws JavaModelException
	 */
	public JArray<? extends JWorkspacePackage> getPackages();
	
	/**
	 * Returns this package root name
	 * @return
	 */
	public String getName();
	
	
	/**
	 * Returns the path to the resource respresenting this package root
	 * @return
	 */
	public String getPath();
}
