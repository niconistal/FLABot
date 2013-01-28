/**
 * $Id: StateDeterminationStrategyEditionItem.java,v 1.10 2006/04/08 04:15:41 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.engine.executionstate.dialogs.event;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gef.commands.Command;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.isistan.flabot.coremodel.ConditionEvent;
import org.isistan.flabot.edit.ucmeditor.dialogs.event.ConditionEventEditionItem;
import org.isistan.flabot.engine.ExtensionPointConstants;
import org.isistan.flabot.engine.executionstate.ExecutionStateManager;
import org.isistan.flabot.engine.executionstate.PrologProviderStrategy;
import org.isistan.flabot.engine.executionstate.dialogs.ChangeNotifier;
import org.isistan.flabot.engine.executionstate.dialogs.StrategyGUIFactory;
import org.isistan.flabot.engine.executionstate.dialogs.StrategyGUILoader;
import org.isistan.flabot.engine.messages.Messages;
import org.isistan.flabot.util.edition.EditionItemStatus;
import org.isistan.flabot.util.edition.tab.EditionTabItemImpl;
import org.isistan.flabot.util.extension.PropertiesReader;
import org.isistan.flabot.util.problems.log.LoggerMessageAccumulator;

/**
 * Edits the responsibily's state determination strategy
 * @author $Author: franco $
 *
 */
public class ConditionEventStrategyEditionItem 
	extends EditionTabItemImpl<ConditionEvent> implements ConditionEventEditionItem, ChangeNotifier {

	private ConditionEvent conditionEvent;
	private Composite control;
	
	private ScrolledComposite strategyConfigurationComposite;

	private PrologProviderStrategy strategy;

	private Group strategyConfigurationGroup;
	private StrategyGUIFactory<ConditionEvent, PrologProviderStrategy > factory;

	
	public static final List<StrategyGUIFactory<ConditionEvent, PrologProviderStrategy >>
		strategyGUIFactoryRegistry = new ArrayList<StrategyGUIFactory<ConditionEvent, PrologProviderStrategy >>();
	
	static 
	{
		StrategyGUILoader<StrategyGUIFactory<ConditionEvent, PrologProviderStrategy>> loader = new StrategyGUILoader<StrategyGUIFactory<ConditionEvent, PrologProviderStrategy >>(
				ExtensionPointConstants.PROLOG_STRATEGY_UI_COMBO_BOX,
				ExtensionPointConstants.PROLOG_STRATEGY_UI_COMBO_BOX_ACTION_TAG,
				ExtensionPointConstants.PROLOG_STRATEGY_UI_COMBO_BOX__CLASS_ATTRIBUTE,
				new PropertiesReader());
		Collection<StrategyGUIFactory<ConditionEvent, PrologProviderStrategy>> collection = loader.getEditionItems(new LoggerMessageAccumulator());
				
		strategyGUIFactoryRegistry.add(new SimplePrologProviderStrategyGUI());
		strategyGUIFactoryRegistry.addAll(collection);
	}
	
	@Override
	public void initialize(TabFolder tabFolder, TabItem tabItem,
			ConditionEvent conditionEvent) {
		
		this.conditionEvent=conditionEvent;
		
		strategy = ExecutionStateManager.getPrologProviderStrategy(conditionEvent);
		this.strategy = (PrologProviderStrategy) EcoreUtil.copy(strategy);		
		
		tabItem.setText(Messages.getString("org.isistan.flabot.engine.executionstate.dialogs.StateDeterminationStrategyEditionItem.tabName")); //$NON-NLS-1$
		control=new Composite(tabFolder, SWT.NONE);
		control.setLayout(new GridLayout(1, true));
		
		createControls();
	}
	
	public void activate() {
		
	}
	
	/**
	 * This method initializes the tab's controsl
	 */
	private void createControls() {
		new Label(control, SWT.NONE).setText(Messages.getString("org.isistan.flabot.engine.executionstate.dialogs.StateDeterminationStrategyEditionItem.responsibilityLabel") + //$NON-NLS-1$
				conditionEvent.getName());
		/// strategy selection group
		Group strategySelectionGroup = new Group(control, SWT.NONE);
		strategySelectionGroup.setText(Messages.getString("org.isistan.flabot.engine.executionstate.dialogs.StateDeterminationStrategyEditionItem.selectStrategyGroup")); //$NON-NLS-1$
		strategySelectionGroup.setLayout(new RowLayout(SWT.VERTICAL));
		strategySelectionGroup.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_FILL));

		final Combo strategySelectionCombo = new Combo(strategySelectionGroup,
				SWT.READ_ONLY | SWT.DROP_DOWN | SWT.SIMPLE);
		StrategyGUIFactory<ConditionEvent, PrologProviderStrategy > initialFactory = null;
		for (StrategyGUIFactory<ConditionEvent, PrologProviderStrategy > factory: strategyGUIFactoryRegistry) {
			strategySelectionCombo.add(factory.getStrategyName());
			if (factory.isAssignable(strategy)) {
				strategySelectionCombo.setText(factory.getStrategyName());
				initialFactory = factory;
				//break;
			}
		}
		strategySelectionCombo.addSelectionListener(new SelectionAdapter(){
			@Override
			public void widgetSelected(SelectionEvent e) {
				StrategyGUIFactory<ConditionEvent, PrologProviderStrategy > factory =
					strategyGUIFactoryRegistry.get(strategySelectionCombo.getSelectionIndex());
				setSelection(factory);
			}
		});
		
		// strategy configuration group
		strategyConfigurationGroup = new Group(control, SWT.NONE);
		strategyConfigurationGroup.setText(Messages.getString("org.isistan.flabot.engine.executionstate.dialogs.StateDeterminationStrategyEditionItem.configureStrategyGroup")); //$NON-NLS-1$
		strategyConfigurationGroup.setLayout(new FillLayout());
		strategyConfigurationGroup.setLayoutData(new GridData(GridData.FILL_BOTH));
		
		if (initialFactory != null)
			setSelection(initialFactory);
	}

	
	@Override
	public Control getControl() {
		return control;
	}

	public Command getCommand() {
		factory.finishFactory();		
		return factory.getCommand();
	}

	public boolean canCreateCommand() {
		return getStatus().equals(EditionItemStatus.DEFAULT_OK);
	}

	public EditionItemStatus getStatus() {
		if (factory == null)
			return EditionItemStatus.DEFAULT_OK;
		return factory.getStatus();
	}
	
	/**
	 * Set the currently selected strategy and call the appropriate
	 * composite creation method to allow strategy-specific configuration
	 * @param strategy
	 */
	private void setSelection(StrategyGUIFactory<ConditionEvent, PrologProviderStrategy > factory) {
		this.factory = factory;
		// set the current strategy
		if (!factory.getReturnType().isAssignableFrom(strategy.getClass()))
			this.strategy = factory.createStrategy(conditionEvent);
		
		// dispose the previous composite (if needed)
		if (strategyConfigurationComposite != null &&
				!strategyConfigurationComposite.isDisposed())
			strategyConfigurationComposite.dispose();
		//create the scrolled composite (contains the strategy-specific composite)
		strategyConfigurationComposite =
			new ScrolledComposite(strategyConfigurationGroup, SWT.HORIZONTAL|SWT.VERTICAL);
		//strategyConfigurationComposite = new Composite(strategyConfigurationGroup, SWT.NONE);
		//strategyConfigurationComposite.setLayout(new GridLayout());
		//strategyConfigurationComposite.setLayoutData(new GridData(GridData.FILL_BOTH));
		
		Composite c = new Composite(strategyConfigurationComposite, SWT.NONE);
		c.setLayout(new GridLayout());
		c.setLayoutData(new GridData(GridData.FILL_BOTH));		
		strategyConfigurationComposite.setContent(c);
		strategyConfigurationComposite.setExpandVertical(true);
		strategyConfigurationComposite.setExpandHorizontal(true);
		//		strategyConfigurationComposite.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WIDGET_BACKGROUND));
		//strategyConfigurationComposite.setBackgroundMode(SWT.INHERIT_DEFAULT);
		
		
		factory.build(c, conditionEvent, strategy, this);
		//new Label(strategyConfigurationGroup, SWT.NONE).setText(Messages.getString("org.isistan.flabot.engine.executionstate.dialogs.TraceStrategyGUIFactory.prologCode")); //$NON-NLS-1$
		
		// compute the composite's size and layout
		c.setSize(c.computeSize(SWT.DEFAULT, SWT.DEFAULT));
		strategyConfigurationGroup.layout(true);
	}

	public boolean accepts(ConditionEvent element) {
		return true;
	}
	
	public void onChange()
	{
		this.notifyChange();
	}
}
