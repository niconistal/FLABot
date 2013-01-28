package org.isistan.flabot.edit.ucmeditor.actions;

import java.util.List;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.ui.actions.SelectionAction;
import org.eclipse.ui.IWorkbenchPart;
import org.isistan.flabot.coremodel.CoremodelFactory;
import org.isistan.flabot.coremodel.DirectionArrowNode;
import org.isistan.flabot.coremodel.DynamicStubNode;
import org.isistan.flabot.coremodel.ResponsibilityNode;
import org.isistan.flabot.coremodel.SimplePathNode;
import org.isistan.flabot.coremodel.StubNode;
import org.isistan.flabot.coremodel.TimerNode;
import org.isistan.flabot.edit.editor.CommandExecutor;
import org.isistan.flabot.edit.editormodel.NodeVisualModel;
import org.isistan.flabot.edit.ucmeditor.commands.visual.InsertDirectionArrowCommand;
import org.isistan.flabot.edit.ucmeditor.editparts.DirectionArrowNodeEditPart;
import org.isistan.flabot.edit.ucmeditor.editparts.PathNodeEditPart;
import org.isistan.flabot.edit.ucmeditor.editparts.ResponsibilityNodeEditPart;
import org.isistan.flabot.edit.ucmeditor.editparts.StubNodeEditPart;
import org.isistan.flabot.edit.ucmmodel.UCMDiagram;
import org.isistan.flabot.messages.Messages;

/**
 * 
 * @author $Author: Martin Villalba $
 *
 */
public class InsertDirectionArrowAction  extends SelectionAction {
	
	/**
	 * Action id
	 */
	public static final String
		INSERT_DIRECTION_ARROW = "INSERT_DIRECTION_ARROW";   //$NON-NLS-1$

	/**
	 * Creates a new InsertDirectionArrowAction in the given workbench part
	 * @param part
	 */
	public InsertDirectionArrowAction(IWorkbenchPart part) {
		super(part);
	
		setId(INSERT_DIRECTION_ARROW);
	
		setText(Messages.getString("org.isistan.flabot.edit.ucmeditor.actions.InsertDirectionArrowAction.text")); //$NON-NLS-1$
	}
	
	/**
	 * Determines whether the action should be enabled or not.
	 * @return false if the selected object is not a PathNode or if a responsibility node or a stub node is selected , true otherwise
	 */
	@Override
	protected boolean calculateEnabled() {
		return canPerformAction();
	}

	private boolean canPerformAction() {		
		if (getSelectedObjects().isEmpty())
			return false;
		
		List parts = getSelectedObjects();		
		if (parts.size() > 1) 
			return false;
		
		Object o = parts.get(0);
		if (!(o instanceof PathNodeEditPart))
			return false;
		
		PathNodeEditPart part = (PathNodeEditPart)o;
		SimplePathNode node = (SimplePathNode)part.getSemanticModel();
		if ((node instanceof ResponsibilityNode) || (node instanceof StubNode) || 
				(node instanceof DirectionArrowNode) || (node instanceof DynamicStubNode))
			return false;

		return !node.isEnd() && !node.isStart();
	}

	/**
	 * Creates a command that executes the node insertion
	 * 
	 * @return the created command
	 */
	private Command getCommand() {
		List editparts = getSelectedObjects();
		PathNodeEditPart part = (PathNodeEditPart)editparts.get(0);
		NodeVisualModel visualNode = part.getCastedModel();		
		
		CompoundCommand commands = new CompoundCommand(Messages.getString("org.isistan.flabot.edit.ucmeditor.actions.InsertDirectionArrowAction.commandLabel")); //$NON-NLS-1$
		DirectionArrowNode directionArrow = CoremodelFactory.eINSTANCE.createDirectionArrowNode();
		directionArrow.setMap(((UCMDiagram)visualNode.getDiagram()).getMap());
		
		commands.add(part.getConnectionsDeleteCommand(part.getTargetConnections()));
		commands.add(new InsertDirectionArrowCommand(visualNode, directionArrow));
		return commands;
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
