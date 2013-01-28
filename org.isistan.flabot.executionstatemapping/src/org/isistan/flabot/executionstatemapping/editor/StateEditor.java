package org.isistan.flabot.executionstatemapping.editor;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.draw2d.ConnectionLayer;
import org.eclipse.draw2d.ShortestPathConnectionRouter;
import org.eclipse.gef.ContextMenuProvider;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.gef.LayerConstants;
import org.eclipse.gef.SnapToGeometry;
import org.eclipse.gef.SnapToGrid;
import org.eclipse.gef.dnd.TemplateTransferDragSourceListener;
import org.eclipse.gef.dnd.TemplateTransferDropTargetListener;
import org.eclipse.gef.editparts.ScalableFreeformRootEditPart;
import org.eclipse.gef.editparts.ZoomManager;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.requests.CreationFactory;
import org.eclipse.gef.requests.SimpleFactory;
import org.eclipse.gef.ui.actions.ActionRegistry;
import org.eclipse.gef.ui.actions.ZoomInAction;
import org.eclipse.gef.ui.actions.ZoomOutAction;
import org.eclipse.gef.ui.palette.PaletteViewer;
import org.eclipse.gef.ui.palette.PaletteViewerProvider;
import org.eclipse.gef.ui.palette.FlyoutPaletteComposite.FlyoutPreferences;
import org.eclipse.gef.ui.parts.GraphicalViewerKeyHandler;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.util.TransferDropTargetListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPart;
import org.isistan.flabot.edit.editor.FlabotGraphicalEditor;
import org.isistan.flabot.edit.editor.actions.EditorSnapGeometryAction;
import org.isistan.flabot.edit.editor.actions.EditorToggleGridAction;
import org.isistan.flabot.edit.editor.actions.ExportDiagramAction;
import org.isistan.flabot.edit.editor.actions.PrintDiagramAction;
import org.isistan.flabot.edit.multipage.FlabotMultiPageEditor;
import org.isistan.flabot.executionstatemapping.editor.actions.AssignMethodExecutionConditionAction;
import org.isistan.flabot.executionstatemapping.editor.actions.ChangeFinalStateValueAction;
import org.isistan.flabot.executionstatemapping.editor.actions.EditExecutionConditionAction;
import org.isistan.flabot.executionstatemapping.editor.actions.EditPreFiltersAction;
import org.isistan.flabot.executionstatemapping.editor.actions.EditVisualizationAction;
import org.isistan.flabot.executionstatemapping.editor.actions.NewGeneralExecutionConditionAction;
import org.isistan.flabot.executionstatemapping.editor.actions.NewMethodExecutionConditionAction;
import org.isistan.flabot.executionstatemapping.editor.editparts.StateEditPartFactory;

public class StateEditor extends FlabotGraphicalEditor
{	
	/** Palette component, holding the tools and parts. */
	private static PaletteRoot PALETTE_MODEL;
	
	/** Create a new StateEditor instance. This is called by the Workspace. */
	public StateEditor(FlabotMultiPageEditor parentEditor) {
		super(parentEditor);
	}
	
	@Override
	public void selectionChanged(IWorkbenchPart part, ISelection selection) {
		IEditorPart activeEditor = getSite().getPage().getActiveEditor();
		if (this.equals(activeEditor) || ((parentEditor != null) && parentEditor.equals(activeEditor) && parentEditor.getActiveEditor()==this))			
			updateActions(getSelectionActions());
	}
	
	/**
	 * Configure the graphical viewer before it receives contents.
	 * <p>
	 * This is the place to choose an appropriate RootEditPart and
	 * EditPartFactory for your editor. The RootEditPart determines the behavior
	 * of the editor's "work-area". For example, GEF includes zoomable and
	 * scrollable root edit parts. The EditPartFactory maps model elements to
	 * edit parts (controllers).
	 * </p>
	 * 
	 * @see org.eclipse.gef.ui.parts.GraphicalEditor#configureGraphicalViewer()
	 */
	@Override
	protected void configureGraphicalViewer()
	{
		super.configureGraphicalViewer();

		GraphicalViewer viewer = getGraphicalViewer();
		viewer.setEditPartFactory(new StateEditPartFactory());
		ScalableFreeformRootEditPart rootEditPart = new ScalableFreeformRootEditPart();
		viewer.setRootEditPart(rootEditPart);
		viewer.setKeyHandler(new GraphicalViewerKeyHandler(viewer));

		// Zoom Function
		
		  ZoomManager manager = rootEditPart.getZoomManager();		  
		  double[] zoomLevels = new double[] { 0.25,0.5,0.75,1.0,1.5,2.0,2.5 };
		  manager.setZoomLevels(zoomLevels);
		  
		  List<String> zoomContributions = new ArrayList<String>();
		  zoomContributions.add(ZoomManager.FIT_ALL);
		  zoomContributions.add(ZoomManager.FIT_HEIGHT);
		  zoomContributions.add(ZoomManager.FIT_WIDTH);
		  manager.setZoomLevelContributions(zoomContributions);
		  
		  IAction zoomIn = new ZoomInAction(manager); 
		  IAction zoomOut = new ZoomOutAction(manager); 
		  getActionRegistry().registerAction(zoomIn);
		  getActionRegistry().registerAction(zoomOut);
		  getSite().getKeyBindingService().registerAction(zoomIn);
		
		  getGraphicalViewer().setProperty(SnapToGeometry.PROPERTY_SNAP_ENABLED,
		  getModel().getSnapToGeometryEnabled()); 
		  // We keep grid visibility and enablement in sync
		  getGraphicalViewer().setProperty(SnapToGrid.PROPERTY_GRID_ENABLED,
		  getModel().getGridEnabled());
		  getGraphicalViewer().setProperty(SnapToGrid.PROPERTY_GRID_VISIBLE,
		  getModel().getGridEnabled());
		  
		  getGraphicalViewer().addPropertyChangeListener( 
				  new  PropertyChangeListener() 
				  { 
					  public void propertyChange(PropertyChangeEvent event) 
					  { 
						  if (SnapToGrid.PROPERTY_GRID_VISIBLE.equals(event.getPropertyName()))
						  {
							  getModel().setGridEnabled((Boolean)event.getNewValue());
							  //firePropertyChange(IEditorPart.PROP_DIRTY);
							  firePropertyChange(PROP_DIRTY);
						  }
		  
						  if (SnapToGeometry.PROPERTY_SNAP_ENABLED.equals(event.getPropertyName()))
						  {
							  getModel().setSnapToGeometryEnabled((Boolean)event.getNewValue());
							  firePropertyChange(PROP_DIRTY);
							  //firePropertyChange(IEditorPart.PROP_DIRTY);
						  }
					}
				  });
		  		 
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
		// ////////////////
		
		ContextMenuProvider cmProvider =
			new StateEditorContextMenuProvider(viewer, getActionRegistry());
		viewer.setContextMenu(cmProvider);
		getSite().registerContextMenu(cmProvider, viewer);
	}

		
	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.ui.parts.GraphicalEditorWithFlyoutPalette#createPaletteViewerProvider()
	 */
	@Override
	protected PaletteViewerProvider createPaletteViewerProvider()
	{
		return new PaletteViewerProvider(getEditDomain())
		{
			@Override
			protected void configurePaletteViewer(PaletteViewer viewer)
			{
				super.configurePaletteViewer(viewer);
				// create a drag source listener for this palette viewer
				// together with an appropriate transfer drop target listener,
				// this will enable
				// model element creation by dragging a
				// CombinatedTemplateCreationEntries
				// from the palette into the editor
				// @see UCMEditor#createTransferDropTargetListener()
				viewer.addDragSourceListener(new TemplateTransferDragSourceListener(
								viewer));
			}
		};
	}

	/**
	 * Create a transfer drop target listener. When using a
	 * CombinedTemplateCreationEntry tool in the palette, this will enable model
	 * element creation by dragging from the palette.
	 * 
	 * @see #createPaletteViewerProvider()
	 */
	private TransferDropTargetListener createTransferDropTargetListener()
	{
		return new TemplateTransferDropTargetListener(getGraphicalViewer())
		{
			@Override
			protected CreationFactory getFactory(Object template)
			{
				return new SimpleFactory((Class) template);
			}
		};
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.ui.parts.GraphicalEditorWithFlyoutPalette#getPalettePreferences()
	 */
	@Override
	protected FlyoutPreferences getPalettePreferences()
	{
		return StateEditorPaletteFactory.createPalettePreferences();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.ui.parts.GraphicalEditorWithFlyoutPalette#getPaletteRoot()
	 */
	@Override
	protected PaletteRoot getPaletteRoot()
	{
		if (PALETTE_MODEL == null)
			PALETTE_MODEL = StateEditorPaletteFactory.createPalette();
		return PALETTE_MODEL;
	}

	/**
	 * Set up the editor's inital content (after creation).
	 * 
	 * @see org.eclipse.gef.ui.parts.GraphicalEditorWithFlyoutPalette#initializeGraphicalViewer()
	 */
	@Override
	protected void initializeGraphicalViewer()
	{
		super.initializeGraphicalViewer();
		GraphicalViewer viewer = getGraphicalViewer();
		viewer.setContents(getModel()); // set the contents of this editor

		// add the ShortestPathConnectionRouter
		ScalableFreeformRootEditPart root = (ScalableFreeformRootEditPart) viewer
				.getRootEditPart();
		ConnectionLayer connLayer = (ConnectionLayer) root
				.getLayer(LayerConstants.CONNECTION_LAYER);
		GraphicalEditPart contentEditPart = (GraphicalEditPart) root
				.getContents();
		ShortestPathConnectionRouter router = new ShortestPathConnectionRouter(
				contentEditPart.getFigure());
		connLayer.setConnectionRouter(router);

		// listen for dropped parts
		viewer.addDropTargetListener(createTransferDropTargetListener());
	}
	
	@Override
	public void doSave(IProgressMonitor monitor) {
		//To implement
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.ui.ISaveablePart#isSaveAsAllowed()
	 */
	@Override
	public boolean isSaveAsAllowed() {
		return true;
	}
	
	@Override
	public Object getAdapter(Class type) {
		if (type == ZoomManager.class) 
		{
			return getGraphicalViewer().getProperty(ZoomManager.class.toString());
		}
		return super.getAdapter(type);
	}
		
	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.ui.parts.GraphicalEditor#createActions()
	 */
	@Override
	protected void createActions()
	{
		super.createActions();
		
		  ActionRegistry registry = getActionRegistry(); 
		  IAction action = new EditVisualizationAction(this);
		  registry.registerAction(action);
		  getSelectionActions().add(action.getId());
		  
		  action = new ChangeFinalStateValueAction(this);
		  registry.registerAction(action);
		  getSelectionActions().add(action.getId());
		  
		  action = new EditExecutionConditionAction(this);
		  registry.registerAction(action);
		  getSelectionActions().add(action.getId());
		  
		  action = new AssignMethodExecutionConditionAction(this);
		  registry.registerAction(action);
		  getSelectionActions().add(action.getId());
		  
		  action = new NewGeneralExecutionConditionAction(this);
		  registry.registerAction(action);
		  getSelectionActions().add(action.getId());
		  
		  action = new NewMethodExecutionConditionAction(this);
		  registry.registerAction(action);
		  getSelectionActions().add(action.getId());
		  
		  action = new EditPreFiltersAction(this);
		  registry.registerAction(action);
		  getSelectionActions().add(action.getId());
	}
		
	public void closeEditor(boolean save) {
		getSite().getPage().closeEditor(StateEditor.this, save);
	}	
	
	@Override
	public void unsetDirty() {
		super.unsetDirty();
		getCommandStack().markSaveLocation();
		this.firePropertyChange(PROP_DIRTY);
	}
}