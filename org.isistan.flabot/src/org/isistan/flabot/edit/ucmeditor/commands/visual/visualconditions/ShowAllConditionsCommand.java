/**
 * $Id: ShowAllConditionsCommand.java,v 1.1 2006/03/09 21:37:22 franco Exp $
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
 * A command that is used to show all responsibility condition dependencies in the UCM diagram.
 * 
 * @author $Author: franco $
 *
 */
public class ShowAllConditionsCommand extends ShowHideAllConditionsCommand {
		
	/**
	 * Create a new command that will show all the responsibility condition dependencies
	 * @param visualResponsibilityNode the visual responsibility node
	 */
	public ShowAllConditionsCommand(FlabotFileModel ffm, NodeVisualModel visualResponsibilityNode) {
		super(ffm, visualResponsibilityNode);
	}
	
	/**
	 * Executes the command. Proceses the list of pre and post conditions of the responsibility node and adds the ShowConditionCommand for each one.
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
				add(new ShowConditionCommand(visualResponsibilityNode, c, (NodeVisualModel) getVisualForModel(diagram.getChildren(), c.getDependencyResponsibility()) ));
		}
	}
}