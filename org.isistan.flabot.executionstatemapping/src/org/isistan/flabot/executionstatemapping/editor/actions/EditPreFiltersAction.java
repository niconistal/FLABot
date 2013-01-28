package org.isistan.flabot.executionstatemapping.editor.actions;

import java.util.List;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.ui.actions.SelectionAction;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.internal.Workbench;
import org.isistan.flabot.edit.editor.CommandExecutor;
import org.isistan.flabot.edit.multipage.FlabotMultiPageEditor;
import org.isistan.flabot.executionstatemapping.InterfacePluginExecutionStateMapping;
import org.isistan.flabot.executionstatemapping.commands.diagram.AssignPreFiltersToStateContainerCommand;
import org.isistan.flabot.executionstatemapping.dialogs.ExecutionConditionFilterDialog;
import org.isistan.flabot.executionstatemapping.editor.editparts.StateDiagramEditPart;
import org.isistan.flabot.executionstatemapping.messages.Messages;
import org.isistan.flabot.executionstatemapping.model.semantic.ExecutionCondition;
import org.isistan.flabot.executionstatemapping.model.semantic.StateContainer;
import org.isistan.flabot.executionstatemapping.model.visual.StateDiagram;

public class EditPreFiltersAction extends SelectionAction {
	
	/**
	 * Action id
	 */
	public static final String
		EDIT_PREFILTERS = "Edit.PreFilters";  //$NON-NLS-1$
	
	private StateContainer stateContainer;
	
	public EditPreFiltersAction(IWorkbenchPart part) {
		super(part);
		
		setText(Messages.getString("org.isistan.flabot.executionmapping.editor.actions.EditPreFiltersAction.actionText")); //$NON-NLS-1$
		setToolTipText(Messages.getString("org.isistan.flabot.executionmapping.editor.actions.EditPreFiltersAction.actionTooltip")); //$NON-NLS-1$
		setId(EDIT_PREFILTERS);
	}
	
	@Override
	protected boolean calculateEnabled() {
		return canPerformAction();
	}
	
	@SuppressWarnings("unchecked") //$NON-NLS-1$
	private boolean canPerformAction() {	
		List selection = getSelectedObjects();
		if (selection == null ||
				selection.isEmpty()) 
		{
			return false;
		}
			
		if (selection.size() > 1)
		{
			return false;
		}
		
		Object o = selection.get(0);		
		if (o instanceof StateDiagramEditPart) 
		{
			stateContainer = (StateContainer) ((StateDiagram)((StateDiagramEditPart)o).getModel()).getSemanticModel();
			return true;
		}
		
		return false;
	}
	
	protected Command getCommand() {
		
		ExecutionConditionFilterDialog executionConditionDialog = new ExecutionConditionFilterDialog();
		executionConditionDialog.build(Messages.getString("org.isistan.flabot.executionmapping.editor.actions.EditPreFiltersAction.preFilters"), InterfacePluginExecutionStateMapping.getFileModel(getEditor()), null, null); //$NON-NLS-1$
		List<ExecutionCondition> newPreFilters = executionConditionDialog.showDialog(stateContainer.getPreFilters());
		
		if (newPreFilters != null)
		{
			return new AssignPreFiltersToStateContainerCommand(stateContainer, newPreFilters);
		}		
		return null;
	}
	
	@Override
	public void run() 
	{
		CommandExecutor commandExecutor = (CommandExecutor)getWorkbenchPart().getAdapter(CommandExecutor.class);
		commandExecutor.executeCommand(getCommand(), false);
	}
	
	@SuppressWarnings("restriction") //$NON-NLS-1$
	private FlabotMultiPageEditor getEditor()
	{
		return (FlabotMultiPageEditor) Workbench.getInstance().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
	}
}