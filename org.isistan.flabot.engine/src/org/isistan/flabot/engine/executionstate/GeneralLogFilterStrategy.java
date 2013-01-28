/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.isistan.flabot.engine.executionstate;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>General Log Filter Strategy</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.isistan.flabot.engine.executionstate.ExecutionstatePackage#getGeneralLogFilterStrategy()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface GeneralLogFilterStrategy extends EObject{

	String getPrologCode();
	
	void resetProlog();

} // GeneralLogFilterStrategy
