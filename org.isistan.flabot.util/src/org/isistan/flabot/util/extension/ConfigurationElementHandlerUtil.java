package org.isistan.flabot.util.extension;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;

public class ConfigurationElementHandlerUtil {

	/**
	 * The path delimiter
	 */
	public static final String PATH_DELIMITER="/";

	
	/**
	 * Creates an array of configuration element handlers for the given configuration elements. 
	 * @param configurationElements
	 * @return
	 */
	public static ConfigurationElementHandler[] createConfigurationElementHandlers(IConfigurationElement[] configurationElements) {
		ConfigurationElementHandler[] configurationElementHandlers=
			new ConfigurationElementHandler[configurationElements.length];
		for (int i = 0; i < configurationElementHandlers.length; i++) {
			configurationElementHandlers[i]=new ConfigurationElementHandler(configurationElements[i]);
		}
		return configurationElementHandlers;
	}
	
	/**
	 * Returns the configuration elements conforming the path.
	 * The path is is a sucesion of tab names and is relative to
	 * the given configuration element.
	 * @param path
	 * @return
	 */
	public static IConfigurationElement[] getConfigurationElements(IConfigurationElement configurationElement, String[] path) {
		if(path.length==0) {
			throw new IllegalArgumentException("Path must have a least lenght=1.");
		}
		List<IConfigurationElement> configurationElements=new LinkedList<IConfigurationElement>();
		ConfigurationElementHandlerUtil.getConfigurationElements(configurationElement, path, 0, configurationElements);
		return configurationElements.toArray(new IConfigurationElement[configurationElements.size()]);
	}
	
	/**
	 * Returns all configuration elements from all extensions for this
	 * handler's extension point.
	 * @param path
	 * @return
	 */
	public static IConfigurationElement[] getAllConfigurationElements(IExtensionPoint extensionPoint, String[] path) {
		if(path.length==0) {
			throw new IllegalArgumentException("Path must have a least lenght=1.");
		}
		IExtension[] extensions = extensionPoint.getExtensions();
		List<IConfigurationElement> configurationElements=new LinkedList<IConfigurationElement>();
		for (IExtension extension : extensions) {
			ConfigurationElementHandlerUtil.getConfigurationElements(
					extension.getConfigurationElements(), path, configurationElements);
		}
		
		return configurationElements.toArray(new IConfigurationElement[configurationElements.size()]);
	}
	
	/**
	 * Returns the configuration elements conforming the path, using the given configuration elements
	 * as first level.
	 * @param childConfigurationElements
	 * @param path
	 * @return
	 */
	public static IConfigurationElement[] getConfigurationElements(IConfigurationElement[] childConfigurationElements, String[] path) {
		if(path.length==0) {
			throw new IllegalArgumentException("Path must have a least lenght=1.");
		}
		List<IConfigurationElement> configurationElements=new LinkedList<IConfigurationElement>();
		getConfigurationElements(childConfigurationElements, path, configurationElements);
		return configurationElements.toArray(new IConfigurationElement[configurationElements.size()]);
	}
	
	/**
	 * Adds to the list all the configuration elements conforming the path, using the given
	 * configuration elements as first level.
	 * @param childConfigurationElements
	 * @param path
	 * @return
	 */
	private static void getConfigurationElements(IConfigurationElement[] childConfigurationElements, String[] path, List<IConfigurationElement> configurationElements) {
		for (IConfigurationElement childConfigurationElement : childConfigurationElements) {
			if(childConfigurationElement.getName().equals(path[0])) {
				if(path.length==1) {
					configurationElements.add(childConfigurationElement);
				} else {
					getConfigurationElements(childConfigurationElement, path, 1, configurationElements);
				}
			}
		}
	}
	/**
	 * Adds to the given list the configuration elements that conforms the given path (the subarray
	 * stating at the given index) relatively to the given configuration element.
	 * @param configurationElement
	 * @param path
	 * @param index
	 * @param configurationElements
	 */
	private static void getConfigurationElements(IConfigurationElement configurationElement, String[] path, int index, List<IConfigurationElement> configurationElements) {
		IConfigurationElement[] childConfigurationElements=configurationElement.getChildren(path[index]);
		for (IConfigurationElement childConfigurationElement : childConfigurationElements) {
			if(path.length==index+1) {
				configurationElements.add(childConfigurationElement);
			} else {
				getConfigurationElements(childConfigurationElement, path, index+1, configurationElements);
			}
		}
	}

	/**
	 * Creates a an array of strings splitin the given path with PATH_DELIMITER
	 * @param path
	 * @return
	 */
	public static String[] getPath(String path) {
		return path.split(ConfigurationElementHandlerUtil.PATH_DELIMITER);
	}
}
