/**
 * $Id: ComponentLocatorManagerImpl.java,v 1.2 2006/01/25 01:46:25 mblech Exp $
 * $Author: mblech $
 */
package org.isistan.flabot.util.locator.impl;

import java.util.HashMap;
import java.util.Map;

import org.isistan.flabot.util.locator.ComponentLocator;
import org.isistan.flabot.util.locator.ComponentLocatorException;
import org.isistan.flabot.util.locator.ComponentLocatorManager;

/**
 * @author $Author: mblech $
 *
 */
public class ComponentLocatorManagerImpl implements ComponentLocatorManager {
	
	Map locatorRegistry;
	
	public ComponentLocatorManagerImpl() {
		locatorRegistry = new HashMap();
	}

	/* (non-Javadoc)
	 * @see org.isistan.flabot.util.locator.ComponentLocatorManager#getComponent(java.lang.String, java.util.Map)
	 */
	public Object getComponent(String locatorId, Map parameters)
			throws ComponentLocatorException {
		ComponentLocator locator = getLocator(locatorId);
		if (locator == null)
			throw new ComponentLocatorException("There's no locator with id = "
					+ locatorId);
		return locator.locate(parameters);
	}

	/* (non-Javadoc)
	 * @see org.isistan.flabot.util.locator.ComponentLocatorManager#getLocator(java.lang.String)
	 */
	public ComponentLocator getLocator(String locatorId) {
		ComponentLocator locator = (ComponentLocator)
			locatorRegistry.get(locatorId);
		return locator;
	}

	/* (non-Javadoc)
	 * @see org.isistan.flabot.util.locator.ComponentLocatorManager#registerLocator(java.lang.String, org.isistan.flabot.util.locator.ComponentLocator)
	 */
	public ComponentLocator registerLocator(String locatorId,
			ComponentLocator locator) {
		if (locatorId == null)
			throw new IllegalArgumentException("Can't register a locator " +
					"without id");
		return (ComponentLocator) locatorRegistry.put(locatorId, locator);
	}

}
