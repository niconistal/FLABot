/**
 * $Id: RunFamilyManagerAction.java,v 1.3 2006/03/21 01:51:55 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.editor.actions;

import java.util.List;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.ui.actions.SelectionAction;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IWorkbenchPart;
import org.isistan.flabot.edit.componenteditor.editparts.ComponentDiagramEditPart;
import org.isistan.flabot.edit.editor.CommandExecutor;
import org.isistan.flabot.edit.editor.FlabotGraphicalEditor;
import org.isistan.flabot.edit.editormodel.Diagram;
import org.isistan.flabot.edit.ucmeditor.dialogs.FamilyDialog;
import org.isistan.flabot.edit.ucmeditor.editparts.UCMDiagramEditPart;
import org.isistan.flabot.messages.Messages;

/**
 * This action is used to add/edit/remove Families
 * 
 * @author $Author: franco $
 *
 */
public class RunFamilyManagerAction extends SelectionAction{
	
	/**
	 * Action id
	 */
	public static final String
		RUN_FAMILY_MANAGER = "RUN_FAMILY_MANAGER";   //$NON-NLS-1$
	
	/**
	 * Creates a new RunFamilyManagerAction in the given workbench part
	 * @param part
	 */
	public RunFamilyManagerAction(IWorkbenchPart part) {
		super(part);
		setText(Messages.getString("org.isistan.flabot.edit.editor.actions.RunFamilyManagerAction.text")); //$NON-NLS-1$
		setId(RUN_FAMILY_MANAGER);
	}	

	/**
	 * Determines whether the action should be enabled or not.
	 * @return true if one object is selected, false otherwise
	 */
	@Override
	protected boolean calculateEnabled() {
		return canPerformAction();
	}

	/**
	 * Determines whether the action should be enabled or not.
	 * @return true if one object is selected, false otherwise
	 */
	private boolean canPerformAction() {
	
		if (getSelectedObjects().isEmpty())
			return false;
		List parts = getSelectedObjects();
		
		if (parts.size() > 1) 
			return false;
		
		Object o = parts.get(0);
		return (o instanceof UCMDiagramEditPart  ||
				o instanceof ComponentDiagramEditPart);
	}

	/**
	 * Opens a dialog to edit Families, it returns the commands given by the dialog.
	 * 
	 * @return the created command
	 */
	public Command getCommand() {
		Diagram diagram = ((FlabotGraphicalEditor)getWorkbenchPart()).getModel();
		FamilyDialog managerdialog = new FamilyDialog(Display.getCurrent().getActiveShell());
		
		return managerdialog.open(diagram.getCoreModel(), diagram.getCoreModel().getArchitecturalUseCaseMaps(), diagram.getCoreModel().getFunctionalUseCaseMaps(), diagram.getCoreModel().getFamilies());	
		//return managerdialog.open(diagram.getCoreModel(), diagram.getCoreModel().getArchitecturalUseCaseMaps(), diagram.getCoreModel().getUseCaseMaps(), diagram.getCoreModel().getFamilies());	

	}
	
	/**
	 * Creates a command and then executes it.
	 */
	@Override
	public void run() {
		Command command = getCommand();
		CommandExecutor commandExecutor = (CommandExecutor)getWorkbenchPart().getAdapter(CommandExecutor.class);
		commandExecutor.executeCommand(command, false);
	}
}