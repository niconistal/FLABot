/**
 * $Id: DeleteMapCommand.java,v 1.2 2006/03/21 01:51:58 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.ucmeditor.commands.model;

import java.util.Iterator;
import java.util.List;

import org.eclipse.gef.commands.CompoundCommand;
import org.isistan.flabot.coremodel.ComponentRole;
import org.isistan.flabot.coremodel.Condition;
import org.isistan.flabot.coremodel.CoreModel;
import org.isistan.flabot.coremodel.Family;
import org.isistan.flabot.coremodel.FamilyElement;
import org.isistan.flabot.coremodel.Path;
import org.isistan.flabot.coremodel.Responsibility;
import org.isistan.flabot.coremodel.UseCaseMap;
import org.isistan.flabot.messages.Messages;

/**
 * @author $Author: franco $
 *
 */
public class DeleteMapCommand extends CompoundCommand {
	
	private UseCaseMap map;
	private CoreModel coreModel;
	
	public DeleteMapCommand(CoreModel coreModel, UseCaseMap map)  {
		this.coreModel = coreModel;
		this.map = map;
		setLabel(Messages.getString("org.isistan.flabot.edit.ucmeditor.commands.model.DeleteMapCommand.label")); //$NON-NLS-1$
	}
	
	public boolean canExecute() {
		return (coreModel != null);
	}
	
	public boolean canUndo() {
		return true;
	}
	
	private void checkConditions(Responsibility r, List conditions, boolean isPreCondition) {
		for (Iterator preIter= conditions.iterator(); preIter.hasNext(); ){
			Condition c = (Condition)preIter.next();
			if (c.getUseCaseMap() == map) {
				add(new DeleteConditionFromResponsibilityCommand(r, c, isPreCondition));
			}
		}
	}
	
	public void execute() {
		
		List roles = map.getComponentRoles();
		for (Iterator iter= roles.iterator(); iter.hasNext(); ){
			ComponentRole r = (ComponentRole)iter.next();
			add(new DeleteComponentRoleCommand(coreModel, r));
		}
		
		List paths = map.getPaths();
		for (Iterator iter= paths.iterator(); iter.hasNext(); ){
			Path p = (Path)iter.next();
			add(new DeletePathCommand(map, p));
		}
				
		List families = coreModel.getFamilies();
		for (Iterator iter= families.iterator(); iter.hasNext(); ){
			Family family = (Family)iter.next();
			if (family.getArchitecturalUseCaseMaps().contains(map) || 
					family.getFunctionalUseCaseMaps().contains(map))
				add (new DeleteFamilyCommand(coreModel, family));
			else {
				for (Iterator feIter= family.getFamilyElement().iterator(); feIter.hasNext(); ){
					FamilyElement fe = (FamilyElement)feIter.next();				
					if (fe.getUseCaseMap()== map)
						add(new DeleteFamilyElementCommand(family, fe));
				}
			}			
		}
		
		List responsibilites = coreModel.getResponsibilities();
		for (Iterator iter= responsibilites.iterator(); iter.hasNext(); ){
			Responsibility resp = (Responsibility)iter.next();
			checkConditions(resp, resp.getPreconditions(), true);
			checkConditions(resp, resp.getPostconditions(), false);
		}				
		super.execute();
		
		doDeleteMap();		
	}
	
	private void doDeleteMap() {
		coreModel.getUseCaseMaps().remove(map);
		
		if (map.getLevelInfo() == UseCaseMap.architecturalLevel)
			coreModel.getArchitecturalUseCaseMaps().remove(map);
		else
			coreModel.getFunctionalUseCaseMaps().remove(map);
	}
	
	private void undoDeleteMap() {
		coreModel.getUseCaseMaps().add(map);
		
		if (map.getLevelInfo() == UseCaseMap.architecturalLevel)
			coreModel.getArchitecturalUseCaseMaps().add(map);
		else
			coreModel.getFunctionalUseCaseMaps().add(map);
	}
	
	public void redo() {
		super.redo();
		doDeleteMap();	
	}
	
	public void undo() {		
		undoDeleteMap();
		super.undo();
	}
}