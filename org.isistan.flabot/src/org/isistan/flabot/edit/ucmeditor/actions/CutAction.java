/**
 * $Id: CutAction.java,v 1.9 2006/03/15 23:36:26 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.ucmeditor.actions;

import java.util.List;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.requests.GroupRequest;
import org.eclipse.gef.ui.actions.Clipboard;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.ActionFactory;
import org.isistan.flabot.edit.editor.CommandExecutor;
import org.isistan.flabot.messages.Messages;

/**
 * This action cuts elements from the UCM diagram
 * @author $Author: franco $
 *
 */
public class CutAction extends CopyAction {

	/**
	 * Creates a new CutAction in the given workbench part
	 * @param part
	 */
	public CutAction(IWorkbenchPart part) {
		super(part);
		
		setId(ActionFactory.CUT.getId());
		setText(Messages.getString("org.isistan.flabot.edit.editor.actions.CutAction.text")); //$NON-NLS-1$
		setToolTipText(Messages.getString("org.isistan.flabot.edit.editor.actions.CutAction.toolTipText")); //$NON-NLS-1$
		ISharedImages sharedImages = PlatformUI.getWorkbench().getSharedImages(); 
		setImageDescriptor(sharedImages.getImageDescriptor(ISharedImages.IMG_TOOL_CUT));
		setDisabledImageDescriptor(sharedImages.getImageDescriptor(ISharedImages.IMG_TOOL_CUT_DISABLED));
		setEnabled(false);							
	}
	
	/**
	 * Creates a command that performs the cutting.
	 * The delete command is requested to each selected edit part.
	 * @return The created command
	 */
	public Command getCommand() {
		List selection = getSelectedObjects();
				
		CompoundCommand commands = new CompoundCommand(Messages.getString("org.isistan.flabot.edit.editor.actions.CutAction.text"));  //$NON-NLS-1$
		for (int i=0; i<selection.size(); i++) {
			EditPart selectionEditPart = (EditPart) selection.get(i);
			GroupRequest request = new GroupRequest();
			request.setEditParts(selectionEditPart);
			request.setType(RequestConstants.REQ_DELETE);
			commands.add(selectionEditPart.getCommand(request));
		}
		return commands;		
	}
					
	/**
	 * Executes the cutting (using a command)
	 */
	@Override
	public void run() {
		Clipboard.getDefault().setContents(getCopyCommandsList());

		Command command = getCommand();
		CommandExecutor commandExecutor = (CommandExecutor)getWorkbenchPart().getAdapter(CommandExecutor.class);
		commandExecutor.executeCommand(command, false);
	}
}