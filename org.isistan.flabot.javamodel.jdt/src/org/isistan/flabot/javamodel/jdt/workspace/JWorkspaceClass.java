package org.isistan.flabot.javamodel.jdt.workspace;

import org.isistan.flabot.javamodel.JClass;

/**
 * Represents a workspace class (as IType)
 * @author $Author: dacostae $
 *
 */
public interface JWorkspaceClass extends JClass, JWorkspaceElement {

	/**
	 * Returns the java file containing this class
	 * null for primitive types
	 * @return
	 */
	public JJavaFile getJavaFile();

}
