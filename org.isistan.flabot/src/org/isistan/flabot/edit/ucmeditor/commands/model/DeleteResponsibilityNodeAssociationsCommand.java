/**
 * $Id: DeleteResponsibilityNodeAssociationsCommand.java,v 1.2 2006/03/10 20:38:09 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.ucmeditor.commands.model;

import java.util.Iterator;
import java.util.List;

import org.eclipse.gef.commands.CompoundCommand;
import org.isistan.flabot.coremodel.Condition;
import org.isistan.flabot.coremodel.CoreModel;
import org.isistan.flabot.coremodel.Family;
import org.isistan.flabot.coremodel.Responsibility;
import org.isistan.flabot.coremodel.ResponsibilityNode;

/**
 * @author $Author: franco $
 *
 */
public class DeleteResponsibilityNodeAssociationsCommand extends CompoundCommand {

	private CoreModel coreModel;
	private ResponsibilityNode rn;
	
	public DeleteResponsibilityNodeAssociationsCommand(CoreModel coreModel, ResponsibilityNode rn) {
		this.coreModel = coreModel;
		this.rn = rn;
	}
	
	private void checkConditions(Responsibility r, List conditions, boolean isPreCondition) {
		for (Iterator preIter= conditions.iterator(); preIter.hasNext(); ){
			Condition c = (Condition)preIter.next();
			if (c.getDependencyResponsibility() == rn ||
					c.getSourceResponsibility() == rn) {
				add(new DeleteConditionFromResponsibilityCommand(r, c, isPreCondition));
			}
		}
	}
	
	public boolean canUndo() {
		return true;
	}
	
	public boolean canExecute() {
		return (coreModel != null);
	}
	
	public void execute() {
		List families = coreModel.getFamilies();
		for (Iterator iter= families.iterator(); iter.hasNext(); ){
			Family family = (Family)iter.next();						
			if (family.getAssociatedResponsibilities().contains(rn))
				add(new DeleteAssociatedNodeFromFamilyCommand(family, rn));
		}
		
		Responsibility responsibility = rn.getResponsibility();
		if (responsibility != null) {
			checkConditions(responsibility, responsibility.getPreconditions(), true);
			checkConditions(responsibility, responsibility.getPostconditions(), false);
		}
		
		List responsibilites = coreModel.getResponsibilities();
		for (Iterator iter= responsibilites.iterator(); iter.hasNext(); ){
			Responsibility resp = (Responsibility)iter.next();			
			checkConditions(resp, resp.getPreconditions(), true);
			checkConditions(resp, resp.getPostconditions(), false);
		}
		super.execute();	
	}	
	
	public void redo() {
		super.redo();
	}
	
	public void undo() {
		super.undo();
	}
}