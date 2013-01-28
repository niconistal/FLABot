/**
 * $Id: CreateComponentDiagramAction.java,v 1.3 2006/03/21 01:51:55 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.editor.actions;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CommandStack;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IWorkbenchPage;
import org.isistan.flabot.FlabotPlugin;
import org.isistan.flabot.edit.componentmodel.ComponentDiagram;
import org.isistan.flabot.edit.componentmodel.ComponentmodelFactory;
import org.isistan.flabot.edit.editor.commands.CreateComponentEditorCommand;
import org.isistan.flabot.edit.multipage.FlabotMultiPageEditor;
import org.isistan.flabot.messages.Messages;

/**
 * This action is used to create new Component Diagram.
 * 
 * @author $Author: franco $
 *
 */
public class CreateComponentDiagramAction extends Action {
	
	/**
	 * Action id
	 */
	public static final String
		NEW_COMPONENT_DIAGRAM = "New.Component.Diagram";  //$NON-NLS-1$
	
	private IWorkbenchPage page;

	/**
	 * Creates a new CreateComponentDiagramAction in the given workbench part
	 * @param part
	 */
	public CreateComponentDiagramAction(IWorkbenchPage page) {
		super();
		this.page = page;
		
		setText(Messages.getString("org.isistan.flabot.edit.editor.actions.CreateComponentDiagramAction.text")); //$NON-NLS-1$
		setToolTipText(Messages.getString("org.isistan.flabot.edit.editor.actions.CreateComponentDiagramAction.toolTipText")); //$NON-NLS-1$
		setId(NEW_COMPONENT_DIAGRAM);
		
		setImageDescriptor(ImageDescriptor.createFromFile(FlabotPlugin.class, "icons/cd.gif"));		 //$NON-NLS-1$
	}
	
	/**
	 * Determines whether the action should be enabled or not.
	 * @return true
	 */
	@Override
	public boolean isEnabled() {
		return true;
	}
	
	/**
	 * Opens a dialog for the user to give a name for the Component Diagram, then
	 * creates a command that executes the creation. 
	 * 
	 * @return the created command
	 */
	public Command getCommand() {		
		FlabotMultiPageEditor flabotEditor = (FlabotMultiPageEditor) page.getActiveEditor();
		InputDialog dlg = new InputDialog(
				Display.getCurrent().getActiveShell(),
				Messages.getString("org.isistan.flabot.edit.editor.actions.CreateComponentDiagramAction.dialogName"), //$NON-NLS-1$
				Messages.getString("org.isistan.flabot.edit.editor.actions.CreateComponentDiagramAction.dialogDescription"), //$NON-NLS-1$
				"", //$NON-NLS-1$
				null); //This is an optional validation class
		dlg.open();

		if(dlg.getReturnCode()==Window.OK) {
			ComponentDiagram diagram = ComponentmodelFactory.eINSTANCE.createComponentDiagram();
			diagram.setName(dlg.getValue());
			diagram.setCoreModel(flabotEditor.getModel().getCoreModel());
			return new CreateComponentEditorCommand(flabotEditor, diagram);
		}		
		return null;
	}
	
	/**
	 * Shows an edition dialog, creates a command and then executes it.
	 */
	@Override
	public void run() {
		CommandStack commandStack = (CommandStack)page.getActiveEditor().getAdapter(CommandStack.class);
		commandStack.execute(getCommand());
	}
}