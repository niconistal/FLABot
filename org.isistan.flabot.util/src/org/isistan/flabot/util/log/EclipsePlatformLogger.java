/**
 * $Id: EclipsePlatformLogger.java,v 1.1 2006/02/07 02:19:31 dacostae Exp $
 * $Author: dacostae $
 */
package org.isistan.flabot.util.log;

import org.eclipse.core.runtime.ILog;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Plugin;
import org.eclipse.core.runtime.Status;
import org.slf4j.Logger;
import org.slf4j.Marker;

/**
 * Logger implementation that uses the eclipse platform's logging facility
 * @author $Author: dacostae $
 *
 */
public class EclipsePlatformLogger implements Logger {

	private static final String PLACEHOLDER_REGEX = "\\{\\}";

	/**
	 * This is a reference to the platform's logger
	 */
	private ILog pLog;
	
	/**
	 * This is a reference to this logger's owner plugin
	 */
	private Plugin plugin;

	/**
	 * The id of the plugin
	 */
	private String pluginId;
	
	/**
	 * The plugin-specific status code descriptor
	 */
	private LogStatusCodes codes;

	/**
	 * Create a logger instance for the given plugin
	 * @param plugin the plugin that owns this logger
	 * @param pluginId the id of the plugin
	 * @param The plugin-specific status codes descriptor
	 */
	public EclipsePlatformLogger(Plugin plugin, String pluginId,
			LogStatusCodes codes) {
		this.pLog = plugin.getLog();
		this.plugin = plugin;
		this.pluginId = pluginId;
		this.codes = codes;
	}

	/* (non-Javadoc)
	 * @see org.slf4j.Logger#getName()
	 */
	public String getName() {
		return pLog.getBundle().getSymbolicName() + " log";
	}

	/* (non-Javadoc)
	 * @see org.slf4j.Logger#isDebugEnabled()
	 */
	public boolean isDebugEnabled() {
		return plugin.isDebugging();
	}

	/* (non-Javadoc)
	 * @see org.slf4j.Logger#isDebugEnabled(org.slf4j.Marker)
	 */
	public boolean isDebugEnabled(Marker m) {
		return isDebugEnabled();
	}
	
	/**
	 * Create a status with the given status codes (general and plugin-specific),
	 * message and exception and log it.
	 * @param gCode the general code (defined in the IStatus interface)
	 * @param sCode the plugin-specific code (provided by the LogStatusCodes interface)
	 * @param message the message string
	 * @param throwable the exception (if any)
	 */
	private void doLog(int gCode, int sCode, String message,
			Throwable throwable) {
		IStatus s =
			new Status(gCode, pluginId, sCode, message, throwable);
		pLog.log(s);
	}
	
	/**
	 * Construct a string from the template, replacing the placeholder
	 * with the given object
	 * @param template the template string that contains a placeholder
	 * @param o the object whose string representation should replace the
	 * placeholder
	 * @return
	 */
	private String constructMessage(String template, Object o) {
		String str;
		if (o == null)
			str = "null";
		else
			str = o.toString().replaceAll("\\\\", "\\\\\\\\").replaceAll("\\$", "\\\\\\$");
		template = template.replaceFirst(PLACEHOLDER_REGEX, str);
		return template;
	}
	
	/**
	 * Construct a string from the template, replacing the placeholder
	 * with the given object
	 * @param template the template string that contains two placeholders
	 * @param o1 the object whose string representation should replace the
	 * placeholder
	 * @return
	 */
	private String constructMessage(String template, Object o1, Object o2) {
		String str1;
		if (o1 == null)
			str1 = "null";
		else
			str1 = o1.toString().replaceAll("\\\\", "\\\\\\\\").replaceAll("\\$", "\\\\\\$");
		String str2;
		if (o2 == null)
			str2 = "null";
		else
			str2 = o2.toString().replaceAll("\\\\", "\\\\\\\\").replaceAll("\\$", "\\\\\\$");
		template = template.replaceFirst(PLACEHOLDER_REGEX, str1);
		template = template.replaceFirst(PLACEHOLDER_REGEX, str2);
		return template;					
	}

	/* (non-Javadoc)
	 * @see org.slf4j.Logger#debug(java.lang.String)
	 */
	public void debug(String message) {
		if (isDebugEnabled()) {
			doLog(IStatus.OK, codes.getDebugCode(),
					message, null);
		}
	}

	/* (non-Javadoc)
	 * @see org.slf4j.Logger#debug(java.lang.String, java.lang.Object)
	 */
	public void debug(String template, Object o) {
		if (isDebugEnabled()) {
			String message = constructMessage(template, o);
			doLog(IStatus.OK, codes.getDebugCode(), message, null);
		}
	}

	/* (non-Javadoc)
	 * @see org.slf4j.Logger#debug(java.lang.String, java.lang.Object, java.lang.Object)
	 */
	public void debug(String template, Object o1, Object o2) {
		if (isDebugEnabled()) {
			String message = constructMessage(template, o1, o2);
			doLog(IStatus.OK, codes.getDebugCode(), message, null);
		}
	}

	/* (non-Javadoc)
	 * @see org.slf4j.Logger#debug(java.lang.String, java.lang.Throwable)
	 */
	public void debug(String template, Throwable t) {
		if (isDebugEnabled()) {
			String message = constructMessage(template, t);
			doLog(IStatus.OK, codes.getDebugCode(), message, t);
		}
	}

	/* (non-Javadoc)
	 * @see org.slf4j.Logger#debug(org.slf4j.Marker, java.lang.String)
	 */
	public void debug(Marker m, String message) {
		debug(message);
	}

	/* (non-Javadoc)
	 * @see org.slf4j.Logger#debug(org.slf4j.Marker, java.lang.String, java.lang.Object)
	 */
	public void debug(Marker m, String template, Object o) {
		debug(template, o);
	}

	/* (non-Javadoc)
	 * @see org.slf4j.Logger#debug(org.slf4j.Marker, java.lang.String, java.lang.Object, java.lang.Object)
	 */
	public void debug(Marker m, String template, Object o1, Object o2) {
		debug(template, o1, o2);
	}

	/* (non-Javadoc)
	 * @see org.slf4j.Logger#debug(org.slf4j.Marker, java.lang.String, java.lang.Throwable)
	 */
	public void debug(Marker m, String template, Throwable t) {
		debug(template, t);
	}

	/* (non-Javadoc)
	 * @see org.slf4j.Logger#isInfoEnabled()
	 */
	public boolean isInfoEnabled() {
		// TODO select an appropriate mechanism for debug level selection
		return true;
	}

	/* (non-Javadoc)
	 * @see org.slf4j.Logger#isInfoEnabled(org.slf4j.Marker)
	 */
	public boolean isInfoEnabled(Marker m) {
		return isInfoEnabled();
	}

	/* (non-Javadoc)
	 * @see org.slf4j.Logger#info(java.lang.String)
	 */
	public void info(String message) {
		if (isInfoEnabled()) {
			doLog(IStatus.OK, codes.getInfoCode(), message, null);
		}
	}

	/* (non-Javadoc)
	 * @see org.slf4j.Logger#info(java.lang.String, java.lang.Object)
	 */
	public void info(String template, Object o) {
		if (isInfoEnabled()) {
			String message = constructMessage(template, o);
			doLog(IStatus.OK, codes.getInfoCode(), message, null);
		}
	}

	/* (non-Javadoc)
	 * @see org.slf4j.Logger#info(java.lang.String, java.lang.Object, java.lang.Object)
	 */
	public void info(String template, Object o1, Object o2) {
		if (isInfoEnabled()) {
			String message = constructMessage(template, o1, o2);
			doLog(IStatus.OK, codes.getInfoCode(), message, null);
		}
	}

	/* (non-Javadoc)
	 * @see org.slf4j.Logger#info(java.lang.String, java.lang.Throwable)
	 */
	public void info(String template, Throwable t) {
		if (isInfoEnabled()) {
			String message = constructMessage(template, t);
			doLog(IStatus.OK, codes.getInfoCode(), message, t);
		}
	}

	/* (non-Javadoc)
	 * @see org.slf4j.Logger#info(org.slf4j.Marker, java.lang.String)
	 */
	public void info(Marker m, String message) {
		info(message);
	}

	/* (non-Javadoc)
	 * @see org.slf4j.Logger#info(org.slf4j.Marker, java.lang.String, java.lang.Object)
	 */
	public void info(Marker m, String template, Object o) {
		info(template, o);
	}

	/* (non-Javadoc)
	 * @see org.slf4j.Logger#info(org.slf4j.Marker, java.lang.String, java.lang.Object, java.lang.Object)
	 */
	public void info(Marker m, String template, Object o1, Object o2) {
		info(template, o1, o2);
	}

	/* (non-Javadoc)
	 * @see org.slf4j.Logger#info(org.slf4j.Marker, java.lang.String, java.lang.Throwable)
	 */
	public void info(Marker m, String template, Throwable t) {
		info(template, t);
	}

	/* (non-Javadoc)
	 * @see org.slf4j.Logger#isWarnEnabled()
	 */
	public boolean isWarnEnabled() {
		//TODO select a proper log level selection mechanism
		return true;
	}

	/* (non-Javadoc)
	 * @see org.slf4j.Logger#warn(java.lang.String)
	 */
	public void warn(String message) {
		if (isWarnEnabled()) {
			doLog(IStatus.WARNING, codes.getWarningCode(), message, null);
		}
	}

	/* (non-Javadoc)
	 * @see org.slf4j.Logger#warn(java.lang.String, java.lang.Object)
	 */
	public void warn(String template, Object o) {
		if (isWarnEnabled()) {
			String message = constructMessage(template, o);
			doLog(IStatus.WARNING, codes.getWarningCode(), message, null);
		}
	}

	/* (non-Javadoc)
	 * @see org.slf4j.Logger#warn(java.lang.String, java.lang.Object, java.lang.Object)
	 */
	public void warn(String template, Object o1, Object o2) {
		if (isWarnEnabled()) {
			String message = constructMessage(template, o1, o2);
			doLog(IStatus.WARNING, codes.getWarningCode(), message, null);
		}
	}

	/* (non-Javadoc)
	 * @see org.slf4j.Logger#warn(java.lang.String, java.lang.Throwable)
	 */
	public void warn(String template, Throwable t) {
		if (isWarnEnabled()) {
			String message = constructMessage(template, t);
			doLog(IStatus.WARNING, codes.getWarningCode(), message, t);
		}
	}

	/* (non-Javadoc)
	 * @see org.slf4j.Logger#isWarnEnabled(org.slf4j.Marker)
	 */
	public boolean isWarnEnabled(Marker m) {
		return isWarnEnabled();
	}

	/* (non-Javadoc)
	 * @see org.slf4j.Logger#warn(org.slf4j.Marker, java.lang.String)
	 */
	public void warn(Marker m, String message) {
		warn(message);
	}

	/* (non-Javadoc)
	 * @see org.slf4j.Logger#warn(org.slf4j.Marker, java.lang.String, java.lang.Object)
	 */
	public void warn(Marker m, String template, Object o) {
		warn(template, o);
	}

	/* (non-Javadoc)
	 * @see org.slf4j.Logger#warn(org.slf4j.Marker, java.lang.String, java.lang.Object, java.lang.Object)
	 */
	public void warn(Marker m, String template, Object o1, Object o2) {
		warn(template, o1, o2);
	}

	/* (non-Javadoc)
	 * @see org.slf4j.Logger#warn(org.slf4j.Marker, java.lang.String, java.lang.Throwable)
	 */
	public void warn(Marker m, String template, Throwable t) {
		warn(template, t);
	}

	/* (non-Javadoc)
	 * @see org.slf4j.Logger#isErrorEnabled()
	 */
	public boolean isErrorEnabled() {
		//TODO select a proper log level selection mechanism
		return true;
	}

	/* (non-Javadoc)
	 * @see org.slf4j.Logger#error(java.lang.String)
	 */
	public void error(String message) {
		if (isErrorEnabled()) {
			doLog(IStatus.ERROR, codes.getErrorCode(), message, null);
		}
	}

	/* (non-Javadoc)
	 * @see org.slf4j.Logger#error(java.lang.String, java.lang.Object)
	 */
	public void error(String template, Object o) {
		if (isErrorEnabled()) {
			String message = constructMessage(template, o);
			doLog(IStatus.ERROR, codes.getErrorCode(), message, null);
		}
	}

	/* (non-Javadoc)
	 * @see org.slf4j.Logger#error(java.lang.String, java.lang.Object, java.lang.Object)
	 */
	public void error(String template, Object o1, Object o2) {
		if (isErrorEnabled()) {
			String message = constructMessage(template, o1, o2);
			doLog(IStatus.ERROR, codes.getErrorCode(), message, null);
		}
	}

	/* (non-Javadoc)
	 * @see org.slf4j.Logger#error(java.lang.String, java.lang.Throwable)
	 */
	public void error(String template, Throwable t) {
		if (isErrorEnabled()) {
			String message = constructMessage(template, t);
			doLog(IStatus.ERROR, codes.getErrorCode(), message, t);
		}
	}

	/* (non-Javadoc)
	 * @see org.slf4j.Logger#isErrorEnabled(org.slf4j.Marker)
	 */
	public boolean isErrorEnabled(Marker m) {
		return isErrorEnabled();
	}

	/* (non-Javadoc)
	 * @see org.slf4j.Logger#error(org.slf4j.Marker, java.lang.String)
	 */
	public void error(Marker m, String message) {
		error(message);
	}

	/* (non-Javadoc)
	 * @see org.slf4j.Logger#error(org.slf4j.Marker, java.lang.String, java.lang.Object)
	 */
	public void error(Marker m, String template, Object o) {
		error(template, o);
	}

	/* (non-Javadoc)
	 * @see org.slf4j.Logger#error(org.slf4j.Marker, java.lang.String, java.lang.Object, java.lang.Object)
	 */
	public void error(Marker m, String template, Object o1, Object o2) {
		error(template, o1, o2);
	}

	/* (non-Javadoc)
	 * @see org.slf4j.Logger#error(org.slf4j.Marker, java.lang.String, java.lang.Throwable)
	 */
	public void error(Marker m, String template, Throwable t) {
		error(template, t);
	}
}
