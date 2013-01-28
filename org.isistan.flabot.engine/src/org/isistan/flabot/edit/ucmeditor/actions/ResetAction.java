/** * $Id: ResetAction.java,v 1.12 2006/04/04 03:29:05 franco Exp $ * $Author: franco $ */package org.isistan.flabot.edit.ucmeditor.actions;

import java.util.HashMap;import java.util.List;import java.util.Map;import org.eclipse.gef.ui.actions.SelectionAction;import org.eclipse.ui.IWorkbenchPart;import org.isistan.flabot.FlabotPlugin;import org.isistan.flabot.coremodel.CoreModel;import org.isistan.flabot.coremodel.ResponsibilityNode;import org.isistan.flabot.edit.editor.FlabotGraphicalEditor;import org.isistan.flabot.edit.editormodel.FlabotFileModel;import org.isistan.flabot.edit.editormodel.NodeVisualModel;import org.isistan.flabot.edit.ucmeditor.editparts.PathNodeEditPart;import org.isistan.flabot.engine.EnginePlugin;import org.isistan.flabot.engine.InterfacePluginEngine;import org.isistan.flabot.engine.RuntimeManager;import org.isistan.flabot.engine.locator.FlabotEngineLocator;import org.isistan.flabot.engine.messages.Messages;import org.isistan.flabot.util.locator.ComponentLocatorException;import org.isistan.flabot.util.locator.ComponentLocatorManager;/** * Action that resets the fault location engine * @author usuario * */public class ResetAction extends SelectionAction{
	
	public static final String
		RESET = "RESET";   //$NON-NLS-1$		private RuntimeManager runtimeManager;

	public ResetAction(IWorkbenchPart part) {
		super(part);

		setText(Messages.getString("org.isistan.flabot.edit.ucmeditor.actions.ResetAction.text")); //$NON-NLS-1$
		setId(RESET);
	}	
	
	@Override	protected boolean calculateEnabled() {
		return canPerformAction();
	}
		/**	 * Check whether the action can be performed or not	 * @return	 */
	private boolean canPerformAction() {
		if (getSelectedObjects().isEmpty())
			return false;
		List parts = getSelectedObjects();
		
		if (parts.size() > 1) 
			return false;
		
		Object o = parts.get(0);
		if (!(o instanceof PathNodeEditPart))
			return false;
		
		PathNodeEditPart part = (PathNodeEditPart)o;
		if (!(part.getSemanticModel() instanceof ResponsibilityNode))
			return false;				if (getRuntimeManager() == null || !getRuntimeManager().isActive())			return false;		
		return true;
	}
		private RuntimeManager getRuntimeManager() {		if (runtimeManager == null) {			List editparts = getSelectedObjects();			PathNodeEditPart part = (PathNodeEditPart)editparts.get(0);			ResponsibilityNode responsibilityNode =				(ResponsibilityNode)part.getSemanticModel();						FlabotFileModel flabotFileModel = responsibilityNode.getMap()			.getCoreModel().getFile();			// add the file model to the parameters map			Map parameters = new HashMap(2);			parameters.put(FlabotEngineLocator.PARAMETER_FLABOT_FILE_MODEL,					flabotFileModel);			parameters.put(FlabotEngineLocator.PARAMETER_EXECUTION_INFO_MANAGER,					InterfacePluginEngine.getExecutionInfoManager(((FlabotGraphicalEditor)getWorkbenchPart()).getParent()));									// obtain a reference to the component locator manager			ComponentLocatorManager locatorManager =			FlabotPlugin.getDefault().getComponentLocatorManager();						try {				runtimeManager = (RuntimeManager)				locatorManager.getComponent(FlabotEngineLocator.LOCATOR_ID,						parameters);			}catch (ComponentLocatorException e) {				EnginePlugin.getDefault().getLogger().error(						Messages.getString("org.isistan.flabot.edit.ucmeditor.actions.RunEngineAction.executionError"),e); //$NON-NLS-1$				return null;			}	  		}		return runtimeManager;	}		/**	 * Execute the action	 */
	@Override	public void run() {
		List editparts = getSelectedObjects();
		PathNodeEditPart part = (PathNodeEditPart)editparts.get(0);				NodeVisualModel visualNode = part.getCastedModel();
		CoreModel coreModel = visualNode.getDiagram().getCoreModel();
		
		ResponsibilityNode responsibilityNode =
			(ResponsibilityNode)part.getSemanticModel();
		// obtain the flabot file model parameter
		FlabotFileModel flabotFileModel = responsibilityNode.getMap()
			.getCoreModel().getFile();
		// add the file model to the parameters map
		Map parameters = new HashMap(2);		parameters.put(FlabotEngineLocator.PARAMETER_FLABOT_FILE_MODEL,				flabotFileModel);		parameters.put(FlabotEngineLocator.PARAMETER_EXECUTION_INFO_MANAGER,				InterfacePluginEngine.getExecutionInfoManager(((FlabotGraphicalEditor)getWorkbenchPart()).getParent()));		
		// obtain a reference to the component locator manager
		ComponentLocatorManager locatorManager =
			FlabotPlugin.getDefault().getComponentLocatorManager();
		try {
			// ask the locator manager to find a runtime manager reference
			RuntimeManager runtimeManager = (RuntimeManager)
				locatorManager.getComponent(FlabotEngineLocator.LOCATOR_ID,
						parameters);
			// finally, reset the runtime manager
			runtimeManager.reset(coreModel);
		} catch (ComponentLocatorException e) {
			EnginePlugin.getDefault().getLogger().error(
					Messages.getString("org.isistan.flabot.edit.ucmeditor.actions.ResetAction.componentLocatorError"), e); //$NON-NLS-1$
		} catch (Exception e) {
			EnginePlugin.getDefault().getLogger().error(
					Messages.getString("org.isistan.flabot.edit.ucmeditor.actions.ResetAction.exceptionError"), e); //$NON-NLS-1$
		}
	}
}