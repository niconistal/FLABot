/**
 * $Id: ModifyResponsibilityCommand.java,v 1.2 2006/03/21 01:51:58 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.componenteditor.commands.model;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gef.commands.Command;
import org.isistan.flabot.coremodel.Responsibility;
import org.isistan.flabot.messages.Messages;

/**
 * ModifyResponsibilityCommand
 * -	Modifies all the properties of a Responsibility (including its name, description, pre and post conditions).
 * -	The new properties are taken from another responsibility.
 * 
 * @author $Author: franco $
 *
 */
public class ModifyResponsibilityCommand extends Command {

	private Responsibility resp;
	private final Responsibility newResp;	
	private final Responsibility oldResp;
	
	/**
	 * Instantiates a command that modifies all the properties of a responsibility.
	 * A copy of the list of pre and post conditions is done.
	 * @param resp the responsibility to modify
	 * @param newResp the responsibility from where the new properties are taken  
	 */
	public ModifyResponsibilityCommand (Responsibility resp, Responsibility newResp) {
		this.resp = resp;
		this.newResp = newResp;
		this.oldResp = (Responsibility)EcoreUtil.copy(resp);
		setLabel(Messages.getString("org.isistan.flabot.edit.componenteditor.commands.ModifyResponsibilityCommand.label")); //$NON-NLS-1$
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
	 * The new properties are set in the responsibility (including its name, description, pre and post conditions).
	 */
	public void redo() {
		setValues(newResp);
	}
	
	@SuppressWarnings("deprecation") //$NON-NLS-1$
	private void setValues(Responsibility respCopy) {
		resp.setName(respCopy.getName());
		resp.setDescription(respCopy.getDescription());
		
		resp.getPostconditions().clear();
		resp.getPostconditions().addAll(respCopy.getPostconditions());
		
		resp.getPreconditions().clear();
		resp.getPreconditions().addAll(respCopy.getPreconditions());
		
		resp.getExtendedData().clear();
		resp.getExtendedData().putAll(respCopy.getExtendedData());
	}
	
	/**
	 * The old properties are restored in the responsibility (including its name, description, pre and post conditions).
	 */
	public void undo() {
		setValues(oldResp);
	}
}