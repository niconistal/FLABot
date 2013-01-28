/**
 * $Id: EditResponsibilityNodeAction.java,v 1.8 2006/03/21 01:51:57 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.ucmeditor.actions;

import java.util.List;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.ui.actions.SelectionAction;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IWorkbenchPart;
import org.isistan.flabot.coremodel.ResponsibilityNode;
import org.isistan.flabot.edit.editor.CommandExecutor;
import org.isistan.flabot.edit.editor.commands.NotifierCommandWrapper;
import org.isistan.flabot.edit.editor.dialogs.StandardEditionDialog;
import org.isistan.flabot.edit.editormodel.NodeVisualModel;
import org.isistan.flabot.edit.ucmeditor.dialogs.responsibilitynode.ResponsibilityNodeEditionItem;
import org.isistan.flabot.edit.ucmeditor.dialogs.responsibilitynode.ResponsibilityNodeVisualEditionItem;
import org.isistan.flabot.edit.ucmeditor.editparts.PathNodeEditPart;
import org.isistan.flabot.messages.Messages;
import org.isistan.flabot.util.edition.DataAdapter;
import org.isistan.flabot.util.edition.IdentityDataAdapter;
import org.isistan.flabot.util.edition.tab.EditionTabItem;
import org.isistan.flabot.util.edition.tab.EditionTabItemContainerImpl;
import org.isistan.flabot.util.problems.MessageAccumulator;
import org.isistan.flabot.util.problems.log.LoggerMessageAccumulator;

/**
 * This action is used to edit the properties of the selected responsibility node
 * 
 * @author $Author: franco $
 *
 */
public class EditResponsibilityNodeAction extends SelectionAction {
	
	/**
	 * Action id
	 */
	public static final String
		EDIT_RESPONSIBILITY = "EDIT_RESPONSIBILITY";   //$NON-NLS-1$

	/**
	 * Creates a new EditResponsibilityNodeAction in the given workbench part
	 * @param part
	 */
	public EditResponsibilityNodeAction(IWorkbenchPart part) {
		super(part);
		
		setText(Messages.getString("org.isistan.flabot.edit.ucmeditor.actions.EditResponsibilityAction.text")); //$NON-NLS-1$
		setId(EDIT_RESPONSIBILITY);
	}

	/**
	 * Determines whether the action should be enabled or not.
	 * @return true if a responsibility node is selected, false otherwise
	 */
	@Override
	protected boolean calculateEnabled() {
		return canPerformAction();
	}

	/**
	 * Determines whether the action should be enabled or not.
	 * @return true if a responsibility node is selected, false otherwise
	 */
	private boolean canPerformAction() {
		
		if (getSelectedObjects().isEmpty())
			return false;
		List parts = getSelectedObjects();
		
		if (parts.size() > 1) 
			return false;
		
		Object o = parts.get(0);
		if (!(o instanceof PathNodeEditPart))
			return false;
		
		PathNodeEditPart part = (PathNodeEditPart)o;
		if (!(part.getCastedModel().getSemanticModel() instanceof ResponsibilityNode))
			return false;
		
		return true;
	}

	/**
	 * Opens a dialog for the user to edit the selected resonsibility node and then
	 * creates a command that executes the changes, that include pre and post condition modification (add/remove/modify) and responsibility properties (name, description, show dependencies or not).
	 * 
	 * @return the created command
	 */
	private Command getCommand() {
		List editparts = getSelectedObjects();
		PathNodeEditPart part = (PathNodeEditPart)editparts.get(0);
		NodeVisualModel visualNode = part.getCastedModel();

		MessageAccumulator messageAccumulator=
			new LoggerMessageAccumulator();
		
		DataAdapter<NodeVisualModel, ResponsibilityNode> visualModelToResponsibilityNodeAdapter=
			new DataAdapter<NodeVisualModel, ResponsibilityNode>() {

				public ResponsibilityNode adapt(NodeVisualModel data) {
					return (ResponsibilityNode)data.getSemanticModel();
				}
			
		};
		EditionTabItem<NodeVisualModel> semanticEditionItem=
			new EditionTabItemContainerImpl(Messages.getString("org.isistan.flabot.edit.ucmeditor.actions.EditResponsibilityNodeAction.semanticTabName"), //$NON-NLS-1$
					Messages.getString("org.isistan.flabot.edit.ucmeditor.actions.EditResponsibilityNodeAction.semanticCommandLabel"), //$NON-NLS-1$
					visualModelToResponsibilityNodeAdapter,
					ResponsibilityNodeEditionItem.LOADER.getEditionItems(
							messageAccumulator));
		
		EditionTabItem<NodeVisualModel> visualEditionItem=
			new EditionTabItemContainerImpl(Messages.getString("org.isistan.flabot.edit.ucmeditor.actions.EditResponsibilityNodeAction.visualTabName"), //$NON-NLS-1$
					Messages.getString("org.isistan.flabot.edit.ucmeditor.actions.EditResponsibilityNodeAction.visualCommandLabel"), //$NON-NLS-1$
					new IdentityDataAdapter<NodeVisualModel>(),
					ResponsibilityNodeVisualEditionItem.LOADER.getEditionItems(
							messageAccumulator));
		
		StandardEditionDialog<NodeVisualModel> dialog =
			new StandardEditionDialog<NodeVisualModel>(
					Display.getCurrent().getActiveShell(),
					Messages.getString("org.isistan.flabot.edit.ucmeditor.dialogs.EditResponsibilityNodeDialog.title"), //$NON-NLS-1$
					Messages.getString("org.isistan.flabot.edit.ucmeditor.actions.EditResponsibilityNodeAction.dialogCommandLabel"), //$NON-NLS-1$
					new EditionTabItem[] {
						semanticEditionItem,
						visualEditionItem});
		
		return dialog.open(visualNode);
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