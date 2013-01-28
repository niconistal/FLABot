package org.isistan.flabot.util.log;


/**
 * Default LogStatusCodes
 * @author usuario
 *
 */
public class DefaultLogStatusCodes implements LogStatusCodes {
	public static final int LOG_STATUS_DEBUG = 1;

	public static final int LOG_STATUS_INFO = 2;

	public static final int LOG_STATUS_WARNING = 3;

	public static final int LOG_STATUS_ERROR = 4;

	private static DefaultLogStatusCodes instance;
	
	public static DefaultLogStatusCodes getInstance() {
		if(instance==null) {
			instance=new DefaultLogStatusCodes();
		}
		return instance;
	}
	
	private DefaultLogStatusCodes() {
		
	}
	
	public int getDebugCode() {
		return LOG_STATUS_DEBUG;
	}
	public int getInfoCode() {
		return LOG_STATUS_INFO;
	}
	public int getWarningCode() {
		return LOG_STATUS_WARNING;
	}
	public int getErrorCode() {
		return LOG_STATUS_ERROR;
	}	
}