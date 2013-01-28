/**
 * $Id: ModifyPropertyCommand.java,v 1.1 2006/03/09 21:37:21 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.componenteditor.commands.model;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gef.commands.Command;
import org.isistan.flabot.coremodel.Property;
import org.isistan.flabot.messages.Messages;

/**
 * UpdatePropertyCommand
 * -	Updates a property
 * 
 * @author $Author: franco $
 *
 */
public class ModifyPropertyCommand extends Command {

	private Property property;
	private Property updatedProperty;
	private Property oldProperty;

	/**
	 * Instantiates a command that can update a property
	 * @param property the Property to update
	 * @param updatedProperty the Property from where the new properties are taken
	 */
	public ModifyPropertyCommand(Property property, Property updatedProperty) {
		this.property = property;
		this.updatedProperty = updatedProperty;
		setLabel(Messages.getString("org.isistan.flabot.edit.componenteditor.commands.UpdatePropertyCommand.label")); //$NON-NLS-1$
	}
	
	/**
	 * Executes the Command. This method should not be called if the Command is not
	 * executable.
	 * 
	 * @see redo()
	 */
	public void execute() {
		this.oldProperty = (Property)EcoreUtil.copy(property);
		redo();
	}
	
	/**
	 * Sets the new name and value in the Property
	 */
	public void redo() {
		property.setName(updatedProperty.getName());
		property.setValue(updatedProperty.getValue());
	}
	
	/**
	 * Restores the olds name and value in the Property
	 */
	public void undo() {
		property.setName(oldProperty.getName());
		property.setValue(oldProperty.getValue());
	}
}