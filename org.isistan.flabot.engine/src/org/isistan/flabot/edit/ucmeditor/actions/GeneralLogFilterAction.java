/**

import org.eclipse.gef.commands.Command;
	
	public static final String
		GENERAL_LOG_FILTER = "GENERAL_LOG_FILTER";   //$NON-NLS-1$

	public GeneralLogFilterAction(IWorkbenchPart part) {
		super(part);

		setText(Messages.getString("org.isistan.flabot.edit.ucmeditor.actions.GeneralLogFilterAction.text")); //$NON-NLS-1$
		setId(GENERAL_LOG_FILTER);
	}	
	
	@Override
		return canPerformAction();
	}
	
	private boolean canPerformAction() {
		return true;
	}
}