/**
 * $Id: ConditionEventStrategyEditionItem.java,v 1.4 2006/04/11 23:32:10 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.engine.executionstate.dialogs.generallog;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.gef.commands.Command;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.isistan.flabot.edit.editormodel.FlabotFileModel;
import org.isistan.flabot.engine.executionstate.ExecutionstateFactory;
import org.isistan.flabot.engine.executionstate.GeneralLogFilterStrategy;
import org.isistan.flabot.engine.executionstate.SimpleGeneralLogFilterStrategy;
import org.isistan.flabot.engine.executionstate.commands.UpdateGeneralLogFilterStrategyCommand;
import org.isistan.flabot.engine.executionstate.dialogs.ChangeNotifier;
import org.isistan.flabot.engine.executionstate.dialogs.StrategyGUIFactory;
import org.isistan.flabot.engine.executionstate.dialogs.conditions.PredefinedCondition;
import org.isistan.flabot.engine.executionstate.dialogs.conditions.predefined.GeneralLogObjectSnapshot;
import org.isistan.flabot.engine.executionstate.dialogs.prolog.PrologEditComposite;
import org.isistan.flabot.engine.messages.Messages;
import org.isistan.flabot.util.edition.EditionItemStatus;
import org.isistan.flabot.util.edition.SingleEditionItemStatus;

/**
 * @author $Author: franco $
 *
 */
public class SimpleGeneralLogFilterPrologProviderStrategyGUI implements StrategyGUIFactory<FlabotFileModel, GeneralLogFilterStrategy> 
{	
	private SimpleGeneralLogFilterStrategy strategy;
	
	private FlabotFileModel flabotFileModel;
	
	private PrologEditComposite prologComposite;
	
	private String prologCode;
	
	public String getStrategyName()
	{
		return "Simple General Log Filter Strategy";
	}
	
	public void finishFactory()
	{
		strategy.setPrologCodeText(prologCode);
	}
	
	public GeneralLogFilterStrategy createStrategy(FlabotFileModel element) {
		return ExecutionstateFactory.eINSTANCE.createSimpleGeneralLogFilterStrategy();
	}
	
	public Class<SimpleGeneralLogFilterStrategy> getReturnType() {
		return SimpleGeneralLogFilterStrategy.class;
	}
	
	public boolean isAssignable(GeneralLogFilterStrategy strategy)
	{
		return (strategy == null || strategy instanceof SimpleGeneralLogFilterStrategy);
	}
	
	/**
	 * This method initializes the tab's controsl
	 */
	public void build(Composite c, FlabotFileModel flabotFileModel, GeneralLogFilterStrategy strategy, ChangeNotifier changeNotifier) {				
		c.setLayout(new GridLayout(2, false));
		
		// strategy configuration group	
		this.flabotFileModel = flabotFileModel;
		this.strategy = (SimpleGeneralLogFilterStrategy) strategy;
		this.prologComposite = null;
			
		prologCode = this.strategy.getPrologCodeText();
		new Label(c, SWT.NONE).setText(Messages.getString("org.isistan.flabot.engine.executionstate.dialogs.event.ConditionEventStrategyEditionItem.prologCode")); //$NON-NLS-1$
		prologComposite = new PrologEditComposite(c, SWT.NONE, createConditionMap());
		prologComposite.setText(prologCode);
		prologComposite.getPrologTextComponent().addFocusListener(new FocusAdapter(){
			public void focusLost(FocusEvent e) {
				prologCode = prologComposite.getText();
			}});
		prologComposite.pack();
	}
	
	public Command getCommand() {
		return new UpdateGeneralLogFilterStrategyCommand(flabotFileModel, strategy);
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
	
	private Map<String, List<PredefinedCondition>> createConditionMap() {
		Map<String, List<PredefinedCondition>> conditions = new HashMap<String, List<PredefinedCondition>>();
		
		List<PredefinedCondition> conds = new ArrayList<PredefinedCondition>();
		conds = new ArrayList<PredefinedCondition>();
		conds.add(new GeneralLogObjectSnapshot());		
		conditions.put(Messages.getString("org.isistan.flabot.engine.executionstate.dialogs.event.ConditionEventStrategyEditionItem.filtered"), conds); //$NON-NLS-1$
		
		return conditions;
	}	

}

