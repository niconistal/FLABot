/**
 * $Id: PredefinedCondition.java,v 1.3 2006/04/11 04:24:49 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.engine.executionstate.dialogs.conditions;

import java.util.Map;

/**
 * @author $Author: franco $
 *
 */
public interface PredefinedCondition {
	
	public static final int NONE_PROPERTY = 1 << 1;
	
	public static final int RETURN_VALUE_PROPERTY = 1 << 2;
	
	public static final int ARGUMENTS_PROPERTY = 1 << 3;
	
	public static final int INSTANCE_PROPERTY = 1 << 4;
	
	public static final int SNAPSHOT_PROPERTY = 1 << 5;
	
	String getPrologCode();
	
	void setPredefinedProperty(int property, PredefinedCondition value);
	
	Map<Integer, PredefinedCondition> getProperties();
	
	String getName();
	
	String getDescription();
	
	String getFieldName();
	
	boolean acceptProperty(int property);
	
	String[] getRequiredRules();
}