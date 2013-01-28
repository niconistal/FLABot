package org.isistan.flabot.executionstatemapping.editor.editparts;

import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.tools.CellEditorLocator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.widgets.Text;
import org.isistan.flabot.edit.editor.editparts.NoteEditManager;

public class StateEditManager extends NoteEditManager {
	
	public StateEditManager(GraphicalEditPart source, CellEditorLocator locator) {	
		super(source, locator);
	}
	
	@Override
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