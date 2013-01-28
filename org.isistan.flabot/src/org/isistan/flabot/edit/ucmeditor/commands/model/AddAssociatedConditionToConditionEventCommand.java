/**
 * $Id: AddAssociatedConditionToConditionEventCommand.java,v 1.3 2006/03/21 01:51:57 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.ucmeditor.commands.model;

import org.eclipse.gef.commands.Command;
import org.isistan.flabot.coremodel.Condition;
import org.isistan.flabot.coremodel.ConditionEvent;
import org.isistan.flabot.messages.Messages;

/**
 * AddAssociatedConditionToConditionEventCommand
 * -	Adds a conditions to the ConditionEvent's list of conditions.
 * 
 * @author $Author: franco $
 *
 */
public class AddAssociatedConditionToConditionEventCommand extends Command {
	
	private ConditionEvent conditionEvent;
	private Condition condition;
	
	/**
	 * Instantiates a command that can eletes a conditions from the ConditionEvent's list of conditions.
	 * @param conditionEvent the condition event where the condition event has to be added
	 * @param condition the condition to add
	 */
	public AddAssociatedConditionToConditionEventCommand(ConditionEvent conditionEvent, Condition condition)  {
		this.conditionEvent = conditionEvent;
		this.condition = condition;
		setLabel(Messages.getString("org.isistan.flabot.edit.ucmeditor.commands.model.AddAssociatedConditionToConditionEventCommand.label")); //$NON-NLS-1$
	}
	
	public boolean canExecute() {
		return (conditionEvent != null);
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
	 * Adds the condition to the ConditionEvent's list of conditions.
	 */
	public void redo() {
		conditionEvent.getAssociatedConditions().add(condition);
	}
	
	/**
	 * Removes the condition from the ConditionEvent's list of conditions.
	 */
	public void undo() {
		conditionEvent.getAssociatedConditions().remove(condition);
	}
}