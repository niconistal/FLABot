/**
 * $Id: DependencyToColorFactory.java,v 1.3 2006/03/02 01:39:23 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.ucmeditor.editparts;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.swt.graphics.Color;
import org.isistan.flabot.coremodel.Condition;

/**
* 
* @author $Author: franco $
*
*/
public class DependencyToColorFactory {
	private static final Map<String, Color> arrows = new HashMap<String, Color>();
		
	static {
		arrows.put(Condition.previous, ColorConstants.orange);
		arrows.put(Condition.mappingCondition, ColorConstants.yellow);
		arrows.put(Condition.constraintCondition, ColorConstants.gray);
		arrows.put(Condition.preconditionCondition, ColorConstants.blue);
	}
		
	public static Color getColor(String condition) {
		Color color = arrows.get(condition);
		if (color == null)
			color = ColorConstants.black;
		return color;
	}	
}