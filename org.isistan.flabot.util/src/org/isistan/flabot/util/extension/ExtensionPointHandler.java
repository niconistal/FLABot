package org.isistan.flabot.util.extension;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.Platform;

/**
 * Handles common issues associated with extension points.
 * 
 * @author da Costa Cambio
 *
 */
public class ExtensionPointHandler implements ExtensionElement {
	
	/**
	 * The extension point itself.
	 */
	private IExtensionPoint extensionPoint;

	/**
	 * creates a new handler for the given extension point.
	 * @param extensionPoint
	 */
	public ExtensionPointHandler(IExtensionPoint extensionPoint) {
		this.extensionPoint=extensionPoint;
	}
	
	/**
	 * Returns the actual extension point.
	 * @return
	 */
	public IExtensionPoint getExtensionPoint() {
		return extensionPoint;
	}
	
	/**
	 * creates a new handler for the given extension point (the actual extension
	 * point point is obtained from the extension registry).
	 * @param extensionPointId
	 */
	public ExtensionPointHandler(String extensionPointId) {
		this.extensionPoint =
			Platform.getExtensionRegistry().getExtensionPoint(
					extensionPointId
				);
		if(extensionPoint==null) {
			throw new IllegalArgumentException("Extension point does not exist: " + extensionPointId);
		}
	}
	
	/**
	 * Returns the extensions contributing this handler's extension point.
	 * @return
	 */
	public IExtension[] getExtensions() {
		return extensionPoint.getExtensions();
	}

	/**
	 * Returns the extension handlers for the extensions contributing
	 * this handler's extension point.
	 * @return
	 */
	public ExtensionHandler[] getExtensionHandlers() {
		IExtension[] extensions=getExtensions();
		ExtensionHandler[] extensionsHandlers=new ExtensionHandler[extensions.length];
		for (int i = 0; i < extensionsHandlers.length; i++) {
			extensionsHandlers[i]=new ExtensionHandler(extensions[i]);
		}
		return extensionsHandlers;
	}	
	
	/**
	 * Returns all configuration elements from all extensions for this
	 * handler's extension point
	 * @param path
	 * @return
	 */
	public IConfigurationElement[] getAllConfigurationElements(String... path) {
		return ConfigurationElementHandlerUtil.getAllConfigurationElements(
				extensionPoint, path);
	}
	
	/**
	 * Returns the handlers for all configuration elements from all extensions
	 * for this handler's extension point
	 * @param path
	 * @return
	 */
	public ConfigurationElementHandler[] getAllConfigurationElementHandlers(String... path) {
		return ConfigurationElementHandlerUtil.createConfigurationElementHandlers(
				getAllConfigurationElements(path));
	}

	public String getNamespace() {
		return extensionPoint.getNamespace();
	}
}
