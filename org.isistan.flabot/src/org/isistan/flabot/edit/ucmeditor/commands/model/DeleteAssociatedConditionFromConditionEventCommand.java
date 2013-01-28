/**
 * $Id: DeleteAssociatedConditionFromConditionEventCommand.java,v 1.3 2006/03/21 01:51:57 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.ucmeditor.commands.model;

import org.eclipse.gef.commands.Command;
import org.isistan.flabot.coremodel.Condition;
import org.isistan.flabot.coremodel.ConditionEvent;
import org.isistan.flabot.messages.Messages;

/**
 * @author $Author: franco $
 *
 */
public class DeleteAssociatedConditionFromConditionEventCommand extends Command {
	
	private ConditionEvent conditionEvent;
	private Condition condition;
	
	public DeleteAssociatedConditionFromConditionEventCommand(ConditionEvent conditionEvent, Condition condition)  {
		this.conditionEvent = conditionEvent;
		this.condition = condition;
		setLabel(Messages.getString("org.isistan.flabot.edit.ucmeditor.commands.model.DeleteAssociatedConditionFromConditionEventCommand.label")); //$NON-NLS-1$
	}
	
	public boolean canExecute() {
		return (conditionEvent != null);
	}
	
	public void execute() {
		redo();		
	}
	
	public void redo() {
		conditionEvent.getAssociatedConditions().remove(condition);
	}
	
	public void undo() {
		conditionEvent.getAssociatedConditions().add(condition);		
	}
}