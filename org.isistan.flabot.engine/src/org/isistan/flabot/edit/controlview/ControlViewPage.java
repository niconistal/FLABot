/**
 * $Id: ControlViewPage.java,v 1.23 2006/03/29 00:55:37 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.controlview;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.internal.Workbench;
import org.eclipse.ui.part.IPageBookViewPage;
import org.eclipse.ui.part.IPageSite;
import org.isistan.flabot.FlabotPlugin;
import org.isistan.flabot.edit.editormodel.FlabotFileModel;
import org.isistan.flabot.engine.EnginePlugin;
import org.isistan.flabot.engine.RuntimeManager;
import org.isistan.flabot.engine.locator.FlabotEngineLocator;
import org.isistan.flabot.engine.messages.Messages;
import org.isistan.flabot.executionmodel.ExecutionContext;
import org.isistan.flabot.executionmodel.ExecutionInfo;
import org.isistan.flabot.executionmodel.ExecutionInfoManager;
import org.isistan.flabot.executionmodel.ExecutionStep;
import org.isistan.flabot.executionmodel.ExecutionmodelPackage;
import org.isistan.flabot.util.locator.ComponentLocatorException;
import org.isistan.flabot.util.locator.ComponentLocatorManager;

/**
 * @author $Author: franco $
 *
 */
public class ControlViewPage implements IPageBookViewPage, Adapter {
		
	private ExecutionInfoManager executionInfoManager;
	
	private RuntimeManager runtimeManager;	
	
	private TreeViewer viewer;
	
	private IPageSite site;
	
	private Notifier target;
	
	/**
     * Instantiates the SequenceViewPage with and an ExecutionInfoManager.
     */
	public ControlViewPage(FlabotFileModel model, ExecutionInfoManager executionInfoManager) {
		this.executionInfoManager = executionInfoManager;
		setRuntimeManager(model);
		activate();
	}

	
	/**
	 * Returns the Execution Info Manager
	 * 
	 * @return the execution info manager
	 */
	private ExecutionInfoManager getExecutionInfoManager() {
		return executionInfoManager;
	}
	
	protected void activate() {
		getExecutionInfoManager().eAdapters().add(this);
	}
	    
	protected void deactivate() {
		getExecutionInfoManager().eAdapters().remove(this);
	}
	
	private void setRuntimeManager(FlabotFileModel flabotFileModel) {
		// add the file model to the parameters map
		Map parameters = new HashMap(2);
		parameters.put(FlabotEngineLocator.PARAMETER_FLABOT_FILE_MODEL,
				flabotFileModel);
		parameters.put(FlabotEngineLocator.PARAMETER_EXECUTION_INFO_MANAGER,
				executionInfoManager);
		// obtain a reference to the component locator manager
		ComponentLocatorManager locatorManager =
			FlabotPlugin.getDefault().getComponentLocatorManager();

		try {
			// ask the locator manager to find a runtime manager reference
			runtimeManager = (RuntimeManager)
			locatorManager.getComponent(FlabotEngineLocator.LOCATOR_ID,
					parameters);
		} catch (ComponentLocatorException e) {
			EnginePlugin.getDefault().getLogger().error(
					Messages.getString("org.isistan.flabot.engine.RunEngineAction.exceptionTryingToLocateTheFlabotEngine"), e); //$NON-NLS-1$
			runtimeManager = null;
		}
	}
	
	protected TreeViewer getViewer() {
		return viewer;
	}
	
	/**
     * Creates the SWT control for this page under the given parent 
     * control. Creates a viewer for the Sequence View, with a SequenceViewFactory.
     */
	public void createControl(Composite parent) {
		viewer = new TreeViewer(parent);
		
		getViewer().getControl().setBackground(ColorConstants.white);
		getViewer().setContentProvider(new ControlViewContentProvider());
		getViewer().setLabelProvider(new ControlViewLabelProvider());
		
		getViewer().setInput(getCurrentExecutionInfo());
		
		
		//Double click edition over conditions
	/*	getViewer().getTree().addListener( SWT.MouseDoubleClick, new Listener() {
			public void handleEvent(Event event) {
				TreeItem[] items = getViewer().getTree().getSelection();
				if (items.length == 1 && items[0].getData() instanceof ExecutionStep) {
					ExecutionStep step = (ExecutionStep)items[0].getData();
					if (step.getDiagnosticToSource() != null) {
						List tags = (List) step.getDiagnosticToSource().getAdditionalData().get(TraceBasedStateDeterminationStrategy.ANALYZED_TAGS_KEY);
						if (tags != null)
							TagFilterDialogManager.INSTANCE.filterTags("Show Tags", tags, Collections.EMPTY_LIST);
					}
				}
		  					
			}			
		});	*/
		
		/*getViewer().addSelectionChangedListener(new ISelectionChangedListener() {
			public void selectionChanged(SelectionChangedEvent event) {
				// if the selection is empty clear the label
				if(event.getSelection().isEmpty()) {
					itemSelected = null;
					return;
				}
				if(event.getSelection() instanceof IStructuredSelection) {
					IStructuredSelection selection = (IStructuredSelection)event.getSelection();
					for (Iterator iterator = selection.iterator(); iterator.hasNext();) {
						Object o = iterator.next();
						if (o instanceof ExecutionStep)
							itemSelected = (ExecutionStep) o;
			           	}
			       	}
			   	}
			}
		);*/	
	}
	
	public ExecutionInfo getCurrentExecutionInfo() {		  
		return getExecutionInfoManager().getCurrentExecution();
	}
	
	/**
     * Disposes of this page.
     */
	public void dispose() {
		deactivate();
	}
	
	public void playStep() {	
		runtimeManager.playStep();
	}
	
	public void rrStep() {
		int size = getActiveSteps().size(); 
		if (size > 1)
			runtimeManager.rrToStep(getActiveSteps().get(size - 2));
	}
	
	public void ffStep() {
		runtimeManager.ffStep();
	}
	
	public void stopStep() {
		runtimeManager.stopStep();
	}
	
	public void pauseStep(boolean isChecked) {
		runtimeManager.pauseStep(isChecked);
	}
	
	public void rrToStep(ExecutionStep step) {
		runtimeManager.rrToStep(step);
	}
	
	/**
     * Returns the SWT control for this page.
     *
     * @return the SWT control for this page, or <code>null</code> if this
     *   page does not have a control
     */
	public Control getControl() {
		return getViewer().getControl();
	} 

	public void setActionBars(IActionBars actionBars) {
		//Do nothing
	}
	
	 /**
     * Asks this page to take focus within its pagebook view.
     */
	public void setFocus() {
		getViewer().getControl().setFocus();
	}
	
	public IPageSite getSite(){
		return site;
	}
 
	public void init(IPageSite site) {
		this.site = site;
	}
	
	protected void addNewStep(ExecutionStep step) {
		getViewer().refresh();
	}
	
	protected void removeStep(ExecutionStep step) {
		getViewer().refresh();
	}
	
	private void changeExecutionInfo() {
		getViewer().getTree().removeAll();
		getViewer().setInput(getCurrentExecutionInfo());
	}	
	
	@SuppressWarnings("deprecation") //$NON-NLS-1$
	public List<ExecutionStep> getActiveSteps() {
		return getCurrentExecutionInfo().getExecutionSteps();
	}
	
	/*
     * Adapter Implementation
     */    
	public Notifier getTarget() {
		return target;
	}
	
	public void setTarget(Notifier newTarget) {
		target = newTarget;
	}
	
	public boolean isAdapterForType(Object type) {
		return getExecutionInfoManager() == type;
	}
	
	public void internalNotifyChanged(Notification notification) {
		if (notification.getNotifier() instanceof ExecutionInfo) {
			switch (notification.getEventType()) {
			case Notification.ADD: {
				ExecutionStep newStep = (ExecutionStep)notification.getNewValue();
				if (newStep.getEnabled() == ExecutionContext.enabled_Step)
					addNewStep(newStep);
				break;
			}
			case Notification.REMOVE: {
				ExecutionStep oldStep = (ExecutionStep)notification.getOldValue();
				if (oldStep.getEnabled() == ExecutionContext.enabled_Step)
					removeStep((ExecutionStep)notification.getOldValue());
				break;
			}
			case ExecutionmodelPackage.EXECUTION_INFO__RESET:
				if (notification.getEventType() == Notification.SET) {
					changeExecutionInfo();
				}
				break;
		}
		} else
			if (notification.getEventType() == Notification.SET)
				switch (notification.getFeatureID(ExecutionmodelPackage.class)) {
					case ExecutionmodelPackage.EXECUTION_INFO_MANAGER__CURRENT_EXECUTION:						
						changeExecutionInfo();
						break;
				}
	}
	
	public void notifyChanged(final Notification notification) {
		Workbench.getInstance().getDisplay().syncExec(
				new Runnable() {
					public void run(){
						internalNotifyChanged(notification);
					}
				}
		);		
	}
}