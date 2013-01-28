/**

import org.eclipse.gef.palette.CombinedTemplateCreationEntry;
	private UCMEditorPaletteFactory() {
		//utility class
	}
	
	/** Preference ID used to persist the palette location. */
	private static final String PALETTE_DOCK_LOCATION = "UCMEditorPaletteFactory.Location"; //$NON-NLS-1$
	/** Preference ID used to persist the palette size. */
	private static final String PALETTE_SIZE = "UCMEditorPaletteFactory.Size"; //$NON-NLS-1$
	/** Preference ID used to persist the flyout palette's state. */
	private static final String PALETTE_STATE = "UCMEditorPaletteFactory.State"; //$NON-NLS-1$
	
	/** Create the "UCM" drawer. */
	private static PaletteContainer createModelsDrawer() {
		PaletteDrawer componentsDrawer = new PaletteDrawer(Messages.getString("org.isistan.flabot.edit.ucmeditor.UCMEditorPaletteFactory.paletteName")); //$NON-NLS-1$

		ToolEntry tool = new CreationToolEntry (
				Messages.getString("org.isistan.flabot.edit.ucmeditor.UCMEditorPaletteFactory.componentItem"),  //$NON-NLS-1$
				Messages.getString("org.isistan.flabot.edit.ucmeditor.UCMEditorPaletteFactory.componentDescription"),  //$NON-NLS-1$
				new CreationFactory() {
					public Object getNewObject() {
						NodeVisualModel visual = EditormodelFactory.eINSTANCE.createNodeVisualModel();
						visual.setSemanticModel(role);
						return visual;
					}
					public Object getObjectType() {return ComponentRole.class;}					
				}, 
				ImageDescriptor.createFromFile(FlabotPlugin.class, "icons/role.gif"),  //$NON-NLS-1$
				ImageDescriptor.createFromFile(FlabotPlugin.class, "icons/role.gif")); //$NON-NLS-1$
			
		tool = new CreationToolEntry(
				Messages.getString("org.isistan.flabot.edit.ucmeditor.UCMEditorPaletteFactory.pathNodeItem"),  //$NON-NLS-1$
				Messages.getString("org.isistan.flabot.edit.ucmeditor.UCMEditorPaletteFactory.pathNodeDescription"),  //$NON-NLS-1$
				new CreationFactory() {
					public Object getNewObject() {
						NodeVisualModel visual = EditormodelFactory.eINSTANCE.createNodeVisualModel();
						return visual;
					}
					public Object getObjectType() {return PathNode.class;}					
				}, 
				ImageDescriptor.createFromFile(FlabotPlugin.class, "icons/path24x24.gif"),  //$NON-NLS-1$
				ImageDescriptor.createFromFile(FlabotPlugin.class, "icons/path24x24.gif")); //$NON-NLS-1$
		tool.setToolProperty(CreationTool.PROPERTY_UNLOAD_WHEN_FINISHED, false);
		componentsDrawer.add(new PaletteSeparator());
		
		tool = new CombinedTemplateCreationEntry(
				Messages.getString("org.isistan.flabot.edit.ucmeditor.UCMEditorPaletteFactory.noteItem"), //$NON-NLS-1$
				Messages.getString("org.isistan.flabot.edit.ucmeditor.UCMEditorPaletteFactory.noteDescription"), //$NON-NLS-1$
				VisualModel.class,
				new CreationFactory() {
					public Object getNewObject() { 
						NodeVisualModel visual = EditormodelFactory.eINSTANCE.createNodeVisualModel(); 
						Note note = CoremodelFactory.eINSTANCE.createNote(); 
						visual.setSemanticModel(note);	
						return visual; 
					}
					public Object getObjectType() { return Note.class; }
				},
				ImageDescriptor.createFromFile(FlabotPlugin.class, "icons/note.gif"), //$NON-NLS-1$
				ImageDescriptor.createFromFile(FlabotPlugin.class, "icons/note.gif")); //$NON-NLS-1$
		componentsDrawer.add(tool);
		
		tool = new ConnectionCreationToolEntry(
				Messages.getString("org.isistan.flabot.edit.ucmeditor.UCMEditorPaletteFactory.noteConnectionItem"), //$NON-NLS-1$
				Messages.getString("org.isistan.flabot.edit.ucmeditor.UCMEditorPaletteFactory.noteConnectionDescription"), //$NON-NLS-1$
				new CreationFactory() {
					public Object getNewObject() { 
						return EditormodelFactory.eINSTANCE.createConnectionVisualModel(); 
					}
					public Object getObjectType() { return NoteConnectionEditPart.NOTE_CONNECTION; }
				},
				ImageDescriptor.createFromFile(FlabotPlugin.class, "icons/note_link.gif"), //$NON-NLS-1$
				ImageDescriptor.createFromFile(FlabotPlugin.class, "icons/note_link.gif")); //$NON-NLS-1$
		componentsDrawer.add(tool);
		
		return componentsDrawer;
	}
	
	/**
	 * Creates the PaletteRoot and adds all palette elements.
	 * Use this factory method to create a new palette for your graphical editor.
	 * @return a new PaletteRoot
	 */
	static PaletteRoot createPalette() {
		PaletteRoot palette = new PaletteRoot();
		palette.add(createToolsGroup(palette));
		palette.add(createModelsDrawer());
		return palette;
	}

	/**
	 * Return a FlyoutPreferences instance used to save/load the preferences of a flyout palette.
	 */
	static FlyoutPreferences createPalettePreferences() {
		return new FlyoutPreferences() {
			private IPreferenceStore getPreferenceStore() {
				return FlabotPlugin.getDefault().getPreferenceStore();
			}
			public int getDockLocation() {
				return getPreferenceStore().getInt(PALETTE_DOCK_LOCATION);
			}
			public int getPaletteState() {
				return getPreferenceStore().getInt(PALETTE_STATE);
			}
			public int getPaletteWidth() {
				return getPreferenceStore().getInt(PALETTE_SIZE);
			}
			public void setDockLocation(int location) {
				getPreferenceStore().setValue(PALETTE_DOCK_LOCATION, location);
			}
			public void setPaletteState(int state) {
				getPreferenceStore().setValue(PALETTE_STATE, state);
			}
			public void setPaletteWidth(int width) {
				getPreferenceStore().setValue(PALETTE_SIZE, width);
			}
		};
	}
	
	/** Create the "Tools" group. */
	private static PaletteContainer createToolsGroup(PaletteRoot palette) {
		PaletteGroup toolGroup = new PaletteGroup(Messages.getString("org.isistan.flabot.edit.ucmeditor.UCMEditorPaletteFactory.paletteGroupName")); //$NON-NLS-1$

		// Add a selection tool to the group
		ToolEntry tool = new PanningSelectionToolEntry();
		toolGroup.add(tool);
		palette.setDefaultEntry(tool);
		
		// Add a marquee tool to the group
		toolGroup.add(new MarqueeToolEntry());

		// Add a (unnamed) separator to the group
		toolGroup.add(new PaletteSeparator());

		return toolGroup;
	}
}