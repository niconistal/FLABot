/**
 * $Id: DeletePathNodeCommand.java,v 1.2 2006/03/21 01:51:55 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.ucmeditor.commands.visual;

import org.eclipse.gef.commands.Command;
import org.isistan.flabot.coremodel.Path;
import org.isistan.flabot.coremodel.PathNode;
import org.isistan.flabot.edit.editormodel.ConnectionVisualModel;
import org.isistan.flabot.edit.editormodel.Diagram;
import org.isistan.flabot.edit.editormodel.NodeVisualModel;
import org.isistan.flabot.edit.editormodel.VisualModel;
import org.isistan.flabot.messages.Messages;

/**
 * Command that deletes a path node
 * @author $Author: franco $
 *
 */
public class DeletePathNodeCommand extends Command {
	
	private NodeVisualModel selectedVisual;
	private PathNode selectedSemantic;
	
	private PathNode previous;
	private PathNode next;
	private ConnectionVisualModel sourceCon;
	private ConnectionVisualModel targetCon;
	private String oldTargetConnection;
	private Path path;
	
	private VisualModel parent;
	private Diagram diagram;

	/**
	 * Create a new path node delete command
	 * @param selectedNode the node selected for deletion
	 */
	public DeletePathNodeCommand(NodeVisualModel selectedNode) {
		this.selectedVisual = selectedNode;
		this.selectedSemantic = (PathNode) selectedNode.getSemanticModel();
		setLabel(Messages.getString("org.isistan.flabot.edit.ucmeditor.commands.visual.DeletePathNodeCommand.label")); //$NON-NLS-1$
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gef.commands.Command#canExecute()
	 */
	@Override
	public boolean canExecute() {
		int nNext = selectedSemantic.uGetNext().size();
		int nPrevious = selectedSemantic.uGetPrevious().size();
		return (nNext == 1 && nPrevious == 1);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.gef.commands.Command#execute()
	 */
	@Override
	public void execute() {						
		redo();
	}	
	
	/* (non-Javadoc)
	 * @see org.eclipse.gef.commands.Command#redo()
	 */
	@Override
	public void redo() {	
		// delete semantic model
		if (selectedSemantic.uGetPrevious().size() > 0 && selectedSemantic.uGetNext().size() > 0) {
			previous = (PathNode) selectedSemantic.uGetPrevious().get(0);			
			next = (PathNode) selectedSemantic.uGetNext().get(0);
			selectedSemantic.removePrevious(previous);
			selectedSemantic.removeNext(next);
			previous.addNext(next);			
		}

		path = selectedSemantic.getPath();
		if (path != null)
			path.getNodes().remove(selectedSemantic);
		
		// delete visual model
		if (selectedVisual.getSourceConnections().size() > 0 && selectedVisual.getTargetConnections().size() > 0) {
			sourceCon = (ConnectionVisualModel)	selectedVisual.getSourceConnections().get(0);
			targetCon = (ConnectionVisualModel) selectedVisual.getTargetConnections().get(0);						
			
			oldTargetConnection = targetCon.getTargetTerminal();
			targetCon.setTargetTerminal(sourceCon.getTargetTerminal());		
			targetCon.setTarget(sourceCon.getTarget());
				
			sourceCon.setSource(null);
			sourceCon.setTarget(null);
		}
		
		parent = selectedVisual.getParent();
		diagram = selectedVisual.getDiagram();
		if (parent == null)
			selectedVisual.setParent(null);
		else	
			selectedVisual.setDiagram(null);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gef.commands.Command#undo()
	 */
	@Override
	public void undo() {
		//restore semantic model
		if (previous != null && next != null) {
			previous.removeNext(next);	
			selectedSemantic.addPrevious(previous);
			selectedSemantic.addNext(next);
		}
		
		if (path != null)
			path.getNodes().add(selectedSemantic);
	
		//restore visual model
		if (sourceCon != null && targetCon!= null) {			
			sourceCon.setTarget(targetCon.getTarget());
			sourceCon.setSource(selectedVisual);
			
			targetCon.setTargetTerminal(oldTargetConnection);
			targetCon.setTarget(selectedVisual);
		}
		
		selectedVisual.setParent(parent);
		if (parent == null)
			selectedVisual.setDiagram(diagram);
	}		
}