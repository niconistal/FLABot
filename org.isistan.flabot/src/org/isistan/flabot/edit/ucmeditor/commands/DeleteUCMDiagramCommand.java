/**
 * $Id: DeleteUCMDiagramCommand.java,v 1.3 2006/03/21 01:51:58 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.ucmeditor.commands;

import java.util.Iterator;
import java.util.List;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.requests.GroupRequest;
import org.isistan.flabot.coremodel.PathNode;
import org.isistan.flabot.edit.editormodel.VisualModel;
import org.isistan.flabot.edit.ucmeditor.commands.model.DeleteMapCommand;
import org.isistan.flabot.edit.ucmeditor.editparts.UCMDiagramEditPart;
import org.isistan.flabot.edit.ucmmodel.UCMDiagram;
import org.isistan.flabot.messages.Messages;

/**
 * @author $Author: franco $
 *
 */
public class DeleteUCMDiagramCommand extends CompoundCommand {
	
	private UCMDiagram diagram;
	private UCMDiagramEditPart editPart;
		
	public DeleteUCMDiagramCommand(UCMDiagramEditPart editPart) {
		this.editPart = editPart;
		this.diagram = (UCMDiagram) editPart.getModel();
		this.setLabel(Messages.getString("org.isistan.flabot.edit.ucmeditor.commands.DeleteUCMDiagramCommand.label")); //$NON-NLS-1$
	}
	
	public boolean canExecute() {
		return true;
	}
	
	/**
	 * Deletes the UCM diagram and executes a delete command for every edit part children.
	 * Except paths (including nodes, forks, joins, stubs, etc).
	 */
	public void execute() {
		List children = editPart.getChildren();
		for (Iterator iter=children.iterator(); iter.hasNext();) {
			EditPart selectionEditPart = (EditPart) iter.next();
			VisualModel visualModel = (VisualModel) selectionEditPart.getModel();
			if ( visualModel.getSemanticModel() instanceof PathNode)
				continue;
			
			GroupRequest r = new GroupRequest();
			r.setEditParts(selectionEditPart);
			r.setType(RequestConstants.REQ_DELETE);
			add(selectionEditPart.getCommand(r));
		}
	    		    	
		add(new DeleteMapCommand(diagram.getCoreModel(), diagram.getMap()));
		
		super.execute();	    	    	
	}
}