package org.isistan.flabot.util;

import org.eclipse.core.runtime.Plugin;
import org.isistan.flabot.util.log.DefaultLogStatusCodes;
import org.isistan.flabot.util.log.EclipsePlatformLogger;
import org.isistan.flabot.util.log.LogStatusCodes;
import org.osgi.framework.BundleContext;
import org.slf4j.Logger;

/**
 * The main plugin class to be used in the desktop.
 */
public class UtilPlugin extends Plugin {
	
	/**
	 * This plugin's id
	 */
	public static final String SYMBOLIC_NAME = "org.isistan.flabot.util";
	
	
	//The shared instance.
	private static UtilPlugin plugin;
	
	/**
	 * This plugin's logger
	 */
	private Logger logger;
	
	/**
	 * The constructor.
	 */
	public UtilPlugin() {
		plugin = this;
	}

	/**
	 * This method is called upon plug-in activation
	 */
	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
	}

	/**
	 * This method is called when the plug-in is stopped
	 */
	@Override
	public void stop(BundleContext context) throws Exception {
		super.stop(context);
		plugin = null;
	}

	/**
	 * Returns the shared instance.
	 */
	public static UtilPlugin getDefault() {
		return plugin;
	}

	
	/**
	 * Returns the plugin's logger
	 * @return
	 */
	public Logger getLogger() {
		if (logger == null) {
			logger = new EclipsePlatformLogger(this, UtilPlugin.SYMBOLIC_NAME, getLogStatusCodes());
		}
		return logger;
	}
	
	
	/**
	 * Returns the plugin's LogStatusCodes
	 * @return
	 */
	public LogStatusCodes getLogStatusCodes() {
		return DefaultLogStatusCodes.getInstance();
	}

}
