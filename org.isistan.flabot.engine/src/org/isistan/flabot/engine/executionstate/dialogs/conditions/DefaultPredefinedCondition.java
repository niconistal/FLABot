/**
 * $Id: DefaultPredefinedCondition.java,v 1.4 2006/04/11 04:24:49 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.engine.executionstate.dialogs.conditions;

import java.util.HashMap;
import java.util.Map;

import org.isistan.flabot.engine.messages.Messages;

/**
 * @author usuario
 *
 */
public abstract class DefaultPredefinedCondition implements PredefinedCondition {
	
	private static final String[] EMPTY_ARRAY = new String[0];
	
	private Map<Integer, PredefinedCondition> properties = new HashMap<Integer, PredefinedCondition>();
			
	public abstract String getPrologCode();
	
	protected String getValueProperty(int property) {
		PredefinedCondition pp = properties.get(Integer.valueOf(property));
		if (pp == null)
			return ""; //$NON-NLS-1$
		
		return pp.getPrologCode();		
	}
	
	public void setPredefinedProperty(int property, PredefinedCondition value) {		
		if (acceptProperty(property))
			properties.put(Integer.valueOf(property), value);
	}
		
	public Map<Integer, PredefinedCondition> getProperties() {
		return properties;
	}	
		
	public abstract boolean acceptProperty(int property);
	
	public String getName() {
		return Messages.getString("org.isistan.flabot.engine.executionstate.dialogs.conditions.DefaultPredefinedCondition.name"); //$NON-NLS-1$
	}
	
	public String getDescription() {
		return Messages.getString("org.isistan.flabot.engine.executionstate.dialogs.conditions.DefaultPredefinedCondition.description"); //$NON-NLS-1$
	}
	
	public String[] getRequiredRules() {
		return EMPTY_ARRAY;
	}
}