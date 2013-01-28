/**
 * $Id: InsertJoinAction.java,v 1.20 2006/03/21 01:51:56 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.ucmeditor.actions;

import java.util.List;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.ui.IWorkbenchPart;
import org.isistan.flabot.coremodel.CoremodelFactory;
import org.isistan.flabot.coremodel.JoinNode;
import org.isistan.flabot.coremodel.Responsibility;
import org.isistan.flabot.edit.editormodel.NodeVisualModel;
import org.isistan.flabot.edit.ucmeditor.commands.visual.InsertJoinCommand;
import org.isistan.flabot.edit.ucmeditor.editparts.PathNodeEditPart;
import org.isistan.flabot.messages.Messages;

/**
 * This action is used to insert a join (or/and)
 * 
 * @author $Author: franco $
 *
 */
public class InsertJoinAction extends InsertResponsibilityAction {

	/**
	 * Action id
	 */
	public static final String
		INSERT_JOIN = "INSERT_JOIN";   //$NON-NLS-1$

	private int joinType;
	private int inputsCount;

	/**
	 * Creates a new InsertJoinAction in the given workbench part
	 * @param part
	 * @param joinType the type of the join to insert (or/and)
	 */
	public InsertJoinAction(IWorkbenchPart part, int joinType, int inputsCount) {
		super(part);
//		switch (joinType) {
//		case JoinNode.AND_JOIN_TYPE:
//			setText(Messages.getString("org.isistan.flabot.edit.ucmeditor.actions.InsertJoinAction.textAnd")); //$NON-NLS-1$
//			break;
//		case JoinNode.OR_JOIN_TYPE:
//			setText(Messages.getString("org.isistan.flabot.edit.ucmeditor.actions.InsertJoinAction.textOr")); //$NON-NLS-1$
//			break;
//		default:
//			throw new IllegalArgumentException();
//		}
		switch (inputsCount) {
		case JoinNode.TWO_INPUTS:
			setText(Messages.getString("org.isistan.flabot.edit.ucmeditor.UCMEditorContextMenuProvider.insertJoinAction_TwoInputs")); //$NON-NLS-1$
			break;
		case JoinNode.THREE_INPUTS:
			setText(Messages.getString("org.isistan.flabot.edit.ucmeditor.UCMEditorContextMenuProvider.insertJoinAction_ThreeInputs")); //$NON-NLS-1$
			break;
		case JoinNode.FOUR_INPUTS:
			setText(Messages.getString("org.isistan.flabot.edit.ucmeditor.UCMEditorContextMenuProvider.insertJoinAction_FourInputs")); //$NON-NLS-1$
			break;
		case JoinNode.FIVE_INPUTS:
			setText(Messages.getString("org.isistan.flabot.edit.ucmeditor.UCMEditorContextMenuProvider.insertJoinAction_FiveInputs")); //$NON-NLS-1$
			break;
		default:
			throw new IllegalArgumentException();
		}
		setId(INSERT_JOIN + joinType + inputsCount);
		this.inputsCount = inputsCount;
		this.joinType = joinType;
	}

	/**
	 * Opens a dialog for the user to select a responsibility to associate to the join, then
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
		CompoundCommand compound = new CompoundCommand(Messages.getString("org.isistan.flabot.edit.ucmeditor.actions.InsertJoinAction.commandLabel")); //$NON-NLS-1$
		if (selectedResponsibility != null) {	
			JoinNode join = CoremodelFactory.eINSTANCE.createJoinNode(selectedResponsibility, joinType);
			join.setMap(map);
			join.setRole(role);
			join.setInputsCount(this.inputsCount);
			compound.add(part.getConnectionsDeleteCommand(part.getTargetConnections()));
			compound.add(new InsertJoinCommand(visualNode, join));
		}		
		return compound;
	}
}