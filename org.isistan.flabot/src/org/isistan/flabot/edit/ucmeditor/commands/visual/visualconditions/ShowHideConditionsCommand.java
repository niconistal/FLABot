/**
 * $Id: ShowHideConditionsCommand.java,v 1.1 2006/03/09 21:37:22 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.ucmeditor.commands.visual.visualconditions;

import java.util.Iterator;
import java.util.List;

import org.eclipse.gef.commands.Command;
import org.isistan.flabot.coremodel.Condition;
import org.isistan.flabot.edit.editormodel.ConnectionVisualModel;
import org.isistan.flabot.edit.editormodel.Diagram;
import org.isistan.flabot.edit.editormodel.NodeVisualModel;

/**
 * A command that is used to show/hide the responsibility condition dependencies in the UCM diagram. 
 * 
 * @author $Author: franco $
 *
 */
public abstract class ShowHideConditionsCommand extends Command {
	
	protected NodeVisualModel visualResponsibilityNode;
	protected NodeVisualModel visualTargetResponsibilityNode;
	protected Condition condition;		
	
	protected ConnectionVisualModel connection;
	protected Condition oldCondition;
	protected NodeVisualModel source;
	protected NodeVisualModel target;
	
	protected Diagram visualJumpDiagram1;
	protected Condition oldConditionJump1;
	protected ConnectionVisualModel connectionJump1;
	protected NodeVisualModel source1;
	protected NodeVisualModel target1;
	
	protected Diagram visualJumpDiagram2;
	protected Condition oldConditionJump2;
	protected ConnectionVisualModel connectionJump2;
	protected NodeVisualModel source2;
	protected NodeVisualModel target2;
	
	/**
	 * Create a new command that will show/hide the responsibility condition dependencies
	 * @param visualResponsibilityNode the visual responsibility node
	 * @param condition the condition dependency to show/hide
	 */
	public ShowHideConditionsCommand(NodeVisualModel visualResponsibilityNode, Condition condition, NodeVisualModel visualTargetResponsibilityNode) {
		this.visualTargetResponsibilityNode = visualTargetResponsibilityNode;
		this.visualResponsibilityNode = visualResponsibilityNode;
		this.condition = condition;
	}
	
	/**
	 * Can execute if all the necessary information has been provided. 
	 */
	public boolean canExecute() {
		return (visualResponsibilityNode != null && condition != null);
	}
	
	/**
	 * Returns the connection visual model that has as its semantic model the condition parameter.
	 * 
	 * @param connections the list of connections
	 * @param condition the condition to look for
	 * @return the connection visual model that has as its semantic model the condition parameter
	 */
	protected ConnectionVisualModel getNormalConnection(List connections, Condition condition) {
		for(Iterator iter=connections.iterator(); iter.hasNext();) {
			ConnectionVisualModel c = (ConnectionVisualModel) iter.next();
			if (c.getSemanticModel() == condition)
				return c;			
		}		
		return null;
	}
	
	protected void finishConnection(ConnectionVisualModel connection) {
		connection.setSource(null);
		connection.setTarget(null);
		connection.setSemanticModel(null);
	}
	
	/**
	 * Removes all the connections and visual jump node added, it is needed to hide the condition dependency
	 *
	 */
	protected void hideConditions() {
		if (connection != null)
			finishConnection(connection);
		else {
			if (connectionJump1 != null) {
				finishConnection(connectionJump1);
				visualJumpDiagram1.getChildren().remove(target1);
			}
			
			if (connectionJump2 != null) {
				finishConnection(connectionJump2);
				visualJumpDiagram2.getChildren().remove(source2);
			}
		}		
	}
	
	/**
	 * Adds all the connections and visual jump nodes needed to show the condition dependency
	 *
	 */
	protected void showConditions() {
		if (connection != null) {
			connection.setSource(source);
			connection.setTarget(target);
			connection.setSemanticModel(oldCondition);
		} else {
			if (connectionJump1 != null) {
				visualJumpDiagram1.getChildren().add(target1);
				connectionJump1.setSource(source1);
				connectionJump1.setTarget(target1);
				connectionJump1.setSemanticModel(oldConditionJump1);
			}
			
			if (connectionJump2 != null) {
				visualJumpDiagram2.getChildren().add(source2);
				connectionJump2.setSource(source2);
				connectionJump2.setTarget(target2);
				connectionJump2.setSemanticModel(oldConditionJump2);
			}
		}		
	}
	
}