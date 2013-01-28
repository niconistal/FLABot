/**
 * $Id: ReturnValuePredefinedProperty.java,v 1.3 2006/04/11 00:35:35 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.engine.executionstate.dialogs.conditions.properties;

import org.isistan.flabot.engine.executionstate.dialogs.conditions.DefaultPredefinedCondition;
import org.isistan.flabot.engine.executionstate.dialogs.conditions.PredefinedCondition;
import org.isistan.flabot.engine.executionstate.dialogs.conditions.SnapshotPredefinedCondition;

/**
 * @author usuario
 *
 */
public class ReturnValuePredefinedProperty extends DefaultPredefinedCondition implements SnapshotPredefinedCondition{
	
	private String fieldName = "ReturnValue"; //$NON-NLS-1$
	
	public String getPrologCode() {		
		String predefined = "returnValue(Tag, " + getFieldName() + "),\n\t" +   //$NON-NLS-1$ //$NON-NLS-2$
			getValueProperty(PredefinedCondition.SNAPSHOT_PROPERTY);
		return predefined;
	}
	
	protected String getValueProperty(int property) {
		String propertyString = super.getValueProperty(property);
		if (propertyString.trim().length() == 0)
			return "(NOT-SET)"; //$NON-NLS-1$
		
		return propertyString;		
	}
		
	public String getFieldName() {
		return fieldName;
	}
	
	public boolean acceptProperty(int property) {
		return PredefinedCondition.SNAPSHOT_PROPERTY == property;
	}
	
	public boolean acceptSnaptshot(int property) {
		return 	SnapshotPredefinedCondition.SNAPSHOT_TOSTRING_PROPERTY == property ||
				SnapshotPredefinedCondition.SNAPSHOT_FIELD_PROPERTY == property || 
				SnapshotPredefinedCondition.SNAPSHOT_OBJECT_PROPERTY == property ||
				SnapshotPredefinedCondition.SNAPSHOT_NULL_PROPERTY == property;
	}
}