/**
 * $Id: DeleteOutlineAction.java,v 1.12 2006/03/17 22:28:02 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.editor.actions;

import java.util.List;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.requests.GroupRequest;
import org.eclipse.jface.action.Action;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.ActionFactory;
import org.isistan.flabot.edit.editor.CommandExecutor;
import org.isistan.flabot.messages.Messages;

/**
 * This action is used to delete models from the Outline.
 * 
 * @author $Author: franco $
 *
 */
public class DeleteOutlineAction extends Action {
	
	private EditPartViewer viewer;
	
	private CommandExecutor commandExecutor;

	/**
	 * Creates a new DeleteOutlineAction in the given viewer
	 * @param viewer
	 * @param commandExecutor
	 */
	public DeleteOutlineAction(EditPartViewer viewer, CommandExecutor commandExecutor) {
		this.viewer = viewer;
		this.commandExecutor = commandExecutor;
	
		setId(ActionFactory.DELETE.getId());
		setText(Messages.getString("org.isistan.flabot.edit.editor.actions.DeleteOutlineAction.text")); //$NON-NLS-1$
		setToolTipText(Messages.getString("org.isistan.flabot.edit.editor.actions.DeleteOutlineAction.toolTipText")); //$NON-NLS-1$
		ISharedImages sharedImages = PlatformUI.getWorkbench().getSharedImages(); 
		setImageDescriptor(sharedImages.getImageDescriptor(ISharedImages.IMG_TOOL_DELETE));
		setDisabledImageDescriptor(sharedImages.getImageDescriptor(ISharedImages.IMG_TOOL_DELETE_DISABLED));						
	}
	
	/**
	 * Determines whether the action should be enabled or not.
	 * @return true if the corresponding delete command exists and can be executed, false otherwise
	 */
	@Override
	public boolean isEnabled() {
		return calculateEnabled();
	}
		
	/**
	 * Determines whether the action should be enabled or not.
	 * @return true if the corresponding delete command exists and can be executed, false otherwise
	 */
	protected boolean calculateEnabled() {
		Command cmd = createDeleteCommand(getViewer().getSelectedEditParts());
		if (cmd == null)
			return false;
		return cmd.canExecute();
	}

	/**
	 * Creates and return a command to execute the deletion of the selected models.
	 * To get the deletetion commands, the selected edit parts are requested for it.
	 * 
	 * @param objects the selected models
	 * @return the deletion command
	 */
	public Command createDeleteCommand(List objects) {
		if (objects.isEmpty())
			return null;
		if (!(objects.get(0) instanceof EditPart))
			return null;

		GroupRequest deleteReq =
			new GroupRequest(RequestConstants.REQ_DELETE);

		CompoundCommand compoundCmd = new CompoundCommand(
			Messages.getString("org.isistan.flabot.edit.editor.actions.DeleteOutlineAction.commandLabel")); //$NON-NLS-1$
		for (int i = 0; i < objects.size(); i++) {
			EditPart object = (EditPart) objects.get(i);
			deleteReq.setEditParts(object);
			Command cmd = object.getCommand(deleteReq);
			if (cmd != null) compoundCmd.add(cmd);
		}

		return compoundCmd;
	}

	/**
	 * Creates a command and then executes it.
	 */
	@Override
	public void run() {
		Command command =  createDeleteCommand(getViewer().getSelectedEditParts());
		if (command == null || !command.canExecute())
			return;
		commandExecutor.executeCommand(command, true);
	}
	
	/**
	 * Returns the edit part viewer of this action
	 *  
	 * @return the edit part viewer
	 */
	public EditPartViewer getViewer() {
		return viewer;
	}
	
	/**
	 * Creates and return a command to execute the deletion of the selected models.
	 * To get the deletetion commands, the selected edit parts are requested for it.
	 *  
	 * @return the deletion command
	 */
	public Command getCommand() {
		List selection = getViewer().getSelectedEditParts();
		
		EditPart selectionEditPart = (EditPart) selection.get(0);
		GroupRequest r = new GroupRequest();
		r.setEditParts(selectionEditPart);
		r.setType(RequestConstants.REQ_DELETE);
		
		return selectionEditPart.getCommand(r);
	}
}