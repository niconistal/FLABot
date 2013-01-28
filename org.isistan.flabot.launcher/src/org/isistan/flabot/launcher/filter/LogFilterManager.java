package org.isistan.flabot.launcher.filter;

import org.isistan.flabot.coremodel.Responsibility;
import org.isistan.flabot.launcher.LauncherPlugin;
import org.isistan.flabot.launcher.filter.filtermodel.LogFilter;

/**
 * Useful class to operate with log filters.
 * @author usuario
 *
 */
public class LogFilterManager {
	/**
	 * Element id that is used to store elements in the extended data map
	 */
	public static final String LOG_FILTER_ELEMENT_ID="logFilter";
	
	/**
	 * Returns the log filter associated with the given responsibility.
	 * @param responsibility
	 * @return
	 */
	public static LogFilter getLogFilter(Responsibility responsibility) {
		if(responsibility==null) {
			throw new IllegalArgumentException("responsibility cannot be null.");
		}
		LogFilter logFilter = (LogFilter) responsibility.getExtendedData(LauncherPlugin.SYMBOLIC_NAME, LOG_FILTER_ELEMENT_ID);
		return logFilter;
	}
	
	/**
	 * Sets the log filter associated with the given responsibility.
	 * Returns the previous set mapping or null if not set.
	 * 
	 * @param responsibility
	 * @param logFilter
	 * @return
	 */
	public static LogFilter setLogFilter(Responsibility responsibility, LogFilter logFilter) {
		return (LogFilter) responsibility.putExtendedData(LauncherPlugin.SYMBOLIC_NAME, LOG_FILTER_ELEMENT_ID, logFilter);
	}
}
