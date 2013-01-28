package org.isistan.flabot.edit.ucmeditor.commands.visual;

import org.isistan.flabot.coremodel.CoreModel;
import org.isistan.flabot.coremodel.TimerNode;
import org.isistan.flabot.edit.editormodel.NodeVisualModel;
import org.isistan.flabot.messages.Messages;

/**
 * 
 * @author $Author: Martin Villalba $
 *
 */
public class DeleteWaitingPlaceCommand  extends DeletePathNodeCommand {
	
	private CoreModel coreModel;
	private TimerNode timerNode;
	
	/**
	 * Create a new path node delete command
	 * @param selectedNode the node selected for deletion
	 */
	public DeleteWaitingPlaceCommand(NodeVisualModel selectedNode) {
		super(selectedNode);
		coreModel = selectedNode.getDiagram().getCoreModel();
		timerNode = (TimerNode)selectedNode.getSemanticModel();
		setLabel(Messages.getString("org.isistan.flabot.edit.ucmeditor.commands.visual.DeleteWaitinfPlaceCommand.label")); //$NON-NLS-1$
	}
	
	public void redo() {
		super.redo();
		coreModel.getTimers().remove(timerNode);
	}

	public void undo() {
		super.undo();
		coreModel.getTimers().add(timerNode);
	}
}
