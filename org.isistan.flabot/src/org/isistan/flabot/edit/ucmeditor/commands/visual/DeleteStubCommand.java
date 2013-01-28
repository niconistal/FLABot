/**
 * $Id: DeleteStubCommand.java,v 1.2 2006/03/21 01:51:55 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.ucmeditor.commands.visual;

import org.isistan.flabot.coremodel.CoreModel;
import org.isistan.flabot.coremodel.StubNode;
import org.isistan.flabot.edit.editormodel.NodeVisualModel;
import org.isistan.flabot.messages.Messages;

/**
 * @author $Author: franco $
 *
 */
public class DeleteStubCommand extends DeletePathNodeCommand {
	
	private CoreModel coreModel;
	private StubNode stubNode;
	
	/**
	 * Create a new path node delete command
	 * @param selectedNode the node selected for deletion
	 */
	public DeleteStubCommand(NodeVisualModel selectedNode) {
		super(selectedNode);
		coreModel = selectedNode.getDiagram().getCoreModel();
		stubNode = (StubNode)selectedNode.getSemanticModel();
		setLabel(Messages.getString("org.isistan.flabot.edit.ucmeditor.commands.visual.DeleteStubCommand.label")); //$NON-NLS-1$
	}
	
	public void redo() {
		super.redo();
		coreModel.getStubs().remove(stubNode);
		if (stubNode.getFamily() != null)
			stubNode.getFamily().getAssociatedResponsibilities().remove(stubNode);
	}

	public void undo() {
		super.undo();
		coreModel.getStubs().add(stubNode);
		if (stubNode.getFamily() != null)
			stubNode.getFamily().getAssociatedResponsibilities().add(stubNode);
	}
	
}

