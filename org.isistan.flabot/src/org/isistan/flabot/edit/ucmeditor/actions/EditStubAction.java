/**
 * $Id: EditStubAction.java,v 1.10 2006/03/21 01:51:56 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.ucmeditor.actions;

import java.util.List;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.ui.actions.SelectionAction;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IWorkbenchPart;
import org.isistan.flabot.coremodel.StubNode;
import org.isistan.flabot.edit.editor.CommandExecutor;
import org.isistan.flabot.edit.editor.commands.NotifierCommandWrapper;
import org.isistan.flabot.edit.editormodel.NodeVisualModel;
import org.isistan.flabot.edit.ucmeditor.commands.model.AddAssociatedNodeToFamilyCommand;
import org.isistan.flabot.edit.ucmeditor.commands.model.DeleteAssociatedNodeFromFamilyCommand;
import org.isistan.flabot.edit.ucmeditor.commands.model.ModifyStubCommand;
import org.isistan.flabot.edit.ucmeditor.dialogs.EditStubDialog;
import org.isistan.flabot.edit.ucmeditor.editparts.StubNodeEditPart;
import org.isistan.flabot.edit.ucmmodel.UCMDiagram;
import org.isistan.flabot.messages.Messages;

/**
 * This action is used to edit the properties of the selected stub node
 * 
 * @author $Author: franco $
 *
 */
public class EditStubAction extends SelectionAction {

	/**
	 * Action id
	 */
	public static final String
		EDIT_STUB = "EDIT_STUB";   //$NON-NLS-1$

	/**
	 * Creates a new EditStubAction in the given workbench part
	 * @param part
	 */
	public EditStubAction(IWorkbenchPart part) {
		super(part);
		
		setText(Messages.getString("org.isistan.flabot.edit.ucmeditor.actions.EditStubAction.text")); //$NON-NLS-1$
		setId(EDIT_STUB);
	}

	/**
	 * Determines whether the action should be enabled or not.
	 * @return true if a stub node is selected, false otherwise
	 */
	@Override
	protected boolean calculateEnabled() {
		return canPerformAction();
	}

	/**
	 * Determines whether the action should be enabled or not.
	 * @return true if a stub node is selected, false otherwise
	 */
	private boolean canPerformAction() {
		
		if (getSelectedObjects().isEmpty())
			return false;
		List parts = getSelectedObjects();
		
		if (parts.size() > 1) 
			return false;
		
		Object o = parts.get(0);
		if (!(o instanceof StubNodeEditPart))
			return false;
		
		return true;
	}

	/**
	 * Opens a dialog for the user to edit the selected stub node and then
	 * creates a command that executes the changes. 
	 * 
	 * @return the created command
	 */
	private Command getCommand() {
		List editparts = getSelectedObjects();
		StubNodeEditPart part = (StubNodeEditPart)editparts.get(0);
		NodeVisualModel visualNode = part.getCastedModel();
		
		StubNode stubNode = (StubNode) part.getCastedModel().getSemanticModel();		
		UCMDiagram diagram = (UCMDiagram) visualNode.getDiagram();
		
		EditStubDialog dialog = new EditStubDialog(Display.getCurrent().getActiveShell(), stubNode);		
		StubNode stubCopy = dialog.open(visualNode.getDiagram().getCoreModel().getUseCaseMaps(), diagram.getMap(), diagram.getCoreModel().getFamilies());
		
		//if the action was not cancelled
		if (stubCopy != null) {
			CompoundCommand commands = new CompoundCommand(Messages.getString("org.isistan.flabot.edit.ucmeditor.actions.EditStubAction.commandLabel"));  //$NON-NLS-1$
			
			if (stubNode.getFamily() != null)
				commands.add( new DeleteAssociatedNodeFromFamilyCommand(stubNode.getFamily(), stubNode));
			
			commands.add( new ModifyStubCommand(stubNode, stubCopy));
			
			if (stubCopy.getFamily() != null)
				commands.add( new AddAssociatedNodeToFamilyCommand(stubCopy.getFamily(), stubNode));
			
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