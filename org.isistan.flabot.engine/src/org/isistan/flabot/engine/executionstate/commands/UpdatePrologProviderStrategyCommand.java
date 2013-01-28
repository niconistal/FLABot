/**
 * $Id: UpdateStateDeterminationStrategyCommand.java,v 1.5 2006/03/08 00:41:16 mblech Exp $
 * $Author: mblech $
 */
package org.isistan.flabot.engine.executionstate.commands;

import org.eclipse.gef.commands.Command;
import org.isistan.flabot.coremodel.ConditionEvent;
import org.isistan.flabot.engine.executionstate.ExecutionStateManager;
import org.isistan.flabot.engine.executionstate.PrologProviderStrategy;

public class UpdatePrologProviderStrategyCommand extends Command {
	
	private ConditionEvent conditionEvent;
	private PrologProviderStrategy newStrategy;
	private PrologProviderStrategy oldStrategy;

	public UpdatePrologProviderStrategyCommand(ConditionEvent conditionEvent,
			PrologProviderStrategy newStrategy) {
		this.conditionEvent = conditionEvent;
		this.newStrategy = newStrategy;
		this.oldStrategy = ExecutionStateManager.getPrologProviderStrategy(conditionEvent);
		this.setLabel("Update event prolog provider strategy");
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gef.commands.Command#canExecute()
	 */
	@Override
	public boolean canExecute() {
		return newStrategy!=null && conditionEvent!=null;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gef.commands.Command#canUndo()
	 */
	@Override
	public boolean canUndo() {
		return oldStrategy != null && conditionEvent!=null;
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
		ExecutionStateManager.setPrologProviderStrategy(conditionEvent, newStrategy);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gef.commands.Command#undo()
	 */
	@Override
	public void undo() {
		ExecutionStateManager.setPrologProviderStrategy(conditionEvent, oldStrategy);
	}

}
