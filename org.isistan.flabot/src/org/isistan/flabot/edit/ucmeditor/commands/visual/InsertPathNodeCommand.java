/**
 * $Id: InsertPathNodeCommand.java,v 1.3 2006/03/21 01:51:55 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.ucmeditor.commands.visual;

import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.gef.commands.CompoundCommand;
import org.isistan.flabot.coremodel.Path;
import org.isistan.flabot.coremodel.PathNode;
import org.isistan.flabot.coremodel.ResponsibilityNode;
import org.isistan.flabot.edit.editormodel.ConnectionVisualModel;
import org.isistan.flabot.edit.editormodel.EditormodelFactory;
import org.isistan.flabot.edit.editormodel.NodeVisualModel;
import org.isistan.flabot.edit.editormodel.Util;
import org.isistan.flabot.edit.editormodel.VisualModel;
import org.isistan.flabot.messages.Messages;

/**
 * InsertPathNodeCommand
 * -	This is the common super command for InsertForkCommand, InsetJoinCommand and InsertResponsibilityCommand.
 * -	Removes the current path node (a simple path node) from the path to change it for a Fork, Join or Responsibility Node.
 * -	Adds a new path node in an existing path, can be a simple node or a responsibility node, in which case additional nodes may be inserted after and before the desired node. 
 * 
 * 
 * @author $Author: franco $
 *
 */
public abstract class InsertPathNodeCommand extends CompoundCommand {

	protected NodeVisualModel newVisualNode = EditormodelFactory.eINSTANCE.createNodeVisualModel();
	protected PathNode newNode;
	
	protected NodeVisualModel visualNode;
	protected PathNode node;
	protected Path path;	
	
	private PathNode previous;
	private PathNode next;	

	/**
	 * Create an instance of this command that will insert a responsibility
	 * on the selected visual node
	 * @param visualNode
	 */
	public InsertPathNodeCommand(NodeVisualModel visualNode,
			PathNode newNode, Dimension size) {
		this.visualNode = visualNode;
		this.node = (PathNode) visualNode.getSemanticModel();
		this.newNode = newNode;
		newVisualNode.setSize(Util.getDimension(size));
		setLabel(Messages.getString("org.isistan.flabot.edit.ucmeditor.commands.visual.InsertPathNodeCommand.label")); //$NON-NLS-1$
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gef.commands.Command#canExecute()
	 */
	@Override
	public boolean canExecute() {
		return node != null && newNode != null;
	}
	
	public boolean canUndo() {
		return true;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.gef.commands.Command#execute()
	 */
	@Override
	public void execute() {
		PathNode prev = (PathNode)node.uGetPrevious().get(0);
		if (prev.isStart() || prev instanceof ResponsibilityNode)
			add(new InsertNodeCommand(visualNode, InsertNodeCommand.BEFORE));		
		
		PathNode next = (PathNode)node.uGetNext().get(0);
		if (next.isEnd() || next instanceof ResponsibilityNode)
			add(new InsertNodeCommand(visualNode, InsertNodeCommand.AFTER));
		
		super.execute();
		
		path = node.getPath();
		doInsertPathNode();
	}

	protected void doInsertPathNode() {		
		// replace the current node with the responsibility			
		node.setPath(null);
		path.getNodes().remove(node);
		newNode.setPath(path);

		previous = (PathNode)node.uGetPrevious().get(0);
		next = (PathNode)node.uGetNext().get(0);
		
		previous.removeNext(node);
		previous.addNext(newNode);		
		next.removePrevious(node);
		next.addPrevious(newNode);
				
		//set the visual model's semantic model to the new node
		newVisualNode.setSemanticModel(newNode);		
		newVisualNode.setLocation(visualNode.getLocation().clone());
		newVisualNode.setForegroundColor(visualNode.getForegroundColor().clone());
		
		((ConnectionVisualModel)visualNode.getSourceConnections().get(0)).setSource(newVisualNode);
		((ConnectionVisualModel)visualNode.getTargetConnections().get(0)).setTarget(newVisualNode);
		
		changeParent(visualNode, newVisualNode);
	}
	
	protected void changeParent(VisualModel oldNode, VisualModel newNode)  {
		VisualModel parent = oldNode.getParent();		
		if (parent != null) {
			newNode.setParent(parent);
			oldNode.setParent(null);
		} else {
			newNode.setDiagram(oldNode.getDiagram());
			oldNode.setDiagram(null);
		}
	}
	
	protected void undoInsertPathNode() {			
		// restore the fork node to the original simple node
		visualNode.setSemanticModel(node);
		next.removePrevious(newNode);
		next.addPrevious(node);
		previous.removeNext(newNode);
		previous.addNext(node);
		path.getNodes().remove(newNode);
		node.setPath(path);
		
		((ConnectionVisualModel)newVisualNode.getSourceConnections().get(0)).setSource(visualNode);
		((ConnectionVisualModel)newVisualNode.getTargetConnections().get(0)).setTarget(visualNode);
		
		changeParent(newVisualNode, visualNode);
		newNode.setPath(null);
		newVisualNode.setSemanticModel(null);
	}
	
	protected void finishConnection(ConnectionVisualModel c) {
		c.setTarget(null);
		c.setSource(null);
		c.setSemanticModel(null);
	}
	
	protected void finishVisualNode(NodeVisualModel n) {
		n.setParent(null);
		n.setDiagram(null);
		n.setSemanticModel(null);		
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.gef.commands.Command#redo()
	 */
	@Override
	public void redo() {
		super.redo();
		doInsertPathNode();		
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gef.commands.Command#undo()
	 */
	@Override
	public void undo() {	
		undoInsertPathNode();
		super.undo();
	}
}