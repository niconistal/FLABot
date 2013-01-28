package org.isistan.flabot.executionstatemapping.dialogs.strategy;

import org.eclipse.gef.commands.Command;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.isistan.flabot.coremodel.ConditionEvent;
import org.isistan.flabot.engine.executionstate.PrologProviderStrategy;
import org.isistan.flabot.engine.executionstate.TraceInferenceStrategy;
import org.isistan.flabot.engine.executionstate.commands.UpdatePrologProviderStrategyCommand;
import org.isistan.flabot.engine.executionstate.dialogs.ChangeNotifier;
import org.isistan.flabot.engine.executionstate.dialogs.StrategyGUIFactory;
import org.isistan.flabot.executionstatemapping.messages.Messages;
import org.isistan.flabot.executionstatemapping.model.prolog.impl.EventTagProviderImpl;
import org.isistan.flabot.executionstatemapping.model.strategymodel.SimpleExecutionConditionTraceInferenceStrategy;
import org.isistan.flabot.executionstatemapping.model.strategymodel.StateDiagramTraceInferenceStrategy;
import org.isistan.flabot.executionstatemapping.model.strategymodel.StrategymodelFactory;
import org.isistan.flabot.util.edition.EditionItemStatus;

public class EventStrategyPrologProviderTabItem  implements StrategyGUIFactory<ConditionEvent, PrologProviderStrategy>   {
	
	private TraceInferenceStrategy  strategy;
	
	private ConditionEvent conditionEvent;
		
	private CompositeTabStrategy compositeTabStrategy;
	
	public void build(Composite c, ConditionEvent conditionEvent, PrologProviderStrategy strategy, ChangeNotifier changeNotifier) {
		
		this.conditionEvent=conditionEvent;
		this.compositeTabStrategy = null;
		
		if (conditionEvent.getName().trim().length() == 0)
		{
			new Label(c, SWT.NONE).setText(Messages.getString("org.isistan.flabot.engine.executionstate.dialogs.event.ConditionEventStrategyEditionItem.eventMustHaveAName")); //$NON-NLS-1$
		}
		else
		{
			if (strategy == null || !(strategy instanceof TraceInferenceStrategy) )
			{
				this.strategy = (TraceInferenceStrategy) createStrategy(conditionEvent);
			}
			else
			{
				this.strategy = (TraceInferenceStrategy) strategy;
			}
			
			compositeTabStrategy = new CompositeTabStrategy(false, null, null, null, new EventTagProviderImpl(conditionEvent.getName()));
			compositeTabStrategy.build(c, this.strategy);
		}
	}
			
	public Command getCommand() 
	{
		if (compositeTabStrategy != null)
		{
			return new UpdatePrologProviderStrategyCommand(conditionEvent, (PrologProviderStrategy) compositeTabStrategy.createStrategy());
		}
		return null;
	}
	
	public boolean canCreateCommand() {
		return getStatus().equals(EditionItemStatus.DEFAULT_OK);
	}
	
	public EditionItemStatus getStatus() 
	{
		if (compositeTabStrategy != null)
		{
			return compositeTabStrategy.validateTabStrategy();
		}
		return EditionItemStatus.DEFAULT_OK;
	}
	
	public String getStrategyName()
	{
		return Messages.getString("org.isistan.flabot.executionmapping.dialogs.strategy.EventStrategyPrologProviderTabItem.eventStrategy"); //$NON-NLS-1$
	}
	
	public void finishFactory()
	{
		if (compositeTabStrategy != null)
		{
			strategy = compositeTabStrategy.createStrategy();
		}
	}
	
	public PrologProviderStrategy createStrategy(ConditionEvent element) {		
		return StrategymodelFactory.eINSTANCE.createStateDiagramTraceInferenceStrategy();
	}
	
	public Class<PrologProviderStrategy> getReturnType() {
		return PrologProviderStrategy.class;
	}
	
	public boolean isAssignable(PrologProviderStrategy strategy)
	{
		return (strategy == null || strategy instanceof SimpleExecutionConditionTraceInferenceStrategy || strategy instanceof StateDiagramTraceInferenceStrategy);
	}	
}