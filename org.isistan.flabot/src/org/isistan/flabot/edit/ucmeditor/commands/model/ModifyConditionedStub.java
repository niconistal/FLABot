package org.isistan.flabot.edit.ucmeditor.commands.model;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gef.commands.Command;
import org.isistan.flabot.coremodel.Condition;
import org.isistan.flabot.coremodel.ConditionedStub;
import org.isistan.flabot.coremodel.CoremodelFactory;
import org.isistan.flabot.coremodel.StubNode;
import org.isistan.flabot.messages.Messages;

/**
 * Modifies the properties of a Conditioned stub
 * The new properties are taken from another conditioned stub.
 * @author $Author: Martin Villalba $
 *
 */
public class ModifyConditionedStub extends Command {

	private ConditionedStub conditionedStub;
	private final ConditionedStub newConditionedStub;	
	private final ConditionedStub oldConditionedStub;
	
	/**
	 * Instantiates a command that modifies the properties of a conditioned stub.
	 * @param condition the condition to modify
	 * @param newCondition the condition from where the new properties are taken  
	 */
	public ModifyConditionedStub (ConditionedStub conditionedStub, ConditionedStub newConditionedStub) {
		this.conditionedStub = conditionedStub;
		this.newConditionedStub = newConditionedStub;
		this.oldConditionedStub = (ConditionedStub)EcoreUtil.copy(conditionedStub);
		setLabel(Messages.getString("org.isistan.flabot.edit.ucmeditor.commands.model.ModifyConditionedStubCommand.label")); //$NON-NLS-1$
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
	 * The new properties are set in the conditioned stub
	 */
	public void redo() {
		setValues(newConditionedStub);
	}
	
	private void setValues(ConditionedStub conditionedStubCopy) {
		conditionedStub.setResponsibilityNode(conditionedStubCopy.getResponsibilityNode());
		StubNode stub = CoremodelFactory.eINSTANCE.createStubNode(conditionedStubCopy.getStub());
		conditionedStub.setStub(stub);
		conditionedStub.setName(conditionedStubCopy.getName());
	}
	
	/**
	 * The old properties are restored in the conditioned stub
	 */
	public void undo() {
		setValues(oldConditionedStub);
	}
}
