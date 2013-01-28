/**
 * $Id: AddPropertyCommand.java,v 1.1 2006/03/09 21:37:21 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.componenteditor.commands.model;

import org.eclipse.gef.commands.Command;
import org.isistan.flabot.coremodel.Property;
import org.isistan.flabot.coremodel.PropertyElementModel;
import org.isistan.flabot.messages.Messages;

/**
 * AddPropertyCommand
 * -	Adds a Property to a PropertyElementModel.
 * 
 * @author $Author: franco $
 *
 */
public class AddPropertyCommand extends Command {

	private final PropertyElementModel propertyModel;
	private final Property prop;
	
	private boolean wasAdded;
	
	/**
	 *	Instantiates a command that can add a Property to a PropertyElementModel.
	 * @param propertyModel the PropertyElementModel where the Property will be added
	 * @param prop the Property that will be added  
	 */
	public AddPropertyCommand(PropertyElementModel propertyModel, Property prop) {
		this.propertyModel = propertyModel;
		this.prop = prop;
		setLabel(Messages.getString("org.isistan.flabot.edit.componenteditor.commands.AddPropertyCommand.label")); //$NON-NLS-1$
	}
	
	/**
	 * The command can be undone if the Porperty was added to the PropertyElementModel.
	 * @return <code>true</code> if the command can be undone
	 */
	public boolean canUndo() {
		return wasAdded;		
	}
	
	/**
	 * Executes the Command. This method should not be called if the command is not
	 * executable.
	 * 
	 * @see redo()
	 */
	public void execute() {
		redo();		
	}
	
	/**
	 * Adds the Porperty to the PropertyElementModel.
	 */	
	public void redo() {
		wasAdded = propertyModel.getProperties().add(prop);	
	}
	
	/**
	 * Removed the Porperty from the PropertyElementModel.
	 */
	public void undo() {
		propertyModel.getProperties().remove(prop);		
	}	
}