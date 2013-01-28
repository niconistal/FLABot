package org.isistan.flabot.executionstatemapping.view;

import java.util.List;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.GroupMarker;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuCreator;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.BusyIndicator;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.part.IPageBookViewPage;
import org.eclipse.ui.part.IPageSite;
import org.isistan.flabot.edit.editor.FlabotCommandStack;
import org.isistan.flabot.edit.editormodel.EditormodelFactory;
import org.isistan.flabot.edit.editormodel.NodeVisualModel;
import org.isistan.flabot.edit.editormodel.Util;
import org.isistan.flabot.edit.multipage.FlabotMultiPageEditor;
import org.isistan.flabot.executionstatemapping.ExecutionConditionPlugin;
import org.isistan.flabot.executionstatemapping.InterfacePluginExecutionStateMapping;
import org.isistan.flabot.executionstatemapping.commands.diagram.ManageStateDiagramCommand;
import org.isistan.flabot.executionstatemapping.commands.executioncondition.ManageMethodExecutionConditionCommand;
import org.isistan.flabot.executionstatemapping.commands.executioncondition.ManagePersistentTreeElementCommand;
import org.isistan.flabot.executionstatemapping.dialogs.common.ExecutionConditionEditorBuilder;
import org.isistan.flabot.executionstatemapping.dialogs.utils.contentproviders.TreeExecutionConditionContentProvider;
import org.isistan.flabot.executionstatemapping.dialogs.utils.labelproviders.TreeExecutionConditionLabelProvider;
import org.isistan.flabot.executionstatemapping.editor.StateEditor;
import org.isistan.flabot.executionstatemapping.editor.figures.StateFigure;
import org.isistan.flabot.executionstatemapping.messages.Messages;
import org.isistan.flabot.executionstatemapping.model.ExecutionStateMappingFileModel;
import org.isistan.flabot.executionstatemapping.model.ModelPackage;
import org.isistan.flabot.executionstatemapping.model.semantic.ExecutionCondition;
import org.isistan.flabot.executionstatemapping.model.semantic.MappedTreeStructuredElement;
import org.isistan.flabot.executionstatemapping.model.semantic.SemanticFactory;
import org.isistan.flabot.executionstatemapping.model.semantic.SemanticPackage;
import org.isistan.flabot.executionstatemapping.model.semantic.State;
import org.isistan.flabot.executionstatemapping.model.semantic.StateContainer;
import org.isistan.flabot.executionstatemapping.model.semantic.StateType;
import org.isistan.flabot.executionstatemapping.model.semantic.TreeStructuredElement;
import org.isistan.flabot.executionstatemapping.model.semantic.TreeType;
import org.isistan.flabot.executionstatemapping.model.visual.StateDiagram;
import org.isistan.flabot.executionstatemapping.model.visual.VisualFactory;
import org.isistan.flabot.executionstatemapping.utils.CommandUtils;
import org.isistan.flabot.executionstatemapping.view.dnd.TreeStructuredElementDrag;
import org.isistan.flabot.executionstatemapping.view.dnd.TreeStructuredElementDrop;

public class ExecutionConditionViewPage implements IPageBookViewPage, Adapter {

	private TreeViewer viewer;

	private IPageSite site;

	private FlabotMultiPageEditor editor;

	private List<StateDiagram> stateDiagramsList;
	
	private TreeStructuredElement stateContainersTree;

	private TreeStructuredElement generalExecutionConditionsTree;
	
	private MappedTreeStructuredElement methodExecutionConditionsTree;
	
	private ExecutionStateMappingFileModel executionStateMappingFileModel;
	
	private Action editAction;
	
	private Action removeAction;
	
	private Action addFolderAction;
	
	private Action sortTreeElementsAction;
	
	private Action addMethodExecutionConditionAction;
	
	private Action addGeneralExecutionConditionAction;
	
	private Action addStateDiagramAction;
	
	private TreeStructuredElement selectedTreeStructuredElement;
	
	/**
	 * Instantiates the SequenceViewPage with and an ExecutionInfoManager.
	 */
	public ExecutionConditionViewPage(FlabotMultiPageEditor editor) {
		this.editor = editor;

		executionStateMappingFileModel = InterfacePluginExecutionStateMapping
				.getFileModel(editor);
		
		stateDiagramsList = InterfacePluginExecutionStateMapping.getStateDiagramsList(editor);
		stateContainersTree = executionStateMappingFileModel.getStateContainersTree();
		methodExecutionConditionsTree = executionStateMappingFileModel.getMethodExecutionConditionsTree();		
		generalExecutionConditionsTree = executionStateMappingFileModel.getGeneralExecutionConditionsTree();
		
		activate();
	}
	
	private void createNewStateDiagram() {
		InputDialog dlg = new InputDialog(
				Display.getCurrent().getActiveShell(),
				Messages
						.getString("org.isistan.flabot.edit.editor.actions.CreateComponentDiagramAction.dialogName"), //$NON-NLS-1$
				Messages
						.getString("org.isistan.flabot.edit.editor.actions.CreateComponentDiagramAction.dialogDescription"), //$NON-NLS-1$
				"", //$NON-NLS-1$
				null); // This is an optional validation class
		dlg.open();

		if (dlg.getReturnCode() == Window.OK) {
			// Creates a new State Diagram
			StateDiagram stateDiagram = VisualFactory.eINSTANCE.createStateDiagram();
			stateDiagram.setName(dlg.getValue());

			NodeVisualModel visual = EditormodelFactory.eINSTANCE
					.createNodeVisualModel();
			State state = SemanticFactory.eINSTANCE.createState();
			state.setName(Messages.getString("org.isistan.flabot.executionmapping.view.ExecutionConditionViewPage.state0")); //$NON-NLS-1$
			state.setStateType(StateType.INITIAL);
			visual.setSemanticModel(state);
			visual.setSize(Util.getDimension(StateFigure.defaultsize));
			visual.setLocation(Util.getPoint(10, 10));
			visual.setDiagram(stateDiagram);

			StateContainer stateContainer = SemanticFactory.eINSTANCE
					.createStateContainer();
			stateContainer.setName(stateDiagram.getName());
			stateContainer.getStates().add(state);
			stateContainer.getInicialStates().add(state);
			stateDiagram.setSemanticModel(stateContainer);

			createEditor(stateDiagram);
			
			CompoundCommand commands = new CompoundCommand();
			commands.setLabel(Messages.getString("org.isistan.flabot.executionmapping.view.ExecutionConditionViewPage.addStateDiagram")); //$NON-NLS-1$
			commands.add(new ManagePersistentTreeElementCommand(stateContainersTree, stateContainer, true));
			commands.add(new ManageStateDiagramCommand(stateDiagramsList, stateDiagram, true));
			appendToLastAndExecuteCommand(commands);
		}
	}

	private void createEditor(StateDiagram stateDiagram) {
		if (stateDiagram != null)
		{
			StateEditor stateEditor = new StateEditor(editor);
			stateEditor.setModel(stateDiagram);
	
			editor.addEditorPage(stateEditor, ImageDescriptor.createFromFile(
					ExecutionConditionPlugin.class, "icons/stateeditor.gif") //$NON-NLS-1$
					.createImage(), stateDiagram.getName(), stateDiagram);
			editor.openDiagram(stateDiagram);
		}
	}

	private void removeStateDiagram(StateDiagram selectedStateDiagram) {
		if (selectedStateDiagram != null) {
			if(CommandUtils.countReferences(selectedStateDiagram.getSemanticModel(), editor.getResourceSet()) > 2)
			{
				MessageDialog
				.openError(Display.getCurrent().getActiveShell(),
						Messages.getString("org.isistan.flabot.executionmapping.view.ExecutionConditionViewPage.diagramReferenceErrorTitle"), //$NON-NLS-1$
						Messages.getString("org.isistan.flabot.executionmapping.view.ExecutionConditionViewPage.diagramReferenceErrorMsg")); //$NON-NLS-1$
				return;
			}
			
			if (MessageDialog.openConfirm(
					Display.getCurrent().getActiveShell(), Messages.getString("org.isistan.flabot.executionmapping.view.ExecutionConditionViewPage.deleteDiagramConfirmationTitle"), //$NON-NLS-1$
					Messages.getString("org.isistan.flabot.executionmapping.view.ExecutionConditionViewPage.deleteDiagramConfirmationQtn"))) { //$NON-NLS-1$
								
				editor.closeDiagram(selectedStateDiagram);
				
				CompoundCommand commands = new CompoundCommand();
				commands.setLabel(Messages.getString("org.isistan.flabot.executionmapping.view.ExecutionConditionViewPage.deleteStateDiagram")); //$NON-NLS-1$
				StateContainer stateContainer = (StateContainer) selectedStateDiagram.getSemanticModel();
				commands.add(new ManagePersistentTreeElementCommand(stateContainer.getParent(), stateContainer, false));
				commands.add(new ManageStateDiagramCommand(stateDiagramsList, selectedStateDiagram, false));
				appendToLastAndExecuteCommand(commands);
			}
		}
	}
	
	public void editExecutionConditionAction(ExecutionCondition selectedExecutionCondition) 
	{
		if (selectedExecutionCondition != null) 
		{			
			appendToLastAndExecuteCommand(ExecutionConditionEditorBuilder.showEditExecutionConditionDialog(selectedExecutionCondition, executionStateMappingFileModel));
		}
	}

	private boolean canRemoveExecutionCondition(ExecutionCondition executionCondition)
	{
		if (executionCondition.isMethodExecutionCondition())
		{
			return CommandUtils.hasReferences(executionCondition, editor.getResourceSet());
		}
		else
		{
			return CommandUtils.countReferences(executionCondition, editor.getResourceSet()) > 1;
		}
	}
	
	public void removeExecutionConditionAction(ExecutionCondition selectedExecutionCondition) {
		if (selectedExecutionCondition != null) {
			if(canRemoveExecutionCondition(selectedExecutionCondition))
			{
				MessageDialog
				.openError(Display.getCurrent().getActiveShell(),
						Messages.getString("org.isistan.flabot.executionmapping.view.ExecutionConditionViewPage.conditionReferenceErrorTitle"), //$NON-NLS-1$
						Messages.getString("org.isistan.flabot.executionmapping.view.ExecutionConditionViewPage.conditionReferenceErrorMsg")); //$NON-NLS-1$
				return;
			}
			
			if (MessageDialog
					.openConfirm(Display.getCurrent().getActiveShell(),
							Messages.getString("org.isistan.flabot.executionmapping.view.ExecutionConditionViewPage.deleteExecutionConfirmationTitle"), //$NON-NLS-1$
							Messages.getString("org.isistan.flabot.executionmapping.view.ExecutionConditionViewPage.deleteExecutionConfirmationQtn")))  //$NON-NLS-1$
			{
				Command command;
				if (selectedExecutionCondition.isMethodExecutionCondition())
				{
					command = new ManageMethodExecutionConditionCommand(methodExecutionConditionsTree, selectedExecutionCondition);
				}
				else
				{
					command = new ManagePersistentTreeElementCommand(selectedExecutionCondition.getParent(), selectedExecutionCondition, false);					
				}
				appendToLastAndExecuteCommand(command);
			}
		}
	}

	protected void activate() 
	{
		executionStateMappingFileModel.eAdapters().add(this);
		
		methodExecutionConditionsTree.eAdapters().add(this);		
		//For each project		
		MappedTreeStructuredElement projectMap;
		for (TreeStructuredElement projectTree : methodExecutionConditionsTree
				.getPersistentList()) 
		{
			projectMap = (MappedTreeStructuredElement) projectTree;
			projectMap.eAdapters().add(this);
			
			//For each package root
			MappedTreeStructuredElement packageRootMap = null;						
			for (TreeStructuredElement packageRootTree : projectMap
					.getPersistentList()) 
			{
				packageRootMap = (MappedTreeStructuredElement) packageRootTree;
				packageRootMap.eAdapters().add(this);
				
				//For each Method Execution Condition
				ExecutionCondition executionCondition;
				for (TreeStructuredElement executionConditionElement : packageRootMap
						.getPersistentList()) 
				{
					
					executionCondition = (ExecutionCondition) executionConditionElement;
					executionCondition.eAdapters().add(this);
				}
			}
		}
		
		activateStructure(generalExecutionConditionsTree);
		activateStructure(stateContainersTree);
	}

	private void activateStructure(TreeStructuredElement treeStructuredElement)
	{
		treeStructuredElement.eAdapters().add(this);
		treeStructuredElement.getTreeStructuredElements().addAll(treeStructuredElement.getPersistentList());
		for(TreeStructuredElement treeChildElement : treeStructuredElement.getTreeStructuredElements())
		{
			activateStructure(treeChildElement);
		}
	}
	
	private void deactivateStructure(TreeStructuredElement treeStructuredElement)
	{
		treeStructuredElement.eAdapters().remove(this);
		treeStructuredElement.getTreeStructuredElements().addAll(treeStructuredElement.getPersistentList());
		for(TreeStructuredElement treeChildElement : treeStructuredElement.getTreeStructuredElements())
		{
			activateStructure(treeChildElement);
		}
	}
	
	protected void deactivate() 
	{
		executionStateMappingFileModel.eAdapters().remove(this);
		
		methodExecutionConditionsTree.eAdapters().remove(this);
		//For each project
		MappedTreeStructuredElement projectMap;
		for (TreeStructuredElement projectTree : methodExecutionConditionsTree
				.getPersistentList()) 
		{
			projectMap = (MappedTreeStructuredElement) projectTree;
			projectMap.eAdapters().remove(this);
			
			//For each package root
			MappedTreeStructuredElement packageRootMap = null;						
			for (TreeStructuredElement packageRootTree : projectMap
					.getPersistentList()) 
			{
				packageRootMap = (MappedTreeStructuredElement) packageRootTree;
				packageRootMap.eAdapters().remove(this);
				
				//For each Method Execution Condition
				ExecutionCondition executionCondition;
				for (TreeStructuredElement executionConditionElement : packageRootMap
						.getPersistentList()) 
				{
					
					executionCondition = (ExecutionCondition) executionConditionElement;
					executionCondition.eAdapters().remove(this);
				}
			}
		}
		
		deactivateStructure(generalExecutionConditionsTree);
		deactivateStructure(stateContainersTree);
	}

	protected TreeViewer getViewer() {
		return viewer;
	}

	/**
	 * Creates the SWT control for this page under the given parent control.
	 * Creates a viewer for the Sequence View, with a SequenceViewFactory.
	 */
	public void createControl(Composite parent) {
		viewer = new TreeViewer(parent);

		getViewer().setContentProvider(new TreeExecutionConditionContentProvider());
		getViewer().setLabelProvider(new TreeExecutionConditionLabelProvider());

		getViewer().getTree().addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				updateSelectedItems();
			}
		});

		getViewer().getTree().addMouseListener(new MouseAdapter() {

			@Override
			public void mouseDoubleClick(MouseEvent e) {
				handleEditAction();
			}
		});

		TreeStructuredElementDrag dragSupport = new TreeStructuredElementDrag(getViewer());
		TreeStructuredElementDrop dropSupport = new TreeStructuredElementDrop(editor.getCommandStack());
		
		viewer.addDragSupport(DND.DROP_MOVE, new Transfer[] {dragSupport.getTransfer()}, dragSupport);
		viewer.addDropSupport(DND.DROP_MOVE, new Transfer[] {dragSupport.getTransfer()}, dropSupport);
		
		createContextMenu();
		
		getViewer().setInput(new TreeStructuredElement[] {methodExecutionConditionsTree, generalExecutionConditionsTree, stateContainersTree});
	}

	private void editFolder(final TreeStructuredElement treeStructuredElement)
	{
		InputDialog dlg = new InputDialog(
				Display.getCurrent().getActiveShell(),
				"Rename folder", //$NON-NLS-1$
				"Please enter the new name", //$NON-NLS-1$
				treeStructuredElement.getName(), 
				null); // This is an optional validation class
		dlg.open();

		if (dlg.getReturnCode() == Window.OK) 
		{
			final String oldName = treeStructuredElement.getName();
			final String newName = dlg.getValue();
			Command editionCommand = new Command()
			{
				@Override
				public void execute()
				{
					redo();
				}
				
				@Override
				public void redo()
				{
					treeStructuredElement.setName(newName);
				}
				
				@Override
				public void undo()
				{
					treeStructuredElement.setName(oldName);
				}
			};
			editionCommand.setLabel(Messages.getString("org.isistan.flabot.executionmapping.view.ExecutionConditionViewPage.renameFolder")); //$NON-NLS-1$
			
			appendToLastAndExecuteCommand(editionCommand);
		}
	}
	
	private void removeFolder(TreeStructuredElement treeStructuredElement)
	{
		if (treeStructuredElement.getPersistentList().size() > 0)
		{
			MessageDialog
			.openError(Display.getCurrent().getActiveShell(),
					Messages.getString("org.isistan.flabot.executionmapping.view.ExecutionConditionViewPage.folderError"), //$NON-NLS-1$
					Messages.getString("org.isistan.flabot.executionmapping.view.ExecutionConditionViewPage.folderErrorMsg")); //$NON-NLS-1$
			return;
		}
		
		appendToLastAndExecuteCommand(new ManagePersistentTreeElementCommand(treeStructuredElement.getParent(), treeStructuredElement, false));
	}
	
	private void handleEditAction()
	{
		if (selectedTreeStructuredElement != null)
		{
			TreeType treeType = selectedTreeStructuredElement.getType();
			if (treeType == TreeType.EXECUTION_CONDITION_TYPE)
			{
				BusyIndicator.showWhile(Display.getCurrent(), new Runnable() {
					public void run() {
						editExecutionConditionAction( (ExecutionCondition) selectedTreeStructuredElement);
					}							
				});
			} 
			else if (treeType == TreeType.FOLDER_STATE_DIAGRAM_TYPE
					||treeType == TreeType.FOLDER_GENERAL_EXECUTION_CONDITION_TYPE)
			{
				editFolder(selectedTreeStructuredElement);
			}
			else if (treeType == TreeType.STATE_DIAGRAM_TYPE)
			{
				BusyIndicator.showWhile(Display.getCurrent(), new Runnable() {
					public void run() {
						StateDiagram selectedStateDiagram = getStateDiagramForStateContainer( (StateContainer) selectedTreeStructuredElement);
						if (editor.openDiagram(selectedStateDiagram) == -1) {
							createEditor(selectedStateDiagram);
						}
					}
				});
			}
		}
	}
	
	private void handleRemoveAction()
	{
		if (selectedTreeStructuredElement != null)
		{
			TreeType treeType = selectedTreeStructuredElement.getType();
			if (treeType == TreeType.EXECUTION_CONDITION_TYPE)
			{
				removeExecutionConditionAction((ExecutionCondition) selectedTreeStructuredElement);
			} 
			else if (treeType == TreeType.FOLDER_STATE_DIAGRAM_TYPE
					|| treeType == TreeType.FOLDER_GENERAL_EXECUTION_CONDITION_TYPE)
			{
				removeFolder(selectedTreeStructuredElement);
			}
			else if (treeType == TreeType.STATE_DIAGRAM_TYPE)
			{
				removeStateDiagram(getStateDiagramForStateContainer((StateContainer) selectedTreeStructuredElement));
			}
		}
	}
	
	private void handleAddNewFolder()
	{
		if (selectedTreeStructuredElement != null)
		{
			TreeType treeType = selectedTreeStructuredElement.getType();
			if (treeType == TreeType.FOLDER_STATE_DIAGRAM_TYPE
				|| treeType == TreeType.FOLDER_GENERAL_EXECUTION_CONDITION_TYPE)
			{
				InputDialog dlg = new InputDialog(
						Display.getCurrent().getActiveShell(),
						"Create New Sub Foder", //$NON-NLS-1$
						"Please enter a name", //$NON-NLS-1$
						"", //$NON-NLS-1$
						null); // This is an optional validation class
				dlg.open();

				if (dlg.getReturnCode() == Window.OK) 
				{				
					TreeStructuredElement treeFolderElement = SemanticFactory.eINSTANCE.createTreeStructuredElement();
					treeFolderElement.setType(treeType);
					treeFolderElement.setName(dlg.getValue());
					
					appendToLastAndExecuteCommand(new ManagePersistentTreeElementCommand(selectedTreeStructuredElement, treeFolderElement, true));
				}
			}
		}
	}
	
	private void updateSelectedItems() {
		TreeItem[] items = getViewer().getTree().getSelection();
		selectedTreeStructuredElement = null;

		addFolderAction.setEnabled(false);
		editAction.setEnabled(false);
		removeAction.setEnabled(false);

		if (items.length == 1) {
				selectedTreeStructuredElement = (TreeStructuredElement) items[0]
						.getData();
			
				TreeType selectedTreeType = selectedTreeStructuredElement.getType();
				editAction.setEnabled(selectedTreeType == TreeType.EXECUTION_CONDITION_TYPE
						|| selectedTreeType == TreeType.FOLDER_STATE_DIAGRAM_TYPE
						|| selectedTreeType == TreeType.FOLDER_GENERAL_EXECUTION_CONDITION_TYPE
						|| selectedTreeType == TreeType.STATE_DIAGRAM_TYPE);
				removeAction.setEnabled(selectedTreeType == TreeType.EXECUTION_CONDITION_TYPE
						||(( selectedTreeType == TreeType.FOLDER_STATE_DIAGRAM_TYPE
						|| selectedTreeType == TreeType.FOLDER_GENERAL_EXECUTION_CONDITION_TYPE) 
						&& selectedTreeStructuredElement.getParent() != null)
						|| selectedTreeType == TreeType.STATE_DIAGRAM_TYPE);
				addFolderAction.setEnabled(selectedTreeType == TreeType.FOLDER_STATE_DIAGRAM_TYPE
						|| selectedTreeType == TreeType.FOLDER_GENERAL_EXECUTION_CONDITION_TYPE);
				
				addMethodExecutionConditionAction.setEnabled((selectedTreeType == TreeType.EXECUTION_CONDITION_TYPE && !((ExecutionCondition)selectedTreeStructuredElement).isMethodExecutionCondition()) 
						|| selectedTreeType == TreeType.CONTAINER_TYPE
						|| selectedTreeType == TreeType.PROJECT_TYPE
						|| selectedTreeType == TreeType.PACKAGE_ROOT_TYPE
						|| selectedTreeType == TreeType.PACKAGE_TYPE
						|| selectedTreeType == TreeType.CLASS_TYPE);
				addGeneralExecutionConditionAction.setEnabled(selectedTreeType == TreeType.FOLDER_GENERAL_EXECUTION_CONDITION_TYPE 
						|| (selectedTreeType == TreeType.EXECUTION_CONDITION_TYPE && !((ExecutionCondition)selectedTreeStructuredElement).isMethodExecutionCondition()));
				addStateDiagramAction.setEnabled(selectedTreeType == TreeType.FOLDER_STATE_DIAGRAM_TYPE 
						|| selectedTreeType == TreeType.STATE_DIAGRAM_TYPE);
		}
	}

	/**
	 * Disposes of this page.
	 */	
	public void dispose() {
		deactivate();
	}

	/**
	 * Returns the SWT control for this page.
	 * 
	 * @return the SWT control for this page, or <code>null</code> if this
	 *         page does not have a control
	 */
	public Control getControl() {
		return getViewer().getControl();
	}
		
	protected void appendToLastAndExecuteCommand(Command command) 
	{
		if (command != null)
		{
			FlabotCommandStack commandStack = (FlabotCommandStack)editor.getCommandStack();
			commandStack.execute(command);
		}
	}
	
	private StateDiagram getStateDiagramForStateContainer(StateContainer stateContainer)
	{
		for(StateDiagram stateDiagram : stateDiagramsList)
		{
			if (stateDiagram.getSemanticModel() == stateContainer)
			{
				return stateDiagram;
			}
		}
		return null;
	}
	
	/**
	 * Action Bars
	 */
	public void setActionBars(IActionBars actionBars) {
		IToolBarManager manager = actionBars.getToolBarManager();
		
		final Action addExecutionConditionAction = new Action(
				Messages.getString("org.isistan.flabot.executionmapping.view.ExecutionConditionViewPage.add"), IAction.AS_DROP_DOWN_MENU) { //$NON-NLS-1$
			
			@Override
			public void run() {
			}
		};
		addExecutionConditionAction.setMenuCreator(new AddClassMenuCreator());
		addExecutionConditionAction.setToolTipText(Messages.getString("org.isistan.flabot.executionmapping.view.ExecutionConditionViewPage.addTreeElement")); //$NON-NLS-1$
		addExecutionConditionAction.setEnabled(true);
		addExecutionConditionAction.setImageDescriptor(ImageDescriptor.createFromFile(
						ExecutionConditionPlugin.class, "icons/add.gif")); //$NON-NLS-1$
		addExecutionConditionAction.setDisabledImageDescriptor(ImageDescriptor.createFromFile(
				ExecutionConditionPlugin.class, "icons/dis_add.png")); //$NON-NLS-1$
		addMethodExecutionConditionAction = new Action(
				Messages.getString("org.isistan.flabot.executionmapping.view.ExecutionConditionViewPage.methodExecutionCondition"), IAction.AS_PUSH_BUTTON) { //$NON-NLS-1$
			
			@Override
			public void run() 
			{
				appendToLastAndExecuteCommand(ExecutionConditionEditorBuilder.showNewMethodExecutionConditionDialog(null, executionStateMappingFileModel));
			}
		};
		addMethodExecutionConditionAction.setToolTipText(Messages.getString("org.isistan.flabot.executionmapping.view.ExecutionConditionViewPage.addNewMethod")); //$NON-NLS-1$
		
		addGeneralExecutionConditionAction = new Action(
				Messages.getString("org.isistan.flabot.executionmapping.view.ExecutionConditionViewPage.generalExecutionCondition"), IAction.AS_PUSH_BUTTON) { //$NON-NLS-1$
			
			@Override
			public void run() 
			{
				appendToLastAndExecuteCommand(ExecutionConditionEditorBuilder.showNewGeneralExecutionConditionDialog(executionStateMappingFileModel));
			}
		};
		addGeneralExecutionConditionAction.setToolTipText(Messages.getString("org.isistan.flabot.executionmapping.view.ExecutionConditionViewPage.addNewGeneral")); //$NON-NLS-1$
		
		addStateDiagramAction = new Action(
				Messages.getString("org.isistan.flabot.executionmapping.view.ExecutionConditionViewPage.stateDiagram"), IAction.AS_PUSH_BUTTON) { //$NON-NLS-1$
			
			@Override
			public void run() 
			{
				createNewStateDiagram();
			}
		};
		addStateDiagramAction.setToolTipText(Messages.getString("org.isistan.flabot.executionmapping.view.ExecutionConditionViewPage.addNewDiagram")); //$NON-NLS-1$
		
		addFolderAction = new Action(
				Messages.getString("org.isistan.flabot.executionmapping.view.ExecutionConditionViewPage.subFolder"), IAction.AS_PUSH_BUTTON) { //$NON-NLS-1$
			
			@Override
			public void run() 
			{
				handleAddNewFolder();
			}
		};
		addFolderAction.setToolTipText(Messages.getString("org.isistan.flabot.executionmapping.view.ExecutionConditionViewPage.addNewSubFolder")); //$NON-NLS-1$
		addFolderAction.setEnabled(false);		
		
		editAction = new Action(Messages.getString("org.isistan.flabot.executionmapping.view.ExecutionConditionViewPage.edit")) { //$NON-NLS-1$
			@Override
			public void run() {
				handleEditAction();
			}
		};
		editAction.setToolTipText(Messages.getString("org.isistan.flabot.executionmapping.view.ExecutionConditionViewPage.editTreeElement")); //$NON-NLS-1$
		editAction.setEnabled(false);
		editAction.setImageDescriptor(ImageDescriptor.createFromFile(
				ExecutionConditionPlugin.class, "icons/edit.gif")); //$NON-NLS-1$

		editAction.setDisabledImageDescriptor(ImageDescriptor.createFromFile(
				ExecutionConditionPlugin.class, "icons/dis_edit.png")); //$NON-NLS-1$

		
		removeAction = new Action(Messages.getString("org.isistan.flabot.executionmapping.view.ExecutionConditionViewPage.delete")) { //$NON-NLS-1$
			@Override
			public void run() {
				handleRemoveAction();
			}
		};
		removeAction.setToolTipText(Messages.getString("org.isistan.flabot.executionmapping.view.ExecutionConditionViewPage.deleteTreeElement")); //$NON-NLS-1$
		removeAction.setEnabled(true);
		removeAction.setImageDescriptor(ImageDescriptor.createFromFile(
				ExecutionConditionPlugin.class, "icons/delete.gif")); //$NON-NLS-1$
		removeAction.setDisabledImageDescriptor(ImageDescriptor.createFromFile(
				ExecutionConditionPlugin.class, "icons/dis_delete.png")); //$NON-NLS-1$

		final ViewerComparator sorter = new ViewerComparator() {
			@Override
			public int compare(Viewer iViewer, Object e1, Object e2) {
				if (e1 == null) {
					return -1;
				} else if (e2 == null) {
					return 1;
				} else {
					return ((TreeStructuredElement)e1).getName().compareToIgnoreCase(((TreeStructuredElement)e2).getName());
				}
			}
		};
		
		sortTreeElementsAction = new Action(Messages.getString("org.isistan.flabot.executionmapping.view.ExecutionConditionViewPage.sort"), IAction.AS_CHECK_BOX) { //$NON-NLS-1$
			@Override
			public void run() {
				ViewerComparator viewerComparator = null;
				if (sortTreeElementsAction.isChecked())
				{
					viewerComparator = sorter;
				}				
				getViewer().setComparator(viewerComparator);
			}
		};
		sortTreeElementsAction.setToolTipText(Messages.getString("org.isistan.flabot.executionmapping.view.ExecutionConditionViewPage.sortTreeView")); //$NON-NLS-1$
		sortTreeElementsAction.setEnabled(true);
		sortTreeElementsAction.setImageDescriptor(ImageDescriptor.createFromFile(
				ExecutionConditionPlugin.class, "icons/sort.gif")); //$NON-NLS-1$
		sortTreeElementsAction.setDisabledImageDescriptor(ImageDescriptor.createFromFile(
				ExecutionConditionPlugin.class, "icons/dis_sort.gif")); //$NON-NLS-1$

		
		manager.add(new Separator());
		manager.add(addExecutionConditionAction);
		manager.add(editAction);
		manager.add(removeAction);
		manager.add(new Separator());
		manager.add(sortTreeElementsAction);
		manager.add(new Separator());
		manager.add(new Separator());
		manager.add(new Separator());
		manager.add(new Separator());
		manager.add(new Separator());
		manager.add(new Separator());
	}
	
	/**
	 * Asks this page to take focus within its pagebook view.
	 */
	public void setFocus() {
		getViewer().getControl().setFocus();
	}

	public IPageSite getSite() {
		return site;
	}

	public void init(IPageSite site) {
		this.site = site;
	}

	private void createContextMenu() {
		// Create menu manager.
		MenuManager menuManager = new MenuManager();
		menuManager.setRemoveAllWhenShown(true);
		menuManager.addMenuListener(new IMenuListener() {
			public void menuAboutToShow(IMenuManager manager) 
			{
				fillContextMenu(manager);
			}
		});

		// Create menu.
		Menu menu = menuManager.createContextMenu(viewer.getControl());
		viewer.getControl().setMenu(menu);

		// Register menu for extension.
		getSite().registerContextMenu("MENU", menuManager, //$NON-NLS-1$
				null);
	}

	private void fillContextMenu(IMenuManager mgr) {
		mgr.add(new GroupMarker(IWorkbenchActionConstants.MB_ADDITIONS));
		
		MenuManager subMenu = new MenuManager(Messages.getString("org.isistan.flabot.executionmapping.view.ExecutionConditionViewPage.add")); //$NON-NLS-1$
		subMenu.add(addMethodExecutionConditionAction);
		subMenu.add(addGeneralExecutionConditionAction);
		subMenu.add(addStateDiagramAction);
		subMenu.add(addFolderAction);
		
		mgr.add(subMenu);
		mgr.add(editAction);
		mgr.add(removeAction);
	}

	class AddClassMenuCreator implements IMenuCreator {

		Menu activeMenu;

		public void dispose() {
			if (activeMenu != null)
			{
				activeMenu.dispose();
			}
		}

		public Menu getMenu(Control parent) {
			dispose();
			activeMenu = createMenu(parent);
			return activeMenu;
		}

		private Menu createMenu(Control parent) {
			Menu menu = new Menu(parent);
			MenuItem item;
			item = new MenuItem(menu, SWT.NONE);
			item.setText(Messages.getString("org.isistan.flabot.executionmapping.view.ExecutionConditionViewPage.methodExecutionCondition")); //$NON-NLS-1$
			item.addSelectionListener(new SelectionAdapter() 
			{	
				@Override
				public void widgetSelected(SelectionEvent e) {
					addMethodExecutionConditionAction.run();
				}
			});

			item = new MenuItem(menu, SWT.NONE);
			item.setText(Messages.getString("org.isistan.flabot.executionmapping.view.ExecutionConditionViewPage.generalExecutionCondition")); //$NON-NLS-1$
			item.addSelectionListener(new SelectionAdapter() 
			{
				@Override
				public void widgetSelected(SelectionEvent e) {					
					addGeneralExecutionConditionAction.run();
				}
			});

			item = new MenuItem(menu, SWT.NONE);
			item.setText(Messages.getString("org.isistan.flabot.executionmapping.view.ExecutionConditionViewPage.stateDiagram")); //$NON-NLS-1$
			item.addSelectionListener(new SelectionAdapter() 
			{
				@Override
				public void widgetSelected(SelectionEvent e) {
					addStateDiagramAction.run();
				}
			});
			
			item = new MenuItem(menu, SWT.NONE);
			item.setText(Messages.getString("org.isistan.flabot.executionmapping.view.ExecutionConditionViewPage.subFolder")); //$NON-NLS-1$
			item.setEnabled(addFolderAction.isEnabled());
			item.addSelectionListener(new SelectionAdapter() 
			{
				@Override
				public void widgetSelected(SelectionEvent e) {
					addFolderAction.run();
				}
			});
			
			return menu;
		}
		
		public Menu getMenu(Menu parent) {
			return null;
		}
	}

	/**
	 * Adapter Listener
	 */
	
	private void internalNotifyChanged(Notification notification)
	{
		int featureID = notification.getFeatureID(SemanticPackage.class);
		int notificationType = notification.getEventType(); 
		
		if (featureID == SemanticPackage.TREE_STRUCTURED_ELEMENT__PERSISTENT_LIST)
		{		
			switch (notificationType) {
				case Notification.ADD:
				{
					TreeStructuredElement element = (TreeStructuredElement)	notification.getNewValue();
					element.eAdapters().add(this);
					getViewer().refresh();
					break;
				}
				case Notification.REMOVE:
				{
					TreeStructuredElement element = (TreeStructuredElement)	notification.getOldValue();
					element.eAdapters().remove(this);
					getViewer().refresh();
					break;
				}
			}
		}
		else if (featureID == SemanticPackage.TREE_STRUCTURED_ELEMENT__NAME)
		{		
			switch (notificationType) {
				case Notification.SET:
				{
					TreeStructuredElement element = (TreeStructuredElement)	notification.getNotifier();
					getViewer().update(element, null);				
				}
			}
		}
		
		featureID = notification.getFeatureID(ModelPackage.class);
		if (featureID == ModelPackage.EXECUTION_STATE_MAPPING_FILE_MODEL__STATE_DIAGRAMS_LIST)
		{
			switch (notificationType) {
				case Notification.REMOVE:
				{
					editor.closeDiagram((StateDiagram) notification.getOldValue());
				}
			}
		}
	}
	
	private Notifier target;
	
	public Notifier getTarget() 
	{
		return target;
	}

	public boolean isAdapterForType(Object type) 
	{
		return false;
	}

	public void notifyChanged(final Notification notification) 
	{
		Display.getCurrent().syncExec(
				new Runnable() 
				{
					public void run()
					{
						internalNotifyChanged(notification);
					}
				}
		);
	}

	public void setTarget(Notifier newTarget) 
	{
		target = newTarget;	
	}
}