package org.isistan.flabot.executionstatemapping.editor.actions;

import java.util.List;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.ui.actions.SelectionAction;
import org.eclipse.swt.custom.BusyIndicator;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.internal.Workbench;
import org.isistan.flabot.edit.editor.CommandExecutor;
import org.isistan.flabot.edit.editormodel.VisualModel;
import org.isistan.flabot.edit.multipage.FlabotMultiPageEditor;
import org.isistan.flabot.executionstatemapping.InterfacePluginExecutionStateMapping;
import org.isistan.flabot.executionstatemapping.dialogs.common.ExecutionConditionEditorBuilder;
import org.isistan.flabot.executionstatemapping.editor.editparts.TransitionConditionConnectionEditPart;
import org.isistan.flabot.executionstatemapping.messages.Messages;
import org.isistan.flabot.executionstatemapping.model.semantic.TransitionCondition;

public class EditExecutionConditionAction extends SelectionAction {
	
	/**
	 * Action id
	 */
	public static final String
		EDIT_EXECUTIONCONDITION = "Edit.ExecutionCondition";  //$NON-NLS-1$
	
	protected TransitionCondition selectedTransitionCondition;
	
	public EditExecutionConditionAction(IWorkbenchPart part) {
		super(part);
		
		setText(Messages.getString("org.isistan.flabot.executionmapping.editor.actions.EditExecutionConditionAction.actionText")); //$NON-NLS-1$
		setToolTipText(Messages.getString("org.isistan.flabot.executionmapping.editor.actions.EditExecutionConditionAction.actionTooltip")); //$NON-NLS-1$
		setId(EDIT_EXECUTIONCONDITION);
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
		if (o instanceof TransitionConditionConnectionEditPart) 
		{
			VisualModel visualModel = (VisualModel) ((TransitionConditionConnectionEditPart)o).getModel();
			selectedTransitionCondition = (TransitionCondition) visualModel.getSemanticModel(); 
			return (selectedTransitionCondition.getExecutionCondition() != null);
		}
		
		return false;
	}
	
	protected Command getCommand()
	{		
		return ExecutionConditionEditorBuilder.showEditExecutionConditionDialog(selectedTransitionCondition.getExecutionCondition(), InterfacePluginExecutionStateMapping.getFileModel(getEditor()));
	}	
	
	@Override
	public void run() 
	{
		BusyIndicator.showWhile(Display.getCurrent(), new Runnable() {
			public void run() {
				CommandExecutor commandExecutor = (CommandExecutor)getWorkbenchPart().getAdapter(CommandExecutor.class);
				commandExecutor.executeCommand(getCommand(), false);
			}
		});
	}	
	
	@SuppressWarnings("restriction") //$NON-NLS-1$
	private FlabotMultiPageEditor getEditor()
	{
		return (FlabotMultiPageEditor) Workbench.getInstance().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
	}
}