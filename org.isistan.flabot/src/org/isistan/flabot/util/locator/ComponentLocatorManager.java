/**
 * $Id: ComponentLocatorManager.java,v 1.2 2006/01/25 01:46:24 mblech Exp $
 * $Author: mblech $
 */
package org.isistan.flabot.util.locator;

import java.util.Map;

/**
 * Manages ComponentsLocators that are registered by id.
 * Different components locate each other using this manager
 * as an access point.
 * @author $Author: mblech $
 *
 */
public interface ComponentLocatorManager {

	/**
	 * Obtain an instance of the component specified by the locatorId,
	 * using the given parameters.
	 * @param locatorId the id of the locator that manages the component
	 * @param parameters locator-specific parameters
	 * @return a component instance
	 * @throws ComponentLocatorException when there's no locator with the
	 * 	given id or something bad happens while locating the component
	 */
	Object getComponent(String locatorId, Map parameters)
		throws ComponentLocatorException;
	
	/**
	 * Register a locator with the given id
	 * @param locatorId the id to be used for registration
	 * @param locator the locator
	 * @return the locator that was previously registered with that id (if any)
	 */
	ComponentLocator registerLocator(String locatorId,
			ComponentLocator locator);
	
	/**
	 * Get the locator that's registered with the given id.
	 * @param locatorId the Id of the requested locator
	 * @return the locator that is registered with the given id (null if none)
	 */
	ComponentLocator getLocator(String locatorId);
}
