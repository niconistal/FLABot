/**
 * $Id: ShowConditionCommand.java,v 1.2 2006/03/21 01:51:58 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.ucmeditor.commands.visual.visualconditions;

import org.eclipse.draw2d.ColorConstants;
import org.isistan.flabot.coremodel.Condition;
import org.isistan.flabot.coremodel.ResponsibilityNode;
import org.isistan.flabot.edit.editormodel.ConnectionVisualModel;
import org.isistan.flabot.edit.editormodel.Diagram;
import org.isistan.flabot.edit.editormodel.EditormodelFactory;
import org.isistan.flabot.edit.editormodel.NodeVisualModel;
import org.isistan.flabot.edit.editormodel.Util;
import org.isistan.flabot.edit.editormodel.VisualDiagramJump;
import org.isistan.flabot.edit.editormodel.VisualModel;
import org.isistan.flabot.edit.ucmeditor.editparts.DependencyToColorFactory;
import org.isistan.flabot.edit.ucmeditor.editparts.DependencyToLineStyleFactory;
import org.isistan.flabot.edit.ucmeditor.figures.VisualDiagramJumpFigure;
import org.isistan.flabot.messages.Messages;

/**
 * A command that is used to show a responsibility condition dependency in the UCM diagram.
 * 
 * @author $Author: franco $
 *
 */
public class ShowConditionCommand extends ShowHideConditionsCommand {
	
	/**
	 *  Create a new command that will show a responsibility condition dependency
	 * @param visualResponsibilityNode the visual responsibility node
	 * @param condition the condition dependency to show
	 */
	public ShowConditionCommand(NodeVisualModel visualResponsibilityNode, Condition condition, NodeVisualModel visualTargetResponsibilityNode) {
		super(visualResponsibilityNode, condition, visualTargetResponsibilityNode);
		setLabel(Messages.getString("org.isistan.flabot.edit.ucmeditor.commands.visual.visualconditions.ShowConditionCommand.label")); //$NON-NLS-1$
	}
	
	/**
	 * Executes the command. It looks for the correct UCM diagram according to the condition diagram and if:
	 * 	 - It is the same diagram of the visual responsibility node: only a connection between this visual responsibility node and the visual responsibility node of the condition dependency responsibiliy is done.
	 * 	 - It is a different diagram: two visual jump nodes must be added to each diagram and the connections to the corresponding visual responsibilies nodes.
	 */
	public void execute() {
		ResponsibilityNode rn = (ResponsibilityNode) visualResponsibilityNode.getSemanticModel();
		
		if (rn.getMap() == condition.getUseCaseMap()) {					
			if (getNormalConnection(visualResponsibilityNode.getSourceConnections(), condition) == null)  { 
				connection = createConnection(condition);
				source = visualResponsibilityNode;
				target = visualTargetResponsibilityNode;
				oldCondition = condition;
			} 
		} else {
			visualJumpDiagram1 = visualResponsibilityNode.getDiagram();				
			visualJumpDiagram2 = visualTargetResponsibilityNode.getDiagram();
			
			if (getNormalConnection(visualResponsibilityNode.getSourceConnections(), condition) == null) {	    				
				connectionJump1 = createConnection(condition);
				source1 = visualResponsibilityNode;
				target1 = createVisualDiagramJump(visualResponsibilityNode, visualTargetResponsibilityNode, visualJumpDiagram1, visualJumpDiagram2, true, (visualResponsibilityNode.getSourceConnections().size()  + visualResponsibilityNode.getTargetConnections().size() - 2) * 25);
				oldConditionJump1 = condition;
			}
			
			if (getNormalConnection(visualTargetResponsibilityNode.getTargetConnections(), condition) == null) {
				connectionJump2 = createConnection(condition);
				source2 = createVisualDiagramJump(visualTargetResponsibilityNode, visualResponsibilityNode, visualJumpDiagram2, visualJumpDiagram1, false, (visualTargetResponsibilityNode.getSourceConnections().size()  + visualTargetResponsibilityNode.getTargetConnections().size() - 2) * 25);
				target2 = visualTargetResponsibilityNode;
				oldConditionJump2 = condition;
	    	}					
		}
		
		redo();
	}
	
	/**
	 * Creates a connection visual model that will reprensent a connection between two visual responsibility node or a connection between visual responsibility node and a visual diagra jump node 
	 * 
	 * @param condition the condition
	 * @return the connection visual model
	 */
	private ConnectionVisualModel createConnection(Condition condition) {
		ConnectionVisualModel c = EditormodelFactory.eINSTANCE.createConnectionVisualModel();		
    	c.setSemanticModel(condition);
		c.setForegroundColor(Util.getColor(ColorConstants.black));
    	c.setLineStyle(4);
    	c.setLineWidth(2);
    	c.setLineStyle(DependencyToLineStyleFactory.getLineStyle(condition.getType()));
    	c.setForegroundColor(Util.getColor(DependencyToColorFactory.getColor(condition.getType())));
    	return c;
	}
	
	/**
	 * Creates a visual diagram jump node, used to show the condition dependencies between different UCM diagrams.
	 * 
	 * @param sourceVisual the source responsibility visual node
	 * @param targetVisual the target responsibility visual node
	 * @param sourceDiagram the source diagram
	 * @param targetDiagram the target diagram
	 * @param isTo true if it a source->target jump, false if it is a target->source jump 
	 * @param paralleloffset the offset in the
	 * @return a visual diagram jump node
	 */
	private VisualDiagramJump createVisualDiagramJump(NodeVisualModel sourceVisual, NodeVisualModel targetVisual, Diagram sourceDiagram, Diagram targetDiagram, boolean isTo, int paralleloffset) {
		VisualDiagramJump visualJump = EditormodelFactory.eINSTANCE.createVisualDiagramJump();
		visualJump.setSourceDiagram(sourceDiagram);
		visualJump.setTargetDiagram(targetDiagram);
		visualJump.setTargetVisualNode(targetVisual);
		visualJump.setTo(new Boolean(isTo));
		//Sets the size of the visual jump
		visualJump.setSize(Util.getDimension(VisualDiagramJumpFigure.defaultsize));
		//Sets the location of the visual jump
		org.isistan.flabot.edit.editormodel.Point ps = EditormodelFactory.eINSTANCE.createPoint();
		org.eclipse.draw2d.geometry.Point point = getMinimun(sourceVisual.getParent(), sourceVisual, 40, paralleloffset);
		ps.setX(point.x);
		ps.setY(point.y);
	
		visualJump.setLocation(ps);
		visualJump.setLineStyle(1);
		visualJump.setLineWidth(2);
		visualJump.setForegroundColor(Util.getColor(ColorConstants.black));
		return visualJump;
	}
	
	private org.eclipse.draw2d.geometry.Point getMinimun(VisualModel parent, NodeVisualModel child, int separationoffset, int paralleloffset) {		
		if (parent == null) 
			return new org.eclipse.draw2d.geometry.Point(child.getLocation().getX() + separationoffset, child.getLocation().getY() + paralleloffset);
			
		//horizontal left or right		
		int minHLeft = child.getLocation().getX();
		int minHRight = parent.getSize().getWidth() - child.getLocation().getX();
		
		org.eclipse.draw2d.geometry.Point retH; int minH;
		if (minHLeft < minHRight) {
			retH = new org.eclipse.draw2d.geometry.Point(parent.getLocation().getX() - separationoffset, parent.getLocation().getY() + child.getLocation().getY() + paralleloffset);
			minH = minHLeft; 
		} else {
			retH = new org.eclipse.draw2d.geometry.Point(parent.getLocation().getX() + parent.getSize().getWidth() + separationoffset, parent.getLocation().getY() + child.getLocation().getY() + paralleloffset);
			minH = minHRight;
		}
		
		//vertical up or down		
		int minVUp = child.getLocation().getY();
		int minVDown = parent.getSize().getHeight() - child.getLocation().getY();
		
		org.eclipse.draw2d.geometry.Point retV; int minV;
		if (minVUp < minVDown) {
			retV = new org.eclipse.draw2d.geometry.Point(parent.getLocation().getX() + child.getLocation().getX() + paralleloffset, parent.getLocation().getY() - separationoffset);
			minV = minVUp; 
		} else {
			retV = new org.eclipse.draw2d.geometry.Point(parent.getLocation().getX() + child.getLocation().getX() + paralleloffset, parent.getLocation().getY() + parent.getSize().getHeight() + separationoffset);
			minV = minVDown;
		}
		
		//the minimun
		if (minH < minV)
			return retH;
		else
			return retV;
	}
	
	/**
	 * @see showConditions()
	 */
	public void redo() {
		showConditions();
	}
	
	/**
	 * @see hideConditions()
	 */
	public void undo() {
		hideConditions();
	}
}