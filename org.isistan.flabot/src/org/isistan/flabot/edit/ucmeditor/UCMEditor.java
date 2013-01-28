/**

import java.beans.PropertyChangeEvent;
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
		getSelectionActions().add(action.getId());
		
		action = new InsertJoinAction(this, JoinNode.AND_JOIN_TYPE, JoinNode.TWO_INPUTS);
		registry.registerAction(action);
		getSelectionActions().add(action.getId());
		
		action = new InsertJoinAction(this, JoinNode.OR_JOIN_TYPE, JoinNode.TWO_INPUTS);
		registry.registerAction(action);
		getSelectionActions().add(action.getId());
		
		action = new InsertResponsibilityAction(this);
		registry.registerAction(action);
		getSelectionActions().add(action.getId());
		
		action = new EditResponsibilityNodeAction(this);
		registry.registerAction(action);
		getSelectionActions().add(action.getId());
		
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
		getSelectionActions().add(action.getId());
		
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
		
		action = new JoinPathsAction(this, JoinNode.AND_JOIN_TYPE);
	
	@Override
	public boolean isSaveAsAllowed() {
		return false;
	}

	public void unsetDirty() {
		getCommandStack().markSaveLocation();
		this.firePropertyChange(PROP_DIRTY);
	}
}