/**
 * $Id: AddRelationshipConnectionCommand.java,v 1.1 2006/03/09 21:37:24 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.componenteditor.commands.visual;

import org.eclipse.gef.commands.Command;
import org.isistan.flabot.coremodel.ComponentModel;
import org.isistan.flabot.coremodel.CoreModel;
import org.isistan.flabot.coremodel.Relationship;
import org.isistan.flabot.edit.componentmodel.ComponentDiagram;
import org.isistan.flabot.edit.editormodel.ConnectionVisualModel;
import org.isistan.flabot.edit.editormodel.NodeVisualModel;
import org.isistan.flabot.messages.Messages;

/**
 * AddRelationshipConnectionCommand
 * -	Adds a connection between two components.
 * -	Adds the component relationship to the Core Model.
 * 
 * @author $Author: franco $
 *
 */
public class AddRelationshipConnectionCommand extends Command {

	protected ConnectionVisualModel connection;	
	protected ComponentDiagram diagram;		
	protected NodeVisualModel source;
	protected NodeVisualModel target;
	private CoreModel coreModel;
	
	private boolean wasAdded;
	
	/**
	 *	Instantiates a command that can create a connection between two components.
	 * @param diagram the components where the components are
	 * @param source the source component
	 * @param connection the visual model of the connection
	 */
	public AddRelationshipConnectionCommand(ComponentDiagram diagram, NodeVisualModel source, ConnectionVisualModel connection) {		
		setLabel(Messages.getString("org.isistan.flabot.edit.componenteditor.commands.AddRelationshipConnectionCommand.label")); //$NON-NLS-1$
		this.source = source;
		this.connection = connection;
		this.diagram = diagram;
	}
	
	/**
	 * The command can be undone if the relationship has been added to the core model and the diagrams of the source and target connections are correct.
	 * @return <code>true</code> if the command can be undone
	 */
	public boolean canUndo() {
		return (wasAdded && source.getDiagram() != null && target.getDiagram() != null);
	}
	
	/**
	 * Verifies whether the command can be executed or not.
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
		
		return true;
	}
	
	/**
	 * Sets the target component of the connection.
	 * @param target the target component
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
		coreModel = diagram.getCoreModel();
		// create a new connection between source and target
		connection.setSource(source);
		connection.setTarget(target);
		((Relationship)connection.getSemanticModel()).setSource((ComponentModel)source.getSemanticModel());
		((Relationship)connection.getSemanticModel()).setTarget((ComponentModel)target.getSemanticModel());
		
		redo();
	}
	
	/**
	 * Adds the semantic relationship model to the core model.
	 * Sets the source and target of the connection visual model.
	 */	
	public void redo() {
		wasAdded = coreModel.getRelationships().add(connection.getSemanticModel());
		if (wasAdded) {
			source.getSourceConnections().add(connection);
			target.getTargetConnections().add(connection);
		}
	}
	
	/**
	 * Removes the semantic relationship from the core model.
	 * Unsets the source and target of the Connection visual model.
	 */	
	public void undo() {
		if (coreModel.getRelationships().remove(connection.getSemanticModel())) {
			source.getSourceConnections().remove(connection);
			target.getTargetConnections().remove(connection);
		}
	}
}