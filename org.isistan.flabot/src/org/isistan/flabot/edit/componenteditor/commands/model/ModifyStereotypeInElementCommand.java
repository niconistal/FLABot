/**
 * $Id: ModifyStereotypeInElementCommand.java,v 1.1 2006/03/13 23:46:45 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.componenteditor.commands.model;

import org.eclipse.gef.commands.Command;
import org.isistan.flabot.coremodel.Stereotype;
import org.isistan.flabot.coremodel.StereotypedElementModel;

/**
 * @author $Author: franco $
 *
 */
public class ModifyStereotypeInElementCommand extends Command {
	
	private StereotypedElementModel stereotypedElementModel;
	private Stereotype newStereotype;
	private Stereotype oldStereotype;
	
	public ModifyStereotypeInElementCommand(StereotypedElementModel  stereotypedElementModel, Stereotype newStereotype) {
		this.stereotypedElementModel = stereotypedElementModel;
		this.newStereotype = newStereotype;
	}

	public boolean canExecute() {
		return stereotypedElementModel != null;
	}
	
	public void execute() {
		oldStereotype = stereotypedElementModel.getStereotype();
		redo();
	}
	
	public void redo() {
		stereotypedElementModel.setStereotype(newStereotype);
	}
	
	public void undo() {
		stereotypedElementModel.setStereotype(oldStereotype);
	}
}
