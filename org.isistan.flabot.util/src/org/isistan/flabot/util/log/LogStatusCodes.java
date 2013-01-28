package org.isistan.flabot.util.log;

/**
 * This interface must be implemented by clients to provide plugin-specific
 * log status codes
 * @author $Author: dacostae $
 *
 */
public interface LogStatusCodes {
	int getDebugCode();

	int getErrorCode();

	int getWarningCode();

	int getInfoCode();
}