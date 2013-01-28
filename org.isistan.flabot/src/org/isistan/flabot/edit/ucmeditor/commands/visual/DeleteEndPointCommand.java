/** * $Id: DeleteEndPointCommand.java,v 1.4 2006/03/21 23:02:37 franco Exp $ * $Author: franco $ */package org.isistan.flabot.edit.ucmeditor.commands.visual;

import java.util.Iterator;import java.util.List;import org.eclipse.gef.commands.Command;import org.isistan.flabot.coremodel.DirectionArrowNode;import org.isistan.flabot.coremodel.Path;import org.isistan.flabot.coremodel.ResponsibilityNode;import org.isistan.flabot.coremodel.SimplePathNode;import org.isistan.flabot.edit.editormodel.ConnectionVisualModel;import org.isistan.flabot.edit.editormodel.Diagram;import org.isistan.flabot.edit.editormodel.NodeVisualModel;import org.isistan.flabot.edit.editormodel.Point;import org.isistan.flabot.edit.editormodel.VisualModel;import org.isistan.flabot.messages.Messages;/** * A command that is used to delete the last node of a path in the UCM diagram. *  * @author $Author: franco $ * */public class DeleteEndPointCommand extends Command {
		private NodeVisualModel selectedVisual;
	private SimplePathNode selectedSemantic;		private SimplePathNode previouspreviousSemantic;		private ConnectionVisualModel previousConnection;	private NodeVisualModel previousVisual;	private SimplePathNode previousSemantic;
	
	private Path path;
	
	private Diagram diagram;	private Point oldLocation;	private VisualModel oldParent;	private Diagram oldDiagram;
		
	/**
	 * Create an instance of the command that deletes the end point of a path. 	 * @param visualNode the selected end visual node
	 */
	public DeleteEndPointCommand(NodeVisualModel selectedNode) {
		this.selectedVisual = selectedNode;
		selectedSemantic = (SimplePathNode) selectedNode.getSemanticModel();
		setLabel(Messages.getString("org.isistan.flabot.edit.ucmeditor.commands.visual.DeleteEndPointCommand.label")); //$NON-NLS-1$
	}
	
	public boolean canExecute() {
		return  (selectedSemantic.isEnd() && selectedSemantic.uGetPrevious().size() > 0 && !(selectedSemantic.uGetPrevious().get(0) instanceof ResponsibilityNode) && !(selectedSemantic.uGetPrevious().get(0) instanceof DirectionArrowNode));
	}
			/**	 * Returns the connection visual model in which the source semantic model is the semantic parameter. 	 * 	 * @param connections the list of connections	 * @param semantic the semantic model to look for	 * @return the connection visual model corresponding to 	 */	private ConnectionVisualModel getCorrectTargetConnection(List connections, SimplePathNode semantic) {		for(Iterator iter=connections.iterator(); iter.hasNext();) {			ConnectionVisualModel c = (ConnectionVisualModel) iter.next();			if (c.getSource().getSemanticModel() == semantic)				return c;		}		return null;	}		/**	 * Executes the command. Inicializates the source and target and the semantic model.	 * 	 * @see redo()	 */
	public void execute() {		
		previousSemantic = (SimplePathNode)selectedSemantic.uGetPrevious().get(0);				oldLocation = selectedVisual.getLocation();				oldParent = selectedVisual.getParent();		oldDiagram = selectedVisual.getDiagram();				previousConnection = getCorrectTargetConnection(selectedVisual.getTargetConnections(), previousSemantic);		previousVisual = previousConnection.getSource();				diagram = selectedVisual.getDiagram();
		path = selectedSemantic.getPath();		
				redo();
	}
	/**	 * Removes the last visual node from the path. Also the semantic model path is modified.	 * The last node is mantain, except it previous node is a start node, in that case it is removed.	 */
	public void redo() {				if (!previousSemantic.isStart()) {					previouspreviousSemantic = (SimplePathNode)previousSemantic.uGetPrevious().get(0);						previouspreviousSemantic.removeNext(previousSemantic);			previouspreviousSemantic.addNext(selectedSemantic);						previousSemantic.removePrevious(previouspreviousSemantic);			previousSemantic.removeNext(selectedSemantic);						selectedSemantic.removePrevious(previousSemantic);			selectedSemantic.addPrevious(previouspreviousSemantic);									path.getNodes().remove(previousSemantic);						ConnectionVisualModel previouspreviousConnection = getCorrectTargetConnection(previousVisual.getTargetConnections(), previouspreviousSemantic);			previouspreviousConnection.setTarget(selectedVisual);			selectedVisual.setLocation(previousVisual.getLocation().clone());			selectedVisual.setDiagram(previousVisual.getDiagram());			if(previousVisual.getParent() != null)				selectedVisual.setParent(previousVisual.getParent());						previousConnection.setSource(null);			previousConnection.setTarget(null);			previousVisual.setDiagram(null);				} else {			previousSemantic.removeNext(selectedSemantic);			path.getEndNodes().remove(selectedSemantic);			path.getEndNodes().add(previousSemantic);			path.getNodes().remove(selectedSemantic);			previousConnection.setSource(null);			previousConnection.setTarget(null);			selectedVisual.setDiagram(null);		}					}
		/**	 * Restores the last visual node of the path. Also the semantic model path is restored.	 */	
	public void undo() {
		if (previouspreviousSemantic != null) {						path.getNodes().add(previousSemantic);						previouspreviousSemantic.removeNext(selectedSemantic);			previouspreviousSemantic.addNext(previousSemantic);						previousSemantic.addPrevious(previouspreviousSemantic);			previousSemantic.addNext(selectedSemantic);						selectedSemantic.removePrevious(previouspreviousSemantic);			selectedSemantic.addPrevious(previousSemantic);						selectedVisual.setLocation(oldLocation);					previousVisual.setDiagram(diagram);			if (selectedVisual.getParent() != null)				previousVisual.setParent(selectedVisual.getParent());			selectedVisual.setDiagram(oldDiagram);			if(oldParent != null)				selectedVisual.setParent(oldParent);						ConnectionVisualModel previouspreviousConnection = getCorrectTargetConnection(selectedVisual.getTargetConnections(), previouspreviousSemantic);			previouspreviousConnection.setTarget(previousVisual);					previousConnection.setSource(previousVisual);			previousConnection.setTarget(selectedVisual);		} else {			previousSemantic.addNext(selectedSemantic);			path.getEndNodes().remove(previousSemantic);			path.getEndNodes().add(selectedSemantic);			path.getNodes().add(selectedSemantic);			selectedVisual.setDiagram(diagram);			previousConnection.setSource(previousVisual);			previousConnection.setTarget(selectedVisual);							if(oldParent != null)				selectedVisual.setParent(oldParent);		}
	}
}