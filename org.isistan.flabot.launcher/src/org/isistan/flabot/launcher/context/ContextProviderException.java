/**
 * 
 */
package org.isistan.flabot.launcher.context;

/**
 * TraceConfigurationProviders throw this exception when they find an
 * error trying to provide the trace configuration
 * @author mblech
 *
 */
public class ContextProviderException extends Exception {
	private static final long serialVersionUID = 1L;

	/**
	 * Create a new instance with the given message and cause
	 * @param message
	 * @param cause
	 */
	public ContextProviderException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Create a new instance with the given message
	 * @param message
	 */
	public ContextProviderException(String message) {
		super(message);
	}

}
