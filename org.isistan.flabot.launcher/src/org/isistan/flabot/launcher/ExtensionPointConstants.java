package org.isistan.flabot.launcher;


/**
 * Constants for provided extension points
 * @author $Author: dacostae $
 *
 */
public interface ExtensionPointConstants {
	
	
	/**
	 * Prefix for every extension-point's id
	 */
	public static final String PREFIX = LauncherPlugin.SYMBOLIC_NAME + ".";
	
	/**
	 * Extension-point for the collection launchers
	 */
	public static final String COLLECTION_LAUNCHER = 
		PREFIX + "collectionLauncher";
	
	public static final String COLLECTION_LAUNCHER__LAUNCHER_TAG = "launcher";
	public static final String COLLECTION_LAUNCHER__ID_ATTRIBUTE = "id";
	public static final String COLLECTION_LAUNCHER__NAME_ATTRIBUTE = "name";
	public static final String COLLECTION_LAUNCHER__LAUNCHER_CLASS_ATTRIBUTE = "class";
	public static final String COLLECTION_LAUNCHER__LAUNCHER_TAB_CLASS_ATTRIBUTE = "tabClass";

	/**
	 * Extension-point for the context providers
	 */
	public static final String CONTEXT_PROVIDER = 
		PREFIX + "contextProvider";
	
	public static final String CONTEXT_PROVIDER__PROVIDER_TAG = "provider";
	public static final String CONTEXT_PROVIDER__ID_ATTRIBUTE = "id";
	public static final String CONTEXT_PROVIDER__NAME_ATTRIBUTE = "name";
	public static final String CONTEXT_PROVIDER__PROVIDER_CLASS_ATTRIBUTE = "class";
	public static final String CONTEXT_PROVIDER__PROVIDER_TAB_CLASS_ATTRIBUTE = "tabClass";

}
