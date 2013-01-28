package org.isistan.flabot.util.extension;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.osgi.framework.Bundle;

/**
 * Load classes from extensions
 * @author usuario
 *
 */
public class ClassExtensionLoader {

	/**
	 * Loads a class defined in the given configuration element with the given attribute name.
	 * @param <T>
	 * @param classNameContainer
	 * @param classNameAttribute
	 * @return the Class or null if the class name found is null or an empty string.
	 * @throws ClassNotFoundException
	 */
	public static <T> Class<? extends T> loadClass(IConfigurationElement classNameContainer, String classNameAttribute) throws ClassNotFoundException {
		if(classNameAttribute==null || classNameAttribute.trim().length()==0)
			throw new IllegalArgumentException("Class name attribute cannot be null nor empty");

		String className=classNameContainer.getAttribute(classNameAttribute);
		if(className==null) {
			return null;
		}
		String bundleSymbolicName=classNameContainer.getDeclaringExtension().getNamespace();
		return loadClass(bundleSymbolicName, className);
	}
	
	/**
	 * Loads a class with the given name in the given name in a plugin with the given
	 * symbolic name
	 * @param <T>
	 * @param bundleSymbolicName
	 * @param className
	 * @return
	 * @throws ClassNotFoundException
	 */
	public static <T> Class<? extends T> loadClass(String bundleSymbolicName, String className) throws ClassNotFoundException {
		if(className==null || className.trim().length()==0)
			throw new IllegalArgumentException("Class name cannot be null nor empty");
		if(bundleSymbolicName==null || bundleSymbolicName.trim().length()==0)
			throw new IllegalArgumentException("BundleSymbolicName name cannot be null nor empty");
		Bundle bundle = Platform.getBundle(bundleSymbolicName);
		Class<? extends T> clazz = (Class<? extends T>)bundle.loadClass(className);
		return clazz;
	}

}
