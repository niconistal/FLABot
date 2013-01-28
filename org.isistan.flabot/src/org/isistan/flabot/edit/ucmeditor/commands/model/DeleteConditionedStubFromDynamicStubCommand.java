package org.isistan.flabot.edit.ucmeditor.commands.model;

import org.eclipse.gef.commands.Command;
import org.isistan.flabot.coremodel.ConditionedStub;
import org.isistan.flabot.coremodel.CoreModel;
import org.isistan.flabot.coremodel.DynamicStubNode;
import org.isistan.flabot.messages.Messages;

/**
 * Removes a conditioned stub from the list conditioned stubs of a dynamic stub.
 * @author $Author: Martin Villalba $
 *
 */
public class DeleteConditionedStubFromDynamicStubCommand  extends Command {
	
	private ConditionedStub conditionedStub;
	private DynamicStubNode dynamicStub;
	private CoreModel coreModel;
	
	private boolean wasRemoved;
	
	/**
	 * Instantiates a command that can delete a conditioned stub from a dynamic stub
	 * @param responsibility the responsibility where the condition has to be deleted
	 * @param condition the condition
	 * @param coreModel the core model
	 */
	public DeleteConditionedStubFromDynamicStubCommand(ConditionedStub conditionedStub, DynamicStubNode dynamicStub, CoreModel coreModel) {
		this.conditionedStub = conditionedStub;
		this.dynamicStub = dynamicStub;
		this.coreModel = coreModel;
		setLabel(Messages.getString("org.isistan.flabot.edit.ucmeditor.commands.model.DeleteConditionedStubFromDynamicStubCommand.label")); //$NON-NLS-1$
	}

	public boolean canExecute() {
		return (conditionedStub != null && dynamicStub != null && coreModel != null);
	}
	
	/**
	 * The command can be undo if the conditioned stub was removed from the dynamic stub
	 * @return <code>true</code> if the command can be undone
	 */
	public boolean canUndo() {
		return wasRemoved;		
	}
	
	/**
	 * Executes the Command. This method should not be called if the Command is not
	 * executable.
	 * 
	 * @see redo()
	 */
	public void execute() {
		redo();		
	}	
	
	/**
	 * Removes the conditioned stub from the conditioned stub list.
	 */
	public void redo() {
			wasRemoved = dynamicStub.getConditionedStubs().remove(conditionedStub);
			coreModel.getConditionedStubs().remove(conditionedStub);
	}
	
	/**
	 * Adds the conditioned stub to the conditioned stub list.
	 */
	public void undo() {
		dynamicStub.getConditionedStubs().add(conditionedStub);
		coreModel.getConditionedStubs().add(conditionedStub);

	}
}
