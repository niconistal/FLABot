/**
 * $Id: ModifyPrologCodeConditionEventCommand.java,v 1.1 2006/04/08 01:45:29 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.ucmeditor.commands.model;

import org.eclipse.gef.commands.Command;
import org.isistan.flabot.coremodel.ConditionEvent;
import org.isistan.flabot.messages.Messages;

/**
 * ModifyPrologCodeConditionEventCommand
 * -	Modifies the prolog code of a Condition Event.
 * 
 * @author $Author: franco $
 *
 */
public class ModifyPrologCodeConditionEventCommand extends Command {

	private ConditionEvent conditionEvent;
	private final String oldPrologCode;	
	private final String newPrologCode;
	
	/**
	 * Instantiates a command that modifies the prolog code of a condition event.
	 * @param conditionEvent the condition event to modify
	 * @param prologCode the prologCode to add  
	 */
	public ModifyPrologCodeConditionEventCommand (ConditionEvent conditionEvent, String prologCode) {
		this.conditionEvent = conditionEvent;
		this.newPrologCode = prologCode;
		this.oldPrologCode = conditionEvent.getConditionEvent();
		setLabel(Messages.getString("org.isistan.flabot.edit.ucmeditor.commands.model.ModifyPrologCodeConditionEventCommand.label")); //$NON-NLS-1$
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
	 * The new prolog code is set in the condition event.
	 */
	public void redo() {
		setValues(newPrologCode);
	}
	
	private void setValues(String prologCode) {
		conditionEvent.setConditionEvent(prologCode);
	}
	
	/**
	 * The old prolog code is restored in the condition event.
	 */
	public void undo() {
		setValues(oldPrologCode);
	}
}
