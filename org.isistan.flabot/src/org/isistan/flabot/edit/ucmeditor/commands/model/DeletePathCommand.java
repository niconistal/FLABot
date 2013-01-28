/**
 * $Id: DeletePathCommand.java,v 1.3 2006/03/21 01:51:57 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.ucmeditor.commands.model;

import org.eclipse.gef.commands.Command;
import org.isistan.flabot.coremodel.Path;
import org.isistan.flabot.coremodel.UseCaseMap;
import org.isistan.flabot.messages.Messages;

/**
 * @author $Author: franco $
 *
 */
public class DeletePathCommand extends Command {
	
	private UseCaseMap map;
	private Path path;
	
	public DeletePathCommand(UseCaseMap map, Path path)  {
		this.path = path;
		this.map = map;
		setLabel(Messages.getString("org.isistan.flabot.edit.ucmeditor.commands.model.DeletePathCommand.label")); //$NON-NLS-1$
	}
	
	public boolean canExecute() {
		return (map != null);
	}
	
	public void execute() {
		redo();		
	}
	
	public void redo() {
		map.getPaths().remove(path);
	}
	
	public void undo() {
		map.getPaths().add(path);
	}
}