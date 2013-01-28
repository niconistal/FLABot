/**
 * $Id: CommandExecutor.java,v 1.2 2005/12/16 01:15:57 mblech Exp $
 * $Author: mblech $
 */
package org.isistan.flabot.edit.editor;

import org.eclipse.gef.commands.Command;

/**
 * Interface that provides command execution with or without using the
 * command stack, but always sets the dirty state.
 * @author $Author: mblech $
 *
 */
public interface CommandExecutor {
	
	/**	
	 * Execute the given command
	 * @param command the command that must be executed
	 * @param askUser whether the user should confirm command execution or not
	 */
	void executeCommand(Command command, boolean askUser);

}
