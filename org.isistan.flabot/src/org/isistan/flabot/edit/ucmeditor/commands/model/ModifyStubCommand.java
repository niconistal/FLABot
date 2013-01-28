/**
 * $Id: ModifyStubCommand.java,v 1.2 2006/03/21 01:51:57 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.ucmeditor.commands.model;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gef.commands.Command;
import org.isistan.flabot.coremodel.StubNode;
import org.isistan.flabot.messages.Messages;

/**
 * ModifyStubCommand
 * -	Modifies all the properties of a Stub Node (including its name, map, start and end nodes).
 * -	The new properties are taken from another stub node.
 * 
 * @author $Author: franco $
 *
 */
public class ModifyStubCommand extends Command {

	StubNode originalStub;
	StubNode newStub;
	StubNode oldStub;
		
	/**
	 * Instantiates a command that modifies all the properties of a stub.
	 * @param visualStub the stub to modify
	 * @param newStub the stub from where the new properties are taken  
	 */
	public ModifyStubCommand(StubNode originalStub, StubNode newStub) {
		this.originalStub = originalStub;
		this.newStub = newStub;
		this.oldStub = (StubNode) EcoreUtil.copy(originalStub);
		setLabel(Messages.getString("org.isistan.flabot.edit.ucmeditor.commands.model.ModifyStubCommand.label")); //$NON-NLS-1$
	}
	
	/**
	 * Verifies that the command can be executed.
	 * @return <code>true</code> if the command can be executed	
	 */
	public boolean canExecute() {
		return (originalStub != null && newStub != null);
	}
	
	/**
	 * Executes the Command. This method should not be called if the command is not
	 * executable.
	 * 
	 * @see redo()
	 */
	public void execute() {
		redo();
	}
	
	/**
	 * The new properties are set in the stub (including its name, map, start and end nodes).
	 */
	public void redo() {
		setValues(newStub);
	}
	
	private void setValues(StubNode stubNodeCopy) {
		originalStub.setName(stubNodeCopy.getName());
		originalStub.setReferencedMap(stubNodeCopy.getReferencedMap());
		originalStub.setStartPointReference(stubNodeCopy.getStartPointReference());
		originalStub.setEndPointReference(stubNodeCopy.getEndPointReference());	
		originalStub.setFamily(stubNodeCopy.getFamily());
	}

	/**
	 * The old properties are restored in the stub (including its name, map, start and end nodes).
	 */
	public void undo() {
		setValues(oldStub);	
	}
}