/**

import java.io.IOException;
 * Flabot multipage editor: used for flabot project files, shows each diagram
 * (either a use case map or a component diagram) in a different page.
 */
public class FlabotMultiPageEditor extends MultiPageEditorPart
	implements Adapter, UnsettableDirtyStateEditor{
	
	private static final Map SAVE_OPTIONS = Collections.singletonMap(XMLResource.OPTION_ENCODING, "ISO-8859-15"); //$NON-NLS-1$

	private boolean dirty = false;
	
	/** The text editor used in page 0. */
	private FlabotMultipagePropertiesEditor properties;

	private FlabotFileModel fileModel;

	private List<Object> diagramRegistry = new ArrayList<Object>(2);
	
	private FlabotOutlinePage outline;
	
	private PropertySheetPage propertiesPage = new PropertySheetPage();

	private boolean editorSaving = false;
	
	private ResourceTracker resourceListener = new ResourceTracker();

	private CommandStack commandStack;

	private List<IEditorPart> editorIndexes = new ArrayList<IEditorPart>(2);
	/**
	 * Creates a multi-page editor example.
	 */
	public FlabotMultiPageEditor() {
		super();
	}

	public String getPartName() {
		return getEditorInput().getName();
	}
	
	public boolean isDirty() {
		return (dirty || super.isDirty());
	}
	
	public CommandStack getCommandStack() {
		if (commandStack == null) {
			commandStack = new FlabotCommandStack(this);
		}
		return commandStack;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.emf.common.notify.Adapter#notifyChanged(org.eclipse.emf.common.notify.Notification)
	 */
	public void notifyChanged(Notification notification) {
		int eventType = notification.getEventType();
				updatePageText((Diagram)notification.getNotifier());
			
		
	}
	
	private void updatePageText(Diagram diagram) {
		int index = getIndexFor(diagram);
		if (index != -1) {
			String name = diagram.getName();
			if (diagram.getCoreModel() != null && diagram.getCoreModel() != fileModel.getCoreModel()) {
				// the diagram is from an imported file, add that information
				// to the page text
				name += " (" + diagram.getCoreModel().getFile().getName() + ")"; //$NON-NLS-1$ //$NON-NLS-2$
			}
			setPageText(index, name);
		}
	}

	public Notifier getTarget() {
		return fileModel.getCoreModel();
	}
	
	public void setTarget(Notifier newTarget) {
		//do nothing
	}
	
	public boolean isAdapterForType(Object type) {
		return FlabotFileModel.class.isAssignableFrom((Class)type);
	}
	
    /**
     * Returns the active nested editor if there is one.
     * <p>
     * Subclasses should not override this method
     * </p>
     * 
     * @return the active nested editor, or <code>null</code> if none
     */
    public IEditorPart getActiveEditor() {
        int index = getActivePage();
        if (index != -1)
            return getEditor(index);
        return null;
    }    
    
	@Override
	public int getActivePage() {
		return super.getActivePage();
	}	
	
	@Override
	public void setActivePage(int pageIndex) {
		super.setActivePage(pageIndex);
	}

	/**
	 * Creates page 0 of the multi-page editor,
	 * which is a flabot multipage properties editor
	 */
	void createPage0() {
		try {
			properties = new FlabotMultipagePropertiesEditor(getModel());
			int index = addPage(properties, getEditorInput());
			setPageText(index, Messages.getString("org.isistan.flabot.edit.multipage.FlabotMultiPageEditor.propertiesTabName")); //$NON-NLS-1$
		} catch (PartInitException e) {
				ErrorDialog.openError(
				getSite().getShell(),
				Messages.getString("org.isistan.flabot.edit.multipage.FlabotMultiPageEditor.errorCreatingNestedEditorDialogName"), //$NON-NLS-1$
				null,
				e.getStatus());
				FlabotPlugin.getDefault().getLogger()
				.error(Messages.getString("org.isistan.flabot.edit.multipage.FlabotMultiPageEditor.errorCreatingNestedEditorException"), e); //$NON-NLS-1$
				
		}
	}
	
	/**
	 * Creates the pages of the multi-page editor.
	 */
	@Override
	protected void createPages() {
		createPage0();
		
		//When deletion is fixed, change to getOpenDiagrams()
				diagrams.hasNext();) {
			Diagram diagram = (Diagram) diagrams.next();
			createDiagramPage(diagram);
		}
	}
	
	/**
	 * Create a page for the given diagram if it hasn't already been created.
	 * @param diagram the diagram
	 * @return the index of the page for the given diagram, whether it's new
	 * 			or not
	 */
	private int createDiagramPage(Diagram diagram) {
		int index = getIndexFor(diagram);
		Image image = null;
		if (index == -1) {
			IEditorPart editor = null;
			if (diagram instanceof UCMDiagram) {
				editor = new UCMEditor(this);
				((UCMEditor)editor).setModel((UCMDiagram) diagram);
				diagram.eAdapters().add(this);
				image = ImageDescriptor.createFromFile(FlabotPlugin.class, "icons/ucm.gif").createImage(); //$NON-NLS-1$
			}
			else if (diagram instanceof ComponentDiagram) {				
				editor = new ComponentEditor(this);
				((ComponentEditor)editor).setModel((ComponentDiagram)diagram);
				diagram.eAdapters().add(this);
				image = ImageDescriptor.createFromFile(FlabotPlugin.class, "icons/cd.gif").createImage(); //$NON-NLS-1$
			}
			try {
				index = addPage(editor, getEditorInput());
				setPageImage(index, image);
				diagramRegistry.add(diagram);
				updatePageText(diagram);
			} catch (PartInitException e) {
				ErrorDialog.openError(
					getSite().getShell(),
					Messages.getString("org.isistan.flabot.edit.multipage.FlabotMultiPageEditor.errorCreatingNestedEditorDialogName"), //$NON-NLS-1$
					null,
					e.getStatus());
			}
			fileModel.getOpenDiagrams().add(diagram);
		}
		return index;
	}
	
	/**
	 * Get the index of the page for the given diagram. If there's no
	 * page, -1 is returned
	 * @param diagram
	 * @return
	 */
	private int getIndexFor(Object diagram) {
		int index = diagramRegistry.indexOf(diagram); 
		if (index == -1)
			return index;
		return  index + 1;
	}	
	
	/**
	 * Activate the editor for the given diagram. If necessary, a page will 
	 * be created
	 * @param diagram
	 * @return
	 */
	public int openDiagram(Diagram diagram) 
	{		
		if (diagram == null)
		}
		if (index >= 0) {
			setActivePage(index);
			pageChange(index);			
		return index;
	}

	public void removeDiagram(Diagram diagram) {
		closeDiagram(diagram);
	}
		
	public void closeActivePage() {
		closePage(getActivePage());
	}
	
	protected void closePage(int index) {
		Object diagram = (Object) diagramRegistry.remove(index - 1);
		removePage(index);
		if (diagram != null && fileModel.getOpenDiagrams().contains(diagram))
		{
		}
	
	@SuppressWarnings("unchecked") //$NON-NLS-1$
	public void createNewComponentEditor(ComponentDiagram diagram) {
		IEditorPart editor = new ComponentEditor(this);
		((ComponentEditor)editor).setModel(diagram);		
	}	
	
	public void markDirty() {
		if (!dirty) {
			this.dirty = true;
			firePropertyChange(PROP_DIRTY);			
		}
	}
	
	@SuppressWarnings("unchecked") //$NON-NLS-1$
	public void createNewUCMEditor(UCMDiagram diagram) {
		IEditorPart editor = new UCMEditor(this);		
		((UCMEditor)editor).setModel(diagram);			
		openDiagram(diagram);
	}
	
	/**
	 * The <code>MultiPageEditorPart</code> implementation of this 
	 * <code>IWorkbenchPart</code> method disposes all nested editors.
	 * Subclasses may extend.
	 */
	public void dispose() {
		super.dispose();
	}
	
	/**
	 * Saves the multi-page editor's document.
	 */
	@SuppressWarnings("unchecked") //$NON-NLS-1$
	public void doSave(IProgressMonitor monitor) {
		editorSaving = true;
			URI uri = getURI(getEditorInput());
			resource = resourceSet.createResource(uri);
		try {
			resource.save(SAVE_OPTIONS);
			this.unsetDirty();
		} catch (IOException e) {
			FlabotPlugin.getDefault().getLogger()
				.error(Messages.getString("org.isistan.flabot.edit.multipage.FlabotMultiPageEditor.errorSavingFile"), e); //$NON-NLS-1$
		}
	}
	
	/**
	 * Saves the multi-page editor's document as another file.
	 * Also updates the text for page 0's tab, and updates this multi-page editor's input
	 * to correspond to the nested editor's.
	 */
	public void doSaveAs() {}
	
	public void gotoMarker(IMarker marker) {
		setActivePage(0);
		IDE.gotoMarker(getEditor(0), marker);
	}
	
	/**
	 * The <code>MultiPageEditorExample</code> implementation of this method
	 * checks that the input is an instance of <code>IFileEditorInput</code>.
	 */
	public void init(IEditorSite site, IEditorInput editorInput)
		throws PartInitException {
		if (!(editorInput instanceof IFileEditorInput ||
				editorInput instanceof IPathEditorInput))
			throw new PartInitException(Messages.getString("org.isistan.flabot.edit.multipage.FlabotMultiPageEditor.invalidInput")); //$NON-NLS-1$
		  
		super.init(site, editorInput);
		fileModel.eAdapters().add(this);
	}
	
	@Override
		return false;
	}
	
	@Override
	@SuppressWarnings("unused")  //$NON-NLS-1$
	protected void setInput(IEditorInput input) {
		superSetInput(input);
		
		URI uri = getURI(input);
		// initialize packages so their factories are registered and the model
		// is loaded correctly
		ComponentmodelPackage cmp = ComponentmodelPackage.eINSTANCE;
		UcmmodelPackage ucmmp = UcmmodelPackage.eINSTANCE;
			resource = resourceSet.getResource(uri, true);
	
	/**
	 * Extract the path from the given input
	 * @param input
	 * @return
	 */
	private URI getURI(IEditorInput input) {
		if (input instanceof IFileEditorInput) {
			IFileEditorInput fileInput = (IFileEditorInput) input;
			IPath path = fileInput.getFile().getFullPath();
			return URI.createPlatformResourceURI(path.toString());
		}
		if (input instanceof IPathEditorInput) {
			IPathEditorInput pathInput = (IPathEditorInput) input;
			IPath path = pathInput.getPath();
			return URI.createFileURI(path.toString());
		}
		throw new RuntimeException(Messages.getString("org.isistan.flabot.edit.multipage.FlabotMultiPageEditor.invalidInput")); //$NON-NLS-1$
	}

	 protected void pageChange(int newPageIndex) {
		 super.pageChange(newPageIndex);
		 CommandStack c = (CommandStack)getActiveEditor().getAdapter(CommandStack.class);
		 if (c != null)
			 propertiesPage.setRootEntry(new UndoablePropertySheetEntry(c));
	 }
	
	/**
	 * Provide an adapter for the outline view
	 */
	public Object getAdapter(Class type) {
		if (type == IContentOutlinePage.class) {
			if (outline == null)
				outline = new FlabotOutlinePage(new TreeViewer(), this);
			return outline;
		}
		if (type == org.eclipse.ui.views.properties.IPropertySheetPage.class) {
			if (propertiesPage == null)
				propertiesPage = new PropertySheetPage();
			return propertiesPage;
		}
		return super.getAdapter(type);
	}
	
	public FlabotFileModel getModel() {
		return fileModel;
	}
	
	public void closeEditor(boolean save) {
		getSite().getPage().closeEditor(FlabotMultiPageEditor.this, save);
	}
	
	/**
	 * An outline page for the flabot file editor
	 * @author $Author: franco $
	 *
	 */
	private class FlabotOutlinePage extends ContentOutlinePage 
	implements CommandStackListener,
				CommandExecutor, IAdaptable {	
		private FlabotMultiPageEditor multipageEditor;
		private ActionRegistry actionRegistry;
		/**
		 * Create a new outline page for the flabot file editor.
		 * @param viewer a viewer (TreeViewer instance) used for this outline page
		 * @param editor 
		 * @throws IllegalArgumentException if editor is null
		 */
		public FlabotOutlinePage(EditPartViewer viewer,
				FlabotMultiPageEditor editor) {
			super(viewer);
			this.multipageEditor = editor;
		}

		/* (non-Javadoc)
		 * @see org.eclipse.ui.part.IPage#createControl(org.eclipse.swt.widgets.Composite)
		 */
		public void createControl(Composite parent) {
			// create outline viewer page
			getViewer().createControl(parent);
			// configure outline viewer
			DefaultEditDomain editDomain = new DefaultEditDomain(FlabotMultiPageEditor.this);
			editDomain.setCommandStack(FlabotMultiPageEditor.this.getCommandStack());
			getViewer().setEditDomain(editDomain);
			getViewer().setEditPartFactory(new FlabotTreeEditPartFactory());
			// configure & add context menu to viewer
			getViewer().getEditDomain().getCommandStack().addCommandStackListener(this);
			
			registerActions();
			
			ContextMenuProvider cmProvider = new FlabotMultiPageContextMenuProvider(getViewer(), getActionRegistry()); 
			getViewer().setContextMenu(cmProvider);
			getSite().registerContextMenu(
					"org.isistan.flabot.edit.multipage.FlabotMultiPageContextMenuProvider", //$NON-NLS-1$
					cmProvider, multipageEditor.getSite().getSelectionProvider());
			
			getViewer().setContents(getModel());
		}

		
		public void commandStackChanged(EventObject event) {			
			dirty = getViewer().getEditDomain().getCommandStack().isDirty();
			firePropertyChange(IEditorPart.PROP_DIRTY);
		}
		
		public ActionRegistry getActionRegistry() {
			if (actionRegistry == null)
				actionRegistry = new ActionRegistry();
			return actionRegistry;
		}
		
		/* (non-Javadoc)
		 * @see org.eclipse.ui.part.IPage#getControl()
		 */
		public Control getControl() {
			return getViewer().getControl();			
		}
		
		private void registerActions() {			
			getActionRegistry().registerAction(
					new AddNewFolderAction(getViewer(), this));
			getActionRegistry().registerAction(
					new DeleteOutlineAction(getViewer(), this));	
		}
		
		/**
		 * @see org.eclipse.ui.part.IPageBookViewPage#init(org.eclipse.ui.part.IPageSite)
		 */
		public void init(IPageSite pageSite) {
			super.init(pageSite);
			
		/*	IActionBars bars = getSite().getActionBars();
			String id = ActionFactory.UNDO.getId();
			bars.setGlobalActionHandler(id, new UndoRetargetAction());
			id = ActionFactory.REDO.getId();
			bars.setGlobalActionHandler(id, registry.getAction(id));
			id = ActionFactory.DELETE.getId();
			bars.setGlobalActionHandler(id, registry.getAction(id));*/
		}

		/* (non-Javadoc)
		 * @see org.isistan.flabot.edit.editor.CommandExecutor#executeCommand(org.eclipse.gef.commands.Command, boolean, boolean)
		 */
		public void executeCommand(Command command, boolean askUser) {
			if (command == null || !command.canExecute())
				return;
			if (!askUser || askUser(command))
				getViewer().getEditDomain().getCommandStack().execute(command);
		}
		
		/**
		 * Create a dialog to ask the user if the given command must be executed
		 * or not.
		 * @param command the command that will be executed
		 * @return
		 */
		private boolean askUser(Command command) {
			String message = Messages.getString("org.isistan.flabot.edit.multipage.FlabotMultiPageEditor.userConformationDialogDescription", command.getLabel()); //$NON-NLS-1$
					Messages.getString("org.isistan.flabot.edit.multipage.FlabotMultiPageEditor.userConformationDialogTitle"), message); //$NON-NLS-1$
		}
		
		/* (non-Javadoc)
		 * @see org.eclipse.gef.ui.parts.GraphicalEditorWithFlyoutPalette#getAdapter(java.lang.Class)
		 */
		public Object getAdapter(Class type) {
			if (CommandExecutor.class.equals(type))
				return this;
			return null;
		}
	}

	public void unsetDirty() {
		// unset dirty state in internal pages
		for (int i = 0; i < getPageCount(); i++) {
			IEditorPart editor = getEditor(i);
			if (editor instanceof UnsettableDirtyStateEditor) {
				// unset dirty state
				UnsettableDirtyStateEditor unsettable =
					(UnsettableDirtyStateEditor) editor;
				unsettable.unsetDirty();
			}
			else {
				FlabotPlugin.getDefault().getLogger().error(
						Messages.getString("org.isistan.flabot.edit.multipage.FlabotMultiPageEditor.unsettableDirtyStateEditorImplementingError"), editor //$NON-NLS-1$
						);
			}
		}
		// unset dirty state for this
		this.dirty = false;
		firePropertyChange(IEditorPart.PROP_DIRTY);
	}
		
	protected void superSetInput(IEditorInput input) {
		// The workspace never changes for an editor.  So, removing and re-adding the 
		// resourceListener is not necessary.  But it is being done here for the sake
		// of proper implementation.  Plus, the resourceListener needs to be added 
		// to the workspace the first time around.
		if(getEditorInput() != null)
			ResourcesPlugin.getWorkspace().removeResourceChangeListener(resourceListener);
		
		super.setInput(input);
		
		if(getEditorInput() != null) {
			ResourcesPlugin.getWorkspace().addResourceChangeListener(resourceListener);
			String g = getURI(getEditorInput()).path();
			setPartName(g);
	}
	
	//	This class listens to changes to the file system in the workspace, and 
	//	makes changes accordingly.
	//	1) An open, saved file gets deleted -> close the editor
	//	2) An open file gets renamed or moved -> change the editor's input accordingly	
	class ResourceTracker implements IResourceChangeListener, IResourceDeltaVisitor	{
		
		public void resourceChanged(final IResourceChangeEvent event) {
			// Closes all project files on project close.
			if(event.getType() == IResourceChangeEvent.PRE_CLOSE){
				Display.getDefault().asyncExec(new Runnable(){
					public void run(){
						IWorkbenchPage[] pages = getSite().getWorkbenchWindow().getPages();
						for (int i = 0; i<pages.length; i++){
							if(((FileEditorInput)properties.getEditorInput()).getFile().getProject().equals(event.getResource())){
								IEditorPart editorPart = pages[i].findEditor(properties.getEditorInput());
								pages[i].closeEditor(editorPart,true);
							}
						}
					}            
				});
			}
			
			IResourceDelta delta = event.getDelta();
			try {
				if (delta != null)
					delta.accept(this);
			} 
			catch (CoreException exception) {
				
			}
		}
		
		public boolean visit(IResourceDelta delta) { 
			if (delta == null || !delta.getResource().equals(((IFileEditorInput)getEditorInput()).getFile()))
				return true;
		
			if (delta.getKind() == IResourceDelta.REMOVED) {
				Display display = getSite().getShell().getDisplay();
				if ((IResourceDelta.MOVED_TO & delta.getFlags()) == 0) { 
					// if the file was deleted
					display.asyncExec(new Runnable() {
						public void run() {
							closeEditor(false/*isDirty()*/); 
						}
					});
				} else { 
					// else if it was moved or renamed
					final IFile newFile = ResourcesPlugin.getWorkspace().getRoot().getFile(delta.getMovedToPath());
					display.asyncExec(new Runnable() {
						public void run() {
							superSetInput(new FileEditorInput(newFile));
						}
					});
				}
			} else if (delta.getKind() == IResourceDelta.CHANGED) {
				if (!editorSaving) {
					// the file was overwritten somehow (could have been replaced by another 
					// version in the respository)
					final IFile newFile = ResourcesPlugin.getWorkspace().getRoot()
							.getFile(delta.getFullPath());
					Display display = getSite().getShell().getDisplay();
					display.asyncExec(new Runnable() {
						public void run() {
							setInput(new FileEditorInput(newFile));
						}
					});
				}
			}
			return false; 
		}
	}
}