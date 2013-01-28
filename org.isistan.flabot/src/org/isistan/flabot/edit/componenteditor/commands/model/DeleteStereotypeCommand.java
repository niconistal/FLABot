/**

import java.util.ArrayList;
 * DeleteStereotypeCommand
 * -	Removes a stereotype from the core model�s list of stereotypes.
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