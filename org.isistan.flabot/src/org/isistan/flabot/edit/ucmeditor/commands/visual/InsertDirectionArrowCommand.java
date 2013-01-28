package org.isistan.flabot.edit.ucmeditor.commands.visual;

import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.gef.commands.CompoundCommand;
import org.isistan.flabot.coremodel.DirectionArrowNode;
import org.isistan.flabot.coremodel.Path;
import org.isistan.flabot.coremodel.PathNode;
import org.isistan.flabot.coremodel.ResponsibilityNode;
import org.isistan.flabot.edit.editormodel.ConnectionVisualModel;
import org.isistan.flabot.edit.editormodel.EditormodelFactory;
import org.isistan.flabot.edit.editormodel.NodeVisualModel;
import org.isistan.flabot.edit.editormodel.Point;
import org.isistan.flabot.edit.editormodel.Util;
import org.isistan.flabot.edit.editormodel.VisualModel;
import org.isistan.flabot.edit.ucmeditor.figures.DirectionArrowFigure;
import org.isistan.flabot.edit.ucmeditor.figures.ThreeConnectionFigure;
import org.isistan.flabot.messages.Messages;

public class InsertDirectionArrowCommand extends InsertPathNodeCommand {

	private int LOWEST_LIMIT = 30; // Represents the angle limit
	private int MIDDLE_LIMIT = 60; // Represents the angle limit

	private PathNode previous;
	private PathNode next;

	/**
	 * Create an instance of this command that will insert a responsibility on
	 * the selected visual node
	 * 
	 * @param visualNode
	 */
	public InsertDirectionArrowCommand(NodeVisualModel visualNode,
			DirectionArrowNode directionArrowNode) {
		super(visualNode, directionArrowNode, DirectionArrowFigure.defaultSize);
		this.visualNode = visualNode;
		this.node = (PathNode) visualNode.getSemanticModel();
		this.newNode = directionArrowNode;
		setLabel(Messages
				.getString("org.isistan.flabot.edit.ucmeditor.commands.visual.InsertDirectionArrowCommand.label")); //$NON-NLS-1$
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.commands.Command#execute()
	 */
	@Override
	public void execute() {
		// PathNode prev = (PathNode)node.uGetPrevious().get(0);
		// if (prev.isStart() || prev instanceof ResponsibilityNode)
		// add(new InsertNodeCommand(visualNode, InsertNodeCommand.BEFORE));
		//		
		// PathNode next = (PathNode)node.uGetNext().get(0);
		// if (next.isEnd() || next instanceof ResponsibilityNode)
		// add(new InsertNodeCommand(visualNode, InsertNodeCommand.AFTER));

		newVisualNode.setRotation(this.getDirectionArrowRotation());
		super.execute();
		
		//newVisualNode.setRotation(this.getDirectionArrowRotation());
		newVisualNode.setLocation(newVisualNode.getLocation().clone());
	}

	public String getDirectionArrowRotation() {
		// previous = (PathNode)node.uGetPrevious().get(0);
		//next = (PathNode) node.uGetNext().get(0);

		NodeVisualModel nextVisualModel = ((ConnectionVisualModel) visualNode
				.getSourceConnections().get(0)).getTarget();
		NodeVisualModel previousVisualModel = ((ConnectionVisualModel) visualNode.getTargetConnections().get(0)).getSource();
		
		return this.getDirectionArrowRotation(previousVisualModel, nextVisualModel);
	}

	private String getDirectionArrowRotation(NodeVisualModel previousVisualModel,
			NodeVisualModel nextVisualModel) {
		Point previousVisualModelLocation = previousVisualModel.getLocation();
		Point nextVisualModelLocation = nextVisualModel.getLocation();

		int difX = previousVisualModelLocation.getX() - nextVisualModelLocation.getX();
		int difAbsX = difX < 0 ? -difX : difX;

		int difY = previousVisualModelLocation.getY() - nextVisualModelLocation.getY();
		int difAbsY = difY < 0 ? -difY : difY;

		double tan = (double)difAbsY / (double)difAbsX;

		double angle = Math.atan(tan) * 180 / Math.PI;
		
		return this.getDirectionArrowRotation(angle, difX, difY);

	}

	private String getDirectionArrowRotation(double angle, int difX, int difY) {

				if (angle < this.LOWEST_LIMIT)
					return this.getLowestDirectionArrowRotation(difX);
				else if (angle < this.MIDDLE_LIMIT)
					return this.getLMiddleDirectionArrowRotation(difX, difY);
				else
					return this.getHighestDirectionArrowRotation(difY);
	}

	private String getLowestDirectionArrowRotation(int difX) {
		if (difX > 0)
			return DirectionArrowFigure.LEFT;
		else
			return DirectionArrowFigure.RIGHT;
	}

	private String getLMiddleDirectionArrowRotation(int difX, int difY) {
		
		if (difX > 0) {
			if (difY < 0)
				return DirectionArrowFigure.BOTTOM_LEFT;
			else
				return DirectionArrowFigure.TOP_LEFT;

		} else {
			if (difY < 0)
				return DirectionArrowFigure.BOTTOM_RIGHT;
			else
				return DirectionArrowFigure.TOP_RIGHT;
		}
	}
	
	private String getHighestDirectionArrowRotation(int difY) {
			if (difY < 0)
				return DirectionArrowFigure.BOTTOM;
			else
				return DirectionArrowFigure.TOP;
	}

	// protected void doInsertDirectionArrow() {
	// // replace the current node with the direction arrow
	// node.setPath(null);
	// path.getNodes().remove(node);
	// newNode.setPath(path);
	//
	// previous = (PathNode)node.uGetPrevious().get(0);
	// next = (PathNode)node.uGetNext().get(0);
	//		
	// previous.removeNext(node);
	// previous.addNext(newNode);
	// next.removePrevious(node);
	// next.addPrevious(newNode);
	//				
	// //set the visual model's semantic model to the new node
	// newVisualNode.setSemanticModel(newNode);
	// newVisualNode.setLocation(visualNode.getLocation().clone());
	// newVisualNode.setForegroundColor(visualNode.getForegroundColor().clone());
	//		
	// ((ConnectionVisualModel)visualNode.getSourceConnections().get(0)).setSource(newVisualNode);
	// ((ConnectionVisualModel)visualNode.getTargetConnections().get(0)).setTarget(newVisualNode);
	//		
	// changeParent(visualNode, newVisualNode);
	// }
	//	
	// protected void changeParent(VisualModel oldNode, VisualModel newNode) {
	// VisualModel parent = oldNode.getParent();
	// if (parent != null) {
	// newNode.setParent(parent);
	// oldNode.setParent(null);
	// } else {
	// newNode.setDiagram(oldNode.getDiagram());
	// oldNode.setDiagram(null);
	// }
	// }
	//	
	// protected void undoInsertPathNode() {
	// // restore the fork node to the original simple node
	// visualNode.setSemanticModel(node);
	// next.removePrevious(newNode);
	// next.addPrevious(node);
	// previous.removeNext(newNode);
	// previous.addNext(node);
	// path.getNodes().remove(newNode);
	// node.setPath(path);
	//		
	// ((ConnectionVisualModel)newVisualNode.getSourceConnections().get(0)).setSource(visualNode);
	// ((ConnectionVisualModel)newVisualNode.getTargetConnections().get(0)).setTarget(visualNode);
	//		
	// changeParent(newVisualNode, visualNode);
	// newNode.setPath(null);
	// newVisualNode.setSemanticModel(null);
	// }
	//	
	// protected void finishConnection(ConnectionVisualModel c) {
	// c.setTarget(null);
	// c.setSource(null);
	// c.setSemanticModel(null);
	// }
	//	
	// protected void finishVisualNode(NodeVisualModel n) {
	// n.setParent(null);
	// n.setDiagram(null);
	// n.setSemanticModel(null);
	// }
	//	
	// /* (non-Javadoc)
	// * @see org.eclipse.gef.commands.Command#redo()
	// */
	// @Override
	// public void redo() {
	// super.redo();
	// doInsertPathNode();
	// }
	//
	// /* (non-Javadoc)
	// * @see org.eclipse.gef.commands.Command#undo()
	// */
	// @Override
	// public void undo() {
	// undoInsertPathNode();
	// super.undo();
	// }
}
