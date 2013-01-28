package org.isistan.flabot.executionstatemapping;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.isistan.flabot.util.log.DefaultLogStatusCodes;
import org.isistan.flabot.util.log.EclipsePlatformLogger;
import org.isistan.flabot.util.log.LogStatusCodes;
import org.osgi.framework.BundleContext;
import org.slf4j.Logger;

/**
 * The activator class controls the plug-in life cycle
 */
public class ExecutionConditionPlugin extends AbstractUIPlugin
{

	// The plug-in ID
	public static final String PLUGIN_ID = "org.isistan.flabot.executionstatemapping";

	// The shared instance
	private static ExecutionConditionPlugin plugin;

	/**
	 * Returns the shared instance
	 * 
	 * @return the shared instance
	 */
	public static ExecutionConditionPlugin getDefault()
	{
		return plugin;
	}

	/**
	 * Returns an image descriptor for the image file at the given plug-in
	 * relative path
	 * 
	 * @param path
	 *            the path
	 * @return the image descriptor
	 */
	public static ImageDescriptor getImageDescriptor(String path)
	{
		return imageDescriptorFromPlugin(PLUGIN_ID, path);
	}

	/**
	 * This plugin's logger
	 */
	private Logger logger;

	/**
	 * The constructor
	 */
	public ExecutionConditionPlugin()
	{
		plugin = this;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	@Override
	public void start(BundleContext context) throws Exception
	{
		super.start(context);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
	 */
	@Override
	public void stop(BundleContext context) throws Exception
	{
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the plugin's logger
	 * 
	 * @return
	 */
	public Logger getLogger()
	{
		if (logger == null)
		{
			logger = new EclipsePlatformLogger(this,
					ExecutionConditionPlugin.PLUGIN_ID, getLogStatusCodes());
		}
		return logger;
	}

	/**
	 * Returns the plugin's LogStatusCodes
	 * 
	 * @return
	 */
	public LogStatusCodes getLogStatusCodes()
	{
		return DefaultLogStatusCodes.getInstance();
	}

}