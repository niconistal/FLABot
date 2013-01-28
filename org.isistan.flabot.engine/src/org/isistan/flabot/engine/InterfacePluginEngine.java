package org.isistan.flabot.engine;

import org.isistan.flabot.edit.multipage.FlabotMultiPageEditor;
import org.isistan.flabot.executionmodel.ExecutionInfoManager;
import org.isistan.flabot.executionmodel.ExecutionmodelFactory;

/**
 * @author $Author: franco $
 */

public abstract class InterfacePluginEngine {
	
	public static final String PLUGIN_ENGINE_NAME = "org.isistan.flabot.engine"; //$NON-NLS-1$
	public static final String PLUGIN_ENGINE_MANAGER_INFO_EXECUTION = "PLUGIN_ENGINE_MANAGER_INFO_EXECUTION"; //$NON-NLS-1$
	
	public static ExecutionInfoManager getExecutionInfoManager(FlabotMultiPageEditor editor){
		ExecutionInfoManager manager = (ExecutionInfoManager)editor.getExtendedData(InterfacePluginEngine.PLUGIN_ENGINE_NAME, InterfacePluginEngine.PLUGIN_ENGINE_MANAGER_INFO_EXECUTION);
		if (manager==null){
			manager = ExecutionmodelFactory.eINSTANCE.createExecutionInfoManager();
			editor.putExtendedData(InterfacePluginEngine.PLUGIN_ENGINE_NAME, InterfacePluginEngine.PLUGIN_ENGINE_MANAGER_INFO_EXECUTION, manager);
		}
		return manager;
	}
}