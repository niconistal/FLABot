/**
 * $Id: ManualStrategyGUIFactory.java,v 1.8 2006/04/08 04:15:41 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.engine.executionstate.dialogs;

import org.eclipse.gef.commands.Command;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.isistan.flabot.coremodel.Responsibility;
import org.isistan.flabot.engine.executionstate.ExecutionstateFactory;
import org.isistan.flabot.engine.executionstate.ManualStateDeterminationStrategy;
import org.isistan.flabot.engine.executionstate.StateDeterminationStrategy;
import org.isistan.flabot.engine.messages.Messages;
import org.isistan.flabot.util.edition.EditionItemStatus;

/**
 * GUI factory for ManualTraceInferenceStrategy
 * @author $Author: franco $
 *
 */
public class ManualStrategyGUIFactory implements StrategyGUIFactory<Responsibility, StateDeterminationStrategy> {

	/* (non-Javadoc)
	 * @see org.isistan.flabot.engine.executionstate.dialogs.StrategyGUIFactory#createStrategy()
	 */
	public StateDeterminationStrategy createStrategy(Responsibility element) {
		return ExecutionstateFactory.eINSTANCE.createManualStateDeterminationStrategy();
	}

	/* (non-Javadoc)
	 * @see org.isistan.flabot.engine.executionstate.dialogs.StrategyGUIFactory#build(org.eclipse.swt.widgets.Composite)
	 */
	public void build(Composite c, Responsibility responsibility, StateDeterminationStrategy strategy, ChangeNotifier changeListener) {
		c.setLayout(new RowLayout());
		new Label(c, SWT.NONE).setText(Messages.getString("org.isistan.flabot.engine.executionstate.dialogs.ManualStrategyGUIFactory.noConfigurationRequired")); //$NON-NLS-1$
	}

	/* (non-Javadoc)
	 * @see org.isistan.flabot.engine.executionstate.dialogs.StrategyGUIFactory#getStrategyName()
	 */
	public String getStrategyName() {
		return Messages.getString("org.isistan.flabot.engine.executionstate.dialogs.ManualStrategyGUIFactory.strategyName"); //$NON-NLS-1$
	}

	/* (non-Javadoc)
	 * @see org.isistan.flabot.engine.executionstate.dialogs.StrategyGUIFactory#getReturnType()
	 */
	public Class<ManualStateDeterminationStrategy> getReturnType() {
		return ManualStateDeterminationStrategy.class;
	}

	public EditionItemStatus getStatus() {
		return EditionItemStatus.DEFAULT_OK;
	}
	
	public void finishFactory() {
	}
	
	public boolean isAssignable(StateDeterminationStrategy strategy)
	{
		return (strategy instanceof ManualStateDeterminationStrategy);
	}
	
	public Command getCommand()
	{
		return null;
	}
}