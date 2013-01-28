package org.isistan.flabot.executionstatemapping.editor;

import org.eclipse.gef.tools.CreationTool;
import org.eclipse.swt.widgets.Display;
import org.isistan.flabot.executionstatemapping.commands.diagram.AddStateCommand;
import org.isistan.flabot.executionstatemapping.editor.dialogs.ChooseFinalStateValueDialog;
import org.isistan.flabot.executionstatemapping.editor.editparts.StateDiagramEditPart;
import org.isistan.flabot.executionstatemapping.messages.Messages;
import org.isistan.flabot.executionstatemapping.model.semantic.ExecutionStateValue;
import org.isistan.flabot.executionstatemapping.model.semantic.FinalState;

public class FinalStateCreationTool extends CreationTool {
	
	@Override
	protected void performCreation(int button) {
		if (getTargetEditPart() instanceof StateDiagramEditPart) 
		{
			ChooseFinalStateValueDialog dialog = new ChooseFinalStateValueDialog(Display.getCurrent().getActiveShell());
			ExecutionStateValue value = dialog.open(Messages.getString("org.isistan.flabot.edit.multipage.FlabotMultiPageEditorContributor.exportDiagramName.FinalStateCreationTool.chooseFinalState"), null); //$NON-NLS-1$
			if (value == null)
			{
				deactivate();
				setState(STATE_TERMINAL);
			}
			else
			{
				AddStateCommand command = (AddStateCommand) getCurrentCommand();
				((FinalState)command.getState()).setExecutionState(value);
				super.performCreation(button);
			}
		} 
		else
		{
			super.performCreation(button);
		}
	}
}