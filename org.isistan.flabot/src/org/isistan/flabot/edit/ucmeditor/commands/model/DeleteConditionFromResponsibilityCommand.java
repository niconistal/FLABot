/**
 * $Id: DeleteConditionFromResponsibilityCommand.java,v 1.2 2006/03/21 01:51:57 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.ucmeditor.commands.model;

import org.eclipse.gef.commands.Command;
import org.isistan.flabot.coremodel.Condition;
import org.isistan.flabot.coremodel.Responsibility;
import org.isistan.flabot.messages.Messages;

/**
 * DeleteConditionFromResponsibilityCommand
 * -	Removes a condition from the list of preconditions or postcondition of a responsibility.
 *  @author $Author: franco $
 *
 */
public class DeleteConditionFromResponsibilityCommand extends Command {
	
	private Responsibility responsibility;
	private Condition condition;
	private boolean isPreCondition;	
	
	private boolean wasRemoved;
	
	/**
	 * Instantiates a command that can delete a condition from a responsibility.
	 * @param responsibility the responsibility where the condition has to be deleted
	 * @param condition the condition
	 * @param isPostCondition true if the condition will be removed from the list of postcondition, otherwise it will be removed from the list of preconditions
	 */
	public DeleteConditionFromResponsibilityCommand(Responsibility responsibility, Condition condition, boolean isPreCondition) {
		this.responsibility = responsibility;
		this.condition = condition;
		this.isPreCondition = isPreCondition;
		setLabel(Messages.getString("org.isistan.flabot.edit.ucmeditor.commands.model.DeleteConditionFromResponsibilityCommand.label")); //$NON-NLS-1$
	}

	public boolean canExecute() {
		return (responsibility != null && condition != null);
	}
	
	/**
	 * The command can be undo if the condition was removed from the responsibility.
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
	 * Removes the condition from the responsibility list.
	 */
	public void redo() {
		if (isPreCondition)
			wasRemoved = responsibility.getPreconditions().remove(condition);
		else
			wasRemoved = responsibility.getPostconditions().remove(condition);
		
		if (condition.getFamily() != null) {
			condition.getFamily().getAssociatedResponsibilities().remove(condition.getSourceResponsibility());
		}
		
		if (condition.getEvent() != null) {
			condition.getEvent().getAssociatedConditions().remove(condition);
		}
	}
	
	/**
	 * Adds the conditions to the responsibility list.
	 */
	public void undo() {
		if (isPreCondition)
			responsibility.getPreconditions().add(condition);
		else
			responsibility.getPostconditions().add(condition);
		
		if (condition.getFamily() != null) {
			condition.getFamily().getAssociatedResponsibilities().add(condition.getSourceResponsibility());
		}
		
		if (condition.getEvent() != null) {
			condition.getEvent().getAssociatedConditions().add(condition);
		}

	}
}