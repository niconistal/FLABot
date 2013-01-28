/**
 * $Id: CopyAction.java,v 1.13 2006/03/17 22:28:02 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.ucmeditor.actions;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.gef.editparts.AbstractConnectionEditPart;
import org.eclipse.ui.IWorkbenchPart;
import org.isistan.flabot.edit.editor.editparts.NoteEditPart;
import org.isistan.flabot.edit.ucmeditor.editparts.ComponentEditPart;
import org.isistan.flabot.edit.ucmeditor.editparts.PathNodeEditPart;

/**
 * This action is used to copy elements from the UCM diagram 
 * 
 * @author $Author: franco $
 *
 */
public class CopyAction extends org.isistan.flabot.edit.editor.actions.CopyAction {

	private int components;
	
	private int paths;
	
	private int notes;
	
	/**
	 * Creates a new CopyAction in the given workbench part
	 * @param part
	 */
	public CopyAction(IWorkbenchPart part) {
		super(part);		
	}
	
	/**
	 * Determines whether the action should be enabled or not.
	 * @return true if selection consists of only components or ports (path copy is not yet allowed), false otherwise
	 */
	@Override
	protected boolean calculateEnabled() {
		return canPerformAction();
	}

	/**
	 * Determines whether the action should be enabled or not.
	 * @return true if selection consists of only components or ports (path copy is not yet allowed), false otherwise
	 */
	private boolean canPerformAction() {	
		List selection = getSelectedObjects();
		if (selection == null ||
				selection.isEmpty()) return false;
		
		checkSelection(getSelectedObjects());
		if (paths > 0)
			return false;
			
		if (components > 0 || notes > 0)
			return true;
		
		return false;
	}
	
	/**
	 * Count the number of selected edit parts of each kind
	 * @param parts
	 */
	private void checkSelection(List parts) {
		connections = new ArrayList();
		paths = 0;
		components = 0;
		notes = 0;
		for (int i=0; i<parts.size(); i++) {
			if (parts.get(i) instanceof PathNodeEditPart)
				paths++;
			if (parts.get(i) instanceof ComponentEditPart)
				components++;
			if (parts.get(i) instanceof NoteEditPart)
				notes++;
			if (parts.get(i) instanceof AbstractConnectionEditPart)
				connections.add(parts.get(i));
		}
	}
}