/** * $Id: ResetAction.java,v 1.12 2006/04/04 03:29:05 franco Exp $ * $Author: franco $ */package org.isistan.flabot.edit.ucmeditor.actions;

import org.eclipse.gef.commands.Command;import org.eclipse.gef.ui.actions.SelectionAction;import org.eclipse.swt.widgets.Display;import org.eclipse.ui.IWorkbenchPart;import org.isistan.flabot.edit.editor.CommandExecutor;import org.isistan.flabot.edit.editor.FlabotGraphicalEditor;import org.isistan.flabot.edit.editor.commands.NotifierCommandWrapper;import org.isistan.flabot.edit.editor.dialogs.StandardEditionDialog;import org.isistan.flabot.edit.editormodel.FlabotFileModel;import org.isistan.flabot.edit.multipage.FlabotMultiPageEditor;import org.isistan.flabot.engine.executionstate.dialogs.generallog.GeneralLogFilterStrategyEditionItem;import org.isistan.flabot.engine.messages.Messages;import org.isistan.flabot.util.edition.tab.EditionTabItem;/** * Action that resets the fault location engine * @author usuario * */public class GeneralLogFilterAction extends SelectionAction{
	
	public static final String
		GENERAL_LOG_FILTER = "GENERAL_LOG_FILTER";   //$NON-NLS-1$

	public GeneralLogFilterAction(IWorkbenchPart part) {
		super(part);

		setText(Messages.getString("org.isistan.flabot.edit.ucmeditor.actions.GeneralLogFilterAction.text")); //$NON-NLS-1$
		setId(GENERAL_LOG_FILTER);
	}	
	
	@Override	protected boolean calculateEnabled() {
		return canPerformAction();
	}
		/**	 * Check whether the action can be performed or not	 * @return	 */
	private boolean canPerformAction() {
		return true;
	}		@SuppressWarnings("unchecked")	private Command getCommand()	{			StandardEditionDialog<FlabotFileModel> dialog =			new StandardEditionDialog<FlabotFileModel>(					Display.getCurrent().getActiveShell(),					Messages.getString("org.isistan.flabot.edit.ucmeditor.actions.GeneralLogFilterAction.title"), //$NON-NLS-1$					Messages.getString("org.isistan.flabot.edit.ucmeditor.actions.GeneralLogFilterAction.dialogCommandLabel"), //$NON-NLS-1$					new EditionTabItem[] {						new GeneralLogFilterStrategyEditionItem()});				FlabotMultiPageEditor editor = (FlabotMultiPageEditor) ((FlabotGraphicalEditor)getWorkbenchPart()).getParent();		return dialog.open(editor.getModel());			}		/**	 * Shows an edition dialog, creates a command and then executes it.	 */	@Override	public void run() {		Command command = getCommand();		if (command != null) {			command = new NotifierCommandWrapper(command,					getWorkbenchPart().getSite().getShell());			CommandExecutor commandExecutor = (CommandExecutor)getWorkbenchPart().getAdapter(CommandExecutor.class);			commandExecutor.executeCommand(command, false);		}	}
}