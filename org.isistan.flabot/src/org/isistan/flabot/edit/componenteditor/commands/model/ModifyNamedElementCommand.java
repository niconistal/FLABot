/**
 * $Id: ModifyNamedElementCommand.java,v 1.2 2006/03/20 19:54:12 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.componenteditor.commands.model;

import org.eclipse.gef.commands.Command;
import org.isistan.flabot.coremodel.NamedElementModel;
import org.isistan.flabot.messages.Messages;

/**
 * RenameNamedElementModelCommand 
 * -	Renames a NamedElementModel.
 * 
 * @author $Author: franco $
 *
 */
public class ModifyNamedElementCommand extends Command {

	private String newName, oldName;
	private NamedElementModel element;

	/**
	 * Instantiates a command that can renames a NamedElementModel. 
	 * @param element the NamedElementModel to rename
	 * @param s the new name
	 */
	public ModifyNamedElementCommand(NamedElementModel element, String s) {
		this.element = element;
		newName = "";  //$NON-NLS-1$
		if (s != null)
			newName = s;
		setLabel(Messages.getString("org.isistan.flabot.edit.componenteditor.commands.RenameNamedElementModelCommand.label")); //$NON-NLS-1$
	}
	
	/**
	 * Verifies that the command can be executed.
	 * @return <code>true</code> if the command can be executed	
	 */
	public boolean canExecute() {	
		return (element != null);
	}

	/**
	 * Executes the Command. This method should not be called if the Command is not
	 * executable.
	 * 
	 * @see redo()
	 */
	public void execute() {
		oldName = new String(element.getName());
		redo();
	}

	/**
	 * Sets the new name in the NamedElementModel
	 */
	public void redo() {
		element.setName(newName);
	}
	
	/**
	 * Restored the olds name in the NamedElementModel
	 */
	public void undo() {
		element.setName(oldName);
	}
}