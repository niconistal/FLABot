/** * $Id: EditResponsibilitiesAction.java,v 1.4 2006/03/21 01:51:55 franco Exp $ * $Author: franco $ */package org.isistan.flabot.edit.componenteditor.actions;

import java.util.List;import org.eclipse.gef.EditPart;import org.eclipse.gef.ui.actions.SelectionAction;import org.eclipse.jface.resource.ImageDescriptor;import org.eclipse.swt.widgets.Display;import org.eclipse.ui.IWorkbenchPart;import org.isistan.flabot.FlabotPlugin;import org.isistan.flabot.coremodel.CoreModel;import org.isistan.flabot.edit.componenteditor.dialogs.ResponsibilitiesDialog;import org.isistan.flabot.edit.componenteditor.editparts.ComponentDiagramEditPart;import org.isistan.flabot.edit.componentmodel.ComponentDiagram;import org.isistan.flabot.messages.Messages;/** * This action is used to edit responsibilities. *   * @author $Author: franco $ * */
public class EditResponsibilitiesAction extends SelectionAction {	/**	 * Action id	 */
	public static final String
		EDIT_RESPONSIBILITIES = "Edit.Responsibilities";   //$NON-NLS-1$
	/**	 * Creates a new EditResponsibilityAction in the given workbench part	 * @param part	 */
	public EditResponsibilitiesAction(IWorkbenchPart part) {
		super(part);

		setText(Messages.getString("org.isistan.flabot.edit.componenteditor.actions.EditResponsibilitiesAction.text")); //$NON-NLS-1$
		setId(EDIT_RESPONSIBILITIES);		setImageDescriptor(ImageDescriptor.createFromFile(FlabotPlugin.class, "icons/responsibility.gif"));	 //$NON-NLS-1$
	}
	/**	 * Determines if the action should be enabled.	 * @return true if the diagram or if exactly one component is selected, false otherwise.  	 */	@Override
	protected boolean calculateEnabled() {
		return canPerformAction();
	}

	/**	 * Determines if the action should be enabled.	 * @return true if the component diagram is selected, false otherwise.  	 */	private boolean canPerformAction() {	
		if (getSelectedObjects().isEmpty()) return false;
		
		List parts = getSelectedObjects();		
		if (parts.size() > 1) return false;
		
		Object o = parts.get(0);
		if (!(o instanceof ComponentDiagramEditPart)) 
			return false;
		
		return true;
	}

	/**	 * Opens a dialog to edit the responsabilities, creates a command and executes it	 */	@Override
	public void run() {
		EditPart part = (EditPart)getSelectedObjects().get(0);				CoreModel coreModel = ((ComponentDiagram)part.getModel()).getCoreModel();							ResponsibilitiesDialog dialog = new ResponsibilitiesDialog(Display.getCurrent().getActiveShell(), getCommandStack());				dialog.open(coreModel, coreModel.getResponsibilities());
	}	
}