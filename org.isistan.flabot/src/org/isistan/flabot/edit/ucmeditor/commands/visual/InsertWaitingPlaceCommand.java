package org.isistan.flabot.edit.ucmeditor.commands.visual;

import org.isistan.flabot.coremodel.TimerNode;
import org.isistan.flabot.edit.editormodel.NodeVisualModel;
import org.isistan.flabot.edit.ucmeditor.figures.PathPointFigure;
import org.isistan.flabot.edit.ucmeditor.figures.ThreeConnectionFigure;
import org.isistan.flabot.messages.Messages;

public class InsertWaitingPlaceCommand extends InsertPathNodeCommand {

	/**
	 * Create an instance of the command that inserts the timer on the given
	 * node
	 * 
	 * @param visualNode
	 *            the selected visual node
	 * @param timerNode
	 *            the timer to be inserted
	 */
	public InsertWaitingPlaceCommand(NodeVisualModel visualNode, TimerNode timerNode) {
		super(visualNode, timerNode, PathPointFigure.defaultsize);
		setLabel(Messages.getString("org.isistan.flabot.edit.ucmeditor.commands.visual.InsertTimerCommand.label")); //$NON-NLS-1$
	}

	protected void doInsertPathNode() {
		super.doInsertPathNode();
		((TimerNode) newNode).getMap().getCoreModel().getTimers().add(newNode);
	}

	protected void undoInsertPathNode() {
		super.undoInsertPathNode();
		((TimerNode) newNode).getMap().getCoreModel().getTimers().remove(
				newNode);
	}

//	/*
//	 * (non-Javadoc)
//	 * 
//	 * @see org.eclipse.gef.commands.Command#execute()
//	 */
//	@Override
//	public void execute() {
//		super.execute();
//		newVisualNode.setRotation(ThreeConnectionFigure.LEFT);
//		newVisualNode.setSize(Util.getDimension(ThreeConnectionFigure
//				.getPreferedSize(newVisualNode.getRotation())));
//		doInsertTimer();
//	}
//
//	private void doInsertTimer() {
//		((ConnectionVisualModel) newVisualNode.getSourceConnections().get(0))
//				.setSourceTerminal(ThreeConnectionFigure.TERMINAL_RIGHT);
//		((ConnectionVisualModel) newVisualNode.getTargetConnections().get(0))
//				.setTargetTerminal(ThreeConnectionFigure.TERMINAL_LEFT1);
//
//		visualBranchNode.setSemanticModel(branchNode);
//		visualBranchStartNode.setSemanticModel(branchStartNode);
//
//		// create the new join's branch
//		branchNode.addNext(newNode);
//		branchNode.setPath(path);
//		branchStartNode.addNext(branchNode);
//		branchStartNode.setPath(path);
//		path.getStartNodes().add(branchStartNode);
//
//		con1.setSemanticModel(path);
//		con1.setTargetTerminal(ThreeConnectionFigure.TERMINAL_LEFT2);
//		con1.setSource(visualBranchNode);
//		con1.setTarget(newVisualNode);
//
//		con2.setSemanticModel(path);
//		con2.setTarget(visualBranchNode);
//		con2.setSource(visualBranchStartNode);
//
//		// create the branch's visual models
//		visualBranchNode.setLocation(Util.getPoint(newVisualNode.getLocation()
//				.getX() + 50, newVisualNode.getLocation().getY() + 10));
//		visualBranchNode
//				.setSize(Util.getDimension(PathPointFigure.defaultsize));
//		setParent(visualBranchNode, newVisualNode);
//		visualBranchNode.setForegroundColor(newVisualNode.getForegroundColor()
//				.clone());
//
//		visualBranchStartNode.setLocation(Util.getPoint(visualBranchNode
//				.getLocation().getX() + 30, visualBranchNode.getLocation()
//				.getY()));
//		visualBranchStartNode.setSize(Util
//				.getDimension(PathPointFigure.defaultsize));
//		setParent(visualBranchStartNode, newVisualNode);
//		visualBranchStartNode.setForegroundColor(newVisualNode
//				.getForegroundColor().clone());
//	}
//
//	protected void setParent(VisualModel node, NodeVisualModel parentNode) {
//		VisualModel parent = parentNode.getParent();
//		node.setParent(parent);
//		if (parent == null)
//			node.setDiagram(parentNode.getDiagram());
//	}
//
//	private void undoInsertTimer() {
//		// delete the branch's visual model
//		finishConnection(con2);
//		finishVisualNode(visualBranchStartNode);
//
//		finishConnection(con1);
//		finishVisualNode(visualBranchNode);
//
//		// delete the branch
//		path.getStartNodes().remove(branchStartNode);
//		branchStartNode.removeNext(branchNode);
//		branchStartNode.setPath(null);
//		branchNode.removeNext(newNode);
//		branchNode.setPath(null);
//
//		((ConnectionVisualModel) newVisualNode.getTargetConnections().get(0))
//				.setTargetTerminal(""); //$NON-NLS-1$
//		((ConnectionVisualModel) newVisualNode.getSourceConnections().get(0))
//				.setSourceTerminal(""); //$NON-NLS-1$
//	}
//
//	/*
//	 * (non-Javadoc)
//	 * 
//	 * @see org.eclipse.gef.commands.Command#redo()
//	 */
//	@Override
//	public void redo() {
//		super.redo();
//		doInsertTimer();
//	}
//
//	/*
//	 * (non-Javadoc)
//	 * 
//	 * @see org.eclipse.gef.commands.Command#undo()
//	 */
//	@Override
//	public void undo() {
//		undoInsertTimer();
//		super.undo();
//	}
}
