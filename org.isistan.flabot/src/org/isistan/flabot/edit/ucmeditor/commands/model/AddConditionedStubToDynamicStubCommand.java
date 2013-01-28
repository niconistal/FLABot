package org.isistan.flabot.edit.ucmeditor.commands.model;

import org.eclipse.gef.commands.Command;
import org.isistan.flabot.coremodel.ConditionedStub;
import org.isistan.flabot.coremodel.CoreModel;
import org.isistan.flabot.coremodel.DynamicStubNode;
import org.isistan.flabot.messages.Messages;

/**
 * 
 * @author $Author: Martin Villalba $
 *
 */
public class AddConditionedStubToDynamicStubCommand extends Command {
	
	private ConditionedStub conditionedStub;
	private DynamicStubNode dynamicStub;
	private CoreModel coreModel;
	
	private boolean wasAdded;
	
	/**
	 * Instantiates a command that can add a new conditioned stub to Dynamic Stub
	 * @param conditionedStub the new conditioned stub
	 * @param dynamicStub the dynamic stub where the conditioned stub has to be added
	 * @param coreModel the core model
	 */
	public AddConditionedStubToDynamicStubCommand(ConditionedStub conditionedStub, DynamicStubNode dynamicStub, CoreModel coreModel) {
		this.conditionedStub = conditionedStub;
		this.dynamicStub = dynamicStub;
		this.coreModel = coreModel;
		setLabel(Messages.getString("org.isistan.flabot.edit.ucmeditor.commands.model.AddConditionedStubToDynamicStubCommand.label")); //$NON-NLS-1$
	}

	public boolean canExecute() {
		return (conditionedStub != null && dynamicStub != null && coreModel != null);
	}
	
	/**
	 * The command can be undo if the conditioned stub was added to the dynamic stub.
	 * @return <code>true</code> if the command can be undone
	 */
	public boolean canUndo() {
		return wasAdded;		
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
	 * Adds the conditionedStub to the conditioned stub list.
	 */
	public void redo() {
			wasAdded = dynamicStub.getConditionedStubs().add(conditionedStub);
			coreModel.getConditionedStubs().add(conditionedStub);
	}
	
	/**
	 * Removes the conditionedStub from the conditioned stub list.
	 */
	public void undo() {
		dynamicStub.getConditionedStubs().remove(conditionedStub);
		coreModel.getConditionedStubs().remove(conditionedStub);
	}
}
