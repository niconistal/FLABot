/** * $Id: AssignResponsibilitiesAction.java,v 1.4 2006/03/21 01:51:55 franco Exp $ * $Author: franco $ */package org.isistan.flabot.edit.componenteditor.actions;

import java.util.Collection;import java.util.HashSet;import java.util.LinkedList;import java.util.List;import java.util.Set;import org.eclipse.gef.commands.CompoundCommand;import org.eclipse.gef.ui.actions.SelectionAction;import org.eclipse.swt.widgets.Display;import org.eclipse.ui.IWorkbenchPart;import org.isistan.flabot.coremodel.ComponentModel;import org.isistan.flabot.coremodel.CoreModel;import org.isistan.flabot.coremodel.Responsibility;import org.isistan.flabot.edit.componenteditor.commands.model.AddResponsibilityToComponentCommand;import org.isistan.flabot.edit.componenteditor.commands.model.DeleteResponsibilityFromComponentCommand;import org.isistan.flabot.edit.componenteditor.editparts.ComponentEditPart;import org.isistan.flabot.edit.editor.dialogs.ResponsibilitySelectionDialog;import org.isistan.flabot.edit.editormodel.NodeVisualModel;import org.isistan.flabot.messages.Messages;/** * This action is used to assign responsibilities to the selected component. *  * @author $Author: franco $ * */
public class AssignResponsibilitiesAction extends SelectionAction {	/**	 * Action id	 */
	public static final String
		ASSIGN_RESPONSIBILITIES = "Assign.Responsibilities";   //$NON-NLS-1$
	/**	 * Creates a new EditResponsibilityAction in the given workbench part	 * @param part	 */
	public AssignResponsibilitiesAction(IWorkbenchPart part) {
		super(part);

		setText(Messages.getString("org.isistan.flabot.edit.componenteditor.actions.AssignResponsibilityAction.text")); //$NON-NLS-1$
		setId(ASSIGN_RESPONSIBILITIES);	
	}
	/**	 * Determines if the action should be enabled.	 * @return true if the diagram or if exactly one component is selected, false otherwise.  	 */	@Override
	protected boolean calculateEnabled() {
		return canPerformAction();
	}

	/**	 * Determines if the action should be enabled.	 * @return true if the diagram or if exactly one component is selected, false otherwise.  	 */	private boolean canPerformAction() {	
		if (getSelectedObjects().isEmpty()) return false;
		
		List parts = getSelectedObjects();		
		if (parts.size() > 1) return false;
		
		Object o = parts.get(0);
		if (o instanceof ComponentEditPart) 
			return true;
		
		return false;
	}

	/**	 * Opens a dialog to assign the responsabilities, creates a command and executes it	 */	@Override
	public void run() {
		ComponentEditPart part = (ComponentEditPart)getSelectedObjects().get(0);				ComponentModel component=(ComponentModel) ((NodeVisualModel)part.getModel()).getSemanticModel();		CoreModel coreModel=(CoreModel) ((NodeVisualModel)part.getModel()).getDiagram().getCoreModel();		ResponsibilitySelectionDialog dialog = new ResponsibilitySelectionDialog(Display.getCurrent().getActiveShell(), getCommandStack(), coreModel);		Set<Responsibility> oldResponsibilities=new HashSet<Responsibility>();		for (Object feature : component.getFeatures()) {			if(feature instanceof Responsibility) {				oldResponsibilities.add((Responsibility) feature);			}		}				Collection<Responsibility> newResponsibilities=dialog.openCheckboxes(Display.getCurrent().getActiveShell(),				Messages.getString("org.isistan.flabot.edit.componenteditor.actions.AssignResponsibilitiesAction.assingResponsibilities"), //$NON-NLS-1$				Messages.getString("org.isistan.flabot.edit.componenteditor.actions.AssignResponsibilitiesAction.selectResponsibilityToAssign"), //$NON-NLS-1$				component.getCoreModel().getResponsibilities(),				oldResponsibilities				);		if(newResponsibilities==null) {			return;		}		List<Responsibility> assignResp=new LinkedList<Responsibility>();		List<Responsibility> deassignResp=new LinkedList<Responsibility>();		for (Responsibility responsibility : newResponsibilities) {			if(!oldResponsibilities.contains(responsibility)) {				assignResp.add(responsibility);			}		}		for (Responsibility responsibility : oldResponsibilities) {			if(!newResponsibilities.contains(responsibility)) {				deassignResp.add(responsibility);			}		}		CompoundCommand command=new CompoundCommand(Messages.getString("org.isistan.flabot.edit.componenteditor.actions.AssignResponsibilitiesAction.assingResponsibilityCommand")); //$NON-NLS-1$		for (Responsibility responsibility : deassignResp) {			command.add(new DeleteResponsibilityFromComponentCommand(component, responsibility));		}		for (Responsibility responsibility : assignResp) {			command.add(new AddResponsibilityToComponentCommand(component, responsibility));		}		if(command.size()>0) {			getCommandStack().execute(command);		}	}	
}