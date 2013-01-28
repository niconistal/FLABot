/**
 * $Id: EditVisualizationPathCommand.java,v 1.3 2006/03/21 01:51:55 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.ucmeditor.commands.visual;

import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.gef.commands.Command;
import org.eclipse.swt.graphics.RGB;
import org.isistan.flabot.coremodel.Condition;
import org.isistan.flabot.coremodel.Note;
import org.isistan.flabot.coremodel.SimplePathNode;
import org.isistan.flabot.edit.editormodel.ConnectionVisualModel;
import org.isistan.flabot.edit.editormodel.NodeVisualModel;
import org.isistan.flabot.edit.editormodel.Util;
import org.isistan.flabot.messages.Messages;

/**
 * EditVisualizationPathCommand
 * -	Changes the visual properties of a visual model representing a path in a ucm. This properties include foreground color, backfground color, line style and line width.
 * -	Updates the color of all the nodes in the path except Responsibility/Fork/Join nodes.
 * 
 * @author $Author: franco $
 *
 */
public class EditVisualizationPathCommand extends Command {
	
	private final NodeVisualModel visualStart;
	private RGB newbC;
	private RGB newfC;
	private int newlS;
	private int newlW;
	private RGB oldbC;
	private RGB oldfC;
	private int oldlS;
	private int oldlW;
	
	/**
	 * Instantiates a command that can change the visual properties of a visual model representing a path in a ucm.
	 * @param visual the visual model to change
	 * @param bC the new background color
	 * @param fC the new foregound color
	 * @param lS the new line style
	 * @param lW the new line width
	 */
	public EditVisualizationPathCommand(NodeVisualModel visualStart, RGB bC, RGB fC, int lS, int lW)  {
		this.visualStart = visualStart;
		newbC = bC;
		newfC = fC;
		newlS = lS;
		newlW = lW;
		oldbC = Util.getSWTRGB(visualStart.getBackgroundColor());
		oldfC = Util.getSWTRGB(visualStart.getForegroundColor());
		oldlS = visualStart.getLineStyle();		
		oldlW = visualStart.getLineWidth();
		setLabel(Messages.getString("org.isistan.flabot.edit.ucmeditor.commands.visual.EditVisualizationPathCommand.label")); //$NON-NLS-1$
	}	
		
	/**
	 * Executes the Command. This method should not be called if the Command is not
	 * executable.
	 * 
	 *  @see redo()
	 */
	public void execute() {		
		redo();
	}
	
	/**
	 * Sets the new visual properties (background color, foreground color, line style and line width), and updates all the nodes in the path.
	 * The path paint algorithm takes the color, line style and width of the path from the first nodes of the path, so it is necessary to set this properties in the visual start nodes.
	 */
	public void redo() {
		BasicEList startsNodes = new BasicEList(); 
		getStartsNode(visualStart, startsNodes, new BasicEList());
		for (int i=0; i < startsNodes.size(); i++){
			NodeVisualModel node = (NodeVisualModel)startsNodes.get(i);
			node.setForegroundColor(Util.getColor(newfC));
			node.setLineStyle(newlS);
			node.setLineWidth(newlW);
		}
		updatePath(visualStart, newbC, newfC, new BasicEList());
	}
	
	/**
	 * Sets the old visual properties (background color, foreground color, line style and line width), and updates all the nodes in the path.
	 */
	public void undo() {
		BasicEList startsNodes = new BasicEList(); 
		getStartsNode(visualStart, startsNodes, new BasicEList());
		for (int i=0; i < startsNodes.size(); i++){
			NodeVisualModel node = (NodeVisualModel)startsNodes.get(i);
			node.setForegroundColor(Util.getColor(oldfC));
			node.setLineStyle(oldlS);
			node.setLineWidth(oldlW);
		}
		updatePath(visualStart, oldbC, oldfC, new BasicEList());
	}
	
	/**
	 * Returns in list, a list of all visual start nodes of the path
	 * @param node the visual start node
	 * @param list the list in which will be returned all visual start nodes
	 * @param tempList the list of visited nodes
	 */	
	private void getStartsNode (NodeVisualModel node, BasicEList list, BasicEList tempList){
		if (!tempList.contains(node)){
			tempList.add(node);
			if ((node.getSemanticModel() instanceof SimplePathNode && (((SimplePathNode)node.getSemanticModel()).isStart())))
				list.add(node);
			if (node.getTargetConnections().size() > 0) {
					List connections = node.getTargetConnections();
					for (int i=0; i<connections.size(); i++) {
						ConnectionVisualModel c = (ConnectionVisualModel)connections.get(i);
						if (c.getSemanticModel() instanceof Condition ||c.getSemanticModel() instanceof Note)
							continue;
						getStartsNode(c.getSource(),list,tempList);
					}
				}
			if (node.getSourceConnections().size() > 0) {
					List connections = node.getSourceConnections();
					for (int i=0; i<connections.size(); i++) {
						ConnectionVisualModel c = (ConnectionVisualModel)connections.get(i);
						if (c.getSemanticModel() instanceof Condition ||c.getSemanticModel() instanceof Note)
							continue;
						getStartsNode(c.getTarget(),list,tempList);
					}
				}
		}
	}
	
	/**
	 * Updates all the nodes in the path with the new backgorund and foregound color.
	 * @param node the visual start node
	 * @param bc the new background color
	 * @param fc the new foreground color
 	 * @param tempList the list of visited nodes
	 */
	private void updatePath (NodeVisualModel node, RGB bc, RGB fc, BasicEList tempList){
		if (!tempList.contains(node)){
			tempList.add(node);
			node.setForegroundColor(Util.getColor(fc));
			if (node.getTargetConnections().size() > 0) {
					List connections = node.getTargetConnections();
					for (int i=0; i<connections.size(); i++) {
						ConnectionVisualModel c = (ConnectionVisualModel)connections.get(i);
						if (c.getSemanticModel() instanceof Condition ||c.getSemanticModel() instanceof Note)
							continue;
						updatePath(c.getSource(),bc,fc,tempList);
					}
				}
			if (node.getSourceConnections().size() > 0) {
					List connections = node.getSourceConnections();
					for (int i=0; i<connections.size(); i++) {
						ConnectionVisualModel c = (ConnectionVisualModel)connections.get(i);
						if (c.getSemanticModel() instanceof Condition ||c.getSemanticModel() instanceof Note)
							continue;
						updatePath(c.getTarget(),bc,fc,tempList);
					}
				}
		}
	}
}