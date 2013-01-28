package org.isistan.flabot.edit.ucmeditor.commands.visual;

import org.isistan.flabot.coremodel.CoremodelFactory;
import org.isistan.flabot.coremodel.JoinNode;
import org.isistan.flabot.coremodel.SimplePathNode;
import org.isistan.flabot.coremodel.StubNode;
import org.isistan.flabot.coremodel.TimerNode;
import org.isistan.flabot.edit.editormodel.ConnectionVisualModel;
import org.isistan.flabot.edit.editormodel.EditormodelFactory;
import org.isistan.flabot.edit.editormodel.NodeVisualModel;
import org.isistan.flabot.edit.editormodel.Util;
import org.isistan.flabot.edit.editormodel.VisualModel;
import org.isistan.flabot.edit.ucmeditor.figures.PathPointFigure;
import org.isistan.flabot.edit.ucmeditor.figures.ThreeConnectionFigure;
import org.isistan.flabot.edit.ucmeditor.figures.TimerFigure;
import org.isistan.flabot.messages.Messages;

/**
 * @author $Author: Martin Villalba $
 *
 */
public class InsertTimerCommand extends InsertPathNodeCommand {
	private SimplePathNode branchNode = CoremodelFactory.eINSTANCE.createSimplePathNode();
	private SimplePathNode branchEndNode = CoremodelFactory.eINSTANCE.createSimplePathNode();
	private NodeVisualModel visualBranchNode = EditormodelFactory.eINSTANCE.createNodeVisualModel();
	private ConnectionVisualModel con1 = EditormodelFactory.eINSTANCE.createConnectionVisualModel();
	private NodeVisualModel visualBranchEndNode = EditormodelFactory.eINSTANCE.createNodeVisualModel();
	private ConnectionVisualModel con2 = EditormodelFactory.eINSTANCE.createConnectionVisualModel();
	
	/**
	 * Create an instance of the command that inserts the timer on the
	 * given node
	 * @param visualNode the selected visual node
	 * @param timerNode the timer to be inserted
	 */
	public InsertTimerCommand(NodeVisualModel visualNode, TimerNode timerNode) {
		super(visualNode, timerNode, TimerFigure.defaultsize);
		setLabel(Messages.getString("org.isistan.flabot.edit.ucmeditor.commands.visual.InsertTimerCommand.label")); //$NON-NLS-1$
	}

//	protected void doInsertPathNode() {	
//		super.doInsertPathNode();
//		//((TimerNode)newNode).getMap().getCoreModel().getTimers().add(newNode);		
//	}
//	
//	protected void undoInsertPathNode() {			
//		super.undoInsertPathNode();
//		//((TimerNode)newNode).getMap().getCoreModel().getTimers().remove(newNode);
//	}
	/* (non-Javadoc)
	 * @see org.eclipse.gef.commands.Command#execute()
	 */
	@Override
	public void execute() {
		super.execute();
		newVisualNode.setRotation(ThreeConnectionFigure.LEFT);
		newVisualNode.setSize(Util.getDimension(ThreeConnectionFigure.getPreferedSize(newVisualNode.getRotation())));
		doInsertTimer();
	}

	private void doInsertTimer() {
		
		((ConnectionVisualModel)newVisualNode.getTargetConnections().get(0)).setTargetTerminal(ThreeConnectionFigure.TERMINAL_RIGHT);		
		((ConnectionVisualModel)newVisualNode.getSourceConnections().get(0)).setSourceTerminal(ThreeConnectionFigure.TERMINAL_LEFT1);
		
		con1.setSemanticModel(path);
		con1.setSourceTerminal(ThreeConnectionFigure.TERMINAL_LEFT2);
		con1.setTarget(visualBranchNode);
		con1.setSource(newVisualNode);
		
		//create the new fork's branch
		branchNode.addPrevious(newNode);
		branchNode.setPath(path);		
		branchEndNode.addPrevious(branchNode);
		branchEndNode.setPath(path);
		path.getEndNodes().add(branchEndNode);
		
		con2.setSemanticModel(path);
		con2.setSource(visualBranchNode);
		con2.setTarget(visualBranchEndNode);
		
		//create the branch's visual models					
		visualBranchNode.setSemanticModel(branchNode);
		visualBranchNode.setLocation(Util.getPoint(
				newVisualNode.getLocation().getX() + 50,
				newVisualNode.getLocation().getY() + 10));
		visualBranchNode.setSize(Util.getDimension(PathPointFigure.defaultsize));
		setParent(visualBranchNode, newVisualNode);
		visualBranchNode.setForegroundColor(newVisualNode.getForegroundColor().clone());
		
		visualBranchEndNode.setSemanticModel(branchEndNode);
		visualBranchEndNode.setLocation(Util.getPoint(
				visualBranchNode.getLocation().getX() + 30,
				visualBranchNode.getLocation().getY()));
		visualBranchEndNode.setSize(Util.getDimension(PathPointFigure.defaultsize));
		setParent(visualBranchEndNode, newVisualNode);
		visualBranchEndNode.setForegroundColor(newVisualNode.getForegroundColor().clone());		
	}
	
	
	protected void setParent(VisualModel node, NodeVisualModel parentNode) {
		VisualModel parent = parentNode.getParent();		
		node.setParent(parent);
		if (parent == null)
			node.setDiagram(parentNode.getDiagram());
	}
	
	private void undoInsertTimer() {		
		finishConnection(con2);
		finishVisualNode(visualBranchEndNode);
	
		finishConnection(con1);
		finishVisualNode(visualBranchNode);
		
		// delete the branch
		path.getEndNodes().remove(branchEndNode);
		branchEndNode.removePrevious(branchNode);
		branchEndNode.setPath(null);
		branchNode.removePrevious(newNode);
		branchNode.setPath(null);
		
		((ConnectionVisualModel)newVisualNode.getTargetConnections().get(0)).setTargetTerminal("");		 //$NON-NLS-1$
		((ConnectionVisualModel)newVisualNode.getSourceConnections().get(0)).setSourceTerminal("");		 //$NON-NLS-1$
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.gef.commands.Command#redo()
	 */
	@Override
	public void redo() {
		super.redo();		
		doInsertTimer();		
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gef.commands.Command#undo()
	 */
	@Override
	public void undo() {			
		undoInsertTimer();
		super.undo();		
	}
}
