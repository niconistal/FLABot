/** * $Id: ComponentEditorPaletteFactory.java,v 1.26 2006/03/22 20:48:01 franco Exp $ * $Author: franco $ */package org.isistan.flabot.edit.componenteditor;

import org.eclipse.gef.palette.CombinedTemplateCreationEntry;import org.eclipse.gef.palette.ConnectionCreationToolEntry;import org.eclipse.gef.palette.MarqueeToolEntry;import org.eclipse.gef.palette.PaletteContainer;import org.eclipse.gef.palette.PaletteDrawer;import org.eclipse.gef.palette.PaletteGroup;import org.eclipse.gef.palette.PaletteRoot;import org.eclipse.gef.palette.PaletteSeparator;import org.eclipse.gef.palette.PanningSelectionToolEntry;import org.eclipse.gef.palette.ToolEntry;import org.eclipse.gef.requests.CreationFactory;import org.eclipse.gef.ui.palette.FlyoutPaletteComposite.FlyoutPreferences;import org.eclipse.jface.preference.IPreferenceStore;import org.eclipse.jface.resource.ImageDescriptor;import org.isistan.flabot.FlabotPlugin;import org.isistan.flabot.coremodel.ComponentModel;import org.isistan.flabot.coremodel.CoremodelFactory;import org.isistan.flabot.coremodel.InterfaceLink;import org.isistan.flabot.coremodel.Note;import org.isistan.flabot.coremodel.PortModel;import org.isistan.flabot.coremodel.Relationship;import org.isistan.flabot.edit.componenteditor.editparts.ProvidedInterfaceEditPart;import org.isistan.flabot.edit.componenteditor.editparts.RequiredInterfaceEditPart;import org.isistan.flabot.edit.editor.editparts.NoteConnectionEditPart;import org.isistan.flabot.edit.editormodel.ConnectionVisualModel;import org.isistan.flabot.edit.editormodel.EditormodelFactory;import org.isistan.flabot.edit.editormodel.NodeVisualModel;import org.isistan.flabot.edit.editormodel.VisualModel;import org.isistan.flabot.messages.Messages;final class ComponentEditorPaletteFactory {
	
	/** Preference ID used to persist the palette location. */
	private static final String PALETTE_DOCK_LOCATION = "ComponentEditorPaletteFactory.Location"; //$NON-NLS-1$
	/** Preference ID used to persist the palette size. */
	private static final String PALETTE_SIZE = "ComponentEditorPaletteFactory.Size"; //$NON-NLS-1$
	/** Preference ID used to persist the flyout palette's state. */
	private static final String PALETTE_STATE = "ComponentEditorPaletteFactory.State"; //$NON-NLS-1$

	/** Create the "Component" drawer. */
	private static PaletteContainer createComponentDrawer() {
		PaletteDrawer componentsDrawer = new PaletteDrawer(Messages.getString("org.isistan.flabot.edit.componenteditor.ComponentEditorPaletteFactory.paletteName")); //$NON-NLS-1$
		
		ToolEntry tool = new CombinedTemplateCreationEntry(
				Messages.getString("org.isistan.flabot.edit.componenteditor.ComponentEditorPaletteFactory.componentItem"),  //$NON-NLS-1$
				Messages.getString("org.isistan.flabot.edit.componenteditor.ComponentEditorPaletteFactory.componentDescription"),  //$NON-NLS-1$
				VisualModel.class,
				new CreationFactory() {
					public Object getNewObject() { 
						NodeVisualModel visual = EditormodelFactory.eINSTANCE.createNodeVisualModel();
						visual.setSemanticModel(CoremodelFactory.eINSTANCE.createComponentModel());
						return visual;
					}
					public Object getObjectType() { return ComponentModel.class; }
				},
				ImageDescriptor.createFromFile(FlabotPlugin.class, "icons/component.gif"), //$NON-NLS-1$
				ImageDescriptor.createFromFile(FlabotPlugin.class, "icons/component.gif")); //$NON-NLS-1$
		componentsDrawer.add(tool);
		
		tool = new CombinedTemplateCreationEntry(
				Messages.getString("org.isistan.flabot.edit.componenteditor.ComponentEditorPaletteFactory.portItem"),  //$NON-NLS-1$
				Messages.getString("org.isistan.flabot.edit.componenteditor.ComponentEditorPaletteFactory.portDescription"),  //$NON-NLS-1$
				VisualModel.class,
				new CreationFactory() {
					public Object getNewObject() { 
						VisualModel visualModel = EditormodelFactory.eINSTANCE.createVisualModel();	
						visualModel.setSemanticModel(CoremodelFactory.eINSTANCE.createPortModel());		
						return visualModel;
					}
					public Object getObjectType() { return PortModel.class; }
				},
				ImageDescriptor.createFromFile(FlabotPlugin.class, "icons/port.gif"), //$NON-NLS-1$
				ImageDescriptor.createFromFile(FlabotPlugin.class, "icons/port.gif")); //$NON-NLS-1$
		componentsDrawer.add(tool);
		
		tool = new CombinedTemplateCreationEntry(
				Messages.getString("org.isistan.flabot.edit.componenteditor.ComponentEditorPaletteFactory.providedInterfaceItem"),  //$NON-NLS-1$
				Messages.getString("org.isistan.flabot.edit.componenteditor.ComponentEditorPaletteFactory.providedInterfaceDescription"),  //$NON-NLS-1$
				VisualModel.class,
				new CreationFactory() {
					public Object getNewObject() { 
						VisualModel visualModel = EditormodelFactory.eINSTANCE.createNodeVisualModel();	
						visualModel.setSemanticModel(CoremodelFactory.eINSTANCE.createInterfaceModel());		
						return visualModel;
					}
					public Object getObjectType() { return ProvidedInterfaceEditPart.PROVIDED_INTERFACE; }
				},
				ImageDescriptor.createFromFile(FlabotPlugin.class, "icons/provided.gif"), //$NON-NLS-1$
				ImageDescriptor.createFromFile(FlabotPlugin.class, "icons/provided.gif")); //$NON-NLS-1$
		componentsDrawer.add(tool);
		
		tool = new CombinedTemplateCreationEntry(
				Messages.getString("org.isistan.flabot.edit.componenteditor.ComponentEditorPaletteFactory.requiredInterfaceItem"),  //$NON-NLS-1$
				Messages.getString("org.isistan.flabot.edit.componenteditor.ComponentEditorPaletteFactory.requiredInterfaceDescription"),  //$NON-NLS-1$
				VisualModel.class,
				new CreationFactory() {
					public Object getNewObject() {	
						VisualModel visualModel = EditormodelFactory.eINSTANCE.createNodeVisualModel();	
						visualModel.setSemanticModel(CoremodelFactory.eINSTANCE.createInterfaceModel());		
						return visualModel;
					}
					public Object getObjectType() { return RequiredInterfaceEditPart.REQUIRED_INTERFACE; }
				},
				ImageDescriptor.createFromFile(FlabotPlugin.class, "icons/required.gif"), //$NON-NLS-1$
				ImageDescriptor.createFromFile(FlabotPlugin.class, "icons/required.gif")); //$NON-NLS-1$
		componentsDrawer.add(tool);

		// Add a (unnamed) separator to the group
		componentsDrawer.add(new PaletteSeparator());
		
		tool = new ConnectionCreationToolEntry(
				Messages.getString("org.isistan.flabot.edit.componenteditor.ComponentEditorPaletteFactory.interfaceConnectionItem"), //$NON-NLS-1$
				Messages.getString("org.isistan.flabot.edit.componenteditor.ComponentEditorPaletteFactory.interfaceConnectionDescription"), //$NON-NLS-1$
				new CreationFactory() {
					public Object getNewObject() { 
						ConnectionVisualModel visual = EditormodelFactory.eINSTANCE.createConnectionVisualModel(); 
						visual.setSemanticModel(CoremodelFactory.eINSTANCE.createInterfaceLink());
						return visual; 
					}
					public Object getObjectType() { return InterfaceLink.class;}
				},
				ImageDescriptor.createFromFile(FlabotPlugin.class, "icons/interface_link.gif"), //$NON-NLS-1$
				ImageDescriptor.createFromFile(FlabotPlugin.class, "icons/interface_link.gif")); //$NON-NLS-1$
		componentsDrawer.add(tool);
		
		tool = new ConnectionCreationToolEntry(
				Messages.getString("org.isistan.flabot.edit.componenteditor.ComponentEditorPaletteFactory.relationshipItem"), //$NON-NLS-1$
				Messages.getString("org.isistan.flabot.edit.componenteditor.ComponentEditorPaletteFactory.relationshipDescription"), //$NON-NLS-1$
				new CreationFactory() {
					public Object getNewObject() { 
						ConnectionVisualModel visual = EditormodelFactory.eINSTANCE.createConnectionVisualModel(); 
						Relationship relation = CoremodelFactory.eINSTANCE.createRelationship(); 						
						visual.setSemanticModel(relation);	
						return visual; 
					}
					public Object getObjectType() { return Relationship.class; }
				},
				ImageDescriptor.createFromFile(FlabotPlugin.class, "icons/relationship.gif"), //$NON-NLS-1$
				ImageDescriptor.createFromFile(FlabotPlugin.class, "icons/relationship.gif")); //$NON-NLS-1$
		componentsDrawer.add(tool);
		
		componentsDrawer.add(new PaletteSeparator());
		
		tool = new CombinedTemplateCreationEntry(
				Messages.getString("org.isistan.flabot.edit.componenteditor.ComponentEditorPaletteFactory.noteItem"), //$NON-NLS-1$
				Messages.getString("org.isistan.flabot.edit.componenteditor.ComponentEditorPaletteFactory.noteDescription"), //$NON-NLS-1$
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
				Messages.getString("org.isistan.flabot.edit.componenteditor.ComponentEditorPaletteFactory.noteConnectionItem"), //$NON-NLS-1$
				Messages.getString("org.isistan.flabot.edit.componenteditor.ComponentEditorPaletteFactory.noteConnectionDescription"), //$NON-NLS-1$
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
		palette.add(createComponentDrawer());
		palette.setUserModificationPermission(PaletteRoot.PERMISSION_HIDE_ONLY);
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
		PaletteGroup toolGroup = new PaletteGroup(Messages.getString("org.isistan.flabot.edit.componenteditor.ComponentEditorPaletteFactory.groupName")); //$NON-NLS-1$

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

	/** Utility class. */
	private ComponentEditorPaletteFactory() {
		// Utility class
	}
}