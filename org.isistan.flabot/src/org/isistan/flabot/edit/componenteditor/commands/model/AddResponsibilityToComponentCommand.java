/**
 * $Id: AddResponsibilityToComponentCommand.java,v 1.2 2006/03/20 19:54:12 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.componenteditor.commands.model;

import org.eclipse.gef.commands.Command;
import org.isistan.flabot.coremodel.ComponentModel;
import org.isistan.flabot.coremodel.Responsibility;
import org.isistan.flabot.messages.Messages;

/**
 * AddResponsibilityToComponentCommand
 * -	Adds an existing responsibility from the core model to a component. The responsibility is added to the component semantic models list of responsibilities.
 * 
 * @author $Author: franco $
 *
 */
public class AddResponsibilityToComponentCommand extends Command {
	
	private final ComponentModel componentModel;
	private final Responsibility resp;
	
	/**
	 * Instantiates a command that can add an existing responsibility from the core model to a component.
	 * @param componentModel the component where the responsibility will be added
	 * @param resp the responsibility that will be added
	 */
	public AddResponsibilityToComponentCommand(ComponentModel componentModel, Responsibility resp) {
		this.componentModel = componentModel;
		this.resp = resp;
		setLabel(Messages.getString("org.isistan.flabot.edit.componenteditor.commands.AddResponsibilityToComponentCommand.label")); //$NON-NLS-1$
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
	 * Adds the responsibility to the feature list of the component.
	 */	
	@SuppressWarnings("unchecked")
	public void redo() {
		componentModel.getFeatures().add(resp);		
	}
	
	/**
	 * Removes the responsibility from the feature list of the component.
	 */
	public void undo() {
		componentModel.getFeatures().remove(resp);
	}	
}