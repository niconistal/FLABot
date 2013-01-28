/** * $Id: EditStereotypesAction.java,v 1.24 2006/04/11 01:31:19 franco Exp $ * $Author: franco $ */package org.isistan.flabot.edit.componenteditor.actions;

import java.util.Iterator;import java.util.List;import java.util.Map;import org.eclipse.gef.commands.Command;import org.eclipse.gef.commands.CompoundCommand;import org.eclipse.gef.ui.actions.SelectionAction;import org.eclipse.jface.resource.ImageDescriptor;import org.eclipse.swt.SWT;import org.eclipse.swt.widgets.Display;import org.eclipse.ui.IWorkbenchPart;import org.isistan.flabot.FlabotPlugin;import org.isistan.flabot.coremodel.CoreModel;import org.isistan.flabot.coremodel.Stereotype;import org.isistan.flabot.edit.componenteditor.commands.model.AddStereotypeCommand;import org.isistan.flabot.edit.componenteditor.commands.model.DeleteStereotypeCommand;import org.isistan.flabot.edit.componenteditor.commands.model.ModifyStereotypeCommand;import org.isistan.flabot.edit.componenteditor.dialogs.StereotypeDialog;import org.isistan.flabot.edit.componenteditor.editparts.ComponentDiagramEditPart;import org.isistan.flabot.edit.componentmodel.ComponentDiagram;import org.isistan.flabot.edit.editor.CommandExecutor;import org.isistan.flabot.edit.editor.commands.NotifierCommandWrapper;import org.isistan.flabot.messages.Messages;/** * This action is used to edit the list of stereotypes *  * @author $Author: franco $ * */
public class EditStereotypesAction extends SelectionAction {
	/**	 * Action id	 */
	public static final String
		EDIT_STEREOTYPES = "Edit.Stereotypes";   //$NON-NLS-1$
	/**	 * Creates a new EditStereotypesAction in the given workbench part	 * @param part	 */
	public EditStereotypesAction(IWorkbenchPart part) {
		super(part);

		setText(Messages.getString("org.isistan.flabot.edit.componenteditor.actions.EditStereotypesAction.text")); //$NON-NLS-1$
		setId(EDIT_STEREOTYPES);		setImageDescriptor(ImageDescriptor.createFromFile(FlabotPlugin.class, "icons/stereotype.gif"));			 //$NON-NLS-1$
	}
	/**	 * Determines whether the action should be enabled or not.	 * @return true if the diagram is selected, false otherwise	 */	@Override
	protected boolean calculateEnabled() {
		return canPerformAction();
	}

	/**	 * Determines whether the action should be enabled or not.	 * @return true if the diagram is selected, false otherwise	 */	private boolean canPerformAction() {	
		if (getSelectedObjects().isEmpty()) return false;
		
		List parts = getSelectedObjects();		
		if (parts.size() > 1) return false;
		
		Object o = parts.get(0);
		if (o instanceof ComponentDiagramEditPart) 
			return true;
		
		return false;
	}
	/**	 * Opens a dialog for the user to edit the list of stereotypes and then	 * creates a command that executes the changes. 
	 * @return the created command
	 */
	private Command getCommand() {
		List editparts = getSelectedObjects();

		ComponentDiagramEditPart part = (ComponentDiagramEditPart)editparts.get(0);
		CoreModel coreModel = ((ComponentDiagram)part.getModel()).getCoreModel(); 
		
		StereotypeDialog dialog = new StereotypeDialog(Display.getCurrent().getActiveShell());		
		int exitValue = dialog.open(coreModel.getStereotypes());
		
		CompoundCommand compound = null;
		if (exitValue == SWT.OK) {
			compound = new CompoundCommand(Messages.getString("org.isistan.flabot.edit.componenteditor.actions.EditStereotypesAction.stereotypesEditionCommand")); //$NON-NLS-1$
			List l = dialog.getRemoveStereotypes();			for (Iterator iter = l.iterator(); iter.hasNext();)				compound.add(new DeleteStereotypeCommand(coreModel, (Stereotype) iter.next()));												l = dialog.getNewStereotypes();
			for (Iterator iter = l.iterator(); iter.hasNext();)
				compound.add(new AddStereotypeCommand(coreModel, (Stereotype) iter.next()));
			
			Map updatedStereotypes = dialog.getUpdatedStereotypes();
			for (Iterator iter = updatedStereotypes.keySet().iterator(); iter.hasNext();) {
				Stereotype stereotype = (Stereotype) iter.next();
				Stereotype newStereotype = (Stereotype) updatedStereotypes.get(stereotype);
				compound.add(new ModifyStereotypeCommand(stereotype, newStereotype));
			}
			
		}
		return compound;
	}
		/**	 * Shows an edition dialog, creates a comamand and then executes it.	 */	@Override
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