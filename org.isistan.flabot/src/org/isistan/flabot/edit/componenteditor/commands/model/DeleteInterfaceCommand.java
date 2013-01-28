/**
 * $Id: DeleteInterfaceCommand.java,v 1.3 2006/03/21 01:51:58 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.componenteditor.commands.model;

import java.util.List;

import org.eclipse.gef.commands.Command;
import org.isistan.flabot.coremodel.InterfaceModel;
import org.isistan.flabot.coremodel.PortModel;
import org.isistan.flabot.messages.Messages;

/**
 * @author $Author: franco $
 *
 */
public class DeleteInterfaceCommand extends Command {
	
	private PortModel port;
	private InterfaceModel inter;
	private List interfaceList;
	
	public DeleteInterfaceCommand(PortModel port, InterfaceModel inter)  {
		this.port = port;
		this.inter = inter;
		setLabel(Messages.getString("org.isistan.flabot.edit.componenteditor.commands.model.DeleteInterfaceCommand.label")); //$NON-NLS-1$
	}
	
	public boolean canExecute() {
		return (port != null);
	}
	
	public void execute() {
		if (port.getProvideds().contains(inter))
			interfaceList = port.getProvideds();
		else 
			interfaceList = port.getRequireds();
		
		redo();		
	}
	
	public void redo() {
		interfaceList.remove(inter);
	}
	
	public void undo() {
		interfaceList.add(inter);
	}
}