/**
 * $Id: StateFromMappingStrategyGUIFactory.java,v 1.4 2006/04/08 04:15:41 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.engine.executionstate.dialogs;

import java.util.List;

import org.eclipse.gef.commands.Command;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.isistan.flabot.coremodel.Condition;
import org.isistan.flabot.coremodel.Responsibility;
import org.isistan.flabot.engine.executionstate.ExecutionstateFactory;
import org.isistan.flabot.engine.executionstate.StateDeterminationStrategy;
import org.isistan.flabot.engine.executionstate.StateFromMappingStateDeterminationStrategy;
import org.isistan.flabot.engine.messages.Messages;
import org.isistan.flabot.util.edition.EditionItemStatus;
import org.isistan.flabot.util.edition.SingleEditionItemStatus;

/**
 * GUI factory for the StateFromMapping strategy
 * @author mblech
 *
 */
public class StateFromMappingStrategyGUIFactory implements StrategyGUIFactory<Responsibility, StateDeterminationStrategy> {

	private Responsibility responsibility;

	/* (non-Javadoc)
	 * @see org.isistan.flabot.engine.executionstate.dialogs.StrategyGUIFactory#createStrategy(org.isistan.flabot.coremodel.Responsibility)
	 */
	public StateDeterminationStrategy createStrategy(Responsibility responsibility) {
		StateDeterminationStrategy strategy = ExecutionstateFactory.eINSTANCE.createStateFromMappingStateDeterminationStrategy();
		strategy.setResponsibility(responsibility);
		this.responsibility = responsibility;
		return strategy;
	}

	/* (non-Javadoc)
	 * @see org.isistan.flabot.engine.executionstate.dialogs.StrategyGUIFactory#build(org.eclipse.swt.widgets.Composite, java.lang.Object, org.isistan.flabot.engine.executionstate.dialogs.StateDeterminationStrategyEditionItem)
	 */
	public void build(Composite c, Responsibility responsibility, StateDeterminationStrategy strategy, ChangeNotifier changeNotifier) {
		c.setLayout(new RowLayout());
		new Label(c, SWT.NONE).setText(Messages.getString("org.isistan.flabot.engine.executionstate.dialogs.StateFromMappingStrategyGUIFactory.noConfigurationRequired")); //$NON-NLS-1$
	}

	/* (non-Javadoc)
	 * @see org.isistan.flabot.engine.executionstate.dialogs.StrategyGUIFactory#getStrategyName()
	 */
	public String getStrategyName() {
		return Messages.getString("org.isistan.flabot.engine.executionstate.dialogs.StateFromMappingStrategyGUIFactory.strategyName"); //$NON-NLS-1$
	}

	/* (non-Javadoc)
	 * @see org.isistan.flabot.engine.executionstate.dialogs.StrategyGUIFactory#getReturnType()
	 */
	public Class<StateFromMappingStateDeterminationStrategy> getReturnType() {
		return StateFromMappingStateDeterminationStrategy.class;
	}

	/* (non-Javadoc)
	 * @see org.isistan.flabot.engine.executionstate.dialogs.StrategyGUIFactory#getStatus()
	 */
	public EditionItemStatus getStatus() {
		if (responsibilityHasMapping())
			return EditionItemStatus.DEFAULT_OK;
		return new SingleEditionItemStatus(EditionItemStatus.Type.ERROR,
				Messages.getString("org.isistan.flabot.engine.executionstate.dialogs.StateFromMappingStrategyGUIFactory.error") + responsibility!=null?responsibility.getName():Messages.getString("org.isistan.flabot.engine.executionstate.dialogs.StateFromMappingStrategyGUIFactory.null")); //$NON-NLS-1$ //$NON-NLS-2$
	}

	/**
	 * Check if the responsibility has a mapping or not
	 * @return
	 */
	@SuppressWarnings("unchecked") //$NON-NLS-1$
	private boolean responsibilityHasMapping() {
		if (responsibility == null)
			return true;
		List<Condition> preconditions = (List<Condition>) responsibility.getPreconditions();
		for (Condition precondition: preconditions) {
			if (Condition.mappingCondition.equals(precondition.getType()))
				return true;
		}
		return false;
	}
	
	public void finishFactory() {
	}
	
	public boolean isAssignable(StateDeterminationStrategy strategy)
	{
		return (strategy instanceof StateFromMappingStateDeterminationStrategy);
	}
	
	public Command getCommand()
	{
		return null;
	}
}