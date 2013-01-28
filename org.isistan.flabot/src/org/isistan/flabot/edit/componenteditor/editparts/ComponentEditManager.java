/**
 * $Id: ComponentEditManager.java,v 1.1 2005/11/15 01:01:19 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.componenteditor.editparts;

import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.tools.CellEditorLocator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.widgets.Text;
import org.isistan.flabot.edit.editor.editparts.NoteEditManager;

/**
 * @author $Author: franco $
 *
 */
public class ComponentEditManager extends NoteEditManager {
	
	public ComponentEditManager(GraphicalEditPart source, CellEditorLocator locator) {	
		super(source, locator);
	}
	
	protected void initCellEditor() {
		super.initCellEditor();
		
		Text text = (Text)getCellEditor().getControl();		
		text.addKeyListener(new KeyListener() {			
			public void keyPressed(KeyEvent e) {
				if (e.keyCode == SWT.CR)
					commit();
			}
			
			public void keyReleased(KeyEvent e) {}
			
		});
	}
}