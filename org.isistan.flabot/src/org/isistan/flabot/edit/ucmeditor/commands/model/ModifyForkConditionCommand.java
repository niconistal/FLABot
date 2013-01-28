/**
 * $Id: ModifyForkConditionCommand.java,v 1.2 2006/03/21 01:51:57 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.ucmeditor.commands.model;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gef.commands.Command;
import org.isistan.flabot.coremodel.ForkCondition;
import org.isistan.flabot.messages.Messages;

/**
 *  EditForkConditionCommand
 * -	Modifies all the properties of a Fork Condition (including its name and condition).
 * -	The new properties are taken from another fork condtion.
 * 
 * @author $Author: franco $
 *
 */
public class ModifyForkConditionCommand extends Command {

	ForkCondition originalForkCondition;
	ForkCondition newForkCondition;
	ForkCondition oldForkCondition;
		
	/**
	 * Instantiates a command that modifies all the properties of a fork condition.
	 * @param originalForkCondition the fork condition to modify
	 * @param newForkCondition the fork condition from where the new properties are taken  
	 */
	public ModifyForkConditionCommand(ForkCondition originalForkCondition, ForkCondition newForkCondition) {
		this.originalForkCondition = originalForkCondition;
		this.newForkCondition = newForkCondition;
		this.oldForkCondition = (ForkCondition) EcoreUtil.copy(originalForkCondition);
		setLabel(Messages.getString("org.isistan.flabot.edit.ucmeditor.commands.model.ModifyForkConditionCommand.label")); //$NON-NLS-1$
	}
	
	/**
	 * Verifies that the command can be executed.
	 * @return <code>true</code> if the command can be executed	
	 */
	public boolean canExecute() {
		return (originalForkCondition!= null && newForkCondition != null && oldForkCondition != null);
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
	 * The new properties are set in the fork condition (including its name and condition).
	 */
	public void redo() {
		originalForkCondition.setName(newForkCondition.getName());
		originalForkCondition.setCondition(newForkCondition.getCondition());
	}
	
	/**
	 * The old properties are restored in the fork condition (including its name and condition).
	 */
	public void undo() {
		originalForkCondition.setName(oldForkCondition.getName());
		originalForkCondition.setCondition(oldForkCondition.getCondition());
	}
}
