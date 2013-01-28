/**
 * $Id: ModifyStereotypeCommand.java,v 1.1 2006/03/09 21:37:21 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.componenteditor.commands.model;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gef.commands.Command;
import org.isistan.flabot.coremodel.Stereotype;
import org.isistan.flabot.messages.Messages;

/**
 * UpdateStereotypeCommand
 * -	Updates a stereotype
 * 
 * @author $Author: franco $
 *
 */
public class ModifyStereotypeCommand extends Command {

	private Stereotype stereotype;
	private Stereotype newStereotype;
	private Stereotype oldStereotype;

	/**
	 * Instantiates a command that can update a stereotype
	 * @param stereotype the Stereotype to update
	 * @param newStereotype the Stereotype from where the new properties are taken
	 */
	public ModifyStereotypeCommand(Stereotype stereotype, Stereotype newStereotype) {
		this.stereotype = stereotype;
		this.newStereotype = newStereotype;
		setLabel(Messages.getString("org.isistan.flabot.edit.componenteditor.commands.UpdateStereotypeCommand.label")); //$NON-NLS-1$
	}
	
	/**
	 * Executes the Command. This method should not be called if the Command is not
	 * executable.
	 * 
	 * @see redo()
	 */
	public void execute() {
		this.oldStereotype = (Stereotype) EcoreUtil.copy(stereotype);
		redo();
	}
	
	/**
	 * Sets the new name in the Stereotype
	 */
	public void redo() {
		stereotype.setName(newStereotype.getName());
	}
	
	/**
	 * Restores the oldw name in the Stereotype
	 */
	public void undo() {
		stereotype.setName(oldStereotype.getName());
	}
}