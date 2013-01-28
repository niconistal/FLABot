/**
 * $Id: InsertNodeCommand.java,v 1.3 2006/03/21 01:51:55 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.ucmeditor.commands.visual;

import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.commands.Command;
import org.isistan.flabot.coremodel.CoremodelFactory;
import org.isistan.flabot.coremodel.PathNode;
import org.isistan.flabot.edit.editormodel.ConnectionVisualModel;
import org.isistan.flabot.edit.editormodel.EditormodelFactory;
import org.isistan.flabot.edit.editormodel.NodeVisualModel;
import org.isistan.flabot.edit.editormodel.Util;
import org.isistan.flabot.edit.editormodel.VisualModel;
import org.isistan.flabot.edit.ucmeditor.figures.PathPointFigure;
import org.isistan.flabot.messages.Messages;

/**
 * @author $Author: franco $
 *
 */
public class InsertNodeCommand extends Command {
	
	public final static String BEFORE = "Previous"; //$NON-NLS-1$
	public final static String AFTER = "Next"; //$NON-NLS-1$
	
	//Visual and SemanticModel of the node of insertion.
	private NodeVisualModel nodeVisual;
	private PathNode nodeSemantic;

	//Connection, NodeVisualModel and SemanticModel to insert
	private ConnectionVisualModel insertedConnection = EditormodelFactory.eINSTANCE.createConnectionVisualModel();
	private NodeVisualModel insertedVisual = EditormodelFactory.eINSTANCE.createNodeVisualModel();	
	private PathNode insertedSemantic = CoremodelFactory.eINSTANCE.createSimplePathNode();
	
	private ConnectionVisualModel modifyConnection;
	private PathNode modifyNode;
	
	private String side;
	
	public InsertNodeCommand(NodeVisualModel nodeVisual, String side) {
		this.nodeVisual = nodeVisual;
		this.nodeSemantic = (PathNode) nodeVisual.getSemanticModel();
		this.side = side;
		setLabel(Messages.getString("org.isistan.flabot.edit.ucmeditor.commands.visual.InsertNodeCommand.label") + side); //$NON-NLS-1$
	}
	
	protected void setSide(String side) {
		this.side = side;
	}
	
	public boolean canExecute() {
		if (nodeVisual != null && nodeSemantic != null) {
			if (side.equals(BEFORE))
				return (!nodeSemantic.isStart());
			
			if (side.equals(AFTER))
				return (!nodeSemantic.isEnd());			
		}
		return false;
	}
	
	public void execute() {
		redo();
	}
	
	//Can have Note Connections
	private ConnectionVisualModel getCorrect(EObject path, List list) {	
		for (Iterator iter=list.iterator(); iter.hasNext();) {
			ConnectionVisualModel c = (ConnectionVisualModel) iter.next();
			if (path == c.getSemanticModel())
				return c;
		}
		return null;
	}
	
	public void doInsertPrevious() {
		if (!nodeSemantic.isStart()) {
			//CoreModel part
			modifyNode = (PathNode) nodeSemantic.uGetPrevious().get(0);
			insertedSemantic.setPath(nodeSemantic.getPath());		
		
			modifyNode.removeNext(nodeSemantic);
			modifyNode.addNext(insertedSemantic);
			nodeSemantic.addPrevious(insertedSemantic);
		
			//Semantic part
			modifyConnection = getCorrect(nodeSemantic.getPath(), nodeVisual.getTargetConnections());
			NodeVisualModel previousVisual = modifyConnection.getSource();
			
			insertedVisual.setLocation(
					Util.getPoint(
							getInsertedX(previousVisual, nodeVisual),
							getInsertedY(previousVisual, nodeVisual)
							)
					);			
			insertedVisual.setSize(Util.getDimension(PathPointFigure.defaultsize));
			insertedVisual.setForegroundColor(nodeVisual.getForegroundColor().clone());
			insertedVisual.setSemanticModel(insertedSemantic);
			insertedVisual.setParent(nodeVisual.getParent());
			if (nodeVisual.getParent() == null)
				insertedVisual.setDiagram(nodeVisual.getDiagram());
		
			modifyConnection.setTarget(insertedVisual);

			insertedConnection.setSemanticModel(nodeSemantic.getPath());
			insertedConnection.setSource(insertedVisual);
			insertedConnection.setTarget(nodeVisual);
		}			
	}
	
	public void doInsertNext() {
		if (!nodeSemantic.isEnd()) {
			//CoreModel part
			modifyNode = (PathNode) nodeSemantic.uGetNext().get(0);
			insertedSemantic.setPath(nodeSemantic.getPath());		
				
			modifyNode.removePrevious(nodeSemantic);
			modifyNode.addPrevious(insertedSemantic);
			nodeSemantic.addNext(insertedSemantic);
		
			//Semantic part
			modifyConnection = (ConnectionVisualModel)
				nodeVisual.getSourceConnections().get(0);
			NodeVisualModel nextVisual = modifyConnection.getTarget();

			insertedVisual.setLocation(
					Util.getPoint(
							getInsertedX(nextVisual, nodeVisual),
							getInsertedY(nextVisual, nodeVisual)
							)
					);
			insertedVisual.setSize(Util.getDimension(PathPointFigure.defaultsize));
			insertedVisual.setForegroundColor(nodeVisual.getForegroundColor().clone());
			insertedVisual.setSemanticModel(insertedSemantic);			
			insertedVisual.setParent(nodeVisual.getParent());
			if (nodeVisual.getParent() == null)
				insertedVisual.setDiagram(nodeVisual.getDiagram());
		
			modifyConnection.setSource(insertedVisual);

			insertedConnection.setSemanticModel(nodeSemantic.getPath());
			insertedConnection.setSource(nodeVisual);
			insertedConnection.setTarget(insertedVisual);
		}			
	}
	
	private int getInsertedX(NodeVisualModel source, NodeVisualModel actual) {
		int middle = (source.getAbsoluteLocation().getX() + actual.getAbsoluteLocation().getX()) / 2;
		int correct = middle - (actual.getAbsoluteLocation().getX() - actual.getLocation().getX());
		if (correct < 0) return 0;
				
		VisualModel parent = actual.getParent(); 
		if (parent != null) {
			if (correct > parent.getSize().getWidth())
				return parent.getSize().getWidth() - 20;
		}
		return correct;
	}
	
	private int getInsertedY(NodeVisualModel source, NodeVisualModel actual) {
		int middle = (source.getAbsoluteLocation().getY() + actual.getAbsoluteLocation().getY()) / 2;
		int correct = middle - (actual.getAbsoluteLocation().getY() - actual.getLocation().getY());
		if (correct < 0) return 0;
				
		VisualModel parent = actual.getParent(); 
		if (parent != null) {
			if (correct > parent.getSize().getHeight())
				return parent.getSize().getHeight();
		}
		return correct;
	}
	
	public void undoInsertPrevious() {
		if (!nodeSemantic.isStart()) {
			//Visual part
			finishConnection(insertedConnection);
			modifyConnection.setTarget(nodeVisual);
			finishVisualNode(insertedVisual);

			//CoreModel part		
			modifyNode.removeNext(insertedSemantic);
			nodeSemantic.removePrevious(insertedSemantic);
			nodeSemantic.addPrevious(modifyNode);
			insertedSemantic.setPath(null);
		}
	}
	
	public void undoInsertNext() {
		if (!nodeSemantic.isEnd()) {
			//Visual part
			finishConnection(insertedConnection);
			modifyConnection.setSource(nodeVisual);
			finishVisualNode(insertedVisual);

			//CoreModel part		
			modifyNode.removePrevious(insertedSemantic);
			nodeSemantic.removeNext(insertedSemantic);
			nodeSemantic.addNext(modifyNode);
			insertedSemantic.setPath(null);
		}
	}
	
	protected void finishConnection(ConnectionVisualModel c) {
		c.setTarget(null);
		c.setSource(null);
		c.setSemanticModel(null);
	}
	
	protected void finishVisualNode(NodeVisualModel n) {
		n.setDiagram(null);
		n.setSemanticModel(null);
	}
	
	public void redo() {
		if (BEFORE.equals(side))
			doInsertPrevious();
		else if (AFTER.equals(side))
			doInsertNext();		
	}
	
	public void undo() {
		if (BEFORE.equals(side))
			undoInsertPrevious();
		else if (AFTER.equals(side))
			undoInsertNext();
	}
}