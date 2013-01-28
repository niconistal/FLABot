/**
 * $Id: StateDeterminationStrategyEditionItem.java,v 1.10 2006/04/08 04:15:41 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.engine.executionstate.dialogs;

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
import org.isistan.flabot.coremodel.Responsibility;
import org.isistan.flabot.edit.componenteditor.dialogs.responsibility.ResponsibilityEditionItem;
import org.isistan.flabot.engine.ExtensionPointConstants;
import org.isistan.flabot.engine.executionstate.ExecutionStateManager;
import org.isistan.flabot.engine.executionstate.StateDeterminationStrategy;
import org.isistan.flabot.engine.executionstate.commands.UpdateStateDeterminationStrategyCommand;
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
public class StateDeterminationStrategyEditionItem extends
		EditionTabItemImpl<Responsibility>
		implements	ResponsibilityEditionItem, ChangeNotifier {

	private Responsibility responsibility;
	private Composite control;
	
	private ScrolledComposite strategyConfigurationComposite;

	private StateDeterminationStrategy strategy;

	private Group strategyConfigurationGroup;
	private StrategyGUIFactory<Responsibility, StateDeterminationStrategy> factory;

	
	public static final List<StrategyGUIFactory<Responsibility, StateDeterminationStrategy>>
		strategyGUIFactoryRegistry = new ArrayList<StrategyGUIFactory<Responsibility, StateDeterminationStrategy>>();
	
	static 
	{
		StrategyGUILoader<StrategyGUIFactory<Responsibility, StateDeterminationStrategy>> loader = new StrategyGUILoader<StrategyGUIFactory<Responsibility, StateDeterminationStrategy>>(
				ExtensionPointConstants.STRATEGY_UI_COMBO_BOX,
				ExtensionPointConstants.STRATEGY_UI_COMBO_BOX_ACTION_TAG,
				ExtensionPointConstants.STRATEGY_UI_COMBO_BOX__CLASS_ATTRIBUTE,
				new PropertiesReader());
		Collection<StrategyGUIFactory<Responsibility, StateDeterminationStrategy>> collection = loader.getEditionItems(new LoggerMessageAccumulator());
				
		strategyGUIFactoryRegistry.addAll(collection);
		strategyGUIFactoryRegistry.add(new TraceStrategyGUIFactory());
		strategyGUIFactoryRegistry.add(new ManualStrategyGUIFactory());
		strategyGUIFactoryRegistry.add(new StateFromMappingStrategyGUIFactory());		
	}
	
	@Override
	public void initialize(TabFolder tabFolder, TabItem tabItem,
			Responsibility responsibility) {
		
		this.responsibility=responsibility;
		StateDeterminationStrategy strategy = ExecutionStateManager.getStateDeterminationStrategy(
				responsibility);
		this.strategy = (StateDeterminationStrategy) EcoreUtil.copy(strategy);
		strategy.setResponsibility(responsibility);
		
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
				responsibility.getName());
		/// strategy selection group
		Group strategySelectionGroup = new Group(control, SWT.NONE);
		strategySelectionGroup.setText(Messages.getString("org.isistan.flabot.engine.executionstate.dialogs.StateDeterminationStrategyEditionItem.selectStrategyGroup")); //$NON-NLS-1$
		strategySelectionGroup.setLayout(new RowLayout(SWT.VERTICAL));
		strategySelectionGroup.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_FILL));

		final Combo strategySelectionCombo = new Combo(strategySelectionGroup,
				SWT.READ_ONLY | SWT.DROP_DOWN | SWT.SIMPLE);
		StrategyGUIFactory<Responsibility, StateDeterminationStrategy> initialFactory = null;
		for (StrategyGUIFactory<Responsibility, StateDeterminationStrategy> factory: strategyGUIFactoryRegistry) {
			strategySelectionCombo.add(factory.getStrategyName());
			if (factory.isAssignable(strategy) && initialFactory == null) {
				strategySelectionCombo.setText(factory.getStrategyName());
				initialFactory = factory;
				//break;
			}
		}
		strategySelectionCombo.addSelectionListener(new SelectionAdapter(){
			@Override
			public void widgetSelected(SelectionEvent e) {
				StrategyGUIFactory<Responsibility, StateDeterminationStrategy> factory =
					strategyGUIFactoryRegistry.get(strategySelectionCombo.getSelectionIndex());
				setSelection(factory, true);
			}
		});
		
		// strategy configuration group
		strategyConfigurationGroup = new Group(control, SWT.NONE);
		strategyConfigurationGroup.setText(Messages.getString("org.isistan.flabot.engine.executionstate.dialogs.StateDeterminationStrategyEditionItem.configureStrategyGroup")); //$NON-NLS-1$
		strategyConfigurationGroup.setLayout(new FillLayout());
		strategyConfigurationGroup.setLayoutData(new GridData(GridData.FILL_BOTH));
		
		if (initialFactory != null)
		{
			setSelection(initialFactory, false);
		}
	}

	
	@Override
	public Control getControl() {
		return control;
	}

	public Command getCommand() {
		factory.finishFactory();
		return new UpdateStateDeterminationStrategyCommand(responsibility, strategy);
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
	private void setSelection(StrategyGUIFactory<Responsibility, StateDeterminationStrategy> factory, boolean reCreateStrategy) {
		// set the current strategy
		if (this.factory != factory)
		{
			this.factory = factory;
			
			if(reCreateStrategy)
			{
				this.strategy = this.factory.createStrategy(responsibility);
			}
		
			// dispose the previous composite (if needed)
			if (strategyConfigurationComposite != null &&
					!strategyConfigurationComposite.isDisposed())
			{
				strategyConfigurationComposite.dispose();
			}
			
			//create the scrolled composite (contains the strategy-specific composite)
			strategyConfigurationComposite =
				new ScrolledComposite(strategyConfigurationGroup, SWT.HORIZONTAL|SWT.VERTICAL);
			Composite c = new Composite(strategyConfigurationComposite, SWT.NONE);
			strategyConfigurationComposite.setContent(c);
			
			factory.build(c, responsibility, strategy, this);
			
			// compute the composite's size and layout
			c.setSize(c.computeSize(SWT.DEFAULT, SWT.DEFAULT));		
			strategyConfigurationComposite.layout(true);
			strategyConfigurationGroup.layout(true);
			
			if (c.getBounds().width + 5 < strategyConfigurationComposite.getBounds().width || strategyConfigurationComposite.getBounds().width == 0)
			{
				strategyConfigurationComposite.setExpandHorizontal(true);
			}
			
			if (c.getBounds().height + 5 < strategyConfigurationComposite.getBounds().height || strategyConfigurationComposite.getBounds().height == 0)
			{
				strategyConfigurationComposite.setExpandVertical(true);
			}
						
			//strategyConfigurationComposite.setExpandVertical(true);
			//strategyConfigurationComposite.setExpandHorizontal(true);
		}
	}

	/**
	 * Get the strategy that's currently being edited
	 * @return
	 */
	public StateDeterminationStrategy getStrategy() {
		return strategy;
	}

	public boolean accepts(Responsibility element) {
		return true;
	}
	
	public void onChange()
	{
		this.notifyChange();
	}
}
