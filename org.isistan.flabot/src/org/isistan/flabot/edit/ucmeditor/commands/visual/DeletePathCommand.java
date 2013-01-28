/** * $Id: DeletePathCommand.java,v 1.5 2006/04/11 03:32:24 franco Exp $ * $Author: franco $ */package org.isistan.flabot.edit.ucmeditor.commands.visual;

import java.util.Iterator;import org.eclipse.gef.commands.Command;import org.eclipse.gef.commands.CompoundCommand;import org.isistan.flabot.coremodel.Condition;import org.isistan.flabot.coremodel.Note;import org.isistan.flabot.coremodel.Path;import org.isistan.flabot.coremodel.PathNode;import org.isistan.flabot.coremodel.ResponsibilityNode;import org.isistan.flabot.coremodel.StubNode;import org.isistan.flabot.edit.editor.commands.DeleteNoteConnectionCommand;import org.isistan.flabot.edit.editor.commands.SetDetailLevelCommand;import org.isistan.flabot.edit.editormodel.ConnectionVisualModel;import org.isistan.flabot.edit.editormodel.NodeVisualModel;import org.isistan.flabot.edit.editormodel.VisualModel;import org.isistan.flabot.edit.ucmeditor.commands.model.DeleteResponsibilityNodeAssociationsCommand;import org.isistan.flabot.edit.ucmmodel.UCMDiagram;import org.isistan.flabot.messages.Messages;public class DeletePathCommand extends Command {
			private CompoundCommand deleteNoteConnections = new CompoundCommand();		private CompoundCommand deletePathConnections = new CompoundCommand();		private NodeVisualModel selectedVisual;
	private UCMDiagram diagram;
	private PathNode selectedSemantic;
	private Path path;
	
	private VisualModel parentEndVisual;
	private VisualModel parentSelectedVisual;	
	private NodeVisualModel endVisual;	
	private ConnectionVisualModel connection;
	
	/**
	 * Create a new path node delete command
	 * @param selectedNode the node selected for deletion
	 */
	public DeletePathCommand(NodeVisualModel selectedNode) {
		this.selectedVisual = selectedNode;
		this.selectedSemantic = (PathNode) selectedNode.getSemanticModel();
		this.diagram = (UCMDiagram) selectedNode.getDiagram();
		setLabel(Messages.getString("org.isistan.flabot.edit.ucmeditor.commands.visual.DeletePathCommand.label")); //$NON-NLS-1$
	}
		
	private boolean isForkNode(NodeVisualModel visual) {
		PathNode p = (PathNode) visual.getSemanticModel();
		if (p != null)
			return (p.uGetNext().size() == 2);
		return false;
	}
	
	private boolean isJoinNode(NodeVisualModel visual) {
		PathNode p = (PathNode) visual.getSemanticModel();
		if (p != null)
			return (p.uGetPrevious().size() == 2);
		return false;		
	}		private boolean isResponsibilityNode(NodeVisualModel visual) {		return visual.getSemanticModel() instanceof ResponsibilityNode;		}		private boolean isStubNode(NodeVisualModel visual) {		return visual.getSemanticModel() instanceof StubNode;		}
			private void deleteNoteConnections(NodeVisualModel source) {		for(Iterator iter=source.getTargetConnections().iterator(); iter.hasNext();) {			ConnectionVisualModel connection = (ConnectionVisualModel) iter.next();			if (connection.getSemanticModel() instanceof Note)				deleteNoteConnections.add(new DeleteNoteConnectionCommand(connection));		}	}		public void processPathDeleteCommand(NodeVisualModel source)  {					deleteNoteConnections(source);				for(Iterator iter= source.getSourceConnections().iterator(); iter.hasNext();) {			ConnectionVisualModel connection = (ConnectionVisualModel) iter.next();						//Ignore Condition connections (that for ResponsibilityNodes showing its dependencies)			if (connection.getSemanticModel() instanceof Condition)				continue;						NodeVisualModel target = connection.getTarget();			PathNode semanticModel = (PathNode)target.getSemanticModel();									if (semanticModel.isEnd()) {								deleteNoteConnections(target);				break;			}									if (isForkNode(target)) {				deletePathConnections.add(new SetDetailLevelCommand(target, VisualModel.LOW_DETAIL));				deleteNoteConnections(target);				deletePathConnections.add(new DeleteResponsibilityNodeAssociationsCommand(diagram.getCoreModel(), (ResponsibilityNode) target.getSemanticModel()));				deletePathConnections.add(new DeleteForkCommand(target));				break;			}						if (isJoinNode(target)) {				deletePathConnections.add(new SetDetailLevelCommand(target, VisualModel.LOW_DETAIL));				deleteNoteConnections(target);				deletePathConnections.add(new DeleteResponsibilityNodeAssociationsCommand(diagram.getCoreModel(), (ResponsibilityNode) target.getSemanticModel()));				deletePathConnections.add(new DeleteJoinCommand(target));				break;			}						if (isResponsibilityNode(target)) {				deletePathConnections.add(new SetDetailLevelCommand(target, VisualModel.LOW_DETAIL));				deletePathConnections.add(new DeleteResponsibilityNodeAssociationsCommand(diagram.getCoreModel(), (ResponsibilityNode) target.getSemanticModel()));				deletePathConnections.add(new DeletePathNodeCommand(target));			} else {					if (isStubNode(target)) 					deletePathConnections.add(new DeleteStubCommand(target));											else					deletePathConnections.add(new DeletePathNodeCommand(target));			}						processPathDeleteCommand(target);					}			}	
	public void execute() {			
		processPathDeleteCommand(selectedVisual);
				deleteNoteConnections.execute();				deletePathConnections.execute();
		
		path = selectedSemantic.getPath();
		if (selectedSemantic.uGetNext().size() > 0) {
			connection = (ConnectionVisualModel)selectedVisual.getSourceConnections().get(0);
			if (path.getEndNodes().contains(connection.getTarget().getSemanticModel()))
				endVisual = connection.getTarget();
		}
						
		if (endVisual != null)
			doDeleteEndNode();
		
		if (endVisual != null || selectedSemantic.uGetNext().size() == 0)
			doDeleteStartNode();		
	}
	
	private void doDeleteEndNode() {
		path.getEndNodes().remove(endVisual.getSemanticModel());
		path.getNodes().remove(endVisual.getSemanticModel());		
	
		connection.setSemanticModel(null);
		connection.setSource(null);
		connection.setTarget(null);		
		
		parentEndVisual = endVisual.getParent();
		endVisual.setParent(null);
		endVisual.setDiagram(null);
	}
	
	private void undoDeleteEndNode() {
		path.getEndNodes().add(endVisual.getSemanticModel());
		path.getNodes().add(endVisual.getSemanticModel());
		
		endVisual.setParent(parentEndVisual);
		if (parentEndVisual == null)
			endVisual.setDiagram(diagram);
					
		connection.setSemanticModel(path);
		connection.setSource(selectedVisual);
		connection.setTarget(endVisual);		
	}
	
	private void doDeleteStartNode() {				
		path.getStartNodes().remove(selectedSemantic);
		path.getNodes().remove(selectedSemantic);
	
		parentSelectedVisual = selectedVisual.getParent();
		
		//If is the only start point of this path
		if (path.getStartNodes().size() <= 0)
			diagram.getMap().getPaths().remove(path);
		
		selectedVisual.setParent(null);
		selectedVisual.setDiagram(null);
	}
	
	private void undoDeleteStartNode() {
		diagram.getMap().getPaths().add(path);
		path.getStartNodes().add(selectedSemantic);
		path.getNodes().add(selectedSemantic);
		
		selectedVisual.setParent(parentSelectedVisual);
		if (parentSelectedVisual == null)
			selectedVisual.setDiagram(diagram);	

	}
	
	public void redo() {
		deleteNoteConnections.redo();		deletePathConnections.redo();				if (endVisual != null)
			doDeleteEndNode();
		if (endVisual != null || selectedSemantic.uGetNext().size() == 0)
			doDeleteStartNode();
	}
	
	public void undo() {				if (endVisual != null || selectedSemantic.uGetNext().size() == 0)
			undoDeleteStartNode();
		if (endVisual != null)
			undoDeleteEndNode();
				deletePathConnections.undo();		deleteNoteConnections.undo();		
	}
}