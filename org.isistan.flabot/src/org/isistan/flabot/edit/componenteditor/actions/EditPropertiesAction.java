/**

import java.util.List;
 * This actions is used to edit component digram elements' properties
 * @author $Author: franco $
 *
 */
public class EditPropertiesAction extends SelectionAction {

	/**
	 * Action id
	 */
	public static final String
		EDIT_PROPERTIES = "Edit.Properties";   //$NON-NLS-1$

	
	/**
	 * Creates a new EditPropertiesAction in the given workbench part
	 * @param part
	 */
	public EditPropertiesAction(IWorkbenchPart part) {
		super(part);

		setText(Messages.getString("org.isistan.flabot.edit.componenteditor.actions.EditPropertiesAction.text")); //$NON-NLS-1$
		setId(EDIT_PROPERTIES);		
	}

	/**
	 * Determies if the action should be enabled.
	 * @return true if there is only one component, port or relationship selected, false otherwise
	 */
	@Override
	protected boolean calculateEnabled() {
		return canPerformAction();
	}

	/**
	 * Determies if the action should be enabled.
	 * @return true if there is only one component, port or relationship selected, false otherwise
	 */
	private boolean canPerformAction() {	
		if (getSelectedObjects().isEmpty()) return false;
		
		List parts = getSelectedObjects();		
		if (parts.size() > 1) return false;
		
		Object o = parts.get(0);
		if (o instanceof PortEditPart
			|| o instanceof RelationshipConnectionEditPart) 
			return true;
		
		return false;
	}

	/**
	 * Shows a dialog to edit properties and then creates a new command that performs the editing action (if not cancelled)
	 * @return The created command
	 */
	private Command getCommand() {
		List editparts = getSelectedObjects();
		AbstractGraphicalEditPart part = (AbstractGraphicalEditPart)editparts.get(0);		
		VisualModel visualModel = (VisualModel)part.getModel();		
		PropertyElementModel propertyModel = (PropertyElementModel)visualModel.getSemanticModel();
		
		StandardEditionDialog<PropertyElementModel> dialog =
	}

	
	/**
	 * Executes the edition (creating a command)
	 */
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