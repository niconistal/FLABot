/** * $Id: UCMEditorContextMenuProvider.java,v 1.52 2006/04/12 23:57:21 franco Exp $ * $Author: franco $ */package org.isistan.flabot.edit.ucmeditor;

import org.eclipse.gef.ContextMenuProvider;import org.eclipse.gef.EditPartViewer;import org.eclipse.gef.ui.actions.ActionRegistry;import org.eclipse.gef.ui.actions.GEFActionConstants;import org.eclipse.jface.action.IAction;import org.eclipse.jface.action.IMenuManager;import org.eclipse.jface.action.MenuManager;import org.eclipse.ui.actions.ActionFactory;import org.isistan.flabot.coremodel.ForkNode;import org.isistan.flabot.coremodel.JoinNode;import org.isistan.flabot.coremodel.TimerNode;import org.isistan.flabot.edit.editor.actions.ArrangeAction;import org.isistan.flabot.edit.editor.actions.EditVisualizationAction;import org.isistan.flabot.edit.editor.actions.RunConsistencyCheckAction;import org.isistan.flabot.edit.editor.actions.RunEventManagerAction;import org.isistan.flabot.edit.editor.actions.RunFamilyManagerAction;import org.isistan.flabot.edit.editor.commands.ArrangeCommand;import org.isistan.flabot.edit.ucmeditor.actions.EditComponentAction;import org.isistan.flabot.edit.ucmeditor.actions.EditDynamicStubAction;import org.isistan.flabot.edit.ucmeditor.actions.EditLineVisualizationAction;import org.isistan.flabot.edit.ucmeditor.actions.EditOrForkAction;import org.isistan.flabot.edit.ucmeditor.actions.EditResponsibilityNodeAction;import org.isistan.flabot.edit.ucmeditor.actions.EditStubAction;import org.isistan.flabot.edit.ucmeditor.actions.EditTimerAction;import org.isistan.flabot.edit.ucmeditor.actions.InsertDirectionArrowAction;import org.isistan.flabot.edit.ucmeditor.actions.InsertDynamicStubAction;import org.isistan.flabot.edit.ucmeditor.actions.InsertForkAction;import org.isistan.flabot.edit.ucmeditor.actions.InsertJoinAction;import org.isistan.flabot.edit.ucmeditor.actions.InsertNodeAction;import org.isistan.flabot.edit.ucmeditor.actions.InsertResponsibilityAction;import org.isistan.flabot.edit.ucmeditor.actions.InsertStubAction;import org.isistan.flabot.edit.ucmeditor.actions.InsertTimerAction;import org.isistan.flabot.edit.ucmeditor.actions.JoinPathsAction;import org.isistan.flabot.edit.ucmeditor.actions.MergePathsAction;import org.isistan.flabot.edit.ucmeditor.actions.RotateForkJoinAction;import org.isistan.flabot.edit.ucmeditor.actions.RotatePathNodeAction;import org.isistan.flabot.edit.ucmeditor.actions.ShowHideAllConditionDependeciesAction;import org.isistan.flabot.edit.ucmeditor.commands.visual.InsertNodeCommand;import org.isistan.flabot.messages.Messages;/** *  * @author $Author: franco $ * */public class UCMEditorContextMenuProvider extends ContextMenuProvider {	

	/** The editor's action registry. */
	private ActionRegistry actionRegistry;		/**	 * The editor 	 */	private UCMEditor editor;

	public UCMEditorContextMenuProvider(EditPartViewer viewer, ActionRegistry registry, UCMEditor editor) {
		super(viewer);		if (registry == null) {
			throw new IllegalArgumentException();
		}
		this.editor=editor;		actionRegistry = registry;
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
//		}				action = getAction(RotatePathNodeAction.ROTATE_LEFT);		if (action.isEnabled()) {						MenuManager subMenu = new MenuManager(Messages.getString("org.isistan.flabot.edit.ucmeditor.UCMEditorContextMenuProvider.rotateAction"));			 //$NON-NLS-1$			subMenu.add(action);			action = getAction(RotatePathNodeAction.ROTATE_RIGHT);			subMenu.add(action);			action = getAction(RotatePathNodeAction.ROTATE_UP);			subMenu.add(action);			action = getAction(RotatePathNodeAction.ROTATE_DOWN);			subMenu.add(action);			menu.appendToGroup(GEFActionConstants.GROUP_REST, subMenu);		}
		
		action = getAction(EditResponsibilityNodeAction.EDIT_RESPONSIBILITY);
		if (action.isEnabled())
			menu.appendToGroup(GEFActionConstants.GROUP_REST, action);				action = getAction(EditTimerAction.EDIT_TIMER);		if (action.isEnabled())			menu.appendToGroup(GEFActionConstants.GROUP_REST, action);
				action = getAction(EditComponentAction.EDIT_COMPONENT);		if (action.isEnabled())			menu.appendToGroup(GEFActionConstants.GROUP_REST, action);		
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
			MenuManager subMenu = new MenuManager(Messages.getString("org.isistan.flabot.edit.ucmeditor.UCMEditorContextMenuProvider.insertForkAction"));			 //$NON-NLS-1$			MenuManager sub_subMenu = new MenuManager(Messages.getString("org.isistan.flabot.edit.ucmeditor.actions.InsertForkAction.textAnd"));			 //$NON-NLS-1$			sub_subMenu.add(action);						action = getAction(InsertForkAction.INSERT_FORK + ForkNode.AND_FORK_TYPE + ForkNode.THREE_OUTPUTS);			sub_subMenu.add(action);						action = getAction(InsertForkAction.INSERT_FORK + ForkNode.AND_FORK_TYPE + ForkNode.FOUR_OUTPUTS);			sub_subMenu.add(action);						action = getAction(InsertForkAction.INSERT_FORK + ForkNode.AND_FORK_TYPE + ForkNode.FIVE_OUTPUTS);			sub_subMenu.add(action);			subMenu.add(sub_subMenu);						sub_subMenu = new MenuManager(Messages.getString("org.isistan.flabot.edit.ucmeditor.actions.InsertForkAction.textOr"));			 //$NON-NLS-1$						action = getAction(InsertForkAction.INSERT_FORK + ForkNode.OR_FORK_TYPE + ForkNode.TWO_OUTPUTS);			sub_subMenu.add(action);						action = getAction(InsertForkAction.INSERT_FORK + ForkNode.OR_FORK_TYPE + ForkNode.THREE_OUTPUTS);			sub_subMenu.add(action);						action = getAction(InsertForkAction.INSERT_FORK + ForkNode.OR_FORK_TYPE + ForkNode.FOUR_OUTPUTS);			sub_subMenu.add(action);						action = getAction(InsertForkAction.INSERT_FORK + ForkNode.OR_FORK_TYPE + ForkNode.FIVE_OUTPUTS);			sub_subMenu.add(action);			subMenu.add(sub_subMenu);						menu.appendToGroup(GEFActionConstants.GROUP_REST, subMenu);
//			subMenu.add(action);
//			action = getAction(InsertForkAction.INSERT_FORK + ForkNode.OR_FORK_TYPE);
//			subMenu.add(action);
//			menu.appendToGroup(GEFActionConstants.GROUP_REST, subMenu);
		}						action = getAction(InsertDirectionArrowAction.INSERT_DIRECTION_ARROW);		if (action.isEnabled()) {						menu.appendToGroup(GEFActionConstants.GROUP_REST, action);		}
		
//		action = getAction(InsertJoinAction.INSERT_JOIN + JoinNode.AND_JOIN_TYPE);
//		if (action.isEnabled()){			
//			MenuManager subMenu = new MenuManager(Messages.getString("org.isistan.flabot.edit.ucmeditor.UCMEditorContextMenuProvider.insertJoinAction"));			 //$NON-NLS-1$
//			subMenu.add(action);
//			action = getAction(InsertJoinAction.INSERT_JOIN + JoinNode.OR_JOIN_TYPE);
//			subMenu.add(action);
//			menu.appendToGroup(GEFActionConstants.GROUP_REST, subMenu);
//		}				action = getAction(InsertJoinAction.INSERT_JOIN + JoinNode.AND_JOIN_TYPE + JoinNode.TWO_INPUTS);		if (action.isEnabled()){						MenuManager subMenu = new MenuManager(Messages.getString("org.isistan.flabot.edit.ucmeditor.UCMEditorContextMenuProvider.insertJoinAction"));			 //$NON-NLS-1$			MenuManager sub_subMenu = new MenuManager(Messages.getString("org.isistan.flabot.edit.ucmeditor.actions.InsertJoinAction.textAnd"));			 //$NON-NLS-1$			sub_subMenu.add(action);						action = getAction(InsertJoinAction.INSERT_JOIN + JoinNode.AND_JOIN_TYPE + JoinNode.THREE_INPUTS);			sub_subMenu.add(action);						action = getAction(InsertJoinAction.INSERT_JOIN + JoinNode.AND_JOIN_TYPE + JoinNode.FOUR_INPUTS);			sub_subMenu.add(action);						action = getAction(InsertJoinAction.INSERT_JOIN + JoinNode.AND_JOIN_TYPE + JoinNode.FIVE_INPUTS);			sub_subMenu.add(action);			subMenu.add(sub_subMenu);						sub_subMenu = new MenuManager(Messages.getString("org.isistan.flabot.edit.ucmeditor.actions.InsertJoinAction.textOr"));			 //$NON-NLS-1$						action = getAction(InsertJoinAction.INSERT_JOIN + JoinNode.OR_JOIN_TYPE + JoinNode.TWO_INPUTS);			sub_subMenu.add(action);						action = getAction(InsertJoinAction.INSERT_JOIN + JoinNode.OR_JOIN_TYPE + JoinNode.THREE_INPUTS);			sub_subMenu.add(action);						action = getAction(InsertJoinAction.INSERT_JOIN + JoinNode.OR_JOIN_TYPE + JoinNode.FOUR_INPUTS);			sub_subMenu.add(action);						action = getAction(InsertJoinAction.INSERT_JOIN + JoinNode.OR_JOIN_TYPE + JoinNode.FIVE_INPUTS);			sub_subMenu.add(action);			subMenu.add(sub_subMenu);						menu.appendToGroup(GEFActionConstants.GROUP_REST, subMenu);		}				action = getAction(InsertTimerAction.INSERT_TIMER + TimerNode.TIMER_TYPE);		if (action.isEnabled()){						MenuManager subMenu = new MenuManager(Messages.getString("org.isistan.flabot.edit.ucmeditor.UCMEditorContextMenuProvider.insertTimerAction"));			 //$NON-NLS-1$			subMenu.add(action);			action = getAction(InsertTimerAction.INSERT_TIMER + TimerNode.WAITING_PLACE_TYPE);			subMenu.add(action);			menu.appendToGroup(GEFActionConstants.GROUP_REST, subMenu);		}
				action = getAction(InsertStubAction.INSERT_STUB);		if (action.isEnabled())			menu.appendToGroup(GEFActionConstants.GROUP_REST, action);				action = getAction(EditStubAction.EDIT_STUB);		if (action.isEnabled())			menu.appendToGroup(GEFActionConstants.GROUP_REST, action);				action = getAction(InsertDynamicStubAction.INSERT_DYNAMIC_STUB);		if (action.isEnabled())			menu.appendToGroup(GEFActionConstants.GROUP_REST, action);				action = getAction(EditDynamicStubAction.EDIT_DYNAMIC_STUB);		if (action.isEnabled())			menu.appendToGroup(GEFActionConstants.GROUP_REST, action);				action = getAction(EditOrForkAction.EDIT_OR_FORK);		if (action.isEnabled())			menu.appendToGroup(GEFActionConstants.GROUP_REST, action);		
		action = getAction(JoinPathsAction.JOIN_PATHS + JoinNode.AND_JOIN_TYPE);
		if (action.isEnabled()) {			
			MenuManager subMenu = new MenuManager(Messages.getString("org.isistan.flabot.edit.ucmeditor.UCMEditorContextMenuProvider.joinPathsAction")); //$NON-NLS-1$			subMenu.add(action);			action = getAction(JoinPathsAction.JOIN_PATHS + JoinNode.OR_JOIN_TYPE);			subMenu.add(action);			menu.appendToGroup(GEFActionConstants.GROUP_REST, subMenu);		}				action = getAction(MergePathsAction.MERGE_PATHS);		if (action.isEnabled()) {						menu.appendToGroup(GEFActionConstants.GROUP_REST, action);		}				
		
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
		action = getAction(RunFamilyManagerAction.RUN_FAMILY_MANAGER);		if (action.isEnabled())			menu.appendToGroup(GEFActionConstants.GROUP_REST, action);				action = getAction(RunEventManagerAction.RUN_EVENT_MANAGER);		if (action.isEnabled())			menu.appendToGroup(GEFActionConstants.GROUP_REST, action);
		
		action = getAction(RunConsistencyCheckAction.RUN_CONSISTENCY);		if (action.isEnabled())				menu.appendToGroup(GEFActionConstants.GROUP_REST, action);				//Copy/Cut/Paste funcionality
		menu.appendToGroup(GEFActionConstants.GROUP_EDIT,
				getAction(ActionFactory.COPY.getId()));
		
		menu.appendToGroup(GEFActionConstants.GROUP_EDIT,
				getAction(ActionFactory.CUT.getId()));
		
		menu.appendToGroup(GEFActionConstants.GROUP_EDIT,
				getAction(ActionFactory.PASTE.getId()));
		
		//Snap geometry action	
		menu.appendToGroup(GEFActionConstants.GROUP_EDIT,
				getAction(GEFActionConstants.TOGGLE_SNAP_TO_GEOMETRY));				menu.appendToGroup(GEFActionConstants.GROUP_EDIT,				getAction(ShowHideAllConditionDependeciesAction.SHOW_HIDE_VISUAL_DEPENDENCIES));
		
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

		IAction[] extensionActions=editor.getExtensionActions();		for(IAction extensionAction: extensionActions) {			if(extensionAction.isEnabled()) {				menu.appendToGroup(GEFActionConstants.GROUP_REST, extensionAction);			}		}
				menu.appendToGroup(				GEFActionConstants.GROUP_REST,				getAction(ActionFactory.DELETE.getId()));	}

	private IAction getAction(String actionId) {
		return actionRegistry.getAction(actionId);
	}
}