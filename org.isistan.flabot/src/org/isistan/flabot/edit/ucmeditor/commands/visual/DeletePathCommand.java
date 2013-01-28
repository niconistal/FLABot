/**

import java.util.Iterator;
	
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
	}
		
	public void execute() {			
		processPathDeleteCommand(selectedVisual);
		
		
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
		deleteNoteConnections.redo();
			doDeleteEndNode();
		if (endVisual != null || selectedSemantic.uGetNext().size() == 0)
			doDeleteStartNode();
	}
	
	public void undo() {		
			undoDeleteStartNode();
		if (endVisual != null)
			undoDeleteEndNode();
		
	}
}