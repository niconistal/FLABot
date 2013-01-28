package org.isistan.flabot.edit.ucmeditor.commands.visual;

import org.isistan.flabot.coremodel.CoreModel;
import org.isistan.flabot.coremodel.DynamicStubNode;
import org.isistan.flabot.edit.editormodel.NodeVisualModel;
import org.isistan.flabot.messages.Messages;

public class DeleteDynamicStubCommand  extends DeletePathNodeCommand {
	
	private CoreModel coreModel;
	private DynamicStubNode dynamicStubNode;
	
	/**
	 * Create a new path node delete command
	 * @param selectedNode the node selected for deletion
	 */
	public DeleteDynamicStubCommand(NodeVisualModel selectedNode) {
		super(selectedNode);
		coreModel = selectedNode.getDiagram().getCoreModel();
		dynamicStubNode = (DynamicStubNode)selectedNode.getSemanticModel();
		setLabel(Messages.getString("org.isistan.flabot.edit.ucmeditor.commands.visual.DeleteDynamicStubCommand.label")); //$NON-NLS-1$
	}
	
	public void redo() {
		super.redo();
		coreModel.getDynamicStubs().remove(dynamicStubNode);
	}

	public void undo() {
		super.undo();
		coreModel.getDynamicStubs().add(dynamicStubNode);
	}
}
