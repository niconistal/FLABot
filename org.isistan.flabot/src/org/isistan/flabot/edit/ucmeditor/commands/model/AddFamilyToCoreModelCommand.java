/**
 * $Id: AddFamilyToCoreModelCommand.java,v 1.2 2006/03/21 01:51:57 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.ucmeditor.commands.model;

import org.eclipse.gef.commands.Command;
import org.isistan.flabot.coremodel.CoreModel;
import org.isistan.flabot.coremodel.Family;
import org.isistan.flabot.messages.Messages;

/**
 * AddFamilyToCoreModelCommand
 * -	Adds a new family to a the list of families of the core model.
 *  @author $Author: franco $
 *
 */
public class AddFamilyToCoreModelCommand extends Command {
	
	private CoreModel coreModel;
	private Family family;
	
	private boolean wasAdded;
	
	/**
	 * Instantiates a command that can add a new family to the core model.
	 * @param coreModel the core model where the family has to be added
	 * @param family the new family
	 */
	public AddFamilyToCoreModelCommand(CoreModel coreModel, Family family) {
		this.coreModel = coreModel;
		this.family = family;
		setLabel(Messages.getString("org.isistan.flabot.edit.ucmeditor.commands.model.AddFamilyToCoreModelCommand.label")); //$NON-NLS-1$
	}

	public boolean canExecute() {
		return (coreModel != null && family != null);
	}
	
	/**
	 * The command can be undo if the family was added to the core model list.
	 * @return <code>true</code> if the command can be undone
	 */
	public boolean canUndo() {
		return wasAdded;		
	}
	
	/**
	 * Executes the Command. This method should not be called if the Command is not
	 * executable.
	 * 
	 * @see redo()
	 */
	public void execute() {
		redo();		
	}
	
	/**
	 * Adds the family to the core model list.
	 */
	public void redo() {
		wasAdded = coreModel.getFamilies().add(family);
	}
	
	/**
	 * Removes the family from the core model list.
	 */
	public void undo() {
		coreModel.getFamilies().remove(family);
	}
}