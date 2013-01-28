/**
 * $Id: NoteCellEditorLocator.java,v 1.1 2005/10/18 21:46:58 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.editor.editparts;

import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.tools.CellEditorLocator;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.swt.widgets.Text;
import org.isistan.flabot.edit.editor.figures.NoteFigure;

/**
 * @author $Author: franco $
 *
 */
final public class NoteCellEditorLocator 
 implements CellEditorLocator {

	private NoteFigure note;

	public NoteCellEditorLocator(NoteFigure note) {
		setLabel(note);
	}

	public void relocate(CellEditor celleditor) {
		Text text = (Text)celleditor.getControl();
		Rectangle rect = note.getClientArea().getCopy();
		note.translateToAbsolute(rect);
		org.eclipse.swt.graphics.Rectangle trim = text.computeTrim(0, 0, 0, 0);
		rect.translate(trim.x, trim.y);
		rect.width += trim.width;
		rect.height += trim.height;
		text.setBounds(rect.x, rect.y, rect.width, rect.height);
	}

	/**
	 * Returns the Note figure.
	 */
	protected NoteFigure getLabel() {
		return note;
	}

	/**
	 * Sets the note figure.
	 * @param note The Note to set
	 */
	protected void setLabel(NoteFigure note) {
		this.note = note;
	}
}