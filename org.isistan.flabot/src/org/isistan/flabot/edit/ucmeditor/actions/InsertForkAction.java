/**
 * $Id: InsertForkAction.java,v 1.31 2006/03/21 01:51:56 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.ucmeditor.actions;

import java.util.List;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.ui.IWorkbenchPart;
import org.isistan.flabot.coremodel.CoremodelFactory;
import org.isistan.flabot.coremodel.ForkNode;
import org.isistan.flabot.coremodel.JoinNode;
import org.isistan.flabot.coremodel.Responsibility;
import org.isistan.flabot.edit.editormodel.NodeVisualModel;
import org.isistan.flabot.edit.ucmeditor.commands.visual.InsertForkCommand;
import org.isistan.flabot.edit.ucmeditor.editparts.PathNodeEditPart;
import org.isistan.flabot.messages.Messages;

/**
 * This action is used to insert a fork (or/and)
 * 
 * @author $Author: franco $
 *
 */
public class InsertForkAction extends InsertResponsibilityAction {

	/**
	 * Action id
	 */
	public static final String
		INSERT_FORK = "INSERT_FORK";   //$NON-NLS-1$

	private int forkType;
	private int outputsCount;

	/**
	 * Creates a new InsertForkAction in the given workbench part
	 * @param part
	 * @param forkType the type of the fork to insert (or/and)
	 */
	public InsertForkAction(IWorkbenchPart part, int forkType, int outputsCount) {
		super(part);
//		switch (forkType) {
//		case ForkNode.AND_FORK_TYPE:
//			setText(Messages.getString("org.isistan.flabot.edit.ucmeditor.actions.InsertForkAction.textAnd")); //$NON-NLS-1$
//			break;
//		case ForkNode.OR_FORK_TYPE:
//			setText(Messages.getString("org.isistan.flabot.edit.ucmeditor.actions.InsertForkAction.textOr")); //$NON-NLS-1$
//			break;
//		default:
//			throw new IllegalArgumentException();
//		}
		switch (outputsCount) {
		case ForkNode.TWO_OUTPUTS:
			setText(Messages.getString("org.isistan.flabot.edit.ucmeditor.UCMEditorContextMenuProvider.insertForkAction_TwoOutputs")); //$NON-NLS-1$
			break;
		case ForkNode.THREE_OUTPUTS:
			setText(Messages.getString("org.isistan.flabot.edit.ucmeditor.UCMEditorContextMenuProvider.insertForkAction_ThreeOutputs")); //$NON-NLS-1$
			break;
		case ForkNode.FOUR_OUTPUTS:
			setText(Messages.getString("org.isistan.flabot.edit.ucmeditor.UCMEditorContextMenuProvider.insertForkAction_FourOutputs")); //$NON-NLS-1$
			break;
		case ForkNode.FIVE_OUTPUTS:
			setText(Messages.getString("org.isistan.flabot.edit.ucmeditor.UCMEditorContextMenuProvider.insertForkAction_FiveOutputs")); //$NON-NLS-1$
			break;
		default:
			throw new IllegalArgumentException();
		}
		setId(INSERT_FORK + forkType + outputsCount);
		this.forkType = forkType;
		this.outputsCount = outputsCount;
	}

	/**
	 * Opens a dialog for the user to select a responsibility to associate to the fork, then
	 * creates a command that executes the insertion. 
	 * 
	 * @return the created command
	 */
	protected Command getCommand() {
		List editparts = getSelectedObjects();
		PathNodeEditPart part = (PathNodeEditPart)editparts.get(0);
		NodeVisualModel visualNode = part.getCastedModel();
				
		// ask the user to select a responsibility from the list
		Responsibility selectedResponsibility = getSelectedResponsibility(visualNode);
		
		// if the user doesn't select a responsibility, the action is cancelled
		CompoundCommand compound = new CompoundCommand(Messages.getString("org.isistan.flabot.edit.ucmeditor.actions.InsertForkAction.commandLabel")); //$NON-NLS-1$
		if (selectedResponsibility != null) {			
			ForkNode fork = CoremodelFactory.eINSTANCE.createForkNode(selectedResponsibility, forkType, this.outputsCount);
			fork.setMap(map);
			fork.setRole(role);
			fork.setOutputsCount(this.outputsCount);
			compound.add(part.getConnectionsDeleteCommand(part.getTargetConnections()));
			compound.add(new InsertForkCommand(visualNode, fork));
		}		
		return compound;
	}
}