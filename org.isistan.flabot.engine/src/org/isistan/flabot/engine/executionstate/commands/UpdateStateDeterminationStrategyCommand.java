/**
 * $Id: UpdateStateDeterminationStrategyCommand.java,v 1.5 2006/03/08 00:41:16 mblech Exp $
 * $Author: mblech $
 */
package org.isistan.flabot.engine.executionstate.commands;

import org.eclipse.gef.commands.Command;
import org.isistan.flabot.coremodel.Responsibility;
import org.isistan.flabot.engine.executionstate.ExecutionStateManager;
import org.isistan.flabot.engine.executionstate.StateDeterminationStrategy;

/**
 * Command that chages the state determination strategy that is registered
 * for a given responsibility node.
 * This initial implementation registers the given strategy to the
 * node's responsibility, but the user should be allowed to select more
 * fine-grained registrations.
 * TODO implement fine-grain strategy registration. 
 * @author $Author: mblech $
 *
 */
public class UpdateStateDeterminationStrategyCommand extends Command {
	
	private Responsibility responsibility;
	private StateDeterminationStrategy newStrategy;
	private StateDeterminationStrategy oldStrategy;

	public UpdateStateDeterminationStrategyCommand(Responsibility responsibility,
			StateDeterminationStrategy newStrategy) {
		this.responsibility = responsibility;
		this.newStrategy = newStrategy;
		this.oldStrategy = ExecutionStateManager.getStateDeterminationStrategy(responsibility);
		this.setLabel("Update responsibility state determination strategy");
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gef.commands.Command#canExecute()
	 */
	@Override
	public boolean canExecute() {
		return newStrategy!=null && responsibility!=null;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gef.commands.Command#canUndo()
	 */
	@Override
	public boolean canUndo() {
		return oldStrategy != null && responsibility!=null;
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
		ExecutionStateManager.setStateDeterminationStrategy(responsibility, newStrategy);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gef.commands.Command#undo()
	 */
	@Override
	public void undo() {
		ExecutionStateManager.setStateDeterminationStrategy(responsibility, oldStrategy);
	}

}
