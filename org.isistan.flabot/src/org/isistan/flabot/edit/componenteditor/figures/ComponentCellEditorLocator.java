/**
 * $Id: ComponentCellEditorLocator.java,v 1.3 2005/12/22 22:37:47 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.componenteditor.figures;

import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.handles.HandleBounds;
import org.eclipse.gef.tools.CellEditorLocator;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.swt.widgets.Text;

/**
 * ComponentCellEditorLocator
 * 
 * Constraint for placing {@link org.eclipse.jface.viewers.CellEditor CellEditors}.
 * 
 *  @author $Author: franco $
 */
final public class ComponentCellEditorLocator implements CellEditorLocator {
	private HandleBounds figure;

	/**
	 * Instantiates an instance of ComponentCellEditorLocator
	 * @param figure the figure that used this cell editor
	 */
	public ComponentCellEditorLocator(HandleBounds figure) {
		setLabel(figure);		
	}

	/**
	 * Relocates a CellEditor.
	 * @param celleditor the CellEditor
	 */
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

	/**
	 * Sets the figure.
	 * @param figure the HandleBounds figure to set
	 */
	protected void setLabel(HandleBounds figure) {
		this.figure = figure;
	}
}