package org.isistan.flabot.edit.ucmeditor.actions;

import java.util.List;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.ui.actions.SelectionAction;
import org.eclipse.ui.IWorkbenchPart;
import org.isistan.flabot.coremodel.TimerNode;
import org.isistan.flabot.edit.editor.CommandExecutor;
import org.isistan.flabot.edit.editormodel.NodeVisualModel;
import org.isistan.flabot.edit.ucmeditor.commands.visual.RotateFigureCommand;
import org.isistan.flabot.edit.ucmeditor.editparts.ForkNodeEditPart;
import org.isistan.flabot.edit.ucmeditor.editparts.JoinNodeEditPart;
import org.isistan.flabot.edit.ucmeditor.editparts.PathNodeEditPart;
import org.isistan.flabot.edit.ucmeditor.editparts.TimerNodeEditPart;
import org.isistan.flabot.edit.ucmeditor.figures.ThreeConnectionFigure;
import org.isistan.flabot.messages.Messages;

public class RotatePathNodeAction extends SelectionAction {

	/**
	 * Action ids
	 */
	public static final String 
		ROTATE_LEFT = "ROTATE_LEFT";   //$NON-NLS-1$

	public static final String 
		ROTATE_RIGHT = "ROTATE_RIGHT";   //$NON-NLS-1$
	
	public static final String 
		ROTATE_UP = "ROTATE_UP";   //$NON-NLS-1$
	
	public static final String 
		ROTATE_DOWN = "ROTATE_DOWN";   //$NON-NLS-1$

	private String position;

	/**
	 * Creates a new RotateForkJoinAction in the given workbench part
	 * @param part
	 * @param position the position to rotate (left/right/up/down)
	 */
	public RotatePathNodeAction(IWorkbenchPart part, String position) {
		super(part);

		this.position = position;
		if (position.equals(ThreeConnectionFigure.LEFT)) {
			setText(Messages.getString("org.isistan.flabot.edit.ucmeditor.actionsRotatePathNodeAction.leftText")); //$NON-NLS-1$
			setId(ROTATE_LEFT);
		} else if (position.equals(ThreeConnectionFigure.RIGHT)){
			setText(Messages.getString("org.isistan.flabot.edit.ucmeditor.actionsRotatePathNodeAction.rightText")); //$NON-NLS-1$
			setId(ROTATE_RIGHT);
		} else if (position.equals(ThreeConnectionFigure.UP)) {
			setText(Messages.getString("org.isistan.flabot.edit.ucmeditor.actionsRotatePathNodeAction.upText")); //$NON-NLS-1$
			setId(ROTATE_UP);
		} else if (position.equals(ThreeConnectionFigure.DOWN)) {	
			setText(Messages.getString("org.isistan.flabot.edit.ucmeditor.actionsRotatePathNodeAction.downText")); //$NON-NLS-1$
			setId(ROTATE_DOWN);
		}
	}

	/**
	 * Determines whether the action should be enabled or not.
	 * @return true if a fork node or join node is selected, false otherwise
	 */
	@Override
	protected boolean calculateEnabled() {
		return canPerformAction();
	}

	/**
	 * Determines whether the action should be enabled or not.
	 * @return true if a fork node or join node is selected, false otherwise
	 */
	private boolean canPerformAction() {
		
		if (getSelectedObjects().isEmpty())
			return false;
		List parts = getSelectedObjects();
		
		if (parts.size() > 1) 
			return false;
		
		Object o = parts.get(0);
		if ((!(o instanceof ForkNodeEditPart)) && (!(o instanceof JoinNodeEditPart)) && (!(o instanceof TimerNodeEditPart)))
			return false;
		
		if (o instanceof TimerNodeEditPart){
			if (((TimerNodeEditPart) o).getTimerNodeType() == TimerNode.WAITING_PLACE_TYPE)
				return false;
		}
		
		return true;
	}

	/**
	 * Creates a command that executes the rotation. 
	 * 
	 * @return the command to execute
	 */
	private Command getCommand() {
		List editparts = getSelectedObjects();
		PathNodeEditPart part = (PathNodeEditPart)editparts.get(0);		
		return new RotateFigureCommand((NodeVisualModel) part.getModel(), position);
	}

	/**
	 * Creates a command and then executes it.
	 */
	@Override
	public void run() {
		Command command = getCommand();
		CommandExecutor commandExecutor = (CommandExecutor)getWorkbenchPart().getAdapter(CommandExecutor.class);
		commandExecutor.executeCommand(command, false);
	}

}
