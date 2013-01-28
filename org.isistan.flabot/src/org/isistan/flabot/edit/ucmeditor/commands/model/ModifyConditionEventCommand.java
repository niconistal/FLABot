/**
 * $Id: ModifyConditionEventCommand.java,v 1.2 2006/03/21 01:51:57 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.ucmeditor.commands.model;

import java.util.List;

import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gef.commands.Command;
import org.isistan.flabot.coremodel.ConditionEvent;
import org.isistan.flabot.messages.Messages;

/**
 * ModifyConditionEventCommand
 * -	Modifies the properties of a Condition Event (including its name, description and condition event).
 * -	The new properties are taken from another condition event.
 * 
 * @author $Author: franco $
 *
 */
public class ModifyConditionEventCommand extends Command {

	private ConditionEvent conditionEvent;
	private final ConditionEvent newConditionEvent;	
	private final ConditionEvent oldConditionEvent;
	
	/**
	 * Instantiates a command that modifies the properties of a condition event.
	 * @param conditionEvent the condition event to modify
	 * @param newConditionEvent the condition event from where the new properties are taken  
	 */
	public ModifyConditionEventCommand (ConditionEvent conditionEvent, ConditionEvent newConditionEvent) {
		this.conditionEvent = conditionEvent;
		this.newConditionEvent = newConditionEvent;
		this.oldConditionEvent = (ConditionEvent)EcoreUtil.copy(conditionEvent);
		setLabel(Messages.getString("org.isistan.flabot.edit.ucmeditor.commands.model.ModifyConditionEventCommand.label")); //$NON-NLS-1$
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
	 * The new properties are set in the condition event (including its name, description and condition event).
	 */
	public void redo() {
		setValues(newConditionEvent);
	}
	
	private void setValues(ConditionEvent conditionEventCopy) {
		conditionEvent.setName(conditionEventCopy.getName());
		conditionEvent.setDescription(conditionEventCopy.getDescription());
		conditionEvent.setConditionEvent(conditionEventCopy.getConditionEvent());
		
		conditionEvent.getExtendedData().clear();
		conditionEvent.getExtendedData().addAll( (List) EcoreUtil.copyAll(conditionEventCopy.getExtendedData()) );
	}
	
	/**
	 * The old properties are restored in the condition event (including its name, description and condition event).
	 */
	public void undo() {
		setValues(oldConditionEvent);
	}
}