package org.isistan.flabot.javamodel.jdt.workspace;

import org.isistan.flabot.javamodel.JArray;
import org.isistan.flabot.javamodel.JDescriptedElement;
import org.isistan.flabot.javamodel.JObject;
import org.isistan.flabot.javamodel.Util;

/**
 * Represents a package root (as IClassFile and ICompilationUnit)
 * @author $Author: dacostae $
 *
 */
public interface JJavaFile extends
		JObject,
		JWorkspaceElement,
		JDescriptedElement {
	
	public static final String JAVA_FILE_DESCRIPTOR_TYPE="";//"javaFile";
	/**
	 * Returns the file name
	 * @return
	 */
	public String getName();
	
	
	/**
	 * Returns all top level classes declared in this file
	 */
	public JArray<? extends JWorkspaceClass> getClasses();

	/**
	 * Returns the package containing this file
	 * @return
	 */
	public JWorkspacePackage getPackage();
	
	
	/**
	 * Returns the descriptor for this file in the form
	 * javaFile:{package}.{javaFile}
	 * 
	 * where:
	 * 		{package} is getPackage().getName();
	 * 		{javaFile} is getName()
	 * @return
	 */
	public String getDescriptor();
	
}
