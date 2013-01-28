/**
 * $Id: AddConditionToResponsibilityCommand.java,v 1.3 2006/03/21 01:51:57 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.ucmeditor.commands.model;

import org.eclipse.gef.commands.Command;
import org.isistan.flabot.coremodel.Condition;
import org.isistan.flabot.coremodel.Responsibility;
import org.isistan.flabot.messages.Messages;

/**
 * AddConditionToResponsibilityCommand
 * -	Adds a new condition to a the list of preconditions or postcondition of a responsibility.
 * 
 *  @author $Author: franco $
 *
 */
public class AddConditionToResponsibilityCommand extends Command {
	
	private Responsibility responsibility;
	private Condition condition;
	private boolean isPreCondition;	
	
	private boolean wasAdded;
	
	/**
	 * Instantiates a command that can add a new condition to responsibility.
	 * @param responsibility the responsibility where the condition has to be added
	 * @param condition the new condition
	 * @param isPostCondition true if the condition will be added to the list of postcondition, otherwise it will be added to the list of preconditions
	 */
	public AddConditionToResponsibilityCommand(Responsibility responsibility, Condition condition, boolean isPreCondition) {
		this.responsibility = responsibility;
		this.condition = condition;
		this.isPreCondition = isPreCondition;
		setLabel(Messages.getString("org.isistan.flabot.edit.ucmeditor.commands.model.AddConditionToResponsibilityCommand.label")); //$NON-NLS-1$
	}

	public boolean canExecute() {
		return (responsibility != null && condition != null);
	}
	
	/**
	 * The command can be undo if the condition was added to the responsibility.
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
	 * Adds the conditions to the responsibility list.
	 */
	public void redo() {
		if (isPreCondition)
			wasAdded = responsibility.getPreconditions().add(condition);
		else
			wasAdded = responsibility.getPostconditions().add(condition);
		
		if (condition.getFamily() != null) {
			condition.getFamily().getAssociatedResponsibilities().add(condition.getSourceResponsibility());
		}
		
		if (condition.getEvent() != null) {
			condition.getEvent().getAssociatedConditions().add(condition);
		}
	}
	
	/**
	 * Removes the condition from the responsibility list.
	 */
	public void undo() {
		if (isPreCondition)
			responsibility.getPreconditions().remove(condition);
		else
			responsibility.getPostconditions().remove(condition);
		
		if (condition.getFamily() != null) {
			condition.getFamily().getAssociatedResponsibilities().remove(condition.getSourceResponsibility());
		}
		
		if (condition.getEvent() != null) {
			condition.getEvent().getAssociatedConditions().remove(condition);
		}
	}
}