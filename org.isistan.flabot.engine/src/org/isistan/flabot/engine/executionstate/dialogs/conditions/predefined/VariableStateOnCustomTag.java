/**
 * $Id: VariableStateOnCustomTag.java,v 1.3 2006/04/11 02:19:00 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.engine.executionstate.dialogs.conditions.predefined;

import org.isistan.flabot.engine.executionstate.dialogs.conditions.DefaultPredefinedCondition;
import org.isistan.flabot.engine.executionstate.dialogs.conditions.PredefinedCondition;
import org.isistan.flabot.engine.messages.Messages;

/**
 * @author usuario
 *
 */
public class VariableStateOnCustomTag extends DefaultPredefinedCondition {
		
	private String state = ""; //$NON-NLS-1$
	
	private String eventName;
	
	public VariableStateOnCustomTag(String state) {
		this.state = state;
		this.eventName = null;
	}
	
	public VariableStateOnCustomTag(String eventName, String state) {
		this(state);
		this.eventName = eventName;
	}
	
	public String getPrologCode() {
		return  getHeading() + "\n\t" + //$NON-NLS-1$
			   	"executionTag(Tag),\n\t" +  //$NON-NLS-1$
				getValueProperty(PredefinedCondition.RETURN_VALUE_PROPERTY) + 
				getValueProperty(PredefinedCondition.ARGUMENTS_PROPERTY) +
				getValueProperty(PredefinedCondition.INSTANCE_PROPERTY) + ".";  //$NON-NLS-1$
	}		
	
	private String getHeading() {
		if (eventName == null)
			return "executionState('" + state + "'):-"; //$NON-NLS-1$ //$NON-NLS-2$
		
		return  "eventState(" + eventName + ", '" + state + "'):-"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
	}
	
	public String getName() {
		return Messages.getString("org.isistan.flabot.engine.executionstate.dialogs.conditions.predefined.VariableStateOnCustomTag.name"); //$NON-NLS-1$
	}
	
	public String getDescription() {
		return Messages.getString("org.isistan.flabot.engine.executionstate.dialogs.conditions.predefined.VariableStateOnCustomTag.description", state); //$NON-NLS-1$
	}
	
	public String getValueProperty(int property) {
		String stringProperty = super.getValueProperty(property);
		if (property == PredefinedCondition.RETURN_VALUE_PROPERTY) {
			if (stringProperty.trim().length() > 0 && (getProperties().get(Integer.valueOf(PredefinedCondition.ARGUMENTS_PROPERTY)) != null ||
					getProperties().get(Integer.valueOf(PredefinedCondition.INSTANCE_PROPERTY)) != null))
				stringProperty += ",\n\t"; //$NON-NLS-1$
		}
		
		if (property == PredefinedCondition.ARGUMENTS_PROPERTY) {
			if (stringProperty.trim().length() > 0 && getProperties().get(Integer.valueOf(PredefinedCondition.INSTANCE_PROPERTY)) != null)
				stringProperty += ",\n\t"; //$NON-NLS-1$
		}
		return stringProperty;
	}
	
	@Override
	public boolean acceptProperty(int property) {
		return 	PredefinedCondition.RETURN_VALUE_PROPERTY == property ||
				PredefinedCondition.ARGUMENTS_PROPERTY == property ||
				PredefinedCondition.INSTANCE_PROPERTY == property;
	}
	
	public String getFieldName() {
		return ""; //$NON-NLS-1$
	}
}