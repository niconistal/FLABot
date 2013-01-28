/**
 * $Id: RunEngineAction.java,v 1.24 2006/04/12 03:58:09 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.ucmeditor.actions;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.gef.ui.actions.SelectionAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IPerspectiveDescriptor;
import org.eclipse.ui.IWorkbenchPart;
import org.isistan.flabot.FlabotPlugin;
import org.isistan.flabot.coremodel.CoreModel;
import org.isistan.flabot.coremodel.ResponsibilityNode;
import org.isistan.flabot.edit.editor.FlabotGraphicalEditor;
import org.isistan.flabot.edit.editor.actions.RunConsistencyCheckAction;
import org.isistan.flabot.edit.editormodel.FlabotFileModel;
import org.isistan.flabot.edit.editormodel.NodeVisualModel;
import org.isistan.flabot.edit.ucmeditor.editparts.PathNodeEditPart;
import org.isistan.flabot.engine.EnginePlugin;
import org.isistan.flabot.engine.InterfacePluginEngine;
import org.isistan.flabot.engine.RuntimeManager;
import org.isistan.flabot.engine.locator.FlabotEngineLocator;
import org.isistan.flabot.engine.messages.Messages;
import org.isistan.flabot.util.locator.ComponentLocatorException;
import org.isistan.flabot.util.locator.ComponentLocatorManager;

/**
 * This action is used to run the Fault Locator Engine.
 * It is active when a responsibility node is selected, so the execution can begin.
 * 
 * @author $Author: franco $
 *
 */
public class RunEngineAction extends SelectionAction{
	
	/**
	 * Action id
	 */
	public static final String
		RUN_ENGINE = "RUN_ENGINE";   //$NON-NLS-1$

	private IPerspectiveDescriptor perspective;
		
	private RuntimeManager runtimeManager;
	
	/**
	 * Creates a run engine action in the given workbench part
	 * @param part
	 */
	public RunEngineAction(IWorkbenchPart part) {
		super(part);

		setText(Messages.getString("org.isistan.flabot.engine.RunEngineAction.runEngine")); //$NON-NLS-1$
		setId(RUN_ENGINE);
		perspective = part.getSite().getWorkbenchWindow().getWorkbench().getPerspectiveRegistry().findPerspectiveWithId("org.isistan.flabot.engine.perspective"); //$NON-NLS-1$
	}	

	/**
	 * Determines whether the action should be enabled or not.
	 * @return true if selection consists of only a responsibility node (responsibilities, forks and joins), false otherwise
	 */
	@Override
	protected boolean calculateEnabled() {
		return canPerformAction();
	}

	/**
	 * Determines whether the action should be enabled or not.
	 * @return true if selection consists of only a responsibility node (responsibilities, forks and joins), false otherwise
	 */
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
			return false;
	
		if (getRuntimeManager() == null || !getRuntimeManager().isActive())
			return false;
		
		setText(Messages.getString("org.isistan.flabot.engine.RunEngineAction.runEngineAt", ((ResponsibilityNode)part.getSemanticModel()).getName())); //$NON-NLS-1$
		return true;
	
	}

	private RuntimeManager getRuntimeManager() {
		if (runtimeManager == null) {
			List editparts = getSelectedObjects();
			PathNodeEditPart part = (PathNodeEditPart)editparts.get(0);
			ResponsibilityNode responsibilityNode =
				(ResponsibilityNode)part.getSemanticModel();
			
			FlabotFileModel flabotFileModel = responsibilityNode.getMap()
			.getCoreModel().getFile();
			// add the file model to the parameters map
			Map parameters = new HashMap(2);
			parameters.put(FlabotEngineLocator.PARAMETER_FLABOT_FILE_MODEL,
					flabotFileModel);
			parameters.put(FlabotEngineLocator.PARAMETER_EXECUTION_INFO_MANAGER,
					InterfacePluginEngine.getExecutionInfoManager(((FlabotGraphicalEditor)getWorkbenchPart()).getParent()));
			
			
			// obtain a reference to the component locator manager
			ComponentLocatorManager locatorManager =
			FlabotPlugin.getDefault().getComponentLocatorManager();
			
			try {
				runtimeManager = (RuntimeManager)
				locatorManager.getComponent(FlabotEngineLocator.LOCATOR_ID,
						parameters);
			}catch (ComponentLocatorException e) {
				EnginePlugin.getDefault().getLogger().error(
						Messages.getString("org.isistan.flabot.edit.ucmeditor.actions.RunEngineAction.executionError"),e); //$NON-NLS-1$
				return null;
			}	  
		}
		return runtimeManager;
	}
			
	/**
	 * Executes the Fault Locator Engine. It also asks the user if want to change to FLABot Engine perspective.
	 */
	@Override
	public void run() {
		
		List editparts = getSelectedObjects();
		PathNodeEditPart part = (PathNodeEditPart)editparts.get(0);
		NodeVisualModel visualNode = part.getCastedModel();
		ResponsibilityNode responsibilityNode =
			(ResponsibilityNode)part.getSemanticModel();
		// obtain the flabot file model parameter
		FlabotFileModel flabotFileModel = responsibilityNode.getMap()
			.getCoreModel().getFile();
		
// workaround to bypass the consistency dialog because of compatibility problems
		//RunConsistencyCheckAction checkAction = new RunConsistencyCheckAction(getWorkbenchPart());
	//	checkAction.setFlabotFileModel(flabotFileModel);
		if(true){ //if (checkAction.isEnabled()) {
	/*		checkAction.run();
			if (checkAction.getExitValue() == SWT.CANCEL)
				return;
			
			if (checkAction.getTotalErrrors() > 0) {				
				MessageDialog dlg = new MessageDialog(
						Display.getCurrent().getActiveShell(),
						Messages.getString("org.isistan.flabot.edit.ucmeditor.actions.RunEngineAction.errorsFoundDialogTitle"), //$NON-NLS-1$
			            null,
			            Messages.getString("org.isistan.flabot.edit.ucmeditor.actions.RunEngineAction.errorsFoundDialogDescription"), //$NON-NLS-1$
			            MessageDialog.ERROR,
			            new String[]{"Run anyway", "Cancel"}, //$NON-NLS-1$
			            0);
			    
				if (dlg.open() == 0)
			    	runEngine(flabotFileModel, responsibilityNode, visualNode.getDiagram().getCoreModel());				
			
			} else {*/
				runEngine(flabotFileModel, responsibilityNode, visualNode.getDiagram().getCoreModel());
			//}
		}
	}
	
	private void runEngine(FlabotFileModel flabotFileModel,
			ResponsibilityNode responsibilityNode, CoreModel coreModel) {
		openPerspective();
		
		// add the file model to the parameters map
		Map parameters = new HashMap(2);
		parameters.put(FlabotEngineLocator.PARAMETER_FLABOT_FILE_MODEL,
				flabotFileModel);
		parameters.put(FlabotEngineLocator.PARAMETER_EXECUTION_INFO_MANAGER,
				InterfacePluginEngine.getExecutionInfoManager(((FlabotGraphicalEditor)getWorkbenchPart()).getParent()));

		// obtain a reference to the component locator manager
		ComponentLocatorManager locatorManager =
			FlabotPlugin.getDefault().getComponentLocatorManager();
		try {
			// ask the locator manager to find a runtime manager reference
			RuntimeManager runtimeManager = (RuntimeManager)
				locatorManager.getComponent(FlabotEngineLocator.LOCATOR_ID,
						parameters);
			// finally, add the execution info to the runtime manager
			runtimeManager.addExecutionInfo(responsibilityNode,	coreModel);
			if (!runtimeManager.getReady()){
				runtimeManager.start();
			}
			else
				runtimeManager.setExecute(true);
		} catch (ComponentLocatorException e) {
			EnginePlugin.getDefault().getLogger().error(
					Messages.getString("org.isistan.flabot.engine.RunEngineAction.exceptionTryingToLocateTheFlabotEngine"), e); //$NON-NLS-1$
		}
	}	
	
	/**
	 * Asks the user if want to change to FLABot Engine perspective.
	 */
	private void openPerspective() {
		if (perspective != getWorkbenchPart().getSite().getWorkbenchWindow().getActivePage().getPerspective()) {
			boolean answer = MessageDialog.openQuestion(
					Display.getCurrent().getActiveShell(),
					Messages.getString("org.isistan.flabot.engine.RunEngineAction.switchPespective"), //$NON-NLS-1$
					Messages.getString("org.isistan.flabot.engine.RunEngineAction.perspectiveQuestion")); //$NON-NLS-1$

			if (answer)
				getWorkbenchPart().getSite().getWorkbenchWindow().getActivePage().setPerspective(perspective);
		}
	}
}