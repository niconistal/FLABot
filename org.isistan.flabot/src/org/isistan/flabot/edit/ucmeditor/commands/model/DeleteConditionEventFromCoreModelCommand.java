/**
 * $Id: DeleteConditionEventFromCoreModelCommand.java,v 1.3 2006/04/11 23:31:50 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.ucmeditor.commands.model;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.isistan.flabot.coremodel.Condition;
import org.isistan.flabot.coremodel.ConditionEvent;
import org.isistan.flabot.coremodel.CoreModel;
import org.isistan.flabot.coremodel.Family;
import org.isistan.flabot.coremodel.Responsibility;
import org.isistan.flabot.messages.Messages;

/**
 * DeleteConditionEventFromCoreModel
 * -	Deletes a condition event from the list of events of the core model.
 *  @author $Author: franco $
 *
 */
public class DeleteConditionEventFromCoreModelCommand extends Command {
	
	private CompoundCommand removedDependencies = new CompoundCommand();
	
	private CoreModel coreModel;
	private ConditionEvent conditionEvent;
	
	private boolean wasRemoved;
	
	/**
	 * Instantiates a command that can delete a condition event from the core model.
	 * @param coreModel the core model where the condition event has to be removed
	 * @param conditionEvent the condition event
	 */
	public DeleteConditionEventFromCoreModelCommand(CoreModel coreModel, ConditionEvent conditionEvent) {
		this.coreModel = coreModel;
		this.conditionEvent = conditionEvent;
		setLabel(Messages.getString("org.isistan.flabot.edit.ucmeditor.commands.model.DeleteConditionEventFromCoreModelCommand.label")); //$NON-NLS-1$
	}

	public boolean canExecute() {
		return (coreModel != null && conditionEvent != null);
	}
	
	/**
	 * The command can be undo if the condition event was removed from the core model list.
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
		//Deletes the Associated Conditions from it responsibility
		for (int i=0; i < conditionEvent.getAssociatedConditions().size(); i++){			
			Condition condition = (Condition) conditionEvent.getAssociatedConditions().get(i);			
			Responsibility responsibility = condition.getSourceResponsibility().getResponsibility();
			removedDependencies.add(new DeleteConditionFromResponsibilityCommand(responsibility, condition, true));
		}
		for(int i=0; i<coreModel.getFamilies().size(); i++) {
			Family family = (Family) coreModel.getFamilies().get(i);
			if (family.getEvents().containsKey(conditionEvent) ||
					family.getEvents().containsValue(conditionEvent))
				removedDependencies.add(new DeleteConditionFromFamilyCommand(coreModel, family, conditionEvent));	
			
		}
		removedDependencies.execute();
		
		doDeleteConditionEvent();		
	}
	
	
	/**
	 * Removes the condition event from the core model list.
	 */
	private void doDeleteConditionEvent() {
		wasRemoved = coreModel.getConditionEvents().remove(conditionEvent);
	}
	
	/**
	 * Adds the condition event to the core model list.
	 */
	private void undoDeleteConditionEvent() {
		coreModel.getConditionEvents().add(conditionEvent);
	}
		
	public void redo() {
		removedDependencies.redo();
		doDeleteConditionEvent();	
	}
	
	public void undo() {
		undoDeleteConditionEvent();
		removedDependencies.undo();
	}
}