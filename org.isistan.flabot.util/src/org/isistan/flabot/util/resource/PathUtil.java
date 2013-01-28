package org.isistan.flabot.util.resource;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;

/**
 * Utilities for paths
 * @author usuario
 *
 */
public class PathUtil {
	
	
	/**
	 * Determines if a path exists in system (taking the workspace location as the root)
	 * @param path
	 * @return
	 */
	public static boolean exists(IPath path) {
		IFile file=ResourcesPlugin.getWorkspace().getRoot().getFile(path);
		return file.getLocation()!=null;
	}
	
	/**
	 * Convers a path from the Workspace absolute form (taking the workspace location as the root)
	 * to the System absolute form.
	 * @param path
	 * @return
	 */
	public static IPath makeSystemAbsolute(IPath path) {
		IFile file=ResourcesPlugin.getWorkspace().getRoot().getFile(path);
		return file.getLocation();
	}
	
	/**
	 * Creates a IPath from the given string.
	 * @see Path.fromPortableString(String)
	 * @param path
	 * @return
	 */
	public static IPath fromString(String path) {
		return Path.fromPortableString(path);
	}
	
	/**
	 * Creates a string path from the given IPath.
	 * @see IPath.toPortableString()
	 * @param path
	 * @return
	 */
	public static String toString(IPath path) {
		return path.toPortableString();
	}
	
	/**
	 * Convers a path from the Workspace absolute form (taking the workspace location as the root)
	 * to the System absolute form.
	 * @param path
	 * @return
	 */
	public static String makeSystemAbsolute(String path) {
		IPath absolutePath=PathUtil.makeSystemAbsolute(PathUtil.fromString(path));		
		if(absolutePath==null) {
			return path;
		}
		return PathUtil.toString(absolutePath);
	}
}
