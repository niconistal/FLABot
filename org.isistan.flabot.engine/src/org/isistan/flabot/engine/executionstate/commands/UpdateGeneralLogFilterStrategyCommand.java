/**
 * $Id: UpdateStateDeterminationStrategyCommand.java,v 1.5 2006/03/08 00:41:16 mblech Exp $
 * $Author: mblech $
 */
package org.isistan.flabot.engine.executionstate.commands;

import org.eclipse.gef.commands.Command;
import org.isistan.flabot.edit.editormodel.FlabotFileModel;
import org.isistan.flabot.engine.executionstate.ExecutionStateManager;
import org.isistan.flabot.engine.executionstate.GeneralLogFilterStrategy;

public class UpdateGeneralLogFilterStrategyCommand extends Command {
	
	private FlabotFileModel flabotFileModel;
	private GeneralLogFilterStrategy newStrategy;
	private GeneralLogFilterStrategy oldStrategy;

	public UpdateGeneralLogFilterStrategyCommand(FlabotFileModel flabotFileModel,
			GeneralLogFilterStrategy newStrategy) {
		this.flabotFileModel = flabotFileModel;
		this.newStrategy = newStrategy;
		this.oldStrategy = ExecutionStateManager.getGeneralLogFilterStrategy(flabotFileModel);
		this.setLabel("Update general log filter strategy");
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gef.commands.Command#canExecute()
	 */
	@Override
	public boolean canExecute() {
		return newStrategy!=null && flabotFileModel!=null;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gef.commands.Command#canUndo()
	 */
	@Override
	public boolean canUndo() {
		return oldStrategy != null && flabotFileModel!=null;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gef.commands.Command#execute()
	 */
	@Override
	public void execute() {
		redo();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gef.commands.Command#redo()
	 */
	@Override
	public void redo() {
		ExecutionStateManager.setGeneralLogFilterStrategy(flabotFileModel, newStrategy);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gef.commands.Command#undo()
	 */
	@Override
	public void undo() {
		ExecutionStateManager.setGeneralLogFilterStrategy(flabotFileModel, oldStrategy);
	}

}
