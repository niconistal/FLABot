/**
 * $Id: FlabotMultiPageContextMenuProvider.java,v 1.3 2005/11/10 00:34:31 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.multipage;

import org.eclipse.gef.ContextMenuProvider;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.ui.actions.ActionRegistry;
import org.eclipse.gef.ui.actions.GEFActionConstants;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.ui.actions.ActionFactory;
import org.isistan.flabot.edit.editor.actions.AddNewFolderAction;

/**
 * @author $Author: franco $
 *
 */
public class FlabotMultiPageContextMenuProvider extends ContextMenuProvider {

	/** The editor's action registry. */
	private ActionRegistry actionRegistry;
		
	/**
	 * Instantiate a new menu context provider for the specified EditPartViewer 
	 * and ActionRegistry.
	 * @param viewer	the editor's graphical viewer
	 * @param registry	the editor's action registry
	 * @throws IllegalArgumentException if registry is <tt>null</tt>. 
	 */
	public FlabotMultiPageContextMenuProvider(EditPartViewer viewer, ActionRegistry registry) {
		super(viewer);
		if (registry == null) {
			throw new IllegalArgumentException();
		}
		this.actionRegistry = registry;
	}

	/**
	 * Called when the context menu is about to show. Actions, 
	 * whose state is enabled, will appear in the context menu.
	 * @see org.eclipse.gef.ContextMenuProvider#buildContextMenu(org.eclipse.jface.action.IMenuManager)
	 */
	public void buildContextMenu(IMenuManager menu) {
		// Add standard action groups to the menu
		GEFActionConstants.addStandardActionGroups(menu);
		
		IAction action = getAction(AddNewFolderAction.ADD_FOLDER);
		if (action.isEnabled())
			menu.appendToGroup(GEFActionConstants.GROUP_REST, action);
		
		action = getAction(ActionFactory.DELETE.getId());
		if (action.isEnabled())
			menu.appendToGroup(GEFActionConstants.GROUP_REST, action);	
	}

	private IAction getAction(String actionId) {
		return actionRegistry.getAction(actionId);
	}
}