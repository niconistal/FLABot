/**
 * $Id: DeleteComponentDiagramCommand.java,v 1.13 2006/03/10 20:34:46 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.componenteditor.commands;

import java.util.Iterator;
import java.util.List;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.requests.GroupRequest;
import org.isistan.flabot.edit.componenteditor.editparts.ComponentDiagramEditPart;
import org.isistan.flabot.messages.Messages;

/**
 * DeleteComponentDiagramCommand 
 * -	Deletes the component diagram and all the edit parts existing in it.
 * 
 * @author $Author: franco $
 *
 */
public class DeleteComponentDiagramCommand extends CompoundCommand {

	/**
	 * the edit part associated with the diagram model
	 */
	private ComponentDiagramEditPart editPart;
	
	/**
	 * Instantiates a command that can delete a component diagram. 
	 * @param editPart the editPart of the component diagram to be deleted
	 */
	public DeleteComponentDiagramCommand(ComponentDiagramEditPart editPart) {
		this.editPart = editPart;
		setLabel(Messages.getString("org.isistan.flabot.edit.componenteditor.commands.DeleteComponentDiagramCommand.label")); //$NON-NLS-1$
	}
	
	public boolean canExecute() {
		return true;
	}
	
	/**
	 * Deletes the component diagram and executes a delete command for every edit part children.
	 */
	public void execute() {	    	
		List children = editPart.getChildren();
		for (Iterator iter=children.iterator(); iter.hasNext();) {
			EditPart selectionEditPart = (EditPart) iter.next();
			GroupRequest r = new GroupRequest();
			r.setEditParts(selectionEditPart);
			r.setType(RequestConstants.REQ_DELETE);
			add(selectionEditPart.getCommand(r));
		}
		super.execute();
	}
}