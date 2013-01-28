/** * $Id: DeleteStereotypeCommand.java,v 1.3 2006/03/21 01:51:58 franco Exp $ * $Author: franco $ */package org.isistan.flabot.edit.componenteditor.commands.model;

import java.util.ArrayList;import java.util.Iterator;import java.util.List;import org.eclipse.gef.commands.Command;import org.isistan.flabot.coremodel.CoreModel;import org.isistan.flabot.coremodel.Stereotype;import org.isistan.flabot.coremodel.StereotypedElementModel;import org.isistan.flabot.messages.Messages;/**
 * DeleteStereotypeCommand
 * -	Removes a stereotype from the core model’s list of stereotypes.
 * 
 * @author $Author: franco $
 *
 */
public class DeleteStereotypeCommand extends Command {

	private final CoreModel coreModel;
	private final Stereotype stereo;
	private List stereotypedElements;
	
	public DeleteStereotypeCommand(CoreModel coreModel, Stereotype stereo) {
		this.coreModel = coreModel;
		this.stereo = stereo;
		setLabel(Messages.getString("org.isistan.flabot.edit.componenteditor.commands.model.DeleteStereotypeCommand.label")); //$NON-NLS-1$
	}
	
	public void execute() {
		stereotypedElements = new ArrayList();
		for (Iterator iter = coreModel.getComponents().iterator(); iter.hasNext();){
			StereotypedElementModel s = (StereotypedElementModel) iter.next();
			if (s.getStereotype() == stereo)
				stereotypedElements.add(s);
		}
		
		for (Iterator iter = coreModel.getRelationships().iterator(); iter.hasNext();){
			StereotypedElementModel s = (StereotypedElementModel) iter.next();
			if (s.getStereotype() == stereo)
				stereotypedElements.add(s);
		}
		redo();		
	}
	
	public void redo() {
		coreModel.getStereotypes().remove(stereo);
		for (Iterator iter = stereotypedElements.iterator(); iter.hasNext();){
			StereotypedElementModel s = (StereotypedElementModel) iter.next();
			s.setStereotype(null);
		}
	}
	
	public void undo() {
		coreModel.getStereotypes().add(stereo);
		for (Iterator iter = stereotypedElements.iterator(); iter.hasNext();){
			StereotypedElementModel s = (StereotypedElementModel) iter.next();
			s.setStereotype(stereo);
		}
	}	
}