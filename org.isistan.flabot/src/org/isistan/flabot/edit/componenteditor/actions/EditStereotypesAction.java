/**

import java.util.Iterator;
public class EditStereotypesAction extends SelectionAction {

	public static final String
		EDIT_STEREOTYPES = "Edit.Stereotypes";   //$NON-NLS-1$

	public EditStereotypesAction(IWorkbenchPart part) {
		super(part);

		setText(Messages.getString("org.isistan.flabot.edit.componenteditor.actions.EditStereotypesAction.text")); //$NON-NLS-1$
		setId(EDIT_STEREOTYPES);
	}

	protected boolean calculateEnabled() {
		return canPerformAction();
	}

	/**
		if (getSelectedObjects().isEmpty()) return false;
		
		List parts = getSelectedObjects();		
		if (parts.size() > 1) return false;
		
		Object o = parts.get(0);
		if (o instanceof ComponentDiagramEditPart) 
			return true;
		
		return false;
	}

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
			List l = dialog.getRemoveStereotypes();
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