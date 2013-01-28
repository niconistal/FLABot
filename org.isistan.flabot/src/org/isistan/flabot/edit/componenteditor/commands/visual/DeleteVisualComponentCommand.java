/**
 * $Id: DeleteVisualComponentCommand.java,v 1.2 2006/03/21 01:51:58 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.componenteditor.commands.visual;

import java.util.List;

import org.eclipse.gef.commands.CompoundCommand;
import org.isistan.flabot.edit.componentmodel.ComponentDiagram;
import org.isistan.flabot.edit.editormodel.NodeVisualModel;
import org.isistan.flabot.edit.editormodel.VisualModel;
import org.isistan.flabot.messages.Messages;

/**
 * DeleteVisualComponentCommand
 * -	Removes a component from the diagram.
 * -	Removes all ports and interfaces from diagram.
 * -	Everything is removed from diagram (visual model) but not from the semantic model (because it can be present in other diagrams or may be reused later).
 * 
 * @author $Author: franco $
 *
 */
public class DeleteVisualComponentCommand extends CompoundCommand {
	
	private final NodeVisualModel child;	
	private final ComponentDiagram parent;	
	private boolean wasRemoved = false;
	
	/**
	 * Instantiates a command that will remove the component from a component diagram.
	 * @param parent the component diagram containing the component
	 * @param child the component to remove
	 */
	public DeleteVisualComponentCommand(ComponentDiagram parent, NodeVisualModel child) {
		this.parent = parent;
		this.child = child;
		setLabel(Messages.getString("org.isistan.flabot.edit.componenteditor.commands.visual.DeleteVisualComponentCommand.label")); //$NON-NLS-1$
	}
	
	/**
	 * The command can be undo if the component was removed.
	 * @return <code>true</code> if the command can be undone
	 */
	public boolean canUndo() {
		return (wasRemoved);
	}
	
	/**
	 * Verifies that the command can be executed. And the component diagram is containing the component.
	 * @return <code>true</code> if the command can be executed	
	 */
	public boolean canExecute() {
		return (parent != null && child != null && parent.getChildren().contains(child));
	}
	
	/**
	 * Executes the Command. This method should not be called if the Command is not
	 * executable.
	 * The command first executes all the DeleteVisualPortCommand, according to the number of port the component has.
	 * 
	 * @see redo()
	 */
	public void execute() {
		List ports = child.getChildren();
		for (int i=0; i<ports.size(); i++)
			add(new DeleteVisualPortCommand((VisualModel)child, (VisualModel)ports.get(i)));

		super.execute();
		
		doDeleteComponent();
	}
	
	/**
	 * Removes the visual component from the component diagram.
	 */	
	private void doDeleteComponent() {
		wasRemoved = parent.getChildren().remove(child);
	}
	
	/**
	 * Adds the removed visual component to the component diagram.
	 */	
	private void undoDeleteComponent() {
		parent.getChildren().add(child);		
	}
	
	@Override
	public void redo() {
		super.redo();
		doDeleteComponent();
	}
		
	@Override
	public void undo() {
		undoDeleteComponent();
		super.undo();
	}
}