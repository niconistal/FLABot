/**
 * $Id: DeleteFamilyCommand.java,v 1.3 2006/03/21 01:51:57 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.ucmeditor.commands.model;

import java.util.List;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.isistan.flabot.coremodel.Condition;
import org.isistan.flabot.coremodel.CoreModel;
import org.isistan.flabot.coremodel.Family;
import org.isistan.flabot.coremodel.Responsibility;
import org.isistan.flabot.coremodel.ResponsibilityNode;
import org.isistan.flabot.coremodel.SimplePathNode;
import org.isistan.flabot.coremodel.StubNode;
import org.isistan.flabot.messages.Messages;

/**
 * Deletes a family from Core Model and its dependecies.
 * 
 * @author $Author: franco $
 *
 */
public class DeleteFamilyCommand extends Command {
	
	private CompoundCommand removedDependencies = new CompoundCommand();  	
	
	private Family family;
	private CoreModel coreModel;
	
	public DeleteFamilyCommand(CoreModel coreModel, Family family)  {
		this.family = family;
		this.coreModel = coreModel;
		setLabel(Messages.getString("org.isistan.flabot.edit.ucmeditor.commands.model.DeleteFamilyCommand.label")); //$NON-NLS-1$
	}
	
	public boolean canExecute() {
		return (coreModel != null);
	}
	
	public void execute() {
		for (int i=0; i < family.getAssociatedResponsibilities().size(); i++){			
			SimplePathNode simplePathNode = (SimplePathNode) family.getAssociatedResponsibilities().get(i);
			if (simplePathNode instanceof ResponsibilityNode) {
				Responsibility responsibility =  ((ResponsibilityNode) simplePathNode).getResponsibility();; 
				List preConditions = responsibility.getPreconditions();
				for (int j=0; j < preConditions.size(); j++) {
					Condition condition = (Condition) preConditions.get(j); 
					if (condition.getFamily() == family)
						removedDependencies.add(new DeleteConditionFromResponsibilityCommand(responsibility, condition, true));
				}
			}
			
			if (simplePathNode instanceof StubNode) {
				removedDependencies.add(new DeleteStubFromCoreModelCommand(coreModel, (StubNode) simplePathNode));
			}
		}
		removedDependencies.execute();
		
		doDeleteFamily();
	//	redo();		
	}

	private void doDeleteFamily() {
		coreModel.getFamilies().remove(family);
	}
	
	private void undoDeleteFamily() {
		coreModel.getFamilies().add(family);
	}
		
	public void redo() {
		removedDependencies.redo();
		doDeleteFamily();	
	}
	
	public void undo() {
		undoDeleteFamily();
		removedDependencies.undo();
	}
}