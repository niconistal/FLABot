/** * $Id: ExecutionmodelFactory.java,v 1.3 2006/03/17 00:28:33 franco Exp $ * $Author: franco $ */package org.isistan.flabot.executionmodel;


import org.eclipse.emf.ecore.EFactory;public interface ExecutionmodelFactory extends EFactory{

	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
	 * @generated
	 */
	ExecutionmodelFactory eINSTANCE = new org.isistan.flabot.executionmodel.impl.ExecutionmodelFactoryImpl();

	/**
	 * Returns a new object of class '<em>Execution Info</em>'.
	 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Execution Info</em>'.
	 * @generated
	 */
	ExecutionInfo createExecutionInfo();

	/**
	 * Returns a new object of class '<em>Execution Info Manager</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Execution Info Manager</em>'.
	 * @generated
	 */
	ExecutionInfoManager createExecutionInfoManager();

	/**
	 * Returns a new object of class '<em>Execution Step</em>'.
	 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Execution Step</em>'.
	 * @generated
	 */
	ExecutionStep createExecutionStep();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	ExecutionmodelPackage getExecutionmodelPackage();

	/**
	 * Returns a new object of class '<em>Dependency</em>'.
	 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Dependency</em>'.
	 * @generated
	 */
	Dependency createDependency();

	/**
	 * Returns a new object of class '<em>Execution Context</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Execution Context</em>'.
	 * @generated
	 */
	ExecutionContext createExecutionContext();

	/**
	 * Returns a new object of class '<em>Evaluation Step</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Evaluation Step</em>'.
	 * @generated
	 */
	EvaluationStep createEvaluationStep();

}
