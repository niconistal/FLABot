/**
 * $Id: StateDeterminationException.java,v 1.4 2006/02/20 23:11:26 dacostae Exp $
 * $Author: dacostae $
 */
package org.isistan.flabot.engine.executionstate;



/**
 * Thrown when the execution state can't be determined because of an internal
 * StateDeterminationStrategy implementation-specific error
 * @author $Author: dacostae $
 *
 */
public class StateDeterminationException extends Exception {
	private static final long serialVersionUID = 1L;

	/**
	 * Construct an instance with the given cause
	 * @param cause
	 */
	public StateDeterminationException(Throwable cause) {
		super(cause);
	}

	/**
	 * Construct an instance with the given message and cause
	 * @param message
	 * @param cause
	 */
	public StateDeterminationException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Construct an instance with the given message
	 * @param message
	 */
	public StateDeterminationException(String message) {
		super(message);
	}

}
