/**
 * $Id: EditVisualizationAction.java,v 1.14 2006/04/08 05:10:13 dacostae Exp $
 * $Author: dacostae $
 */
package org.isistan.flabot.edit.editor.actions;

import java.util.List;

import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.eclipse.gef.ui.actions.SelectionAction;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IWorkbenchPart;
import org.isistan.flabot.edit.componenteditor.editparts.RelationshipConnectionEditPart;
import org.isistan.flabot.edit.editor.CommandExecutor;
import org.isistan.flabot.edit.editor.dialogs.StandardEditionDialog;
import org.isistan.flabot.edit.editor.dialogs.editionitem.EditVisualizationTabItem;
import org.isistan.flabot.messages.Messages;
import org.isistan.flabot.util.edition.tab.EditionTabItem;

/**
 * This action is used to edit the visual properties of ComponentEditPart and RelationshipConnectionEditPart.
 * 
 * @author $Author: dacostae $
 *
 */
public class EditVisualizationAction extends SelectionAction {
	
	/**
	 * Action id
	 */
	public static final String
		EDIT_VISUALIZATION = "Edit.Visualization";  //$NON-NLS-1$
	
	private int style = 0;
	
	/**
	 * Creates a new EditVisualizationAction in the given workbench part
	 * @param part
	 */
	public EditVisualizationAction(IWorkbenchPart part) {
		super(part);
		
		setText(Messages.getString("org.isistan.flabot.edit.editor.actions.EditVisualizationAction.text")); //$NON-NLS-1$
		setToolTipText(Messages.getString("org.isistan.flabot.edit.editor.actions.EditVisualizationAction.toolTipText")); //$NON-NLS-1$
		setId(EDIT_VISUALIZATION);
		setEnabled(false);	
	}

	/**
	 * Determines whether the action should be enabled or not.
	 * @return if a ComponentEditPart or RelationshipConnectionEditPart is selected, otherwise false 
	 */
	@Override
	protected boolean calculateEnabled() {
		return canPerformAction();
	}

	/**
	 * Determines whether the action should be enabled or not.
	 * @return if a ComponentEditPart or RelationshipConnectionEditPart is selected, otherwise false 
	 */
	private boolean canPerformAction() {	
		List selection = getSelectedObjects();
		if (selection == null ||
				selection.isEmpty()) return false;
			
		if (selection.size() > 1) return false;
		
		Object o = selection.get(0);		
		if (o instanceof org.isistan.flabot.edit.ucmeditor.editparts.ComponentEditPart) {
			style = EditVisualizationTabItem.BACKGROUND_COLOR_PROPERTY |
					EditVisualizationTabItem.FOREGROUND_COLOR_PROPERTY |
					EditVisualizationTabItem.LINE_STYLE_PROPERTY |
					EditVisualizationTabItem.SIZE_PROPERTY;
			return true;
		}
		
		if (o instanceof RelationshipConnectionEditPart) {
			style = EditVisualizationTabItem.FOREGROUND_COLOR_PROPERTY |
					EditVisualizationTabItem.LINE_STYLE_PROPERTY |
					EditVisualizationTabItem.LINE_WIDTH_PROPERTY;
			return true;
		}		
		
		return false;
	}
	
	/**
	 * Opens the dialog so the user can edit the visual properties of the selected model.
	 * Then creates a command to apply the changes.
	 * 
	 * @return
	 */
	protected Command getCommand() {
		AbstractGraphicalEditPart part = (AbstractGraphicalEditPart)getSelectedObjects().get(0);		
		
		StandardEditionDialog<GraphicalEditPart> dialog =
			new StandardEditionDialog<GraphicalEditPart>(
					Display.getCurrent().getActiveShell(),
					Messages.getString("org.isistan.flabot.edit.editor.actions.EditVisualizationAction.dialogName"), //$NON-NLS-1$
					Messages.getString("org.isistan.flabot.edit.editor.actions.EditVisualizationAction.commandName"), //$NON-NLS-1$
					new EditionTabItem[] {
						new EditVisualizationTabItem(style)});
		
		
		return dialog.open(part);
	}
	
	/**
	 * Shows an edition dialog, creates a command and then executes it.
	 */
	@Override
	public void run() {
		CommandExecutor commandExecutor = (CommandExecutor)getWorkbenchPart().getAdapter(CommandExecutor.class);
		commandExecutor.executeCommand(getCommand(), false);
	}		
}