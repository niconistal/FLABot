/**
 * $Id: DeleteAssociatedNodeFromFamilyCommand.java,v 1.3 2006/03/21 01:51:57 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.ucmeditor.commands.model;

import org.eclipse.gef.commands.Command;
import org.isistan.flabot.coremodel.Family;
import org.isistan.flabot.coremodel.SimplePathNode;
import org.isistan.flabot.messages.Messages;

/**
 * @author $Author: franco $
 *
 */
public class DeleteAssociatedNodeFromFamilyCommand extends Command {
	
	private Family family;
	private SimplePathNode spn;
	
	public DeleteAssociatedNodeFromFamilyCommand(Family family, SimplePathNode spn)  {
		this.family = family;
		this.spn = spn;
		setLabel(Messages.getString("org.isistan.flabot.edit.ucmeditor.commands.model.DeleteAssociatedNodeFromFamilyCommand.label")); //$NON-NLS-1$
	}
	
	public boolean canExecute() {
		return (family != null);
	}
	
	public void execute() {
		redo();		
	}
	
	public void redo() {
		family.getAssociatedResponsibilities().remove(spn);
	}
	
	public void undo() {
		family.getAssociatedResponsibilities().add(spn);
	}
}
