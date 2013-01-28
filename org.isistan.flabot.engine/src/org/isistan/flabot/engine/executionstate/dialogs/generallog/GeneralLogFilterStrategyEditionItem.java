/**
 * $Id: StateDeterminationStrategyEditionItem.java,v 1.10 2006/04/08 04:15:41 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.engine.executionstate.dialogs.generallog;

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
import org.isistan.flabot.edit.editormodel.FlabotFileModel;
import org.isistan.flabot.engine.ExtensionPointConstants;
import org.isistan.flabot.engine.executionstate.ExecutionStateManager;
import org.isistan.flabot.engine.executionstate.GeneralLogFilterStrategy;
import org.isistan.flabot.engine.executionstate.dialogs.ChangeNotifier;
import org.isistan.flabot.engine.executionstate.dialogs.StrategyGUIFactory;
import org.isistan.flabot.engine.executionstate.dialogs.StrategyGUILoader;
import org.isistan.flabot.engine.messages.Messages;
import org.isistan.flabot.util.edition.EditionItemStatus;
import org.isistan.flabot.util.edition.tab.EditionTabItemImpl;
import org.isistan.flabot.util.extension.PropertiesReader;
import org.isistan.flabot.util.problems.log.LoggerMessageAccumulator;

/**
 * Edits the general log filter strategy
 * @author $Author: franco $
 *
 */
public class GeneralLogFilterStrategyEditionItem 
	extends EditionTabItemImpl<FlabotFileModel> implements ChangeNotifier {

	private FlabotFileModel flabotFileModel;
	private Composite control;
	
	private ScrolledComposite strategyConfigurationComposite;

	private GeneralLogFilterStrategy strategy;

	private Group strategyConfigurationGroup;
	private StrategyGUIFactory<FlabotFileModel, GeneralLogFilterStrategy > factory;

	
	public static final List<StrategyGUIFactory<FlabotFileModel, GeneralLogFilterStrategy >>
		strategyGUIFactoryRegistry = new ArrayList<StrategyGUIFactory<FlabotFileModel, GeneralLogFilterStrategy >>();
	
	static 
	{
		StrategyGUILoader<StrategyGUIFactory<FlabotFileModel, GeneralLogFilterStrategy>> loader = new StrategyGUILoader<StrategyGUIFactory<FlabotFileModel, GeneralLogFilterStrategy >>(
				ExtensionPointConstants.GENERAL_LOG_FILTER_STRATEGY_UI_COMBO_BOX,
				ExtensionPointConstants.GENERAL_LOG_FILTER_STRATEGY_UI_COMBO_BOX_ACTION_TAG,
				ExtensionPointConstants.GENERAL_LOG_FILTER_STRATEGY_UI_COMBO_BOX__CLASS_ATTRIBUTE,
				new PropertiesReader());
		Collection<StrategyGUIFactory<FlabotFileModel, GeneralLogFilterStrategy>> collection = loader.getEditionItems(new LoggerMessageAccumulator());
				
		strategyGUIFactoryRegistry.add(new SimpleGeneralLogFilterPrologProviderStrategyGUI());
		strategyGUIFactoryRegistry.addAll(collection);
	}
	
	@Override
	public void initialize(TabFolder tabFolder, TabItem tabItem,
			FlabotFileModel flabotFileModel) {
		
		this.flabotFileModel=flabotFileModel;
		
		strategy = ExecutionStateManager.getGeneralLogFilterStrategy(flabotFileModel);
		this.strategy = (GeneralLogFilterStrategy) EcoreUtil.copy(strategy);		
		
		tabItem.setText(Messages.getString("org.isistan.flabot.engine.executionstate.dialogs.generallog.GeneralLogFilterStrategyEditionItem.tabName")); //$NON-NLS-1$
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
		/// strategy selection group
		Group strategySelectionGroup = new Group(control, SWT.NONE);
		strategySelectionGroup.setText(Messages.getString("org.isistan.flabot.engine.executionstate.dialogs.generallog.GeneralLogFilterStrategyEditionItem.selectStrategyGroup")); //$NON-NLS-1$
		strategySelectionGroup.setLayout(new RowLayout(SWT.VERTICAL));
		strategySelectionGroup.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_FILL));

		final Combo strategySelectionCombo = new Combo(strategySelectionGroup,
				SWT.READ_ONLY | SWT.DROP_DOWN | SWT.SIMPLE);
		StrategyGUIFactory<FlabotFileModel, GeneralLogFilterStrategy > initialFactory = null;
		for (StrategyGUIFactory<FlabotFileModel, GeneralLogFilterStrategy > factory: strategyGUIFactoryRegistry) {
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
				StrategyGUIFactory<FlabotFileModel, GeneralLogFilterStrategy > factory =
					strategyGUIFactoryRegistry.get(strategySelectionCombo.getSelectionIndex());
				setSelection(factory);
			}
		});
		
		// strategy configuration group
		strategyConfigurationGroup = new Group(control, SWT.NONE);
		strategyConfigurationGroup.setText(Messages.getString("org.isistan.flabot.engine.executionstate.dialogs.generallog.GeneralLogFilterStrategyEditionItem.configureStrategyGroup")); //$NON-NLS-1$
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
	private void setSelection(StrategyGUIFactory<FlabotFileModel, GeneralLogFilterStrategy > factory) {
		this.factory = factory;
		// set the current strategy
		if (!factory.getReturnType().isAssignableFrom(strategy.getClass()))
			this.strategy = factory.createStrategy(flabotFileModel);
		
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
		
		
		factory.build(c, flabotFileModel, strategy, this);
		//new Label(strategyConfigurationGroup, SWT.NONE).setText(Messages.getString("org.isistan.flabot.engine.executionstate.dialogs.TraceStrategyGUIFactory.prologCode")); //$NON-NLS-1$
		
		// compute the composite's size and layout
		c.setSize(c.computeSize(SWT.DEFAULT, SWT.DEFAULT));
		strategyConfigurationGroup.layout(true);
	}

	public boolean accepts(FlabotFileModel element) {
		return true;
	}
	
	public void onChange()
	{
		this.notifyChange();
	}
}