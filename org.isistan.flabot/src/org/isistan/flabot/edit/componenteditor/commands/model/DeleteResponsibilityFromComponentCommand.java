/**
 * $Id: DeleteResponsibilityFromComponentCommand.java,v 1.3 2006/03/21 01:51:58 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.componenteditor.commands.model;

import org.eclipse.gef.commands.Command;
import org.isistan.flabot.coremodel.ComponentModel;
import org.isistan.flabot.coremodel.Responsibility;
import org.isistan.flabot.messages.Messages;

/**
 * Command that removes a responsibility from the responsibility list of a component
 * 
 * DeleteResponsibilityFromComponentCommand
 * -	Removes a responsibility from a component's responsibilities list.
 * -	This may cause a responsibility node to be moved out from inside a component.
 * 
 * @author $Author: franco $
 *
 */
public class DeleteResponsibilityFromComponentCommand extends Command {

	private ComponentModel componentModel;
	private Responsibility responsibility;
	private boolean wasRemoved;

	/**
	 * Instantiates a command that can remove a responsibility from the component's responsibilities list.
	 * @param componentModel the component
	 * @param responsibility the responsibility that will be removed
	 */
	public DeleteResponsibilityFromComponentCommand(ComponentModel componentModel, Responsibility responsibility) {
		this.componentModel = componentModel;
		this.responsibility = responsibility;
		this.wasRemoved = false;
		setLabel(Messages.getString("org.isistan.flabot.edit.componenteditor.commands.model.DeleteResponsibilityFromComponentCommand.label")); //$NON-NLS-1$
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
	 * Removes the responsibility from the list of features of the component.
	 */
	public void redo() {
		wasRemoved = componentModel.getFeatures().contains(responsibility); 
		componentModel.getFeatures().remove(responsibility);
	}
	
	/**
	 * Adds the responsibility to the list of features of the component.
	 */	
	public void undo() {
		if (wasRemoved)
			componentModel.getFeatures().add(responsibility);
	}	
}