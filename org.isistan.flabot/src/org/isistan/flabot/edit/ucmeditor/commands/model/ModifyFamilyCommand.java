/**
 * $Id: ModifyFamilyCommand.java,v 1.4 2006/04/11 04:21:26 apersson Exp $
 * $Author: apersson $
 */
package org.isistan.flabot.edit.ucmeditor.commands.model;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gef.commands.Command;
import org.isistan.flabot.coremodel.Family;
import org.isistan.flabot.messages.Messages;

/**
 * ModifyFamilyCommand
 * -	Modifies all the properties of a Family (including its name, mappedResponsibilityNode, sourceResponsibilityNode,  and the lists architecturalUseCaseMaps, functionalUseCaseMaps, associatedResponsibilities and familyElements).
 * -	The new properties are taken from another family.
 * 
 * @author $Author: apersson $
 *
 */
public class ModifyFamilyCommand extends Command {

	private Family family;
	private final Family newFamily;	
	private final Family oldFamily;
	
	/**
	 * Instantiates a command that modifies all the properties of a family.
	 * @param family the family to modify
	 * @param newFamily the family from where the new properties are taken  
	 */
	public ModifyFamilyCommand (Family family, Family newFamily) {
		this.family = family;
		this.newFamily = newFamily;
		this.oldFamily = (Family)EcoreUtil.copy(family);
		setLabel(Messages.getString("org.isistan.flabot.edit.ucmeditor.commands.model.ModifyFamilyCommand.label")); //$NON-NLS-1$
	}

	/**
	 * Executes the Command. This method should not be called if the command is not
	 * executable.
	 * 
	 * @see redo()
	 */
	public void execute() {
		redo();		
	}
	
	/**
	 * The new properties are set in the family (including its name, mappedResponsibilityNode, sourceResponsibilityNode,  and the lists architecturalUseCaseMaps, functionalUseCaseMaps, associatedResponsibilities and familyElements).
	 */
	public void redo() {
		setValues(newFamily);
	}
	
	private void setValues(Family familyCopy) {
		family.setName(familyCopy.getName());
		
		family.getArchitecturalUseCaseMaps().clear();
		family.getArchitecturalUseCaseMaps().addAll(familyCopy.getArchitecturalUseCaseMaps());
		
		family.getFunctionalUseCaseMaps().clear();
		family.getFunctionalUseCaseMaps().addAll(familyCopy.getFunctionalUseCaseMaps());
		
		family.getAssociatedResponsibilities().clear();
		family.getAssociatedResponsibilities().addAll(familyCopy.getAssociatedResponsibilities());
				
		family.getFamilyElement().clear();
		family.getFamilyElement().addAll(familyCopy.getFamilyElement());
		
		family.getEvents().clear();
		family.getEvents().addAll(familyCopy.getEvents());
	}
	
	/**
	 * The old properties are restored in the family (including its name, mappedResponsibilityNode, sourceResponsibilityNode,  and the lists architecturalUseCaseMaps, functionalUseCaseMaps, associatedResponsibilities and familyElements).
	 */
	public void undo() {
		setValues(oldFamily);
	}
}