/**
 * $Id: EventPreviousScope.java,v 1.2 2006/04/11 02:19:00 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.engine.executionstate.dialogs.conditions.predefined;

import org.isistan.flabot.engine.executionstate.dialogs.conditions.DefaultPredefinedCondition;
import org.isistan.flabot.engine.messages.Messages;

/**
 * @author usuario
 *
 */
public class EventPreviousScope extends DefaultPredefinedCondition {

	private String eventName;
	
	public EventPreviousScope(String eventName) {
		this.eventName = eventName;
	}
	
	public String getPrologCode() {
		return "eventPreFilter(" + eventName + "):-\n\t" + //$NON-NLS-1$ //$NON-NLS-2$
			   "preScope(PreScope),\n\t" +  //$NON-NLS-1$
			   "argument(Tag, Argument),\n\t" + //$NON-NLS-1$
			   "scopeAcceptsSnapshot(PreScope, Argument)."; //$NON-NLS-1$
	}
		
	public String getName() {
		return Messages.getString("org.isistan.flabot.engine.executionstate.dialogs.conditions.predefined.EventPreviousScope.name"); //$NON-NLS-1$
	}
	
	public boolean acceptProperty(int property) {
		return false;
	}
	
	public String getFieldName() {
		return eventName;
	}
}