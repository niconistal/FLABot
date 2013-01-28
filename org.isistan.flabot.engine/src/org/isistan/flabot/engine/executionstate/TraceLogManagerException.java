/**
 * $Id: TraceLogManagerException.java,v 1.1 2006/01/31 22:19:29 dacostae Exp $
 * $Author: dacostae $
 */
package org.isistan.flabot.engine.executionstate;

/**
 * Exception in the trace log manager
 * @author $Author: dacostae $
 *
 */
public class TraceLogManagerException extends Exception {
	private static final long serialVersionUID = 1L;

	public TraceLogManagerException(String message) {
		super(message);
	}

}
