/**
 * $Id: DeleteVisualInterfaceCommand.java,v 1.1 2006/03/09 21:37:24 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.componenteditor.commands.visual;

import java.util.Iterator;
import java.util.List;

import org.eclipse.gef.commands.CompoundCommand;
import org.isistan.flabot.edit.componentmodel.ComponentDiagram;
import org.isistan.flabot.edit.editormodel.ConnectionVisualModel;
import org.isistan.flabot.edit.editormodel.NodeVisualModel;
import org.isistan.flabot.edit.editormodel.VisualModel;
import org.isistan.flabot.messages.Messages;

/**
 * DeleteVisualInterfaceCommand
 * -	Deletes all connections that have as target or source this interface, to perform this, it creates a command and adds it the compound command. The links are removed directly from semantic model.
 * -	Removes the visual model representing the interface but not from core model.
 * 
 * @author $Author: franco $
 *
 */
public class DeleteVisualInterfaceCommand extends CompoundCommand {
	
	private VisualModel parent;
	private NodeVisualModel child;
	
	/**
	 * Instantiates a command that will remove an interface from a port.
	 * @param parent the visual porto containing the interface
	 * @param child the interface to remove
	 */
	public DeleteVisualInterfaceCommand(VisualModel parent, NodeVisualModel child) {		
		this.parent = parent;
		this.child = child;
		setLabel(Messages.getString("org.isistan.flabot.edit.componenteditor.commands.DeleteVisualInterfaceCommand.label")); //$NON-NLS-1$
	}
	
	/**
	 * @return <code>true</code> if the command can be undone
	 */
	public boolean canUndo() {
		return (true);
	}

	/**
	 * Verifies that the command can be executed. And the port is containing the interface.
	 * @return <code>true</code> if the command can be executed	
	 */
	public boolean canExecute() {
		return (parent != null && child != null && parent.getChildren().contains(child));
	}
		
	/**
	 * Adds the DeleteInterfaceConnectionCommand commands according to the list of connections.
	 * @param connections the list of interface connections
	 */
	private void addDeleteConnections(List connections) {
		for (Iterator iter=connections.iterator(); iter.hasNext();) {
			ConnectionVisualModel c = (ConnectionVisualModel) iter.next();
			add(new DeleteInterfaceConnectionCommand((ComponentDiagram)parent.getParent().getDiagram(), c));
		}			
	}
	
	/**
	 * Executes the Command. This method should not be called if the Command is not
	 * executable.
	 * The command first executes DeleteInterfaceConnectionCommand, according to the source and target connection that the interface has.
	 * 
	 * @see redo()
	 */
	public void execute() {
		addDeleteConnections(child.getSourceConnections());
		addDeleteConnections(child.getTargetConnections());
		
		super.execute();
		redo();
	}
	
	/**
	 * Removes the visual Interface from the visual port.
	 */	
	private void doDeleteInterface() {
		parent.getChildren().remove(child);
	}
	
	/**
	 * Adds the removed visual Interface to the visual port.
	 */	
	private void undoDeleteInterface() {
		parent.getChildren().add(child);
	}
		
	@Override
	public void redo() {			
		super.redo();		
		doDeleteInterface();
	}
		
	@Override
	public void undo() {		 
		undoDeleteInterface();
		super.undo();
	}
}