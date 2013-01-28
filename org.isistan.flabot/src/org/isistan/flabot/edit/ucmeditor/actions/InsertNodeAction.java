/**
 * $Id: InsertNodeAction.java,v 1.15 2006/03/17 22:28:02 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.ucmeditor.actions;

import java.util.List;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.ui.actions.SelectionAction;
import org.eclipse.ui.IWorkbenchPart;
import org.isistan.flabot.coremodel.ForkNode;
import org.isistan.flabot.coremodel.JoinNode;
import org.isistan.flabot.coremodel.SimplePathNode;
import org.isistan.flabot.edit.editor.CommandExecutor;
import org.isistan.flabot.edit.editormodel.NodeVisualModel;
import org.isistan.flabot.edit.ucmeditor.commands.visual.InsertNodeCommand;
import org.isistan.flabot.edit.ucmeditor.editparts.PathNodeEditPart;
import org.isistan.flabot.messages.Messages;

/**
 * This action is used to insert a node (after or before)
 * 
 * @author $Author: franco $
 *
 */
public class InsertNodeAction extends SelectionAction {
	
	/**
	 * Action id
	 */
	public static final String
		INSERT_NODE = "INSERT_NODE";   //$NON-NLS-1$

	private String side;

	/**
	 * Creates a new InsertNodeAction in the given workbench part
	 * @param part
	 * @param side the side where the node will be inserted (after or before)
	 */
	public InsertNodeAction(IWorkbenchPart part, String side) {
		super(part);
	
		setId(INSERT_NODE + side);
		this.side = side;
	
		if(InsertNodeCommand.BEFORE.equals(side))
			setText(Messages.getString("org.isistan.flabot.edit.ucmeditor.actions.InsertNodeAction.beforeInsertion")); //$NON-NLS-1$
		else
			if (InsertNodeCommand.AFTER.equals(side))
				setText(Messages.getString("org.isistan.flabot.edit.ucmeditor.actions.InsertNodeAction.afterInsertion"));			 //$NON-NLS-1$
			else
				throw new IllegalArgumentException();
	}
	
	/**
	 * Determines whether the action should be enabled or not.
	 * @return true if a responsibility node is selected, false otherwise
	 */
	@Override
	protected boolean calculateEnabled() {
		return canPerformAction();
	}
	
	/**
	 * Determines whether a before insertion action should be enabled or not.
	 * @return true if not a start node is selected, false otherwise
	 */
	public boolean canPerformActionStartBefore() {
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
		return !node.isStart();
	}
	
	/**
	 * Determines whether a after insertion action should be enabled or not.
	 * @return true if a not an end node is selected, false otherwise
	 */
	public boolean canPerformActionEndAfter() {
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
		return !node.isEnd();
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
		if (!(part.getSemanticModel() instanceof SimplePathNode))
			return false;
		
		if (part.getSemanticModel() instanceof ForkNode || part.getSemanticModel() instanceof JoinNode)
			return false;
		
		return true;
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
		return new InsertNodeCommand(visualNode, side);
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