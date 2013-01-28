package org.isistan.flabot.edit.ucmeditor.actions;

import java.util.List;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.ui.actions.SelectionAction;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IWorkbenchPart;
import org.isistan.flabot.coremodel.DynamicStubNode;
import org.isistan.flabot.edit.editor.CommandExecutor;
import org.isistan.flabot.edit.editor.commands.NotifierCommandWrapper;
import org.isistan.flabot.edit.editormodel.NodeVisualModel;
import org.isistan.flabot.edit.ucmeditor.commands.model.ModifyDynamicStubCommand;
import org.isistan.flabot.edit.ucmeditor.dialogs.DynamicStubManagerDialog;
import org.isistan.flabot.edit.ucmeditor.dialogs.EditDynamicStubDialog;
import org.isistan.flabot.edit.ucmeditor.editparts.DynamicStubNodeEditPart;
import org.isistan.flabot.edit.ucmmodel.UCMDiagram;
import org.isistan.flabot.messages.Messages;

/**
 * 
 * @author $Author: Martin Villalba $
 *
 */
public class EditDynamicStubAction extends SelectionAction {

			/**
			 * Action id
			 */
			public static final String
				EDIT_DYNAMIC_STUB = "EDIT_DYNAMIC_STUB";   //$NON-NLS-1$

			/**
			 * Creates a new EditDynamicStubAction in the given workbench part
			 * @param part
			 */
			public EditDynamicStubAction(IWorkbenchPart part) {
				super(part);
				
				setText(Messages.getString("org.isistan.flabot.edit.ucmeditor.actions.EditDynamicStubAction.text")); //$NON-NLS-1$
				setId(EDIT_DYNAMIC_STUB);
			}

			/**
			 * Determines whether the action should be enabled or not.
			 * @return true if a dynamic stub node is selected, false otherwise
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
				if (!(o instanceof DynamicStubNodeEditPart))
					return false;
				
				return true;
			}

			/**
			 * Opens a dialog for the user to edit the selected dynamic stub node and then
			 * creates a command that executes the changes. 
			 * 
			 * @return the created command
			 */
			private Command getCommand() {
				List editparts = getSelectedObjects();
				DynamicStubNodeEditPart part = (DynamicStubNodeEditPart)editparts.get(0);
				NodeVisualModel visualNode = part.getCastedModel();
				
				DynamicStubNode dynamicStubNode = (DynamicStubNode) part.getCastedModel().getSemanticModel();		
				UCMDiagram diagram = (UCMDiagram) visualNode.getDiagram();
				
				EditDynamicStubDialog dialog = new EditDynamicStubDialog(Display.getCurrent().getActiveShell(), dynamicStubNode, getCommandStack());
				Command dynamicStubEditCommands = dialog.open((UCMDiagram)visualNode.getDiagram(), dynamicStubNode);
				
				//if the action was not cancelled
				//if (dynamicStubEditCommands != null) {
//					CompoundCommand commands = new CompoundCommand(Messages.getString("org.isistan.flabot.edit.ucmeditor.actions.EditDynamicStubAction.commandLabel"));  //$NON-NLS-1$
//					
//					commands.add(dynamicStubEditCommands);
//					commands.add( new ModifyDynamicStubCommand(dynamicStubNode, dynamicStubCopy, visualNode.getDiagram().getCoreModel()));					
					return dynamicStubEditCommands;
				//}

				//return null;
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
