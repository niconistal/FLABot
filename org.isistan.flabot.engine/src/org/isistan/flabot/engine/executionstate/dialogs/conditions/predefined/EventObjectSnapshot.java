/**
 * $Id: EventObjectSnapshot.java,v 1.4 2006/04/11 04:24:49 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.engine.executionstate.dialogs.conditions.predefined;

import java.util.Iterator;

import org.isistan.flabot.engine.executionstate.dialogs.conditions.DefaultPredefinedCondition;
import org.isistan.flabot.engine.executionstate.dialogs.conditions.PredefinedCondition;
import org.isistan.flabot.engine.messages.Messages;

/**
 * @author usuario
 *
 */
public class EventObjectSnapshot extends DefaultPredefinedCondition {
		
	String eventName = ""; //$NON-NLS-1$
	
	public EventObjectSnapshot(String eventName) {
		this.eventName = eventName;
	}
	
	public String getPrologCode() {
		return 	getHeading() + 				
				getValueProperty(PredefinedCondition.RETURN_VALUE_PROPERTY) + 
				getValueProperty(PredefinedCondition.ARGUMENTS_PROPERTY) +
				getValueProperty(PredefinedCondition.INSTANCE_PROPERTY) + ".";  //$NON-NLS-1$
	}
	
	protected String getHeading() {
		if (!hasValidProperties()) {
			return "eventPreFilter(" + eventName + ")"; //$NON-NLS-1$ //$NON-NLS-2$
		} else  {
			return "eventPreFilterAccepts(" + eventName + ", Tag) :-\n\t"; //$NON-NLS-1$ //$NON-NLS-2$
		}
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

	protected boolean hasValidProperties() {
		for (Iterator<Integer> iter=getProperties().keySet().iterator(); iter.hasNext();) {
			if (getProperties().get(iter.next()) != null)
				return true;			
		}
		return false;
	}
		
	public String getName() {
		return Messages.getString("org.isistan.flabot.engine.executionstate.dialogs.conditions.predefined.EventObjectSnapshot.name"); //$NON-NLS-1$
	}
	
	public boolean acceptProperty(int property) {
		return 	PredefinedCondition.RETURN_VALUE_PROPERTY == property ||
				PredefinedCondition.ARGUMENTS_PROPERTY == property || 
				PredefinedCondition.INSTANCE_PROPERTY == property;
	}
	
	public String getFieldName() {
		return eventName;
	}
	
	public String[] getRequiredRules() {
		if (hasValidProperties())
			return new String[]{"eventPreFilter(" + eventName + ")."}; //$NON-NLS-1$ //$NON-NLS-2$
		return super.getRequiredRules();
	}
}