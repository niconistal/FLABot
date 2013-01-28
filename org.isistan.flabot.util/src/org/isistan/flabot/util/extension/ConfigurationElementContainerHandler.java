package org.isistan.flabot.util.extension;

import org.eclipse.core.runtime.IConfigurationElement;

public interface ConfigurationElementContainerHandler {

	/**
	 * Returns the configuration elements conforming the path.
	 * The path is is a sucesion of tab names and is relative to
	 * this handler's configuration element container.
	 * @param path
	 * @return
	 */
	public IConfigurationElement[] getConfigurationElements(String... path);

	/**
	 * Returns the handlers for the configuration elements conforming the path.
	 * The path is is a sucesion of tab names and is relative to
	 * this handler's configuration element container.
	 * @param path
	 * @return
	 */
	public ConfigurationElementHandler[] getConfigurationElementHandlers(String... path);
}
