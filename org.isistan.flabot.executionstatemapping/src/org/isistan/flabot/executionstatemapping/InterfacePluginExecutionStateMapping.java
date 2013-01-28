package org.isistan.flabot.executionstatemapping;

import java.util.List;

import org.isistan.flabot.edit.multipage.FlabotMultiPageEditor;
import org.isistan.flabot.executionstatemapping.model.ExecutionStateMappingFileModel;
import org.isistan.flabot.executionstatemapping.model.ModelFactory;
import org.isistan.flabot.executionstatemapping.model.visual.StateDiagram;

/**
 * @author $Author: franco $
 */

public abstract class InterfacePluginExecutionStateMapping {
	
	public static final String PLUGIN_EXECUTIONSTATEMAPPING_FILEMODEL = "executionStateMappingFileModel"; //$NON-NLS-1$
	
	public static List<StateDiagram> getStateDiagramsList(FlabotMultiPageEditor editor){
		return getFileModel(editor).getStateDiagramsList();
	}
	
	public synchronized static ExecutionStateMappingFileModel getFileModel(FlabotMultiPageEditor editor)
	{
		ExecutionStateMappingFileModel fileModel= (ExecutionStateMappingFileModel)editor.getModel().getExtendedData(ExecutionConditionPlugin.PLUGIN_ID, InterfacePluginExecutionStateMapping.PLUGIN_EXECUTIONSTATEMAPPING_FILEMODEL);
		if (fileModel == null)
		{
			fileModel = ModelFactory.eINSTANCE.createExecutionStateMappingFileModel();;
			editor.getModel().putExtendedData(ExecutionConditionPlugin.PLUGIN_ID, PLUGIN_EXECUTIONSTATEMAPPING_FILEMODEL, fileModel);
		}
		return fileModel;
	}
}