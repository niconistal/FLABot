/**
 * $Id: InsertJoinCommand.java,v 1.3 2006/03/21 01:51:55 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.ucmeditor.commands.visual;

import java.util.Hashtable;
import java.util.List;
import java.util.Vector;

import org.isistan.flabot.coremodel.CoremodelFactory;
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
 * @author $Author: franco $
 *
 */
public class InsertJoinCommand extends InsertPathNodeCommand {
//	private SimplePathNode branchNode = CoremodelFactory.eINSTANCE.createSimplePathNode();
//	private SimplePathNode branchStartNode = CoremodelFactory.eINSTANCE.createSimplePathNode();
//	private NodeVisualModel visualBranchNode = EditormodelFactory.eINSTANCE.createNodeVisualModel();
//	private ConnectionVisualModel con1 = EditormodelFactory.eINSTANCE.createConnectionVisualModel();
//	private NodeVisualModel visualBranchStartNode = EditormodelFactory.eINSTANCE.createNodeVisualModel();
//	private ConnectionVisualModel con2 = EditormodelFactory.eINSTANCE.createConnectionVisualModel();
	
	private Vector branchNodes = new Vector();
	private Vector branchStartNodes = new Vector();
	private Vector visualBranchNodes = new Vector();
	private Vector visualBranchStartNodes = new Vector();
	private Vector connectionBranchNodes = new Vector();
	private Vector connectionBranchStartNodes = new Vector();
	
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
	public InsertJoinCommand(NodeVisualModel visualNode, JoinNode joinNode) {
		super(visualNode, joinNode, ThreeConnectionFigure.getPreferedSize(ThreeConnectionFigure.LEFT));
		setLabel(Messages.getString("org.isistan.flabot.edit.ucmeditor.commands.visual.InsertJoinCommand.label")); //$NON-NLS-1$
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gef.commands.Command#execute()
	 */
	@Override
	public void execute() {
		super.execute();
		newVisualNode.setRotation(ThreeConnectionFigure.LEFT);
		newVisualNode.setSize(Util.getDimension(ThreeConnectionFigure.getPreferedSize(newVisualNode.getRotation())));
		doInsertJoin();
	}

	private void doInsertJoin() {		
		((ConnectionVisualModel)newVisualNode.getSourceConnections().get(0)).setSourceTerminal(ThreeConnectionFigure.TERMINAL_RIGHT);		
		((ConnectionVisualModel)newVisualNode.getTargetConnections().get(0)).setTargetTerminal(ThreeConnectionFigure.TERMINAL_LEFT1);
//		
//		visualBranchNode.setSemanticModel(branchNode);
//		visualBranchStartNode.setSemanticModel(branchStartNode);
//		
//		//create the new join's branch
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
//		//create the branch's visual models							
//		visualBranchNode.setLocation(Util.getPoint(
//				newVisualNode.getLocation().getX() + 50,
//				newVisualNode.getLocation().getY() + 10));
//		visualBranchNode.setSize(Util.getDimension(PathPointFigure.defaultsize));
//		setParent(visualBranchNode, newVisualNode);
//		visualBranchNode.setForegroundColor(newVisualNode.getForegroundColor().clone());
//						
//		visualBranchStartNode.setLocation(Util.getPoint(
//				visualBranchNode.getLocation().getX() + 30,
//				visualBranchNode.getLocation().getY()));
//		visualBranchStartNode.setSize(Util.getDimension(PathPointFigure.defaultsize));
//		setParent(visualBranchStartNode, newVisualNode);
//		visualBranchStartNode.setForegroundColor(newVisualNode.getForegroundColor().clone());
		JoinNode joinNode = (JoinNode) newNode;
		for (int i=0; i < joinNode.getInputsCount() - 1; i++)
		{
			SimplePathNode branchNode = CoremodelFactory.eINSTANCE.createSimplePathNode();
			SimplePathNode branchStartNode = CoremodelFactory.eINSTANCE.createSimplePathNode();
			NodeVisualModel visualBranchNode = EditormodelFactory.eINSTANCE.createNodeVisualModel();
			ConnectionVisualModel con1 = EditormodelFactory.eINSTANCE.createConnectionVisualModel();
			NodeVisualModel visualBranchStartNode = EditormodelFactory.eINSTANCE.createNodeVisualModel();
			ConnectionVisualModel con2 = EditormodelFactory.eINSTANCE.createConnectionVisualModel();
			
			visualBranchNode.setSemanticModel(branchNode);
			visualBranchStartNode.setSemanticModel(branchStartNode);
			
			//create the new join's branch
			branchNode.addNext(newNode);
			branchNode.setPath(path);		
			branchStartNode.addNext(branchNode);
			branchStartNode.setPath(path);
			path.getStartNodes().add(branchStartNode);
			
			con1.setSemanticModel(path);
			//con1.setTargetTerminal(ThreeConnectionFigure.TERMINAL_LEFT2);
			con1.setTargetTerminal((String)terminals.get(i));
			con1.setSource(visualBranchNode);
			con1.setTarget(newVisualNode);
			joinNode.setName("Node " + i );
			
			con2.setSemanticModel(path);
			con2.setTarget(visualBranchNode);
			con2.setSource(visualBranchStartNode);
//			
//			//create the branch's visual models							
			visualBranchNode.setLocation(Util.getPoint(
					newVisualNode.getLocation().getX() - 30,
					newVisualNode.getLocation().getY() + 10 + i * 10));
			visualBranchNode.setSize(Util.getDimension(PathPointFigure.defaultsize));
			setParent(visualBranchNode, newVisualNode);
			visualBranchNode.setForegroundColor(newVisualNode.getForegroundColor().clone());
							
			visualBranchStartNode.setLocation(Util.getPoint(
					visualBranchNode.getLocation().getX() - 50,
					visualBranchNode.getLocation().getY() + 10 + i * 10));
			visualBranchStartNode.setSize(Util.getDimension(PathPointFigure.defaultsize));
			setParent(visualBranchStartNode, newVisualNode);
			visualBranchStartNode.setForegroundColor(newVisualNode.getForegroundColor().clone());
			
			branchNodes.add(branchNode);
			branchStartNodes.add(branchStartNode);
			visualBranchNodes.add(visualBranchNode);
			visualBranchStartNodes.add(visualBranchStartNode);
			connectionBranchNodes.add(con1);
			connectionBranchStartNodes.add(con2);
		}
	}
	
	
	protected void setParent(VisualModel node, NodeVisualModel parentNode) {
		VisualModel parent = parentNode.getParent();		
		node.setParent(parent);
		if (parent == null)
			node.setDiagram(parentNode.getDiagram());
	}
	
	private void undoInsertJoin() {
		// delete the branch's visual model		
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
//		((ConnectionVisualModel)newVisualNode.getTargetConnections().get(0)).setTargetTerminal("");		 //$NON-NLS-1$
//		((ConnectionVisualModel)newVisualNode.getSourceConnections().get(0)).setSourceTerminal(""); //$NON-NLS-1$
		
		JoinNode joinNode = (JoinNode) newNode;
		for (int i=0; i < joinNode.getInputsCount() - 1; i++)
		{
			SimplePathNode branchNode = (SimplePathNode)branchNodes.get(i);
			SimplePathNode branchStartNode = (SimplePathNode)branchStartNodes.get(i);
			NodeVisualModel visualBranchNode = (NodeVisualModel)visualBranchNodes.get(i);
			ConnectionVisualModel con1 = (ConnectionVisualModel)connectionBranchNodes.get(i);
			NodeVisualModel visualBranchStartNode = (NodeVisualModel) visualBranchStartNodes.get(i);
			ConnectionVisualModel con2 = (ConnectionVisualModel)connectionBranchStartNodes.get(i);
			
			
			finishConnection(con2);
			finishVisualNode(visualBranchStartNode);
		
			finishConnection(con1);
			finishVisualNode(visualBranchNode);
			
			// delete the branch
			path.getStartNodes().remove(branchStartNode);
			branchStartNode.removeNext(branchNode);
			branchStartNode.setPath(null);
			branchNode.removeNext(newNode);
			branchNode.setPath(null);
			
			((ConnectionVisualModel)newVisualNode.getTargetConnections().get(0)).setTargetTerminal("");		 //$NON-NLS-1$
			((ConnectionVisualModel)newVisualNode.getSourceConnections().get(0)).setSourceTerminal(""); //$NON-NLS-1$
		}
		
		
		branchNodes.removeAllElements();
		branchStartNodes.removeAllElements();
		visualBranchNodes.removeAllElements();
		visualBranchStartNodes.removeAllElements();
		connectionBranchNodes.removeAllElements();
		connectionBranchStartNodes.removeAllElements();
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.gef.commands.Command#redo()
	 */
	@Override
	public void redo() {
		super.redo();		
		doInsertJoin();		
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gef.commands.Command#undo()
	 */
	@Override
	public void undo() {			
		undoInsertJoin();
		super.undo();		
	}
}