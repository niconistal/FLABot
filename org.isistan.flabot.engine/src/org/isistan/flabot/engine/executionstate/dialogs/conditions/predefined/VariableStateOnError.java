/**
 * $Id: VariableStateOnError.java,v 1.2 2006/04/11 02:19:00 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.engine.executionstate.dialogs.conditions.predefined;

import org.isistan.flabot.engine.executionstate.dialogs.conditions.DefaultPredefinedCondition;
import org.isistan.flabot.engine.messages.Messages;

/**
 * @author $Author: franco $
 *
 */
public class VariableStateOnError extends DefaultPredefinedCondition {

	private String state;
	
	private String eventName;
	
	public VariableStateOnError(String state) {
		this.state = state;
		this.eventName = null;
	}
	
	public VariableStateOnError(String eventName, String state) {
		this(state);
		this.eventName = eventName;
	}
	
	public String getPrologCode() {
		return getHeading() + "\n\t" + //$NON-NLS-1$
			   "executionTag(T), isExitError(T)."; //$NON-NLS-1$
	}
		
	private String getHeading() {
		if (eventName == null)
			return "executionState('" + state + "'):-"; //$NON-NLS-1$ //$NON-NLS-2$
		
		return "eventState(" + eventName + ", '" + state + "'):-"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
	}
	
	public String getName() {
		return Messages.getString("org.isistan.flabot.engine.executionstate.dialogs.conditions.predefined.VariableStateOnError.name"); //$NON-NLS-1$
	}
	
	public String getDescription() {
		return Messages.getString("org.isistan.flabot.engine.executionstate.dialogs.conditions.predefined.VariableStateOnError.description", state); //$NON-NLS-1$
	}
	
	public boolean acceptProperty(int property) {
		return false;
	}
	
	public String getFieldName() {
		return state;
	}
}