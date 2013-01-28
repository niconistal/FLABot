/**
 * $Id: CopyAction.java,v 1.9 2006/03/17 22:28:02 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.editor.actions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editparts.AbstractConnectionEditPart;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gef.ui.actions.Clipboard;
import org.eclipse.gef.ui.actions.SelectionAction;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.ActionFactory;
import org.isistan.flabot.edit.editor.FlabotGraphicalEditor;
import org.isistan.flabot.edit.editor.commands.paste.RetargetConnectionPasteCommand;
import org.isistan.flabot.edit.editor.commands.paste.RetargetParentPasteCommand;
import org.isistan.flabot.messages.Messages;

/**
 * This action is used as a common copy action for Flabot editors. 
 * 
 * @author $Author: franco $
 *
 */
public abstract class CopyAction  extends SelectionAction {

	private HashMap commands = new HashMap();	
	
	private List commandsList = new ArrayList();
	
	protected List connections = new ArrayList();
	
	/**
	 * Creates a new CopyAction in the given workbench part
	 * @param part
	 */
	public CopyAction(IWorkbenchPart part) {
		super(part);
	
		setId(ActionFactory.COPY.getId());
		setText(Messages.getString("org.isistan.flabot.edit.editor.actions.CopyAction.text")); //$NON-NLS-1$
		setToolTipText(Messages.getString("org.isistan.flabot.edit.editor.actions.CopyAction.toolTipText")); //$NON-NLS-1$
		ISharedImages sharedImages = PlatformUI.getWorkbench().getSharedImages(); 
		setImageDescriptor(sharedImages.getImageDescriptor(ISharedImages.IMG_TOOL_COPY));
		setDisabledImageDescriptor(sharedImages.getImageDescriptor(ISharedImages.IMG_TOOL_COPY_DISABLED));
		setEnabled(false);							
	}
	
	/**
	 * Copy the list of command into the Clipboard.
	 */
	public void run() {
		Clipboard.getDefault().setContents(getCopyCommandsList());
	}
	
	/**
	 * Returns the list of all commands to copy.
	 * Including source and target models, and connections between them.
	 * First are copied the source and target models and then its connections.
	 * 
	 * @return the list of commands
	 */
	protected List getCopyCommandsList() {
		commands = new HashMap();				

		//Source and target copy commands.
		commandsList = getInicialList();
		
		//The FlabotFileModel is added to the beginning of the list
		commandsList.add(0, ((FlabotGraphicalEditor)getWorkbenchPart()).getModel().getCoreModel().getFile());
		
		//Then the dependant copy commands are added.
		commandsList.addAll(getConnectionCommands());
		return commandsList;
	}
	
	/**
	 * Returns a list of all copy commands without its connections.
	 * First are copied the source and target models and then its connections.
	 * 
	 * @return the list of commands
	 */
	protected List getInicialList() {
		List ret = new ArrayList();
		List selection = getSelectedObjects();
		for (int i=0; i<selection.size(); i++) {
			EditPart part = (EditPart) selection.get(i);
			ChangeBoundsRequest r = new ChangeBoundsRequest();
			r.setEditParts(part);
			r.setType(RequestConstants.REQ_CLONE);
			
			Command c = part.getCommand(r);
			if (c != null) {
				processDependantCommands(c);
				ret.add(c);	
			}
		}
		return ret;
	}
	
	/**
	 * Returns a list of all connections copy commands.
	 * First are copied the source and target models and then its connections.
	 * 
	 * @return the list of commands
	 */
	private List getConnectionCommands() {
		List ret = new ArrayList();
		for (int i=0; i<connections.size(); i++) {
			AbstractConnectionEditPart part = (AbstractConnectionEditPart) connections.get(i);
			RetargetParentPasteCommand connectionCommand = (RetargetParentPasteCommand)commands.get(part.getModel());
			commandsList.remove(connectionCommand);
			
			Command scc = (Command)commands.get(part.getSource().getModel());
			Command tcc = (Command)commands.get(part.getTarget().getModel());
			
			if (scc != null && tcc != null && connectionCommand!= null) {
				ChangeBoundsRequest r = new ChangeBoundsRequest();
				r.setEditParts(part);
				r.setType(RequestConstants.REQ_CLONE);

				((RetargetConnectionPasteCommand)connectionCommand).setCommandSource((RetargetParentPasteCommand)scc);
				((RetargetConnectionPasteCommand)connectionCommand).setCommandTarget((RetargetParentPasteCommand)tcc);
				
				((RetargetParentPasteCommand)scc).addConnectionDependantCommand(true, (RetargetConnectionPasteCommand)connectionCommand);
				((RetargetParentPasteCommand)tcc).addConnectionDependantCommand(false, (RetargetConnectionPasteCommand)connectionCommand);				
				
				ret.add(connectionCommand);
			} 
		}
		return ret;
	}
	
	/**
	 * Processes all connections dependant commands.
	 * 
	 * @param c the command to analyse
	 */
	private void processDependantCommands(Command c) {
		RetargetParentPasteCommand pc = (RetargetParentPasteCommand) c;
		commands.put(pc.getCopyVisualModel(), c);		
		for(Iterator iter=pc.getDependantCommands().iterator(); iter.hasNext();)
			processDependantCommands((Command) iter.next());
	}
}