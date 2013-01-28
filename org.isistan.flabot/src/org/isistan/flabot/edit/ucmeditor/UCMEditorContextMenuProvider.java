/**

import org.eclipse.gef.ContextMenuProvider;

	/** The editor's action registry. */
	private ActionRegistry actionRegistry;

	public UCMEditorContextMenuProvider(EditPartViewer viewer, ActionRegistry registry, UCMEditor editor) {
		super(viewer);
			throw new IllegalArgumentException();
		}
		this.editor=editor;
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
		
		action = getAction(InsertResponsibilityAction.INSERT_RESPONSIBILITY);
		if (action.isEnabled())
			menu.appendToGroup(GEFActionConstants.GROUP_REST, action);
		
//		action = getAction(RotateForkJoinAction.ROTATE_LEFT);
//		if (action.isEnabled()) {			
//			MenuManager subMenu = new MenuManager(Messages.getString("org.isistan.flabot.edit.ucmeditor.UCMEditorContextMenuProvider.rotateAction"));			 //$NON-NLS-1$
//			subMenu.add(action);
//			action = getAction(RotateForkJoinAction.ROTATE_RIGHT);
//			subMenu.add(action);
//			action = getAction(RotateForkJoinAction.ROTATE_UP);
//			subMenu.add(action);
//			action = getAction(RotateForkJoinAction.ROTATE_DOWN);
//			subMenu.add(action);
//			menu.appendToGroup(GEFActionConstants.GROUP_REST, subMenu);
//		}
		
		action = getAction(EditResponsibilityNodeAction.EDIT_RESPONSIBILITY);
		if (action.isEnabled())
			menu.appendToGroup(GEFActionConstants.GROUP_REST, action);
		
		action = getAction(EditVisualizationAction.EDIT_VISUALIZATION);
		if (action.isEnabled())
			menu.appendToGroup(GEFActionConstants.GROUP_REST, action);
		
		action = getAction(EditLineVisualizationAction.EDIT_LINE_VISUALIZATION);
		if (action.isEnabled())
			menu.appendToGroup(GEFActionConstants.GROUP_REST, action);

		InsertNodeAction actionInsert = (InsertNodeAction)getAction(InsertNodeAction.INSERT_NODE + InsertNodeCommand.AFTER);
		if (actionInsert.isEnabled()) {
			MenuManager subMenu = new MenuManager(Messages.getString("org.isistan.flabot.edit.ucmeditor.UCMEditorContextMenuProvider.insertNodeAction"));		 //$NON-NLS-1$
			if (actionInsert.canPerformActionEndAfter())
				subMenu.add(actionInsert);
			actionInsert = (InsertNodeAction)getAction(InsertNodeAction.INSERT_NODE  + InsertNodeCommand.BEFORE);
			if (actionInsert.canPerformActionStartBefore())
				subMenu.add(actionInsert);
			menu.appendToGroup(GEFActionConstants.GROUP_REST, subMenu);
		}

		action = getAction(InsertForkAction.INSERT_FORK + ForkNode.AND_FORK_TYPE + ForkNode.TWO_OUTPUTS);
		if (action.isEnabled()) {			
			MenuManager subMenu = new MenuManager(Messages.getString("org.isistan.flabot.edit.ucmeditor.UCMEditorContextMenuProvider.insertForkAction"));			 //$NON-NLS-1$
//			subMenu.add(action);
//			action = getAction(InsertForkAction.INSERT_FORK + ForkNode.OR_FORK_TYPE);
//			subMenu.add(action);
//			menu.appendToGroup(GEFActionConstants.GROUP_REST, subMenu);
		}		
		
//		action = getAction(InsertJoinAction.INSERT_JOIN + JoinNode.AND_JOIN_TYPE);
//		if (action.isEnabled()){			
//			MenuManager subMenu = new MenuManager(Messages.getString("org.isistan.flabot.edit.ucmeditor.UCMEditorContextMenuProvider.insertJoinAction"));			 //$NON-NLS-1$
//			subMenu.add(action);
//			action = getAction(InsertJoinAction.INSERT_JOIN + JoinNode.OR_JOIN_TYPE);
//			subMenu.add(action);
//			menu.appendToGroup(GEFActionConstants.GROUP_REST, subMenu);
//		}
		
		action = getAction(JoinPathsAction.JOIN_PATHS + JoinNode.AND_JOIN_TYPE);
		if (action.isEnabled()) {			
			MenuManager subMenu = new MenuManager(Messages.getString("org.isistan.flabot.edit.ucmeditor.UCMEditorContextMenuProvider.joinPathsAction")); //$NON-NLS-1$
		
		action = getAction(ArrangeAction.ARRANGE + ArrangeCommand.BRING_TO_FRONT);
		if (action.isEnabled()) {
			MenuManager subMenu = new MenuManager(Messages.getString("org.isistan.flabot.edit.ucmeditor.UCMEditorContextMenuProvider.arrangeAction"));			 //$NON-NLS-1$
			subMenu.add(action);
			action = getAction(ArrangeAction.ARRANGE  + ArrangeCommand.BRING_FORWARD);
			subMenu.add(action);
			action = getAction(ArrangeAction.ARRANGE  + ArrangeCommand.SEND_BACKWARD);
			subMenu.add(action);
			action = getAction(ArrangeAction.ARRANGE  + ArrangeCommand.SEND_TO_BACK);
			subMenu.add(action);
			menu.appendToGroup(GEFActionConstants.GROUP_REST, subMenu);
		}			
		action = getAction(RunFamilyManagerAction.RUN_FAMILY_MANAGER);
		
		action = getAction(RunConsistencyCheckAction.RUN_CONSISTENCY);
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
//		menu.appendToGroup(
//				GEFActionConstants.GROUP_REST,
//				getAction(ActionFactory.DELETE.getId()));
		
		//action = getAction(CloseDiagramAction.CLOSE_DIAGRAM);
		//if (action.isEnabled())
		//	menu.appendToGroup(GEFActionConstants.GROUP_FIND, action);

		IAction[] extensionActions=editor.getExtensionActions();
		

	private IAction getAction(String actionId) {
		return actionRegistry.getAction(actionId);
	}
}