/** * $Id: UCMEditor.java,v 1.68 2006/04/12 23:57:21 franco Exp $ * $Author: franco $ */package org.isistan.flabot.edit.ucmeditor;

import java.beans.PropertyChangeEvent;import java.beans.PropertyChangeListener;import java.util.EventObject;import org.eclipse.core.runtime.IProgressMonitor;import org.eclipse.draw2d.ConnectionLayer;import org.eclipse.draw2d.ShortestPathConnectionRouter;import org.eclipse.gef.ContextMenuProvider;import org.eclipse.gef.GraphicalEditPart;import org.eclipse.gef.GraphicalViewer;import org.eclipse.gef.LayerConstants;import org.eclipse.gef.SnapToGeometry;import org.eclipse.gef.SnapToGrid;import org.eclipse.gef.dnd.TemplateTransferDragSourceListener;import org.eclipse.gef.dnd.TemplateTransferDropTargetListener;import org.eclipse.gef.editparts.ScalableFreeformRootEditPart;import org.eclipse.gef.palette.PaletteRoot;import org.eclipse.gef.requests.CreationFactory;import org.eclipse.gef.requests.SimpleFactory;import org.eclipse.gef.ui.actions.ActionRegistry;import org.eclipse.gef.ui.palette.PaletteViewer;import org.eclipse.gef.ui.palette.PaletteViewerProvider;import org.eclipse.gef.ui.palette.FlyoutPaletteComposite.FlyoutPreferences;import org.eclipse.gef.ui.parts.GraphicalViewerKeyHandler;import org.eclipse.jface.action.IAction;import org.eclipse.jface.util.TransferDropTargetListener;import org.eclipse.jface.viewers.ISelection;import org.eclipse.swt.events.SelectionEvent;import org.eclipse.swt.events.SelectionListener;import org.eclipse.ui.IEditorInput;import org.eclipse.ui.IEditorPart;import org.eclipse.ui.IWorkbenchPart;import org.isistan.flabot.ExtensionPointConstants;import org.isistan.flabot.coremodel.ForkNode;import org.isistan.flabot.coremodel.JoinNode;import org.isistan.flabot.coremodel.TimerNode;import org.isistan.flabot.edit.componenteditor.actions.EditResponsibilitiesAction;import org.isistan.flabot.edit.editor.ActionLoader;import org.isistan.flabot.edit.editor.FlabotGraphicalEditor;import org.isistan.flabot.edit.editor.actions.ArrangeAction;import org.isistan.flabot.edit.editor.actions.EditVisualizationAction;import org.isistan.flabot.edit.editor.actions.EditorSnapGeometryAction;import org.isistan.flabot.edit.editor.actions.EditorToggleGridAction;import org.isistan.flabot.edit.editor.actions.ExportDiagramAction;import org.isistan.flabot.edit.editor.actions.PasteAction;import org.isistan.flabot.edit.editor.actions.PrintDiagramAction;import org.isistan.flabot.edit.editor.actions.RunConsistencyCheckAction;import org.isistan.flabot.edit.editor.actions.RunEventManagerAction;import org.isistan.flabot.edit.editor.actions.RunFamilyManagerAction;import org.isistan.flabot.edit.editor.actions.SelectAllAction;import org.isistan.flabot.edit.editor.commands.ArrangeCommand;import org.isistan.flabot.edit.multipage.FlabotMultiPageEditor;import org.isistan.flabot.edit.multipage.UnsettableDirtyStateEditor;import org.isistan.flabot.edit.ucmeditor.actions.CopyAction;import org.isistan.flabot.edit.ucmeditor.actions.CutAction;import org.isistan.flabot.edit.ucmeditor.actions.EditComponentAction;import org.isistan.flabot.edit.ucmeditor.actions.EditDynamicStubAction;import org.isistan.flabot.edit.ucmeditor.actions.EditLineVisualizationAction;import org.isistan.flabot.edit.ucmeditor.actions.EditOrForkAction;import org.isistan.flabot.edit.ucmeditor.actions.EditResponsibilityNodeAction;import org.isistan.flabot.edit.ucmeditor.actions.EditStubAction;import org.isistan.flabot.edit.ucmeditor.actions.EditTimerAction;import org.isistan.flabot.edit.ucmeditor.actions.InsertDirectionArrowAction;import org.isistan.flabot.edit.ucmeditor.actions.InsertDynamicStubAction;import org.isistan.flabot.edit.ucmeditor.actions.InsertForkAction;import org.isistan.flabot.edit.ucmeditor.actions.InsertJoinAction;import org.isistan.flabot.edit.ucmeditor.actions.InsertNodeAction;import org.isistan.flabot.edit.ucmeditor.actions.InsertResponsibilityAction;import org.isistan.flabot.edit.ucmeditor.actions.InsertStubAction;import org.isistan.flabot.edit.ucmeditor.actions.InsertTimerAction;import org.isistan.flabot.edit.ucmeditor.actions.JoinPathsAction;import org.isistan.flabot.edit.ucmeditor.actions.MergePathsAction;import org.isistan.flabot.edit.ucmeditor.actions.RotateForkJoinAction;import org.isistan.flabot.edit.ucmeditor.actions.RotatePathNodeAction;import org.isistan.flabot.edit.ucmeditor.actions.ShowHideAllConditionDependeciesAction;import org.isistan.flabot.edit.ucmeditor.commands.visual.InsertNodeCommand;import org.isistan.flabot.edit.ucmeditor.editparts.UCMEditPartFactory;import org.isistan.flabot.edit.ucmeditor.figures.ThreeConnectionFigure;import org.isistan.flabot.util.problems.MessageAccumulator;import org.isistan.flabot.util.problems.log.LoggerMessageAccumulator;public class UCMEditor extends FlabotGraphicalEditor
		implements UnsettableDirtyStateEditor {
	
	public UCMEditor(FlabotMultiPageEditor parentEditor) {
		super(parentEditor);
	}

	/** Palette component, holding the tools and parts. */
	private static PaletteRoot PALETTE_MODEL;

	private IAction[] extensionActions;
	
	public void selectionChanged(IWorkbenchPart part, ISelection selection) {
		IEditorPart activeEditor = getSite().getPage().getActiveEditor();
		if (this.equals(activeEditor) || ((parentEditor != null) && parentEditor.equals(activeEditor) && parentEditor.getActiveEditor()==this))
			updateActions(getSelectionActions());
	}
	
	/**
	 * Configure the graphical viewer before it receives contents.
	 * <p>This is the place to choose an appropriate RootEditPart and EditPartFactory
	 * for your editor. The RootEditPart determines the behavior of the editor's "work-area".
	 * For example, GEF includes zoomable and scrollable root edit parts. The EditPartFactory
	 * maps model elements to edit parts (controllers).</p>
	 * @see org.eclipse.gef.ui.parts.GraphicalEditor#configureGraphicalViewer()
	 */
	protected void configureGraphicalViewer() {
		super.configureGraphicalViewer();
		
		GraphicalViewer viewer = getGraphicalViewer();
		viewer.setEditPartFactory(new UCMEditPartFactory());
		ScalableFreeformRootEditPart rootEditPart = new ScalableFreeformRootEditPart();
		viewer.setRootEditPart(rootEditPart);
		viewer.setKeyHandler(new GraphicalViewerKeyHandler(viewer));

		//Zoom Function
/*		ZoomManager manager = rootEditPart.getZoomManager();

		double[] zoomLevels = new double[] {
		  0.25,0.5,0.75,1.0,1.5,2.0,2.5
		};
		manager.setZoomLevels(zoomLevels);

		ArrayList zoomContributions = new ArrayList();
		zoomContributions.add(ZoomManager.FIT_ALL);
		zoomContributions.add(ZoomManager.FIT_HEIGHT);
		zoomContributions.add(ZoomManager.FIT_WIDTH);
		manager.setZoomLevelContributions(zoomContributions);

		IAction zoomIn = new ZoomInAction(manager);
		IAction zoomOut = new ZoomOutAction(manager);
		getActionRegistry().registerAction(zoomIn);
		getActionRegistry().registerAction(zoomOut);
		getSite().getKeyBindingService().registerAction(zoomIn);
		getSite().getKeyBindingService().registerAction(zoomOut);	*/
					
		// Grid properties
		getGraphicalViewer().setProperty(SnapToGeometry.PROPERTY_SNAP_ENABLED, getModel().getSnapToGeometryEnabled());
		
		// We keep grid visibility and enablement in sync
		getGraphicalViewer().setProperty(SnapToGrid.PROPERTY_GRID_ENABLED, getModel().getGridEnabled());
		getGraphicalViewer().setProperty(SnapToGrid.PROPERTY_GRID_VISIBLE, getModel().getGridEnabled());						

		getGraphicalViewer().addPropertyChangeListener( new PropertyChangeListener() {				
			public void propertyChange(PropertyChangeEvent event) {
				if (SnapToGrid.PROPERTY_GRID_VISIBLE.equals(event.getPropertyName()))
					getModel().setGridEnabled((Boolean)event.getNewValue());
				
				if (SnapToGeometry.PROPERTY_SNAP_ENABLED.equals(event.getPropertyName()))
					getModel().setSnapToGeometryEnabled((Boolean)event.getNewValue());
			}				
		});								
			
		// configure the context menu provider
		ContextMenuProvider cmProvider =
				new UCMEditorContextMenuProvider(viewer, getActionRegistry(), this);
		viewer.setContextMenu(cmProvider);
		getSite().registerContextMenu(cmProvider, viewer);
		
				
		// export, print and grid diagram actions (they're here because they
		// depend on the graphical viewer)
		IAction action = new ExportDiagramAction(getGraphicalViewer(), this);
		getActionRegistry().registerAction(action);
		getSelectionActions().add(action.getId());
		
		action = new PrintDiagramAction(getGraphicalViewer(), this);
		getActionRegistry().registerAction(action);
		getSelectionActions().add(action.getId());
		
		action = new EditorSnapGeometryAction(viewer);
		getActionRegistry().registerAction(action);
				
		action = new EditorToggleGridAction(viewer);
		getActionRegistry().registerAction(action);		
		//////////////////
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.gef.ui.parts.GraphicalEditor#commandStackChanged(java.util.EventObject)
	 */
	public void commandStackChanged(EventObject event) {
		firePropertyChange(IEditorPart.PROP_DIRTY);
		super.commandStackChanged(event);
	}
	/* (non-Javadoc)
	 * @see org.eclipse.gef.ui.parts.GraphicalEditorWithFlyoutPalette#createPaletteViewerProvider()
	 */
	protected PaletteViewerProvider createPaletteViewerProvider() {
		return new PaletteViewerProvider(getEditDomain()) {
			protected void configurePaletteViewer(PaletteViewer viewer) {
				super.configurePaletteViewer(viewer);
				// create a drag source listener for this palette viewer
				// together with an appropriate transfer drop target listener, this will enable
				// model element creation by dragging a CombinatedTemplateCreationEntries 
				// from the palette into the editor
				// @see UCMEditor#createTransferDropTargetListener()
				viewer.addDragSourceListener(new TemplateTransferDragSourceListener(viewer));
			}
		};
	}
	
	/**
	 * Create a transfer drop target listener. When using a CombinedTemplateCreationEntry
	 * tool in the palette, this will enable model element creation by dragging from the palette.
	 * @see #createPaletteViewerProvider()
	 */
	private TransferDropTargetListener createTransferDropTargetListener() {
		return new TemplateTransferDropTargetListener(getGraphicalViewer()) {
			protected CreationFactory getFactory(Object template) {
				return new SimpleFactory((Class) template);
			}
		};
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.gef.ui.parts.GraphicalEditorWithFlyoutPalette#getPalettePreferences()
	 */
	protected FlyoutPreferences getPalettePreferences() {
		return UCMEditorPaletteFactory.createPalettePreferences();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gef.ui.parts.GraphicalEditorWithFlyoutPalette#getPaletteRoot()
	 */
	protected PaletteRoot getPaletteRoot() {
		if (PALETTE_MODEL == null)
			PALETTE_MODEL = UCMEditorPaletteFactory.createPalette();
		return PALETTE_MODEL;
	}
	
	/**
	 * Set up the editor's inital content (after creation).
	 * @see org.eclipse.gef.ui.parts.GraphicalEditorWithFlyoutPalette#initializeGraphicalViewer()
	 */
	protected void initializeGraphicalViewer() {
		super.initializeGraphicalViewer();
		GraphicalViewer viewer = getGraphicalViewer();
		viewer.setContents(getModel()); // set the contents of this editor
		
		// add the ShortestPathConnectionRouter
		ScalableFreeformRootEditPart root = 
			(ScalableFreeformRootEditPart)viewer.getRootEditPart();
		ConnectionLayer connLayer =
			(ConnectionLayer)root.getLayer(LayerConstants.CONNECTION_LAYER);
		GraphicalEditPart contentEditPart = (GraphicalEditPart)root.getContents();
		ShortestPathConnectionRouter router = 
			new ShortestPathConnectionRouter(contentEditPart.getFigure());
		connLayer.setConnectionRouter(router);
		
		// listen for dropped parts
		viewer.addDropTargetListener(createTransferDropTargetListener());
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.ui.part.EditorPart#setInput(org.eclipse.ui.IEditorInput)
	 */
	protected void setInput(IEditorInput input) {
		super.setInput(input);
	}

	@Override
	public void doSave(IProgressMonitor monitor) {
		// do nothing
	}

	@Override
	public void doSaveAs() {
		// do nothing
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gef.ui.parts.GraphicalEditor#createActions()
	 */
	@Override
	protected void createActions() {
		super.createActions();
		ActionRegistry registry = getActionRegistry();
		IAction action;
				action = new SelectAllAction(this);		registry.registerAction(action);		
		action = new CopyAction(this);
		registry.registerAction(action);
		getSelectionActions().add(action.getId());
		
		action = new CutAction(this);
		registry.registerAction(action);
		getSelectionActions().add(action.getId());
		
		action = new PasteAction(this);
		registry.registerAction(action);
		getSelectionActions().add(action.getId());
		
		action = new InsertForkAction(this, ForkNode.AND_FORK_TYPE, ForkNode.TWO_OUTPUTS);
		registry.registerAction(action);
		getSelectionActions().add(action.getId());
		
		action = new InsertForkAction(this, ForkNode.OR_FORK_TYPE, ForkNode.TWO_OUTPUTS);
		registry.registerAction(action);
		getSelectionActions().add(action.getId());				action = new InsertForkAction(this, ForkNode.AND_FORK_TYPE, ForkNode.THREE_OUTPUTS);		registry.registerAction(action);		getSelectionActions().add(action.getId());				action = new InsertForkAction(this, ForkNode.OR_FORK_TYPE, ForkNode.THREE_OUTPUTS);		registry.registerAction(action);		getSelectionActions().add(action.getId());				action = new InsertForkAction(this, ForkNode.AND_FORK_TYPE, ForkNode.FOUR_OUTPUTS);		registry.registerAction(action);		getSelectionActions().add(action.getId());				action = new InsertForkAction(this, ForkNode.OR_FORK_TYPE, ForkNode.FOUR_OUTPUTS);		registry.registerAction(action);		getSelectionActions().add(action.getId());				action = new InsertForkAction(this, ForkNode.AND_FORK_TYPE, ForkNode.FIVE_OUTPUTS);		registry.registerAction(action);		getSelectionActions().add(action.getId());				action = new InsertForkAction(this, ForkNode.OR_FORK_TYPE, ForkNode.FIVE_OUTPUTS);		registry.registerAction(action);		getSelectionActions().add(action.getId());
		
		action = new InsertJoinAction(this, JoinNode.AND_JOIN_TYPE, JoinNode.TWO_INPUTS);
		registry.registerAction(action);
		getSelectionActions().add(action.getId());
		
		action = new InsertJoinAction(this, JoinNode.OR_JOIN_TYPE, JoinNode.TWO_INPUTS);
		registry.registerAction(action);
		getSelectionActions().add(action.getId());				action = new InsertJoinAction(this, JoinNode.AND_JOIN_TYPE, JoinNode.THREE_INPUTS);		registry.registerAction(action);		getSelectionActions().add(action.getId());				action = new InsertJoinAction(this, JoinNode.OR_JOIN_TYPE, JoinNode.THREE_INPUTS);		registry.registerAction(action);		getSelectionActions().add(action.getId());				action = new InsertJoinAction(this, JoinNode.AND_JOIN_TYPE, JoinNode.FOUR_INPUTS);		registry.registerAction(action);		getSelectionActions().add(action.getId());				action = new InsertJoinAction(this, JoinNode.OR_JOIN_TYPE, JoinNode.FOUR_INPUTS);		registry.registerAction(action);		getSelectionActions().add(action.getId());				action = new InsertJoinAction(this, JoinNode.AND_JOIN_TYPE, JoinNode.FIVE_INPUTS);		registry.registerAction(action);		getSelectionActions().add(action.getId());				action = new InsertJoinAction(this, JoinNode.OR_JOIN_TYPE, JoinNode.FIVE_INPUTS);		registry.registerAction(action);		getSelectionActions().add(action.getId());				action = new InsertTimerAction(this, TimerNode.TIMER_TYPE);		registry.registerAction(action);		getSelectionActions().add(action.getId());				action = new InsertTimerAction(this, TimerNode.WAITING_PLACE_TYPE);		registry.registerAction(action);		getSelectionActions().add(action.getId());				action = new InsertDirectionArrowAction(this);		registry.registerAction(action);		getSelectionActions().add(action.getId());
				action = new EditResponsibilitiesAction(this);		registry.registerAction(action);		getSelectionActions().add(action.getId());		
		action = new InsertResponsibilityAction(this);
		registry.registerAction(action);
		getSelectionActions().add(action.getId());
		
		action = new EditResponsibilityNodeAction(this);
		registry.registerAction(action);
		getSelectionActions().add(action.getId());				action = new EditTimerAction(this);		registry.registerAction(action);		getSelectionActions().add(action.getId());				action = new EditComponentAction(this);		registry.registerAction(action);		getSelectionActions().add(action.getId());
		
		action = new RotateForkJoinAction(this, ThreeConnectionFigure.LEFT);
		registry.registerAction(action);
		getSelectionActions().add(action.getId());
		
		action = new RotateForkJoinAction(this, ThreeConnectionFigure.RIGHT);
		registry.registerAction(action);
		getSelectionActions().add(action.getId());
		
		action = new RotateForkJoinAction(this, ThreeConnectionFigure.UP);
		registry.registerAction(action);
		getSelectionActions().add(action.getId());
		
		action = new RotateForkJoinAction(this, ThreeConnectionFigure.DOWN);
		registry.registerAction(action);
		getSelectionActions().add(action.getId());				action = new RotatePathNodeAction(this, ThreeConnectionFigure.LEFT);		registry.registerAction(action);		getSelectionActions().add(action.getId());				action = new RotatePathNodeAction(this, ThreeConnectionFigure.RIGHT);		registry.registerAction(action);		getSelectionActions().add(action.getId());				action = new RotatePathNodeAction(this, ThreeConnectionFigure.UP);		registry.registerAction(action);		getSelectionActions().add(action.getId());				action = new RotatePathNodeAction(this, ThreeConnectionFigure.DOWN);		registry.registerAction(action);		getSelectionActions().add(action.getId());
		
		//action = new CloseDiagramAction(this);
		//registry.registerAction(action);
		//getSelectionActions().add(action.getId());
		
		action = new EditVisualizationAction(this);
		registry.registerAction(action);
		getSelectionActions().add(action.getId());
		
		action = new EditLineVisualizationAction(this);
		registry.registerAction(action);
		getSelectionActions().add(action.getId());
		
		action = new InsertNodeAction(this, InsertNodeCommand.AFTER);
		registry.registerAction(action);
		getSelectionActions().add(action.getId());
		
		action = new InsertNodeAction(this, InsertNodeCommand.BEFORE);
		registry.registerAction(action);
		getSelectionActions().add(action.getId());
		
		action = new RunConsistencyCheckAction(this);
		registry.registerAction(action);
		getSelectionActions().add(action.getId());
		
		action = new ArrangeAction(this, ArrangeCommand.BRING_FORWARD);
		registry.registerAction(action);
		getSelectionActions().add(action.getId());
		
		action = new ArrangeAction(this, ArrangeCommand.BRING_TO_FRONT);
		registry.registerAction(action);
		getSelectionActions().add(action.getId());
		
		action = new ArrangeAction(this, ArrangeCommand.SEND_TO_BACK);
		registry.registerAction(action);
		getSelectionActions().add(action.getId());
		
		action = new ArrangeAction(this, ArrangeCommand.SEND_BACKWARD);
		registry.registerAction(action);
		getSelectionActions().add(action.getId());
		
		action = new JoinPathsAction(this, JoinNode.AND_JOIN_TYPE);		registry.registerAction(action);		getSelectionActions().add(action.getId());				action = new JoinPathsAction(this, JoinNode.OR_JOIN_TYPE);		registry.registerAction(action);		getSelectionActions().add(action.getId());				action = new MergePathsAction(this);		registry.registerAction(action);		getSelectionActions().add(action.getId());				action = new InsertStubAction(this);		registry.registerAction(action);		getSelectionActions().add(action.getId());				action = new EditStubAction(this);		registry.registerAction(action);		getSelectionActions().add(action.getId());				action = new InsertDynamicStubAction(this);		registry.registerAction(action);		getSelectionActions().add(action.getId());				action = new EditDynamicStubAction(this);		registry.registerAction(action);		getSelectionActions().add(action.getId());				action = new EditOrForkAction(this);		registry.registerAction(action);		getSelectionActions().add(action.getId());				action = new RunFamilyManagerAction(this);		registry.registerAction(action);		getSelectionActions().add(action.getId());				action = new RunEventManagerAction(this);		registry.registerAction(action);		getSelectionActions().add(action.getId());				action = new ShowHideAllConditionDependeciesAction(this);		registry.registerAction(action);		getSelectionActions().add(action.getId());						MessageAccumulator messageAccumulator=new LoggerMessageAccumulator();				extensionActions= ActionLoader.loadAllActions(				this, 				ExtensionPointConstants.UCM_EDITOR_CONTEXT_MENU_ACTION,				messageAccumulator			);				for (IAction extensionAction : extensionActions) {			registry.registerAction(extensionAction);			getSelectionActions().add(extensionAction.getId());		}			}			IAction[] getExtensionActions() {		return extensionActions;	}
	
	@Override
	public boolean isSaveAsAllowed() {
		return false;
	}

	public void unsetDirty() {		super.unsetDirty();
		getCommandStack().markSaveLocation();
		this.firePropertyChange(PROP_DIRTY);
	}
}