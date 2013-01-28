/**
 * $Id: DeleteFamilyElementCommand.java,v 1.3 2006/03/21 01:51:57 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.ucmeditor.commands.model;

import org.eclipse.gef.commands.Command;
import org.isistan.flabot.coremodel.Family;
import org.isistan.flabot.coremodel.FamilyElement;
import org.isistan.flabot.messages.Messages;

/**
 * @author $Author: franco $
 *
 */
public class DeleteFamilyElementCommand extends Command {
	
	private Family family;
	private FamilyElement fe;		
	
	public DeleteFamilyElementCommand(Family family, FamilyElement fe)  {
		this.family = family;
		this.fe = fe;
		setLabel(Messages.getString("org.isistan.flabot.edit.ucmeditor.commands.model.DeleteFamilyElementCommand.label")); //$NON-NLS-1$
	}
	
	public boolean canExecute() {
		return (family != null);
	}
	
	public void execute() {
		redo();		
	}
	
	public void redo() {
		family.getFamilyElement().remove(fe);
	}
	
	public void undo() {
		family.getFamilyElement().add(fe);;
	}
}