/**
 * $Id: TraceStrategyGUIFactory.java,v 1.14 2006/04/08 04:15:41 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.engine.executionstate.dialogs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.gef.commands.Command;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.isistan.flabot.coremodel.Responsibility;
import org.isistan.flabot.engine.executionstate.ExecutionstateFactory;
import org.isistan.flabot.engine.executionstate.StateDeterminationStrategy;
import org.isistan.flabot.engine.executionstate.TraceBasedStateDeterminationStrategy;
import org.isistan.flabot.engine.executionstate.TraceInferenceStrategy;
import org.isistan.flabot.engine.executionstate.dialogs.conditions.PredefinedCondition;
import org.isistan.flabot.engine.executionstate.dialogs.conditions.predefined.FixedStateDefault;
import org.isistan.flabot.engine.executionstate.dialogs.conditions.predefined.ResponsibilityObjectSnapshot;
import org.isistan.flabot.engine.executionstate.dialogs.conditions.predefined.ResponsibilityPreviousScope;
import org.isistan.flabot.engine.executionstate.dialogs.conditions.predefined.VariableStateOnAnyTag;
import org.isistan.flabot.engine.executionstate.dialogs.conditions.predefined.VariableStateOnCustomTag;
import org.isistan.flabot.engine.executionstate.dialogs.conditions.predefined.VariableStateOnError;
import org.isistan.flabot.engine.executionstate.dialogs.prolog.PrologEditComposite;
import org.isistan.flabot.engine.executionstate.javalogtrace.JavalogTraceInferenceStrategy;
import org.isistan.flabot.engine.executionstate.javalogtrace.JavalogtraceFactory;
import org.isistan.flabot.engine.messages.Messages;
import org.isistan.flabot.util.edition.EditionItemStatus;
import org.isistan.flabot.util.edition.SingleEditionItemStatus;

/**
 * Config GUI builder for TraceBasedStateDeterminationStrategy
 * @author $Author: franco $
 *
 */
public class TraceStrategyGUIFactory implements StrategyGUIFactory<Responsibility, StateDeterminationStrategy> {
		
	private PrologEditComposite prologComposite;		
	
	private static Map<String, List<PredefinedCondition>> conditions;
	
	private TraceBasedStateDeterminationStrategy traceStrategy;
	
	private JavalogTraceInferenceStrategy javalogInferenceStrategy;	
	
	private static Map<String, List<PredefinedCondition>> getConditions() {
		if (conditions == null)
			conditions = createConditionMap();
		return conditions;		
	}
	
	private static Map<String, List<PredefinedCondition>> createConditionMap() {
		Map<String, List<PredefinedCondition>> conditions = new HashMap<String, List<PredefinedCondition>>();
		
		List<PredefinedCondition> conds = new ArrayList<PredefinedCondition>();
		conds.add(new VariableStateOnError("Faulty")); //$NON-NLS-1$
		conds.add(new FixedStateDefault("Faulty")); //$NON-NLS-1$
		conds.add(new VariableStateOnAnyTag("Faulty")); //$NON-NLS-1$
		conds.add(new VariableStateOnCustomTag("Faulty")); //$NON-NLS-1$
		conditions.put(Messages.getString("org.isistan.flabot.engine.executionstate.dialogs.TraceStrategyGUIFactory.faulty"), conds); //$NON-NLS-1$
			
		conds = new ArrayList<PredefinedCondition>();
		conds.add(new VariableStateOnError("Executed")); //$NON-NLS-1$
		conds.add(new FixedStateDefault("Executed")); //$NON-NLS-1$
		conds.add(new VariableStateOnAnyTag("Executed")); //$NON-NLS-1$
		conds.add(new VariableStateOnCustomTag("Executed")); //$NON-NLS-1$
		conditions.put(Messages.getString("org.isistan.flabot.engine.executionstate.dialogs.TraceStrategyGUIFactory.executed"), conds); //$NON-NLS-1$
		
		conds = new ArrayList<PredefinedCondition>();
		conds.add(new VariableStateOnError("NotExecuted")); //$NON-NLS-1$
		conds.add(new FixedStateDefault("NotExecuted")); //$NON-NLS-1$
		conds.add(new VariableStateOnAnyTag("NotExecuted")); //$NON-NLS-1$
		conds.add(new VariableStateOnCustomTag("NotExecuted")); //$NON-NLS-1$
		conditions.put(Messages.getString("org.isistan.flabot.engine.executionstate.dialogs.TraceStrategyGUIFactory.notExecuted"), conds); //$NON-NLS-1$

		conds = new ArrayList<PredefinedCondition>();
		conds.add(new ResponsibilityObjectSnapshot());
		conds.add(new ResponsibilityPreviousScope());
		conditions.put(Messages.getString("org.isistan.flabot.engine.executionstate.dialogs.TraceStrategyGUIFactory.filtered"), conds); //$NON-NLS-1$
		
		return conditions;
	}
		
	/* (non-Javadoc)
	 * @see org.isistan.flabot.engine.executionstate.dialogs.ConfigGUIBuilder#build(org.eclipse.swt.widgets.Composite)
	 */
	public void build(Composite c, Responsibility responsibility, StateDeterminationStrategy strategy, ChangeNotifier changeNotifier) {				
		c.setLayout(new GridLayout(2, false));
		
		if (strategy == null ||
				!(strategy instanceof TraceBasedStateDeterminationStrategy)) {
			new Label(c, SWT.NONE).setText(Messages.getString("org.isistan.flabot.engine.executionstate.dialogs.TraceStrategyGUIFactory.wrongStrategy")); //$NON-NLS-1$
			return;
		}
		
		traceStrategy =	(TraceBasedStateDeterminationStrategy) strategy;
		javalogInferenceStrategy = (JavalogTraceInferenceStrategy) traceStrategy.getTraceInferenceStrategy(); 
		if (javalogInferenceStrategy == null) {
			javalogInferenceStrategy = JavalogtraceFactory.eINSTANCE.createJavalogTraceInferenceStrategy();
			traceStrategy.setTraceInferenceStrategy(javalogInferenceStrategy);
		}
		
		new Label(c, SWT.NONE).setText(Messages.getString("org.isistan.flabot.engine.executionstate.dialogs.TraceStrategyGUIFactory.prologCode")); //$NON-NLS-1$
		prologComposite = new PrologEditComposite(c, SWT.NONE, getConditions());
		prologComposite.setText(javalogInferenceStrategy.getPrologCode());	
		prologComposite.pack();		
	}
		
	public void finishFactory() 
	{
		traceStrategy.setTraceInferenceStrategy(javalogInferenceStrategy);		
		javalogInferenceStrategy.setPrologCode(prologComposite.getText());
	}
	
	public StateDeterminationStrategy createStrategy(Responsibility responsibility) {
		TraceBasedStateDeterminationStrategy traceStrategy = ExecutionstateFactory.eINSTANCE.createTraceBasedStateDeterminationStrategy();
		TraceInferenceStrategy inferenceStrategy = JavalogtraceFactory.eINSTANCE.createJavalogTraceInferenceStrategy();
		traceStrategy.setTraceInferenceStrategy(inferenceStrategy);
		traceStrategy.setResponsibility(responsibility);
		return traceStrategy;
	}

	public String getStrategyName() {
		return Messages.getString("org.isistan.flabot.engine.executionstate.dialogs.TraceStrategyGUIFactory.strategyName"); //$NON-NLS-1$
	}

	public Class<TraceBasedStateDeterminationStrategy> getReturnType() {
		return TraceBasedStateDeterminationStrategy.class;
	}

	public EditionItemStatus getStatus() {
		String diagnostic = prologComposite.validatePrologCode();
		if (diagnostic == null)
			return EditionItemStatus.DEFAULT_OK;
		return new SingleEditionItemStatus(EditionItemStatus.Type.ERROR,
				Messages.getString("org.isistan.flabot.engine.executionstate.dialogs.TraceStrategyGUIFactory.errorInPrologCode") + diagnostic); //$NON-NLS-1$
	}
	
	public boolean isAssignable(StateDeterminationStrategy strategy)
	{
		if (strategy instanceof TraceBasedStateDeterminationStrategy)
		{
			return ((TraceBasedStateDeterminationStrategy) strategy).getTraceInferenceStrategy() == null || ((TraceBasedStateDeterminationStrategy) strategy).getTraceInferenceStrategy() instanceof JavalogTraceInferenceStrategy;
		}
		return false; 
	}	
	
	public Command getCommand()
	{
		return null;
	}
}