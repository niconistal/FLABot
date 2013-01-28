/**
 * $Id: AddInterfaceConnectionCommand.java,v 1.1 2006/03/09 21:37:24 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.componenteditor.commands.visual;

import java.util.Iterator;

import org.eclipse.gef.commands.Command;
import org.isistan.flabot.coremodel.CoreModel;
import org.isistan.flabot.coremodel.InterfaceLink;
import org.isistan.flabot.coremodel.InterfaceModel;
import org.isistan.flabot.edit.componentmodel.ComponentDiagram;
import org.isistan.flabot.edit.editormodel.ConnectionVisualModel;
import org.isistan.flabot.edit.editormodel.NodeVisualModel;
import org.isistan.flabot.messages.Messages;

/**
 * AddInterfaceConnectionCommand
 * -	Adds a connection from a provided interface to a required interface.
 * -	Adds the interface link to the Core Model.
 * 
 * @author $Author: franco $
 *
 */
public class AddInterfaceConnectionCommand extends Command {
	
	protected ConnectionVisualModel connection;
	protected NodeVisualModel source;
	protected NodeVisualModel target;
	protected ComponentDiagram diagram;
	
	private CoreModel coreModel;
	private boolean wasAdded;
		
	/**
	 * Instantiates a command that can create a connection between two interfaces.
	 * @param diagram the diagram where the interface are
	 * @param source the source interface (provided)
	 * @param connection the visual model of the connection
	 */
	public AddInterfaceConnectionCommand(ComponentDiagram diagram, NodeVisualModel source, ConnectionVisualModel connection) {				
		this.diagram = diagram;
		this.source = source;
		this.connection = connection;
		setLabel(Messages.getString("org.isistan.flabot.edit.componenteditor.commands.AddInterfaceConnectionCommand.label")); //$NON-NLS-1$
	}
	
	/**
	 * The command can be undone if the interface link was added to the core model and the diagrams of the source and target connections are correct.
	 * @return <code>true</code> if the command can be undone
	 */
	public boolean canUndo() {
		return (wasAdded && source.getDiagram() != null && target.getDiagram() != null);
	}
	
	/**
	 * Verifies that the command can be executed.
	 * The connection must not be duplicated (source -> target connection exists already) 
	 * @return <code>true</code> if the command can be executed	
	 */
	public boolean canExecute() {
		if (source == null || connection == null || diagram == null)
			return false;
		
		// disallow source -> source connections
		if (source == null || target == null || 
				connection == null || source.equals(target)) {
			return false;
		}
		// return false, if the source -> target connection exists already
		for (Iterator iter = source.getSourceConnections().iterator(); iter.hasNext();) {
			ConnectionVisualModel conn = (ConnectionVisualModel) iter.next();
			if (conn.getTarget().equals(target)) {
				return false;
			}
		}
		
		return true;
	}
	
	/**
	 * Sets the target interface for the connection.
	 * @param target the target interface
	 * @throws IllegalArgumentException if target is null
	 */
	public void setTarget(NodeVisualModel target) {
		if (target == null) {
			throw new IllegalArgumentException();
		}
		this.target = target;
	}
		
	/**
	 * Executes the Command. This method should not be called if the Command is not
	 * executable.
	 * 
	 * @see redo()
	 */
	public void execute() {
		this.coreModel = diagram.getCoreModel();
		
		// create a new connection between source and target
		connection.setSource(source);
		connection.setTarget(target);
		((InterfaceLink)connection.getSemanticModel()).setSource((InterfaceModel)source.getSemanticModel());
		((InterfaceLink)connection.getSemanticModel()).setTarget((InterfaceModel)target.getSemanticModel());
		redo();
	}
	
	/**
	 * Adds the semantic interface link to the core model.
	 * Sets the source and target of the connection visual model.
	 */	
	public void redo() {			
		wasAdded = coreModel.getInterfaceLinks().add(connection.getSemanticModel());
		if (wasAdded) {
			source.getSourceConnections().add(connection);
			target.getTargetConnections().add(connection);
		}
	}

	/**
	 * Removes the semantic interface link from the core model.
	 * Unsets the source and target of the Connection visual model.
	 */	
	public void undo() {
		if (coreModel.getInterfaceLinks().remove(connection.getSemanticModel())) {
			source.getSourceConnections().remove(connection);
			target.getTargetConnections().remove(connection);
		}
	}
}