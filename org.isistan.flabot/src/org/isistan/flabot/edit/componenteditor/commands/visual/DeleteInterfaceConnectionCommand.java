/**
 * $Id: DeleteInterfaceConnectionCommand.java,v 1.1 2006/03/09 21:37:24 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.componenteditor.commands.visual;

import org.eclipse.gef.commands.Command;
import org.isistan.flabot.coremodel.CoreModel;
import org.isistan.flabot.edit.componentmodel.ComponentDiagram;
import org.isistan.flabot.edit.editormodel.ConnectionVisualModel;
import org.isistan.flabot.edit.editormodel.NodeVisualModel;
import org.isistan.flabot.messages.Messages;

/**
 * DeleteInterfaceConnectionCommand
 * -	Deletes a connection from a provided interface to a required interface.
 * -	Deletes the interface link from the Core Model.
 * 
 * @author $Author: franco $
 *
 */
public class DeleteInterfaceConnectionCommand extends Command {
	
	private final ConnectionVisualModel connection;
	private ComponentDiagram diagram;
	private NodeVisualModel source;
	private NodeVisualModel target;	
	private CoreModel coreModel;
	
	private boolean  wasRemoved = true;
	
	/**
	 * Instantiates a command that can delete a connection between two interfaces.
	 * @param diagram the diagram where the interface are
	 * @param connection the visual model of the connection tha will be deleted
	 */
	public DeleteInterfaceConnectionCommand(ComponentDiagram diagram, ConnectionVisualModel connection) {	
		this.connection = connection;
		this.diagram = diagram;
		setLabel(Messages.getString("org.isistan.flabot.edit.componenteditor.commands.DeleteInterfaceConnectionCommand.label")); //$NON-NLS-1$
	}
	
	/**
	 * The command can be undone if the interface link was removed from the core model.
	 * @return <code>true</code> if the command can be undone
	 */
	public boolean canUndo() {
		return (wasRemoved);
	}
	
	/**
	 * @return <code>true</code> if the connection and  the diagram variables are not null. 	
	 */
	public boolean canExecute() {
		return (connection != null && diagram != null);
	}
		
	/**
	 * Sets up the required variables and calls the redo method
	 * 
	 * @see redo()
	 */
	public void execute() {
		source = connection.getSource();
		target = connection.getTarget();
		
		coreModel = diagram.getCoreModel();
		redo();
	}
	
	/**
	 * Removes the semantic interface link from the core model.
	 * Unsets the source and target of the connection visual model.
	 */	
	public void redo() {
		wasRemoved = coreModel.getInterfaceLinks().remove(connection.getSemanticModel());
		if (wasRemoved) {
			connection.setSource(null);
			connection.setTarget(null);
		}
	}
	
	/**
	 * Adds the semantic interface link to the core model.
	 * Sets the source and target of the connection visual model.
	 */	
	public void undo() {
		if (coreModel.getInterfaceLinks().add(connection.getSemanticModel())) {
			connection.setSource(source);
			connection.setTarget(target);
		}
	}
}