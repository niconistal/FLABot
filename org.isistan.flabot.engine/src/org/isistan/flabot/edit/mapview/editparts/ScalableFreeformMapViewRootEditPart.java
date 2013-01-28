/**
 * $Id: ScalableFreeformMapViewRootEditPart.java,v 1.1 2006/01/31 23:30:38 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.mapview.editparts;

import org.eclipse.gef.editparts.ScalableFreeformRootEditPart;
import org.isistan.flabot.edit.mapview.MapViewPage;

/**
 * @author $Author: franco $
 *
 */
public class ScalableFreeformMapViewRootEditPart extends ScalableFreeformRootEditPart{
	
	MapViewPage page;
	
	public ScalableFreeformMapViewRootEditPart(MapViewPage page) {
		this.page = page;
	}
	
	public MapViewPage getMapViewPage() {
		return page;
	}
}