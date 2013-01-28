/**

import org.eclipse.gef.ContextMenuProvider;

/** The editor's action registry. */
private ActionRegistry actionRegistry;
	
/**
 * Instantiate a new menu context provider for the specified EditPartViewer 
 * and ActionRegistry.
 * @param viewer	the editor's graphical viewer
 * @param registry	the editor's action registry
 * @throws IllegalArgumentException if registry is <tt>null</tt>. 
 */
public ComponentEditorContextMenuProvider(EditPartViewer viewer, ActionRegistry registry, ComponentEditor editor) {
	super(viewer);
	if (registry == null) {
		throw new IllegalArgumentException();
	}
	actionRegistry = registry;
}

/**
 * Called when the context menu is about to show. Actions, 
 * whose state is enabled, will appear in the context menu.
 * @see org.eclipse.gef.ContextMenuProvider#buildContextMenu(org.eclipse.jface.action.IMenuManager)
 */
public void buildContextMenu(IMenuManager menu) {
	// Add standard action groups to the menu
	GEFActionConstants.addStandardActionGroups(menu);

	IAction action;
	action = getAction(EditResponsibilitiesAction.EDIT_RESPONSIBILITIES);
	if (action.isEnabled())
		menu.appendToGroup(GEFActionConstants.GROUP_REST, action);
	
	action = getAction(AssignResponsibilitiesAction.ASSIGN_RESPONSIBILITIES);
	action = getAction(EditPropertiesAction.EDIT_PROPERTIES);
	if (action.isEnabled())
		menu.appendToGroup(GEFActionConstants.GROUP_REST, action);
	action = getAction(EditVisualizationAction.EDIT_VISUALIZATION);
	if (action.isEnabled())
		menu.appendToGroup(GEFActionConstants.GROUP_REST, action);

	action = getAction(EditStereotypesAction.EDIT_STEREOTYPES);
	
	action = getAction(ArrangeAction.ARRANGE + ArrangeCommand.BRING_TO_FRONT);
	if (action.isEnabled()) {
		MenuManager subMenu = new MenuManager(Messages.getString("org.isistan.flabot.edit.componenteditor.ComponentEditorContextMenuProvider.arrange")); //$NON-NLS-1$			
		subMenu.add(action);
		action = getAction(ArrangeAction.ARRANGE  + ArrangeCommand.BRING_FORWARD);
		subMenu.add(action);
		action = getAction(ArrangeAction.ARRANGE  + ArrangeCommand.SEND_BACKWARD);
		subMenu.add(action);
		action = getAction(ArrangeAction.ARRANGE  + ArrangeCommand.SEND_TO_BACK);
		subMenu.add(action);
		menu.appendToGroup(GEFActionConstants.GROUP_REST, subMenu);
	}
	
	action = getAction(RunConsistencyCheckAction.RUN_CONSISTENCY);
	if (action.isEnabled())
		menu.appendToGroup(GEFActionConstants.GROUP_REST, action);
	
	//Copy/Cut/Paste funcionality
	menu.appendToGroup(GEFActionConstants.GROUP_EDIT,
			getAction(ActionFactory.COPY.getId()));
	
	menu.appendToGroup(GEFActionConstants.GROUP_EDIT,
			getAction(ActionFactory.CUT.getId()));
	
	menu.appendToGroup(GEFActionConstants.GROUP_EDIT,
			getAction(ActionFactory.PASTE.getId()));
		
	//Snap geometry action	
	menu.appendToGroup(GEFActionConstants.GROUP_EDIT,
			getAction(GEFActionConstants.TOGGLE_SNAP_TO_GEOMETRY));
	
	// Add actions to the menu
	menu.appendToGroup(
			GEFActionConstants.GROUP_UNDO, // target group id
			getAction(ActionFactory.UNDO.getId())); // action to add
	menu.appendToGroup(
			GEFActionConstants.GROUP_UNDO, 
			getAction(ActionFactory.REDO.getId()));
	menu.appendToGroup(
			GEFActionConstants.GROUP_REST,
			getAction(ActionFactory.DELETE.getId()));
	
	//action = getAction(CloseDiagramAction.CLOSE_DIAGRAM);
	//if (action.isEnabled())
	//	menu.appendToGroup(GEFActionConstants.GROUP_FIND, action);

}

private IAction getAction(String actionId) {
	return actionRegistry.getAction(actionId);
}

}