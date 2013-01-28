package org.isistan.flabot.edit.ucmeditor.actions;

import java.util.List;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.ui.actions.SelectionAction;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IWorkbenchPart;
import org.isistan.flabot.coremodel.ConditionedStub;
import org.isistan.flabot.coremodel.CoremodelFactory;
import org.isistan.flabot.coremodel.DirectionArrowNode;
import org.isistan.flabot.coremodel.DynamicStubNode;
import org.isistan.flabot.coremodel.ResponsibilityNode;
import org.isistan.flabot.coremodel.SimplePathNode;
import org.isistan.flabot.coremodel.StubNode;
import org.isistan.flabot.edit.editor.CommandExecutor;
import org.isistan.flabot.edit.editormodel.Diagram;
import org.isistan.flabot.edit.editormodel.NodeVisualModel;
import org.isistan.flabot.edit.ucmeditor.commands.model.AddConditionedStubToDynamicStubCommand;
import org.isistan.flabot.edit.ucmeditor.commands.model.ModifyDynamicStubCommand;
import org.isistan.flabot.edit.ucmeditor.commands.visual.InsertDynamicStubCommand;
import org.isistan.flabot.edit.ucmeditor.dialogs.DynamicStubManagerDialog;
import org.isistan.flabot.edit.ucmeditor.dialogs.EditStubDialog;
import org.isistan.flabot.edit.ucmeditor.editparts.ComponentEditPart;
import org.isistan.flabot.edit.ucmeditor.editparts.PathNodeEditPart;
import org.isistan.flabot.edit.ucmmodel.UCMDiagram;
import org.isistan.flabot.messages.Messages;

public class InsertDynamicStubAction  extends SelectionAction {
	
	/**
	 * Action id
	 */
	public static final String
		INSERT_DYNAMIC_STUB = "INSERT_DYNAMIC_STUB"; //$NON-NLS-1$

	/**
	 * Creates a new InsertStubAction in the given workbench part
	 * @param part
	 */
	public InsertDynamicStubAction(IWorkbenchPart part) {
		super(part);

		setText(Messages.getString("org.isistan.flabot.edit.ucmeditor.actions.InsertDynamicStubAction.text")); //$NON-NLS-1$
		setId(INSERT_DYNAMIC_STUB);
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
	 * Creates a command that executes the insertion of the new dynamic stub. 
	 * @return the created command
	 */
	private Command getCommand() {
		List editparts = getSelectedObjects();
		PathNodeEditPart part = (PathNodeEditPart)editparts.get(0);
		NodeVisualModel visualNode = part.getCastedModel();
		
		CompoundCommand commands = new CompoundCommand(Messages.getString("org.isistan.flabot.edit.ucmeditor.actions.InsertStubAction.commandLabel")); //$NON-NLS-1$
		DynamicStubNode dynamicStub = CoremodelFactory.eINSTANCE.createDynamicStubNode();
		dynamicStub.setMap(((UCMDiagram)visualNode.getDiagram()).getMap());				
		UCMDiagram diagram = (UCMDiagram) visualNode.getDiagram();
	
		DynamicStubManagerDialog dialog = new DynamicStubManagerDialog(Display.getCurrent().getActiveShell(), dynamicStub, getCommandStack());		
		DynamicStubNode stubCopy = dialog.open(diagram, dynamicStub); 
		
		//if the action was not cancelled
		if (stubCopy != null) {
			commands.add(part.getConnectionsDeleteCommand(part.getTargetConnections()));
			commands.add(new InsertDynamicStubCommand(visualNode, stubCopy));
			commands.add(new ModifyDynamicStubCommand(dynamicStub, stubCopy, diagram.getCoreModel()));
			for (int i=0; i < stubCopy.getConditionedStubs().size(); i++)
			{
				ConditionedStub conditionedStub = (ConditionedStub)stubCopy.getConditionedStubs().get(i);
				commands.add(new AddConditionedStubToDynamicStubCommand(conditionedStub, dynamicStub, diagram.getCoreModel()));
			}
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
