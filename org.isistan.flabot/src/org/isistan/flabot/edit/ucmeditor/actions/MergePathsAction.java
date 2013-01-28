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
import org.isistan.flabot.coremodel.PathNode;
import org.isistan.flabot.coremodel.Responsibility;
import org.isistan.flabot.coremodel.SimplePathNode;
import org.isistan.flabot.edit.editor.CommandExecutor;
import org.isistan.flabot.edit.editor.dialogs.ResponsibilitySelectionDialog;
import org.isistan.flabot.edit.editormodel.ConnectionVisualModel;
import org.isistan.flabot.edit.editormodel.NodeVisualModel;
import org.isistan.flabot.edit.ucmeditor.commands.visual.JoinPathsCommand;
import org.isistan.flabot.edit.ucmeditor.commands.visual.MergePathsCommand;
import org.isistan.flabot.edit.ucmeditor.editparts.PathNodeEditPart;
import org.isistan.flabot.edit.ucmmodel.UCMDiagram;
import org.isistan.flabot.messages.Messages;

/**
 * This action is used to join two paths in one unique path
 * 
 * @author $Author: Martin Villalba $
 * 
 */
public class MergePathsAction extends SelectionAction {

	/**
	 * Action id
	 */
	public static final String MERGE_PATHS = "MERGE_PATHS"; //$NON-NLS-1$

	private NodeVisualModel nextModel;
	private PathNode node1;

	private PathNodeEditPart part1;
	private PathNodeEditPart part2;

	/**
	 * Creates a new MergePathsAction in the given workbench part
	 * 
	 * @param part
	 */
	public MergePathsAction(IWorkbenchPart part) {
		super(part);
		setText(Messages
				.getString("org.isistan.flabot.edit.ucmeditor.actions.MergePathsAction.andMergeText")); //$NON-NLS-1$
		setId(MERGE_PATHS);
	}

	/**
	 * Determines whether the action should be enabled or not.
	 * 
	 * @return true if an end node and start node are selected, false otherwise
	 */
	@Override
	protected boolean calculateEnabled() {
		return canPerformAction();
	}

	/**
	 * Determines whether the action should be enabled or not.
	 * 
	 * @return true if an end node and start node are selected, false otherwise
	 */
	private boolean canPerformAction() {
		if (getSelectedObjects().isEmpty())
			return false;

		List parts = getSelectedObjects();
		if (parts.size() != 2)
			return false;

		Object o1 = parts.get(0);
		Object o2 = parts.get(1);
		if (!(o1 instanceof PathNodeEditPart && o2 instanceof PathNodeEditPart))
			return false;

		PathNodeEditPart part1 = (PathNodeEditPart) o1;
		PathNodeEditPart part2 = (PathNodeEditPart) o2;

		SimplePathNode node1 = (SimplePathNode) part1.getSemanticModel();
		SimplePathNode node2 = (SimplePathNode) part2.getSemanticModel();

		return ((((node1.isEnd() && node2.isStart())) || (node1.isStart() && node2
				.isEnd())) && (node1.getPath() != node2.getPath()));
	}

	/**
	 * Opens a dialog for the user to select a responsibility to associate to
	 * the join, then creates a command that executes the insertion.
	 * 
	 * @return the created command
	 */
	private Command getCommand() {
		List editparts = getSelectedObjects();
		part1 = (PathNodeEditPart) editparts.get(0);
		part2 = (PathNodeEditPart) editparts.get(1);

		CompoundCommand commands = new CompoundCommand(
				Messages
						.getString("org.isistan.flabot.edit.ucmeditor.actions.MergePathsAction.commandLabel")); //$NON-NLS-1$

		SimplePathNode mergeNode = CoremodelFactory.eINSTANCE
				.createSimplePathNode();
		mergeNode.setMap(((UCMDiagram) part1.getCastedModel().getDiagram())
				.getMap());

		node1 = (PathNode) part1.getCastedModel().getSemanticModel();
		if (node1.isStart()) {
			commands.add(part1.getConnectionsDeleteCommand(part1
					.getSourceConnections()));
			commands.add(part2.getConnectionsDeleteCommand(part2
					.getTargetConnections()));
			nextModel = ((ConnectionVisualModel) part1.getCastedModel()
					.getSourceConnections().get(0)).getTarget();
		} else {
			commands.add(part1.getConnectionsDeleteCommand(part1
					.getTargetConnections()));
			commands.add(part2.getConnectionsDeleteCommand(part2
					.getSourceConnections()));
			nextModel = ((ConnectionVisualModel) part2.getCastedModel()
					.getSourceConnections().get(0)).getTarget();
		}

		commands.add(new MergePathsCommand(part1.getCastedModel(), part2
				.getCastedModel(), mergeNode, getStartEditPart(node1)));

		return commands;
	}

	/**
	 * Creates a command and then executes it.
	 */
	@Override
	public void run() {
		Command command = getCommand();
		CommandExecutor commandExecutor = (CommandExecutor) getWorkbenchPart()
				.getAdapter(CommandExecutor.class);
		commandExecutor.executeCommand(command, false);
	}

	private PathNodeEditPart getStartEditPart(PathNode node) {
		if (node1.isStart()) {
			return part1;
		} else {
			return part2;
		}
	}
}
