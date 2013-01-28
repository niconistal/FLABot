package org.isistan.flabot.edit.ucmeditor.actions;

import java.util.List;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.ui.actions.SelectionAction;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IWorkbenchPart;
import org.isistan.flabot.coremodel.ComponentModel;
import org.isistan.flabot.coremodel.ComponentRole;
import org.isistan.flabot.coremodel.TimerNode;
import org.isistan.flabot.edit.editor.CommandExecutor;
import org.isistan.flabot.edit.editor.commands.NotifierCommandWrapper;
import org.isistan.flabot.edit.editormodel.NodeVisualModel;
import org.isistan.flabot.edit.ucmeditor.commands.model.ModifyComponentCommand;
import org.isistan.flabot.edit.ucmeditor.commands.model.ModifyTimerCommand;
import org.isistan.flabot.edit.ucmeditor.dialogs.EditComponentDialog;
import org.isistan.flabot.edit.ucmeditor.dialogs.EditTimerDialog;
import org.isistan.flabot.edit.ucmeditor.editparts.ComponentEditPart;
import org.isistan.flabot.edit.ucmeditor.editparts.PathNodeEditPart;
import org.isistan.flabot.edit.ucmeditor.editparts.TimerNodeEditPart;
import org.isistan.flabot.edit.ucmeditor.editparts.UCMDiagramEditPart;
import org.isistan.flabot.edit.ucmmodel.UCMDiagram;
import org.isistan.flabot.messages.Messages;

/**
 * 
 * @author $Author: Martin Villalba $
 *
 */
public class EditComponentAction extends SelectionAction {
	
	/**
	 * Action id
	 */
	public static final String
		EDIT_COMPONENT = "EDIT_COMPONENT";   //$NON-NLS-1$

	/**
	 * Creates a new EditComponentAction in the given workbench part
	 * @param part
	 */
	public EditComponentAction(IWorkbenchPart part) {
		super(part);
		
		setText(Messages.getString("org.isistan.flabot.edit.ucmeditor.actions.EditComponentAction.text")); //$NON-NLS-1$
		setId(EDIT_COMPONENT);
	}

	/**
	 * Determines whether the action should be enabled or not.
	 * @return true if a component is selected, false otherwise
	 */
	@Override
	protected boolean calculateEnabled() {
		return canPerformAction();
	}

	/**
	 * Determines whether the action should be enabled or not.
	 * @return true if a component is selected, false otherwise
	 */
	private boolean canPerformAction() {
		
		if (getSelectedObjects().isEmpty())
			return false;
		List parts = getSelectedObjects();
		
		if (parts.size() > 1) 
			return false;
		
		Object o = parts.get(0);
		if ( !(o instanceof ComponentEditPart))
			return false;
		
		return true;
	}

	/**
	 * Opens a dialog for the user to edit the selected component and then
	 * creates a command that executes the changes, that include pre and post condition modification (add/remove/modify) and responsibility properties (name, description, show dependencies or not).
	 * 
	 * @return the created command
	 */
	private Command getCommand() {		
		List editparts = getSelectedObjects();
		ComponentEditPart part = (ComponentEditPart)editparts.get(0);
		NodeVisualModel visualNode = (NodeVisualModel)part.getModel();
		
		ComponentRole componentRole = (ComponentRole) visualNode.getSemanticModel();		
		//UCMDiagram diagram = (UCMDiagram) visualNode.getDiagram();
		
		EditComponentDialog dialog = new EditComponentDialog(Display.getCurrent().getActiveShell(), componentRole.getComponent());		
		ComponentModel componentCopy = dialog.open();
		
		//if the action was not cancelled
		if (componentCopy != null) {
			CompoundCommand commands = new CompoundCommand(Messages.getString("org.isistan.flabot.edit.ucmeditor.actions.EditComponentAction.commandLabel"));  //$NON-NLS-1$
			
			commands.add( new ModifyComponentCommand(componentRole.getComponent(), componentCopy));
			
			return commands;
		}

		return null;
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
