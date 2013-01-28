/**
 * $Id: DeleteVisualPortCommand.java,v 1.1 2006/03/09 21:37:24 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.componenteditor.commands.visual;

import java.util.List;

import org.eclipse.gef.commands.CompoundCommand;
import org.isistan.flabot.edit.editormodel.NodeVisualModel;
import org.isistan.flabot.edit.editormodel.VisualModel;
import org.isistan.flabot.messages.Messages;

/**
 * DeleteVisualPortCommand
 * -	Deletes all connections that have as target or source one of the interfaces contained by the port and the interfaces themselves, to perform this, it creates a command and adds it the compound command. The links are removed directly from semantic model, while interfaces aren’t.
 * -	Removes the visual model representing the port but not from semantic model.
 * 
 * @author $Author: franco $
 *
 */
public class DeleteVisualPortCommand  extends CompoundCommand {
	
	private VisualModel child;	
	private VisualModel parent;
	
	/**
	 * Instantiates a command that will remove a port from a component.
	 * @param parent the component containing the port
	 * @param child	the port to remove
	 */
	public DeleteVisualPortCommand(VisualModel parent, VisualModel child) {
		this.parent = parent;
		this.child = child;
		setLabel(Messages.getString("org.isistan.flabot.edit.componenteditor.commands.DeleteVisualPortCommand.label")); //$NON-NLS-1$
	}
	
	/**
	 * @return <code>true</code> if the command can be undone
	 */
	public boolean canUndo() {
		return (true);
	}

	/**
	 * Verifies that the command can be executed. And the component is containing the port.
	 * @return <code>true</code> if the command can be executed	
	 */
	public boolean canExecute() {
		return (parent != null && child != null &&  parent.getChildren().contains(child));
	}
	
	/**
	 * Executes the Command. This method should not be called if the Command is not
	 * executable.
	 * The command first executes all the DeleteVisualInterfaceCommand, according to the number of interfcaes the port has.
	 * 
	 * @see redo()
	 */
	public void execute() {
		List interfaces = child.getChildren();
		for (int i=0; i<interfaces.size(); i++)
			add(new DeleteVisualInterfaceCommand(child, (NodeVisualModel)interfaces.get(i)));
		
		super.execute();
		doDeletePort();
	}
	
	/**
	 * Removes the visual port from the visual component.
	 */
	private void doDeletePort() {
		parent.getChildren().remove(child);
	}

	/**
	 * Adds the removed visual port to the visual component.
	 */
	private void undoDeletePort() {
		parent.getChildren().add(child);			
	}
	
	@Override
	public void redo() {
		super.redo();
		doDeletePort();
	}
		
	@Override
	public void undo() {
		undoDeletePort();
		super.undo();
	}
}