package org.isistan.flabot.executionstatemapping.editor;

import org.eclipse.gef.palette.CombinedTemplateCreationEntry;
import org.eclipse.gef.palette.ConnectionCreationToolEntry;
import org.eclipse.gef.palette.CreationToolEntry;
import org.eclipse.gef.palette.MarqueeToolEntry;
import org.eclipse.gef.palette.PaletteContainer;
import org.eclipse.gef.palette.PaletteDrawer;
import org.eclipse.gef.palette.PaletteGroup;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.palette.PaletteSeparator;
import org.eclipse.gef.palette.PanningSelectionToolEntry;
import org.eclipse.gef.palette.ToolEntry;
import org.eclipse.gef.requests.CreationFactory;
import org.eclipse.gef.ui.palette.FlyoutPaletteComposite.FlyoutPreferences;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.resource.ImageDescriptor;
import org.isistan.flabot.coremodel.CoremodelFactory;
import org.isistan.flabot.coremodel.Note;
import org.isistan.flabot.edit.editor.editparts.NoteConnectionEditPart;
import org.isistan.flabot.edit.editormodel.ConnectionVisualModel;
import org.isistan.flabot.edit.editormodel.EditormodelFactory;
import org.isistan.flabot.edit.editormodel.NodeVisualModel;
import org.isistan.flabot.edit.editormodel.VisualModel;
import org.isistan.flabot.executionstatemapping.ExecutionConditionPlugin;
import org.isistan.flabot.executionstatemapping.messages.Messages;
import org.isistan.flabot.executionstatemapping.model.semantic.SemanticFactory;
import org.isistan.flabot.executionstatemapping.model.semantic.State;
import org.isistan.flabot.executionstatemapping.model.semantic.StateType;
import org.isistan.flabot.executionstatemapping.model.semantic.TransitionCondition;

final class StateEditorPaletteFactory
{
	private StateEditorPaletteFactory()
	{
		// utility class
	}

	/** Preference ID used to persist the palette location. */
	private static final String PALETTE_DOCK_LOCATION = "StateEditorPaletteFactory.Location"; //$NON-NLS-1$
	/** Preference ID used to persist the palette size. */
	private static final String PALETTE_SIZE = "StateEditorPaletteFactory.Size"; //$NON-NLS-1$
	/** Preference ID used to persist the flyout palette's state. */
	private static final String PALETTE_STATE = "StateEditorPaletteFactory.State"; //$NON-NLS-1$

	/** Create the "UCM" drawer. */
	private static PaletteContainer createModelsDrawer()
	{
		PaletteDrawer componentsDrawer = new PaletteDrawer(
				Messages
						.getString("org.isistan.flabot.edit.ucmeditor.UCMEditorPaletteFactory.paletteName")); //$NON-NLS-1$

		ToolEntry tool = new CreationToolEntry(
				Messages.getString("org.isistan.flabot.executionmapping.editor.StateEditorPaletteFactory.state"),  //$NON-NLS-1$
				Messages.getString("org.isistan.flabot.executionmapping.editor.StateEditorPaletteFactory.addState"),  //$NON-NLS-1$
				new CreationFactory()
				{
					public Object getNewObject()
					{
						NodeVisualModel visual = EditormodelFactory.eINSTANCE
								.createNodeVisualModel();
						State state = SemanticFactory.eINSTANCE.createState();
						state.setStateType(StateType.NORMAL);
						visual.setSemanticModel(state);
						return visual;
					}

					public Object getObjectType()
					{
						return State.class;
					}
				}, ImageDescriptor.createFromFile(ExecutionConditionPlugin.class,
						"icons/state_normal.gif"), //$NON-NLS-1$
				ImageDescriptor.createFromFile(ExecutionConditionPlugin.class,
						"icons/state_normal.gif")); //$NON-NLS-1$
		componentsDrawer.add(tool);
				
		tool = new CreationToolEntry(
				Messages.getString("org.isistan.flabot.executionmapping.editor.StateEditorPaletteFactory.finalState"),  //$NON-NLS-1$
				Messages.getString("org.isistan.flabot.executionmapping.editor.StateEditorPaletteFactory.addFinalState"),  //$NON-NLS-1$
				new CreationFactory()
				{
					public Object getNewObject()
					{
						NodeVisualModel visual = EditormodelFactory.eINSTANCE
								.createNodeVisualModel();
						State state = SemanticFactory.eINSTANCE.createFinalState();
						state.setStateType(StateType.FINAL);
						visual.setSemanticModel(state);
						return visual;
					}

					public Object getObjectType()
					{
						return State.class;
					}
				}, ImageDescriptor.createFromFile(ExecutionConditionPlugin.class,
						"icons/state_final.gif"), //$NON-NLS-1$
				ImageDescriptor.createFromFile(ExecutionConditionPlugin.class,
						"icons/state_final.gif")); //$NON-NLS-1$
		tool.setToolClass(FinalStateCreationTool.class);
		componentsDrawer.add(tool);		
		
		tool = new ConnectionCreationToolEntry(
				Messages.getString("org.isistan.flabot.executionmapping.editor.StateEditorPaletteFactory.transitionCondition"), //$NON-NLS-1$
				Messages.getString("org.isistan.flabot.executionmapping.editor.StateEditorPaletteFactory.addTransitionCondition"), //$NON-NLS-1$
				new CreationFactory() {
					public Object getNewObject() { 
						ConnectionVisualModel visual = EditormodelFactory.eINSTANCE.createConnectionVisualModel(); 
						TransitionCondition transitionCondition = SemanticFactory.eINSTANCE.createTransitionCondition(); 						
						visual.setSemanticModel(transitionCondition);	
						return visual; 
					}
					public Object getObjectType() { return TransitionCondition.class; }
				},
				ImageDescriptor.createFromFile(ExecutionConditionPlugin.class, "icons/state_link.gif"), //$NON-NLS-1$
				ImageDescriptor.createFromFile(ExecutionConditionPlugin.class, "icons/state_link.gif")); //$NON-NLS-1$
		componentsDrawer.add(tool);		

		componentsDrawer.add(new PaletteSeparator());

		tool = new CombinedTemplateCreationEntry(
				Messages.getString("org.isistan.flabot.executionmapping.editor.StateEditorPaletteFactory.note"), //$NON-NLS-1$
				Messages.getString("org.isistan.flabot.executionmapping.editor.StateEditorPaletteFactory.addNote"), //$NON-NLS-1$
				VisualModel.class, 
				new CreationFactory()
				{
					public Object getNewObject()
					{
						NodeVisualModel visual = EditormodelFactory.eINSTANCE
								.createNodeVisualModel();
						Note note = CoremodelFactory.eINSTANCE.createNote();
						visual.setSemanticModel(note);
						return visual;
					}

					public Object getObjectType()
					{
						return Note.class;
					}
				}, ImageDescriptor.createFromFile(ExecutionConditionPlugin.class,
						"icons/note.gif"), //$NON-NLS-1$
				ImageDescriptor.createFromFile(ExecutionConditionPlugin.class,
						"icons/note.gif")); //$NON-NLS-1$
		componentsDrawer.add(tool);

		tool = new ConnectionCreationToolEntry(
				Messages.getString("org.isistan.flabot.executionmapping.editor.StateEditorPaletteFactory.noteLink"), //$NON-NLS-1$
				Messages.getString("org.isistan.flabot.executionmapping.editor.StateEditorPaletteFactory.addNoteLink"), //$NON-NLS-1$
				new CreationFactory()
				{
					public Object getNewObject()
					{
						return EditormodelFactory.eINSTANCE
								.createConnectionVisualModel();
					}

					public Object getObjectType()
					{
						return NoteConnectionEditPart.NOTE_CONNECTION;
					}
				}, ImageDescriptor.createFromFile(ExecutionConditionPlugin.class,
						"icons/note_link.gif"), //$NON-NLS-1$
				ImageDescriptor.createFromFile(ExecutionConditionPlugin.class,
						"icons/note_link.gif")); //$NON-NLS-1$
		componentsDrawer.add(tool);

		return componentsDrawer;
	}

	/**
	 * Creates the PaletteRoot and adds all palette elements. Use this factory
	 * method to create a new palette for your graphical editor.
	 * 
	 * @return a new PaletteRoot
	 */
	static PaletteRoot createPalette()
	{
		PaletteRoot palette = new PaletteRoot();
		palette.add(createToolsGroup(palette));
		palette.add(createModelsDrawer());
		return palette;
	}

	/**
	 * Return a FlyoutPreferences instance used to save/load the preferences of
	 * a flyout palette.
	 */
	static FlyoutPreferences createPalettePreferences()
	{
		return new FlyoutPreferences()
		{
			private IPreferenceStore getPreferenceStore()
			{
				return ExecutionConditionPlugin.getDefault().getPreferenceStore();
			}

			public int getDockLocation()
			{
				return getPreferenceStore().getInt(PALETTE_DOCK_LOCATION);
			}

			public int getPaletteState()
			{
				return getPreferenceStore().getInt(PALETTE_STATE);
			}

			public int getPaletteWidth()
			{
				return getPreferenceStore().getInt(PALETTE_SIZE);
			}

			public void setDockLocation(int location)
			{
				getPreferenceStore().setValue(PALETTE_DOCK_LOCATION, location);
			}

			public void setPaletteState(int state)
			{
				getPreferenceStore().setValue(PALETTE_STATE, state);
			}

			public void setPaletteWidth(int width)
			{
				getPreferenceStore().setValue(PALETTE_SIZE, width);
			}
		};
	}

	/** Create the "Tools" group. */
	private static PaletteContainer createToolsGroup(PaletteRoot palette)
	{
		PaletteGroup toolGroup = new PaletteGroup(
				Messages
						.getString("org.isistan.flabot.edit.ucmeditor.UCMEditorPaletteFactory.paletteGroupName")); //$NON-NLS-1$

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