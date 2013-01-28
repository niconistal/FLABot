package org.isistan.flabot.launcher.collection;


/**
 * Exception thrown by CollectionLaunchers when the fail to launch an application.
 * @author usuario
 *
 */
public class CollectionLauncherException extends Exception {
	private static final long serialVersionUID = 1L;

	/**
	 * Creates a CollectionLauncherException specifying a message.
	 * @param message
	 */
	public CollectionLauncherException(String message) {
		super(message);
	}

	/**
	 * Creates a CollectionLauncherException specifying a cause.
	 * @param cause
	 */
	public CollectionLauncherException(Throwable cause) {
		super(cause);
	}
	
	/**
	 * Creates a CollectionLauncherException specifying a message and cause.
	 * @param message
	 * @param cause
	 */
	public CollectionLauncherException(String message, Throwable cause) {
		super(message, cause);
	}
	
	/**
	 * Returns a textual description of the exception. 
	 */
	@Override
	public String toString() {
		return this.getClass().getName() + 
				": " + (getMessage()==null? "Error while launching application.":
					getMessage());
	}
}
