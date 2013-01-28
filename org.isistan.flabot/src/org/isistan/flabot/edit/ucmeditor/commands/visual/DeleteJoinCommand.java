/**
 * $Id: DeleteJoinCommand.java,v 1.2 2006/03/21 01:51:55 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.ucmeditor.commands.visual;

import java.util.ArrayList;
import java.util.Vector;

import org.isistan.flabot.coremodel.CoremodelFactory;
import org.isistan.flabot.coremodel.JoinNode;
import org.isistan.flabot.coremodel.Path;
import org.isistan.flabot.coremodel.PathNode;
import org.isistan.flabot.edit.editormodel.ConnectionVisualModel;
import org.isistan.flabot.edit.editormodel.EditormodelFactory;
import org.isistan.flabot.edit.editormodel.NodeVisualModel;
import org.isistan.flabot.edit.editormodel.Point;
import org.isistan.flabot.edit.editormodel.Util;
import org.isistan.flabot.edit.ucmeditor.figures.PathPointFigure;
import org.isistan.flabot.edit.ucmmodel.UCMDiagram;
import org.isistan.flabot.messages.Messages;

/**
 * DeleteJoinCommand
 * -	Removes a join node from an existing path, splitting the path in two different paths.
 * 
 * @author $Author: franco $
 *
 */
public class DeleteJoinCommand extends UpdateAllPathCommand {

	private UCMDiagram diagram;
	
	private NodeVisualModel selectedVisual;
	private PathNode selectedSemantic;
	
	private Path oldPath;

	private Vector<ConnectionVisualModel> connectionBranchNodes = new Vector();
	private ConnectionVisualModel conNext;
	private Vector<NodeVisualModel> visualBranchNodes = new Vector();
	
	private NodeVisualModel nextNode;

	private Vector<PathNode> branchNodes = new Vector();
	private PathNode nextSemantic;
	
	private Vector<PathNode> newEndNodes = new Vector<PathNode>();
	
	private Vector<NodeVisualModel> newEndVisualNodes = new Vector<NodeVisualModel>();
	
	private Vector<Path> newPaths = new Vector<Path>();
	
	private Point selectedLocation;
	private NodeVisualModel parent;
	
	/**
	 * Create an instance of the command that deletes the join
	 * @param visualNode the selected visual join node to delete 
	 */
	public DeleteJoinCommand(NodeVisualModel selectedNode) {
		this.selectedVisual = selectedNode;
		this.selectedLocation = Util.getPoint(this.selectedVisual.getLocation().getX(), this.selectedVisual.getLocation().getY());
		
		this.selectedSemantic = (PathNode) selectedNode.getSemanticModel();
		for (int inputs=0; inputs < ((JoinNode)this.selectedSemantic).getInputsCount() - 1; inputs++)
		{
			newEndVisualNodes.add(EditormodelFactory.eINSTANCE.createNodeVisualModel(selectedVisual));
			newEndNodes.add(CoremodelFactory.eINSTANCE.createSimplePathNode());
			newPaths.add(CoremodelFactory.eINSTANCE.createPath());
		}
		setLabel(Messages.getString("org.isistan.flabot.edit.ucmeditor.commands.visual.DeleteJoinCommand.label")); //$NON-NLS-1$
	}
	
	public void execute() {		
		
		diagram = (UCMDiagram) selectedVisual.getDiagram();
		
		for (int i=0; i < ((JoinNode)selectedSemantic).getInputsCount(); i++)
		{
			ConnectionVisualModel previousCon = (ConnectionVisualModel)selectedVisual.getTargetConnections().get(i);
			connectionBranchNodes.add(previousCon);
			NodeVisualModel previousNode = previousCon.getSource();
			visualBranchNodes.add(previousNode);
			PathNode previousSemantic = (PathNode) previousNode.getSemanticModel();
			branchNodes.add(previousSemantic);
		}
			
		conNext = (ConnectionVisualModel)selectedVisual.getSourceConnections().get(0);
		nextNode = conNext.getTarget();
		nextSemantic = (PathNode) nextNode.getSemanticModel();										
		
		oldPath = selectedSemantic.getPath();		
		doDeleteJoin();		
	}
	
	private void doDeleteJoin() {	
	
		conNext.setSource(null);
		conNext.setTarget(null);
		
		ConnectionVisualModel conPrevious1 = (ConnectionVisualModel)connectionBranchNodes.elementAt(0);
		NodeVisualModel previousNode1 = (NodeVisualModel)visualBranchNodes.elementAt(0);
		PathNode previousSemantic1 = (PathNode)branchNodes.elementAt(0);
		
		conPrevious1.setSource(previousNode1);
		conPrevious1.setTarget(nextNode);
		
		selectedSemantic.removePrevious(previousSemantic1);	
		selectedSemantic.removeNext(nextSemantic);
		previousSemantic1.addNext(nextSemantic);
		this.parent = (NodeVisualModel)selectedVisual.getParent();
						
		//Genereate new paths
		for (int j=1; j < branchNodes.size(); j++)
		{
			NodeVisualModel newEndVisualNode = newEndVisualNodes.elementAt(j-1);
			newEndVisualNode.setForegroundColor(selectedVisual.getForegroundColor().clone());
			newEndVisualNode.setSize(Util.getDimension(PathPointFigure.defaultsize));
			
			Path newPath = newPaths.elementAt(j-1);
			PathNode newEndNode = newEndNodes.elementAt(j-1);
			newPath.getEndNodes().add(newEndNode);
			newPath.getNodes().add(newEndNode);
			oldPath.getNodes().remove(selectedSemantic);
			
			PathNode previousSemantic = branchNodes.elementAt(j);
			selectedSemantic.removePrevious(previousSemantic);
			previousSemantic.addNext(newEndNode);		
	
			NodeVisualModel previousNode = visualBranchNodes.elementAt(j);
			ConnectionVisualModel conPrevious = connectionBranchNodes.elementAt(j);
			conPrevious.setSemanticModel(newPath);
			conPrevious.setSource(previousNode);
			conPrevious.setTarget(newEndVisualNode);
			
			newEndVisualNode.setSemanticModel(newEndNode);
			
			//Before adding the new end node to the diagram
			updatePrevious(newEndVisualNode, oldPath, newPath, new ArrayList());
					
			newEndVisualNode.setParent(selectedVisual.getParent());
			if (selectedVisual.getParent() == null)
				newEndVisualNode.setDiagram(diagram);	
			newEndVisualNode.setLocation(Util.getPoint(selectedLocation.getX(), selectedLocation.getY()+ (j * 10)));
			
			diagram.getMap().getPaths().add(newPath);
		}
		
		if (oldPath.getNodes().size() == 0)
			diagram.getMap().getPaths().remove(oldPath);

		selectedVisual.setParent(null);
		selectedVisual.setDiagram(null);
	}
	
	private void undoDeleteJoin() {
		ConnectionVisualModel conPrevious1 = (ConnectionVisualModel)connectionBranchNodes.elementAt(0);
		NodeVisualModel previousNode1 = (NodeVisualModel)visualBranchNodes.elementAt(0);
		PathNode previousSemantic1 = (PathNode)branchNodes.elementAt(0);
		

		
		if (oldPath.getNodes().size() == 0)
			diagram.getMap().getPaths().add(oldPath);
		
		NodeVisualModel newEndVisualNode = newEndVisualNodes.elementAt(1);
		selectedVisual.setSemanticModel(selectedSemantic);
		selectedVisual.setParent(newEndVisualNode.getParent());
		
		if (newEndVisualNode.getParent() == null)
			selectedVisual.setDiagram(diagram);
		
		conPrevious1.setSemanticModel(oldPath);
		conPrevious1.setSource(previousNode1);
		conPrevious1.setTarget(selectedVisual);	
		
		for (int j = 1; j < ((JoinNode)selectedSemantic).getInputsCount(); j++)
		{
			newEndVisualNode = newEndVisualNodes.elementAt(j-1);
			Path newPath = newPaths.elementAt(j-1);
			PathNode newEndNode = newEndNodes.elementAt(j-1);
			
			PathNode previousSemantic = branchNodes.elementAt(j);
			NodeVisualModel previousNode = visualBranchNodes.elementAt(j);
			ConnectionVisualModel conPrevious = connectionBranchNodes.elementAt(j);

			diagram.getMap().getPaths().remove(newPath);		
			updatePrevious(newEndVisualNode, newPath, oldPath, new ArrayList());
	
			conPrevious.setSemanticModel(oldPath);
			conPrevious.setSource(previousNode);
			conPrevious.setTarget(selectedVisual);		
			
			newEndVisualNode.setParent(null);
			newEndVisualNode.setDiagram(null);				
								
			
			previousSemantic1.removeNext(nextSemantic);
			previousSemantic.removeNext(newEndNode);
		
			selectedSemantic.addPrevious(previousSemantic1);
			selectedSemantic.addPrevious(previousSemantic);
			selectedSemantic.addNext(nextSemantic);
			
			conNext.setSemanticModel(oldPath);
			conNext.setSource(selectedVisual);
			conNext.setTarget(nextNode);
		}
		oldPath.getNodes().add(selectedSemantic);
	}
	
	public void redo() {
		doDeleteJoin();
	}
	
	public void undo() {
		undoDeleteJoin();	
	}
}
