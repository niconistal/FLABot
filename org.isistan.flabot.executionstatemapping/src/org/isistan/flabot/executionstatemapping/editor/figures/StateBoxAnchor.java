package org.isistan.flabot.executionstatemapping.editor.figures;

import org.eclipse.draw2d.ChopboxAnchor;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.handles.HandleBounds;

public class StateBoxAnchor extends ChopboxAnchor {
	
	public StateBoxAnchor(HandleBounds figure) {
		super(figure);
	}
	
	@Override
	protected Rectangle getBox() {
		return ((HandleBounds)getOwner()).getHandleBounds();
	}
}