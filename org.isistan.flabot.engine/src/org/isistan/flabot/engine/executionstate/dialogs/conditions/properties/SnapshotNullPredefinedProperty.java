/**
 * 
 */
package org.isistan.flabot.engine.executionstate.dialogs.conditions.properties;

import org.isistan.flabot.engine.executionstate.dialogs.conditions.DefaultPredefinedCondition;

/**
 * @author usuario
 *
 */
public class SnapshotNullPredefinedProperty extends DefaultPredefinedCondition {
		
	String name = ""; //$NON-NLS-1$
	
	public SnapshotNullPredefinedProperty(String name) {
		this.name = name;
	}
	
	
	public String getPrologCode() {				
		return 	"snapshotIsNull(" + name + ")"; 	
	}
	
	public String getFieldName() {
		return "";
	}	
	
	public boolean acceptProperty(int property) {
		return false;
	}
}