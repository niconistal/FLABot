/**
 * $Id: MapViewVisualJumpEditPart.java,v 1.1 2006/03/01 22:26:40 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.mapview.editparts;

import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import org.isistan.flabot.edit.editormodel.NodeVisualModel;
import org.isistan.flabot.edit.mapview.MapViewPage;
import org.isistan.flabot.edit.ucmeditor.editparts.VisualDiagramJumpEditPart;

/**
 * @author franco
 *
 */
public class MapViewVisualJumpEditPart extends VisualDiagramJumpEditPart {
	
	@Override
	public void performRequest(Request req) {
		if (req.getType() == RequestConstants.REQ_OPEN) {
			// if the component is double-clicked, open its respective map			
			ScalableFreeformMapViewRootEditPart root = (ScalableFreeformMapViewRootEditPart) getRoot();
			MapViewPage page = root.getMapViewPage();
			NodeVisualModel targetNode = getCastedModel().getTargetVisualNode();
			page.showDiagram(getCastedModel().getTargetDiagram(), targetNode.getAbsoluteLocation().getX(), targetNode.getAbsoluteLocation().getY());	
		} else
			super.performRequest(req);
	}
}
