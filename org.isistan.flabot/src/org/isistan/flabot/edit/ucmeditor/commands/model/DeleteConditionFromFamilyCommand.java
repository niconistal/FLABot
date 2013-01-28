/**
 * $Id: DeleteConditionFromFamilyCommand.java,v 1.2 2006/04/12 21:41:04 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.ucmeditor.commands.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.gef.commands.Command;
import org.isistan.flabot.coremodel.ConditionEvent;
import org.isistan.flabot.coremodel.CoreModel;
import org.isistan.flabot.coremodel.Family;
import org.isistan.flabot.messages.Messages;

/**
 * @author $Author: franco $
 *
 */
public class DeleteConditionFromFamilyCommand extends Command {
	
	private Family family;
	private ConditionEvent conditionEvent;
	private CoreModel coreModel;
	private ConditionEvent value;
	
	private List<ConditionEvent> keys = new ArrayList<ConditionEvent>();
	
	public DeleteConditionFromFamilyCommand(CoreModel coreModel, Family family, ConditionEvent conditionEvent)  {
		this.family = family;
		this.conditionEvent = conditionEvent;
		this.coreModel = coreModel;
		setLabel(Messages.getString("org.isistan.flabot.edit.ucmeditor.commands.model.DeleteConditionFromFamilyCommand.label")); //$NON-NLS-1$
	}
	
	public boolean canExecute() {
		return (family != null);
	}
	
	public boolean canUndo() {
		return true;
	}
	
	public void execute() {
		//The condition is a value for keys
		for(Iterator iter=family.getEvents().keySet().iterator(); iter.hasNext();) {
			ConditionEvent key = (ConditionEvent) iter.next();
			if (key != conditionEvent && family.getEvents().get(key) == conditionEvent)
				keys.add(key);
		}
		
		value = (ConditionEvent)family.getEvents().get(conditionEvent);
		
		redo();
	}
	
	public void redo() {
		if (value != null)
			family.getEvents().remove(conditionEvent);
		
		ConditionEvent noneConditionEvent = getNoneEvent();
		for(ConditionEvent key: keys) {
			family.getEvents().put(key, noneConditionEvent);			
		}
			
	}
	
	private ConditionEvent getNoneEvent() {
		for(Iterator iter=coreModel.getEvents().iterator(); iter.hasNext();) {
			ConditionEvent ce = (ConditionEvent) iter.next();
			if (ce.getName().equals("none"))
				return ce;
		}
		return null;
	}
	
	public void undo() {
		if (value != null)
			family.getEvents().put(conditionEvent, value);
		
		for(ConditionEvent key: keys) {
			family.getEvents().put(key, conditionEvent);
		}
	}
}