/**
 * $Id: ShowHideAllConditionsCommand.java,v 1.1 2006/03/09 21:37:22 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.ucmeditor.commands.visual.visualconditions;

import java.util.Iterator;
import java.util.List;

import org.eclipse.gef.commands.CompoundCommand;
import org.isistan.flabot.coremodel.UseCaseMap;
import org.isistan.flabot.edit.editormodel.Diagram;
import org.isistan.flabot.edit.editormodel.FlabotFileModel;
import org.isistan.flabot.edit.editormodel.NodeVisualModel;
import org.isistan.flabot.edit.editormodel.VisualModel;
import org.isistan.flabot.edit.ucmmodel.UCMDiagram;

/**
 * @author $Author: franco $
 *
 */
public class ShowHideAllConditionsCommand extends CompoundCommand {

	protected FlabotFileModel flabotFileModel;
	protected NodeVisualModel visualResponsibilityNode;
	
	/**
	 * Create a new command that will hide/show all the responsibility condition dependencies
	 * @param visualResponsibilityNode the visual responsibility node
	 */
	public ShowHideAllConditionsCommand(FlabotFileModel flabotFileModel, NodeVisualModel visualResponsibilityNode) {
		this.flabotFileModel = flabotFileModel;
		this.visualResponsibilityNode = visualResponsibilityNode;
	}
	
	/**
	 * Can execute if all the necessary information has been provided. 
	 */
	public boolean canExecute() {
		return (flabotFileModel!= null && visualResponsibilityNode != null && visualResponsibilityNode.getSemanticModel() != null);
	}
	
	public boolean canUndo() {
		return true;
	}
	
	/**
	 * Returns the correct UCM diagram that has associated the map in a flabot file model, otherwise returns null.
	 * 
	 * @param model the flabot file model
	 * @param map the use case map to look for
	 * @return the correct UCM diagram that has associated the map in the flabot file model, otherwise return null.
	 */
	protected Diagram getCorrectDiagram(FlabotFileModel model, UseCaseMap map) {
		for(Iterator iter=model.getDiagrams().iterator(); iter.hasNext();) {
			Diagram d = (Diagram) iter.next();
			if (d instanceof UCMDiagram) {
				if (((UCMDiagram)d).getMap() == map)
					return d;
			}
		}
		return null;
	}
	
	/**
	 * Resturns the visual model that has as its semantic model the parameter model.
	 * It is a recursive function that will look in all children's sons.
	 * 
	 * @param children the list of visual models
	 * @param model the model 
	 * @return the visual model that has as its semantic model the parameter model
	 */
	protected VisualModel getVisualForModel(List children, Object model) {
		VisualModel retVisual = null;
		for (Iterator iter=children.iterator(); iter.hasNext() && retVisual == null;) {
			VisualModel visual = (VisualModel) iter.next();
			if (visual.getSemanticModel() == model)
				retVisual = visual;
			else
				retVisual = getVisualForModel(visual.getChildren(), model);
		}		
		return retVisual;
	}
}