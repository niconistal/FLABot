/**
 * $Id: JoinPathsAction.java,v 1.11 2006/03/21 01:51:56 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.ucmeditor.actions;

import java.util.List;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.ui.actions.SelectionAction;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IWorkbenchPart;
import org.isistan.flabot.coremodel.CoreModel;
import org.isistan.flabot.coremodel.CoremodelFactory;
import org.isistan.flabot.coremodel.JoinNode;
import org.isistan.flabot.coremodel.Responsibility;
import org.isistan.flabot.coremodel.SimplePathNode;
import org.isistan.flabot.edit.editor.CommandExecutor;
import org.isistan.flabot.edit.editor.dialogs.ResponsibilitySelectionDialog;
import org.isistan.flabot.edit.ucmeditor.commands.visual.JoinPathsCommand;
import org.isistan.flabot.edit.ucmeditor.editparts.PathNodeEditPart;
import org.isistan.flabot.edit.ucmmodel.UCMDiagram;
import org.isistan.flabot.messages.Messages;

/**
 * This action is used to join two paths (two end nodes) with a join node
 * 
 * @author $Author: franco $
 *
 */
public class JoinPathsAction extends SelectionAction {

	/**
	 * Action id
	 */
	public static final String
		JOIN_PATHS = "JOIN_PATHS";   //$NON-NLS-1$

	private int joinType = JoinNode.AND_JOIN_TYPE;
	
	/**
	 * Creates a new JoinPathsAction in the given workbench part
	 * @param part
	 * @param joinType the type of the join to insert (or/and)
	 */
	public JoinPathsAction(IWorkbenchPart part, int joinType) {
		super(part);
		this.joinType = joinType;
		switch (joinType) {
		case JoinNode.AND_JOIN_TYPE:
			setText(Messages.getString("org.isistan.flabot.edit.ucmeditor.actions.JoinPathsAction.andJoinText")); //$NON-NLS-1$
			break;
		case JoinNode.OR_JOIN_TYPE:
			setText(Messages.getString("org.isistan.flabot.edit.ucmeditor.actions.JoinPathsAction.orJoinText")); //$NON-NLS-1$
			break;
		default:
			throw new IllegalArgumentException();
		}
		setId(JOIN_PATHS + joinType);
	}

	/**
	 * Determines whether the action should be enabled or not.
	 * @return true if a two end nodes are selected, false otherwise
	 */
	@Override
	protected boolean calculateEnabled() {
		return canPerformAction();
	}

	/**
	 * Determines whether the action should be enabled or not.
	 * @return true if a two end nodes are selected, false otherwise
	 */
	private boolean canPerformAction() {		
		if (getSelectedObjects().isEmpty())
			return false;
		
		List parts = getSelectedObjects();		
		if (parts.size() != 2) 
			return false;
		
		Object o1 = parts.get(0);
		Object o2 = parts.get(1);
		if (!(o1 instanceof PathNodeEditPart && o2 instanceof PathNodeEditPart ))
			return false;
		
		PathNodeEditPart part1 = (PathNodeEditPart)o1;
		PathNodeEditPart part2 = (PathNodeEditPart)o2;

		SimplePathNode node1 = (SimplePathNode)part1.getSemanticModel();
		SimplePathNode node2 = (SimplePathNode)part2.getSemanticModel();
		
		return (node1.isEnd() && node2.isEnd());
	}

	/**
	 * Opens a dialog for the user to select a responsibility to associate to the join, then
	 * creates a command that executes the insertion. 
	 * 
	 * @return the created command
	 */
	private Command getCommand() {
		List editparts = getSelectedObjects();
		PathNodeEditPart part1 = (PathNodeEditPart)editparts.get(0);
		PathNodeEditPart part2 = (PathNodeEditPart)editparts.get(1);
				
		List responsibilities =	 part1.getCastedModel().getDiagram().getCoreModel().getResponsibilities();
		CoreModel coreModel = part1.getCastedModel().getDiagram().getCoreModel();
		ResponsibilitySelectionDialog dialog = new ResponsibilitySelectionDialog(Display.getCurrent().getActiveShell(), getCommandStack(), coreModel);
		Responsibility selectedResponsibility =	dialog.openSingle(
				Display.getCurrent().getActiveShell(),
				Messages.getString("org.isistan.flabot.edit.ucmeditor.actions.JoinPathsAction.dialogName"), //$NON-NLS-1$
				Messages.getString("org.isistan.flabot.edit.ucmeditor.actions.JoinPathsAction.dialogDescription"), //$NON-NLS-1$
				responsibilities,
				null);
		
		CompoundCommand commands = new CompoundCommand(Messages.getString("org.isistan.flabot.edit.ucmeditor.actions.JoinPathsAction.commandLabel")); //$NON-NLS-1$
		//if the user doesn't select a responsibility, the action is cancelled
		if (selectedResponsibility != null) {			
			JoinNode join = CoremodelFactory.eINSTANCE.createJoinNode();
			join.setResponsibility(selectedResponsibility);
			join.setJoinType(joinType);
			join.setMap(((UCMDiagram)part1.getCastedModel().getDiagram()).getMap());
			commands.add(part1.getConnectionsDeleteCommand(part1.getTargetConnections()));
			commands.add(part2.getConnectionsDeleteCommand(part2.getTargetConnections()));
			commands.add(new JoinPathsCommand(part1.getCastedModel(), part2.getCastedModel(), join));
		}		
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