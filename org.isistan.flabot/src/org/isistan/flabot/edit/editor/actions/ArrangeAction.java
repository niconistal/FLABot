/** * $Id: ArrangeAction.java,v 1.10 2006/03/21 01:51:55 franco Exp $ * $Author: franco $ */package org.isistan.flabot.edit.editor.actions;

import java.util.List;import org.eclipse.gef.EditPart;import org.eclipse.gef.commands.Command;import org.eclipse.gef.ui.actions.SelectionAction;import org.eclipse.jface.resource.ImageDescriptor;import org.eclipse.ui.IWorkbenchPart;import org.isistan.flabot.FlabotPlugin;import org.isistan.flabot.edit.editor.CommandExecutor;import org.isistan.flabot.edit.editor.commands.ArrangeCommand;import org.isistan.flabot.edit.editor.editparts.NoteEditPart;import org.isistan.flabot.edit.editormodel.VisualModel;import org.isistan.flabot.messages.Messages;/** * This action is used to arrage visual parts (Bring to Front/Bring Forward/Send Backward/Send to Back). *  * @author $Author: franco $ * */
public class ArrangeAction extends SelectionAction {
	/**	 * Action id	 */
	public static final String
		ARRANGE = "ARRANGE";   //$NON-NLS-1$

	private String arrange;
	/**	 * Creates a new ArrangeAction in the given workbench part	 * @param part	 * @param arrage	 */
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
	/**	 * Determines whether the action should be enabled or not.	 * @return true if a component, component role or note is selected, false otherwise	 */	@Override
	protected boolean calculateEnabled() {
		return canPerformAction();
	}

	/**	 * Determines whether the action should be enabled or not.	 * @return true if a component, component role or note is selected, false otherwise	 */	private boolean canPerformAction() {		
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

	/**	 * Creates a command that executes the arrange. 	 * 	 * @return the created command	 */
	private Command getCommand() {
		List editparts = getSelectedObjects();
		EditPart componentEditPart = (EditPart)editparts.get(0);	
		VisualModel componentModel = ((VisualModel) componentEditPart.getModel());
		return new ArrangeCommand(componentModel, arrange);
	}
		/**	 * Creates a command and then executes it.	 */	@Override
	public void run() {
		CommandExecutor commandExecutor = (CommandExecutor)getWorkbenchPart().getAdapter(CommandExecutor.class);
		commandExecutor.executeCommand(getCommand(), false);
	}
}