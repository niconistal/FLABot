/** * $Id: ExecutionInfo.java,v 1.8 2006/03/29 00:55:37 franco Exp $ * $Author: franco $ */package org.isistan.flabot.executionmodel;


import org.eclipse.emf.common.util.EList;import org.eclipse.emf.ecore.EObject;import org.isistan.flabot.engine.executionstate.Diagnostic;/**
 * @model
 */

public interface ExecutionInfo extends EObject {
	
	/**
	 * @model type="ExecutionStep" containment="true"
	 * @deprecated
	 */
	@Deprecated	EList getExecutionSteps();
		int getStepsCount();	
	ExecutionStep addExecutionStep(ExecutionContext context, Diagnostic diagnosticToSource, Diagnostic DiagnosticToTarget);		void backToStep(ExecutionStep step);		void startEvaluatingNode(EvaluationStep step);		void finishEvaluatingNode(EvaluationStep step);		void resetExecutionInfo();
}
