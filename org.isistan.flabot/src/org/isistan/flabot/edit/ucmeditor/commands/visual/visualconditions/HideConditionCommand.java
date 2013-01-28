/**
 * $Id: HideConditionCommand.java,v 1.2 2006/03/21 01:51:58 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.ucmeditor.commands.visual.visualconditions;

import org.isistan.flabot.coremodel.Condition;
import org.isistan.flabot.coremodel.ResponsibilityNode;
import org.isistan.flabot.edit.editormodel.NodeVisualModel;
import org.isistan.flabot.messages.Messages;

/**
 * A command that is used to hide a responsibility condition dependency in the UCM diagram.
 * 
 * @author $Author: franco $
 *
 */
public class HideConditionCommand extends ShowHideConditionsCommand {
		
	/**
	 * Create a new command that will hide a responsibility condition dependency
	 * @param visualResponsibilityNode the visual responsibility node
	 * @param condition the condition dependency to hide
	 */
	public HideConditionCommand(NodeVisualModel visualResponsibilityNode, Condition condition, NodeVisualModel visualTargetResponsibilityNode) {
		super(visualResponsibilityNode, condition, visualTargetResponsibilityNode);
		setLabel(Messages.getString("org.isistan.flabot.edit.ucmeditor.commands.visual.visualconditions.HideConditionCommand.label")); //$NON-NLS-1$
	}
	
	/**
	 * Executes the command. It looks for the correct UCM diagram according to the condition diagram and if:
	 * 	 - It is the same diagram of the visual responsibility node: only a connection between this visual responsibility node and the visual responsibility node of the condition dependency responsibiliy is removed.
	 * 	 - It is a different diagram: two visual jump nodes must be removed from each diagram and the connections to the corresponding visual responsibilies nodes too.
	 */
	public void execute() {
		ResponsibilityNode rn = (ResponsibilityNode) visualResponsibilityNode.getSemanticModel();
		if (rn.getMap() == condition.getUseCaseMap()) {					
			connection = getNormalConnection(visualResponsibilityNode.getSourceConnections(), condition);
			if (connection != null)  {
				source = connection.getSource();
				target = connection.getTarget();
				oldCondition = condition;
			}					
		} else {
			visualJumpDiagram1 = visualResponsibilityNode.getDiagram();					
			connectionJump1 = getNormalConnection(visualResponsibilityNode.getSourceConnections(), condition);
			if (connectionJump1 != null) { 					
				source1 = connectionJump1.getSource();
				target1 = connectionJump1.getTarget();
				oldConditionJump1 = condition;
			}
			
			if (visualTargetResponsibilityNode != null) {
				visualJumpDiagram2 = visualTargetResponsibilityNode.getDiagram();	
				connectionJump2 = getNormalConnection(visualTargetResponsibilityNode.getTargetConnections(), condition);
				if (connectionJump2 != null) {
					source2 = connectionJump2.getSource();
					target2 = connectionJump2.getTarget();
					oldConditionJump2 = condition;
				}
			}			
		}
		
		redo();
	}
	
	/**
	 * @see hideConditions()
	 */
	public void redo() {
		hideConditions();
	}
	
	/**
	 * @see showConditions()
	 */
	public void undo() {
		showConditions();
	}	
}