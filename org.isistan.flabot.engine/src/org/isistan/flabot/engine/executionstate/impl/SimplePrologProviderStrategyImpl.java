/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.isistan.flabot.engine.executionstate.impl;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.isistan.flabot.coremodel.ConditionEvent;
import org.isistan.flabot.engine.executionstate.ExecutionstatePackage;
import org.isistan.flabot.engine.executionstate.SimplePrologProviderStrategy;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Simple Prolog Provider Strategy</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class SimplePrologProviderStrategyImpl extends EObjectImpl implements SimplePrologProviderStrategy {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SimplePrologProviderStrategyImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return ExecutionstatePackage.eINSTANCE.getSimplePrologProviderStrategy();
	}

	public String getPrologCode(ConditionEvent conditionEvent) {
		if (conditionEvent != null)
		{
			return conditionEvent.getConditionEvent();
		}

		return "";
	}
	
	public void resetProlog()
	{
		//Do nothing
	}

} //SimplePrologProviderStrategyImpl
