/**
 * $Id: ModifyConditionCommand.java,v 1.2 2006/03/21 01:51:57 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.ucmeditor.commands.model;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gef.commands.Command;
import org.isistan.flabot.coremodel.Condition;
import org.isistan.flabot.messages.Messages;

/**
 * ModifyConditionCommand
 * -	Modifies the properties of a Condition (including its name, type, useCaseMap,  sourceResponsibility, dependencyResponsibility, value, condition event and family).
 * -	The new properties are taken from another condition.
 * 
 * @author $Author: franco $
 *
 */
public class ModifyConditionCommand extends Command {

	private Condition condition;
	private final Condition newCondition;	
	private final Condition oldCondition;
	
	/**
	 * Instantiates a command that modifies the properties of a condition.
	 * @param condition the condition to modify
	 * @param newCondition the condition from where the new properties are taken  
	 */
	public ModifyConditionCommand (Condition condition, Condition newCondition) {
		this.condition = condition;
		this.newCondition = newCondition;
		this.oldCondition = (Condition)EcoreUtil.copy(condition);
		setLabel(Messages.getString("org.isistan.flabot.edit.ucmeditor.commands.model.ModifyConditionCommand.label")); //$NON-NLS-1$
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
	 * The new properties are set in the condition (including its name, type, useCaseMap,  sourceResponsibility, dependencyResponsibility, value, condition event and family).
	 */
	public void redo() {
		setValues(newCondition);
	}
	
	private void setValues(Condition conditionCopy) {
		condition.setName(conditionCopy.getName());
		condition.setType(conditionCopy.getType());
		condition.setUseCaseMap(conditionCopy.getUseCaseMap());
		condition.setSourceResponsibility(conditionCopy.getSourceResponsibility());
		condition.setDependencyResponsibility(conditionCopy.getDependencyResponsibility());		
		condition.setValue(conditionCopy.getValue());
		condition.setEvent(conditionCopy.getEvent());		
		condition.setFamily(conditionCopy.getFamily());
	}
	
	/**
	 * The old properties are restored in the condition (including its name, type, useCaseMap,  sourceResponsibility, dependencyResponsibility, value, condition event and family).
	 */
	public void undo() {
		setValues(oldCondition);
	}
}