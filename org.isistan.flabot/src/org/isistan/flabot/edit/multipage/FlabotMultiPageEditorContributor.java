/** * $Id: FlabotMultiPageEditorContributor.java,v 1.27 2006/04/12 04:27:32 franco Exp $ * $Author: franco $ */package org.isistan.flabot.edit.multipage;

import java.util.ArrayList;import java.util.List;import org.eclipse.gef.ui.actions.ActionRegistry;import org.eclipse.gef.ui.actions.GEFActionConstants;import org.eclipse.gef.ui.actions.RedoRetargetAction;import org.eclipse.gef.ui.actions.UndoRetargetAction;import org.eclipse.jface.action.IAction;import org.eclipse.jface.action.IToolBarManager;import org.eclipse.jface.action.Separator;import org.eclipse.ui.IActionBars;import org.eclipse.ui.IEditorPart;import org.eclipse.ui.actions.ActionFactory;import org.eclipse.ui.actions.LabelRetargetAction;import org.eclipse.ui.part.MultiPageEditorActionBarContributor;import org.isistan.flabot.edit.componenteditor.ComponentEditor;import org.isistan.flabot.edit.editor.actions.CreateComponentDiagramAction;import org.isistan.flabot.edit.editor.actions.CreateUCMDiagramAction;import org.isistan.flabot.edit.editor.actions.ExportDiagramAction;import org.isistan.flabot.edit.ucmeditor.UCMEditor;import org.isistan.flabot.messages.Messages;/**
 * Manages the installation/deinstallation of global actions for multi-page editors.
 * Responsible for the redirection of global actions to the active editor.
 * Multi-page contributor replaces the contributors for the individual editors in the multi-page editor.
 */
public class FlabotMultiPageEditorContributor extends MultiPageEditorActionBarContributor {
	public static final String SEPARATOR = "$separator"; //$NON-NLS-1$
		
	private IEditorPart activeEditorPart;
	protected List globalActions = new ArrayList();
	protected List toolbarActions = new ArrayList();
	//protected List menuActions = new ArrayList();
	
	/**
	 * Creates a multi-page contributor.
	 */
	public FlabotMultiPageEditorContributor() {
		super();
		
		globalActions.add(ActionFactory.PRINT.getId());
		
		globalActions.add(ActionFactory.COPY.getId());
		globalActions.add(ActionFactory.CUT.getId());
		globalActions.add(ActionFactory.PASTE.getId());
		
		globalActions.add(ActionFactory.SELECT_ALL.getId());		globalActions.add(ActionFactory.UNDO.getId());
		globalActions.add(ActionFactory.REDO.getId());
		globalActions.add(ActionFactory.DELETE.getId());
		//globalActions.add(CloseDiagramAction.CLOSE_DIAGRAM);
		
		globalActions.add(GEFActionConstants.ZOOM_IN);
		globalActions.add(GEFActionConstants.ZOOM_OUT);
		
		
		toolbarActions.add(GEFActionConstants.ZOOM_IN);
		toolbarActions.add(GEFActionConstants.ZOOM_OUT);
		toolbarActions.add(SEPARATOR);
		toolbarActions.add(ActionFactory.UNDO.getId());
		toolbarActions.add(ActionFactory.REDO.getId());
		toolbarActions.add(GEFActionConstants.TOGGLE_GRID_VISIBILITY);
		toolbarActions.add(SEPARATOR);
		toolbarActions.add(ExportDiagramAction.EXPORT_DIAGRAM);
		toolbarActions.add(SEPARATOR);
		//toolbarActions.add(CloseDiagramAction.CLOSE_DIAGRAM);		
	}
	
	public void setActivePage(IEditorPart part) {
		if (activeEditorPart == part)
			return;

		activeEditorPart = part;
		IActionBars actionBars = getActionBars();
		//if (activeEditorPart instanceof ComponentEditor || activeEditorPart instanceof UCMEditor) {
		if (! (activeEditorPart instanceof FlabotMultipagePropertiesEditor)) {			ActionRegistry registry;
			registry = (ActionRegistry) activeEditorPart.getAdapter(ActionRegistry.class);
			for (int i = 0; i < globalActions.size(); i++) {
				String id = (String) globalActions.get(i);
				actionBars.setGlobalActionHandler(id, registry.getAction(id));
			}
			actionBars.updateActionBars();
		} else {
			actionBars.clearGlobalActionHandlers();
			actionBars.updateActionBars();
		}
		
		/*IMenuManager menuMmanager = viewMenu.getMenuManager();
		for (int i = 0; i < menuActions.size(); i++) {
			String id = (String) menuActions.get(i);
			if (viewMenu.find(id) != null)
				viewMenu.remove(id);
		}
		if (activeEditorPart instanceof ComponentEditor || activeEditorPart instanceof UCMEditor) {
			ActionRegistry registry;
			registry = (ActionRegistry) activeEditorPart.getAdapter(ActionRegistry.class);
			for (int i = 0; i < menuActions.size(); i++) {
				String id = (String) menuActions.get(i);
				if (id == SEPARATOR) {
					viewMenu.add(new Separator());
					continue;
				}
				IAction a=registry.getAction(id);
				if(a!=null)
					viewMenu.add(a);
			}
		}*/
		
		IToolBarManager manager = actionBars.getToolBarManager();
		for (int i = 0; i < toolbarActions.size(); i++) {
			String id = (String) toolbarActions.get(i);
			if (manager.find(id) != null)
				manager.remove(id);
		}
		if (! (activeEditorPart instanceof FlabotMultipagePropertiesEditor)) {
			ActionRegistry registry;
			registry = (ActionRegistry) activeEditorPart.getAdapter(ActionRegistry.class);
			for (int i = 0; i < toolbarActions.size(); i++) {
				String id = (String) toolbarActions.get(i);
				if (id == SEPARATOR) {
					manager.add(new Separator());
					continue;
				}
				IAction a=registry.getAction(id);
				if(a!=null)
					manager.add(a);
			}
		}		
		manager.update(false);					
	}
	
	/*public void contributeToMenu(IMenuManager menuManager) {		
		super.contributeToMenu(menuManager);
		viewMenu = new MenuManager("View");
		viewMenu.add(new LabelRetargetAction(GEFActionConstants.TOGGLE_GRID_VISIBILITY, "Close Diagram",LabelRetargetAction.AS_PUSH_BUTTON));
		//viewMenu.add(getAction(GEFActionConstants.TOGGLE_GRID_VISIBILITY));
		//viewMenu.add(getAction(GEFActionConstants.TOGGLE_SNAP_TO_GEOMETRY));
		menuManager.insertAfter(IWorkbenchActionConstants.M_EDIT, viewMenu);
	}*/

	public void contributeToToolBar(IToolBarManager manager) {	
		manager.add(new CreateComponentDiagramAction(getPage()));
		manager.add(new CreateUCMDiagramAction(getPage()));
		manager.add(new Separator());
		
		//manager.add(new DeleteRetargetAction());
		manager.add(new UndoRetargetAction());
		manager.add(new RedoRetargetAction());
		
		//manager.add(new LabelRetargetAction(CloseDiagramAction.CLOSE_DIAGRAM, Messages.getString("org.isistan.flabot.edit.multipage.FlabotMultiPageEditorContributor.closeDiagramName"),LabelRetargetAction.AS_PUSH_BUTTON));		 //$NON-NLS-1$
		manager.add(new LabelRetargetAction(GEFActionConstants.TOGGLE_GRID_VISIBILITY, Messages.getString("org.isistan.flabot.edit.multipage.FlabotMultiPageEditorContributor.showGridName"),LabelRetargetAction.AS_UNSPECIFIED)); //$NON-NLS-1$
	
		//Export image action
		manager.add(new LabelRetargetAction(ExportDiagramAction.EXPORT_DIAGRAM, Messages.getString("org.isistan.flabot.edit.multipage.FlabotMultiPageEditorContributor.exportDiagramName"), LabelRetargetAction.AS_PUSH_BUTTON)); //$NON-NLS-1$
	}
}