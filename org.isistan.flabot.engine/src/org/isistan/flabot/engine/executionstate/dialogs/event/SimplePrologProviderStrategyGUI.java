/**
 * $Id: ConditionEventStrategyEditionItem.java,v 1.4 2006/04/11 23:32:10 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.engine.executionstate.dialogs.event;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.isistan.flabot.coremodel.ConditionEvent;
import org.isistan.flabot.edit.ucmeditor.commands.model.ModifyPrologCodeConditionEventCommand;
import org.isistan.flabot.engine.executionstate.ExecutionstateFactory;
import org.isistan.flabot.engine.executionstate.PrologProviderStrategy;
import org.isistan.flabot.engine.executionstate.SimplePrologProviderStrategy;
import org.isistan.flabot.engine.executionstate.commands.UpdatePrologProviderStrategyCommand;
import org.isistan.flabot.engine.executionstate.dialogs.ChangeNotifier;
import org.isistan.flabot.engine.executionstate.dialogs.StrategyGUIFactory;
import org.isistan.flabot.engine.executionstate.dialogs.conditions.PredefinedCondition;
import org.isistan.flabot.engine.executionstate.dialogs.conditions.predefined.EventObjectSnapshot;
import org.isistan.flabot.engine.executionstate.dialogs.conditions.predefined.EventPreviousScope;
import org.isistan.flabot.engine.executionstate.dialogs.conditions.predefined.FixedStateDefault;
import org.isistan.flabot.engine.executionstate.dialogs.conditions.predefined.VariableStateOnAnyTag;
import org.isistan.flabot.engine.executionstate.dialogs.conditions.predefined.VariableStateOnCustomTag;
import org.isistan.flabot.engine.executionstate.dialogs.conditions.predefined.VariableStateOnError;
import org.isistan.flabot.engine.executionstate.dialogs.prolog.PrologEditComposite;
import org.isistan.flabot.engine.messages.Messages;
import org.isistan.flabot.util.edition.EditionItemStatus;
import org.isistan.flabot.util.edition.SingleEditionItemStatus;

/**
 * @author $Author: franco $
 *
 */
public class SimplePrologProviderStrategyGUI implements StrategyGUIFactory<ConditionEvent, PrologProviderStrategy> 
{	
	private PrologProviderStrategy strategy;
	
	private ConditionEvent conditionEvent;
	
	private PrologEditComposite prologComposite;
	
	public String getStrategyName()
	{
		return "Simple Prolog Strategy";
	}
	
	public void finishFactory()
	{
	}
	
	public PrologProviderStrategy createStrategy(ConditionEvent element) {
		return ExecutionstateFactory.eINSTANCE.createSimplePrologProviderStrategy();
	}
	
	public Class<SimplePrologProviderStrategy> getReturnType() {
		return SimplePrologProviderStrategy.class;
	}
	
	public boolean isAssignable(PrologProviderStrategy strategy)
	{
		return (strategy == null || strategy instanceof SimplePrologProviderStrategy);
	}
	
	/**
	 * This method initializes the tab's controsl
	 */
	public void build(Composite c, ConditionEvent condition, PrologProviderStrategy strategy, ChangeNotifier changeNotifier) {				
		c.setLayout(new GridLayout(2, false));
		
		// strategy configuration group	
		this.conditionEvent = condition;
		this.strategy = strategy;
		this.prologComposite = null;
			
		if (conditionEvent.getName().trim().length() == 0)
			new Label(c, SWT.NONE).setText(Messages.getString("org.isistan.flabot.engine.executionstate.dialogs.event.ConditionEventStrategyEditionItem.eventMustHaveAName")); //$NON-NLS-1$
		else {
			new Label(c, SWT.NONE).setText(Messages.getString("org.isistan.flabot.engine.executionstate.dialogs.event.ConditionEventStrategyEditionItem.prologCode")); //$NON-NLS-1$
			prologComposite = new PrologEditComposite(c, SWT.NONE, createConditionMap(conditionEvent.getName()));
			prologComposite.setText(conditionEvent.getConditionEvent());
			prologComposite.getPrologTextComponent().addFocusListener(new FocusAdapter(){
				public void focusLost(FocusEvent e) {
					conditionEvent.setConditionEvent(prologComposite.getText());
				}});
			prologComposite.pack();
		}
	}
	
	public Command getCommand() {
		CompoundCommand commands = new CompoundCommand();
		if (prologComposite != null)
		{
			commands.add(new ModifyPrologCodeConditionEventCommand(conditionEvent, prologComposite.getText()));
		}
		commands.add(new UpdatePrologProviderStrategyCommand(conditionEvent, strategy));
		return commands;
	}

	public EditionItemStatus getStatus() {
		if (prologComposite != null) {
			String diagnostic = prologComposite.validatePrologCode();
			if (diagnostic == null)
				return EditionItemStatus.DEFAULT_OK;
			return new SingleEditionItemStatus(EditionItemStatus.Type.ERROR,
					Messages.getString("org.isistan.flabot.engine.executionstate.dialogs.event.ConditionEventStrategyEditionItem.errorInPrologCode") + diagnostic); //$NON-NLS-1$
		}
		return EditionItemStatus.DEFAULT_OK;
	}
			
	private Map<String, List<PredefinedCondition>> createConditionMap(String eventName) {
		Map<String, List<PredefinedCondition>> conditions = new HashMap<String, List<PredefinedCondition>>();
		
		List<PredefinedCondition> conds = new ArrayList<PredefinedCondition>();
		conds.add(new VariableStateOnError(eventName, "Faulty")); //$NON-NLS-1$
		conds.add(new FixedStateDefault(eventName, "Faulty")); //$NON-NLS-1$
		conds.add(new VariableStateOnAnyTag(eventName, "Faulty")); //$NON-NLS-1$
		conds.add(new VariableStateOnCustomTag(eventName, "Faulty")); //$NON-NLS-1$
		conditions.put(Messages.getString("org.isistan.flabot.engine.executionstate.dialogs.event.ConditionEventStrategyEditionItem.faulty"), conds); //$NON-NLS-1$
			
		conds = new ArrayList<PredefinedCondition>();
		conds.add(new VariableStateOnError(eventName, "Executed")); //$NON-NLS-1$
		conds.add(new FixedStateDefault(eventName, "Executed")); //$NON-NLS-1$
		conds.add(new VariableStateOnAnyTag(eventName, "Executed")); //$NON-NLS-1$
		conds.add(new VariableStateOnCustomTag(eventName, "Executed")); //$NON-NLS-1$
		conditions.put(Messages.getString("org.isistan.flabot.engine.executionstate.dialogs.event.ConditionEventStrategyEditionItem.executed"), conds); //$NON-NLS-1$
		
		conds = new ArrayList<PredefinedCondition>();
		conds.add(new VariableStateOnError(eventName, "NotExecuted")); //$NON-NLS-1$
		conds.add(new FixedStateDefault(eventName, "NotExecuted")); //$NON-NLS-1$
		conds.add(new VariableStateOnAnyTag(eventName, "NotExecuted")); //$NON-NLS-1$
		conds.add(new VariableStateOnCustomTag(eventName, "NotExecuted")); //$NON-NLS-1$
		conditions.put(Messages.getString("org.isistan.flabot.engine.executionstate.dialogs.event.ConditionEventStrategyEditionItem.notExecuted"), conds); //$NON-NLS-1$

		conds = new ArrayList<PredefinedCondition>();
		conds.add(new EventObjectSnapshot(eventName));
		conds.add(new EventPreviousScope(eventName));		
		conditions.put(Messages.getString("org.isistan.flabot.engine.executionstate.dialogs.event.ConditionEventStrategyEditionItem.filtered"), conds); //$NON-NLS-1$
		
		return conditions;
	}
}