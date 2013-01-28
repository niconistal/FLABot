/**
 * $Id: AddStereotypeCommand.java,v 1.1 2006/03/09 21:37:21 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.componenteditor.commands.model;

import org.eclipse.gef.commands.Command;
import org.isistan.flabot.coremodel.CoreModel;
import org.isistan.flabot.coremodel.Stereotype;
import org.isistan.flabot.messages.Messages;

/**
 * AddStereotypeCommand
 * -	Adds a new stereotype to the stereotype list of the core model.
 * 
 * @author $Author: franco $
 *
 */
public class AddStereotypeCommand extends Command {

	private final CoreModel coreModel;
	private final Stereotype stereo;
	
	private boolean wasAdded;
	
	/**
	 * Instantiates a command that can add a new stereotype to the stereotype list.
	 * @param coreModel the core model where the stereotype has to be added
	 * @param stereo the new stereotype 
	 */
	public AddStereotypeCommand(CoreModel coreModel, Stereotype stereo) {
		this.coreModel = coreModel;
		this.stereo = stereo;
		setLabel(Messages.getString("org.isistan.flabot.edit.componenteditor.commands.AddStereotypeCommand.label")); //$NON-NLS-1$
	}
	
	/**
	 * The command can be undo if the stereotype was added to the core model.
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
	 * Adds the stereotype to the stereotype list.
	 */
	public void redo() {
		wasAdded = coreModel.getStereotypes().add(stereo);	
	}
	
	/**
	 * Removes the stereotype from the the stereotype list.
	 */
	public void undo() {
		coreModel.getStereotypes().remove(stereo);		
	}	
}