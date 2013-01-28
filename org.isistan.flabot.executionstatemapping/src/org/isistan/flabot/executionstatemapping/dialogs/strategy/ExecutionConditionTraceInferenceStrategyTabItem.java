
package org.isistan.flabot.executionstatemapping.dialogs.strategy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.gef.commands.Command;
import org.eclipse.jdt.ui.JavaElementLabelProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.BusyIndicator;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.model.WorkbenchContentProvider;
import org.eclipse.ui.views.navigator.ResourceSorter;
import org.isistan.flabot.coremodel.ComponentModel;
import org.isistan.flabot.coremodel.Responsibility;
import org.isistan.flabot.engine.executionstate.ExecutionstateFactory;
import org.isistan.flabot.engine.executionstate.StateDeterminationStrategy;
import org.isistan.flabot.engine.executionstate.TraceBasedStateDeterminationStrategy;
import org.isistan.flabot.engine.executionstate.TraceInferenceStrategy;
import org.isistan.flabot.engine.executionstate.dialogs.ChangeNotifier;
import org.isistan.flabot.engine.executionstate.dialogs.StrategyGUIFactory;
import org.isistan.flabot.executionstatemapping.dialogs.utils.filter.UpdatableFilteredView;
import org.isistan.flabot.executionstatemapping.dialogs.utils.filter.ViewFilterProvider;
import org.isistan.flabot.executionstatemapping.dialogs.utils.filter.ViewFilterProviderAdapter;
import org.isistan.flabot.executionstatemapping.dialogs.utils.labelproviders.DecoratedWorkbenchLabelProvider;
import org.isistan.flabot.executionstatemapping.dialogs.utils.viewerfilters.ExecutionConditionScopeViewerFilter;
import org.isistan.flabot.executionstatemapping.dialogs.utils.viewerfilters.MethodClassViewerFilter;
import org.isistan.flabot.executionstatemapping.dialogs.utils.viewerfilters.StateDiagramScopeViewerFilter;
import org.isistan.flabot.executionstatemapping.messages.Messages;
import org.isistan.flabot.executionstatemapping.model.prolog.impl.ResponsibilityTagProviderImpl;
import org.isistan.flabot.executionstatemapping.model.strategymodel.SimpleExecutionConditionTraceInferenceStrategy;
import org.isistan.flabot.executionstatemapping.model.strategymodel.StateDiagramTraceInferenceStrategy;
import org.isistan.flabot.executionstatemapping.model.strategymodel.StrategymodelFactory;
import org.isistan.flabot.executionstatemapping.utils.ExecutionConditionUtils;
import org.isistan.flabot.javamodel.JBehavior;
import org.isistan.flabot.javamodel.JObject;
import org.isistan.flabot.javamodel.jdt.ImplicitConstructorImpl;
import org.isistan.flabot.javamodel.jdt.JavaModelJDTUtil;
import org.isistan.flabot.javamodel.jdt.workspace.JWorkspaceClass;
import org.isistan.flabot.mapping.MappingManager;
import org.isistan.flabot.mapping.MappingType;
import org.isistan.flabot.mapping.editor.ClientViewerContentProvider;
import org.isistan.flabot.mapping.editor.ClientViewerLabelProvider;
import org.isistan.flabot.mapping.editor.WorkspaceViewerContentProvider;
import org.isistan.flabot.mapping.editor.WorkspaceViewerLabelProvider;
import org.isistan.flabot.mapping.editor.WorkspaceViewerContentProvider.ContentFilter;
import org.isistan.flabot.mapping.mappingmodel.Mapping;
import org.isistan.flabot.mapping.mappingmodel.PatternMapping;
import org.isistan.flabot.util.edition.EditionItemStatus;
import org.isistan.flabot.util.problems.MessageAccumulator;
import org.isistan.flabot.util.problems.log.LoggerMessageAccumulator;

public class ExecutionConditionTraceInferenceStrategyTabItem implements StrategyGUIFactory<Responsibility, StateDeterminationStrategy> 
{
	private TraceBasedStateDeterminationStrategy traceStrategy;
	
	private Responsibility responsibility; 
	
	//Component Mappings
	private PatternMapping[] componentPatternMappings;
	
	//Component Scope Filter for Diagrams
	private StateDiagramScopeViewerFilter scopeComponentDiagrams;
	
	//Responsibility Scope Filter for Diagrams
	private StateDiagramScopeViewerFilter scopeResponsibilityDiagrams;
			
	//Component Scope Filter for Execution Conditions	
	private ExecutionConditionScopeViewerFilter scopeComponentFilter;
	
	//Responsibility Scope Filter for Execution Conditions
	private ExecutionConditionScopeViewerFilter scopeResponsibilityFilter;
		
	private CompositeTabStrategy compositeTabStrategy;
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see org.isistan.flabot.engine.executionstate.dialogs.ConfigGUIBuilder#build(org.eclipse.swt.widgets.Composite)
	 */
	public void build(Composite c, Responsibility responsibility, StateDeterminationStrategy strategy, ChangeNotifier changeNotifier) 
	{
		scopeResponsibilityFilter = null;
		scopeComponentFilter = null;
		componentPatternMappings = null;
		scopeResponsibilityDiagrams = null;
		scopeComponentDiagrams = null;
		this.compositeTabStrategy = null;
		
		if (strategy == null
				|| !(strategy instanceof TraceBasedStateDeterminationStrategy)) 
		{
			new Label(c, SWT.NONE).setText(Messages.getString("org.isistan.flabot.executionmapping.dialogs.strategy.ExecutionConditionTraceInferenceStrategyTabItem.strategyError")); //$NON-NLS-1$
		}
		else
		{
			this.responsibility = responsibility;
			this.traceStrategy = (TraceBasedStateDeterminationStrategy)strategy;
		
			compositeTabStrategy = new CompositeTabStrategy(true, getExecutionConditionAddMenuSubItems(), getNewMethodExecutionConditionMenuSubItems(), createStateDiagramFileSection(), new ResponsibilityTagProviderImpl());
			compositeTabStrategy.build(c, ((TraceBasedStateDeterminationStrategy) strategy).getTraceInferenceStrategy());
		}
	}
			
	public void finishFactory() 
	{
		traceStrategy.setTraceInferenceStrategy(createStrategy());
	}

	public StateDeterminationStrategy createStrategy(
			Responsibility responsibility) {
		TraceBasedStateDeterminationStrategy traceStrategy = ExecutionstateFactory.eINSTANCE
				.createTraceBasedStateDeterminationStrategy();
		traceStrategy.setTraceInferenceStrategy(StrategymodelFactory.eINSTANCE.createStateDiagramTraceInferenceStrategy());
		traceStrategy.setResponsibility(responsibility);
		return traceStrategy;
	}

	public String getStrategyName() {
		return Messages.getString("org.isistan.flabot.executionmapping.dialogs.strategy.ExecutionConditionTraceInferenceStrategyTabItem.conditionStrategy"); //$NON-NLS-1$
	}

	public Class<TraceBasedStateDeterminationStrategy> getReturnType() {
		return TraceBasedStateDeterminationStrategy.class;
	}

	public EditionItemStatus getStatus() {
		if (compositeTabStrategy != null)
		{
			return compositeTabStrategy.validateTabStrategy();
		}
		return EditionItemStatus.DEFAULT_OK;
	}

	protected ViewFilterProvider[] createStateDiagramFileSection() 
	{		
		ViewFilterProvider[] viewFilterProviders = new ViewFilterProvider[3];
		
		viewFilterProviders[0] = new ViewFilterProviderAdapter()
		{			
			@Override
			public String getTextName()
			{
				return Messages.getString("org.isistan.flabot.executionmapping.dialogs.strategy.ExecutionConditionTraceInferenceStrategyTabItem.noScopeFilter"); //$NON-NLS-1$
			}
			
			@Override
			public void filterChanged(final UpdatableFilteredView updatableView)
			{
				BusyIndicator.showWhile(Display.getCurrent(), new Runnable() {
					public void run() 
					{				
						updatableView.updateFilter(null);
					}
				});			
			}
		};
		
		viewFilterProviders[1] = new ViewFilterProviderAdapter()
		{			
			@Override
			public String getTextName()
			{
				return Messages.getString("org.isistan.flabot.executionmapping.dialogs.strategy.ExecutionConditionTraceInferenceStrategyTabItem.responsibilityScopeFilter"); //$NON-NLS-1$
			}
			
			@Override
			public void filterChanged(final UpdatableFilteredView updatableView)
			{
				BusyIndicator.showWhile(Display.getCurrent(), new Runnable() {
					public void run() 
					{				
						updatableView.updateFilter(getScopeResponsibilityDiagrams());
					}
				});			
			}
		};
		
		viewFilterProviders[2] = new ViewFilterProviderAdapter()
		{			
			@Override
			public String getTextName()
			{
				return Messages.getString("org.isistan.flabot.executionmapping.dialogs.strategy.ExecutionConditionTraceInferenceStrategyTabItem.componentScopeFilter"); //$NON-NLS-1$
			}
			
			@Override
			public void filterChanged(final UpdatableFilteredView updatableView)
			{
				BusyIndicator.showWhile(Display.getCurrent(), new Runnable() {
					public void run() 
					{				
						updatableView.updateFilter(getScopeComponentDiagrams());
					}
				});			
			}
		};
		return viewFilterProviders;
	}	
			
	private JObject[] getMatchingElements(Mapping mapping) {
		if(mapping==null)
			return new JObject[0];
		MessageAccumulator messageAccumulator = new LoggerMessageAccumulator();
		return mapping.getWorkspaceMapper().find(MappingType.ANYTHING, mapping, true, messageAccumulator);
	}
	
	private JObject[] getMatchingElements(Mapping[] parentScopeMappings) {
		List<JObject> elements=new LinkedList<JObject>();
		MessageAccumulator messageAccumulator = new LoggerMessageAccumulator();
		for (Mapping mapping : parentScopeMappings) {
			 JObject[] matches=mapping.getWorkspaceMapper().find(MappingType.CLASSES, mapping, true, messageAccumulator);
			 for (JObject match : matches) {
				 if(!JavaModelJDTUtil.contains(elements, match)) {
					 elements.add(match);
				 }
			}
			 
		}
		return elements.toArray(new JObject[elements.size()]);
	}
		
	private ViewFilterProvider[] getNewMethodExecutionConditionMenuSubItems()
	{
		ViewFilterProvider[] viewFilterProviders = new ViewFilterProvider[3];
		
		viewFilterProviders[0] = new ViewFilterProviderAdapter()
		{			
			@Override
			public String getTextName()
			{
				return Messages.getString("org.isistan.flabot.executionmapping.dialogs.strategy.ExecutionConditionTraceInferenceStrategyTabItem.noScopeFilter"); //$NON-NLS-1$
			}
			
			@Override
			public void filterChanged(final UpdatableFilteredView updatableView)
			{
				BusyIndicator.showWhile(Display.getCurrent(), new Runnable() {
					public void run() 
					{
						updatableView.updateContent(new ResourceSorter(ResourceSorter.NAME), new DecoratedWorkbenchLabelProvider(), new WorkbenchContentProvider(), ExecutionConditionUtils.getJavaModelForWorkspace());					
						updatableView.updateFilter(new MethodClassViewerFilter());
					}
				});			
			}
		};
		
		viewFilterProviders[1] = new ViewFilterProvider()
		{
			public String getTextName()
			{
				return Messages.getString("org.isistan.flabot.executionmapping.dialogs.strategy.ExecutionConditionTraceInferenceStrategyTabItem.responsibilityScopeFilter"); //$NON-NLS-1$
			}
			
			public Object[] validateResult(Object[] result)
			{
				if (result != null)
				{
					for(int i=0; i<result.length; i++)
					{
						if (result[i] instanceof JObject)
						{
							result[i] = JavaModelJDTUtil.getJavaElement((JObject)result[i]);
						}
						else
						{
							result[i] = null;
						}
					}
				}
				return result;
			}
			
			public void filterChanged(final UpdatableFilteredView updatableView)
			{
				BusyIndicator.showWhile(Display.getCurrent(), new Runnable() {
					public void run() 
					{								
						ClientViewerContentProvider treeContentProvider = new ClientViewerContentProvider(false, true);
						JObject[] jObjects = getMatchingElements(MappingManager.getMapping(responsibility));
						treeContentProvider.inputChanged(null, null, jObjects);
														
						ClientViewerLabelProvider labelProvider = new ClientViewerLabelProvider(JavaElementLabelProvider.SHOW_PARAMETERS | JavaElementLabelProvider.SHOW_OVERLAY_ICONS | JavaElementLabelProvider.SHOW_RETURN_TYPE | JavaElementLabelProvider.SHOW_QUALIFIED);
												
						updatableView.updateContent(null, labelProvider, treeContentProvider, jObjects);
					}
				});
			}
		};
		
		viewFilterProviders[2] = new ViewFilterProvider()
		{
			public String getTextName()
			{
				return Messages.getString("org.isistan.flabot.executionmapping.dialogs.strategy.ExecutionConditionTraceInferenceStrategyTabItem.componentScopeFilter"); //$NON-NLS-1$
			}
			
			public Object[] validateResult(Object[] result)
			{
				if (result != null)
				{
					for(int i=0; i<result.length; i++)
					{
						if (result[i] instanceof JObject)
						{						
							result[i] = JavaModelJDTUtil.getJavaElement((JObject)result[i]);
						}
						else
						{
							result[i] = null;
						}
					}
				}
				return result;
			}			
			
			public void filterChanged(final UpdatableFilteredView updatableView)
			{
				BusyIndicator.showWhile(Display.getCurrent(), new Runnable() {
					public void run() 
					{				
						
						ContentFilter contentFilter = new ContentFilter()
						{

							public boolean accept(JWorkspaceClass class1,
									boolean hasShowableChildren) {
								return true;
							}

							public boolean accept(JBehavior behavior,
									boolean hasShowableChildren) {
								return !(behavior instanceof ImplicitConstructorImpl);
							}
							
						};
						
						WorkspaceViewerLabelProvider labelProvider = new WorkspaceViewerLabelProvider(
								JavaElementLabelProvider.SHOW_PARAMETERS | JavaElementLabelProvider.SHOW_OVERLAY_ICONS | JavaElementLabelProvider.SHOW_RETURN_TYPE
								| JavaElementLabelProvider.SHOW_QUALIFIED);
						
						WorkspaceViewerContentProvider treeContentProvider = new WorkspaceViewerContentProvider(true, false, false, false, true, true, contentFilter);
												
						updatableView.updateContent(null, labelProvider, treeContentProvider, getMatchingElements(getComponentPatternMappings()));
					}
				});
			}
		};
				
		return viewFilterProviders;	
	}			
	
	private ViewFilterProvider[] getExecutionConditionAddMenuSubItems()
	{
		ViewFilterProvider[] viewFilterProviders = new ViewFilterProvider[3];
		
		viewFilterProviders[0] = new ViewFilterProviderAdapter()
			{			
				@Override
				public String getTextName()
				{
					return Messages.getString("org.isistan.flabot.executionmapping.dialogs.strategy.ExecutionConditionTraceInferenceStrategyTabItem.noScopeFilter"); //$NON-NLS-1$
				}
				
				@Override
				public void filterChanged(UpdatableFilteredView updatableView)
				{
					updatableView.updateFilter(null);
				}
			};	
		
		viewFilterProviders[1] = new ViewFilterProviderAdapter()
			{			
				@Override
				public String getTextName()
				{
					return Messages.getString("org.isistan.flabot.executionmapping.dialogs.strategy.ExecutionConditionTraceInferenceStrategyTabItem.responsibilityScopeFilter"); //$NON-NLS-1$
				}
				
				@Override
				public void filterChanged(UpdatableFilteredView updatableView)
				{
					updatableView.updateFilter(getResponsibilityFilter());
				}				
			};
	    
		viewFilterProviders[2] = new ViewFilterProviderAdapter()
			{			
				@Override
				public String getTextName()
				{
					return Messages.getString("org.isistan.flabot.executionmapping.dialogs.strategy.ExecutionConditionTraceInferenceStrategyTabItem.componentScopeFilter"); //$NON-NLS-1$
				}
				
				@Override
				public void filterChanged(UpdatableFilteredView updatableView)
				{
					updatableView.updateFilter(getComponentFilter());
				}
			};		
		
		return viewFilterProviders;
	}
	
	private TraceInferenceStrategy createStrategy()
	{
		if (compositeTabStrategy != null)
		{
			return compositeTabStrategy.createStrategy();
		}
		return null;
	}
	
	public boolean isAssignable(StateDeterminationStrategy strategy) {
		if (strategy instanceof TraceBasedStateDeterminationStrategy) 
		{
			TraceBasedStateDeterminationStrategy s  = ((TraceBasedStateDeterminationStrategy) strategy); 
			return s.getTraceInferenceStrategy() instanceof StateDiagramTraceInferenceStrategy || s.getTraceInferenceStrategy() instanceof SimpleExecutionConditionTraceInferenceStrategy;
		}
		return false;
	}
	
	public Command getCommand()
	{
		return null;
	}
	
	/**
	 * Scope Filters
	 */
	private ExecutionConditionScopeViewerFilter getResponsibilityFilter()
	{
		if (scopeResponsibilityFilter == null)
		{			
			scopeResponsibilityFilter = new ExecutionConditionScopeViewerFilter(new PatternMapping[] {(PatternMapping) MappingManager.getMapping(responsibility)}, false);
		}
		return scopeResponsibilityFilter;
	}
		
	private ExecutionConditionScopeViewerFilter getComponentFilter()
	{
		if (scopeComponentFilter == null)
		{			
			scopeComponentFilter = new ExecutionConditionScopeViewerFilter(getComponentPatternMappings(), true);
		}
		return scopeComponentFilter;
	}
	
	@SuppressWarnings("unchecked") //$NON-NLS-1$
	private PatternMapping[] getComponentPatternMappings()
	{
		if (componentPatternMappings == null)
		{
			List<PatternMapping> mappings = new ArrayList<PatternMapping>();
			List<ComponentModel> components = (List<ComponentModel>) responsibility.getComponents();
			for(ComponentModel component : components)
			{
				mappings.add((PatternMapping)MappingManager.getMapping(component));
			}
			componentPatternMappings = new PatternMapping[mappings.size()];
			mappings.toArray(componentPatternMappings);			
		}
		return componentPatternMappings;
	}
	
	private StateDiagramScopeViewerFilter getScopeResponsibilityDiagrams()
	{
		if (scopeResponsibilityDiagrams == null)		
		{
			scopeResponsibilityDiagrams = new StateDiagramScopeViewerFilter(new PatternMapping[] {(PatternMapping) MappingManager.getMapping(responsibility)});
		}
		return scopeResponsibilityDiagrams;
	}	
	
	private StateDiagramScopeViewerFilter getScopeComponentDiagrams()
	{
		if (scopeComponentDiagrams == null)		
		{
			scopeComponentDiagrams = new StateDiagramScopeViewerFilter(getComponentPatternMappings());
		}
		return scopeComponentDiagrams;
	}
}