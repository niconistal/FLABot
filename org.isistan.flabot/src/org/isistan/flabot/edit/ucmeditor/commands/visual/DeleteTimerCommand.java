package org.isistan.flabot.edit.ucmeditor.commands.visual;

import java.util.ArrayList;

import org.isistan.flabot.coremodel.CoreModel;
import org.isistan.flabot.coremodel.CoremodelFactory;
import org.isistan.flabot.coremodel.Path;
import org.isistan.flabot.coremodel.PathNode;
import org.isistan.flabot.coremodel.TimerNode;
import org.isistan.flabot.edit.editormodel.ConnectionVisualModel;
import org.isistan.flabot.edit.editormodel.EditormodelFactory;
import org.isistan.flabot.edit.editormodel.NodeVisualModel;
import org.isistan.flabot.edit.editormodel.Util;
import org.isistan.flabot.edit.ucmeditor.figures.PathPointFigure;
import org.isistan.flabot.edit.ucmeditor.figures.TimerFigure;
import org.isistan.flabot.edit.ucmmodel.UCMDiagram;
import org.isistan.flabot.messages.Messages;

/**
 * @author $Author: Martin Villalba $
 *
 */
public class DeleteTimerCommand extends UpdateAllPathCommand {//extends DeletePathNodeCommand {
	
//	private CoreModel coreModel;
//	private TimerNode timerNode;
//	
//	/**
//	 * Create a new path node delete command
//	 * @param selectedNode the node selected for deletion
//	 */
//	public DeleteTimerCommand(NodeVisualModel selectedNode) {
//		super(selectedNode);
//		coreModel = selectedNode.getDiagram().getCoreModel();
//		timerNode = (TimerNode)selectedNode.getSemanticModel();
//		setLabel(Messages.getString("org.isistan.flabot.edit.ucmeditor.commands.visual.DeleteTimerCommand.label")); //$NON-NLS-1$
//	}
//	
//	public void redo() {
//		super.redo();
//		coreModel.getTimers().remove(timerNode);
//	}
//
//	public void undo() {
//		super.undo();
//		coreModel.getTimers().add(timerNode);
//	}
	
	//The diagram UCM diagram where the visuals are
	private UCMDiagram diagram;
	
	//The selected Visual and semantic - the timer
	private NodeVisualModel selectedVisual;
	private PathNode selectedSemantic;
	
	//The three connections, the visual and semantic nodes
	private ConnectionVisualModel conPrevious;
	private ConnectionVisualModel conNext1;
	private ConnectionVisualModel conNext2;
	private NodeVisualModel previousNode;
	private NodeVisualModel nextNode1;
	private NodeVisualModel nextNode2;	
	private PathNode previousSemantic;
	private PathNode nextSemantic1;
	private PathNode nextSemantic2;
	
	private NodeVisualModel newStartVisualNode;
	private PathNode newStartNode = CoremodelFactory.eINSTANCE.createSimplePathNode();		
	
	private Path oldPath;
	private Path newPath = CoremodelFactory.eINSTANCE.createPath();
	
	/**
	 * Create an instance of the command that deletes the timer 
	 * @param visualNode the selected visual timer node to delete
	 */
	public DeleteTimerCommand(NodeVisualModel selectedNode) {
		this.selectedVisual = selectedNode;
		this.selectedSemantic = (PathNode) selectedNode.getSemanticModel();
		newStartVisualNode = EditormodelFactory.eINSTANCE.createNodeVisualModel(selectedVisual);
		newStartVisualNode.setSemanticModel(newStartNode);
		setLabel(Messages.getString("org.isistan.flabot.edit.ucmeditor.commands.visual.DeleteTimerCommand.label")); //$NON-NLS-1$
	}
	
	public void execute() {
		newStartVisualNode.setForegroundColor(selectedVisual.getForegroundColor().clone());
		newStartVisualNode.setSize(Util.getDimension(TimerFigure.defaultsize));
		
		diagram = (UCMDiagram) selectedVisual.getDiagram();
			
		conNext1 = (ConnectionVisualModel)selectedVisual.getSourceConnections().get(0);
		conNext2 = (ConnectionVisualModel)selectedVisual.getSourceConnections().get(1);
		nextNode1 = conNext1.getTarget();
		nextNode2 = conNext2.getTarget();
		nextSemantic1 = (PathNode) nextNode1.getSemanticModel();
		nextSemantic2 = (PathNode) nextNode2.getSemanticModel();
			
		conPrevious = (ConnectionVisualModel)selectedVisual.getTargetConnections().get(0);
		previousNode = conPrevious.getSource();
		previousSemantic = (PathNode) previousNode.getSemanticModel();
		
		oldPath = selectedSemantic.getPath();
		doDeleteTimer();
	}
	
	private void doDeleteTimer() {			
		conNext1.setTarget(null);
		conNext1.setSource(null);
		conPrevious.setSource(previousNode);
		conPrevious.setTarget(nextNode1);
		
		selectedSemantic.removeNext(nextSemantic1);
		selectedSemantic.removePrevious(previousSemantic);		
		previousSemantic.addNext(nextSemantic1);
		
		newPath.getNodes().add(newStartNode);
		newPath.getStartNodes().add(newStartNode);
		oldPath.getNodes().remove(selectedSemantic);
	
		selectedSemantic.removeNext(nextSemantic2);	
		newStartNode.addNext(nextSemantic2);
						
		conNext2.setSemanticModel(newPath);
		conNext2.setSource(newStartVisualNode);
		conNext2.setTarget(nextNode2);
		
		newStartVisualNode.setSemanticModel(newStartNode);
		
		updateNexts(newStartVisualNode, oldPath, newPath, new ArrayList());
		
		newStartVisualNode.setParent(selectedVisual.getParent());
		if (selectedVisual.getParent() == null)
			newStartVisualNode.setDiagram(diagram);
		
		selectedVisual.setParent(null);
		selectedVisual.setDiagram(null);
		
		diagram.getMap().getPaths().add(newPath);
	}
	
	private void undoDeleteTimer() {					
		diagram.getMap().getPaths().remove(newPath);
		updateNexts(newStartVisualNode, newPath, oldPath, new ArrayList());
		
		selectedVisual.setSemanticModel(selectedSemantic);
		selectedVisual.setParent(newStartVisualNode.getParent());
		if (newStartVisualNode.getParent() == null)
			selectedVisual.setDiagram(diagram);
		
		conNext1.setSemanticModel(oldPath);
		conNext1.setTarget(nextNode1);
		conNext1.setSource(selectedVisual);
		
		conNext2.setSemanticModel(oldPath);
		conNext2.setTarget(nextNode2);
		conNext2.setSource(selectedVisual);
		
		newStartVisualNode.setParent(null);
		newStartVisualNode.setDiagram(null);
		
		oldPath.getNodes().add(selectedSemantic);			
	
		nextSemantic1.removePrevious(previousSemantic);
		nextSemantic2.removePrevious(newStartNode);
		
		selectedSemantic.addNext(nextSemantic1);
		selectedSemantic.addNext(nextSemantic2);		
		selectedSemantic.addPrevious(previousSemantic);
		
		conPrevious.setSemanticModel(oldPath);
		conPrevious.setSource(previousNode);
		conPrevious.setTarget(selectedVisual);		
	}

	public void redo() {	
		//execute();
		doDeleteTimer();
	}
	
	public void undo() {
		undoDeleteTimer();	
	}
	
}
