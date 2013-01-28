/**
 * $Id: EditOrForkAction.java,v 1.7 2006/03/21 01:51:57 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.ucmeditor.actions;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.ui.actions.SelectionAction;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IWorkbenchPart;
import org.isistan.flabot.coremodel.ForkCondition;
import org.isistan.flabot.coremodel.ForkNode;
import org.isistan.flabot.edit.componenteditor.commands.model.ModifyNamedElementCommand;
import org.isistan.flabot.edit.editor.CommandExecutor;
import org.isistan.flabot.edit.editor.commands.NotifierCommandWrapper;
import org.isistan.flabot.edit.editormodel.VisualModel;
import org.isistan.flabot.edit.ucmeditor.commands.model.ModifyForkConditionCommand;
import org.isistan.flabot.edit.ucmeditor.dialogs.EditOrForkConditionsDialog;
import org.isistan.flabot.edit.ucmeditor.editparts.ForkNodeEditPart;
import org.isistan.flabot.messages.Messages;

/**
 * This action is used to edit the properties of the selected or fork node
 * 
 * @author $Author: franco $
 *
 */
public class EditOrForkAction extends SelectionAction {

	/**
	 * Action id
	 */
	public static final String
		EDIT_OR_FORK = "EDIT_OR_FORK";   //$NON-NLS-1$

	/**
	 * Creates a new EditOrForkAction in the given workbench part
	 * @param part
	 */
	public EditOrForkAction(IWorkbenchPart part) {
		super(part);
		
		setText(Messages.getString("org.isistan.flabot.edit.ucmeditor.actions.EditOrForkAction.text")); //$NON-NLS-1$
		setId(EDIT_OR_FORK);
	}

	/**
	 * Determines whether the action should be enabled or not.
	 * @return true if an or fork node is selected, false otherwise
	 */
	@Override
	protected boolean calculateEnabled() {
		return canPerformAction();
	}

	/**
	 * Determines whether the action should be enabled or not.
	 * @return true if an or fork node is selected, false otherwise
	 */
	private boolean canPerformAction() {
		
		if (getSelectedObjects().isEmpty())
			return false;
		List parts = getSelectedObjects();
		
		if (parts.size() > 1) 
			return false;
		
		Object o = parts.get(0);
		if (!(o instanceof ForkNodeEditPart))
			return false;
		
		VisualModel visual = (VisualModel) ((ForkNodeEditPart) o).getModel();
		
		return ((ForkNode)visual.getSemanticModel()).getForkType() == ForkNode.OR_FORK_TYPE;
	}

	/**
	 * Opens a dialog for the user to edit the selected or fork node and then
	 * creates a command that executes the changes. 
	 * 
	 * @return the created command
	 */
	private Command getCommand() {
		List editparts = getSelectedObjects();
		ForkNodeEditPart part = (ForkNodeEditPart)editparts.get(0);	
		ForkNode forkNode = (ForkNode) part.getCastedModel().getSemanticModel();		
	
		EditOrForkConditionsDialog dialog = new EditOrForkConditionsDialog(Display.getCurrent().getActiveShell());	
		int exitValue = dialog.open(forkNode.getName(), forkNode.getConditions());
		
		//if the action was not cancelled
		CompoundCommand compound = new CompoundCommand(Messages.getString("org.isistan.flabot.edit.ucmeditor.actions.EditOrForkAction.commandLabel")); //$NON-NLS-1$
		if (exitValue == SWT.OK) {
			Map map = dialog.getModifyForkConditionsMap();
			for (Iterator iter = map.keySet().iterator(); iter.hasNext();) {
				ForkCondition forkCondition = (ForkCondition) iter.next();
				compound.add( new ModifyForkConditionCommand(forkCondition, (ForkCondition) map.get(forkCondition)));
			}
			
			String newName = dialog.getNewName();
			if (!newName.equals(forkNode.getName()))
				compound.add( new ModifyNamedElementCommand(forkNode.getResponsibility(), newName));
		}

		return compound;
	}

	/**
	 * Shows an edition dialog, creates a command and then executes it.
	 */
	@Override
	public void run() {
		Command command = getCommand();
		if (command != null) {
			command = new NotifierCommandWrapper(command,
					getWorkbenchPart().getSite().getShell());
			CommandExecutor commandExecutor = (CommandExecutor)getWorkbenchPart().getAdapter(CommandExecutor.class);
			commandExecutor.executeCommand(command, false);
		}
	}

}