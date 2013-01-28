/**
 * $Id: FlabotPlugin.java,v 1.25 2006/03/21 02:57:52 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.isistan.flabot.util.locator.ComponentLocatorManager;
import org.isistan.flabot.util.locator.impl.ComponentLocatorManagerImpl;
import org.isistan.flabot.util.log.DefaultLogStatusCodes;
import org.isistan.flabot.util.log.EclipsePlatformLogger;
import org.isistan.flabot.util.log.LogStatusCodes;
import org.isistan.flabot.util.plugin.PluginUtils;
import org.slf4j.Logger;

/**
 * The plugin class (singleton).
 * <p>
 * This instance can be shared between all extensions in the plugin. Information
 * shared between extensions can be persisted by using the PreferenceStore.
 * </p>
 * @see org.eclipse.ui.plugin.AbstractUIPlugin#getPreferenceStore()
 * @author $Author: franco $
 */
public class FlabotPlugin extends AbstractUIPlugin {
	
	/**
	 * This plugin's id
	 */
	public static final String SYMBOLIC_NAME = "org.isistan.flabot"; //$NON-NLS-1$
	
	/** Single plugin instance. */
	private static FlabotPlugin singleton;
	
	/**
	 * Returns the shared plugin instance.
	 */
	public static FlabotPlugin getDefault() {
		return singleton;
	}
	
	/**
	 * This plugin's logger
	 */
	private Logger logger;

	private ComponentLocatorManager componentLocatorManager;
	
	/** 
	 * The constructor. 
	 */
	public FlabotPlugin() {
		if (singleton == null) {
			singleton = this;
		}
	}

	public static String getPluginFolder() {
		return PluginUtils.getPluginFolder(FlabotPlugin.getDefault());
	}

	/**
	 * Returns the plugin's logger
	 * @return
	 */
	public Logger getLogger() {
		if (logger == null) {
			logger = new EclipsePlatformLogger(this, FlabotPlugin.SYMBOLIC_NAME, getLogStatusCodes());
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
	
	public ComponentLocatorManager getComponentLocatorManager() {
		if (componentLocatorManager == null) {
			componentLocatorManager = new ComponentLocatorManagerImpl();
			// TODO register here all the component locators
			// TODO Engine plugin should initialize this
			/*
			componentLocatorManager.registerLocator(
					FailureLocatedActionLocator.LOCATOR_ID, new FailureLocatedActionLocator());*/
		}
		return componentLocatorManager;
	}
}