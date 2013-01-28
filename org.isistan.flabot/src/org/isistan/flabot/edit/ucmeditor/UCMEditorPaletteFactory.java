/** * $Id: UCMEditorPaletteFactory.java,v 1.29 2006/04/01 03:44:03 franco Exp $ * $Author: franco $ */package org.isistan.flabot.edit.ucmeditor;

import org.eclipse.gef.palette.CombinedTemplateCreationEntry;import org.eclipse.gef.palette.ConnectionCreationToolEntry;import org.eclipse.gef.palette.CreationToolEntry;import org.eclipse.gef.palette.MarqueeToolEntry;import org.eclipse.gef.palette.PaletteContainer;import org.eclipse.gef.palette.PaletteDrawer;import org.eclipse.gef.palette.PaletteGroup;import org.eclipse.gef.palette.PaletteRoot;import org.eclipse.gef.palette.PaletteSeparator;import org.eclipse.gef.palette.PanningSelectionToolEntry;import org.eclipse.gef.palette.ToolEntry;import org.eclipse.gef.requests.CreationFactory;import org.eclipse.gef.tools.CreationTool;import org.eclipse.gef.ui.palette.FlyoutPaletteComposite.FlyoutPreferences;import org.eclipse.jface.preference.IPreferenceStore;import org.eclipse.jface.resource.ImageDescriptor;import org.isistan.flabot.FlabotPlugin;import org.isistan.flabot.coremodel.ComponentRole;import org.isistan.flabot.coremodel.CoremodelFactory;import org.isistan.flabot.coremodel.Note;import org.isistan.flabot.coremodel.PathNode;import org.isistan.flabot.edit.editor.editparts.NoteConnectionEditPart;import org.isistan.flabot.edit.editormodel.EditormodelFactory;import org.isistan.flabot.edit.editormodel.NodeVisualModel;import org.isistan.flabot.edit.editormodel.VisualModel;import org.isistan.flabot.messages.Messages;final class UCMEditorPaletteFactory {
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
						NodeVisualModel visual = EditormodelFactory.eINSTANCE.createNodeVisualModel();						ComponentRole role = CoremodelFactory.eINSTANCE.createComponentRole();						role.setComponentType(ComponentRole.COMPONENT_TYPE);
						visual.setSemanticModel(role);
						return visual;
					}
					public Object getObjectType() {return ComponentRole.class;}					
				}, 
				ImageDescriptor.createFromFile(FlabotPlugin.class, "icons/role.gif"),  //$NON-NLS-1$
				ImageDescriptor.createFromFile(FlabotPlugin.class, "icons/role.gif")); //$NON-NLS-1$		tool.setToolClass(ComponentCreationTool.class);		componentsDrawer.add(tool);				tool = new CreationToolEntry (				Messages.getString("org.isistan.flabot.edit.ucmeditor.UCMEditorPaletteFactory.componentProcessItem"),  //$NON-NLS-1$				Messages.getString("org.isistan.flabot.edit.ucmeditor.UCMEditorPaletteFactory.componentProcessDescription"),  //$NON-NLS-1$				new CreationFactory() {					public Object getNewObject() {						NodeVisualModel visual = EditormodelFactory.eINSTANCE.createNodeVisualModel();						ComponentRole role = CoremodelFactory.eINSTANCE.createComponentRole();						role.setComponentType(ComponentRole.PROCESS_TYPE);						visual.setSemanticModel(role);						//visual.setSemanticModel(CoremodelFactory.eINSTANCE.createComponentRole(ComponentRole.PROCESS_TYPE));						return visual;					}					public Object getObjectType() {return ComponentRole.class;}									}, 				ImageDescriptor.createFromFile(FlabotPlugin.class, "icons/Process16.gif"),  //$NON-NLS-1$				ImageDescriptor.createFromFile(FlabotPlugin.class, "icons/Process24.gif")); //$NON-NLS-1$		tool.setToolClass(ComponentCreationTool.class);		componentsDrawer.add(tool);				tool = new CreationToolEntry (				Messages.getString("org.isistan.flabot.edit.ucmeditor.UCMEditorPaletteFactory.componentAgentItem"),  //$NON-NLS-1$				Messages.getString("org.isistan.flabot.edit.ucmeditor.UCMEditorPaletteFactory.componentAgentDescription"),  //$NON-NLS-1$				new CreationFactory() {					public Object getNewObject() {						NodeVisualModel visual = EditormodelFactory.eINSTANCE.createNodeVisualModel();						ComponentRole role = CoremodelFactory.eINSTANCE.createComponentRole();						role.setComponentType(ComponentRole.AGENT_TYPE);						visual.setSemanticModel(role);						//visual.setSemanticModel(CoremodelFactory.eINSTANCE.createComponentRole(ComponentRole.AGENT_TYPE));						return visual;					}					public Object getObjectType() {return ComponentRole.class;}									}, 				ImageDescriptor.createFromFile(FlabotPlugin.class, "icons/Agent16.gif"),  //$NON-NLS-1$				ImageDescriptor.createFromFile(FlabotPlugin.class, "icons/Agent24.gif")); //$NON-NLS-1$		tool.setToolClass(ComponentCreationTool.class);		componentsDrawer.add(tool);				tool = new CreationToolEntry (				Messages.getString("org.isistan.flabot.edit.ucmeditor.UCMEditorPaletteFactory.componentObjectItem"),  //$NON-NLS-1$				Messages.getString("org.isistan.flabot.edit.ucmeditor.UCMEditorPaletteFactory.componentObjectDescription"),  //$NON-NLS-1$				new CreationFactory() {					public Object getNewObject() {						NodeVisualModel visual = EditormodelFactory.eINSTANCE.createNodeVisualModel();						ComponentRole role = CoremodelFactory.eINSTANCE.createComponentRole();						role.setComponentType(ComponentRole.OBJECT_TYPE);						visual.setSemanticModel(role);						//visual.setSemanticModel(CoremodelFactory.eINSTANCE.createComponentRole(ComponentRole.OBJECT_TYPE));						return visual;					}					public Object getObjectType() {return ComponentRole.class;}									}, 				ImageDescriptor.createFromFile(FlabotPlugin.class, "icons/Object16.gif"),  //$NON-NLS-1$				ImageDescriptor.createFromFile(FlabotPlugin.class, "icons/Object24.gif")); //$NON-NLS-1$		tool.setToolClass(ComponentCreationTool.class);		componentsDrawer.add(tool);				tool = new CreationToolEntry (				Messages.getString("org.isistan.flabot.edit.ucmeditor.UCMEditorPaletteFactory.componentActorItem"),  //$NON-NLS-1$				Messages.getString("org.isistan.flabot.edit.ucmeditor.UCMEditorPaletteFactory.componentActorDescription"),  //$NON-NLS-1$				new CreationFactory() {					public Object getNewObject() {						NodeVisualModel visual = EditormodelFactory.eINSTANCE.createNodeVisualModel();						ComponentRole role = CoremodelFactory.eINSTANCE.createComponentRole();						role.setComponentType(ComponentRole.ACTOR_TYPE);						visual.setSemanticModel(role);						//visual.setSemanticModel(CoremodelFactory.eINSTANCE.createComponentRole(ComponentRole.ACTOR_TYPE));						return visual;					}					public Object getObjectType() {return ComponentRole.class;}									}, 				ImageDescriptor.createFromFile(FlabotPlugin.class, "icons/Actor16.gif"),  //$NON-NLS-1$				ImageDescriptor.createFromFile(FlabotPlugin.class, "icons/Actor24.gif")); //$NON-NLS-1$		tool.setToolClass(ComponentCreationTool.class);		componentsDrawer.add(tool);		
			
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
		tool.setToolProperty(CreationTool.PROPERTY_UNLOAD_WHEN_FINISHED, false);		tool.setToolClass(PathCreationTool.class);				componentsDrawer.add(tool);		
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