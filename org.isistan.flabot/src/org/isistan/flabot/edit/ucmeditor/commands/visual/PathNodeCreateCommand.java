/**
 * $Id: PathNodeCreateCommand.java,v 1.2 2006/03/21 01:51:54 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.ucmeditor.commands.visual;

import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.commands.Command;
import org.isistan.flabot.coremodel.CoremodelFactory;
import org.isistan.flabot.coremodel.Path;
import org.isistan.flabot.coremodel.SimplePathNode;
import org.isistan.flabot.edit.editormodel.ConnectionVisualModel;
import org.isistan.flabot.edit.editormodel.EditormodelFactory;
import org.isistan.flabot.edit.editormodel.NodeVisualModel;
import org.isistan.flabot.edit.editormodel.Util;
import org.isistan.flabot.edit.ucmeditor.figures.PathPointFigure;
import org.isistan.flabot.edit.ucmmodel.UCMDiagram;
import org.isistan.flabot.messages.Messages;

/**
 * A command that creates a new path node and links it to the currently
 * selected node. If there's no selected node, a new path should be created.
 * @author $Author: franco $
 *
 */
public class PathNodeCreateCommand extends Command {
	
	private Rectangle bounds;
	
	private UCMDiagram diagram;
	private NodeVisualModel host;
	
	//the selected visual and semantic node (if exists)
	private NodeVisualModel selectedVisualNode;
	private SimplePathNode selectedSemanticNode;
	
	//the new visual and semantic end node
	private NodeVisualModel newVisualEndNode;
	private SimplePathNode newSemanticEndNode;
	
	//the path
	private Path path = CoremodelFactory.eINSTANCE.createPath();;
	
	//the new connection
	private ConnectionVisualModel newConnection = EditormodelFactory.eINSTANCE.createConnectionVisualModel();
	
	//the previous connection
	private ConnectionVisualModel previousConnection;
	private NodeVisualModel previousVisualNode;
	private SimplePathNode previousSemanticNode;
	
	private PathNodeCreateCommand(NodeVisualModel newVisualNode, Rectangle bounds,
			NodeVisualModel selectedVisualNode) {
		this.newVisualEndNode = newVisualNode;
		this.newSemanticEndNode  = (SimplePathNode)newVisualNode.getSemanticModel();
		this.selectedVisualNode = getSelectedNode(selectedVisualNode);
		this.bounds = bounds;
		setLabel(Messages.getString("org.isistan.flabot.edit.ucmeditor.commands.visual.PathNodeCreateCommand.label")); //$NON-NLS-1$
	}	
	
	/**
	 * Create a new Path Node Create command
	 * @param newVisualNode the new visual node to be added
	 * @param bounds the bounds for the request
	 * @param selectedVisualNode the currently selected visual node
	 * @param diagram the ucm diagram
	 */
	public PathNodeCreateCommand(
			NodeVisualModel newVisualNode, Rectangle bounds,
			NodeVisualModel selectedVisualNode, UCMDiagram diagram) {
		this(newVisualNode, bounds, selectedVisualNode);
		this.diagram = diagram;
	}
	
	public PathNodeCreateCommand(
			NodeVisualModel newVisualNode, Rectangle bounds,
			NodeVisualModel selectedVisualNode, NodeVisualModel host) {
		this(newVisualNode, bounds, selectedVisualNode);
		this.host = host;
		this.diagram = (UCMDiagram)host.getDiagram();
	}

	private NodeVisualModel getSelectedNode(NodeVisualModel selectedVisualNode) {		
		if (selectedVisualNode != null) {
			// if there's a selected node, find the last one in its trivial path
			while (selectedVisualNode.getSourceConnections().size()==1) {
				ConnectionVisualModel connection = (ConnectionVisualModel)
					selectedVisualNode.getSourceConnections().get(0);
				selectedVisualNode = connection.getTarget();
			}
		}
		return selectedVisualNode;
	}	

	/**
	 * Can execute if all the necessary information has been provided and
	 * 1. there's no selected node so a new path should be created,
	 * 2. the selected node is a final point or
	 * 3. a final point can be trivially found starting from the selected node
	 * @see org.eclipse.gef.commands.Command#canExecute()
	 */
	public boolean canExecute() {
		if (newVisualEndNode != null && diagram != null && bounds != null) {
			if (selectedVisualNode == null)
				return true;
			selectedSemanticNode = (SimplePathNode)selectedVisualNode.getSemanticModel();
			path = selectedSemanticNode.getPath();
			return path.getEndNodes().contains(selectedSemanticNode);
		}
		return false;
	}


	@Override
	public void execute() {
		newVisualEndNode.setLocation(Util.getPoint(bounds.getLocation()));
		newVisualEndNode.setSize(Util.getDimension(PathPointFigure.defaultsize));		
		if (newSemanticEndNode == null) {
			newSemanticEndNode = CoremodelFactory.eINSTANCE.createSimplePathNode();
			newVisualEndNode.setSemanticModel(newSemanticEndNode);
		}
		
		if (selectedVisualNode != null && selectedVisualNode.getTargetConnections().size() > 0) {
			newVisualEndNode.setForegroundColor(selectedVisualNode.getForegroundColor().clone());
			previousConnection = (ConnectionVisualModel) selectedVisualNode.getTargetConnections().get(0);
			previousVisualNode = previousConnection.getSource();
			previousSemanticNode = (SimplePathNode)previousVisualNode.getSemanticModel();
		} 
		redo();
	}


	@Override
	public void redo() {
		if (selectedVisualNode == null) {
			// there's no selected node, a new path is created
			path.getStartNodes().add(newSemanticEndNode);
			path.getEndNodes().add(newSemanticEndNode);
			path.getNodes().add(newSemanticEndNode);
			diagram.getMap().getPaths().add(path);
		}
		else {
			path = selectedSemanticNode.getPath();
			newConnection.setSemanticModel(path);
			newVisualEndNode.setForegroundColor(selectedVisualNode.getForegroundColor().clone());
			
			if (previousConnection == null) {
				//there's one start node
				path.getNodes().add(newSemanticEndNode);
				path.getEndNodes().add(newSemanticEndNode);
				path.getEndNodes().remove(selectedSemanticNode);
				selectedSemanticNode.addNext(newSemanticEndNode);
				newSemanticEndNode.addPrevious(selectedSemanticNode);
								
				newConnection.setSource(selectedVisualNode);
				newConnection.setTarget(newVisualEndNode);
			} else {			
				//there's two or more nodes in the path
				path.getNodes().add(newSemanticEndNode);
				previousSemanticNode.removeNext(selectedSemanticNode);
				previousSemanticNode.addNext(newSemanticEndNode);
				newSemanticEndNode.addNext(selectedSemanticNode);
				selectedSemanticNode.removePrevious(selectedSemanticNode);
				selectedSemanticNode.addPrevious(newSemanticEndNode);				

				newVisualEndNode.setSemanticModel(selectedSemanticNode);
				selectedVisualNode.setSemanticModel(newSemanticEndNode);
				
				previousConnection.setSource(previousVisualNode);
				previousConnection.setTarget(selectedVisualNode);
				newConnection.setSource(selectedVisualNode);
				newConnection.setTarget(newVisualEndNode);
				newSemanticEndNode.setName(""); //$NON-NLS-1$
			}
		}
		
		if (host != null)
			newVisualEndNode.setParent(host);
		else
			diagram.getChildren().add(newVisualEndNode);
	}
	
	public boolean canUndo() {
		return true;
	}

	@Override
	public void undo() {
		if (selectedVisualNode == null)
			diagram.getMap().getPaths().remove(path);
		else {
			
			if (previousConnection == null) {								
				path.getNodes().remove(newSemanticEndNode);
				path.getEndNodes().remove(newSemanticEndNode);
				path.getEndNodes().add(selectedSemanticNode);
				
				selectedSemanticNode.removeNext(newSemanticEndNode);		
			} else {				
				previousSemanticNode.removeNext(newSemanticEndNode);
				previousSemanticNode.addNext(selectedSemanticNode);
				selectedSemanticNode.removePrevious(newSemanticEndNode);
				selectedSemanticNode.addPrevious(previousSemanticNode);
				path.getNodes().remove(newSemanticEndNode);				
				
				selectedVisualNode.setSemanticModel(selectedSemanticNode);
				selectedSemanticNode.setName(selectedSemanticNode.getName());
			}
			
			newConnection.setSemanticModel(null);
			newConnection.setSource(null);
			newConnection.setTarget(null);

		}
		if (host != null)
			newVisualEndNode.setParent(null);
		else
			diagram.getChildren().remove(newVisualEndNode);
	}
}
