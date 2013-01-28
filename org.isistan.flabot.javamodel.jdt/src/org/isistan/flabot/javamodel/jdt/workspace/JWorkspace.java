package org.isistan.flabot.javamodel.jdt.workspace;

import org.eclipse.jdt.core.JavaModelException;
import org.isistan.flabot.javamodel.JArray;
import org.isistan.flabot.javamodel.JObject;

/**
 * Represents a workspace (as IJavaModel)
 * @author $Author: dacostae $
 *
 */
public interface JWorkspace extends JObject, JWorkspaceElement {
	
	/**
	 * Returns the project contained in this workspace
	 * @return
	 * @throws JavaModelException
	 */
	public JArray<? extends JProject> getProjects();

	/**
	 * Returns the name of this workspace
	 * @return
	 */
	public String getName();

}
