package org.isistan.flabot.engine;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.isistan.flabot.FlabotPlugin;
import org.isistan.flabot.engine.executionstate.javalogtrace.TraceInferenceJavalogEngineLocator;
import org.isistan.flabot.engine.locator.FlabotEngineLocator;
import org.isistan.flabot.util.log.DefaultLogStatusCodes;
import org.isistan.flabot.util.log.EclipsePlatformLogger;
import org.isistan.flabot.util.log.LogStatusCodes;
import org.osgi.framework.BundleContext;
import org.slf4j.Logger;

/**
 * The main plugin class to be used in the desktop.
 */
public class EnginePlugin extends AbstractUIPlugin {

	/**
	 * This plugin's id
	 */
	public static final String SYMBOLIC_NAME = "org.isistan.flabot.engine"; //$NON-NLS-1$

	
	//The shared instance.
	private static EnginePlugin plugin;
	
	/**
	 * This plugin's logger
	 */
	private Logger logger;

	/**
	 * The constructor.
	 */
	public EnginePlugin() {
		plugin = this;
	}

	/**
	 * This method is called upon plug-in activation
	 */
	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		
		// initialize locator
		FlabotPlugin.getDefault().getComponentLocatorManager()
			.registerLocator(FlabotEngineLocator.LOCATOR_ID,
					new FlabotEngineLocator());
		
		// trace inference javalog engine locator
		FlabotPlugin.getDefault().getComponentLocatorManager()
			.registerLocator(TraceInferenceJavalogEngineLocator.LOCATOR_ID,
					new TraceInferenceJavalogEngineLocator());
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
	public static EnginePlugin getDefault() {
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
		return AbstractUIPlugin.imageDescriptorFromPlugin(SYMBOLIC_NAME, path);
	}
	
	/**
	 * Returns the plugin's logger
	 * @return
	 */
	public Logger getLogger() {
		if (logger == null) {
			logger = new EclipsePlatformLogger(this, EnginePlugin.SYMBOLIC_NAME, getLogStatusCodes());
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
