/**

import java.util.ArrayList;

	private final CoreModel coreModel;
	private final Responsibility resp;
	private List componentList = new ArrayList();
	
	public DeleteResponsibilityCommand (CoreModel coreModel, Responsibility resp) {
		this.coreModel = coreModel;
		this.resp = resp;
		setLabel(Messages.getString("org.isistan.flabot.edit.ucmeditor.commands.model.DeleteResponsibilityCommand.label")); //$NON-NLS-1$
	}
	
	public void execute() {
		List list = coreModel.getComponents();
		for (Iterator iter = list.iterator(); iter.hasNext(); ) {
			ComponentModel component = (ComponentModel) iter.next();
			if (component.getFeatures().contains(resp))
					componentList.add(component);
		}
		
		redo();		
	}
		
	/* (non-Javadoc)
	 * @see org.eclipse.gef.commands.Command#redo()
	 */
	public void redo() {
		for (Iterator iter = componentList.iterator(); iter.hasNext(); ) {
			ComponentModel component = (ComponentModel) iter.next();
			component.getFeatures().remove(resp);
		}
		coreModel.getResponsibilities().remove(resp);	
	}
	
	public void undo() {
		for (Iterator iter = componentList.iterator(); iter.hasNext(); ) {
			ComponentModel component = (ComponentModel) iter.next();
			component.getFeatures().add(resp);
		}		
		coreModel.getResponsibilities().add(resp);		
	}
}