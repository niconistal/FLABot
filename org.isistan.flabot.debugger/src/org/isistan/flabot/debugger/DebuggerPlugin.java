package org.isistan.flabot.debugger;

import org.eclipse.ui.plugin.*;
import org.eclipse.jface.resource.ImageDescriptor;
import org.isistan.flabot.FlabotPlugin;
import org.isistan.flabot.util.log.DefaultLogStatusCodes;
import org.isistan.flabot.util.log.EclipsePlatformLogger;
import org.isistan.flabot.util.log.LogStatusCodes;
import org.osgi.framework.BundleContext;
import org.slf4j.Logger;

/**
 * The main plugin class to be used in the desktop.
 */
public class DebuggerPlugin extends AbstractUIPlugin {

	/**
	 * This plugin's id
	 */
	public static final String SYMBOLIC_NAME = "org.isistan.debugger";
	
	
	//The shared instance.
	private static DebuggerPlugin plugin;


	private Logger logger;
	
	/**
	 * The constructor.
	 */
	public DebuggerPlugin() {
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
	public static DebuggerPlugin getDefault() {
		return plugin;
	}

	/**
	 * Returns an image descriptor for the image file at the given
	 * plug-in relative path.
	 *
	 * @param path the path
	 * @return the image descriptor
	 */
	public static ImageDescriptor getImageDescriptor(String path) {
		return AbstractUIPlugin.imageDescriptorFromPlugin("org.isistan.flabot.debugger", path);
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
}
