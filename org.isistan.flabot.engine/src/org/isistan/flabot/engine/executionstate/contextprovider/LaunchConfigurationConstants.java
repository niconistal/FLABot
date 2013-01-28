package org.isistan.flabot.engine.executionstate.contextprovider;

import org.isistan.flabot.engine.EnginePlugin;

public interface LaunchConfigurationConstants {
	/**
	 * Prefix for every attribute
	 */
	public static final String PREFIX = EnginePlugin.SYMBOLIC_NAME + ".";

	
	/**
	 * Attribute for the flabot file
	 */
	public static final String FLABOT_FILE =
		PREFIX + "flabotFile";
	
}
