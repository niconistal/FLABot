package org.isistan.flabot.util.extension;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;

/**
 * Handles common issues associated with extensions.
 * @author usuario
 *
 */
public class ExtensionHandler implements ConfigurationElementContainerHandler, ExtensionElement {
	/**
	 * The extension itself.
	 */
	private IExtension extension;

	/**
	 * Creates a new handler for the given extension.
	 * @param extension
	 */
	public ExtensionHandler(IExtension extension) {
		this.extension=extension;
	}
	
	/**
	 * Returns the actual extension.
	 * @return
	 */
	public IExtension getExtension() {
		return extension;
	}

	public IConfigurationElement[] getConfigurationElements(String... path) {
		return ConfigurationElementHandlerUtil.getConfigurationElements(
				extension.getConfigurationElements(), path);
	}

	public ConfigurationElementHandler[] getConfigurationElementHandlers(String... path) {
		return ConfigurationElementHandlerUtil.createConfigurationElementHandlers(
				getConfigurationElements(path));
	}

	public String getNamespace() {
		return extension.getNamespace();
	}
}
