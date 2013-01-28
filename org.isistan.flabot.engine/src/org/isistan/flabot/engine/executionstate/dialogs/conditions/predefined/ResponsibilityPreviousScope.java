/**
 * $Id: ResponsibilityPreviousScope.java,v 1.1 2006/04/08 04:15:41 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.engine.executionstate.dialogs.conditions.predefined;

import org.isistan.flabot.engine.executionstate.dialogs.conditions.DefaultPredefinedCondition;
import org.isistan.flabot.engine.messages.Messages;

/**
 * 
 * @author usuario
 *
 */
public class ResponsibilityPreviousScope extends DefaultPredefinedCondition {
		
	public String getPrologCode() {
		return 	"responsibilityPreFilterAccepts(Tag) :-\n\t" +  //$NON-NLS-1$
				"returnValue(Tag, Return),\n\t" + //$NON-NLS-1$
				"preScope(Scope),\n\t" + //$NON-NLS-1$
				"scopeAcceptsSnapshot(Scope, Tag).";  //$NON-NLS-1$
	}
			
	public String getName() {
		return Messages.getString("org.isistan.flabot.engine.executionstate.dialogs.conditions.predefined.ResponsibilityPreviousScope.name"); //$NON-NLS-1$
	}
	
	public boolean acceptProperty(int property) {
		return 	false;
	}
	
	public String getFieldName() {
		return ""; //$NON-NLS-1$
	}
}