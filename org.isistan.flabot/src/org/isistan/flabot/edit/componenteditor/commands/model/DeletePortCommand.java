/**
 * $Id: DeletePortCommand.java,v 1.2 2006/03/21 01:51:58 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.componenteditor.commands.model;

import java.util.Iterator;
import java.util.List;

import org.eclipse.gef.commands.CompoundCommand;
import org.isistan.flabot.coremodel.ComponentModel;
import org.isistan.flabot.coremodel.InterfaceModel;
import org.isistan.flabot.coremodel.PortModel;
import org.isistan.flabot.messages.Messages;

/**
 * @author $Author: franco $
 *
 */
public class DeletePortCommand extends CompoundCommand {
	
	private ComponentModel component;
	private PortModel port;
	
	public DeletePortCommand(ComponentModel component, PortModel port)  {
		this.component = component;
		this.port = port;
		setLabel(Messages.getString("org.isistan.flabot.edit.componenteditor.commands.model.DeletePortCommand.label")); //$NON-NLS-1$
	}
	
	public boolean canExecute() {
		return (component != null);
	}
	
	public boolean canUndo() {
		return true;
	}
	
	private void addDeleteCommands(List interfaces) {
		for (Iterator iterInter =interfaces.iterator(); iterInter.hasNext(); ) {
			InterfaceModel inter = (InterfaceModel) iterInter.next();
			add(new DeleteInterfaceCommand(port, inter));
		}		
	}
	
	public void execute() {
		addDeleteCommands(port.getProvideds());
		addDeleteCommands(port.getRequireds());
		
		super.execute();
		
		doDeletePort();		
	}
	
	public void doDeletePort() {
		component.getOwnedPorts().remove(port);
	}
	
	public void undDeletePort() {
		component.getOwnedPorts().add(port);
	}
	
	public void redo() {
		super.redo();	
		doDeletePort();			
	}
	
	public void undo() {		
		undDeletePort();
		super.undo();
	}
}