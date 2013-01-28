/**
 * $Id: DeletePropertyCommand.java,v 1.1 2006/03/09 21:37:21 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.componenteditor.commands.model;

import org.eclipse.gef.commands.Command;
import org.isistan.flabot.coremodel.Property;
import org.isistan.flabot.coremodel.PropertyElementModel;
import org.isistan.flabot.messages.Messages;


/**
 * - Removes a Property from a PropertyElementModel.
 *  
 * @author $Author: franco $
 *
 */
public class DeletePropertyCommand extends Command {

	private final PropertyElementModel propertyModel;
	private final Property prop;
	
	private boolean wasRemoved;
	
	/**
	 *	Instantiates a command that can add a Property to a PropertyElementModel.
	 * @param propertyModel the PropertyElementModel where the Property has to be removed
	 * @param prop a Property   
	 */
	public DeletePropertyCommand(PropertyElementModel propertyModel, Property prop) {
		this.propertyModel = propertyModel;
		this.prop = prop;
		setLabel(Messages.getString("org.isistan.flabot.edit.componenteditor.commands.DeletePropertyCommand.label")); //$NON-NLS-1$
	}
	
	/**
	 * The command can be undone if the Porperty was removed from the PropertyElementModel.
	 * @return <code>true</code> if the command can be undone
	 */
	public boolean canUndo() {
		return wasRemoved;		
	}
	
	/**
	 * Executes the Command. This method should not be called if the command is not
	 * executable.
	 * @see redo()
	 */
	public void execute() {
		redo();		
	}
	
	/**
	 * Removed the Porperty from the PropertyElementModel.
	 */
	public void redo() {
		wasRemoved = propertyModel.getProperties().remove(prop);	
	}
	
	/**
	 * Adds the Porperty to the PropertyElementModel.
	 */	
	public void undo() {
		propertyModel.getProperties().add(prop);		
	}	
}