/**
 * $Id: ComponentLocator.java,v 1.1 2005/11/17 22:46:26 mblech Exp $
 * $Author: mblech $
 */
package org.isistan.flabot.util.locator;

import java.util.Map;

/**
 * Implementations of this interface are responsible for location,
 * instance creation and instance management of specific components
 * @author $Author: mblech $
 *
 */
public interface ComponentLocator {

	/**
	 * Locate a component instance using the given parameters
	 * @param parameters the parameters to use for component location
	 * @return an instance of the component
	 * @throws ComponentLocatorException when something bad happens
	 * 	while locating the component
	 */
	Object locate(Map parameters) throws ComponentLocatorException;
}
