/**
 * $Id: MapViewComponentEditPart.java,v 1.1 2006/01/31 23:30:38 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.mapview.editparts;

import org.eclipse.gef.EditPolicy;
import org.isistan.flabot.edit.ucmeditor.editparts.ComponentEditPart;

/**
 * @author usuario
 *
 */
public class MapViewComponentEditPart extends ComponentEditPart {
	
	@Override
	protected void createEditPolicies() {
		super.createEditPolicies();		
		installEditPolicy(EditPolicy.LAYOUT_ROLE,  null);
	}
}