/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.isistan.flabot.engine.executionstate;

import org.eclipse.emf.ecore.EObject;
import org.isistan.flabot.coremodel.ConditionEvent;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Prolog Provider Strategy</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.isistan.flabot.engine.executionstate.ExecutionstatePackage#getPrologProviderStrategy()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface PrologProviderStrategy extends EObject {
	
	String getPrologCode(ConditionEvent conditionEvent);
	
	void resetProlog();
	
} // PrologProviderStrategy
