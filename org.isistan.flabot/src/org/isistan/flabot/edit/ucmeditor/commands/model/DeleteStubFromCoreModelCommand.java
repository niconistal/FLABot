/**
 * $Id: DeleteStubFromCoreModelCommand.java,v 1.3 2006/03/21 01:51:57 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.ucmeditor.commands.model;

import org.eclipse.gef.commands.Command;
import org.isistan.flabot.coremodel.CoreModel;
import org.isistan.flabot.coremodel.StubNode;
import org.isistan.flabot.messages.Messages;

/**
 * @author $Author: franco $
 *
 */
public class DeleteStubFromCoreModelCommand extends Command {
	
	private StubNode stubNode;
	private CoreModel coreModel;
	
	/**
	 * Create a new path node delete command
	 * @param selectedNode the node selected for deletion
	 */
	public DeleteStubFromCoreModelCommand(CoreModel coreModel, StubNode stubNode) {
		this.coreModel = coreModel;
		this.stubNode = stubNode;
		setLabel(Messages.getString("org.isistan.flabot.edit.ucmeditor.commands.model.DeleteStubFromCoreModelCommand.label")); //$NON-NLS-1$
	}
	
	public void execute() {
		redo();
	}

	public void redo() {
		coreModel.getStubs().remove(stubNode);
		if (stubNode.getFamily() != null)
			stubNode.getFamily().getAssociatedResponsibilities().remove(stubNode);
	}
	
	public void undo() {
		coreModel.getStubs().add(stubNode);
		if (stubNode.getFamily() != null)
			stubNode.getFamily().getAssociatedResponsibilities().add(stubNode);
	}
}