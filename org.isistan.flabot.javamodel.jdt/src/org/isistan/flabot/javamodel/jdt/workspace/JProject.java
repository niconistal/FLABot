package org.isistan.flabot.javamodel.jdt.workspace;

import org.eclipse.jdt.core.JavaModelException;
import org.isistan.flabot.javamodel.JArray;
import org.isistan.flabot.javamodel.JObject;


/**
 * Represents a project (as IJavaProject)
 * @author $Author: dacostae $
 *
 */
public interface JProject extends JObject, JWorkspaceElement {
	
	/**
	 * Returns the workspace
	 * @return
	 */
	public JWorkspace getWorkspace();
	
	/**
	 * Returns the project's package roots
	 * @return
	 * @throws JavaModelException
	 */
	public JArray<? extends JPackageRoot> getPackageRoots();
	
	/**
	 * Returns all the project's package roots
	 * @return
	 * @throws JavaModelException
	 */
	public JArray<? extends JPackageRoot> getAllPackageRoots();
	
	/**
	 * returns the project name
	 * @return
	 */
	public String getName();
}
