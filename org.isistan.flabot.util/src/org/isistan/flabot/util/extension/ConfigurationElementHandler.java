package org.isistan.flabot.util.extension;

import java.net.URL;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;
import org.osgi.framework.Bundle;

/**
 * Handles common issues associated with configuration elements.
 * @author usuario
 *
 */
public class ConfigurationElementHandler implements ConfigurationElementContainerHandler, ExtensionElement {
	
	/**
	 * The configuration element itself.
	 */
	private IConfigurationElement configurationElement;

	/**
	 * Creates a new handler for the given configuration element.
	 * @param extension
	 */
	public ConfigurationElementHandler(IConfigurationElement configurationElement) {
		this.configurationElement=configurationElement;
	}
	
	/**
	 * Returns the actual configuration element.
	 * @return
	 */
	public IConfigurationElement getConfigurationElement() {
		return configurationElement;
	}
	
	/**
	 * Obtains all configuration elements conforming the given path, relative to
	 * this configuration element
	 */
	public IConfigurationElement[] getConfigurationElements(String... path) {
		if(path.length==0) {
			throw new IllegalArgumentException("Path must have a least lenght=1.");
		}
		return ConfigurationElementHandlerUtil.getConfigurationElements(configurationElement, path);
	}

	/**
	 * Obtains handlers for all configuration elements conforming the given path, relative to
	 * this configuration element
	 */
	public ConfigurationElementHandler[] getConfigurationElementHandlers(String... path) {
		return ConfigurationElementHandlerUtil.createConfigurationElementHandlers(getConfigurationElements(path));
	}
	
	/**
	 * Obtains the string value of an attribute
	 * @param attributeName
	 * @return
	 */
	public String getString(String attributeName) {
		return configurationElement.getAttribute(attributeName);
	}
	
	/**
	 * Obtains the integer value of an attribute
	 * @param attributeName
	 * @return
	 */
	public Integer getInteger(String attributeName) {
		String string=configurationElement.getAttribute(attributeName);
		if(string==null || string.trim().length()==0) {
			return null;
		}
		return Integer.valueOf(string);
	}

	/**
	 * Obtains a class defined in the given attribute
	 * @param <T>
	 * @param attributeName
	 * @return
	 * @throws ClassNotFoundException
	 */
	public <T> Class<? extends T> getClass(String attributeName) throws ClassNotFoundException {
		return ClassExtensionLoader.<T>loadClass(
				configurationElement, attributeName);
	}

	/**
	 * Obtains this configuration element namespace
	 */
	public String getNamespace() {
		return configurationElement.getDeclaringExtension().getNamespace();
	}

	/**
	 * Obtains a URL for the resource defined in the given attribute
	 * @param attributeName
	 * @return
	 */
	public URL getURL(String attributeName) {
		String attributeValue=configurationElement.getAttribute(attributeName);
		if(attributeValue==null || attributeValue.trim().length()==0) {
			return null;
		}
		String bundleSymbolicName=configurationElement.getDeclaringExtension().getNamespace();
		Bundle bundle = Platform.getBundle(bundleSymbolicName);
		URL url=bundle.getResource(attributeValue);
		return url;
	}
	
	/**
	 * Obtains an image defined in the given attribute
	 * @param attributeName
	 * @return
	 */
	public Image getImage(String attributeName) {
		URL url=this.getURL(attributeName);
		if(url==null) {
			return null;
		}
		ImageDescriptor descriptor=ImageDescriptor.createFromURL(url);
		Image image=descriptor.createImage();
		return image;
	}
}
