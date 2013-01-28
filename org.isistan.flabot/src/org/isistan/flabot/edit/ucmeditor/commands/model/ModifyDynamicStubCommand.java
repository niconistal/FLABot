package org.isistan.flabot.edit.ucmeditor.commands.model;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gef.commands.Command;
import org.isistan.flabot.coremodel.ConditionedStub;
import org.isistan.flabot.coremodel.CoreModel;
import org.isistan.flabot.coremodel.CoremodelPackage;
import org.isistan.flabot.coremodel.DynamicStubNode;
import org.isistan.flabot.coremodel.impl.DynamicStubNodeImpl;
import org.isistan.flabot.messages.Messages;

/**
 * 
 * @author $Author: Martin Villalba $
 *
 */
public class ModifyDynamicStubCommand extends Command {

	private DynamicStubNode originalDynamicStub;
	private DynamicStubNode newDynamicStub;
	private DynamicStubNode oldDynamicStub;
	private CoreModel coreModel;
		
	/**
	 * Instantiates a command that modifies all the properties of a dynamic stub.
	 * @param visualDynamicStub the dynamic stub to modify
	 * @param newDynamicStub the dynamic stub from where the new properties are taken  
	 */
	public ModifyDynamicStubCommand(DynamicStubNode originalDynamicStub, DynamicStubNode newDynamicStub, CoreModel coreModel) {
		this.originalDynamicStub = originalDynamicStub;
		this.newDynamicStub = newDynamicStub;
		this.oldDynamicStub = (DynamicStubNode) EcoreUtil.copy(originalDynamicStub);
		this.coreModel = coreModel;
		setLabel(Messages.getString("org.isistan.flabot.edit.ucmeditor.commands.model.ModifyDynamicStubCommand.label")); //$NON-NLS-1$
	}
	
	/**
	 * Verifies that the command can be executed.
	 * @return <code>true</code> if the command can be executed	
	 */
	public boolean canExecute() {
		return (originalDynamicStub != null && newDynamicStub != null);
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
	 * The new properties are set in the dynamic stub
	 */
	public void redo() {
//		for(int i=0; i < oldDynamicStub.getConditionedStubs().size(); i++)
//		{
//			ConditionedStub conditionedStub = (ConditionedStub)oldDynamicStub.getConditionedStubs().get(i);
//			coreModel.getConditionedStubs().remove(conditionedStub);
//			//coreModel.getStubs().remove(conditionedStub.getStub());
//		}
//		
//		for(int i=0; i < newDynamicStub.getConditionedStubs().size(); i++)
//		{
//			ConditionedStub conditionedStub = (ConditionedStub)newDynamicStub.getConditionedStubs().get(i);
//			coreModel.getConditionedStubs().add(conditionedStub);
//			//coreModel.getStubs().add(conditionedStub.getStub());
//		}
		
		setValues(newDynamicStub);
		
		
	}
	
	private void setValues(DynamicStubNode dynamicStubNodeCopy) {
		
		originalDynamicStub.setName(dynamicStubNodeCopy.getName());
		//((DynamicStubNodeImpl)originalDynamicStub).eSet(CoremodelPackage.DYNAMIC_STUB_NODE__CONDITIONED_STUBS, dynamicStubNodeCopy.getConditionedStubs());
		//((DynamicStubNodeImpl)originalDynamicStub).eSet(CoremodelPackage.DYNAMIC_STUB_NODE__CONDITIONED_STUBS, EcoreUtil.copyAll(dynamicStubNodeCopy.getConditionedStubs()));
		
	}

	/**
	 * The old properties are restored in the dynamic stub
	 */
	public void undo() {
//		for(int i=0; i < newDynamicStub.getConditionedStubs().size(); i++)
//		{
//			ConditionedStub conditionedStub = (ConditionedStub)newDynamicStub.getConditionedStubs().get(i);
//			coreModel.getConditionedStubs().remove(conditionedStub);
//			//coreModel.getStubs().remove(conditionedStub.getStub());
//		}
//		
//		for(int i=0; i < oldDynamicStub.getConditionedStubs().size(); i++)
//		{
//			ConditionedStub conditionedStub = (ConditionedStub)oldDynamicStub.getConditionedStubs().get(i);
//			coreModel.getConditionedStubs().add(conditionedStub);
//			//coreModel.getStubs().add(conditionedStub.getStub());
//		}
		
		setValues(oldDynamicStub);	
	}
}
