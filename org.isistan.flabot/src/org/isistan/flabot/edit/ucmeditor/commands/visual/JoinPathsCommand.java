/**
 * $Id: JoinPathsCommand.java,v 1.2 2006/03/21 01:51:55 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.ucmeditor.commands.visual;

import java.util.ArrayList;

import org.isistan.flabot.coremodel.CoremodelFactory;
import org.isistan.flabot.coremodel.JoinNode;
import org.isistan.flabot.coremodel.Path;
import org.isistan.flabot.coremodel.SimplePathNode;
import org.isistan.flabot.edit.editormodel.ConnectionVisualModel;
import org.isistan.flabot.edit.editormodel.EditormodelFactory;
import org.isistan.flabot.edit.editormodel.NodeVisualModel;
import org.isistan.flabot.edit.editormodel.Util;
import org.isistan.flabot.edit.ucmeditor.figures.PathPointFigure;
import org.isistan.flabot.edit.ucmeditor.figures.ThreeConnectionFigure;
import org.isistan.flabot.edit.ucmmodel.UCMDiagram;
import org.isistan.flabot.messages.Messages;

/**
 * A command to join two paths (two end nodes) with a join node.
 * 
 * @author $Author: franco $
 *
 */
public class JoinPathsCommand extends UpdateAllPathCommand {

	private UCMDiagram diagram;
	
	private NodeVisualModel joinVisual = EditormodelFactory.eINSTANCE.createNodeVisualModel();
	private JoinNode joinSemantic;
	
	private ConnectionVisualModel conn1 = EditormodelFactory.eINSTANCE.createConnectionVisualModel();
	private ConnectionVisualModel conn2 = EditormodelFactory.eINSTANCE.createConnectionVisualModel();
	private ConnectionVisualModel conn3 = EditormodelFactory.eINSTANCE.createConnectionVisualModel();
		
	private NodeVisualModel visualNodePath1;
	private NodeVisualModel visualNodePath2;
	
	private SimplePathNode semanticNodePath1;
	private String oldName1;
	private SimplePathNode semanticNodePath2;
	private String oldName2;
	
	private NodeVisualModel nextVisual = EditormodelFactory.eINSTANCE.createNodeVisualModel();
	private SimplePathNode nextSemantic = CoremodelFactory.eINSTANCE.createSimplePathNode();
	
	private Path newPath;	
	private Path oldPath;
	
	/**
	 * Create a new command to join two end nodes
	 * @param nodePath1 the first visual end node
	 * @param nodePath2 the second visual end node
	 * @param joinSemantic the join node that will join the two nodes
	 */
	public JoinPathsCommand(NodeVisualModel nodePath1, NodeVisualModel nodePath2, JoinNode joinSemantic) {				
		this.visualNodePath1 = nodePath1;
		this.visualNodePath2 = nodePath2;
		if (nodePath1.getLocation().getY() > nodePath2.getLocation().getY()) {
			this.visualNodePath1 = nodePath2;
			this.visualNodePath2 = nodePath1;
		}
		nextVisual.setSize(Util.getDimension(PathPointFigure.defaultsize));
		joinVisual.setSize(Util.getDimension(ThreeConnectionFigure.getPreferedSize(ThreeConnectionFigure.RIGHT)));
		joinVisual.setSemanticModel(joinSemantic);
		this.joinSemantic = (JoinNode) joinVisual.getSemanticModel();
		this.semanticNodePath1 = (SimplePathNode)visualNodePath1.getSemanticModel();
		oldName1 = semanticNodePath1.getName();
		this.semanticNodePath2 = (SimplePathNode)visualNodePath2.getSemanticModel();
		oldName2 = semanticNodePath2.getName();
		
		setLabel(Messages.getString("org.isistan.flabot.edit.ucmeditor.commands.visual.JoinPathsCommand.label")); //$NON-NLS-1$
	}
	
	/**
	 * Returns <code>true</code> if the two nodes given are en nodes. 
	 * @return <code>true</code> if the command can be executed	
	 */
	public boolean canExecute() {
		return (semanticNodePath1 != null && semanticNodePath2 != null &&
				semanticNodePath1.isEnd() && semanticNodePath2.isEnd());
	}
	
	/**
	 * Executes the Command. This method should not be called if the Command is not
	 * executable.
	 * Joins the two end node with the join node.
	 * 
	 *  @see redo()
	 */
	public void execute() {
		diagram = (UCMDiagram)visualNodePath1.getDiagram();
		
		newPath = semanticNodePath1.getPath();
		oldPath = semanticNodePath2.getPath();
		joinVisual.setSemanticModel(joinSemantic);		
		nextVisual.setSemanticModel(nextSemantic);
				
		int maxX = Math.max(visualNodePath1.getAbsoluteLocation().getX(), visualNodePath2.getAbsoluteLocation().getX()); 
		int minY = Math.min(visualNodePath1.getAbsoluteLocation().getY(), visualNodePath2.getAbsoluteLocation().getY());
		int dif = Math.abs(visualNodePath1.getAbsoluteLocation().getY()- visualNodePath2.getAbsoluteLocation().getY()) / 2;
		minY += dif;
		
		joinVisual.setLocation(Util.getPoint(maxX + 50, minY));		
		nextVisual.setLocation(Util.getPoint(joinVisual.getAbsoluteLocation().getX() + 50, joinVisual.getAbsoluteLocation().getY()));
		joinVisual.setRotation(ThreeConnectionFigure.LEFT);
		
		conn1.setSemanticModel(newPath);
		conn1.setTargetTerminal(ThreeConnectionFigure.TERMINAL_LEFT1);
		conn2.setSemanticModel(newPath);		
		conn2.setTargetTerminal(ThreeConnectionFigure.TERMINAL_LEFT2);
		conn3.setSemanticModel(newPath);		
		conn3.setSourceTerminal(ThreeConnectionFigure.TERMINAL_RIGHT);
	
		redo();
	}
	
	/**
	 * Joins the two nodes with a join node. The end nodes are removes from the list of end nodes of its path; 
	 * and all the nodes previous to the second end node are updated with the path of the first end node, so they all belong to only one semantic path. 
	 */
	public void redo() {
		joinSemantic.setPath(newPath);
		nextSemantic.setPath(newPath);
		
		newPath.getNodes().add(joinSemantic);
		newPath.getNodes().add(nextSemantic);
		newPath.getEndNodes().add(nextSemantic);
		
		semanticNodePath1.getPath().getEndNodes().remove(semanticNodePath1);
		semanticNodePath2.getPath().getEndNodes().remove(semanticNodePath2);
		semanticNodePath1.addNext(joinSemantic);
		semanticNodePath2.addNext(joinSemantic);		
		nextSemantic.addPrevious(joinSemantic);		
		
		semanticNodePath1.setName(""); //$NON-NLS-1$
		semanticNodePath2.setName(""); //$NON-NLS-1$
		
		joinVisual.setDiagram(visualNodePath1.getDiagram());
		nextVisual.setDiagram(visualNodePath1.getDiagram());				
		
		semanticNodePath2.setPath(newPath);
		newPath.getNodes().add(semanticNodePath2);
		if (oldPath != newPath) {
			updatePrevious(visualNodePath2, oldPath, newPath, new ArrayList());
			diagram.getMap().getPaths().remove(oldPath);
		}
		
		conn1.setSource(visualNodePath1);
		conn1.setTarget(joinVisual);
		
		conn2.setSource(visualNodePath2);
		conn2.setTarget(joinVisual);
		
		conn3.setSource(joinVisual);
		conn3.setTarget(nextVisual);				
	}
	
	/**
	 * Separates the two joined nodes. The join node is removed and the end nodes are restored. 
	 * All the nodes previous to the second end node are updated with the old path, so the state is restored. 
	 */
	public void undo() {							
		semanticNodePath1.removeNext(joinSemantic);	
		semanticNodePath2.removeNext(joinSemantic);
		nextSemantic.removePrevious(joinSemantic);	
		
		semanticNodePath1.setName(oldName1);
		semanticNodePath2.setName(oldName2);
		
		newPath.getEndNodes().add(semanticNodePath1);
		oldPath.getEndNodes().add(semanticNodePath2);														
		
		newPath.getNodes().remove(joinSemantic);		
		newPath.getNodes().remove(nextSemantic);
		newPath.getEndNodes().remove(nextSemantic);
		
		conn1.setSource(null);
		conn1.setTarget(null);
				
		conn2.setSource(null);
		conn2.setTarget(null);
		
		conn3.setSource(null);
		conn3.setTarget(null);		
		
		joinVisual.setDiagram(null);
		nextVisual.setDiagram(null);
		
		nextSemantic.setPath(null);
		joinSemantic.setPath(null);		

		semanticNodePath2.setPath(oldPath);
		if (oldPath != newPath) {
			updatePrevious(visualNodePath2, newPath, oldPath, new ArrayList());
			diagram.getMap().getPaths().add(oldPath);
		}
	}
}