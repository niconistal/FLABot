/**
 * $Id: ExtensionLoaderComponentLocator.java,v 1.2 2006/04/01 03:50:28 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.util.locator;

import java.util.Map;

import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.Platform;

/**
 * Abstract component locator that provides extension loading functionality.
 * Extend this class to create component loaders that must load extensions.
 * @author $Author: franco $
 *
 */
public abstract class ExtensionLoaderComponentLocator implements
		ComponentLocator {

	public static final String PARAMETER_EXTENSION_ID = "extensionId"; //$NON-NLS-1$

	/* (non-Javadoc)
	 * @see org.isistan.flabot.util.locator.ComponentLocator#locate(java.util.Map)
	 */
	public Object locate(Map parameters) throws ComponentLocatorException {
		String extensionId = (String) parameters.get(PARAMETER_EXTENSION_ID);
		IExtension extension = null;
		if (extensionId == null) {
			// no extension id was given, try to find the first extension
			IExtension[] availableExtensions = getAvailableExtensions();
			if (availableExtensions.length > 0) {
				extension = availableExtensions[0];
			}
			else
				throw new ComponentLocatorException(
						"There are no extensions for this locator's " +
						"extension point (" + getExtensionPointId() + ")");
		}
		else {
			// try to find the extension for the given id
			extension = Platform.getExtensionRegistry()
				.getExtension(extensionId);
			if (extension == null)
				throw new ComponentLocatorException(
						"There's no extension with the given extensionId " +
						"(" + extensionId + ")");
		}
		return instantiate(extension, parameters);
	}
	
	/**
	 * Instantiate the given extension with the given parameters
	 * @param extension
	 * @param parameters
	 * @return
	 */
	protected abstract Object instantiate(IExtension extension, Map parameters)
		throws ComponentLocatorException;

	/**
	 * Get the list of available extensions for this locator's extension point
	 * @return
	 */
	public IExtension[] getAvailableExtensions() {
		return Platform.getExtensionRegistry()
			.getExtensionPoint(getExtensionPointId()).getExtensions();
	}

	/**
	 * Return this locator's extension point id
	 * @return
	 */
	public abstract String getExtensionPointId();

}
