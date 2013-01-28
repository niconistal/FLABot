/**

import java.util.ArrayList;
 * This action is used to copy elements from the component diagram 
 * 
 * @author $Author: franco $
 *
 */
public class CopyAction extends org.isistan.flabot.edit.editor.actions.CopyAction {

	
	
	
	
	/**
	 * Creates a new CopyAction in the given workbench part
	 * @param part
	 */
	public CopyAction(IWorkbenchPart part) {
		super(part);		
	}
	
	
	/**
	 * Determines whether the action should be enabled or not.
	 * @return true if selection consists of only ports, only interfaces or only components and notes, false otherwise
	 */
	@Override
	protected boolean calculateEnabled() {
		return canPerformAction();
	}

	/**
	 * Determines whether the action should be enabled or not.
	 * @return true if selection consists of only ports, only interfaces or only components and notes, false otherwise
	 */
	private boolean canPerformAction() {			
		List selection = getSelectedObjects();		
		
		if (selection == null ||
				selection.isEmpty()) return false;
				
		checkSelection(getSelectedObjects());
		
		if (ports > 0 && interfaces == 0 && components == 0 && notes == 0 && connections.size() == 0)
			return true;
		
		if (interfaces > 0 && ports == 0 && components == 0 && notes == 0 && connections.size() == 0)
			return true;
		
		if (interfaces == 0 && ports == 0 && (components > 0 || notes > 0))
			return true;
	
		return false;
	}

	/**
	 * Count the number of selected edit parts of each kind
	 * @param parts
	 */
	private void checkSelection(List parts) {
		connections = new ArrayList();
		ports = 0;
		interfaces = 0;
		components = 0;
		notes = 0;
		
		for (int i=0; i<parts.size(); i++) {
			if (parts.get(i) instanceof PortEditPart)
				ports++;
			if (parts.get(i) instanceof InterfaceEditPart)
				interfaces++;
			if (parts.get(i) instanceof ComponentEditPart)
				components++;
			if (parts.get(i) instanceof NoteEditPart)
				notes++;
			if (parts.get(i) instanceof AbstractConnectionEditPart)
				connections.add(parts.get(i));
		}
	}
}