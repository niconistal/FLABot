package org.isistan.flabot;


/**
 * Constants for provided extension points
 * @author $Author: franco $
 *
 */
public interface ExtensionPointConstants {
	
	/**
	 * Prefix for every extension-point's id
	 */
	public static final String PREFIX = FlabotPlugin.SYMBOLIC_NAME + "."; //$NON-NLS-1$
	
	/**
	 * Extension-point for the use case map editor's context menu
	 */
	public static final String UCM_EDITOR_CONTEXT_MENU_ACTION = 
		PREFIX +"ucmEditorContextMenuAction"; //$NON-NLS-1$
	
	public static final String UCM_EDITOR_CONTEXT_MENU_ACTION__ACTION_TAG = "action"; //$NON-NLS-1$
	public static final String UCM_EDITOR_CONTEXT_MENU_ACTION__CLASS_ATTRIBUTE = "class"; //$NON-NLS-1$

	/**
	 * Extension-point for the component diagram editor's context menu
	 */
	public static final String COMPONENT_DIAGRAM_EDITOR_CONTEXT_MENU_ACTION = 
		PREFIX +"componentDiagramEditorContextMenuAction"; //$NON-NLS-1$
	
	public static final String COMPONENT_DIAGRAM_EDITOR_CONTEXT_MENU_ACTION__ACTION_TAG = "action"; //$NON-NLS-1$
	public static final String COMPONENT_DIAGRAM_EDITOR_CONTEXT_MENU_ACTION__CLASS_ATTRIBUTE = "class"; //$NON-NLS-1$

	/**
	 * Extension-point for responsibility edition tabs
	 */
	public static final String RESPONSIBILITY_EDITION_TAB_ITEM = 
		PREFIX +"responsibilityEditionTabItem"; //$NON-NLS-1$
	
	public static final String RESPONSIBILITY_EDITION_TAB_ITEM__TAB_TAG = "tab"; //$NON-NLS-1$
	public static final String RESPONSIBILITY_EDITION_TAB_ITEM__CLASS_ATTRIBUTE = "class"; //$NON-NLS-1$
	public static final String RESPONSIBILITY_EDITION_TAB_ITEM__ORDER_ATTRIBUTE = "order"; //$NON-NLS-1$

	/**
	 * Extension-point for responsibility node edition tabs
	 */
	public static final String RESPONSIBILITY_NODE_EDITION_TAB_ITEM = 
		PREFIX +"responsibilityNodeEditionTabItem"; //$NON-NLS-1$
	
	public static final String RESPONSIBILITY_NODE_EDITION_TAB_ITEM__TAB_TAG = "tab"; //$NON-NLS-1$
	public static final String RESPONSIBILITY_NODE_EDITION_TAB_ITEM__CLASS_ATTRIBUTE = "class"; //$NON-NLS-1$
	public static final String RESPONSIBILITY_NODE_EDITION_TAB_ITEM__ORDER_ATTRIBUTE = "order"; //$NON-NLS-1$
	
	/**
	 * Extension-point for responsibility node edition tabs
	 */
	public static final String CONDITIONED_STUB_RESPONSIBILITY_NODE_EDITION_TAB_ITEM = 
		PREFIX +"conditionedStubResponsibilityNodeEditionTabItem"; //$NON-NLS-1$
	
	public static final String CONDITIONED_STUB_RESPONSIBILITY_NODE_EDITION_TAB_ITEM__TAB_TAG = "tab"; //$NON-NLS-1$
	public static final String CONDITIONED_STUB_RESPONSIBILITY_NODE_EDITION_TAB_ITEM__CLASS_ATTRIBUTE = "class"; //$NON-NLS-1$
	public static final String CONDITIONED_STUB_RESPONSIBILITY_NODE_EDITION_TAB_ITEM__ORDER_ATTRIBUTE = "order"; //$NON-NLS-1$

	
	/**
	 * Extension-point for responsibility materialization edition tabs
	 */
	public static final String RESPONSIBILITY_MATERIALIZATION_EDITION_TAB_ITEM = 
		PREFIX +"responsibilityMaterializationEditionTabItem"; //$NON-NLS-1$
	
	public static final String RESPONSIBILITY_MATERIALIZATION_EDITION_TAB_ITEM__TAB_TAG = "tab"; //$NON-NLS-1$
	public static final String RESPONSIBILITY_MATERIALIZATION_EDITION_TAB_ITEM__CLASS_ATTRIBUTE = "class"; //$NON-NLS-1$
	public static final String RESPONSIBILITY_MATERIALIZATION_EDITION_TAB_ITEM__ORDER_ATTRIBUTE = "order"; //$NON-NLS-1$

	
	/**
	 * Extension-point for responsibility node visual edition tabs
	 */
	public static final String RESPONSIBILITY_NODE_VISUAL_EDITION_TAB_ITEM = 
		PREFIX +"responsibilityNodeVisualEditionTabItem"; //$NON-NLS-1$
	
	public static final String RESPONSIBILITY_NODE_VISUAL_EDITION_TAB_ITEM__TAB_TAG = "tab"; //$NON-NLS-1$
	public static final String RESPONSIBILITY_NODE_VISUAL_EDITION_TAB_ITEM__CLASS_ATTRIBUTE = "class"; //$NON-NLS-1$
	public static final String RESPONSIBILITY_NODE_VISUAL_EDITION_TAB_ITEM__ORDER_ATTRIBUTE = "order"; //$NON-NLS-1$

	/**
	 * Extension-point for component edition tabs
	 */
	public static final String COMPONENT_EDITION_TAB_ITEM = 
		PREFIX +"componentEditionTabItem"; //$NON-NLS-1$
	
	public static final String COMPONENT_EDITION_TAB_ITEM__TAB_TAG = "tab"; //$NON-NLS-1$
	public static final String COMPONENT_EDITION_TAB_ITEM__CLASS_ATTRIBUTE = "class"; //$NON-NLS-1$
	public static final String COMPONENT_EDITION_TAB_ITEM__ORDER_ATTRIBUTE = "order"; //$NON-NLS-1$

	/**
	 * Extension-point for component visual edition tabs
	 */
	public static final String COMPONENT_VISUAL_EDITION_TAB_ITEM = 
		PREFIX +"componentVisualEditionTabItem"; //$NON-NLS-1$
	
	public static final String COMPONENT_VISUAL_EDITION_TAB_ITEM__TAB_TAG = "tab"; //$NON-NLS-1$
	public static final String COMPONENT_VISUAL_EDITION_TAB_ITEM__CLASS_ATTRIBUTE = "class"; //$NON-NLS-1$
	public static final String COMPONENT_VISUAL_EDITION_TAB_ITEM__ORDER_ATTRIBUTE = "order"; //$NON-NLS-1$
	
	/**
	 * Extension-point for condition event edition tabs
	 */
	public static final String CONDITION_EVENT_EDITION_TAB_ITEM = 
		PREFIX +"conditionEventEditionTabItem"; //$NON-NLS-1$
	
	public static final String CONDITION_EVENT_EDITION_TAB_ITEM__TAB_TAG = "tab"; //$NON-NLS-1$
	public static final String CONDITION_EVENT_EDITION_TAB_ITEM__CLASS_ATTRIBUTE = "class"; //$NON-NLS-1$
	public static final String CONDITION_EVENT_EDITION_TAB_ITEM__ORDER_ATTRIBUTE = "order"; //$NON-NLS-1$
	
	/**
	 * Extension-point for timer node edition tabs
	 */
	public static final String TIMER_NODE_EDITION_TAB_ITEM = 
		PREFIX +"timerNodeEditionTabItem"; //$NON-NLS-1$
	
	public static final String TIMER_NODE_EDITION_TAB_ITEM__TAB_TAG = "tab"; //$NON-NLS-1$
	public static final String TIMER_NODE_EDITION_TAB_ITEM__CLASS_ATTRIBUTE = "class"; //$NON-NLS-1$
	public static final String TIMER_NODE_EDITION_TAB_ITEM__ORDER_ATTRIBUTE = "order"; //$NON-NLS-1$

}
