package org.isistan.flabot.edit.ucmeditor.actions;

import java.util.List;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.ui.actions.SelectionAction;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IWorkbenchPart;
import org.isistan.flabot.coremodel.ComponentRole;
import org.isistan.flabot.coremodel.CoremodelFactory;
import org.isistan.flabot.coremodel.DirectionArrowNode;
import org.isistan.flabot.coremodel.DynamicStubNode;
import org.isistan.flabot.coremodel.JoinNode;
import org.isistan.flabot.coremodel.Responsibility;
import org.isistan.flabot.coremodel.ResponsibilityNode;
import org.isistan.flabot.coremodel.SimplePathNode;
import org.isistan.flabot.coremodel.StubNode;
import org.isistan.flabot.coremodel.TimerNode;
import org.isistan.flabot.edit.editor.CommandExecutor;
import org.isistan.flabot.edit.editormodel.NodeVisualModel;
import org.isistan.flabot.edit.editormodel.VisualModel;
import org.isistan.flabot.edit.ucmeditor.commands.model.AddAssociatedNodeToFamilyCommand;
import org.isistan.flabot.edit.ucmeditor.commands.model.ModifyStubCommand;
import org.isistan.flabot.edit.ucmeditor.commands.model.ModifyTimerCommand;
import org.isistan.flabot.edit.ucmeditor.commands.visual.InsertJoinCommand;
import org.isistan.flabot.edit.ucmeditor.commands.visual.InsertStubCommand;
import org.isistan.flabot.edit.ucmeditor.commands.visual.InsertTimerCommand;
import org.isistan.flabot.edit.ucmeditor.commands.visual.InsertWaitingPlaceCommand;
import org.isistan.flabot.edit.ucmeditor.dialogs.EditStubDialog;
import org.isistan.flabot.edit.ucmeditor.dialogs.EditTimerDialog;
import org.isistan.flabot.edit.ucmeditor.editparts.PathNodeEditPart;
import org.isistan.flabot.edit.ucmmodel.UCMDiagram;
import org.isistan.flabot.messages.Messages;

/**
 * This action is used to insert a join (or/and)
 * 
 * @author $Author: Martin Villalba $
 *
 */
public class InsertTimerAction extends InsertResponsibilityAction { //extends SelectionAction{// extends InsertResponsibilityAction {

	/**
	 * Action id
	 */
	public static final String
		INSERT_TIMER = "INSERT_TIMER";   //$NON-NLS-1$

	private int timerType;

	/**
	 * Creates a new InsertTimerAction in the given workbench part
	 * @param part
	 * @param timerType the type of the timer to insert (timer/waiting place)
	 */
	public InsertTimerAction(IWorkbenchPart part, int timerType) {
		super(part);
		switch (timerType) {
		case TimerNode.TIMER_TYPE:
			setText(Messages.getString("org.isistan.flabot.edit.ucmeditor.actions.InsertTimerAction.textTimer")); //$NON-NLS-1$
			break;
		case TimerNode.WAITING_PLACE_TYPE:
			setText(Messages.getString("org.isistan.flabot.edit.ucmeditor.actions.InsertTimerAction.textWaitingPlace")); //$NON-NLS-1$
			break;
		default:
			throw new IllegalArgumentException();
		}
		setId(INSERT_TIMER + timerType);
		this.timerType = timerType;
	}

	/**
	 * Opens a dialog for the user to select a responsibility to associate to the timer, then
	 * creates a command that executes the insertion. 
	 * 
	 * @return the created command
	 */
	protected Command getCommand() {
		
		List editparts = getSelectedObjects();
		PathNodeEditPart part = (PathNodeEditPart)editparts.get(0);
		NodeVisualModel visualNode = part.getCastedModel();
		
		CompoundCommand commands = new CompoundCommand(Messages.getString("org.isistan.flabot.edit.ucmeditor.actions.InsertTimerAction.commandLabel")); //$NON-NLS-1$
		TimerNode timer = CoremodelFactory.eINSTANCE.createTimerNode(this.timerType);
		timer.setMap(((UCMDiagram)visualNode.getDiagram()).getMap());				
		UCMDiagram diagram = (UCMDiagram) visualNode.getDiagram();
	
		Responsibility selectedResponsibility = getSelectedResponsibility(visualNode);
		
		//if selection of responsibility was not cancelled
		if (selectedResponsibility != null)
		{
			EditTimerDialog dialog = new EditTimerDialog(Display.getCurrent().getActiveShell(), timer);		
			TimerNode timerCopy = dialog.open(diagram.getMap()); 
			
			//if the action was not cancelled
			if (timerCopy != null) {
				timerCopy.setResponsibility(selectedResponsibility);
				commands.add(part.getConnectionsDeleteCommand(part.getTargetConnections()));
				
				if (this.timerType == TimerNode.TIMER_TYPE)
					commands.add(new InsertTimerCommand(visualNode, timerCopy));
				else
					commands.add(new InsertWaitingPlaceCommand(visualNode, timerCopy));
				commands.add(new ModifyTimerCommand(timer, timerCopy));
			}
		}
		
		return commands;
	}
	
	/**
	 * Determines whether the action should be enabled or not.
	 * @return true if a timer node is selected, false otherwise
	 */
	@Override
	protected boolean calculateEnabled() {
		return canPerformAction();
	}

	/**
	 * Determines whether the action should be enabled or not.
	 * @return true if a timer node is selected, false otherwise
	 */
	private boolean canPerformAction() {		
		if (getSelectedObjects().isEmpty())
			return false;
		List parts = getSelectedObjects();
		
		if (parts.size() > 1) 
			return false;
		
		Object o = parts.get(0);
		if ( !(o instanceof PathNodeEditPart))
			return false;
		
		PathNodeEditPart part = (PathNodeEditPart)o;
		VisualModel parent = ((VisualModel)part.getModel()).getParent();
		if (parent == null || !(parent.getSemanticModel() instanceof ComponentRole))
			return false;
		
		SimplePathNode node = (SimplePathNode)part.getSemanticModel();
		if ((node instanceof ResponsibilityNode) || (node instanceof StubNode) || 
				(node instanceof DirectionArrowNode) || (node instanceof DynamicStubNode))
			return false;
		
		return !node.isEnd() && !node.isStart();
	}
	
	/**
	 * Creates a comamand and then executes it.
	 */
	@Override
	public void run() {
		Command command = getCommand();
		CommandExecutor commandExecutor = (CommandExecutor)getWorkbenchPart().getAdapter(CommandExecutor.class);
		commandExecutor.executeCommand(command, false);
	}
}