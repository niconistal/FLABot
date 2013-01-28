package org.isistan.flabot.launcher;


public interface LaunchConfigurationConstants {

	/**
	 * Prefix for every attribute
	 */
	public static final String PREFIX = LauncherPlugin.SYMBOLIC_NAME + ".";

	
	/**
	 * Attribute for the target configuration
	 */
	public static final String TARGET_LAUNCH_CONFIGURATION =
		PREFIX + "targetLaunchConfiguration";
	
	/**
	 * Attribute for the collection launcher id
	 */
	public static final String COLLECTION_LAUNCHER_ID = 
		PREFIX + "collectionLauncherId";

	/**
	 * Attribute for the collection provider id
	 */
	public static final String CONTEXT_PROVIDER_ID = 
		PREFIX + "contextProviderId";
	
	
	/**
	 * Attribute for the collection output file
	 */
	public static final String OUTPUT_FILE = 
		PREFIX + "outputFile";
	
	/**
	 * Attribute for the start collecting option
	 */
	public static final String START_COLLECTING = 
		PREFIX + "startCollecting";
}
