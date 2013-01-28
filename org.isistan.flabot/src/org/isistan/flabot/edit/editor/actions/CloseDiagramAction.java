/**
 * $Id: CloseDiagramAction.java,v 1.6 2006/03/17 22:28:02 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.editor.actions;

import org.eclipse.gef.ui.actions.SelectionAction;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IWorkbenchPart;
import org.isistan.flabot.FlabotPlugin;
import org.isistan.flabot.edit.multipage.FlabotMultiPageEditor;
import org.isistan.flabot.messages.Messages;

/**
 * This action is used to close an opened diagram from the FlabotMultiPageEditor.
 * 
 * @author $Author: franco $
 *
 */
public class CloseDiagramAction extends SelectionAction {
	
	/**
	 * Action id
	 */
	public static final String
		CLOSE_DIAGRAM = "Close.Diagram";  //$NON-NLS-1$
	
	/**
	 * Creates a new CloseDiagramAction in the given workbench part
	 * @param part
	 */
	public CloseDiagramAction(IWorkbenchPart part) {
		super(part);
		
		setText(Messages.getString("org.isistan.flabot.edit.editor.actions.CloseDiagramAction.text")); //$NON-NLS-1$
		setToolTipText(Messages.getString("org.isistan.flabot.edit.editor.actions.CloseDiagramAction.toolTipText")); //$NON-NLS-1$
		setId(CLOSE_DIAGRAM);
		setImageDescriptor(ImageDescriptor.createFromFile(FlabotPlugin.class, "icons/close.gif")); //$NON-NLS-1$
		setEnabled(false);							
	}

	/**
	 * Determines whether the action should be enabled or not.
	 * @return true
	 */
	@Override
	protected boolean calculateEnabled() {
		return canPerformAction();
	}

	/**
	 * Determines whether the action should be enabled or not.
	 * @return true
	 */
	private boolean canPerformAction() {	
		return true;
	}
	
	/**
	 * Closes the active open diagram of the FlabotMultiPageEditor.
	 */
	public void run() {
		FlabotMultiPageEditor editor = (FlabotMultiPageEditor)getWorkbenchPart().getSite().getPage().getActiveEditor();
		editor.closeActivePage();
	}
}