/** * $Id: BendpointCommand.java,v 1.4 2006/01/27 00:09:19 mblech Exp $ * $Author: mblech $ */package org.isistan.flabot.edit.editor.commands.bendpoints;

import org.eclipse.draw2d.geometry.Dimension;import org.eclipse.draw2d.geometry.Point;import org.eclipse.gef.commands.Command;import org.isistan.flabot.edit.editormodel.ConnectionVisualModel;public class BendpointCommand extends Command 
{

	protected int index;
	protected Point location;
	protected ConnectionVisualModel connectioModel;
	private Dimension d1, d2;

	protected Dimension getFirstRelativeDimension() {
		return d1;
	}

	protected Dimension getSecondRelativeDimension() {
		return d2;
	}

	protected int getIndex() {
		return index;
	}

	protected Point getLocation() {
		return location;
	}

	protected ConnectionVisualModel getConnection() {
		return connectioModel;
	}

	public void redo() {
		execute();
	}

	public void setRelativeDimensions(Dimension dim1, Dimension dim2) {
		d1 = dim1;
		d2 = dim2;
	}

	public void setIndex(int i) {
		index = i;
	}

	public void setLocation(Point p) {
		location = p;
	}

	public void setConnection(ConnectionVisualModel w) {
		connectioModel = w;
	}
}