/**
 * $Id: AddConditionEventToCoreModelCommand.java,v 1.3 2006/03/21 01:51:57 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.ucmeditor.commands.model;

import org.eclipse.gef.commands.Command;
import org.isistan.flabot.coremodel.ConditionEvent;
import org.isistan.flabot.coremodel.CoreModel;
import org.isistan.flabot.messages.Messages;

/**
 * AddConditionEventToCoreModel
 * -	Adds a new condition event to a the list of events of the core model.
 *
 *  @author $Author: franco $
 *
 */
public class AddConditionEventToCoreModelCommand extends Command {
	
	private CoreModel coreModel;
	private ConditionEvent conditionEvent;
	
	private boolean wasAdded;
	
	/**
	 * Instantiates a command that can add a new condition event to the core model.
	 * @param coreModel the core model where the condition event has to be added
	 * @param conditionEvent the new condition event
	 */
	public AddConditionEventToCoreModelCommand(CoreModel coreModel, ConditionEvent conditionEvent) {
		this.coreModel = coreModel;
		this.conditionEvent = conditionEvent;
		setLabel(Messages.getString("org.isistan.flabot.edit.ucmeditor.commands.model.AddConditionEventToCoreModelCommand.label")); //$NON-NLS-1$
	}

	public boolean canExecute() {
		return (coreModel != null && conditionEvent != null);
	}
	
	/**
	 * The command can be undo if the condition event was added to the core model list.
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
	 * Adds the condition event to the core model list.
	 */
	public void redo() {
		wasAdded = coreModel.getConditionEvents().add(conditionEvent);
	}
	
	/**
	 * Removes the condition event from the core model list.
	 */
	public void undo() {
		coreModel.getEvents().remove(conditionEvent);
	}
}