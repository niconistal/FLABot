package org.isistan.flabot.executionstatemapping.dialogs.strategy;

import org.eclipse.gef.commands.Command;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.internal.Workbench;
import org.isistan.flabot.edit.editormodel.FlabotFileModel;
import org.isistan.flabot.edit.multipage.FlabotMultiPageEditor;
import org.isistan.flabot.engine.executionstate.GeneralLogFilterStrategy;
import org.isistan.flabot.engine.executionstate.commands.UpdateGeneralLogFilterStrategyCommand;
import org.isistan.flabot.engine.executionstate.dialogs.ChangeNotifier;
import org.isistan.flabot.engine.executionstate.dialogs.StrategyGUIFactory;
import org.isistan.flabot.executionstatemapping.InterfacePluginExecutionStateMapping;
import org.isistan.flabot.executionstatemapping.dialogs.common.PreFilterManagerComposite;
import org.isistan.flabot.executionstatemapping.messages.Messages;
import org.isistan.flabot.executionstatemapping.model.semantic.SemanticFactory;
import org.isistan.flabot.executionstatemapping.model.semantic.SimpleExecutionConditionConfiguration;
import org.isistan.flabot.executionstatemapping.model.strategymodel.ExecutionConditionGeneralLogFilterStrategy;
import org.isistan.flabot.executionstatemapping.model.strategymodel.StrategymodelFactory;
import org.isistan.flabot.util.edition.EditionItemStatus;
import org.isistan.flabot.util.edition.SingleEditionItemStatus;

public class ExecutionConditionGeneralLogFilterStrategyTabItem implements StrategyGUIFactory<FlabotFileModel, GeneralLogFilterStrategy>   {
	
	private ExecutionConditionGeneralLogFilterStrategy  strategy;
	
	private FlabotFileModel flabotFileModel;
		
	private PreFilterManagerComposite preFilterManagerDialog;
	
	private ChangeNotifier changeNotifier;
	
	public void build(Composite c, FlabotFileModel flabotFileModel, GeneralLogFilterStrategy strategy, ChangeNotifier changeNotifier) {
		
		this.flabotFileModel=flabotFileModel;
		this.changeNotifier = changeNotifier;
		
		if (strategy == null || !(strategy instanceof ExecutionConditionGeneralLogFilterStrategy) )
		{
			this.strategy = (ExecutionConditionGeneralLogFilterStrategy) createStrategy(flabotFileModel);
		}
		else
		{
			this.strategy = (ExecutionConditionGeneralLogFilterStrategy) strategy;
		}
		createControls(c);
	}
			
	public Command getCommand() 
	{
		if (preFilterManagerDialog != null)
		{
			return new UpdateGeneralLogFilterStrategyCommand(flabotFileModel, strategy);
		}
		return null;
	}
	
	public boolean canCreateCommand() {
		return getStatus().equals(EditionItemStatus.DEFAULT_OK);
	}
	
	public EditionItemStatus getStatus() 
	{
		if (preFilterManagerDialog != null && preFilterManagerDialog.getElements().size() == 0)
		{
			return new SingleEditionItemStatus(EditionItemStatus.Type.ERROR, Messages.getString("org.isistan.flabot.executionmapping.dialogs.strategy.ExecutionConditionGeneralLogFilterStrategyTabItem.mustSpecfyConfiguration")); //$NON-NLS-1$
		}
		return EditionItemStatus.DEFAULT_OK;
	}
	
	public String getStrategyName()
	{
		return Messages.getString("org.isistan.flabot.executionmapping.dialogs.strategy.ExecutionConditionGeneralLogFilterStrategyTabItem.executionLogFilterStrategy"); //$NON-NLS-1$
	}
	
	public void finishFactory()
	{
		if (preFilterManagerDialog != null)
		{
			SimpleExecutionConditionConfiguration simpleConfiguration = strategy.getSimpleExecutionConditionConfiguration();
			if (simpleConfiguration == null)
			{
				simpleConfiguration = SemanticFactory.eINSTANCE.createSimpleExecutionConditionConfiguration();
				strategy.setSimpleExecutionConditionConfiguration(simpleConfiguration);
			}
			simpleConfiguration.getPreFilters().addAll(preFilterManagerDialog.getElements());
			simpleConfiguration.setUseCustomConfiguration(false);
			simpleConfiguration.setUseDefaultConfiguration(false);
		}
	}
	
	public GeneralLogFilterStrategy createStrategy(FlabotFileModel flabotFileModel) {		
		ExecutionConditionGeneralLogFilterStrategy strategy = StrategymodelFactory.eINSTANCE.createExecutionConditionGeneralLogFilterStrategy();
		strategy.setSimpleExecutionConditionConfiguration(SemanticFactory.eINSTANCE.createSimpleExecutionConditionConfiguration());		
		return strategy;
	}
	
	public Class<ExecutionConditionGeneralLogFilterStrategy> getReturnType() {
		return ExecutionConditionGeneralLogFilterStrategy.class;
	}
	
	public boolean isAssignable(GeneralLogFilterStrategy strategy)
	{
		return (strategy instanceof ExecutionConditionGeneralLogFilterStrategy);
	}
	
	private void createControls(Composite c) {
		Composite control = new Composite(c, SWT.NONE);
		control.setLayout(new GridLayout(3, false));
		GridData gridDataControl = new GridData(GridData.FILL_HORIZONTAL);
		gridDataControl.heightHint =310;
		gridDataControl.grabExcessHorizontalSpace =true;
		control.setLayoutData(gridDataControl);
		
		preFilterManagerDialog = new PreFilterManagerComposite(control,
				SWT.None, InterfacePluginExecutionStateMapping.getFileModel(getEditor()), null,
				null);		
		preFilterManagerDialog.setChangeNotifier(changeNotifier);
		
		if (strategy != null && strategy.getSimpleExecutionConditionConfiguration() != null)
		{
			preFilterManagerDialog.setElements(strategy.getSimpleExecutionConditionConfiguration().getPreFilters());
		}
	}
	
	@SuppressWarnings("restriction") //$NON-NLS-1$
	private FlabotMultiPageEditor getEditor()
	{
		return (FlabotMultiPageEditor) Workbench.getInstance().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
	}
}