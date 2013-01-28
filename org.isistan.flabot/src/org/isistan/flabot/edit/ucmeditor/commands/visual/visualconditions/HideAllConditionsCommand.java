/**
 * $Id: HideAllConditionsCommand.java,v 1.1 2006/03/09 21:37:22 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.ucmeditor.commands.visual.visualconditions;

import java.util.Iterator;
import java.util.List;

import org.isistan.flabot.coremodel.Condition;
import org.isistan.flabot.coremodel.Responsibility;
import org.isistan.flabot.coremodel.ResponsibilityNode;
import org.isistan.flabot.edit.editormodel.Diagram;
import org.isistan.flabot.edit.editormodel.FlabotFileModel;
import org.isistan.flabot.edit.editormodel.NodeVisualModel;

/**
 * A command that is used to hide all responsibility condition dependencies in the UCM diagram.
 * 
 * @author $Author: franco $
 *
 */
public class HideAllConditionsCommand extends ShowHideAllConditionsCommand {
		
	/**
	 * Create a new command that will hide all the responsibility condition dependencies
	 * @param visualResponsibilityNode the visual responsibility node
	 */
	public HideAllConditionsCommand(FlabotFileModel flabotFileModel, NodeVisualModel visualResponsibilityNode) {
		super(flabotFileModel, visualResponsibilityNode);
	}
	
	/**
	 * Executes the command. Proceses the list of pre and post conditions of the responsibility node and adds the HideConditionCommand for each one.
	 */
	public void execute() {
		ResponsibilityNode rn = (ResponsibilityNode) visualResponsibilityNode.getSemanticModel();
		Responsibility responsibility = rn.getResponsibility();
		if (responsibility != null) {
			processConditionsHide(responsibility.getPreconditions());
			processConditionsHide(responsibility.getPostconditions());
		}		
		super.execute();		
	}
	
	private void processConditionsHide(List conditions) {
		for (Iterator iter=conditions.iterator(); iter.hasNext();) {
			Condition c = (Condition) iter.next();
			Diagram diagram = getCorrectDiagram(flabotFileModel, c.getDependencyResponsibility().getMap());
			if (diagram != null)						
				add(new HideConditionCommand(visualResponsibilityNode, c, (NodeVisualModel) getVisualForModel(diagram.getChildren(), c.getDependencyResponsibility()) ));
		}
	}
}