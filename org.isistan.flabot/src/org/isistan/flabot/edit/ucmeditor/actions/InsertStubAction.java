/**
 * $Id: InsertStubAction.java,v 1.11 2006/03/21 01:51:56 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.ucmeditor.actions;

import java.util.List;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.ui.actions.SelectionAction;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IWorkbenchPart;
import org.isistan.flabot.coremodel.CoremodelFactory;
import org.isistan.flabot.coremodel.DirectionArrowNode;
import org.isistan.flabot.coremodel.DynamicStubNode;
import org.isistan.flabot.coremodel.ResponsibilityNode;
import org.isistan.flabot.coremodel.SimplePathNode;
import org.isistan.flabot.coremodel.StubNode;
import org.isistan.flabot.edit.editor.CommandExecutor;
import org.isistan.flabot.edit.editormodel.NodeVisualModel;
import org.isistan.flabot.edit.ucmeditor.commands.model.AddAssociatedNodeToFamilyCommand;
import org.isistan.flabot.edit.ucmeditor.commands.model.ModifyStubCommand;
import org.isistan.flabot.edit.ucmeditor.commands.visual.InsertStubCommand;
import org.isistan.flabot.edit.ucmeditor.dialogs.EditStubDialog;
import org.isistan.flabot.edit.ucmeditor.editparts.ComponentEditPart;
import org.isistan.flabot.edit.ucmeditor.editparts.PathNodeEditPart;
import org.isistan.flabot.edit.ucmmodel.UCMDiagram;
import org.isistan.flabot.messages.Messages;

/**
 * This action is used to insert a new stub in a path
 * 
 * @author $Author: franco $
 *
 */
public class InsertStubAction extends SelectionAction {
	
	/**
	 * Action id
	 */
	public static final String
		INSERT_STUB = "INSERT_SUB"; //$NON-NLS-1$

	/**
	 * Creates a new InsertStubAction in the given workbench part
	 * @param part
	 */
	public InsertStubAction(IWorkbenchPart part) {
		super(part);

		setText(Messages.getString("org.isistan.flabot.edit.ucmeditor.actions.InsertStubAction.text")); //$NON-NLS-1$
		setId(INSERT_STUB);
	}
	
	/**
	 * Determines whether the action should be enabled or not.
	 * @return true if a simple node is selected, false otherwise
	 */
	@Override
	protected boolean calculateEnabled() {
		return canPerformAction();
	}

	/**
	 * Determines whether the action should be enabled or not.
	 * @return true if a simple node is selected, false otherwise
	 */
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
		
		SimplePathNode node = (SimplePathNode)part.getSemanticModel();
		
		if (part.getParent() instanceof ComponentEditPart)
			return false;
		
		if ((node instanceof ResponsibilityNode) || (node instanceof StubNode) || 
				(node instanceof DirectionArrowNode) || (node instanceof DynamicStubNode))
			return false;
		
		return !node.isEnd() && !node.isStart();
	}

	/**
	 * Creates a command that executes the insertion of the new stub. 
	 * @return the created command
	 */
	private Command getCommand() {
		List editparts = getSelectedObjects();
		PathNodeEditPart part = (PathNodeEditPart)editparts.get(0);
		NodeVisualModel visualNode = part.getCastedModel();
		
		CompoundCommand commands = new CompoundCommand(Messages.getString("org.isistan.flabot.edit.ucmeditor.actions.InsertStubAction.commandLabel")); //$NON-NLS-1$
		StubNode stub = CoremodelFactory.eINSTANCE.createStubNode();
		stub.setMap(((UCMDiagram)visualNode.getDiagram()).getMap());				
		UCMDiagram diagram = (UCMDiagram) visualNode.getDiagram();
	
		EditStubDialog dialog = new EditStubDialog(Display.getCurrent().getActiveShell(), stub);		
		StubNode stubCopy = dialog.open(visualNode.getDiagram().getCoreModel().getUseCaseMaps(), diagram.getMap(), diagram.getCoreModel().getFamilies()); 
		
		//if the action was not cancelled
		if (stubCopy != null) {
			commands.add(part.getConnectionsDeleteCommand(part.getTargetConnections()));
			commands.add(new InsertStubCommand(visualNode, stub));
			commands.add(new ModifyStubCommand(stub, stubCopy));
			if (stubCopy.getFamily() != null)
				commands.add( new AddAssociatedNodeToFamilyCommand(stubCopy.getFamily(), stub));
		}		
		return commands;
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