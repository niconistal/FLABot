/* $Id: EvaluatePostOrJoinCommand.java,v 1.8 2006/04/04 03:29:51 franco Exp $
 */

package org.isistan.flabot.engine.commands;

import java.io.IOException;
import java.util.Hashtable;

import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.internal.Workbench;
import org.isistan.flabot.coremodel.ResponsibilityNode;
import org.isistan.flabot.coremodel.SimplePathNode;
import org.isistan.flabot.coremodel.StubNode;
import org.isistan.flabot.engine.RuntimeManager;
import org.isistan.flabot.engine.dialogs.JoinOrSetStateDialog;
import org.isistan.flabot.engine.executionstate.ExecutionState;
import org.isistan.flabot.executionmodel.ExecutionContext;

import JavaLog.PlException;
import JavaLog.PlList;

/**
 * @author $Author: franco $
 */

public class EvaluatePostOrJoinCommand extends Command{
	
	private RuntimeManager runtimeManager;
	
	public EvaluatePostOrJoinCommand(RuntimeManager runtimeManager) {
		this.name = "'EVALUATE_POST_JOIN_OR'";
		this.runtimeManager = runtimeManager;
	}
	
	@Override
	public void execute(ExecutionContext context) throws PlException, IOException{
		context.setEnabled(ExecutionContext.enabled_Step);
		String query = "retractRule(evaluateCommand("+String.valueOf(Integer.parseInt(context.getCurrentStep())+1)+","+context.getPreResponsibility().getID()+")).";
		runtimeManager.getJavaLogEngine().executeQuery(query);
		query = "retractRule(evaluatingJoin("+context.getPreResponsibility().getID()+")).";
		runtimeManager.getJavaLogEngine().executeQuery(query);
		
		Hashtable stateByResponsibility = new Hashtable();
		for (int i=0; i < context.getPreResponsibility().uGetPrevious().size(); i++){
			SimplePathNode previousNode = getPrevious((SimplePathNode)context.getPreResponsibility().uGetPrevious().get(i));
			if (previousNode!=null){
				query = "responsibilityLog("+previousNode.getID()+",Instance,Component,Event,CurrentScenario,ExecutionInfo,"+ String.valueOf(Integer.parseInt(context.getCurrentStep())+1)+").";
				Object state = runtimeManager.getJavaLogEngine().executeQuery(query,"ExecutionInfo");
				stateByResponsibility.put(previousNode,state.toString());
			}
		}
		
		GetStateRunnable getStateRunnable = new GetStateRunnable(context.getPreResponsibility(),getPrevious((SimplePathNode)context.getPreResponsibility().uGetPrevious().get(0)),getPrevious((SimplePathNode)context.getPreResponsibility().uGetPrevious().get(1)),stateByResponsibility);
		Workbench.getInstance().getDisplay().syncExec(getStateRunnable);
		ExecutionState state = getStateRunnable.getExecutionState();
		SimplePathNode branchSelection = getStateRunnable.getBranchSelection();
		
		if (branchSelection!=null)
			context.getBranchJoin().put(String.valueOf(Integer.parseInt(context.getCurrentStep())+1),branchSelection.getID());
		query = "assertRule(responsibilityLog("+context.getPreResponsibility().getID()+",Instance,Component,Event,Scenario,'"+state.getName()+"',"+context.getCurrentStep()+")).";
		runtimeManager.getJavaLogEngine().executeQuery(query);
		
		context.setCurrentResponsibility(context.getResponsibilityToJoin());
		context.setPreResponsibility(context.getPreResponsibilityToJoin());
		
		query = "evaluateDependencies("+context.getCurrentFamily()+","+context.getCurrentResponsibility().getID()+","+context.getCurrentResponsibility().getMap().getID()+","+context.getCurrentResponsibility().getMap().getID()+",Event,Result,"+context.getCurrentStep()+").";
        PlList resultFinal = (PlList)runtimeManager.getJavaLogEngine().executeQuery(query,"Result");
        context.setCurrentDependency(resultFinal.toString());
		context.setDependencies(resultFinal.toString());
		putPrologSentence(context);		
	}
	
	public SimplePathNode getPrevious (SimplePathNode node){
		if (node instanceof ResponsibilityNode || node instanceof StubNode){
			return (node);
		}	
		else
			if (node.uGetPrevious().size() > 0){
				return getPrevious ((SimplePathNode)node.uGetPrevious().get(0));
			}
			else {
				return null;
			}
	}

	@Override
	public void putPrologSentence(ExecutionContext context) throws PlException, IOException{
		String query = "assertRule(evaluateCommand("+context.getCurrentStep()+","+context.getCurrentResponsibility().getID()+")).";
		runtimeManager.getJavaLogEngine().executeQuery(query);
	}
	
	private class GetStateRunnable implements Runnable {
		private SimplePathNode node;
		private ExecutionState executionState;
		private SimplePathNode node1;
		private SimplePathNode node2;
		private SimplePathNode branchSelection;
		private Hashtable stateByResponsibility;
		
		public GetStateRunnable(SimplePathNode node, SimplePathNode node1, SimplePathNode node2, Hashtable stateByResponsibility) {
			this.node = node;
			this.node1 = node1;
			this.node2 = node2;
			this.stateByResponsibility = stateByResponsibility;
		}
		
		public void run() {
			JoinOrSetStateDialog aDialog  = new JoinOrSetStateDialog(new Shell());
			ExecutionState executionStateName = aDialog.getExecutionInfo(node,node1,node2,stateByResponsibility);
			executionState = ExecutionState.get(executionStateName.getName());
			branchSelection = aDialog.getBranchSelection();
		}
		
		public ExecutionState getExecutionState() {
			return executionState;
		}
		
		public SimplePathNode getBranchSelection (){
			return branchSelection;
		}
		
	}
}