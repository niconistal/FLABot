/**
 * $Id: RuntimeManager.java,v 1.59 2006/04/13 01:56:53 apersson Exp $
 * 
 */

package org.isistan.flabot.engine;

import java.io.IOException;
import java.util.Hashtable;
import java.util.List;
import java.util.Vector;

import org.eclipse.emf.common.util.EList;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.internal.Workbench;
import org.isistan.flabot.coremodel.ComponentRole;
import org.isistan.flabot.coremodel.CoreModel;
import org.isistan.flabot.coremodel.ResponsibilityNode;
import org.isistan.flabot.coremodel.SimplePathNode;
import org.isistan.flabot.engine.dialogs.ResultFaultLocatorEngineDialog;
import org.isistan.flabot.engine.executionstate.Diagnostic;
import org.isistan.flabot.engine.executionstate.ExecutionState;
import org.isistan.flabot.engine.failurelocatedaction.FailureLocatedAction;
import org.isistan.flabot.engine.failurelocatedaction.FailureLocatedActionLoader;
import org.isistan.flabot.executionmodel.ExecutionContext;
import org.isistan.flabot.executionmodel.ExecutionInfo;
import org.isistan.flabot.executionmodel.ExecutionInfoManager;
import org.isistan.flabot.executionmodel.ExecutionStep;
import org.isistan.flabot.executionmodel.ExecutionmodelFactory;
import org.isistan.flabot.util.plugin.PluginUtils;
import org.isistan.flabot.util.problems.DefaultMessage;
import org.isistan.flabot.util.problems.MessageAccumulator;
import org.isistan.flabot.util.problems.MessageSeverity;
import org.isistan.flabot.util.problems.log.LoggerMessageAccumulator;

import JavaLog.Brain;
import JavaLog.PlAtom;
import JavaLog.PlException;
import JavaLog.PlList;
import JavaLog.PlObject;
import JavaLog.PlStructArgs;

/**
 * @author $Author: apersson $
 *
 */

 public class RuntimeManager extends Thread{
    //--Constants
    public static final String PrologFilename = PluginUtils.getPluginFolder(EnginePlugin.getDefault()) + "resource/LocatorMethod-Improved.pl";
    public static final String LogicModuleGeneral = PluginUtils.getPluginFolder(EnginePlugin.getDefault()) + "resource/LogicModuleGeneral.pl";
    public static final String LogicModuleConstraint = PluginUtils.getPluginFolder(EnginePlugin.getDefault()) + "resource/LogicModuleConstraint.pl";
    public static final String LogicModuleStub = PluginUtils.getPluginFolder(EnginePlugin.getDefault()) + "resource/LogicModuleStub.pl";

	private ExecutionInfo currentExecutionInfo; 
	private JavaLogEngine javaLogEngine;
	private Loader loader;
	private SystemFactory systemFactory;
	private Hashtable javaRuntimeToStep = new Hashtable();
	private ExecutionStep currentStep;
	private boolean ready = false;
	private boolean stepByStep = false;
	private boolean execute;
	private boolean stopExecution;
	private boolean active = true;
	private boolean activeToControl = true;
	
	private ExecutionInfoManager executionInfoManager;
	
    public void setExecutionInfo(ExecutionInfo currentExecutionInfo){
    	this.currentExecutionInfo = currentExecutionInfo;
    }
    
    public RuntimeManager(JavaLogEngine javaLogEngine,
    		Loader loader, SystemFactory systemFactory, ExecutionInfoManager executionInfoManager) throws IOException, PlException {
    	this.javaLogEngine = javaLogEngine;
    	this.loader = loader;
    	this.systemFactory = systemFactory;
    	this.executionInfoManager = executionInfoManager;
    	resetJavalog();
    }
       
    public synchronized void activedJavaRuntime (){
    	synchronized(this){
    		this.notify();
    	}
    }
    
    protected ExecutionInfoManager getExecutionInfoManager() {
    	return executionInfoManager;
    }
    
    @Override
    public void run(){
    	while(true){
    		active = false;
    		ExecutionStep step = (ExecutionStep)currentExecutionInfo.getExecutionSteps().get(0);
    		ExecutionContext context = step.getExecutionContext();
          	String query = "runnedOK("+step.getExecutionContext().getCurrentResponsibility().getID()+","+step.getExecutionContext().getCurrentResponsibility().getID()+",Component,"+step.getExecutionContext().getEvent()+","+step.getExecutionContext().getCurrentFamily()+","+step.getExecutionContext().getCurrentResponsibility().getMap().getID()+","+step.getExecutionContext().getCurrentResponsibility().getMap().getID()+",ExecutionInfo,"+step.getExecutionContext().getCurrentStep()+",previous).";
    		Object stateFirstNode = "'NotExecuted'";
    		try {
    			javaLogEngine.setStateLogicModule(context.getPrologKnowledge(),false);
				javaLogEngine.executeQuery(query);
				activeToControl = false;
				query = "responsibilityLog("+context.getCurrentResponsibility().getID()+",Instance,Component,Event,CurrentScenario,ExecutionInfo,"+ context.getCurrentStep()+").";
				stateFirstNode =  javaLogEngine.executeQuery(query,"ExecutionInfo");
				activeToControl = true;
			} catch (Exception e1) {
				 EnginePlugin.getDefault().getLogger().error(
		  					"Error in the execution of Fault Locator: {}\n",e1);
			}   		
    		ready=true; 
       		execute = true;
       		stopExecution=false;
    		if (!stateFirstNode.toString().equals("'Executed'")){
    			this.runSteps();
    		}
    		else{
    			query = "getInstance("+step.getExecutionContext().getCurrentResponsibility().getID()+",Family,Instance).";
    			try {
    				Object instance = javaLogEngine.executeQuery(query,"Instance");
        			query = "assertRule(faultyComponent("+step.getExecutionContext().getCurrentResponsibility().getID()+","+instance.toString()+",state(Family,"+stateFirstNode.toString()+",current))).";
    				javaLogEngine.executeQuery(query);
    				currentExecutionInfo.getExecutionSteps().remove(step);
				} catch (PlException e) {
					 EnginePlugin.getDefault().getLogger().error(
			  					"Error in the execution of Fault Locator: {}\n",e);
				}
    		}		
	       	if (!stopExecution){
	       		try{
	       			showResult();
	       		}
	       		catch (Exception e){
	       		 EnginePlugin.getDefault().getLogger().error(
	   					"Error in the execution of Fault Locator: {}\n",e);
	       		}
	       	}
		    execute = false;
		    active = true;
		    while (!execute){
		    	try {
		    		Thread.sleep(10);		
		    	} catch (InterruptedException e) {
					e.printStackTrace();
				}
		    }
	    }
    }
    
    
    public synchronized void runSteps (){
        try {
          while(currentExecutionInfo.getExecutionSteps().size()>0){
        	      currentStep = (ExecutionStep) currentExecutionInfo.getExecutionSteps().get(currentExecutionInfo.getExecutionSteps().size()-1);
	        	  EList steps = currentExecutionInfo.getExecutionSteps();
	              ExecutionContext context = currentStep.getExecutionContext();
	              JavaRuntime currentJavaRuntime;
	              if (context.getStopStep().equals("RUN")){
	            	  currentJavaRuntime = new JavaRuntime(context.getResponsibilityToExecute(),Integer.parseInt(context.getCurrentStep()),context.getCurrentFamily(),context, javaLogEngine, this, loader);
	              }
	              else{
	            	  context.setStopStep("RUN");
	            	  context.setResponsibilityToExecute(context.getPreResponsibility());
	            	  currentJavaRuntime = new JavaRuntime(context.getCurrentResponsibility(),Integer.parseInt(context.getCurrentStep()),context.getCurrentFamily(),context, javaLogEngine, this, loader);
	              }
	              javaRuntimeToStep.put(currentStep,currentJavaRuntime);  
		  	      synchronized(this){
		  	    	  if (stepByStep && currentJavaRuntime.acceptStepByStep()){
		  	    		  this.wait();       		  
		  	    	  }
		  	      }
		  	     if (execute){
		  	    	  activeToControl = false;
	        	      currentJavaRuntime.run();
	        	      activeToControl = true;
			  	      if (!currentJavaRuntime.stopStep&&context.getStopStep().equals("RUN")){
				  	     // currentStep.getExecutionContext().setPrologKnowledge(javaLogEngine.getStateLogicModule());
				  	      currentStep.setFinalState(getFinalState(currentStep.getTarget()));
				  	      steps.remove(currentStep);
			  	      }    
		  	     }
          	}
        }
        catch (Exception e){
      	  EnginePlugin.getDefault().getLogger().error(
  					"Error in the execution of Fault Locator: {}\n",e);
        }
        
      }
    
    
    private ExecutionState getFinalState(SimplePathNode target) throws PlException {
    	String query = "faultyComponent("+target.getID()+",Instance,State).";
    	PlStructArgs state = (PlStructArgs) javaLogEngine.executeQuery(query,"State");
    	if (state!=null){
    		String auxState = state.argument(1).toString().substring(1, state.argument(1).toString().length() - 1);
    		return ExecutionState.get(auxState);
    	}
    	return null;
	}

	/**
	 * Add a new Execution Step at current Execution Information
	 * @param ExecutionContext
	 */ 
    
    public void addExecutionStep(ExecutionContext context){
    	
    	try {
			context.setPrologKnowledge(javaLogEngine.getStateLogicModule());
			setInstanceComponent(context);
		} catch (Exception e) {
			EnginePlugin.getDefault().getLogger().error(
					"Error adding a new Step in the execution of Fault Locator: {}\n",e);
		}
		
		getExecutionInfoManager().getCurrentExecution().addExecutionStep(context, (Diagnostic)loader.getDiagnosticByResponsibility().get(context.getCurrentResponsibility().getID()), (Diagnostic)loader.getDiagnosticByResponsibility().get(context.getPreResponsibility().getID()));
		setExecutionInfo(getExecutionInfoManager().getCurrentExecution());
	}
    
    private void setInstanceComponent(ExecutionContext context) throws PlException {
    	String query = "existsCurrentFamily(Family).";
		PlAtom family = (PlAtom)javaLogEngine.executeQuery(query,"Family");
		if (family!=null){
			query = "responsibilityOption("+context.getPreResponsibility().getID()+",ComponentType,CurrentScenario).";
			PlAtom component = (PlAtom)javaLogEngine.executeQuery(query,"ComponentType");
			if (context.getFamily().equals("Family")){
				query = "family("+family.toString()+",Instance,"+component.toString()+",CurrentScenario).";
				PlAtom instance = (PlAtom)javaLogEngine.executeQuery(query,"Instance");
				context.setInstanceComponentToTarget((ComponentRole)loader.getComponentsByID().get(instance.toString()));
			}
			else{
				query = "getComponentFamily("+family+","+context.getFamily()+","+component.toString()+", Instance).";
				PlAtom instance = (PlAtom)javaLogEngine.executeQuery(query,"Instance");
				if (instance!=null){
					context.setInstanceComponentToTarget((ComponentRole)loader.getComponentsByID().get(instance.toString()));
				}
				else{
					context.setInstanceComponentToTarget(null);
				}
			}	
			query = "responsibilityOption("+context.getCurrentResponsibility().getID()+",ComponentType,CurrentScenario).";
			component = (PlAtom)javaLogEngine.executeQuery(query,"ComponentType");
			if (context.getFamily().equals("Family")){
				query = "family("+family.toString()+",Instance,"+component.toString()+",CurrentScenario).";
				PlAtom instance = (PlAtom)javaLogEngine.executeQuery(query,"Instance");
				context.setInstanceComponentToSource((ComponentRole)loader.getComponentsByID().get(instance.toString()));
			}
			else{
				query = "getComponentFamily("+family+","+context.getFamily()+","+component+",Instance).";
				PlAtom instance = (PlAtom)javaLogEngine.executeQuery(query,"Instance");
				if (instance!=null)
					context.setInstanceComponentToSource((ComponentRole)loader.getComponentsByID().get(instance.toString()));
			}	
		}
		else{
			context.setInstanceComponentToSource(null);
			context.setInstanceComponentToTarget(null);
		}
	}
    
    public void addFirstExecutionStep(ExecutionContext context){  	
    	try {
			context.setPrologKnowledge(javaLogEngine.getStateLogicModule());
		} catch (Exception e) {
			EnginePlugin.getDefault().getLogger().error(
					"Error adding a new Step in the execution of Fault Locator: {}\n",e);
		}
		getExecutionInfoManager().getCurrentExecution().addExecutionStep(context,null,null);
		setExecutionInfo(getExecutionInfoManager().getCurrentExecution());
	}

	/**
	 * Add a a new Execution Information
	 * @param responsibilityNode
	 * @param Model
	 */
    
    public void addExecutionInfo(ResponsibilityNode responsibility,CoreModel coreModel){
    	try {
			loader.generatePrologCode(responsibility,coreModel);
		} catch (Exception e) {
			EnginePlugin.getDefault().getLogger().error(
					"Error adding a new Execution in Fault Locator: {}\n",e);
		}
    	ExecutionContext context = ExecutionmodelFactory.eINSTANCE.createExecutionContext();
    	context.setPreResponsibility(responsibility);
    	context.setCurrentResponsibility(responsibility);
    	context.setCurrentDependency("[]");
    	context.setDependencies("[]");
    	
    	getExecutionInfoManager().addExecution();
    	setExecutionInfo(getExecutionInfoManager().getCurrentExecution());
    	addFirstExecutionStep(context);
    }
	
    
    /**
	 * Generate the current state for each responsibility based on a execution context
	 * @throws IOException
	 * @throws PlException
	 * @return Hashtable 
	 */
    private Hashtable generatePartialResult() throws PlException, IOException{
		Hashtable stateByResponsibility = new Hashtable();
		String query = "getFinalResult(Result).";
		PlList list = (PlList)javaLogEngine.executeQuery(query,"Result");
		if (list != null) {
	        PlObject [] objects = list.toArray();
	        if (objects!=null){	        	
	        	for (int i = 0; i < objects.length; i++) {
	        		 PlStructArgs state = (PlStructArgs)((PlStructArgs) objects[i]).argument(3);
	        		Object instance = (Object)((PlStructArgs) objects[i]).argument(1);
	        		String auxState = state.argument(1).toString().substring(1, state.argument(1).toString().length() - 1);
	        		Vector respAndInstance = new Vector();
	        		respAndInstance.add(ExecutionState.get(auxState));
	        		if (loader.getComponentsByID().containsKey(instance.toString()))
	        			respAndInstance.add(loader.getComponentsByID().get(instance.toString()));
	        		else
	        			respAndInstance.add("None");
	        		stateByResponsibility.put((SimplePathNode)loader.getResponsibilitiesNodeByID().get(((PlStructArgs)objects[i]).argument(0).toString()),respAndInstance);
	        	}
	        }
        }
        return stateByResponsibility;
	}
    
    /**
	 * Reset the runtime manager
	 * @param responsibilityNode
	 * @param Model
	 * @throws IOException
	 * @throws PlException
	 */
	public void reset(CoreModel Model) throws IOException, PlException {
		if (getExecutionInfoManager().getCurrentExecution() != null)
			getExecutionInfoManager().getCurrentExecution().resetExecutionInfo();
		resetJavalog();
		loader.reset(Model);
	}

	/**
	 * @throws IOException
	 * @throws PlException
	 */
	private void resetJavalog() throws IOException, PlException {
		javaLogEngine.reset();
		Brain brain = javaLogEngine.getBrain();
        brain.call("assert(executionStateDialog($0)).",new Object[]{systemFactory});
       	String path = PrologFilename;
        System.out.println("path : "+ path);
        System.out.println("Loading prolog file ... " + brain.consult(path));   
        javaLogEngine.loadLogicModule(LogicModuleGeneral);
        javaLogEngine.loadLogicModule(LogicModuleConstraint);
        javaLogEngine.loadLogicModule(LogicModuleStub);
        javaLogEngine.changeLogicModule(LogicModuleGeneral);
	}
	
	public JavaLogEngine getJavaLogEngine(){
		return javaLogEngine;
	}
	
	public ExecutionInfo getCurrentExecutionInfo(){
		return currentExecutionInfo;
	}
	
	public Hashtable getJavaRuntimeToStep(){
		return javaRuntimeToStep;
	}
    
	public void setCurrentStep (ExecutionStep step){
		this.currentStep = step;
	}
	
	public void showResult() throws Exception{
		ResultsRunnable results= new ResultsRunnable(this);
		Workbench.getInstance().getDisplay().syncExec(results);
	}
	
	public void setExecute (boolean execute){
		this.execute = execute;
	}
	
	public boolean isExecuting (){
		return execute;
	}
	
	public void setStepByStep (boolean stepByStep){
		this.stepByStep = stepByStep;
	}
	
	public boolean getStepByStep (){
		return stepByStep;
	}
	
	public boolean getReady (){
		return ready;
	}
	
	public void stopExecution(){
		stopExecution = true;
		try {
			this.getJavaLogEngine().setStateLogicModule("",true);
		} catch (Exception e) {
			EnginePlugin.getDefault().getLogger().error(
					"Error in the execution of Fault Locator: {}\n",e);
		}
	}

	public void setActiveRuntime(boolean state) {
		this.active = state;		
	}
	
	public boolean isActive(){
		return active;
	}
	
	public void playStep() {	
		if (this.activeToControl){
			if (this.getReady()){
				if (this.getStepByStep()&&this.isExecuting()){
					this.setStepByStep(false);
					this.activedJavaRuntime();
				}
				else if (this.isExecuting()){
					this.setStepByStep(false);
					EList steps = this.getCurrentExecutionInfo().getExecutionSteps();
					executeStep((ExecutionStep)steps.get(steps.size()-1),true);
					this.setExecute(true);
				}
			}
			this.setStepByStep(false);
		}
	}
	
	public void rrStep() {
		System.out.println("RR");
	}
	
	public void ffStep() {
		if (activeToControl){
			if (this.getStepByStep() && this.isExecuting()){
				this.activedJavaRuntime();
			}
		}
	}
	
	public void stopStep() {
		if (activeToControl){
			boolean isExecuting = this.isExecuting();
			this.setStepByStep(false);
			if (this.getCurrentExecutionInfo()!=null&&this.isExecuting()){
				try {
					this.setExecute(false);
					EList steps = this.getCurrentExecutionInfo().getExecutionSteps();
					this.activedJavaRuntime();
					for (int i= steps.size()-1; i >= 0; i--){
			      	 	if (this.getJavaRuntimeToStep().get(steps.get(i))!=null)
			      	    		((JavaRuntime)this.getJavaRuntimeToStep().get(steps.get(i))).stopStep();
			      	 	if (i==0){
			      	 		this.reset(((ExecutionStep)steps.get(0)).getExecutionContext().getCurrentResponsibility().getMap().getCoreModel());
			      	 	}
			      	 	steps.remove(i);
			      	}				
				} catch (Exception e) {
					EnginePlugin.getDefault().getLogger().error(
							"Error in the execution of Fault Locator: {}\n",e);
				}
				this.stopExecution();
				
			}
		}
	}
	
	public void pauseStep(boolean isChecked) {
		if (isChecked){			
			this.setStepByStep(true);
		}
		else{
			if (this.getStepByStep()&&this.isExecuting()){
				this.setStepByStep(false);
				this.activedJavaRuntime();
			}
			else
				this.setStepByStep(false);
		}
	}
	
	public void rrToStep(ExecutionStep step) {
		if (activeToControl){
			if (this.getReady()){
				if (this.isExecuting()&&this.getStepByStep()){
					EList steps = this.getCurrentExecutionInfo().getExecutionSteps();
					int index = steps.indexOf(step);
					if (! (index == steps.size()-1)){
						executeStep(step,true);
					}
					this.activedJavaRuntime();
				}
			}
		}
	}
	
	private void executeStep(ExecutionStep step, boolean deleteNextSteps){
		EList steps = this.getCurrentExecutionInfo().getExecutionSteps();
		int index = steps.indexOf(step);
      	step.getExecutionContext().setResponsibilityToExecute(step.getExecutionContext().getCurrentResponsibility());
       	if (index-1<0){
	      	   try{
	      		   step.getExecutionContext().setPrologKnowledge("");
	      		   this.getJavaLogEngine().setStateLogicModule("",true);
	      	   }
	      	   catch(Exception e){
	      		 EnginePlugin.getDefault().getLogger().error(
	 					"Error in the execution of Fault Locator: {}\n",e);
	      	   }	  	      	   
	      	}
	      	else{
	      	   step.getExecutionContext().setPrologKnowledge(((ExecutionStep)steps.get(index-1)).getExecutionContext().getPrologKnowledge());
	      	   try {
				this.getJavaLogEngine().setStateLogicModule(step.getExecutionContext().getPrologKnowledge(),true);
	      	   } catch (Exception e) {}
	      	}
	      	for (int i=steps.size()-1; i > index; i--){
	      	 	if (this.getJavaRuntimeToStep().get(steps.get(i))!=null)
	      	    		((JavaRuntime)this.getJavaRuntimeToStep().get(steps.get(i))).stopStep();
	      	}
	      	this.currentExecutionInfo.backToStep(step);
	      	this.getJavaLogEngine().changeLogicModule(step.getExecutionContext().getCurrentLogicModule());
	      	this.setCurrentStep(step);
	}
	
	private class ResultsRunnable implements Runnable {
		private RuntimeManager manager;

		public ResultsRunnable(RuntimeManager manager) {
			this.manager = manager;
		}

		public void run() {
			MessageAccumulator messageAccumulator=new LoggerMessageAccumulator();
			boolean failureLocatedActionsAvailable=FailureLocatedActionLoader.areFailureLocatedActions();
	       	ResultFaultLocatorEngineDialog dialog = new ResultFaultLocatorEngineDialog(new Shell(),failureLocatedActionsAvailable);
	       	
			try {
				dialog.open(manager.generatePartialResult());
			} catch (PlException e) {
				messageAccumulator.addMessage(new DefaultMessage(
						EnginePlugin.getDefault(), EnginePlugin.SYMBOLIC_NAME,
						MessageSeverity.ERROR, "Prolog exception",
						"An exception occured in prolog.",
						e));
				return;
			} catch (IOException e) {
				messageAccumulator.addMessage(new DefaultMessage(
						EnginePlugin.getDefault(), EnginePlugin.SYMBOLIC_NAME,
						MessageSeverity.ERROR, "IOException",
						"An io exception occured.",
						e));
				return;
			}
			
			if (dialog.isTreatFailure()){
				FailureLocatedAction[] failureLocatedActions=
					FailureLocatedActionLoader.getUserSelectedFailureLocatedActions(new Shell(), messageAccumulator);
				List<Vector> list = dialog.getResponsibilitieNodes();
				for (FailureLocatedAction failureLocatedAction : failureLocatedActions) {
					for (Vector node : list) {
						failureLocatedAction.execute((ResponsibilityNode)node.get(0), (ComponentRole)node.get(1), messageAccumulator);					}
				}

			}
		}
	}
	
}
