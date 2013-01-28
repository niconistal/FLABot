/**
 * $Id: ComponentLocatorException.java,v 1.2 2006/02/14 04:34:49 dacostae Exp $
 * $Author: dacostae $
 */
package org.isistan.flabot.util.locator;

/**
 * This exception must be thrown when something bad happens trying to
 * locate a component.
 * @author $Author: dacostae $
 *
 */
public class ComponentLocatorException extends Exception {
	private static final long serialVersionUID = 1L;

	public ComponentLocatorException(String message, Throwable cause) {
		super(message, cause);
	}

	public ComponentLocatorException(String message) {
		super(message);
	}

	public ComponentLocatorException(Throwable cause) {
		super(cause);
	}

}
