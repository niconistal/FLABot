package org.isistan.flabot.engine;


/**
 * Constants for provided extension points
 * @author $Author: dacostae $
 *
 */
public interface ExtensionPointConstants {
	
	
	/**
	 * Prefix for every extension-point's id
	 */
	public static final String PREFIX = EnginePlugin.SYMBOLIC_NAME + ".";
	
	/**
	 * Extension-point for the failure located actions
	 */
	public static final String FAILURE_LOCATED_ACTION = 
		PREFIX +"failureLocatedAction";
	
	public static final String FAILURE_LOCATED_ACTION__ACTION_TAG = "action";
	public static final String FAILURE_LOCATED_ACTION__NAME_ATTRIBUTE = "name";
	public static final String FAILURE_LOCATED_ACTION__DESCRIPTION_ATTRIBUTE = "description";
	public static final String FAILURE_LOCATED_ACTION__ICON_ATTRIBUTE = "icon";
	public static final String FAILURE_LOCATED_ACTION__CLASS_ATTRIBUTE = "class";

	/**
	 * Extension-point for the strategy UI combo box
	 */
	public static final String STRATEGY_UI_COMBO_BOX = 
		PREFIX +"strategyUIComboBox";
	
	public static final String STRATEGY_UI_COMBO_BOX_ACTION_TAG = "action";
	public static final String STRATEGY_UI_COMBO_BOX__CLASS_ATTRIBUTE = "class";
	
	public static final String PROLOG_STRATEGY_UI_COMBO_BOX = 
		PREFIX +"prologStrategyUIComboBox";
	
	public static final String PROLOG_STRATEGY_UI_COMBO_BOX_ACTION_TAG = "action";
	public static final String PROLOG_STRATEGY_UI_COMBO_BOX__CLASS_ATTRIBUTE = "class";
	
	public static final String GENERAL_LOG_FILTER_STRATEGY_UI_COMBO_BOX = 
		PREFIX +"generalLogFilterStrategyUIComboBox";
	
	public static final String GENERAL_LOG_FILTER_STRATEGY_UI_COMBO_BOX_ACTION_TAG = "action";
	public static final String GENERAL_LOG_FILTER_STRATEGY_UI_COMBO_BOX__CLASS_ATTRIBUTE = "class";
	
}
