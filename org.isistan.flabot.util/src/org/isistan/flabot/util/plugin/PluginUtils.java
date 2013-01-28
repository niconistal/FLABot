package org.isistan.flabot.util.plugin;

import java.io.IOException;
import java.net.URL;

import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Plugin;
import org.isistan.flabot.util.UtilPlugin;
import org.osgi.framework.Bundle;

public class PluginUtils {

	/**
	 * Returns the plugin folder for the given plugin
	 * @return
	 */
	public static String getPluginFolder(Plugin plugin) {
		return getPluginFolder(plugin.getBundle());
	}
	
	/**
	 * Returns the plugin folder for the given bundle
	 * @return
	 */
	public static String getPluginFolder(Bundle bundle) {
		try {
			// URL to the root ("/") of the plugin-path:
			URL relativeURL = bundle.getEntry("/");
	
			// Turn relative path to a local path with the help of Eclipse-platform:
			URL localURL = Platform.asLocalURL(relativeURL);
	
			// From this you can get the path
			return localURL.getPath();
		} catch (IOException e) {
			UtilPlugin.getDefault().getLogger().error("Error obtainng plugin folder.", e);
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * Returns the plugin folder for the given bundle id
	 * @return
	 */
	public static String getPluginFolder(String symbolicName) {
		Bundle bundle=Platform.getBundle(symbolicName);
		return getPluginFolder(bundle);
	}
	
}
