/**
 * $Id: PasteAction.java,v 1.10 2006/03/21 01:51:55 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.editor.actions;

import java.util.List;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.ui.actions.Clipboard;
import org.eclipse.gef.ui.actions.SelectionAction;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.ActionFactory;
import org.isistan.flabot.edit.editor.CommandExecutor;
import org.isistan.flabot.edit.editor.FlabotGraphicalEditor;
import org.isistan.flabot.edit.editor.commands.paste.RetargetParentPasteCommand;
import org.isistan.flabot.edit.editormodel.FlabotFileModel;
import org.isistan.flabot.messages.Messages;

/**
 * This action is used to paste models.
 * 
 * @author $Author: franco $
 *
 */
public class PasteAction extends SelectionAction {
	
	/**
	 * Creates a new PasteAction in the given workbench part
	 * @param part
	 */
	public PasteAction(IWorkbenchPart part) {
		super(part);

		setId(ActionFactory.PASTE.getId());
		setText(Messages.getString("org.isistan.flabot.edit.editor.actions.PasteAction.text")); //$NON-NLS-1$
		setToolTipText(Messages.getString("org.isistan.flabot.edit.editor.actions.PasteAction.toolTipText")); //$NON-NLS-1$
		ISharedImages sharedImages = PlatformUI.getWorkbench().getSharedImages(); 
		setImageDescriptor(sharedImages.getImageDescriptor(ISharedImages.IMG_TOOL_PASTE));
		setDisabledImageDescriptor(sharedImages.getImageDescriptor(ISharedImages.IMG_TOOL_PASTE_DISABLED));
		setEnabled(false);						
	}

	/**
	 * Determines whether the action should be enabled or not.
	 * @return true if the contents of the Clipboard are correct (contains the FlabotFileModel and the list of commands), otherwise false
	 */
	@Override
	protected boolean calculateEnabled() {
		return canPerformAction();
	}

	/**
	 * Determines whether the action should be enabled or not.
	 * @return true if the contents of the Clipboard are correct (contains the FlabotFileModel and the list of commands), otherwise false
	 */
	private boolean canPerformAction() {			
		List selection = getSelectedObjects();
		if (selection == null ||
				selection.isEmpty()) return false;
		
		Object o = Clipboard.getDefault().getContents();
		if (o == null || !(o instanceof List))
			return false;
		
		FlabotFileModel modelCopy = (FlabotFileModel) ((List)o).get(0);
		FlabotFileModel model = ((FlabotGraphicalEditor)getWorkbenchPart()).getModel().getCoreModel().getFile();
		if (modelCopy != model)
			return false;
		
		return true;
	}
	
	/**
	 * Gets the paste commands from the Clipboard and executes the commands that are valid,
	 * according to the place where the object want to be pasted (selected object).
	 * 
	 * @return the paste command
	 */
	public Command getCommand() {
		List selection = getSelectedObjects();
		Object target = ((EditPart)selection.get(0)).getModel();
		
		CompoundCommand commands = new CompoundCommand();
		List copyEditParts = (List)Clipboard.getDefault().getContents();
		
		for (int i=1; i<copyEditParts.size(); i++) {
			RetargetParentPasteCommand copy = (RetargetParentPasteCommand) copyEditParts.get(i);			
			Command command = copy.clone();
			RetargetParentPasteCommand retarget = (RetargetParentPasteCommand) command;
			if (retarget.isValidParent(target)) {
				retarget.setParent(target);
				commands.add(command);
			}
		}
		return commands;
	}
	
	/**
	 * Executes the correct paste commands from the Clipboard.
	 */
	public void run() {
		CommandExecutor commandExecutor = (CommandExecutor)getWorkbenchPart().getAdapter(CommandExecutor.class);
		commandExecutor.executeCommand(getCommand(), false);
	}
}