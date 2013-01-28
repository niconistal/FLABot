/**
 * $Id: SnapshotObjectPredefinedProperty.java,v 1.2 2006/04/08 04:15:41 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.engine.executionstate.dialogs.conditions.properties;

import org.isistan.flabot.engine.executionstate.dialogs.conditions.DefaultPredefinedCondition;
import org.isistan.flabot.engine.executionstate.dialogs.conditions.PredefinedCondition;

/**
 * @author usuario
 *
 */
public class SnapshotObjectPredefinedProperty extends DefaultPredefinedCondition {
	
	StringMatchingPredefinedProperty matchingToString;
	
	String fieldValue = ""; //$NON-NLS-1$
	String name = ""; //$NON-NLS-1$
	
	public SnapshotObjectPredefinedProperty(String name) {
		this.name = name;
		this.fieldValue = name + "Object"; //$NON-NLS-1$
		matchingToString = new StringMatchingPredefinedProperty(name + "Descriptor"); //$NON-NLS-1$
	}
	
	public String getPrologCode() {				
		return 	"snapshotObject(" + name + ", " + fieldValue + "),\n\t" + //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				"objectClass(" + fieldValue + ", " + name + "Class),\n\t" + //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				"classDescriptor(" + name + "Class, " + name + "Descriptor),\n\t" +  //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				matchingToString.getPrologCode();
	}
	
	public String getFieldName() {
		return fieldValue;
	}
	
	public PredefinedCondition getMatchingToString() {
		return matchingToString;
	}
		
	public boolean acceptProperty(int property) {
		return false;
	}
}