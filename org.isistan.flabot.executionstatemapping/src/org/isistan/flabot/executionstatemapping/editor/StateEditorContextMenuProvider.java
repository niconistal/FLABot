package org.isistan.flabot.executionstatemapping.editor;

import org.eclipse.gef.ContextMenuProvider;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.ui.actions.ActionRegistry;
import org.eclipse.gef.ui.actions.GEFActionConstants;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.ui.actions.ActionFactory;
import org.isistan.flabot.executionstatemapping.editor.actions.AssignMethodExecutionConditionAction;
import org.isistan.flabot.executionstatemapping.editor.actions.ChangeFinalStateValueAction;
import org.isistan.flabot.executionstatemapping.editor.actions.EditExecutionConditionAction;
import org.isistan.flabot.executionstatemapping.editor.actions.EditPreFiltersAction;
import org.isistan.flabot.executionstatemapping.editor.actions.EditVisualizationAction;
import org.isistan.flabot.executionstatemapping.editor.actions.NewGeneralExecutionConditionAction;
import org.isistan.flabot.executionstatemapping.editor.actions.NewMethodExecutionConditionAction;
import org.isistan.flabot.executionstatemapping.messages.Messages;

/**
 * Provides context menu actions for the ShapesEditor.
 *  
 */
class StateEditorContextMenuProvider extends ContextMenuProvider {

	/** The editor's action registry. */
	private ActionRegistry actionRegistry;

	/**
	 * Instantiate a new menu context provider for the specified EditPartViewer
	 * and ActionRegistry.
	 * 
	 * @param viewer
	 *            the editor's graphical viewer
	 * @param registry
	 *            the editor's action registry
	 * @throws IllegalArgumentException
	 *             if registry is <tt>null</tt>.
	 */
	public StateEditorContextMenuProvider(EditPartViewer viewer,
			ActionRegistry registry) {
		super(viewer);
		if (registry == null) {
			throw new IllegalArgumentException();
		}
		actionRegistry = registry;
	}

	/**
	 * Called when the context menu is about to show. Actions, whose state is
	 * enabled, will appear in the context menu.
	 * 
	 * @see org.eclipse.gef.ContextMenuProvider#buildContextMenu(org.eclipse.jface.action.IMenuManager)
	 */
	@Override
	public void buildContextMenu(IMenuManager menu) {
		// Add standard action groups to the menu
		GEFActionConstants.addStandardActionGroups(menu);

		IAction action = getAction(EditVisualizationAction.EDIT_VISUALIZATION);
		if (action.isEnabled())
			menu.appendToGroup(GEFActionConstants.GROUP_REST, action);
		
		action = getAction(ChangeFinalStateValueAction.CHANGE_FINAL_STATE_VALUE);
		if (action.isEnabled())
			menu.appendToGroup(GEFActionConstants.GROUP_REST, action);

		action = getAction(EditExecutionConditionAction.EDIT_EXECUTIONCONDITION);
		if (action.isEnabled())
			menu.appendToGroup(GEFActionConstants.GROUP_REST, action);
		
		
		action = getAction(AssignMethodExecutionConditionAction.ASSIGN_METHOD_EXECUTIONCONDITION);
		if (action.isEnabled()) {
			MenuManager subMenu = new MenuManager(Messages.getString("org.isistan.flabot.executionmapping.editor.StateEditorContextMenuProvider.changeExecutionCondition"));			 //$NON-NLS-1$
			subMenu.add(action);
			action = getAction(NewMethodExecutionConditionAction.NEW_METHOD_EXECUTIONCONDITION);
			subMenu.add(action);
			action = getAction(NewGeneralExecutionConditionAction.NEW_GENERAL_EXECUTIONCONDITION);
			subMenu.add(action);
			menu.appendToGroup(GEFActionConstants.GROUP_REST, subMenu);
		}
		
		action = getAction(EditPreFiltersAction.EDIT_PREFILTERS);
		if (action.isEnabled())
			menu.appendToGroup(GEFActionConstants.GROUP_REST, action);
		
		// Add actions to the menu
		menu.appendToGroup(GEFActionConstants.GROUP_UNDO, // target group id
				getAction(ActionFactory.UNDO.getId())); // action to add
		menu.appendToGroup(GEFActionConstants.GROUP_UNDO,
				getAction(ActionFactory.REDO.getId()));
		menu.appendToGroup(GEFActionConstants.GROUP_EDIT,
				getAction(ActionFactory.DELETE.getId()));
	}

	private IAction getAction(String actionId) {
		return actionRegistry.getAction(actionId);
	}
}
