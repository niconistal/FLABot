package org.isistan.flabot.executionstatemapping.editor.figures;

import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.handles.HandleBounds;
import org.eclipse.gef.tools.CellEditorLocator;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.swt.widgets.Text;

final public class StateCellEditorLocator implements CellEditorLocator {
	
	private HandleBounds figure;

	public StateCellEditorLocator(HandleBounds figure) {
		setLabel(figure);		
	}
	
	public void relocate(CellEditor celleditor) {
		Text text = (Text)celleditor.getControl();		
		Rectangle rect = figure.getHandleBounds();
		figure.translateToAbsolute(rect);
		org.eclipse.swt.graphics.Rectangle trim = text.computeTrim(0, 0, 0, 0);
		rect.translate(trim.x, trim.y);
		rect.width += trim.width;
		rect.height += trim.height;
		text.setBounds(rect.x + 15, rect.y + 15, rect.width - 30, rect.height - 30 );
	}

	/**
	 * Returns the HandleBounds Figure.
	 */
	protected HandleBounds getLabel() {
		return figure;
	}
	
	protected void setLabel(HandleBounds figure) {
		this.figure = figure;
	}
}