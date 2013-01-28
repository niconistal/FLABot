/**

import java.util.List;
public class ArrangeAction extends SelectionAction {

	public static final String
		ARRANGE = "ARRANGE";   //$NON-NLS-1$

	private String arrange;

	public ArrangeAction(IWorkbenchPart part, String arrange) {
		super(part);
	
		setId(ARRANGE + arrange);
		
		this.arrange = arrange;
		
		if(ArrangeCommand.BRING_TO_FRONT.equals(arrange)){
			setText(Messages.getString("org.isistan.flabot.edit.editor.actions.ArrangeAction.bringToFront")); //$NON-NLS-1$
			setImageDescriptor(ImageDescriptor.createFromFile(FlabotPlugin.class, "icons/bring_to_front.gif")); //$NON-NLS-1$
		}
		else
		if(ArrangeCommand.BRING_FORWARD.equals(arrange)){
			setText(Messages.getString("org.isistan.flabot.edit.editor.actions.ArrangeAction.bringForward")); //$NON-NLS-1$
			setImageDescriptor(ImageDescriptor.createFromFile(FlabotPlugin.class, "icons/bring_forward.gif")); //$NON-NLS-1$
		}
		else
		if(ArrangeCommand.SEND_BACKWARD.equals(arrange)){
			setText(Messages.getString("org.isistan.flabot.edit.editor.actions.ArrangeAction.sendBackward")); //$NON-NLS-1$
			setImageDescriptor(ImageDescriptor.createFromFile(FlabotPlugin.class, "icons/send_backward.gif")); //$NON-NLS-1$
		}
		else
		if(ArrangeCommand.SEND_TO_BACK.equals(arrange)){
			setText(Messages.getString("org.isistan.flabot.edit.editor.actions.ArrangeAction.sendToBack")); //$NON-NLS-1$
			setImageDescriptor(ImageDescriptor.createFromFile(FlabotPlugin.class, "icons/send_to_back.gif")); //$NON-NLS-1$
		}
		else
			throw new IllegalArgumentException();
	}

	protected boolean calculateEnabled() {
		return canPerformAction();
	}

	/**
		List selection = getSelectedObjects();
		if (selection == null ||
				selection.isEmpty()) return false;
			
		if (selection.size() > 1) return false;
		
		Object o = selection.get(0);		
		if (o instanceof org.isistan.flabot.edit.componenteditor.editparts.ComponentEditPart ||
				o instanceof org.isistan.flabot.edit.ucmeditor.editparts.ComponentEditPart || o instanceof NoteEditPart) {
			return true;
		}
		return false;
	}

	/**
	private Command getCommand() {
		List editparts = getSelectedObjects();
		EditPart componentEditPart = (EditPart)editparts.get(0);	
		VisualModel componentModel = ((VisualModel) componentEditPart.getModel());
		return new ArrangeCommand(componentModel, arrange);
	}
	
	public void run() {
		CommandExecutor commandExecutor = (CommandExecutor)getWorkbenchPart().getAdapter(CommandExecutor.class);
		commandExecutor.executeCommand(getCommand(), false);
	}
}