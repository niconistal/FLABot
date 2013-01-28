/**
 * $Id: SnapshotFieldPredefinedProperty.java,v 1.2 2006/04/08 04:15:41 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.engine.executionstate.dialogs.conditions.properties;

import org.isistan.flabot.engine.executionstate.dialogs.conditions.DefaultPredefinedCondition;
import org.isistan.flabot.engine.executionstate.dialogs.conditions.PredefinedCondition;

/**
 * @author usuario
 *
 */
public class SnapshotFieldPredefinedProperty extends DefaultPredefinedCondition {
	
	StringMatchingPredefinedProperty matchingName;
	StringMatchingPredefinedProperty matchingValue;
	
	String fieldName = ""; //$NON-NLS-1$
	String fieldValue = ""; //$NON-NLS-1$
	String name = ""; //$NON-NLS-1$
	
	public SnapshotFieldPredefinedProperty(String name) {
		this.name = name;
		this.fieldName = name + "FieldName"; //$NON-NLS-1$
		this.fieldValue = name + "FieldValue"; //$NON-NLS-1$
		matchingName = new StringMatchingPredefinedProperty(fieldName);
		matchingValue = new StringMatchingPredefinedProperty(fieldValue);
	}
	
	
	public String getPrologCode() {
		return 	"snapshotField(" + getFieldName() + ", field(" + fieldName + ", " + fieldValue + ")),\n\t" + //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
				matchingName.getPrologCode() + ",\n\t" +  //$NON-NLS-1$
				matchingValue.getPrologCode();
	}
	
	
	public PredefinedCondition getMatchingName() {
		return matchingName;
	}
	
	public PredefinedCondition getMatchingValue() {
		return matchingValue;
	}
	
	public boolean acceptProperty(int property) {
		return false;
	}
	
	public String getFieldName() {
		return name;
	}
}