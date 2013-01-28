/**

import java.util.List;
public class EditResponsibilitiesAction extends SelectionAction {
	public static final String
		EDIT_RESPONSIBILITIES = "Edit.Responsibilities";   //$NON-NLS-1$

	public EditResponsibilitiesAction(IWorkbenchPart part) {
		super(part);

		setText(Messages.getString("org.isistan.flabot.edit.componenteditor.actions.EditResponsibilitiesAction.text")); //$NON-NLS-1$
		setId(EDIT_RESPONSIBILITIES);
	}

	protected boolean calculateEnabled() {
		return canPerformAction();
	}

	/**
		if (getSelectedObjects().isEmpty()) return false;
		
		List parts = getSelectedObjects();		
		if (parts.size() > 1) return false;
		
		Object o = parts.get(0);
		if (!(o instanceof ComponentDiagramEditPart)) 
			return false;
		
		return true;
	}

	/**
	public void run() {
		EditPart part = (EditPart)getSelectedObjects().get(0);		
	}	
}