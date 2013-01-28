/**
 * $Id: InsertForkCommand.java,v 1.3 2006/03/21 01:51:54 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.ucmeditor.commands.visual;

import java.util.Hashtable;
import java.util.List;
import java.util.Vector;

import org.isistan.flabot.coremodel.CoremodelFactory;
import org.isistan.flabot.coremodel.ForkNode;
import org.isistan.flabot.coremodel.JoinNode;
import org.isistan.flabot.coremodel.SimplePathNode;
import org.isistan.flabot.edit.editormodel.ConnectionVisualModel;
import org.isistan.flabot.edit.editormodel.EditormodelFactory;
import org.isistan.flabot.edit.editormodel.NodeVisualModel;
import org.isistan.flabot.edit.editormodel.Util;
import org.isistan.flabot.edit.editormodel.VisualModel;
import org.isistan.flabot.edit.ucmeditor.figures.PathPointFigure;
import org.isistan.flabot.edit.ucmeditor.figures.ThreeConnectionFigure;
import org.isistan.flabot.messages.Messages;

/**
 * InsertForkCommand
 * -	Extends InsertPathNodeCommand.
 * -	Inserts a fork node into an existing path.
 * 
 * @author $Author: franco $
 *
 */
public class InsertForkCommand extends InsertPathNodeCommand {
	
//	private SimplePathNode branchNode = CoremodelFactory.eINSTANCE.createSimplePathNode();
//	private SimplePathNode branchEndNode = CoremodelFactory.eINSTANCE.createSimplePathNode();
//	private NodeVisualModel visualBranchNode = EditormodelFactory.eINSTANCE.createNodeVisualModel();
//	private ConnectionVisualModel con1 = EditormodelFactory.eINSTANCE.createConnectionVisualModel();
//	private NodeVisualModel visualBranchEndNode = EditormodelFactory.eINSTANCE.createNodeVisualModel();
//	private ConnectionVisualModel con2 = EditormodelFactory.eINSTANCE.createConnectionVisualModel();
	
	private Vector branchNodes = new Vector();
	private Vector branchEndNodes = new Vector();
	private Vector visualBranchNodes = new Vector();
	private Vector visualBranchEndNodes = new Vector();
	private Vector connectionBranchNodes = new Vector();
	private Vector connectionBranchEndNodes = new Vector();
	
	private NodeVisualModel previousNode;
	
	public static Hashtable terminals = new Hashtable();
	
	static {
		
		terminals.put(0, ThreeConnectionFigure.TERMINAL_LEFT2);
		terminals.put(1, ThreeConnectionFigure.TERMINAL_LEFT3);
		terminals.put(2, ThreeConnectionFigure.TERMINAL_LEFT4);
		terminals.put(3, ThreeConnectionFigure.TERMINAL_LEFT5);
	}
	
	/**
	 * Create an instance of the command that inserts the fork on the
	 * given node
	 * @param visualNode the selected visual node
	 * @param forkNode the fork to be inserted
	 */
	public InsertForkCommand(NodeVisualModel visualNode, ForkNode forkNode) {
		super(visualNode, forkNode, ThreeConnectionFigure.getPreferedSize(ThreeConnectionFigure.RIGHT));
		setLabel(Messages.getString("org.isistan.flabot.edit.ucmeditor.commands.visual.InsertForkCommand.label")); //$NON-NLS-1$
	}
		
	/* (non-Javadoc)
	 * @see org.eclipse.gef.commands.Command#execute()
	 */
	@Override
	public void execute() {
		super.execute();
		newVisualNode.setRotation(ThreeConnectionFigure.RIGHT);
		newVisualNode.setSize(Util.getDimension(ThreeConnectionFigure.getPreferedSize(newVisualNode.getRotation())));
		doInsertFork();
	}

	private void doInsertFork() {	
		((ConnectionVisualModel)newVisualNode.getTargetConnections().get(0)).setTargetTerminal(ThreeConnectionFigure.TERMINAL_RIGHT);		
		((ConnectionVisualModel)newVisualNode.getSourceConnections().get(0)).setSourceTerminal(ThreeConnectionFigure.TERMINAL_LEFT1);
		
		ForkNode forkNode = (ForkNode) newNode;
		for (int i=0; i < forkNode.getOutputsCount() - 1; i++)
		{
			SimplePathNode branchNode = CoremodelFactory.eINSTANCE.createSimplePathNode();
			SimplePathNode branchEndNode = CoremodelFactory.eINSTANCE.createSimplePathNode();
			NodeVisualModel visualBranchNode = EditormodelFactory.eINSTANCE.createNodeVisualModel();
			ConnectionVisualModel con1 = EditormodelFactory.eINSTANCE.createConnectionVisualModel();
			NodeVisualModel visualBranchEndNode = EditormodelFactory.eINSTANCE.createNodeVisualModel();
			ConnectionVisualModel con2 = EditormodelFactory.eINSTANCE.createConnectionVisualModel();
			
			visualBranchNode.setSemanticModel(branchNode);
			visualBranchEndNode.setSemanticModel(branchEndNode);
			
			con1.setSemanticModel(path);
			con1.setSourceTerminal((String)terminals.get(i));
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
					newVisualNode.getLocation().getX() + 30,
					newVisualNode.getLocation().getY() + 10 + i * 10));
			visualBranchNode.setSize(Util.getDimension(PathPointFigure.defaultsize));
			setParent(visualBranchNode, newVisualNode);
			visualBranchNode.setForegroundColor(newVisualNode.getForegroundColor().clone());
			
			visualBranchEndNode.setSemanticModel(branchEndNode);
			visualBranchEndNode.setLocation(Util.getPoint(
					visualBranchNode.getLocation().getX() + 50,
					visualBranchNode.getLocation().getY() + 10 + i * 10));
			visualBranchEndNode.setSize(Util.getDimension(PathPointFigure.defaultsize));
			setParent(visualBranchEndNode, newVisualNode);
			visualBranchEndNode.setForegroundColor(newVisualNode.getForegroundColor().clone());
			
			branchNodes.add(branchNode);
			branchEndNodes.add(branchEndNode);
			visualBranchNodes.add(visualBranchNode);
			visualBranchEndNodes.add(visualBranchEndNode);
			connectionBranchNodes.add(con1);
			connectionBranchEndNodes.add(con2);
		}
	}
	
	protected void setParent(VisualModel node, NodeVisualModel parentNode) {
		VisualModel parent = parentNode.getParent();		
		node.setParent(parent);
		if (parent == null)
			node.setDiagram(parentNode.getDiagram());
	}
	
	private void undoInsertFork() {

		ForkNode forkNode = (ForkNode) newNode;
		for (int i=0; i < forkNode.getOutputsCount() - 1; i++)
		{
			SimplePathNode branchNode = (SimplePathNode)branchNodes.get(i);
			SimplePathNode branchEndNode = (SimplePathNode)branchEndNodes.get(i);
			NodeVisualModel visualBranchNode = (NodeVisualModel)visualBranchNodes.get(i);
			ConnectionVisualModel con1 = (ConnectionVisualModel)connectionBranchNodes.get(i);
			NodeVisualModel visualBranchEndNode = (NodeVisualModel) visualBranchEndNodes.get(i);
			ConnectionVisualModel con2 = (ConnectionVisualModel)connectionBranchEndNodes.get(i);
			
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

		branchNodes.removeAllElements();
		branchEndNodes.removeAllElements();
		visualBranchNodes.removeAllElements();
		visualBranchEndNodes.removeAllElements();
		connectionBranchNodes.removeAllElements();
		connectionBranchEndNodes.removeAllElements();
	}	
	
	/* (non-Javadoc)
	 * @see org.eclipse.gef.commands.Command#redo()
	 */
	@Override
	public void redo() {
		super.redo();		
		doInsertFork();		
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gef.commands.Command#undo()
	 */
	@Override
	public void undo() {					
		undoInsertFork();
		super.undo();
	}

}