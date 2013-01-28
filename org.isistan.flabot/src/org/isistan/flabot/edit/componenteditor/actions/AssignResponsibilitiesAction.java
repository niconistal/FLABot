/**

import java.util.Collection;
public class AssignResponsibilitiesAction extends SelectionAction {
	public static final String
		ASSIGN_RESPONSIBILITIES = "Assign.Responsibilities";   //$NON-NLS-1$

	public AssignResponsibilitiesAction(IWorkbenchPart part) {
		super(part);

		setText(Messages.getString("org.isistan.flabot.edit.componenteditor.actions.AssignResponsibilityAction.text")); //$NON-NLS-1$
		setId(ASSIGN_RESPONSIBILITIES);	
	}

	protected boolean calculateEnabled() {
		return canPerformAction();
	}

	/**
		if (getSelectedObjects().isEmpty()) return false;
		
		List parts = getSelectedObjects();		
		if (parts.size() > 1) return false;
		
		Object o = parts.get(0);
		if (o instanceof ComponentEditPart) 
			return true;
		
		return false;
	}

	/**
	public void run() {
		ComponentEditPart part = (ComponentEditPart)getSelectedObjects().get(0);
}