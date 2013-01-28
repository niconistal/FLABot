/**
 * $Id: MapViewDiagramEditPart.java,v 1.2 2006/02/03 21:03:06 dacostae Exp $
 * $Author: dacostae $
 */
package org.isistan.flabot.edit.mapview.editparts;

import org.eclipse.gef.EditPolicy;
import org.isistan.flabot.edit.ucmeditor.editparts.UCMDiagramEditPart;

/**
 * @author $Author: dacostae $
 *
 */
public class MapViewDiagramEditPart extends UCMDiagramEditPart {
		
	@Override
	protected void createEditPolicies() {		
		installEditPolicy(EditPolicy.LAYOUT_ROLE,  null);
	}
}