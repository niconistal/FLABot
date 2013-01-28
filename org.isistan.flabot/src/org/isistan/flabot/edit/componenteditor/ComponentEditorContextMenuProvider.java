/** * $Id: ComponentEditorContextMenuProvider.java,v 1.30 2006/04/12 23:57:21 franco Exp $ * $Author: franco $ */package org.isistan.flabot.edit.componenteditor;

import org.eclipse.gef.ContextMenuProvider;import org.eclipse.gef.EditPartViewer;import org.eclipse.gef.ui.actions.ActionRegistry;import org.eclipse.gef.ui.actions.GEFActionConstants;import org.eclipse.jface.action.IAction;import org.eclipse.jface.action.IMenuManager;import org.eclipse.jface.action.MenuManager;import org.eclipse.ui.actions.ActionFactory;import org.isistan.flabot.edit.componenteditor.actions.AssignResponsibilitiesAction;import org.isistan.flabot.edit.componenteditor.actions.EditComponentAction;import org.isistan.flabot.edit.componenteditor.actions.EditPropertiesAction;import org.isistan.flabot.edit.componenteditor.actions.EditResponsibilitiesAction;import org.isistan.flabot.edit.componenteditor.actions.EditStereotypesAction;import org.isistan.flabot.edit.editor.actions.ArrangeAction;import org.isistan.flabot.edit.editor.actions.EditVisualizationAction;import org.isistan.flabot.edit.editor.actions.RunConsistencyCheckAction;import org.isistan.flabot.edit.editor.actions.RunEventManagerAction;import org.isistan.flabot.edit.editor.actions.RunFamilyManagerAction;import org.isistan.flabot.edit.editor.commands.ArrangeCommand;import org.isistan.flabot.messages.Messages;/** *  * @author $Author: franco $ * */public class ComponentEditorContextMenuProvider extends ContextMenuProvider {

/** The editor's action registry. */
private ActionRegistry actionRegistry;private ComponentEditor editor;
	
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
	actionRegistry = registry;	this.editor=editor;
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
		action = getAction(EditComponentAction.EDIT_COMPONENT);	if (action.isEnabled())		menu.appendToGroup(GEFActionConstants.GROUP_REST, action);
	action = getAction(AssignResponsibilitiesAction.ASSIGN_RESPONSIBILITIES);	if (action.isEnabled())		menu.appendToGroup(GEFActionConstants.GROUP_REST, action);	
	action = getAction(EditPropertiesAction.EDIT_PROPERTIES);
	if (action.isEnabled())
		menu.appendToGroup(GEFActionConstants.GROUP_REST, action);	
	action = getAction(EditVisualizationAction.EDIT_VISUALIZATION);
	if (action.isEnabled())
		menu.appendToGroup(GEFActionConstants.GROUP_REST, action);

	action = getAction(EditStereotypesAction.EDIT_STEREOTYPES);	if (action.isEnabled())		menu.appendToGroup(GEFActionConstants.GROUP_REST, action);		action = getAction(RunFamilyManagerAction.RUN_FAMILY_MANAGER);	if (action.isEnabled())		menu.appendToGroup(GEFActionConstants.GROUP_REST, action);		action = getAction(RunEventManagerAction.RUN_EVENT_MANAGER);	if (action.isEnabled())		menu.appendToGroup(GEFActionConstants.GROUP_REST, action);	
	
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
	IAction[] extensionActions=editor.getExtensionActions();	for(IAction extensionAction: extensionActions) {		if(extensionAction.isEnabled()) {			menu.appendToGroup(GEFActionConstants.GROUP_REST, extensionAction);		}	}
}

private IAction getAction(String actionId) {
	return actionRegistry.getAction(actionId);
}

}