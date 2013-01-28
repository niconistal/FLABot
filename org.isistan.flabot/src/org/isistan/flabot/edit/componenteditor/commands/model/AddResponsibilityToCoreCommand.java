/**
 * $Id: AddResponsibilityToCoreCommand.java,v 1.1 2006/03/09 21:37:21 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.componenteditor.commands.model;

import org.eclipse.gef.commands.Command;
import org.isistan.flabot.coremodel.CoreModel;
import org.isistan.flabot.coremodel.Responsibility;
import org.isistan.flabot.messages.Messages;

/**
 * AddResponsibilityToCoreCommand
 * -	Adds a new responsibility to the responsibility list of the core model without assigning the responsibility to any particular component.
 *  @author $Author: franco $
 *
 */
public class AddResponsibilityToCoreCommand extends Command {
	
	private final CoreModel coreModel;
	private final Responsibility resp;
	
	private boolean wasAdded;
	
	/**
	 * Instantiates a command that can add a new responsibility to the core model.
	 * @param coreModel the core model where the responsibility has to be added
	 * @param resp the new responsibility
	 */
	public AddResponsibilityToCoreCommand(CoreModel coreModel, Responsibility resp) {
		this.coreModel = coreModel;
		this.resp = resp;
		setLabel(Messages.getString("org.isistan.flabot.edit.componenteditor.commands.AddResponsibilityToCoreCommand.label")); //$NON-NLS-1$
	}

	/**
	 * The command can be undo if the responsibily was added to the core model.
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
	 * Adds the responsibility to the responsibility list.
	 */
	public void redo() {
		wasAdded = coreModel.getResponsibilities().add(resp);	
	}
	
	/**
	 * Removes the responsibility from the responsibilities list.
	 */
	public void undo() {
		coreModel.getResponsibilities().remove(resp);		
	}
}