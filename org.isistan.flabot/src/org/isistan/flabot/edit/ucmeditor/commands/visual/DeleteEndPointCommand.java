/**

import java.util.Iterator;
	
	private SimplePathNode selectedSemantic;
	
	private Path path;
	
	private Diagram diagram;
		
	/**
	 * Create an instance of the command that deletes the end point of a path. 
	 */
	public DeleteEndPointCommand(NodeVisualModel selectedNode) {
		this.selectedVisual = selectedNode;
		selectedSemantic = (SimplePathNode) selectedNode.getSemanticModel();
		setLabel(Messages.getString("org.isistan.flabot.edit.ucmeditor.commands.visual.DeleteEndPointCommand.label")); //$NON-NLS-1$
	}
	
	public boolean canExecute() {
		return  (selectedSemantic.isEnd() && selectedSemantic.uGetPrevious().size() > 0 && !(selectedSemantic.uGetPrevious().get(0) instanceof ResponsibilityNode) && !(selectedSemantic.uGetPrevious().get(0) instanceof DirectionArrowNode));
	}
		
	public void execute() {		
		previousSemantic = (SimplePathNode)selectedSemantic.uGetPrevious().get(0);
		path = selectedSemantic.getPath();		
		
	}

	public void redo() {		
	
	public void undo() {
		if (previouspreviousSemantic != null) {			
	}
}