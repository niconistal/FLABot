/**
 * $Id: DependencyToLineStyleFactory.java,v 1.2 2006/02/21 21:35:52 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.ucmeditor.editparts;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.swt.SWT;
import org.isistan.flabot.coremodel.Condition;

/**
 * @author $Author: franco $
 *
 */
public class DependencyToLineStyleFactory {
	
	private static final Map<String, Integer> styles = new HashMap<String, Integer>();
	
	static {
		styles.put(Condition.previous, new Integer(SWT.LINE_SOLID));
		styles.put(Condition.mappingCondition, new Integer(SWT.LINE_SOLID));
		styles.put(Condition.constraintCondition, new Integer(SWT.LINE_DOT));
		styles.put(Condition.preconditionCondition, new Integer(SWT.LINE_DASH));
	}
	
	public static int getLineStyle(String condition) {
		Integer lineStyle = styles.get(condition);
		if (lineStyle == null)
			return SWT.LINE_SOLID;
		
		return lineStyle.intValue();
	}		
}