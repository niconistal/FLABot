package org.isistan.flabot.edit.ucmeditor.commands.visual;

import java.util.ArrayList;

import org.isistan.flabot.coremodel.Path;
import org.isistan.flabot.coremodel.PathNode;
import org.isistan.flabot.coremodel.SimplePathNode;
import org.isistan.flabot.edit.editormodel.ConnectionVisualModel;
import org.isistan.flabot.edit.editormodel.EditormodelFactory;
import org.isistan.flabot.edit.editormodel.NodeVisualModel;
import org.isistan.flabot.edit.editormodel.Point;
import org.isistan.flabot.edit.editormodel.Util;
import org.isistan.flabot.edit.editormodel.VisualModel;
import org.isistan.flabot.edit.ucmeditor.editparts.PathNodeEditPart;
import org.isistan.flabot.edit.ucmeditor.figures.PathPointFigure;
import org.isistan.flabot.edit.ucmmodel.UCMDiagram;
import org.isistan.flabot.messages.Messages;

/**
 * 
 * @author $Author: Martin Villalba $
 * 
 */
public class MergePathsCommand extends UpdateAllPathCommand {

	private UCMDiagram diagram;

	private NodeVisualModel mergeNodeVisual = EditormodelFactory.eINSTANCE
			.createNodeVisualModel();

	private PathNode mergeSemantic;

	private ConnectionVisualModel conn1 = EditormodelFactory.eINSTANCE
			.createConnectionVisualModel();
	// private ConnectionVisualModel conn2 = EditormodelFactory.eINSTANCE
	// .createConnectionVisualModel();

	private NodeVisualModel visualNodePath1;
	private NodeVisualModel visualNodePath2;

	private SimplePathNode semanticNodePath1;
	private String oldName1;
	private SimplePathNode semanticNodePath2;
	private String oldName2;

	private ConnectionVisualModel nextConnection;
	private NodeVisualModel nextVisualModel;
	private PathNode nextNode;
	private VisualModel parent;

	private Path newPath;
	private Path oldPath;
	
	private PathNodeEditPart part;
	
	private int maxX = 0;
	private int minY = 0;
	
	Point mergeNodeLocation;

	/**
	 * Create a new command to join an end node with a start node
	 * 
	 * @param nodePath1
	 *            the first visual node
	 * @param nodePath2
	 *            the second visual node
	 */
	public MergePathsCommand(NodeVisualModel nodePath1,
			NodeVisualModel nodePath2, SimplePathNode mergeSemantic, PathNodeEditPart part) {
		if (((SimplePathNode) nodePath1.getSemanticModel()).isStart()) {
			this.visualNodePath1 = nodePath1;
			this.visualNodePath2 = nodePath2;
		} else {
			this.visualNodePath1 = nodePath2;
			this.visualNodePath2 = nodePath1;
		}
		this.part = part;

		// nextVisual.setSize(Util.getDimension(PathPointFigure.defaultsize));
		// joinVisual.setSize(Util.getDimension(ThreeConnectionFigure.getPreferedSize(ThreeConnectionFigure.RIGHT)));
		// joinVisual.setSemanticModel(joinSemantic);
		// this.joinSemantic = (JoinNode) joinVisual.getSemanticModel();
		mergeNodeVisual.setSemanticModel(mergeSemantic);
		this.mergeSemantic = mergeSemantic;

		this.semanticNodePath1 = (SimplePathNode) visualNodePath1
				.getSemanticModel();
		oldName1 = semanticNodePath1.getName();
		this.semanticNodePath2 = (SimplePathNode) visualNodePath2
				.getSemanticModel();
		oldName2 = semanticNodePath2.getName();

		setLabel(Messages
				.getString("org.isistan.flabot.edit.ucmeditor.commands.visual.MergePathsCommand.label")); //$NON-NLS-1$
	}

	/**
	 * Returns <code>true</code> if the two nodes given are en nodes.
	 * 
	 * @return <code>true</code> if the command can be executed
	 */
	public boolean canExecute() {
		return (semanticNodePath1 != null && semanticNodePath2 != null && ((semanticNodePath1
				.isEnd() && semanticNodePath2.isStart()) || (semanticNodePath1
				.isStart() && semanticNodePath2.isEnd())));
	}

	/**
	 * Executes the Command. This method should not be called if the Command is
	 * not executable. joins an end node with a start node
	 * 
	 * @see redo()
	 */
	public void execute() {
		diagram = (UCMDiagram) visualNodePath1.getDiagram();

		newPath = semanticNodePath1.getPath();
		oldPath = semanticNodePath2.getPath();

		maxX = Math.max(visualNodePath1.getAbsoluteLocation().getX(),
				visualNodePath2.getAbsoluteLocation().getX());
		minY = Math.min(visualNodePath1.getAbsoluteLocation().getY(),
				visualNodePath2.getAbsoluteLocation().getY());
		int dif = Math.abs(visualNodePath1.getAbsoluteLocation().getY()
				- visualNodePath2.getAbsoluteLocation().getY()) / 2;
		minY += dif;

		mergeNodeVisual.setSize(Util.getDimension(PathPointFigure.defaultsize));
		mergeNodeLocation = visualNodePath1.getLocation();
		// mergeNodeVisual.setLocation(visualNodePath2.getAbsoluteLocation());
		// nextVisual.setLocation(Util.getPoint(mergeNodeVisual.getAbsoluteLocation().getX()
		// + 50, mergeNodeVisual.getAbsoluteLocation().getY()));
		// joinVisual.setRotation(ThreeConnectionFigure.LEFT);

		// conn1.setSemanticModel(newPath);
		// conn1.setTargetTerminal(ThreeConnectionFigure.TERMINAL_LEFT1);
		// conn2.setSemanticModel(newPath);
		// conn2.setTargetTerminal(ThreeConnectionFigure.TERMINAL_LEFT2);
		// conn3.setSemanticModel(newPath);
		// conn3.setSourceTerminal(ThreeConnectionFigure.TERMINAL_RIGHT);

		conn1.setSemanticModel(newPath);
		// conn2.setSemanticModel(newPath);
		
		nextConnection = ((ConnectionVisualModel) visualNodePath1
				.getSourceConnections().get(0));
		nextVisualModel = nextConnection.getTarget();
		nextNode = (PathNode) nextVisualModel.getSemanticModel();

		parent = visualNodePath1.getParent();
		
		redo();
	}

	/**
	 * REDO COMMENTS Joins the two paths in one. The end nodes are removes from
	 * the list of end nodes of its path; and all the nodes previous to the
	 * second end node are updated with the path of the first end node, so they
	 * all belong to only one semantic path.
	 */
	public void redo() {

		mergeNodeVisual.setLocation(Util.getPoint(maxX + 50, minY));
		
		mergeSemantic.setPath(newPath);
		newPath.getNodes().add(mergeSemantic);

		// semanticNodePath1.getPath().getStartNodes().remove(semanticNodePath1);
		semanticNodePath2.getPath().getEndNodes().remove(semanticNodePath2);
		semanticNodePath2.addNext(mergeSemantic);

		semanticNodePath1.setName(""); //$NON-NLS-1$
		semanticNodePath2.setName(""); //$NON-NLS-1$

		replaceStartNodeInPath();

		updateConnections();
		
		if (parent != null)
		{
			visualNodePath1.setParent(null);
			mergeNodeVisual.setParent(parent);
		}
		else
		{
			visualNodePath1.setDiagram(null);
			mergeNodeVisual.setDiagram(diagram);
		}

		semanticNodePath2.setPath(newPath);
		newPath.getNodes().add(semanticNodePath2);

		if (oldPath != newPath) {
			updatePrevious(visualNodePath2, oldPath, newPath, new ArrayList());
			deleteOldPath();
		}

		newPath.getStartNodes().remove(semanticNodePath1);
		mergeNodeVisual.setLocation(mergeNodeLocation.clone());
		
		part.setModel(mergeNodeVisual);
	}

	private void deleteOldPath() {
		diagram.getMap().getPaths().remove(oldPath);
	}

	private void updateConnections() {
		nextConnection.setSource(mergeNodeVisual);
		nextConnection.setTarget(nextVisualModel);

		conn1.setSource(visualNodePath2);
		conn1.setTarget(mergeNodeVisual);
	}

	private void replaceStartNodeInPath() {
		nextNode.removePrevious(semanticNodePath1);
		semanticNodePath1.removeNext(nextNode);

		nextNode.addPrevious(mergeSemantic);
		mergeSemantic.addNext(nextNode);

		semanticNodePath1.setPath(null);
		newPath.getNodes().remove(semanticNodePath1);
	}

	/**
	 * Separates the two joined nodes. The join node is removed and the end
	 * nodes are restored. All the nodes previous to the second end node are
	 * updated with the old path, so the state is restored.
	 */
	public void undo() {

//		part.setModel(visualNodePath1);
//		visualNodePath1.setLocation(mergeNodeVisual.getLocation().clone());
//		if (this.parent != null)
//			visualNodePath1.setParent(parent);
//		else
//			visualNodePath1.setDiagram(diagram);
//		
//		semanticNodePath2.removeNext(mergeSemantic);
//		nextNode.removePrevious(mergeSemantic);
//		nextNode.addPrevious(semanticNodePath1);
//		semanticNodePath1.addNext(nextNode);
//
//		semanticNodePath1.setName(oldName1);
//		semanticNodePath2.setName(oldName2);
//
//		newPath.getNodes().remove(mergeSemantic);
//		
//		semanticNodePath1.setPath(newPath);
//		newPath.getNodes().add(semanticNodePath1);
//		
//		//newPath.getNodes().remove(semanticNodePath2);
//		oldPath.getNodes().add(semanticNodePath2);
//		semanticNodePath2.setPath(oldPath);
//		
//		if (oldPath != newPath) {
//			updatePrevious(visualNodePath2, newPath, oldPath, new ArrayList());
//			diagram.getMap().getPaths().add(oldPath);
//		}
//		
//		oldPath.getEndNodes().add(semanticNodePath2);
//		
//		newPath.getStartNodes().add(semanticNodePath1);
//
//		conn1.setSource(null);
//		conn1.setTarget(null);
//		//conn1.setDiagram(null);
//
//		nextConnection.setSource(visualNodePath1);
//		nextConnection.setTarget(nextVisualModel);
//
//		mergeNodeVisual.setDiagram(null);
//		mergeSemantic.setPath(null);
		
		visualNodePath1.setLocation(Util.getPoint(maxX + 50, minY));
		
		semanticNodePath1.setPath(newPath);
		newPath.getNodes().add(semanticNodePath1);
		newPath.getStartNodes().add(semanticNodePath1);
		
		oldPath.getNodes().add(semanticNodePath2);
		oldPath.getEndNodes().add(semanticNodePath2);
		semanticNodePath2.removeNext(mergeSemantic);
		
		semanticNodePath1.setName(oldName1);
		semanticNodePath2.setName(oldName2);
		
		nextNode.removePrevious(mergeSemantic);
		mergeSemantic.removeNext(nextNode);
		
		nextNode.addPrevious(semanticNodePath1);
		semanticNodePath1.addNext(nextNode);
		
		mergeSemantic.setPath(null);
		newPath.getNodes().remove(mergeSemantic);
		
		nextConnection.setSource(visualNodePath1);
		nextConnection.setTarget(nextVisualModel);
		
		conn1.setSource(null);
		conn1.setTarget(null);
		
		if (this.parent != null)
		{
			visualNodePath1.setParent(parent);
			mergeNodeVisual.setParent(null);
		}
		else
		{
			visualNodePath1.setDiagram(diagram);
			mergeNodeVisual.setDiagram(null);
		}

		//newPath.getNodes().remove(semanticNodePath2);
		semanticNodePath2.setPath(oldPath);
		
		
		if (oldPath != newPath) {
			updatePrevious(visualNodePath2, newPath, oldPath, new ArrayList());
			diagram.getMap().getPaths().add(oldPath);
		}

		visualNodePath1.setLocation(mergeNodeLocation);
		
		part.setModel(visualNodePath1);
		
	}

}
